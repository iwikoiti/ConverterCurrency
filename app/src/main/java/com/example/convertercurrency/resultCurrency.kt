package com.example.convertercurrency

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class resultCurrency : AppCompatActivity() {

    private lateinit var costTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_currency)

        val completeCost = intent.getFloatExtra("your_cost",0f)
        //Toast.makeText(this, "Выбрана валюта: $completeCost", Toast.LENGTH_SHORT).show()

        costTextView = findViewById(R.id.costTextView)
        costTextView.text = completeCost.toString()

    }
}