package com.example.mybottomnavigation

import androidx.lifecycle.ViewModelProvider
import com.example.mybottomnavigation.ui.hero.HeroViewModel
import com.example.mybottomnavigation.ui.hero.HeroViewModelFactory
import com.example.mybottomnavigation.ui.hero.RetrofitServiceHero
import com.example.mybottomnavigation.ui.movie.RetrofitServiceMovie
import com.example.mybottomnavigation.ui.quote.RetrofitServiceQuote
import dagger.Module
import dagger.Provides

@Module
class MyModule {
    @Provides
    fun retrofitServiceHero(): RetrofitServiceHero {
        return RetrofitServiceHero.getInstance()
    }
    @Provides
    fun retrofitServiceMovie(): RetrofitServiceMovie{
        return RetrofitServiceMovie.getInstance()
    }
    @Provides
    fun retrofitServiceQuote(): RetrofitServiceQuote{
        return RetrofitServiceQuote.getInstance()
    }
}