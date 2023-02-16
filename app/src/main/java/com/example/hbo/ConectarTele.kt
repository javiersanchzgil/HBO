package com.example.hbo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hbo.databinding.ActivityConectarTeleBinding
import com.example.hbo.databinding.ActivityIniciosesionBinding

class ConectarTele : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conectar_tele)

        val binding = ActivityConectarTeleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.volverRecuContra.setOnClickListener() {
            val intent = Intent(this@ConectarTele, MainActivity::class.java)
            startActivity(intent)
        }

        binding.botonConectar.setOnClickListener() {
            //cambiar el color del boton a verde cogiendolo de color.xml
            binding.botonConectar.setBackgroundColor(resources.getColor(R.color.green))

        }
    }
}