package za.co.varsitycollege.st10480736.qwimi.poe

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LongCourseDetails2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_longcoursedetails2)

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //  declare Buttons
        val btnBack = findViewById<AppCompatButton>(R.id.btnBack)
        val btnSewing = findViewById<AppCompatButton>(R.id.btnSewing)
        val btnFirstAid = findViewById<AppCompatButton>(R.id.btnFirstAid)
        val btnLandscaping = findViewById<AppCompatButton>(R.id.btnLandscaping)
        val btnLifeSkills = findViewById<AppCompatButton>(R.id.btnLifeSkills)

        // Set click listeners
        btnSewing.setOnClickListener { navigateTo(SewingActivity::class.java) }
        btnFirstAid.setOnClickListener { navigateTo(FirstAidActivity::class.java) }
        btnLandscaping.setOnClickListener { navigateTo(LandscapingActivity::class.java) }
        btnLifeSkills.setOnClickListener { navigateTo(LifeSkillsActivity::class.java) }

        btnBack.setOnClickListener { finish() }
        // back to previous page
    }

    // Helper function to navigate to a new Activity
    private fun navigateTo(activityClass: Class<*>) {
        startActivity(Intent(this, activityClass))
    }
}
