package com.example.week3challenge.posts

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week3challenge.database.PostsDatabase
import com.example.week3challenge.networking.Posts
import com.example.week3challenge.networking.PostsApi
import kotlinx.coroutines.launch

class PostsViewModel(var application: Application) : ViewModel() {

    private val db: PostsDatabase = PostsDatabase.getInstance(application)

    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
        get() = _status


    private val _postinfo = MutableLiveData<List<Posts>>()

    val posties: LiveData<List<Posts>>
        get() = _postinfo

    private val _navigateToSelectedPost = MutableLiveData<Posts>()

    val navigateToSelectedPost: LiveData<Posts>
        get() = _navigateToSelectedPost


    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            try {
                val listResult = PostsApi.retrofitService.getPosts()
                Log.wtf("ravn", listResult.toString())
                _status.value = "Success: ${listResult.size} posts retrieved"
                if (listResult.isNotEmpty()) {
                    _postinfo.value = listResult

                    for (item in listResult) {

                        db.postsDatabase.insert(item)
                        Log.wtf("basededato", "inserte esto$item")
                    }


                }
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
                Log.wtf("ravn", e.message)
            }
        }
    }


    fun displayPostComments(post: Posts) {
        _navigateToSelectedPost.value = post
    }

    @SuppressLint("NullSafeMutableLiveData")
    fun displayPostDetailsComplete() {
        _navigateToSelectedPost.value = null
    }
}