package com.proflucas.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.proflucas.myapplication.ui.theme.Aula1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        /*setContent {
            Aula1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Lucas",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }*/
        setContentView(R.layout.activity_main)

        val txtNota1 = findViewById<EditText>(R.id.txtNota1)
        val txtNota2 = findViewById<EditText>(R.id.txtNota2)
        val labelMedia = findViewById<TextView>(R.id.labelMedia)
        val btnCalcularMedia = findViewById<Button>(R.id.btnCalcularMedia)

        btnCalcularMedia.setOnClickListener{
            val nota1 = txtNota1.text.toString().toDoubleOrNull()
            val nota2 = txtNota2.text.toString().toDoubleOrNull()
            if(nota1 == null || nota2 == null) {
                labelMedia.text = "Nota Inválida"
                return@setOnClickListener
            }

            val media:Double? = (nota1 + nota2) / 2
            labelMedia.text = "Média: $media"
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Aula1Theme {
        Greeting("Android")
    }
}