package za.co.varsitycollege.st10480736.qwimi.poe
import android.widget.Toast


import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class longcourse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_longcourse)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val chkFirstAid = findViewById<CheckBox>(R.id.chkFirstAid)
        val chkSewing = findViewById<CheckBox>(R.id.chkSewing)
        val chkLandscaping = findViewById<CheckBox>(R.id.Lanscaping)
        val chkLifeSkills = findViewById<CheckBox>(R.id.chkLifeSkills)
        val btnAdd = findViewById<AppCompatButton>(R.id.btnAdd)
        val btnBack = findViewById<AppCompatButton>(R.id.btnFristAid)
        val btnQuotation = findViewById<AppCompatButton>(R.id.btnQuotation)

        btnAdd.setOnClickListener {
            var anySelected = false

            if (chkFirstAid.isChecked) { Cart.addService("First Aid", 1500); anySelected = true }
            if (chkSewing.isChecked) { Cart.addService("Sewing", 1500); anySelected = true }
            if (chkLandscaping.isChecked) { Cart.addService("Landscaping", 1500); anySelected = true }
            if (chkLifeSkills.isChecked) { Cart.addService("Life Skills", 1500); anySelected = true }

            if (anySelected) {
                Toast.makeText(
                    this,
                    "Added to cart: ${Cart.selectedServices.joinToString { it.first }}",
                    Toast.LENGTH_SHORT
                ).show()
                chkFirstAid.isChecked = false
                chkSewing.isChecked = false
                chkLandscaping.isChecked = false
                chkLifeSkills.isChecked = false
            } else {
                Toast.makeText(this, "Select at least one service", Toast.LENGTH_SHORT).show()
            }
        }

        btnQuotation.setOnClickListener {
            startActivity(Intent(this, Quotations::class.java))
        }

        btnBack.setOnClickListener { finish() }
    }
}
