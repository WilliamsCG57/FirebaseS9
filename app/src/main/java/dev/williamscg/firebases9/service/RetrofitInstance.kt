package dev.williamscg.firebases9.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val TOKEN ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjQsImlhdCI6MTczMDU2NjU0NCwiZXhwIjoxNzMwNjUyOTQ0fQ.VZQb9T7ncqRqJIZC9AW9gwBtN3BSBd82qqMd4uCoU0g"
    private val BASE_URL = "https://cf1d-38-253-147-39.ngrok-free.app/node-api/"
    private val client = OkHttpClient
                        .Builder()
                        .addInterceptor(AuthInterceptor(TOKEN))
                        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    val api: ProductApiService by lazy {
        retrofit.create(ProductApiService::class.java)
    }

}