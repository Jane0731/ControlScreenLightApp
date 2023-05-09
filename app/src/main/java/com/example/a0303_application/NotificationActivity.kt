package com.example.a0303_application

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.service.controls.Control
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.a0303_application.databinding.ActivityNotificationBinding
import java.text.SimpleDateFormat
import java.util.*

class NotificationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotificationBinding
    private lateinit var showNotificationBtn:Button
    private companion object{
        private const val CHANNEL_ID="channel01"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showNotificationBtn=binding.showNo
        showNotificationBtn.setOnClickListener{
            showNotification()
        }
    }
    private fun showNotification(){
        createNotificationChannel()
        val vibrateEffect: LongArray = longArrayOf(3000, 3000, 3000, 3000);
        val date=Date()
        val notificationId=SimpleDateFormat("ddHHmmss", Locale.CHINESE).format(date).toInt()
        val notificationBuilder=NotificationCompat.Builder(this,"$CHANNEL_ID")
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("提醒標題")
            .setContentText("提醒內容")
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setVibrate(vibrateEffect)
        val notificationManagerCompat=NotificationManagerCompat.from(this)
        notificationManagerCompat.notify(notificationId,notificationBuilder.build())
    }
    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val name="MyNotification"
            val importance=NotificationManager.IMPORTANCE_HIGH
            val notificationChannel=NotificationChannel(CHANNEL_ID,name,importance)
            val description="My notification channel description"
            notificationChannel.description=description
            notificationChannel.enableLights(true)
            notificationChannel.lightColor=Color.RED
            val notificationManager=getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(notificationChannel)

        }
    }


}