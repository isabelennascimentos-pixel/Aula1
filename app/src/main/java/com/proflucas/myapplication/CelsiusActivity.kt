package com.proflucas.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class CelsiusActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_celsius)

        Toast.makeText(this, "Trocou para IMC!", Toast.LENGTH_SHORT).show()

        val txtCelsius = findViewById<EditText>(R.id.txtCelsius)
        val labelConversor = findViewById<TextView>(R.id.labelConversor)
        val btnCalcularCelsius = findViewById<Button>(R.id.btnCalcularCelsius)

        btnCalcularCelsius.setOnClickListener {
            // Pegar o texto do EditText
            val input = txtCelsius.text.toString().trim()

            if (input.isEmpty()) {
                Toast.makeText(this, "Digite uma temperatura!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val celsius = input.toDouble()

                // Fórmula: °F = (°C × 9/5) + 32
                val fahrenheit = (celsius * 9.0 / 5.0) + 32.0

                // Mostrar resultado com 1 casa decimal
                labelConversor.text = String.format("Resultado: %.1f °F", fahrenheit)

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Digite um número válido!", Toast.LENGTH_SHORT).show()
                labelConversor.text = "Resultado: — °F"
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