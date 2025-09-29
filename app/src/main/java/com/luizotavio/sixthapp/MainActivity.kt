package com.luizotavio.sixthapp

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val peso = findViewById<EditText>(R.id.campo_peso)
        val altura = findViewById<EditText>(R.id.campo_altura)
        val resultado = findViewById<TextView>(R.id.resultado)

        val btCalc = findViewById<Button>(R.id.botao_acao)
        btCalc.setOnClickListener {
            val peso = peso.text.toString().toFloat()
            val altura = altura.text.toString().toFloat()
            val calculo = (Math.round((peso/(altura*altura))*100)/100.0f)
            resultado.setText("IMC = $calculo")
            val nome = findViewById<TextView>(R.id.nome)
            nome.setText("\uD83D\uDC7E Luiz Otávio \uD83D\uDC7E")
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}