package com.example.week3challenge

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.week3challenge.networking.Comments
import com.example.week3challenge.networking.Posts
import com.example.week3challenge.posts.PostsAdapter
import com.example.week3challenge.postsdetail.PostsDetailsAdapter


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Posts>?) {
    val adapter = recyclerView.adapter as PostsAdapter
    adapter.submitList(data)
}

@BindingAdapter("commentAdapter")
fun bindRecyclerView2(recyclerView: RecyclerView,data: List<Comments>?){
    val adapter=recyclerView.adapter as PostsDetailsAdapter
    adapter.submitList(data)
}