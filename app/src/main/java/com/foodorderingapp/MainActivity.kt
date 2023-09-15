package com.foodorderingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.foodorderingapp.databinding.ActivityMainBinding
import com.foodorderingapp.screens.fragment.bottom_sheet.NotificationBottomSheetFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         val navController = findNavController(R.id.fragmentContainerView)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setupWithNavController(navController)

            binding.ivNotification.setOnClickListener {
                val notificationBottomSheetBinding = NotificationBottomSheetFragment()
                notificationBottomSheetBinding.show(supportFragmentManager,"Test")
        }
    }
}