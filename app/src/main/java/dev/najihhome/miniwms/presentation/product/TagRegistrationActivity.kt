package dev.najihhome.miniwms.presentation.product

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import dev.najihhome.miniwms.R
import dev.najihhome.miniwms.presentation.productselection.ProductSelectionUiState
import dev.najihhome.miniwms.presentation.productselection.ProductSelectionViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class TagRegistrationActivity : AppCompatActivity() {

    private val viewModel: ProductSelectionViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        observeViewModel()
        viewModel.loadProducts()
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.uiState.collect { state ->
                when (state) {
                    is ProductSelectionUiState.Initial -> {

                    }

                    is ProductSelectionUiState.Loading -> {
                        Toast.makeText(
                            this@TagRegistrationActivity,
                            "loading",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    is ProductSelectionUiState.ProductsLoaded -> {
                        Toast.makeText(
                            this@TagRegistrationActivity,
                            "total data: ${state.products.size}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    is ProductSelectionUiState.Error -> {
                        Toast.makeText(
                            this@TagRegistrationActivity,
                            "error ${state.message}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}