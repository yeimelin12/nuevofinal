package com.example.myapplication2project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication2project.databinding.ActivityMainBinding
import com.example.myapplication2project.databinding.ActivityTasksBinding
import com.example.myapplication2project.viewmodel.episodateviewmodel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class tasks : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityTasksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

       val viewModel = ViewModelProvider(this).get(episodateviewmodel::class.java)




    }

}