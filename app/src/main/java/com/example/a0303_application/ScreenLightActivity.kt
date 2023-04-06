package com.example.a0303_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import com.example.a0303_application.databinding.ActivityScreenLightBinding

class ScreenLightActivity : AppCompatActivity() {
    private lateinit var binding:ActivityScreenLightBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityScreenLightBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.seekBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                setScreenLight(p1.toFloat()/100)
                Log.d("持動","float is"+p1.toFloat()/100)
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
        binding.radioGroup.setOnCheckedChangeListener{radioGroup,i->
            if(i==R.id.radioButton){
                setScreenLight(0.0f)
            }
            else if(i==R.id.radioButton2){
                setScreenLight(0.25f)
            }
            else if(i==R.id.radioButton3){
                setScreenLight(0.50f)
            }
            else if(i==R.id.radioButton4){
                setScreenLight(0.75f)
            }
            else if(i==R.id.radioButton5){
                setScreenLight(1.0f)
            }
            else{
                //
            }
        }
    }

    private fun setScreenLight(lightValue:Float){
        val lp = window.attributes
        //screenBrightness的值範圍為0~1 單位為float
        lp.screenBrightness = java.lang.Float.valueOf(lightValue)
        window.attributes = lp
    }
}