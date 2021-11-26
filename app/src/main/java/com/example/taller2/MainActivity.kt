package com.example.taller2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickboton()
    }

    @SuppressLint("SetTextI18n")
    fun clickboton() {

        // Botones
        var bsuma = findViewById<Button>(R.id.buttonSuma)
        var bresta = findViewById<Button>(R.id.buttonResta)
        var bmulti = findViewById<Button>(R.id.buttonMulti)
        var bdiv = findViewById<Button>(R.id.buttonDivision)
        var biva = findViewById<Button>(R.id.buttonIva)
        var bedad = findViewById<Button>(R.id.buttonMayorMenor)
        var bprimo = findViewById<Button>(R.id.buttonPrimo)
        var bpar = findViewById<Button>(R.id.buttonPar)

        // Textos
        var editNum1 = findViewById<EditText>(R.id.editNumero1)
        var editNum2 = findViewById<EditText>(R.id.editNumero2)
        var resultado = findViewById<TextView>(R.id.textResultado)
        var parametro = findViewById<EditText>(R.id.editParametro)
        var resultado2 = findViewById<TextView>(R.id.textRValidacion)

        bsuma.setOnClickListener{
            var result = (editNum1.text.toString()).toDouble() + (editNum2.text.toString()).toDouble()
            resultado.text = result.toString()
        }

        bresta.setOnClickListener{
            var result = (editNum1.text.toString()).toDouble() - (editNum2.text.toString()).toDouble()
            resultado.text = result.toString()
        }
        
        bmulti.setOnClickListener{
            var result = (editNum1.text.toString()).toDouble() * (editNum2.text.toString()).toDouble()
            resultado.text = result.toString()
        }

        bdiv.setOnClickListener{
            if ((editNum2.text.toString()).toInt() == 0) {
                editNum2.error = "No se puede dividir para 0"
                editNum2.requestFocus()
                return@setOnClickListener
            }else{
                var result = (editNum1.text.toString()).toDouble() / (editNum2.text.toString()).toDouble()
                resultado.text = result.toString()
            }

        }

        biva.setOnClickListener{
            var result = (parametro.text.toString()).toDouble() * 0.12
            resultado2.setText("El IVA es: "+result)
        }

        bedad.setOnClickListener{
            if ((parametro.text.toString()).toInt() > 17) {
                resultado2.setText("Usted es mayor de edad")
            }else{
                resultado2.setText("Usted es menor de edad")
            }
        }

        bprimo.setOnClickListener{
            var numero = (parametro.text.toString()).toInt()
            var cont = 0
            var i = 1
            while (i <= numero) {
                if (numero % i == 0) {
                    cont++
                }
                i++
            }
            if (cont == 2) {
                resultado2.setText("El numero "+numero+" es primo")
            }else{
                resultado2.setText("El numero "+numero+" no es primo")

            }
        }

        bpar.setOnClickListener{
            var numero = (parametro.text.toString()).toInt()
            if (numero % 2 == 0) {
                resultado2.setText("El numero "+numero+" es par")
            }else{
                resultado2.setText("El numero "+numero+" es impar")
            }
        }
    }
}