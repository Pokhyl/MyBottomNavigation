package com.example.mybottomnavigation

import androidx.lifecycle.ViewModelProvider
import com.example.mybottomnavigation.ui.hero.HeroViewModel
import com.example.mybottomnavigation.ui.hero.HeroViewModelFactory
import com.example.mybottomnavigation.ui.hero.RetrofitServiceHero
import dagger.Module
import dagger.Provides

@Module
class MyModule {
    @Provides
    fun retrofitServiceHero(): RetrofitServiceHero {
        return RetrofitServiceHero.getInstance()
    }
//    @Provides
//    fun heroViewModel(heroViewModelFactory: HeroViewModelFactory): HeroViewModel{
//        return ViewModelProvider(this, heroViewModelFactory).get(HeroViewModel::class.java)
//    }
}