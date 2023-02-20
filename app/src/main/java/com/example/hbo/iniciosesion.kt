package com.example.hbo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.hbo.databinding.ActivityIniciosesionBinding
import com.example.hbo.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType {
    BASIC
}

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

        if (binding.escribircorreo.text.toString()
                .isEmpty() && binding.escribircontraseA.text.toString().isEmpty()
        ) {
            binding.botonIniciarSesion.isEnabled = false
        }

        binding.botonIniciarSesion.setOnClickListener() {
            val intent = Intent(this@iniciosesion, MainActivity::class.java)
            startActivity(intent)
        }

        binding.olvidarContra.setOnClickListener() {
            val intent = Intent(this@iniciosesion, RecuperarContrasena::class.java)
            startActivity(intent)
        }

        //Setup
        setup()


    }

    private fun setup() {
        title = "Autenticación"
        val binding = ActivityIniciosesionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonIniciarSesion.setOnClickListener {
            if (binding.escribircorreo.text.isNotEmpty() && binding.escribircontraseA.text.isNotEmpty()) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.escribircorreo.text.toString(), binding.escribircontraseA.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                    } else {
                        showAlert()
                    }
                }
            }

        }

        binding.botonRegistrarse.setOnClickListener {
            if (binding.escribircorreo.text.isNotEmpty() && binding.escribircontraseA.text.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(
                    binding.escribircorreo.text.toString(), binding.escribircontraseA.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                    } else {
                        showAlert()
                    }
                }
            }

        }

    }


    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email: String, provider: ProviderType) {
        val homeIntent: Intent = Intent(this, MainActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }
}
