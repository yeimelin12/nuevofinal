package com.example.myapplication2project

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication2project.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth



        binding.login.setOnClickListener{
            val emaill = binding.email.text.toString()
            val passw = binding.contrasena.text.toString()


            when {
                emaill.isEmpty() ||  passw.isEmpty() -> {

                    Toast.makeText(
                        baseContext, "No hay nada en los campos",
                        Toast.LENGTH_SHORT
                    ).show()
                  reload()
                }else -> {
                singin(emaill,passw)

                }

            }

        }
        binding.registrarse.setOnClickListener{
            val intent = Intent(this, registro::class.java)
            startActivity(intent)
        }

        binding.olvido.setOnClickListener(){
            val intent = Intent(this, Contrasenaolvidada::class.java)
            startActivity(intent)
        }

    }



    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
            //reload();
        }
    }
    private  fun  singin(email:String,password: String)
    {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("TAG", "signInWithEmail:success")
                    val intent = Intent(this, menu::class.java)
                    startActivity(intent)



                } else {
                    // If sign in fails, display a message to the user.
                        Log.w("TAG","signInWithEmail:notsuccess")
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    reload()
                }
            }
    }

    private fun reload(){
        val intent = Intent(this, MainActivity::class.java)
        this.startActivity(intent)
    }





}