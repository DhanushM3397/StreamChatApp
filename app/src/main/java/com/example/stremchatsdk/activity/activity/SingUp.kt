package com.example.stremchatsdk.activity.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stremchatsdk.databinding.ActivitySingUpBinding
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.stremchatsdk.activity.User


import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class SingUp : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var binding: ActivitySingUpBinding
    private  lateinit var mDbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        mAuth= FirebaseAuth.getInstance()

        binding.button2.setOnClickListener{

            val email = binding.SignUserEmail.text?.toString()!!.trim()
            val password = binding.SignUserPassword.text?.toString()!!
            val name= binding.SignUserName.text?.toString()!!
             Toast.makeText(this,"User name is $name,User password is $password,User Email  is $email",Toast.LENGTH_SHORT).show()

            singup(name ,email, password)
        }

    }


    private fun singup(name:String,email: String, password: String) {

        // Logic  of Creating User
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // firebase Real database
                    addUserToDatabase(name,email,mAuth.currentUser!!.uid)
                    binding.progressBar.isVisible=false
                    // Code For Jumping to Home

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)



                } else {
                    binding.progressBar.isVisible=true
                    Toast.makeText(this, "Some Error Occurred ", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun addUserToDatabase(name: String, email: String, uid: String) {

       mDbRef=FirebaseDatabase.getInstance().reference
        mDbRef.child("user").child(uid).setValue(User(name,email,uid))


    }
}