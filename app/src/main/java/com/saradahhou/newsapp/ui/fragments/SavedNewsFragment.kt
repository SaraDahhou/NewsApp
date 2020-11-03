package com.saradahhou.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.saradahhou.newsapp.R
import com.saradahhou.newsapp.ui.NewsActivity
import com.saradahhou.newsapp.ui.NewsViewModel
import com.saradahhou.newsapp.ui.adapters.NewsAdapter
import kotlinx.android.synthetic.main.fragment_breaking_news.*

/**
 * Created by Created by Sara Dahhou on 10/29/20.
 * Copyright © 2020 Sara Dahhou. All rights reserved.
 */

class SavedNewsFragment : Fragment(R.layout.fragment_saved_news) {

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("currentArticle", it)
            }
            findNavController().navigate(R.id.action_savedNewsFragment_to_articleFragment, bundle)
        }
        viewModel = (activity as NewsActivity).viewModel
    }

    private fun setupRecyclerView(){
        newsAdapter = NewsAdapter()
        rvBreakingNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}