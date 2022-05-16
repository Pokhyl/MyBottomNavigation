package com.example.mybottomnavigation.ui.quote

import javax.inject.Inject


class QuoteRepository @Inject constructor(private val retrofitServiceQuote: RetrofitServiceQuote) {
    fun getAllQuotes() = retrofitServiceQuote.getAllQuote()
}