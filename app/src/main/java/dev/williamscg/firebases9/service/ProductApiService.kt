package dev.williamscg.firebases9.service

import dev.williamscg.firebases9.model.ProductApiModel
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ProductApiService {

    @GET("products")
    fun getProducts(): Call<List<ProductApiModel>>

    @GET("products/{id}")
    fun getProductById(@Path("id") id: Int): Call<ProductApiModel>

    //Create POST products
    @POST("products")
    fun createProduct(product: ProductApiModel): Call<ProductApiModel>

    //Create PUT products
    @PUT("products/{id}")
    fun updateProduct(@Path("id") id: Int, product: ProductApiModel): Call<ProductApiModel>

    //Create DELETE products
    @DELETE("products/{id}")
    fun deleteProduct(@Path("id") id: Int): Call<Void>
}