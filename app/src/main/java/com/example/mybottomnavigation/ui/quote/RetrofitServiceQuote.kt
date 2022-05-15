package com.example.mybottomnavigation.ui.quote

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitServiceQuote {
    @GET("quotes")
    fun getAllQuote(): Call<QuoteList>
    companion object {
        var retrofitService: RetrofitServiceQuote? = null

        fun getInstance() : RetrofitServiceQuote {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://quotable.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitServiceQuote::class.java)
            }
            return retrofitService!!
        }
    }
}