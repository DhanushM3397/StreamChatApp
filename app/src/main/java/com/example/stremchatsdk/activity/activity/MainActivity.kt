package com.example.stremchatsdk.activity.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stremchatsdk.R
import com.example.stremchatsdk.activity.User
import com.example.stremchatsdk.activity.adapter.UserAdapter
import com.example.stremchatsdk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var  userlist:ArrayList<User>
    private  lateinit var  binding:ActivityMainBinding
    private  lateinit var  adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        userlist=ArrayList<User>()
        adapter=UserAdapter(this,userlist)

    }
}