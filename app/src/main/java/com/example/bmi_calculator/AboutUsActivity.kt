package com.example.bmi_calculator

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import androidx.appcompat.app.AppCompatActivity
import com.example.bmi_calculator.databinding.ActivityAboutUsBinding

class AboutUsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the Call Doctor button
        binding.callDoctorButton.setOnClickListener {
            makePhoneCall()
        }

        // Set up the Message Doctor button
        binding.messageDoctorButton.setOnClickListener {
            showMessageOptions()
        }
    }

    private fun makePhoneCall() {
        val phoneNumber = "1234567890" // Replace with the doctor's phone number
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:$phoneNumber")
        startActivity(intent)
    }

    private fun showMessageOptions() {
        val messageIntent = Intent(Intent.ACTION_SEND)
        messageIntent.type = "text/plain"
        messageIntent.putExtra(Intent.EXTRA_TEXT, "Hello Doctor, I need assistance.")
        val chooserIntent = Intent.createChooser(messageIntent, "Choose an app to send a message")
        startActivity(chooserIntent)
    }
}
