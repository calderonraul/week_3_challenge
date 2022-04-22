package com.example.week3challenge.postsdetail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class PostDetailViewModelFactory(val aux: Int,var application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostDetailViewModel(aux,application) as T
    }
}


