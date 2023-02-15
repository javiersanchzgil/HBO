package com.example.hbo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hbo.databinding.ActivityIniciosesionBinding
import com.example.hbo.databinding.ActivityMainBinding

class iniciosesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciosesion)

        val binding = ActivityIniciosesionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.volverajustes.setOnClickListener() {
            val intent = Intent(this@iniciosesion, MainActivity::class.java)
            startActivity(intent)
        }

        if (binding.escribircorreo.text.toString().isEmpty() && binding.escribircontraseA.text.toString().isEmpty()) {
            binding.botonIniciarSesion.isEnabled = false
            }

        binding.botonIniciarSesion.setOnClickListener() {
            val intent = Intent(this@iniciosesion, MainActivity::class.java)
            startActivity(intent)
        }


        }

    }
