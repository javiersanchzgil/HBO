package com.example.hbo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hbo.databinding.ActivityConectarTeleBinding
import com.example.hbo.databinding.ActivityIniciosesionBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class ConectarTele : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conectar_tele)

        var flag: Int = 0


        val binding = ActivityConectarTeleBinding.inflate(layoutInflater)
        setContentView(binding.root)





        binding.volverRecuContra.setOnClickListener() {
            val intent = Intent(this@ConectarTele, MainActivity::class.java)
            startActivity(intent)
        }



        binding.botonConectar.setOnClickListener() {

            when (flag) {

                0 -> {
                    binding.botonConectar.text = "Desconectar - ROOMTV"
                    binding.botonConectar.setBackgroundColor(resources.getColor(R.color.green))
                    Snackbar.make(
                        findViewById(R.id.botonConectar),
                        "Conectado",
                        BaseTransientBottomBar.LENGTH_LONG
                    ).show()
                    flag = 1
                }

                1 -> {
                    binding.botonConectar.text = "Conectar - ROOMTV"
                    binding.botonConectar.setBackgroundColor(resources.getColor(R.color.newcolor))
                    Snackbar.make(
                        findViewById(R.id.botonConectar),
                        "Desconectado",
                        BaseTransientBottomBar.LENGTH_SHORT
                    ).show()
                    flag = 0
                }

            }


        }
    }
}