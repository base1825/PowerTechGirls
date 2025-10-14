package za.co.varsitycollege.st10480736.qwimi.poe
import android.content.Intent
import android.widget.Toast
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    val etName= findViewById<AppCompatEditText>(R.id.etName)
        val password= findViewById<AppCompatEditText>(R.id.password)
        val btnStart= findViewById<AppCompatButton>(R.id.btnStart)

        btnStart.setOnClickListener{
            if (etName.text.isNullOrEmpty() || password.text.isNullOrEmpty()) {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
            } else if (etName.text!!.equals("user") && password.text!!.equals("1234")) {
                // Hard-coded credentials check
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
                finish() // prevents going back to login
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }

        // --- Optional Start button logic ---
        btnStart.setOnClickListener {
            // Navigate to LongCourseActivity (home screen)
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish() // optio
        }

    }
}

