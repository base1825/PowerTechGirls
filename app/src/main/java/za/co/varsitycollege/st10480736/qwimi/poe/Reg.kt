package za.co.varsitycollege.st10480736.qwimi.poe
import android.content.Intent
import android.widget.Toast
import android.os.Bundle
import android.util.Patterns
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Reg : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reg)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

val email = findViewById<AppCompatEditText>(R.id.email)
        val etName= findViewById<AppCompatEditText>(R.id.etName)
        val passwork= findViewById<AppCompatEditText>(R.id.password)
        val btnEnter= findViewById<AppCompatButton>(R.id.btnEnter)
        btnEnter.setOnClickListener {
            val name = etName.text.toString().trim()
            val email = email.text.toString().trim()
            val password = password.text.toString().trim()

            // --- Validation ---
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Enter a valid email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // --- Registration success ---
            Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()

            // Navigate to LoginActivity
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish()
        }
    }
}


