package com.example.a0303_application

import android.app.Service
import android.content.Context
import android.content.Intent
import android.hardware.camera2.CameraManager
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.provider.Settings
import android.util.Log
import androidx.annotation.RequiresApi

class MyService : Service() {
    private lateinit var cameraM: CameraManager

    override fun onCreate() {
        super.onCreate()
        cameraM=getSystemService(Context.CAMERA_SERVICE) as CameraManager
    }
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        setFlashLightOnOrOff(true)
        return  START_STICKY
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onDestroy() {
        super.onDestroy()
        setFlashLightOnOrOff(false)
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
    @RequiresApi(Build.VERSION_CODES.M)
    private fun setFlashLightOnOrOff(isFlash:Boolean){
        val cameraListId=cameraM.cameraIdList[0]
        cameraM.setTorchMode(cameraListId,isFlash)
    }
}