package com.example.week3challenge.posts

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week3challenge.networking.Posts
import com.example.week3challenge.networking.PostsApi
import kotlinx.coroutines.launch

class   PostsViewModel : ViewModel() {
    // The internal MutableLiveData String that stores the most recent response status
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the status String
    val status: LiveData<String>
        get() = _status

    // Internally, we use a MutableLiveData, because we will be updating the MarsProperty with
    // new values
    private val _postinfo = MutableLiveData<List<Posts>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val posties: LiveData<List<Posts>>
        get() = _postinfo

    private val _navigateToSelectedPost = MutableLiveData<Posts>()

    // The external immutable LiveData for the navigation property
    val navigateToSelectedPost: LiveData<Posts>
        get() = _navigateToSelectedPost


    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            try {
                val listResult = PostsApi.retrofitService.getPosts()
                Log.wtf("ravn",listResult.toString())
                _status.value = "Success: ${listResult.size} posts retrieved"
                if (listResult.isNotEmpty()) {
                    _postinfo.value = listResult
                }
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
                Log.wtf("ravn",e.message)
            }
        }
    }



    fun displayPostComments(post: Posts) {
        _navigateToSelectedPost.value = post
    }

    /**
     * After the navigation has taken place, make sure navigateToSelectedProperty is set to null
     */
    @SuppressLint("NullSafeMutableLiveData")
    fun displayPostDetailsComplete() {
        _navigateToSelectedPost.value =null
    }
}