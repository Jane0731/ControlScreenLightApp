package com.example.a0303_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import com.example.a0303_application.databinding.ActivityDatepickerBinding
import com.example.a0303_application.databinding.ActivityNotificationBinding
import java.util.*

class DatepickerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDatepickerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDatepickerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val picker:DatePicker=binding.datePicker
        val today=Calendar.getInstance()
        picker.init(today.get(Calendar.YEAR),today.get(Calendar.MONTH),today.get(Calendar.DAY_OF_MONTH)){
            view,year,month,day->
            val month=month+1
            Toast.makeText(this,"你選擇的日期為：$year/$month/$day",Toast.LENGTH_SHORT).show()
        }
    }
}