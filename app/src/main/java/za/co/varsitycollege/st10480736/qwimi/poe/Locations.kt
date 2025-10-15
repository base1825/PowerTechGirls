package za.co.varsitycollege.st10480736.qwimi.poe

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Locations : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_locations)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Buttons for each location
        val btnSandton = findViewById<AppCompatButton>(R.id.btnSandton)
        val btnRandburg = findViewById<AppCompatButton>(R.id.btnRandburg)
        val btnWaterfall = findViewById<AppCompatButton>(R.id.btnWaterfall)
        val btnBack = findViewById<AppCompatButton>(R.id.btnBack)

        btnSandton.setOnClickListener {
            openMapLocation("Sandton, Johannesburg, South Africa")
        }

        btnRandburg.setOnClickListener {
            openMapLocation("Randburg, Johannesburg, South Africa")
        }

        btnWaterfall.setOnClickListener {
            openMapLocation("Waterfall, Johannesburg, South Africa")
        }

        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun openMapLocation(query: String) {
        try {
            val uri = Uri.parse("https://www.google.com/maps/search/?api=1&query=$query")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.google.android.apps.maps")
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, "Google Maps not installed.", Toast.LENGTH_SHORT).show()
        }
    }
}
