package za.co.varsitycollege.st10480736.qwimi.poe


import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Toast
import za.co.varsitycollege.st10480736.qwimi.poe.Cart


class shortcouse6week : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shortcouse6week)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val chkCooking= findViewById<CheckBox>(R.id.chkCooking)
        val chkChildMinding=findViewById<CheckBox>(R.id.chkChildMinding)
        val chkGardenMaintenance=findViewById<CheckBox>(R.id.chkGardenMaintenance)

        val btnAdd= findViewById<AppCompatButton>(R.id.btnAdd)
        val btnBack=findViewById<AppCompatButton>(R.id.btnBack)
        val selected = Cart.selectedServices


        if (anySelected) {
            Toast.makeText(
                this,
                "Added to cart: ${Cart.selectedServices.joinToString { it.first }}",
                Toast.LENGTH_SHORT
            ).show()
            chkCooking.isChecked = false
            chkChildMinding.isChecked = false
            chkGardenMaintenance.isChecked = false
        } else {
            Toast.makeText(this, "Select at least one service", Toast.LENGTH_SHORT).show()
        }
    }

    btnQuotation.setOnClickListener{
    startActivity(Intent(this, Quotations::class.java))

    btnBack.setOnClickListener { finish() }
}
}
