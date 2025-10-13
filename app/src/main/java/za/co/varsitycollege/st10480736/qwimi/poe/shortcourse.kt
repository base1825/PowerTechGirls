package za.co.varsitycollege.st10480736.qwimi.poe

import android.content.Intent
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class shortcourse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

   val txtshort= findViewById<TextView>(R.id.txtshort)
    val radioOption1= findViewById<TextView>(R.id.radioOption1)
        val radioOption2= findViewById<TextView>(R.id.radioOption2)
        val radioOption3= findViewById<TextView>(R.id.radioOption3)
        val btnadd= findViewById<AppCompatButton>(R.id.btnadd)
        val btnback= findViewById<AppCompatButton>(R.id.btnback)
        btnadd.setOnClickListener {
            Toast.makeText(this, "Add button clicked!", Toast.LENGTH_SHORT).show()
        }
        btnback.setOnClickListener{
            startActivity(Intent(this, Home::class.java))
            finish()


        }
          }
    }