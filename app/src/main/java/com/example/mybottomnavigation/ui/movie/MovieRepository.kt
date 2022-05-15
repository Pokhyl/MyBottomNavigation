package com.example.mybottomnavigation.ui.movie

class MovieRepository constructor(private val retrofitService: RetrofitServiceMovie) {
    fun getAllMovies() = retrofitService.getAllMovies()
}