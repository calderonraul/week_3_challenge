package com.example.week3challenge.postsdetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment

import android.view.View
import android.view.ViewGroup
import com.example.week3challenge.databinding.PostDetailFragmentBinding


class PostDetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View{

        val binding = PostDetailFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this

        return binding.root
    }
}