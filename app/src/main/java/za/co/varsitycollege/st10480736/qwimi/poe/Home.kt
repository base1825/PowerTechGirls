package za.co.varsitycollege.st10480736.qwimi.poe
import android.content.Intent


import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

val btnShort= findViewById<AppCompatButton>(R.id.btnShort)
        val btn6Month= findViewById<AppCompatButton>(R.id.btn6Month)
        val btnAboutus=findViewById<AppCompatButton>(R.id.btnQtion)
        val txtintro=findViewById<TextView>(R.id.txtintro)

        btn6Month.setOnClickListener {
            startActivity(Intent(this, longcourse::class.java))
        }

        btnShort.setOnClickListener {
            startActivity(Intent(this, shortcouse6week::class.java))
        }

        btnAboutus.setOnClickListener {
            startActivity(Intent(this, Aboutus::class.java))
        }
    }
}










