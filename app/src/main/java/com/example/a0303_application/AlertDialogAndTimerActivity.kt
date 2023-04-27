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

        val timer =object : CountDownTimer(30000, 1000) {

            override fun onFinish() {
                AlertDialog.Builder(this@AlertDialogAndTimerActivity)
                    .setMessage("倒數結束")
                    .setTitle("倒數通知")
                    .setPositiveButton("ok",null)
                    .show()
            }

            override fun onTick(millisUntilFinished: Long) {
                timerCount.setText("${millisUntilFinished/1000}")
            }
        }
        binding.startTimer.setOnClickListener {timer.start()}
    }
}