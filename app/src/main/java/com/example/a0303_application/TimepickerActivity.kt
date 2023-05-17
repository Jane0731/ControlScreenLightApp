package com.example.a0303_application

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker
import android.widget.Toast
import com.example.a0303_application.databinding.ActivityTimepickerBinding
import java.util.*

class TimepickerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTimepickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimepickerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val picker: TimePicker =binding.timePicker
        val today=Calendar.getInstance()
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            picker.hour=today.get(Calendar.HOUR_OF_DAY)
            picker.minute=today.get(Calendar.MINUTE)
        }else{
            picker.currentHour=5
            picker.currentMinute=16
        }
        picker.setOnTimeChangedListener{view,hourOfDay,minute->
            Toast.makeText(this,"你選擇的時間為：$hourOfDay:$minute",Toast.LENGTH_SHORT).show()
        }
    }
}