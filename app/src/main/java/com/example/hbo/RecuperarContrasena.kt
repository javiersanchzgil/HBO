package com.example.hbo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hbo.databinding.ActivityIniciosesionBinding
import com.example.hbo.databinding.ActivityRecuperarContrasenaBinding

class RecuperarContrasena : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar_contrasena)

        val binding = ActivityRecuperarContrasenaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.volverRecuContra.setOnClickListener() {
            val intent = Intent(this@RecuperarContrasena, MainActivity::class.java)
            startActivity(intent)


        }


    }
}