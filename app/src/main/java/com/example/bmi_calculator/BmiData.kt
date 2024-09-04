package com.example.bmi_calculator

data class BmiData(
    val height: String = "",
    val weight: String = "",
    val bmi: Double? = null,
    val classification: String = ""
)
