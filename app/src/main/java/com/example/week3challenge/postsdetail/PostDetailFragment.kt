package com.example.week3challenge.postsdetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment

import android.view.View
import android.view.ViewGroup
import com.example.week3challenge.databinding.PostDetailFragmentBinding


class PostDetailFragment : Fragment() {
    private val viewModel:PostDetailViewModel by lazy{
        ViewModelProvider(this).get(PostDetailViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View{

        val binding = PostDetailFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.recycler2.adapter=PostsDetailsAdapter()


        return binding.root
    }
}