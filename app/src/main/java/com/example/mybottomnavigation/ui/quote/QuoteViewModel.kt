package com.example.mybottomnavigation.ui.quote


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuoteViewModel(private val repository: QuoteRepository) : ViewModel() {
    val quoteList = MutableLiveData<QuoteList>()
    val errorMessage = MutableLiveData<String>()
    var progresBar = MutableLiveData<Boolean>(true)

    fun getAllQuotes() {
        val response: Call<QuoteList> = repository.getAllQuotes()
        response.enqueue(object : Callback<QuoteList> {
            override fun onResponse(call: Call<QuoteList>, response: Response<QuoteList>) {
                quoteList.postValue(response.body())
                progresBar.postValue(false)
            }
            override fun onFailure(call: Call<QuoteList>, t: Throwable) {
                errorMessage.postValue(t.message)
                progresBar.postValue(true)
            }
        })
    }
}