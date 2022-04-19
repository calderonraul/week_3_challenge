package com.example.week3challenge.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.week3challenge.networking.PostsApi
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback

class PostsViewModel : ViewModel() {
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the request status String
    val response: LiveData<String>
        get() = _response

    init {
        getPosts()
    }

    private fun getPosts() {
        PostsApi.retrofitService.getProperties().enqueue(object: Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                _response.value = response.body()
            }
        })
    }
}