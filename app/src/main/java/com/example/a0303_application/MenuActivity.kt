package com.example.a0303_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MenuActivity : AppCompatActivity() {
    val menu= arrayOf("螢幕亮度功能","手電筒功能","跑馬燈")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val listView=findViewById<ListView>(R.id.menu)
        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,menu)
        listView.adapter=adapter
        listView.onItemClickListener=object:AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if(p2==0){
                    onClickScreenLight()
                }
            }
        }
    }
    private fun onClickScreenLight(){
        val i= Intent(this,ScreenLightActivity::class.java)
        startActivity(i)
    }
}