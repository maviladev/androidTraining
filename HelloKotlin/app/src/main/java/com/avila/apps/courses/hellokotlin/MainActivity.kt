package com.avila.apps.courses.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    var tts: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tts = TextToSpeech(this, this)

        findViewById<Button>(R.id.btnPlay).setOnClickListener { speak() }
    }

    private fun speak(){
        var tvText = findViewById<TextView>(R.id.etMessage).text.toString()

        if (tvText.isEmpty()){
            Toast.makeText(this, "Ingresar un mensaje", Toast.LENGTH_SHORT).show()
        }

        tts!!.speak(tvText, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS){
            findViewById<TextView>(R.id.tvStatus).text = "¡Listo!"
            tts!!.language = Locale("ES")
        } else {
            findViewById<TextView>(R.id.tvStatus).text = "No disponible :("
        }

    }

    override fun onDestroy() {
        if (tts != null){
            tts!!.stop()
            tts!!.shutdown()
        }

        super.onDestroy()
    }
}