package za.co.varsitycollege.st10480736.qwimi.poe

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ShortCourseDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shortcourse_details)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Buttons declarations
        val btnChildMinding = findViewById<AppCompatButton>(R.id.btnChildMinding)
        val btnCooking = findViewById<AppCompatButton>(R.id.btnCooking)
        val btnGardenMaintenance = findViewById<AppCompatButton>(R.id.btnGardenMaintenance)
        val btnBack = findViewById<AppCompatButton>(R.id.btnBack)

        // Set click listeners all buttons
        btnChildMinding.setOnClickListener { navigateTo(ChildMindingActivity::class.java) }
        btnCooking.setOnClickListener { navigateTo(CookingActivity::class.java) }
        btnGardenMaintenance.setOnClickListener { navigateTo(GardenMaintenanceActivity::class.java) }

        btnBack.setOnClickListener { finish() }
    }

    // Helper function to navigate to a new Activity
    private fun navigateTo(activityClass: Class<*>) {
        startActivity(Intent(this, activityClass))
    }
}
