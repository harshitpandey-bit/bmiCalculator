package com.example.bmi_calculator

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.bmi_calculator.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Sample data for demonstration
        val bmiHistory = listOf(
            "Height: 170 cm, Weight: 70 kg, BMI: 24.2",
            "Height: 165 cm, Weight: 60 kg, BMI: 22.0",
            "Height: 180 cm, Weight: 85 kg, BMI: 26.2"
        )

        // Setup ListView with ArrayAdapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, bmiHistory)
        binding.historyListView.adapter = adapter
    }
}
