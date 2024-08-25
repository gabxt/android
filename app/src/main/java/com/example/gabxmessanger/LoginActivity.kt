package com.example.gabxmessanger

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.gabxmessanger.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity: AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButtonLogin.setOnClickListener {
            val email = binding.editTextTextEmailAddress.text.toString()
            val password = binding.editTextTextPassword.text.toString()

            Log.d("Login", "Megpróbált bejelentkezni email / jelszóval: $email/*****")
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
               // .addOnCompleteListener()
               // .add
        }

            this.binding.backToRegisterTextView.setOnClickListener {


                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }

    }
