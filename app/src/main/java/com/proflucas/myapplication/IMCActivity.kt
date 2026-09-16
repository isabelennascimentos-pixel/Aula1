package com.proflucas.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class IMCActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_IMC)

        Toast.makeText(this, "Trocou para IMC!", Toast.LENGTH_SHORT).show()

        val labelpeso = findViewById<TextView>(R.id.labelpeso)
        val labelaltura = findViewById<TextView>(R.id.labelaltura)
        val btnCalcularIMC = findViewById<Button>(R.id.btnCalcularIMC)
        val txtIMC = findViewById<TextView>(R.id.txtIMC)

        btnCalcularIMC.setOnClickListener {
            // Pegar o texto do EditText
            val input = txtIMC.text.toString().trim()

            if (input.isEmpty()) {
                Toast.makeText(this, "Digite sua altura!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val altura = input.toDouble()

                // Fórmula: °F = (°C × 9/5) + 32
                val fahrenheit = (IMC * 9.0 / 5.0) + 32.0

                // Mostrar resultado com 1 casa decimal
                labelaltura.text = String.format("Resultado: %.1f °F", fahrenheit)

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Digite um número válido!", Toast.LENGTH_SHORT).show()
                labelaltura.text = "Resultado: — °F"
            }
        }

        val btnSwitchToMedia = findViewById<Button>(R.id.btnLayoutMedia)

        btnSwitchToMedia.setOnClickListener {
            switchToLayoutMedia()
        }

    }

    private fun switchToLayoutMedia() {
        startActivity(Intent(this, MainActivity::class.java))
    }

}