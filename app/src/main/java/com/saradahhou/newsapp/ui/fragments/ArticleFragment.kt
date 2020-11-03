package com.saradahhou.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.saradahhou.newsapp.R
import com.saradahhou.newsapp.ui.NewsActivity
import com.saradahhou.newsapp.ui.NewsViewModel
import kotlinx.android.synthetic.main.fragment_article.*

/**
 * Created by Created by Sara Dahhou on 10/29/20.
 * Copyright © 2020 Sara Dahhou. All rights reserved.
 */

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var viewModel: NewsViewModel
    private val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel

        val article = args.currentArticle
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.let {
            it.title = article.title
            it.setDisplayHomeAsUpEnabled(true)
        }

        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

        saveButton.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view, "Article saved", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onStop() {
        super.onStop()
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.let {
            it.title = "NewsApp"
            it.setDisplayHomeAsUpEnabled(false)
        }
    }

}