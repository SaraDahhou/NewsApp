package com.saradahhou.newsapp.data.repository

import com.saradahhou.newsapp.data.db.ArticleDatabase
import com.saradahhou.newsapp.data.models.Article
import com.saradahhou.newsapp.network.RemoteDataSource

/**
 * Created by Created by Sara Dahhou on 10/29/20.
 * Copyright © 2020 Sara Dahhou. All rights reserved.
 */

class NewsRepository(
    val db: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RemoteDataSource.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RemoteDataSource.api.searchForNews(searchQuery, pageNumber)

    suspend fun insertArticle(article: Article) = db.getArticleDoa().insert(article)

    suspend fun deleteArticle(article: Article) = db.getArticleDoa().deleteArticle(article)

    fun getSavedNews() = db.getArticleDoa().getAllArticles()
}