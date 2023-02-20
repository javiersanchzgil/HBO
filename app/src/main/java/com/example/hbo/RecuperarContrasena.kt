package com.example.hbo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hbo.databinding.ActivityIniciosesionBinding
import com.example.hbo.databinding.ActivityRecuperarContrasenaBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

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


        binding.botonEnviarContra.setOnClickListener(){
            if (binding.escribirCorreo.text.toString().isEmpty()) {
                Snackbar.make(
                    findViewById(R.id.botonEnviarContra),
                    "Campo vacío",
                    BaseTransientBottomBar.LENGTH_LONG
                ).show()
            }
            if (binding.escribirCorreo.text.toString().isNotEmpty()) {
                binding.botonEnviarContra.setBackgroundColor(resources.getColor(R.color.black))
                binding.botonEnviarContra.text = "Enviado"
                binding.botonEnviarContra.isEnabled = false
                Snackbar.make(
                    findViewById(R.id.botonEnviarContra),
                    "Correo enviado",
                    BaseTransientBottomBar.LENGTH_LONG
                ).show()
            }

        }


    }
}