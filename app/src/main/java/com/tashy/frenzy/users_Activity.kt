package com.tashy.frenzy

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageButton
import androidx.core.app.ActivityCompat
import com.google.firebase.auth.FirebaseAuth
import java.util.jar.Manifest

class users_Activity : AppCompatActivity() {
    var send:ImageButton ?=null
    var camera:ImageButton ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        send=findViewById(R.id.imgb)
        send=findViewById(R.id.cam)

        send !!.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:0112873941")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "The SMS text")
            startActivity(intent)
            camera!!.setOnClickListener {
                val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(takePictureIntent, 1)

            }

    }
}}

