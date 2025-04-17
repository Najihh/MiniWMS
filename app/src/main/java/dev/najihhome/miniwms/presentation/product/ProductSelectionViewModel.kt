package dev.najihhome.miniwms.presentation.productselection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.najihhome.miniwms.data.model.Product
import dev.najihhome.miniwms.domain.usecase.GetProductDetailUseCase
import dev.najihhome.miniwms.domain.usecase.GetProductsUseCase
import dev.najihhome.miniwms.presentation.utils.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductSelectionViewModel(
    private val getProductsUseCase: GetProductsUseCase,
    private val getProductDetailUseCase: GetProductDetailUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<ProductSelectionUiState>(
        ProductSelectionUiState.Initial
    )
    val uiState: StateFlow<ProductSelectionUiState> = _uiState

    private var currentProducts = emptyList<Product>()

    init {
        loadProducts()
    }

    fun loadProducts() {
        viewModelScope.launch {
            _uiState.value = ProductSelectionUiState.Loading()

            getProductsUseCase().collect { result ->
                when (result) {
                    is Result.Success -> {
                        result.data?.let {
                            currentProducts = it
                            _uiState.value = ProductSelectionUiState.ProductsLoaded(it)
                        } ?: run {
                            _uiState.value = ProductSelectionUiState.Error("No products found")
                        }
                    }

                    is Result.Error -> {
                        _uiState.value = ProductSelectionUiState.Error(
                            result.message ?: "Unknown error",
                            result.data
                        )
                    }

                    is Result.Loading -> {
                        result.data?.let {
                            currentProducts = it
                            _uiState.value = ProductSelectionUiState.Loading(it)
                        } ?: run {
                            _uiState.value = ProductSelectionUiState.Loading()
                        }
                    }
                }
            }
        }
    }
}

sealed class ProductSelectionUiState {
    data object Initial : ProductSelectionUiState()
    data class Loading(val data: List<Product> = emptyList()) : ProductSelectionUiState()
    data class ProductsLoaded(val products: List<Product>) : ProductSelectionUiState()
    data class Error(val message: String, val data: List<Product>? = null) :
        ProductSelectionUiState()
}