package com.tashy.frenzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class profile_Activity : AppCompatActivity() {

    var button:Button?=null
    var imageView : ImageView ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        button=findViewById(R.id.btnp)
        imageView=findViewById(R.id.img_save)
        imageView!!.setOnClickListener {
          pickImageGallery()

         button!!.setOnClickListener {
              val intent = Intent(this,MainActivity2::class.java)
              startActivity(intent)
          }
        }
    }
    private fun pickImageGallery() {
            val intent = Intent(Intent.ACTION_PICK)
           intent.type="image/*"
      startActivityForResult(intent,100)
        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK){
            imageView?.setImageURI(data?.data)

        }
    }
    }

