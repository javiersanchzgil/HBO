package com.example.hbo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hbo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Boton para acceder a los ajustes
        binding.ajustes.setOnClickListener() {
            val intent = Intent(this@MainActivity, ajustes::class.java)
            startActivity(intent)
        }

        //Boton para acceder a la pantalla de iniciar sesion
        binding.usuario.setOnClickListener(){
            val intent = Intent(this@MainActivity, iniciosesion::class.java)
            startActivity(intent)
        }

        //Boton para acceder a la pantalla para conectar a un dispositivo
        binding.tele.setOnClickListener() {
            val intent = Intent(this@MainActivity, ConectarTele::class.java)
            startActivity(intent)
        }

    }
}