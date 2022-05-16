package com.example.mybottomnavigation.ui.hero

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class HeroViewModelFactory @Inject constructor(private val repository: HeroRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HeroViewModel::class.java)){
            HeroViewModel(repository) as T
        }
        else {

            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}