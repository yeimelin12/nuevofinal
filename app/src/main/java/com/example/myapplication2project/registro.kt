package com.example.myapplication2project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.example.myapplication2project.databinding.ActivityRegistroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.*
import java.util.regex.Pattern
import android.app.Activity
import android.content.Intent
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth


class registro : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityRegistroBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth




        binding.register.setOnClickListener{
            val emaill = binding.emailadd.text.toString()
            val pass = binding.Password.text.toString()
            val valpass = binding.reppassword.text.toString()

            val pastipe = Pattern.compile("^"+

                    ".{6,}"+
                    "$"
            )


            if (emaill.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(emaill).matches()){
                Toast.makeText(baseContext, "Ingrese un correo valido",
                    Toast.LENGTH_SHORT).show()
            }
            else if (pass.isEmpty()||!pastipe.matcher(pass).matches()){
                Toast.makeText(baseContext, "La contrasena es debil",
                    Toast.LENGTH_SHORT).show()
            }

            else if (pass != valpass){
                Toast.makeText(baseContext, "Confirmar la contrasena",
                    Toast.LENGTH_SHORT).show()
            }
            else{
                createaccount(emaill, pass)
            }

        }
    }


    private fun createaccount (
        email: String,
        password: String,

    ){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    Toast.makeText(this,"Datos guardados", Toast.LENGTH_SHORT).show()
                    MainActivity()


                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }
            }
    }

    private fun reload(){
        val intent = Intent(this, MainActivity::class.java)
        this.startActivity(intent)
    }

}