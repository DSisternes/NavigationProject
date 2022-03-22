package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navigation.databinding.ActivityMainBinding
import com.example.navigation.databinding.FragmentInsideHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.security.AccessController

class MainActivity : AppCompatActivity() {
    //private lateinit var navController: NavController
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFrgmnt = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        binding.bottomNavigationView.setupWithNavController(navHostFrgmnt.navController)

//        val navView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
//        navView.setupWithNavController(navController)
    }
}