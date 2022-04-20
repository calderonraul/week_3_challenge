package com.example.week3challenge.posts

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.week3challenge.R
import com.example.week3challenge.databinding.PostsFragmentBinding

class PostsFragment : Fragment() {

private val viewModel:PostsViewModel by lazy{
    ViewModelProvider(this).get(PostsViewModel::class.java)
}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding=PostsFragmentBinding.inflate(inflater)
        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this
        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        binding.recycler.adapter=PostsAdapter()

        return binding.root

    }



}