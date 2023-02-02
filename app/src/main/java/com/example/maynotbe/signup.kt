package com.example.maynotbe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.maynotbe.R.layout.activity_signup
import com.google.firebase.auth.FirebaseAuth

class signup : AppCompatActivity() {
lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
firebaseAuth= FirebaseAuth.getInstance()
        val btnSignUp=findViewById<Button>(R.id.signUpButton).setOnClickListener {
            signUpUser()
        }

    }
    private fun signUpUser(){
        val email=findViewById<EditText>(R.id.etEmailSUp).text.toString()
        val password=findViewById<EditText>(R.id.etPasswordSup).text.toString()
        val confirmPassword=findViewById<EditText>(R.id.etconfirmPasswordSup).text.toString()

        if(email.isBlank() || password.isBlank() || confirmPassword.isBlank()){
            Toast.makeText(this, "Email and password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }

        if( password!= confirmPassword){
            Toast.makeText(this, "password and confirm password do not match", Toast.LENGTH_SHORT).show()
            return
        }


        firebaseAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this) {
                if (it.isSuccessful){
                    Toast.makeText(this, "Sign Up successful", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "Error creating user", Toast.LENGTH_SHORT).show()
                }
            }



    }
}