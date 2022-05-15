package com.example.mybottomnavigation.ui.hero

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroViewModel constructor(private val repository:HeroRepository) : ViewModel() {
    val heroList = MutableLiveData<List<Hero>>()
    val errorMessage = MutableLiveData<String>()
    var progresBar = MutableLiveData<Boolean>(true)

    fun getAllHeroes() {
        val response: Call<List<Hero>> = repository.getAllHeroes()
        response.enqueue(object : Callback<List<Hero>> {
            override fun onResponse(call: Call<List<Hero>>, response: Response<List<Hero>>) {
                heroList.postValue(response.body())
                progresBar.postValue(false)
            }
            override fun onFailure(call: Call<List<Hero>>, t: Throwable) {
                errorMessage.postValue(t.message)
                progresBar.postValue(true)
            }
        })
    }
}