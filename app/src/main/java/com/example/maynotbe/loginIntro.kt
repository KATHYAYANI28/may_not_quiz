package com.example.maynotbe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class loginIntro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_intro)
        val auth=FirebaseAuth.getInstance()
        if(auth.currentUser !=null){
            Toast.makeText(this, "User is already logged in", Toast.LENGTH_SHORT).show()
            redirect("MAIN")
        }
    val btnGetStarted= findViewById<Button>(R.id.GetStartedbtn).setOnClickListener{
        redirect("LOGIN")
    }

    }
    private fun redirect(name:String){
        val intent=when(name){
            "LOGIN"->Intent(this,login::class.java)
            "MAIN"->Intent(this,MainActivity::class.java)
            else -> throw java.lang.Exception("no path exists")
        }
        startActivity(intent)
        finish()
    }
}