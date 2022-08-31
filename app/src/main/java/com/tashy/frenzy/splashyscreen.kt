package com.tashy.frenzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class splashyscreen : AppCompatActivity() {
    lateinit var handler : Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashyscreen)
        handler= Handler()
        handler.postDelayed({
            val intent= Intent(this,welcome_Activity::class.java)
            startActivity(intent)
            finish()
        },3000)// three seconds delay to open main activity
    }
}