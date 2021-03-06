package com.example.week3challenge.networking

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface PostsApiService {

    @GET("posts")
    suspend fun getPosts(): List<Posts>

    @GET("comments")
    suspend fun getPostDetail(@Query("postId") id: Int?): List<Comments>


}

object PostsApi {
    val retrofitService: PostsApiService by lazy { retrofit.create(PostsApiService::class.java) }
}