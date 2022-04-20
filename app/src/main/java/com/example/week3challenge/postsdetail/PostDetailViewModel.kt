package com.example.week3challenge.postsdetail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.week3challenge.networking.Comments
import com.example.week3challenge.networking.Posts

class PostDetailViewModel(comments: Comments, app: Application) : AndroidViewModel(app) {

    private val _selectedComment = MutableLiveData<Comments>()

    val selectedPost: LiveData<Comments>
        get() = _selectedComment

    init {
        _selectedComment.value = comments
    }




}