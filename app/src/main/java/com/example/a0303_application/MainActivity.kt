package com.example.a0303_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.a0303_application.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var accEdit:EditText
    private lateinit var pwdEdit:EditText
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        accEdit=binding.acc
        pwdEdit=binding.pwd
        var loginButton:Button=binding.login
        loginButton.setOnClickListener{
            val acc=accEdit.text.toString()
            val pwd=pwdEdit.text.toString()
            clickLoginButton(acc,pwd)
        }
    }
    fun clickLoginButton(acc:String,pwd:String){
        if(acc=="user" && pwd=="12345"){
           val i= Intent(this,MenuActivity::class.java)
           i.putExtra("account",acc)
           startActivity(i)
        }
        else{
            val context=applicationContext
            val text="帳號或密碼錯誤"
            val duration=Toast.LENGTH_SHORT
            Toast.makeText(context,text, duration).show()
        }
    }

}
