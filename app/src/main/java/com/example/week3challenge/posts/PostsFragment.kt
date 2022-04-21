package com.example.week3challenge.posts

import android.app.Activity
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.week3challenge.databinding.PostsFragmentBinding

class PostsFragment : Fragment() {
    lateinit var sharedPreferences: SharedPreferences

    private val viewModel: PostsViewModel by lazy {
        ViewModelProvider(this).get(PostsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        val binding = PostsFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this
        sharedPreferences = requireContext().getSharedPreferences("mySP", Activity.MODE_PRIVATE)


        val modelfactory = PostsViewModelFactory(requireActivity().application);


        binding.viewModel = ViewModelProvider(this, modelfactory).get(PostsViewModel::class.java)

        binding.recycler.adapter = PostsAdapter(PostsAdapter.OnClickListener {
            viewModel.displayPostComments(it)
            val editor = sharedPreferences.edit()
            editor.putInt("id", it.id)
            editor.apply()
            Log.wtf("ravnn", "guarde el id" + it.id.toString())

        })
        viewModel.navigateToSelectedPost.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(PostsFragmentDirections.actionShowDetail(it))
                viewModel.displayPostDetailsComplete()
            }
        })

        return binding.root

    }


}