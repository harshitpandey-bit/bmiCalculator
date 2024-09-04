package com.example.bmi_calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//class BmiViewModel : ViewModel() {
//    val height = MutableLiveData<String>()
//    val weight = MutableLiveData<String>()
//
//    private val _bmi = MutableLiveData<Double?>()
//    val bmi: LiveData<Double?> = _bmi
//
//    private val _bmiClassification = MutableLiveData<String>()
//    val bmiClassification: LiveData<String> = _bmiClassification
//
//    private val _isResetVisible = MutableLiveData(false)
//    val isResetVisible: LiveData<Boolean> = _isResetVisible
//
//    fun onCalculateClicked() {
//        if (_isResetVisible.value == true) {
//            reset()
//        } else {
//            calculateBmi()
//        }
//    }
//
//    private fun calculateBmi() {
//        val heightValue = height.value?.toDoubleOrNull()
//        val weightValue = weight.value?.toDoubleOrNull()
//
//        if (heightValue != null && weightValue != null) {
//            val bmiValue = weightValue / ((heightValue / 100) * (heightValue / 100))
//            _bmi.value = bmiValue
//
//            _bmiClassification.value = when {
//                bmiValue < 18.5 -> "Underweight"
//                bmiValue < 25 -> "Normal"
//                bmiValue < 30 -> "Overweight"
//                else -> "Obese"
//            }
//
//            _isResetVisible.value = true // Show reset button
//        }
//    }
//
//    private fun reset() {
//        height.value = "" // Clear height
//        weight.value = "" // Clear weight
//        _bmi.value = null // Clear BMI
//        _bmiClassification.value = "" // Clear classification
//        _isResetVisible.value = false // Hide reset button
//    }
//}
class BmiViewModel : ViewModel() {
    val height = MutableLiveData<String>()
    val weight = MutableLiveData<String>()

    private val _bmi = MutableLiveData<Double?>()
    val bmi: LiveData<Double?> = _bmi

    private val _bmiClassification = MutableLiveData<String>()
    val bmiClassification: LiveData<String> = _bmiClassification

    private val _isResetVisible = MutableLiveData(false)
    val isResetVisible: LiveData<Boolean> = _isResetVisible

    val isMale = MutableLiveData<Boolean>(true) // Default gender selection is Male

    fun onCalculateClicked() {
        if (_isResetVisible.value == true) {
            reset()
        } else {
            calculateBmi()
        }
    }

    private fun calculateBmi() {
        val heightValue = height.value?.toDoubleOrNull()
        val weightValue = weight.value?.toDoubleOrNull()

        if (heightValue != null && weightValue != null) {
            val bmiValue = weightValue / ((heightValue / 100) * (heightValue / 100))
            _bmi.value = bmiValue

            _bmiClassification.value = when {
                bmiValue < 18.5 -> "Underweight"
                bmiValue < 25 -> "Normal"
                bmiValue < 30 -> "Overweight"
                else -> "Obese"
            }

            _isResetVisible.value = true // Show reset button
        }
    }

    private fun reset() {
        height.value = "" // Clear height
        weight.value = "" // Clear weight
        _bmi.value = null // Clear BMI
        _bmiClassification.value = "" // Clear classification
        _isResetVisible.value = false // Hide reset button
        isMale.value = true // Reset gender selection to Male
    }
}
