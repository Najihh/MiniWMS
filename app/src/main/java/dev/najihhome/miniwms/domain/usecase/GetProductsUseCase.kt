package dev.najihhome.miniwms.domain.usecase

import dev.najihhome.miniwms.data.model.Product
import dev.najihhome.miniwms.domain.repository.ProductRepository
import dev.najihhome.miniwms.presentation.utils.Result
import kotlinx.coroutines.flow.Flow

class GetProductsUseCase(private val repository: ProductRepository) {
    suspend operator fun invoke(): Flow<Result<List<Product>>> {
        return repository.getProducts()
    }
}