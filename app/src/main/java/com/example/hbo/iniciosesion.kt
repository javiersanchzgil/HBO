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

        //Llamada a la funcion setup
        setup()


    }

    private fun setup() {
        title = "Autenticación"
        val binding = ActivityIniciosesionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Boton para poder registrarse en la aplicacion con firebase
        binding.botonRegistrarse.setOnClickListener {
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

        //Boton para poder iniciar sesion en la aplicacion con firebase
        binding.botonIniciarSesion.setOnClickListener {
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
        //Boton para volver a la pantalla principal
        binding.volverajustes.setOnClickListener() {
            val intent = Intent(this@iniciosesion, MainActivity::class.java)
            startActivity(intent)
        }


        //boton para poder acceder a la pantalla de recuperar contraseña
        binding.olvidarContra.setOnClickListener() {
            val intent = Intent(this@iniciosesion, RecuperarContrasena::class.java)
            startActivity(intent)
        }

    }

        //funcion showHome para lanzar una alrta en caso de que el usuario no se haya podido registrar o iniciar sesion
    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    //funcion showHome para lanzar el email del usuario y el tipo de proveedor que ha utilizado para iniciar sesion
    private fun showHome(email: String, provider: ProviderType) {
        val homeIntent: Intent = Intent(this, MainActivity::class.java).apply {
            putExtra("email", email)
            putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }


}
