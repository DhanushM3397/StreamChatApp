package com.example.stremchatsdk.activity.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.stremchatsdk.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var fAuth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding
    private lateinit var email: String
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        fAuth = FirebaseAuth.getInstance()

        binding.btSignUp.setOnClickListener {
            val intent = Intent(this, SingUp::class.java)
            startActivity(intent)
        }

        binding.btLogin.setOnClickListener {
            if (binding.etUserName.text.toString() == "" || binding.etUserPassword.text.toString() == "") {
                if (binding.etUserName.text.toString() == "") {
                    binding.etUserName.error = "Please Enter the Email .."
                } else {
                    email = binding.etUserName.text.toString()
                }
                if (binding.etUserPassword.text.toString() == "") {
                    binding.etUserName.error = "Please Enter the Email .."
                } else {
                    password = binding.etUserPassword.text.toString()
                }
            } else {
                email = binding.etUserName.text.toString()
                password = binding.etUserPassword.text.toString()
                login(email, password)
            }


        }

    }

    private fun login(email: String, password: String) {

        if (fAuth != null) {
            (fAuth.signInWithEmailAndPassword(email, password))
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "USer DoesNot Exist ", Toast.LENGTH_SHORT).show()

                    }
                }
        } else {

        }
    }


}