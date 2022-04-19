package com.example.week3challenge.posts

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.leanback.widget.DiffCallback
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.week3challenge.databinding.PostsAdapterBinding
import com.example.week3challenge.networking.Posts
import com.example.week3challenge.posts.PostsAdapter.PostViewHolder

class PostsAdapter() :ListAdapter<Posts, PostViewHolder> (DiffCallback) {

    class PostViewHolder (private val binding: PostsAdapterBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(posts: Posts){
            binding.posts=posts
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(PostsAdapterBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val posts=getItem(position)
        holder.bind(posts)
    }


    companion object DiffCallback : DiffUtil.ItemCallback<Posts>() {
        override fun areItemsTheSame(oldItem: Posts, newItem: Posts): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Posts, newItem: Posts): Boolean {
            return oldItem.id == newItem.id
        }
    }
}
