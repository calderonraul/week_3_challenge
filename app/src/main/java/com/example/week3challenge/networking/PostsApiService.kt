package com.example.week3challenge.networking

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()



interface PostsApiService {

    @GET("posts")
    fun getProperties(): Call<String>
}
object PostsApi {
    val retrofitService : PostsApiService by lazy { retrofit.create(PostsApiService::class.java) }
}