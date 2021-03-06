package com.example.mybottomnavigation.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class MovieViewModelFactory @Inject constructor(private val repository: MovieRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MovieViewModel::class.java)) {
           MovieViewModel(this.repository) as T
        }
        else {

            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}