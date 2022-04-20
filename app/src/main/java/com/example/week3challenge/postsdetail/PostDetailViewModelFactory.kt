package com.example.week3challenge.postsdetail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.week3challenge.networking.Comments
/*
class PostDetailViewModelFactory(
    private val comments: Comments,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostDetailViewModel::class.java)) {
            return PostDetailViewModel(comments, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


 */