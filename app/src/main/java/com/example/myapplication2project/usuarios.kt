package com.example.myapplication2project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication2project.databinding.ActivityMainBinding
import com.example.myapplication2project.databinding.ActivityUsuariosBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase

class usuarios : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityUsuariosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUsuariosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        updateUI()

        binding.guardarusu.setOnClickListener{

            val ape =binding.apellido.text.toString()

            actualizarperfil(ape)

        }
    }

    private fun actualizarperfil( apellido:String){

        val user = auth.currentUser

        val actualizar = userProfileChangeRequest {

            displayName = apellido



        }

        user!!.updateProfile(actualizar)
            .addOnCompleteListener{task ->
                if (task.isSuccessful){
                    Toast.makeText(baseContext,"Cambios guardados",
                    Toast.LENGTH_SHORT).show()
                    updateUI()
                }

            }

    }

    private fun updateUI(){
        val user = auth.currentUser
        //val usern = auth.currentUser
        val usera = auth.currentUser
        val userc = auth.currentUser


        if (user != null && usera!=null && userc!=null ){
            binding.emaill.text = user.email
            binding.celularl.text= user.displayName
            //binding.apellidol.text= usera.displayName




        }
    }
}