package dev.najihhome.miniwms.data.repository

import android.content.Context
import dev.najihhome.miniwms.data.api.RetrofitInstance
import dev.najihhome.miniwms.data.model.Product
import dev.najihhome.miniwms.data.model.ProductDetail
import dev.najihhome.miniwms.domain.repository.ProductRepository
import dev.najihhome.miniwms.presentation.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class ProductRepositoryImpl : ProductRepository {

    private val apiService = RetrofitInstance.apiService

    override suspend fun getProducts(): Flow<Result<List<Product>>> = flow {
        emit(Result.Loading())
        try {
            val response = apiService.getProducts()
            if (response.isSuccessful) {
                response.body()?.let { products ->
                    val productEntities = products.data
                    emit(Result.Success(productEntities))
                } ?: emit(Result.Error("Empty response body"))
            } else {
                emit(Result.Error("Error fetching products: ${response.code()}"))
            }
        } catch (e: HttpException) {
            emit(Result.Error("Network error: ${e.message}"))
        } catch (e: IOException) {
            emit(Result.Error("IO error: ${e.message}"))
        } catch (e: Exception) {
            emit(Result.Error("Unknown error: ${e.message}"))
        }
    }

    override suspend fun getProductDetail(productId: Int): Flow<Result<ProductDetail>> = flow {
        emit(Result.Loading())
        try {
            val response = apiService.getProductDetail(productId)
            if (response.isSuccessful) {
                response.body()?.let { productDetail ->
                    emit(Result.Success(productDetail.data))
                } ?: emit(Result.Error("Empty response body"))
            } else {
                emit(Result.Error("Error fetching product details: ${response.code()}"))
            }
        } catch (e: HttpException) {
            emit(Result.Error("Network error: ${e.message}"))
        } catch (e: IOException) {
            emit(Result.Error("IO error: ${e.message}"))
        } catch (e: Exception) {
            emit(Result.Error("Unknown error: ${e.message}"))
        }
    }
}