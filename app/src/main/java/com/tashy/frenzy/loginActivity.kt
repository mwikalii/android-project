package com.tashy.frenzy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class loginActivity:AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_fragment)

        auth = FirebaseAuth.getInstance()



        val loginButton: Button = findViewById(R.id.btnl)
        loginButton!!.setOnClickListener {
            performLogin()
        }
        //let do login now
        //first we add a login button

    }

    private fun performLogin() {

        //lets get input from the user
        val email : EditText =findViewById(R.id.mtvemail)
        val password : EditText = findViewById(R.id.mtvpass)

        //null checks on input
        if(email.text.isEmpty() || password.text.isEmpty()){
            Toast.makeText(this,"Please fill all the fields",
                Toast.LENGTH_SHORT).show()
            return
        }
        val emailInput = email.text.toString()
        val passwordInput = password.text.toString()
        auth .signInWithEmailAndPassword(emailInput,passwordInput)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, navigate to the main activity
                    val intent = Intent(this,profile_Activity::class.java)
                    startActivity(intent)
                    Toast.makeText(baseContext, "Success",
                        Toast.LENGTH_SHORT).show()
                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(baseContext, "Authentication failed: "+task.exception!!.message,
                        Toast.LENGTH_SHORT).show()
            }
    }
}
}