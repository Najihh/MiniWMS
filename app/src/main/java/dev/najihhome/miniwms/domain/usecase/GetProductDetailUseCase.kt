package dev.najihhome.miniwms.domain.usecase

import dev.najihhome.miniwms.data.model.ProductDetail
import dev.najihhome.miniwms.domain.repository.ProductRepository
import dev.najihhome.miniwms.presentation.utils.Result
import kotlinx.coroutines.flow.Flow

class GetProductDetailUseCase(private val repository: ProductRepository) {
    suspend operator fun invoke(productId: Int): Flow<Result<ProductDetail>> {
        return repository.getProductDetail(productId)
    }
}