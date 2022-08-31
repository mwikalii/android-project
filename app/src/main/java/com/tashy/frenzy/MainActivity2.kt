package com.tashy.frenzy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tashy.frenzy.databinding.ActivityMainBinding

class MainActivity2: AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var userArrayList: ArrayList<user>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageid = intArrayOf(
            R.drawable.mj, R.drawable.kl, R.drawable.ko, R.drawable.jh,
            R.drawable.mh, R.drawable.pg, R.drawable.b, R.drawable.windowgirl,
        )
        val name= arrayOf(
            "faith",
            "shanky" ,
            "valeskia",
            "herbert" ,
            "john" ,
            "iceflow" ,
            "devian"
        )
        val lastmessagetym= arrayOf(
            "7.02 am" ,"8:20am" ,"8:30am" ,"9:01am" ,"10:23am" ,"10.30am"

        )
        userArrayList=ArrayList()
        for (i in name.indices){
            val user=user(name [i],lastmessagetym [i],imageid[i])
            userArrayList.add(user)
        }
        binding.listview.isClickable=true
        binding.listview.adapter=userAdapter(this,userArrayList)
        binding.listview.setOnItemClickListener(parent,view,position,id->
        val name=name[position]
        val imageid=imageid[position]
        val intent = Intent(applicationContext,users_Activity::class.java)
        startActivity(intent)


    }
}