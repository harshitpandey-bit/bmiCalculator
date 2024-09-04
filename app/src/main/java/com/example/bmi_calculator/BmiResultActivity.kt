package com.example.bmi_calculator

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.bmi_calculator.databinding.ActivityBmiResultBinding

class BmiResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBmiResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBmiResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get data passed from the MainActivity
        val height = intent.getStringExtra("HEIGHT")
        val weight = intent.getStringExtra("WEIGHT")
        val bmi = intent.getDoubleExtra("BMI", 0.0)
        val classification = intent.getStringExtra("CLASSIFICATION")

        // Create a list of the BMI data
        val bmiData = listOf(
            "Height: $height cm",
            "Weight: $weight kg",
            "BMI: $bmi",
            "Classification: $classification"
        )

        // Set up the ListView with the BMI data
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, bmiData)
        binding.bmiResultListView.adapter = adapter
    }
}
