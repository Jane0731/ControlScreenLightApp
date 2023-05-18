package com.example.a0303_application

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.storage.StorageManager
import android.os.storage.StorageVolume
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.getSystemService
import com.example.a0303_application.databinding.ActivityMusicBinding
import java.io.BufferedReader
import java.io.File
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.file.Files
import java.nio.file.Paths

class MusicActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMusicBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.gerPermission.setOnClickListener{
            if(checkPermission()){
                val i= Intent(this,MusicListActivity::class.java)
                val path:String=Environment.getExternalStorageDirectory().path
                i.putExtra("path",path)
                startActivity(i)
            }
            else{
                requestPermission()
            }
        }

    }
    private fun checkPermission():Boolean{
        val result=ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if(result==PackageManager.PERMISSION_GRANTED){
            return true
        }
        else{
            return false
        }
    }
    private fun requestPermission(){
        if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            Toast.makeText(this,"請同意存取權限",Toast.LENGTH_SHORT).show()
        }
        ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),111)
    }

}