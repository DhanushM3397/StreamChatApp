package com.example.stremchatsdk.activity.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.stremchatsdk.R
import com.example.stremchatsdk.activity.User
import com.example.stremchatsdk.activity.adapter.UserAdapter
import com.example.stremchatsdk.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    private  lateinit var  userlist:ArrayList<User>
    private  lateinit var  binding:ActivityMainBinding
    private  lateinit var  adapter: UserAdapter
    private  lateinit var  mAuth: FirebaseAuth
    private  lateinit var mDbRef:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        mAuth= FirebaseAuth.getInstance()
        mDbRef=FirebaseDatabase.getInstance().reference

        setContentView(binding.root)
        userlist=ArrayList<User>()
        adapter=UserAdapter(this,userlist)

        // this creates a vertical layout Manager
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter=adapter

        mDbRef.child("user").addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                userlist.clear()
                for (item in snapshot.children){
                    val  currentUser = item.getValue(User::class.java)
                    if (currentUser != null) {
                        userlist.add(currentUser)
                    }
                }

                adapter.notifyDataSetChanged()





            }

            override fun onCancelled(error: DatabaseError) {

            }
        }

        )


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.logout){
            mAuth.signOut()
            val intent1 = Intent(this, Login::class.java)
            finish()
            startActivity(intent1)
            return true
        }
    return true
    }
}