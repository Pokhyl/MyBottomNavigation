package com.example.mybottomnavigation.ui.movie

import javax.inject.Inject

class MovieRepository @Inject constructor(private val retrofitService: RetrofitServiceMovie) {
    fun getAllMovies() = retrofitService.getAllMovies()
}