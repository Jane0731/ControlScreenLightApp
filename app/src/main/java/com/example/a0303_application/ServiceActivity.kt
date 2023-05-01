package com.example.a0303_application

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import com.example.a0303_application.databinding.ActivityServiceBinding

class ServiceActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var binding: ActivityServiceBinding
    private lateinit var sensorManager: SensorManager
    private lateinit var lightText: TextView
    private var light: Sensor?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lightText=binding.lightValue
        sensorManager=getSystemService(Context.SENSOR_SERVICE) as SensorManager
        light=sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
        sensorManager.registerListener(this,light,SensorManager.SENSOR_DELAY_GAME)
    }

    override fun onSensorChanged(p0: SensorEvent) {
        val lightValue= p0.values[0]
        lightText.text=lightValue.toString()
        if (lightValue<=100) startService(Intent(this@ServiceActivity,MyService::class.java))
        else stopService(Intent(this@ServiceActivity,MyService::class.java))
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }
}