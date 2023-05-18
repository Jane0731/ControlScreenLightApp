package com.example.a0303_application

import android.content.Intent
import android.media.AudioManager
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.example.a0303_application.databinding.ActivityMusicListBinding
import java.io.File

class MusicListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMusicListBinding
    var musicList:Array<File> = arrayOf()
    private lateinit var musicSeekBar:SeekBar
    private var mp:MediaPlayer= MediaPlayer()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMusicListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        musicSeekBar=binding.seekBar2
        val listView=binding.music
        val path:String=intent.getStringExtra("path").toString()
        val root=File(path+"/Music")
        val fileAndFolders:Array<File> =root?.listFiles()
        for (item in fileAndFolders){
            musicList=musicList.plus(item)
        }
        val adapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,musicList)
        listView.adapter=adapter
        listView.onItemClickListener=object: AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                startSong(musicList[p2].toString())
            }
        }
        binding.stop.setOnClickListener {
            stopSong()
        }
        musicSeekBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                if(p2){
                    mp?.seekTo(p1)
                }
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

    }

    private fun stopSong() {
        if(mp!!.isPlaying){
            mp!!.stop()
            mp!!.reset()
            mp!!.release()
        }
    }

    private fun startSong(path:String){
        mp?.setAudioStreamType(AudioManager.STREAM_MUSIC)
        try {
            mp!!.setDataSource(path)
            mp!!.prepare()
            mp!!.start()
            initSeekBar()
        }
        catch (ex:Exception){
            Log.d("error","失敗")
        }
    }
    private fun initSeekBar(){
        musicSeekBar.max=mp!!.duration
        var handler=Handler()
        handler.postDelayed(object :Runnable{
            override fun run() {
                try{
                    musicSeekBar.progress=mp!!.currentPosition
                    handler.postDelayed(this,1000)
                }
                catch (ex:Exception){
                    musicSeekBar.progress=0
                }
            }

        },0)
    }

}