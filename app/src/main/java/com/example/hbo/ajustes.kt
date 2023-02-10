package com.example.hbo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hbo.databinding.ActivityAjustesBinding
import com.example.hbo.databinding.ActivityMainBinding

class ajustes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajustes)

        val binding = ActivityAjustesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.volverajustes.setOnClickListener() {
            val intent = Intent(this@ajustes, MainActivity::class.java)
            startActivity(intent)
        }

    }
}