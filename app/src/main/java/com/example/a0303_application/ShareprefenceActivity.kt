package com.example.a0303_application

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.a0303_application.databinding.ActivityDatepickerBinding
import com.example.a0303_application.databinding.ActivityShareprefenceBinding

class ShareprefenceActivity : AppCompatActivity() {
    private lateinit var imageSource:ImageView
    private lateinit var countString:TextView
    private lateinit var binding: ActivityShareprefenceBinding
    private lateinit var clickButton:Button
    private var count:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShareprefenceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        readData()
        countString=binding.countValue
        countString.setText(count.toString())
        imageSource=binding.imageView
        clickButton=binding.button2
        clickButton.setOnClickListener{
            count+=1
            saveData(count)
            countString.setText(count.toString())
            if(count>=5){
                imageSource.setImageResource(R.drawable.a2)
            }
        }

    }
    private fun readData() {
        count = getSharedPreferences("Data",0).getInt("Count", 0)
    }

    private fun saveData(count:Int) {
        val sharPref=getSharedPreferences("Data",0)
        sharPref.edit()
            .putInt("Count",count)
            .apply()
    }
}