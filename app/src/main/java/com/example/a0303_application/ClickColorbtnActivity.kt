package com.example.a0303_application

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.a0303_application.databinding.ActivityClickColorbtnBinding

class ClickColorbtnActivity : AppCompatActivity() {
    val colorsImage = intArrayOf(R.drawable.red, R.drawable.green,R.drawable.blue,R.drawable.yellow)
    val colors= intArrayOf(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW)
    private lateinit var iv: ImageView
    private lateinit var binding:ActivityClickColorbtnBinding
    private lateinit var redButton: Button
    private lateinit var blueButton: Button
    private lateinit var timerCount:TextView
    val randInt= intArrayOf(0,1,2,3)
    var a=0
    var isFinish=false
    var isBegin=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClickColorbtnBinding.inflate(layoutInflater)
        setContentView(binding.root)
        iv=binding.imageView
        redButton=binding.button
        timerCount=binding.second
        blueButton=binding.button2

        val timer =object : CountDownTimer(10000, 1000) {
            override fun onFinish() {
                isFinish=true

                AlertDialog.Builder(this@ClickColorbtnActivity)
                        .setMessage("倒數結束")
                        .setTitle("倒數通知")
                        .setPositiveButton("ok",null)
                        .show()
            }



            override fun onTick(millisUntilFinished: Long) {
                timerCount.setText("剩餘秒數：${millisUntilFinished/1000}")
            }
        }


        binding.begin.setOnClickListener{
            timer.start()
            isBegin=true
            setColor()
        }
        redButton.setOnClickListener{
            if(isBegin){
                if((a==0) or (a==2)){
                    Toast.makeText(this,"答對",Toast.LENGTH_SHORT).show()
                    setColor()
                }
                else{
                    Toast.makeText(this,"答錯",Toast.LENGTH_SHORT).show()

                }
            }
        }
        blueButton.setOnClickListener{
            if(isBegin){
                if((a==1) or (a==3)){
                    Toast.makeText(this,"答對",Toast.LENGTH_SHORT).show()
                    setColor()
                }
                else{
                    Toast.makeText(this,"答錯",Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
    fun setColor(){
        a=randInt.random()
        iv.setImageResource(colorsImage[a])
        redButton.setTextColor(colors[randInt.random()])
        blueButton.setTextColor(colors[randInt.random()])
    }

}