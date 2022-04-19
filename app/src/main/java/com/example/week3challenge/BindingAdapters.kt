package com.example.week3challenge

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.week3challenge.networking.Posts
import com.example.week3challenge.posts.PostsAdapter


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Posts>?) {
    val adapter = recyclerView.adapter as PostsAdapter
    adapter.submitList(data)
}