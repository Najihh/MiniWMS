package dev.najihhome.miniwms.domain.repository

import dev.najihhome.miniwms.data.model.Product
import dev.najihhome.miniwms.data.model.ProductDetail
import dev.najihhome.miniwms.presentation.utils.Result
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProducts(): Flow<Result<List<Product>>>
    suspend fun getProductDetail(productId: Int): Flow<Result<ProductDetail>>
}