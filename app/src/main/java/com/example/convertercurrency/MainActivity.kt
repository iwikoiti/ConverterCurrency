package com.example.convertercurrency

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var okButton: Button
    private lateinit var costEditText: EditText
    private lateinit var radioGroupCurrency: RadioGroup
//    private lateinit var radioButtonEuro: RadioButton
//    private lateinit var radioButtonDollar: RadioButton
//    private lateinit var radioButtonPound: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        okButton = findViewById(R.id.okButton)
        costEditText = findViewById(R.id.costEditText)
        radioGroupCurrency = findViewById(R.id.radioGroupCurrency)
        var convertValue = 0f
        var completeValue = 0f

        radioGroupCurrency.setOnCheckedChangeListener { _, checkedId ->
            val selectedRadioButton = findViewById<RadioButton>(checkedId)
            val selectedCurrency = selectedRadioButton?.text.toString()

            val w = getString(R.string.dollar_sign)
            when (selectedCurrency) {
                getString(R.string.euro_sign) -> {
                    convertValue = 90f
                }
                getString(R.string.dollar_sign) -> {
                    convertValue = 75f
                }
                getString(R.string.pound_sign) -> {
                    convertValue = 100f
                }
            }
            //Toast.makeText(this, "Выбрана валюта: $convertValue", Toast.LENGTH_SHORT).show()

        }

        okButton.setOnClickListener{

            var cost = costEditText.text.toString().toFloatOrNull() ?: 0f

            completeValue = cost * convertValue

            Toast.makeText(this, "Выбрана валюта: $completeValue", Toast.LENGTH_SHORT).show()



            val intent = Intent(this, resultCurrency::class.java)
            startActivity(intent)
        }
    }
}