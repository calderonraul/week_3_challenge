package com.example.week3challenge.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PostsViewModel : ViewModel() {
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the request status String
    val response: LiveData<String>
        get() = _response

    init {
        getPosts()
    }

    private fun getPosts() {
        _response.value = "Set the Mars API Response here!"
    }
}