package com.example.maynotbe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        firebaseAuth= FirebaseAuth.getInstance()
        val btnLogin=findViewById<Button>(R.id.loginButton).setOnClickListener {
            loginUser()
        }
       val btnSignUp=findViewById<TextView>(R.id.btnSignUp).setOnClickListener{
           val intent= Intent( this, signup::class.java)
           startActivity(intent)
           finish()
       }


    }
    private fun loginUser(){
        val email=findViewById<EditText>(R.id.etEmailSUp).text.toString()
        val password=findViewById<EditText>(R.id.etPasswordSup).text.toString()

        if(email.isBlank() || password.isBlank()){
            Toast.makeText(this, "Email and password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this) {
          if (it.isSuccessful){
              Toast.makeText(this, "login succesful", Toast.LENGTH_SHORT).show()
              val intent= Intent( this, MainActivity::class.java)
              startActivity(intent)
              finish()
          }
            else{
              Toast.makeText(this, "error logging in user", Toast.LENGTH_SHORT).show()
          }
        }
    }
}