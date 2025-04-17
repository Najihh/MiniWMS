package dev.najihhome.miniwms.data.api

import dev.najihhome.miniwms.data.model.ApiResponse
import dev.najihhome.miniwms.data.model.Product
import dev.najihhome.miniwms.data.model.ProductDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("v1/product/filter?key=name")
    suspend fun getProducts(): Response<ApiResponse<List<Product>>>

    @GET("v1/item/rfid/product/{productId}")
    suspend fun getProductDetail(
        @Path("idProduct") idProduct: Int
    ): Response<ApiResponse<ProductDetail>>
}