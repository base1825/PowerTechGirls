package za.co.varsitycollege.st10480736.qwimi.poe

import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ShortCourse6Week : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shortcouse6week)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // CheckBoxes
        val chkCooking = findViewById<CheckBox>(R.id.chkCooking)
        val chkChildMinding = findViewById<CheckBox>(R.id.chkChildMinding)
        val chkGardenMaintenance = findViewById<CheckBox>(R.id.chkGardenMaintenance)

        // Buttons
        val btnAdd = findViewById<AppCompatButton>(R.id.btnAdd)
        val btnBack = findViewById<AppCompatButton>(R.id.btnback)
        val btnQuotation = findViewById<AppCompatButton>(R.id.btnQuotation)

        // Button: Add to cart
        btnAdd.setOnClickListener {
            val selected = mutableListOf<String>()

            if (chkCooking.isChecked) selected.add("Cooking")
            if (chkChildMinding.isChecked) selected.add("Child Minding")
            if (chkGardenMaintenance.isChecked) selected.add("Garden Maintenance")

            if (selected.isNotEmpty()) {
                // Add selected items to Cart (assuming Cart.selectedServices exists)
                for (service in selected) {
                    Cart.selectedServices.add(Pair(service, 6)) // Example: 6 = weeks
                }

                Toast.makeText(
                    this,
                    "Added to cart: ${selected.joinToString()}",
                    Toast.LENGTH_SHORT
                ).show()

                // Reset checkboxes
                chkCooking.isChecked = false
                chkChildMinding.isChecked = false
                chkGardenMaintenance.isChecked = false
            } else {
                Toast.makeText(this, "Select at least one service", Toast.LENGTH_SHORT).show()
            }
        }

        // Button: Go back
        btnBack.setOnClickListener {
            finish()
        }

        // Button: Go to quotation page
        btnQuotation.setOnClickListener {
            val intent = Intent(this, Quotations::class.java)
            startActivity(intent)
        }
    }
}
