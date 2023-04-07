package com.example.a0303_application

import android.content.Context
import android.hardware.ConsumerIrManager
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import com.example.a0303_application.databinding.ActivityFlashlightBinding

class FlashlightActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFlashlightBinding
    private lateinit var cameraM:CameraManager
    private lateinit var spinnerF:Spinner
    private lateinit var spinnerS:Spinner
    var frequency=1
    var second=5
    var isFlash=false
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFlashlightBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cameraM=getSystemService(Context.CAMERA_SERVICE) as CameraManager
        binding.lightSwitch.setOnCheckedChangeListener{ _ , isChecked ->
            setFlashLightOnOrOff()
        }
        spinnerF=binding.frequencySpinner
        ArrayAdapter.createFromResource(
            this,
            R.array.frequency_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerF.adapter = adapter
        }
        spinnerF.onItemSelectedListener=object:AdapterView.OnItemSelectedListener,
            AdapterView.OnItemClickListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when (p2) {
                    0 -> frequency=1
                    1 -> frequency=2
                    2 -> frequency=3
                    3 -> frequency=4
                    4 -> frequency=5
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }
        }
        spinnerS=binding.secondSpinner
        ArrayAdapter.createFromResource(
            this,
            R.array.second_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinnerS.adapter = adapter
        }
        spinnerS.onItemSelectedListener=object:AdapterView.OnItemSelectedListener,
            AdapterView.OnItemClickListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when (p2) {
                    0 -> second=5
                    1 -> second=10
                    2 -> second=20
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            }
        }
        binding.button.setOnClickListener{
            setFlashLightFrequency(frequency,second)
        }

    }
    @RequiresApi(Build.VERSION_CODES.M)
    private fun setFlashLightOnOrOff(){
        val cameraListId=cameraM.cameraIdList[0]
        if(!isFlash){
            cameraM.setTorchMode(cameraListId,true)
            isFlash=true
        }
        else{
            cameraM.setTorchMode(cameraListId,false)
            isFlash=false
        }
    }
    @RequiresApi(Build.VERSION_CODES.M)
    private fun setFlashLightFrequency(frequency:Int, second:Int){
        val cameraListId=cameraM.cameraIdList[0]
        val sleepSecond:Long=1000/frequency.toLong()/2
        for (i in 1..second*frequency){
            cameraM.setTorchMode(cameraListId,true)
            Thread.sleep(sleepSecond)
            cameraM.setTorchMode(cameraListId,false)
            Thread.sleep(sleepSecond)
        }
    }
}

