package com.example.mybottomnavigation

import com.example.mybottomnavigation.ui.hero.HeroFragment
import com.example.mybottomnavigation.ui.movie.MovieFragment
import com.example.mybottomnavigation.ui.quote.QuoteFragment
import dagger.Component

@Component(modules = [MyModule::class])
interface MyComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(heroFragment: HeroFragment)
    fun inject(movieFragment: MovieFragment)
    fun inject(quoteFragment: QuoteFragment)
}