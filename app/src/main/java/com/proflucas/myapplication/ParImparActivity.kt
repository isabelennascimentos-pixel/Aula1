package com.proflucas.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class ParImparActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_parimpar)
        Toast.makeText(this, "Trocou para Par ou Impar!", Toast.LENGTH_SHORT).show()

        val txtNumero = findViewById<EditText>(R.id.txtNumero)
        val labelParImpar = findViewById<TextView>(R.id.labelParImpar)
        val btnCalcularParImpar = findViewById<Button>(R.id.btnCalcularParImpar)

        btnCalcularParImpar.setOnClickListener {
            // Pegar o texto do EditText
            val input = txtNumero.text.toString().trim()

            if (input.isEmpty()) {
                Toast.makeText(this, "Digite um Número!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                val numero = input.toInt()

                labelParImpar.text = checkParImpar(numero);

            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Digite um número válido!", Toast.LENGTH_SHORT).show()
                labelParImpar.text = "O número é ?"
            }
        }

        val btnSwitchToMedia = findViewById<Button>(R.id.btnLayoutMedia)
        val btnSwitchToCelsius = findViewById<Button>(R.id.btnLayoutCelsius)

        btnSwitchToMedia.setOnClickListener {
            switchToLayoutMedia()
        }

        btnSwitchToCelsius.setOnClickListener {
            startActivity(Intent(this, CelsiusActivity::class.java))
        }
    }

    private fun switchToLayoutMedia() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    fun checkParImpar(number: Int): String {
        return if (number % 2 == 0) {
            "$number é par."
        } else {
            "$number é impar."
        }
    }

}