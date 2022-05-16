package com.example.mybottomnavigation.ui.quote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class QuoteViewModelFactory @Inject constructor(private val repository: QuoteRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(QuoteViewModel::class.java)){
                QuoteViewModel(repository) as T
            }
            else {

                throw IllegalArgumentException("ViewModel Not Found")
            }
        }
    }
