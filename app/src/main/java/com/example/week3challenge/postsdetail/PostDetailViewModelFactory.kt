package com.example.week3challenge.postsdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.week3challenge.networking.Comments


class PostDetailViewModelFactory(val aux: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostDetailViewModel(aux) as T
    }
}


