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
import com.example.week3challenge.R
import com.example.week3challenge.databinding.PostsFragmentBinding

class PostsFragment : Fragment() {
    lateinit var sharedPreferences: SharedPreferences

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
        sharedPreferences= requireContext().getSharedPreferences("mySP",Activity.MODE_PRIVATE)
        // Giving the binding access to the OverviewViewModel
        binding.viewModel = viewModel

        binding.recycler.adapter=PostsAdapter(PostsAdapter.OnClickListener{
            viewModel.displayPostComments(it)
            val editor=sharedPreferences.edit()
            editor.putString("id",it.id.toString())
            editor.apply()
            Log.wtf("ravnn","guarde el id"+it.id.toString())


        })

        return binding.root

    }



}