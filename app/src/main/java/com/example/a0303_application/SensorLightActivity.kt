package com.example.a0303_application

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.a0303_application.databinding.ActivityScreenLightBinding
import com.example.a0303_application.databinding.ActivitySensorLightBinding

class SensorLightActivity : AppCompatActivity(),SensorEventListener {
    private lateinit var binding: ActivitySensorLightBinding
    private lateinit var sensorManager:SensorManager
    private var light:Sensor?=null
    private lateinit var lightText:TextView
    private lateinit var lightProgressbar:ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySensorLightBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onSensorChanged(p0: SensorEvent) {

    }

    override fun onAccuracyChanged(p0: Sensor, p1: Int) {
    }

    private fun setScreenLight(lightValue:Float){
        val lp = window.attributes
        //screenBrightness的值範圍為0~1 單位為float
        lp.screenBrightness = java.lang.Float.valueOf(lightValue)
        window.attributes = lp
    }
}