package com.example.mybottomnavigation.ui.quote



class QuoteRepository constructor(private val retrofitServiceQuote: RetrofitServiceQuote) {
    fun getAllQuotes() = retrofitServiceQuote.getAllQuote()
}