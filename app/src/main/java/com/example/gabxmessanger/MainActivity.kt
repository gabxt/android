package com.example.gabxmessanger

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.gabxmessanger.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.registerButtonRegister.setOnClickListener {

            preformRegister()

        }

        binding.allreadyHaveAccountTextView.setOnClickListener {

            //A login activityre váltás
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.kepRegisterButton.setOnClickListener {

        }

    }

    private fun preformRegister() {
        val email = binding.emailEdittextRegister.text.toString()
        val password = binding.passwordEdittextRegister.text.toString()

        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Add meg az email címed és a jelszavad", Toast.LENGTH_SHORT).show()
            return
        }

        Log.d("MainActivity", "Email :" +email)
        Log.d("MainActivity", "Password : $password")

        //firebase authentication to create a user with email and password
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful)

                //else if successfull
                    Log.d("Main", "Sikeresen elkészült a regisztráció: ${it.result.user!!.uid}")
                Toast.makeText(this, "Sikeresen elkészült a regisztráció:", Toast.LENGTH_SHORT).show()

                return@addOnCompleteListener
            }
            .addOnFailureListener {
                Log.d("Main", "Nem ssikerült a regisztráció: ${it.message}")
                Toast.makeText(this, "Nem ssikerült a regisztráció:", Toast.LENGTH_SHORT).show()
                return@addOnFailureListener
            }
    }
 }