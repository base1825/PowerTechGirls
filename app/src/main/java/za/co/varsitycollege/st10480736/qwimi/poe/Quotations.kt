package za.co.varsitycollege.st10480736.qwimi.poe

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.TextView


import androidx.appcompat.widget.AppCompatButton




class Quotations : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quotations)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val selectedServices = Cart.selectedServices
        val numberOfCourses = selectedServices.size

        // --- Tiered discount ---
        val discountRate = when {
            numberOfCourses == 1 -> 0.0
            numberOfCourses == 2 -> 0.05
            numberOfCourses >= 3 -> 0.10
            else -> 0.0
        }

        // --- Totals ---
        val subtotal = selectedServices.sumOf { it.second }
        val discount = subtotal * discountRate
        val afterDiscount = subtotal - discount
        val vatRate = 0.15
        val vat = afterDiscount * vatRate
        val total = afterDiscount + vat

        val quotationText = """
            Selected Services:
            ${selectedServices.joinToString("\n") { "${it.first} - R${it.second}" }}

            Number of Courses: $numberOfCourses
            Subtotal: R$subtotal
            Discount (${(discountRate*100).toInt()}%): R$discount
            After Discount: R$afterDiscount
            VAT (${(vatRate*100).toInt()}%): R$vat
            ---------------------------
            Total: R$total
        """.trimIndent()

        findViewById<TextView>(R.id.txtQuotation).text = quotationText

        findViewById<AppCompatButton>(R.id.btnFristAid).setOnClickListener { finish() }
    }
}


