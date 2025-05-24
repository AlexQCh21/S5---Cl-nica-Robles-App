package com.example.s05quezada

import android.content.Intent
import android.os.Bundle
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn_start = findViewById<Button>(R.id.btn_comenzar)
        val btn_salir = findViewById<Button>(R.id.btn_cerrar)
        var intent = Intent(this, HomeActivity::class.java)


        btn_start.setOnClickListener {
            startActivity(intent)
        }

        btn_salir.setOnClickListener {
            finish()
        }


    }
}