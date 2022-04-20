package com.example.week3challenge.posts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week3challenge.networking.Posts
import com.example.week3challenge.networking.PostsApi
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback

class PostsViewModel : ViewModel() {
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

    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            try {
                val listResult = PostsApi.retrofitService.getProperties()
                Log.wtf("ravn",listResult.toString())
                _status.value = "Success: ${listResult.size} Mars properties retrieved"
                if (listResult.isNotEmpty()) {
                    _postinfo.value = listResult
                }
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
                Log.wtf("ravn",e.message)
            }
        }
    }
}