package za.co.varsitycollege.st10480736.qwimi.poe
import android.content.Intent


import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Aboutus : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
val textintro= findViewById<TextView>(R.id.textintro)
        val btnShort2= findViewById<TextView>(btnShort2)
        val btn6Month2= findViewById<AppCompatButton>(btn6Month2)
        val btnQtion= findViewById<AppCompatButton>(btnQtion)


        btnShort2.setOnClickListener {
            startActivity(Intent(this, shortcourseDetails::class.java))
        }

        btn6Month2.setOnClickListener {
            startActivity(Intent(this, longcoursedetails2::class.java))
        }

        btnQtion.setOnClickListener {
            startActivity(Intent(this, Quotations::class.java))
        }






    }
}