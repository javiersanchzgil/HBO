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

        binding.ajustes.setOnClickListener() {
            val intent = Intent(this@MainActivity, ajustes::class.java)
            startActivity(intent)
        }

        binding.usuario.setOnClickListener(){
            val intent = Intent(this@MainActivity, iniciosesion::class.java)
            startActivity(intent)
        }

    }
}