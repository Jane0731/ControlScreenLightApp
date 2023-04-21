package com.example.a0303_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MenuActivity : AppCompatActivity() {
    val menu= arrayOf("螢幕亮度功能","手電筒功能","光感測器應用","AlertDialog及Timer的應用")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val listView=findViewById<ListView>(R.id.menu)
        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,menu)
        listView.adapter=adapter
        listView.onItemClickListener=object:AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when (p2) {
                    0 -> onClickScreenLight()
                    1 -> onClickFlashlight()
                    2 -> onClickSensorlight()
                    3 -> onClickAlertDialogAndTimer()
                }
            }
        }
    }
    private fun onClickScreenLight(){
        val i= Intent(this,ScreenLightActivity::class.java)
        startActivity(i)
    }
    private fun onClickFlashlight(){
        val i= Intent(this,FlashlightActivity::class.java)
        startActivity(i)
    }
    private fun onClickSensorlight(){
        val i= Intent(this,SensorLightActivity::class.java)
        startActivity(i)
    }
    private fun onClickAlertDialogAndTimer(){
        val i= Intent(this,AlertDialogAndTimerActivity::class.java)
        startActivity(i)
    }
}