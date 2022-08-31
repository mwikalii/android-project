package com.tashy.frenzy

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class userAdapter (private val context: Activity,private  val arrayList:ArrayList<user>):ArrayAdapter<user>(
    context,R.layout.activity_main2,arrayList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater:LayoutInflater=LayoutInflater.from(context)
        val view:View=inflater.inflate(R.layout.activity_main2,null)
        val imageview:ImageView=view.findViewById(R.id.imgh)
        val username:TextView=view.findViewById(R.id.TXTY)
        val lastmessagetym:TextView=view.findViewById(R.id.rtr)


        imageview.setImageResource(arrayList[position].imageid)
        username.text=arrayList[position].name
        lastmessagetym.text=arrayList[position].lastmessage
        return view

        return super.getView(position, convertView, parent)
    }
}