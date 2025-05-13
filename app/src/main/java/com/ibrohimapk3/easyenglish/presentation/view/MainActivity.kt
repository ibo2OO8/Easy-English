package com.ibrohimapk3.easyenglish.presentation.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.ibrohimapk3.easyenglish.R
import com.ibrohimapk3.easyenglish.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.btnNav.setupWithNavController(navController)
    }
    fun hideBottomNav(hide: Boolean) {
        binding.btnNav.visibility = if (hide) View.GONE else View.VISIBLE
    }
}
