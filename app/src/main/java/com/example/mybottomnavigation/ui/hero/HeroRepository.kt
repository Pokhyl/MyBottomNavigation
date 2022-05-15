package com.example.mybottomnavigation.ui.hero

class HeroRepository constructor(private val retrofitServiceHero: RetrofitServiceHero) {
    fun getAllHeroes() = retrofitServiceHero.getAllHeroes()
}
