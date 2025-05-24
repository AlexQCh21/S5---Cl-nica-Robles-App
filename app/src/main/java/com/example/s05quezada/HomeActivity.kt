package com.example.s05quezada

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.s05quezada.adapter.EspecialidadAdapter

class HomeActivity : AppCompatActivity() {
    val homeFragment = HomeFragment()
    val especialidadFragment = EspecialidadesFragment()
    val acercaDeFragment = AcercaDeFragment()
    val navBarFragment = NavBarFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        showHome()
        showNavBar()

    }

    fun showHome(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frContenido, homeFragment)
            .addToBackStack(null) // Permite regresar con el botón Atrás
            .commit()

    }

    fun showNavBar(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fgNavbar, navBarFragment)
            .addToBackStack(null) // Permite regresar con el botón Atrás
            .commit()

    }

    fun showEspecialidades(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frContenido, especialidadFragment)
            .addToBackStack(null) // Permite regresar con el botón Atrás
            .commit()
    }

    fun showAcercaDe(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frContenido, acercaDeFragment)
            .addToBackStack(null) // Permite regresar con el botón Atrás
            .commit()
    }

}