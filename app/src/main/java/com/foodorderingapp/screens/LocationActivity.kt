package com.foodorderingapp.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.foodorderingapp.R

class LocationActivity : AppCompatActivity() {

    val act_list_of_location: AutoCompleteTextView get() = findViewById(R.id.act_list_of_location)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        val locations = arrayOf("Indore", "Dewas", "Ujjen", "Kannod", "Bahndariya", "Bhopal")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, locations)
        act_list_of_location.setAdapter(adapter)

    }
}