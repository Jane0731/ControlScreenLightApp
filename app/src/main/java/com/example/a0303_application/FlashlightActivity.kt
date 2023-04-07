package com.example.a0303_application


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.a0303_application.databinding.ActivityFlashlightBinding

class FlashlightActivity : AppCompatActivity() {
    private lateinit var binding:ActivityFlashlightBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFlashlightBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}

