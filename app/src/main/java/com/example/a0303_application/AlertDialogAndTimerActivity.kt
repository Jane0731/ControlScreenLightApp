package com.example.a0303_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.a0303_application.databinding.ActivityAlertDialogAndTimerBinding
import com.example.a0303_application.databinding.ActivityFlashlightBinding

class AlertDialogAndTimerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlertDialogAndTimerBinding
    private lateinit var timerCount:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAlertDialogAndTimerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        timerCount=binding.info

        
    }
}