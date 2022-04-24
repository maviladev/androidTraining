package com.avila.apps.courses.lifecycle

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    val TAG = "LIFECYCLE-MainActivity"

    private var mediaPlayer: MediaPlayer? = null
    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "onCreate")


        findViewById<MaterialButton>(R.id.btnCheck).setOnClickListener {
            startActivity(Intent(this, Dialog::class.java))
        }

    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")

        mediaPlayer = MediaPlayer.create(this, R.raw.alarma_picoro)

    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
        mediaPlayer?.seekTo(position)
        mediaPlayer?.start()
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")

        mediaPlayer?.pause()
        if (mediaPlayer != null)
            position = mediaPlayer!!.currentPosition

    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")

        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }


}