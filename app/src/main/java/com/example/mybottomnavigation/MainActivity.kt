package com.example.mybottomnavigation

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mybottomnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var myComponent: MyComponent
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        myComponent = (applicationContext as MyApplication).component
        myComponent.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navView: BottomNavigationView = binding.navView
//NavController - этот основной механизм Navigation Component. Именно его мы будем просить показывать на экране фрагменты.
// Но чтобы он мог это делать, он должен иметь список фрагментов и контейнер, в котором он будет эти фрагменты отображать.

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        //Список фрагментов между которыми переключаемся
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_hero, R.id.navigation_movie, R.id.navigation_quote
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}