package com.example.stremchatsdk.activity.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stremchatsdk.activity.User
import com.example.stremchatsdk.databinding.UserLayoutBinding

class UserAdapter(val context: Context, val userList: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    lateinit var binding: UserLayoutBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        binding = UserLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)

    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userList[position]
        binding.textView4.text = currentUser.name
    }

    override fun getItemCount(): Int {
        return userList.size
    }


    class UserViewHolder(binding: UserLayoutBinding) : RecyclerView.ViewHolder(binding.root)

}