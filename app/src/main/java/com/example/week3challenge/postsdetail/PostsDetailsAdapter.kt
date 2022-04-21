package com.example.week3challenge.postsdetail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.week3challenge.databinding.CommentsAdapterBinding

import com.example.week3challenge.networking.Comments


class PostsDetailsAdapter() :
    ListAdapter<Comments, PostsDetailsAdapter.CommentViewHolder>(DiffCallback) {

    class CommentViewHolder(private val binding: CommentsAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(comments: Comments) {
            binding.comments = comments
            binding.executePendingBindings()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        return CommentViewHolder(CommentsAdapterBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comments = getItem(position)

        holder.bind(comments)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Comments>() {
        override fun areItemsTheSame(oldItem: Comments, newItem: Comments): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Comments, newItem: Comments): Boolean {
            return oldItem.id == newItem.id
        }
    }

}