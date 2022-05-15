package com.example.mybottomnavigation.ui.hero

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitServiceHero{
    @GET("marvel")
    fun getAllHeroes(): Call<List<Hero>>
    companion object {
        var retrofitService: RetrofitServiceHero? = null

        fun getInstance() : RetrofitServiceHero {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://www.simplifiedcoding.net/demos/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitServiceHero::class.java)
            }
            return retrofitService!!
        }
    }
}
