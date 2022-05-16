package com.example.mybottomnavigation.ui.hero

import javax.inject.Inject

class HeroRepository @Inject constructor(private val retrofitServiceHero: RetrofitServiceHero) {
    fun getAllHeroes() = retrofitServiceHero.getAllHeroes()
}
