package com.example.mybottomnavigation.ui.movie

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitServiceMovie {
    @GET("movielist.json")
    fun getAllMovies(): Call<List<Movie>>
    companion object {
        var retrofitService: RetrofitServiceMovie? = null

        fun getInstance() : RetrofitServiceMovie {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitServiceMovie::class.java)
            }
            return retrofitService!!
        }
    }
}