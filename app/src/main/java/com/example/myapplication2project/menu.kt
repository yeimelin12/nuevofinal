package com.example.myapplication2project


import com.example.myapplication2project.databinding.ActivityMainBinding
import com.example.myapplication2project.databinding.ActivityTasksBinding
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication2project.databinding.ActivityMenuBinding
import com.example.myapplication2project.model.tvshow
import com.example.myapplication2project.service.Episodeservice
import com.example.myapplication2project.views.tvshowlist
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class menu : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        binding.usuarper.setOnClickListener {
            val intent = Intent(this, usuarios::class.java)
            startActivity(intent)
        }

        binding.show.setOnClickListener {
            val intent = Intent(this, tasks::class.java)
            startActivity(intent)
        }






    }


}