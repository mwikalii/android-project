
package com.tashy.frenzy

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    //declare variables
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Firebase Auth

        auth = FirebaseAuth.getInstance()

        val loginText:Button= findViewById(R.id.btn_l)
        loginText!!.setOnClickListener {
            val intent = Intent(this,loginActivity::class.java)
            startActivity(intent)
        }

        val registerButton:Button = findViewById(R.id.btnr)

        registerButton.setOnClickListener {
            performSignUp()
        }
        //lets get emails and password from users

    }

    private fun performSignUp() {
        val name=findViewById<EditText>(R.id.mtvn)
        val email= findViewById<EditText>(R.id.mtve)
        val password= findViewById<EditText>(R.id.mtvpass1)


        if (email.text.isEmpty() || password.text.isEmpty() || name.text.isEmpty() ){
            Toast.makeText(this,"Please fill all the fields",
                Toast.LENGTH_SHORT).show()
            return
        }
        val inputName = name.text.toString()
        val inputEmail = email.text.toString()
        val inputPassword = password.text.toString()

        auth.createUserWithEmailAndPassword(inputEmail,inputPassword)


            .addOnCompleteListener(this) { task ->

                if (task.isSuccessful) {
                    // Sign in success, lets move on to next activity i.e main activity

                    val intent = Intent(this,profile_Activity::class.java)
                    startActivity(intent)
                    Toast.makeText(baseContext, "Success",
                        Toast.LENGTH_SHORT).show()
                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }
            }
            .addOnFailureListener {
                Toast.makeText(this,"Error occurred ${it.localizedMessage}"
                    ,Toast.LENGTH_SHORT).show()
            }
    }}
