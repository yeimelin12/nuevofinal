package com.example.myapplication2project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication2project.databinding.ActivityContrasenaolvidadaBinding
import com.example.myapplication2project.databinding.ActivityTasksBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Contrasenaolvidada : AppCompatActivity() {

    private lateinit var binding: ActivityContrasenaolvidadaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContrasenaolvidadaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.enviar.setOnClickListener{
            val emailla = binding.email2.text.toString()
            Firebase.auth.sendPasswordResetEmail(emailla).addOnCompleteListener{ Task ->
                if (Task.isSuccessful){
                    val intent = Intent(this,MainActivity::class.java)
                    this.startActivity(intent)

                }else{
                    Toast.makeText(this,"Ingrese una cuenta valida",
                    Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}