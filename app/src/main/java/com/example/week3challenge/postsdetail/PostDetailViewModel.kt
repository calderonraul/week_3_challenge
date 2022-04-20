package com.example.week3challenge.postsdetail

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.week3challenge.networking.Comments
import com.example.week3challenge.networking.Posts
import com.example.week3challenge.networking.PostsApi
import kotlinx.coroutines.launch

class PostDetailViewModel(comments: Comments, app: Application,aux: Int) : AndroidViewModel(app) {

    private val _selectedComment = MutableLiveData<List<Comments>>()

    val selectedPost: LiveData<List<Comments>>
        get() = _selectedComment

init {
    getComments(aux)
}
    private fun getComments(aux : Int) {
        viewModelScope.launch {
            try {
                val listResult = PostsApi.retrofitService.getPostDetail(aux)
                Log.wtf("ravn",listResult.toString())
                //_status.value = "Success: ${listResult.size} posts retrieved"
                if (listResult.isNotEmpty()) {
                    _selectedComment.value = listResult
                }
            } catch (e: Exception) {
                //_status.value = "Failure: ${e.message}"
                Log.wtf("ravn",e.message)
            }
        }
    }


}