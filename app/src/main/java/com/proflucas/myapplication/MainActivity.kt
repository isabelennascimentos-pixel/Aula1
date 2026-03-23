package com.proflucas.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.proflucas.myapplication.ui.theme.Aula1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_media)

        val txtNota1 = findViewById<EditText>(R.id.txtNota1)
        val txtNota2 = findViewById<EditText>(R.id.txtNota2)
        val labelMedia = findViewById<TextView>(R.id.labelMedia)
        val btnCalcularMedia = findViewById<Button>(R.id.btnCalcularMedia)

        btnCalcularMedia.setOnClickListener {
            val nota1 = txtNota1.text.toString().toDoubleOrNull()
            val nota2 = txtNota2.text.toString().toDoubleOrNull()
            if (nota1 == null || nota2 == null) {
                labelMedia.text = "Nota Inválida"
                return@setOnClickListener
            }

            val media: Double? = (nota1 + nota2) / 2
            labelMedia.text = "Média: $media"

        }

        // Configurar o botão no layout media
        val btnSwitchToCelsius = findViewById<Button>(R.id.btnLayoutCelsius)
        val btnSwitchToParImpar = findViewById<Button>(R.id.btnLayoutParImpar)

        btnSwitchToCelsius.setOnClickListener {
            switchToLayoutCelsius()
        }

        btnSwitchToParImpar.setOnClickListener {
            startActivity(Intent(this, ParImparActivity::class.java))
        }
    }

    private fun switchToLayoutCelsius() {
        startActivity(Intent(this, CelsiusActivity::class.java))
    }

}