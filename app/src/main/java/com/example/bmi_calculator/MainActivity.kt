package com.example.bmi_calculator

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bmi_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inflate the layout using View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the toolbar as the app bar for the activity
        setSupportActionBar(binding.toolbar)

        // Set up click listeners for buttons (if any) in your main activity
        // Example:
        // binding.someButton.setOnClickListener {
        //     // Handle button click
        // }
    }

    // Inflate the menu options
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Handle menu item clicks
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            // Handle BMI Chart option
//            R.id.action_bmi_chart -> {
//                val intent = Intent(this, BmiChartActivity::class.java)
//                startActivity(intent)
//                true
//            }
            // Handle History option
            R.id.action_history -> {
                val intent = Intent(this, HistoryActivity::class.java)
                startActivity(intent)
                true
            }
            // Handle About Us option
            R.id.action_about_us -> {
                val intent = Intent(this, AboutUsActivity::class.java)
                startActivity(intent)
                true
            }
            // Handle Contact Us option
            R.id.action_contact_us -> {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:example@example.com") // Replace with your contact email
                    putExtra(Intent.EXTRA_SUBJECT, "Contact Us")
                }
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "No email client installed", Toast.LENGTH_SHORT).show()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
