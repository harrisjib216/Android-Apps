package com.example.pianochord

import android.media.AudioAttributes
import android.media.AudioFormat
import android.media.AudioTrack
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b = findViewById<Button>(R.id.play_c_btn)
        b.setOnClickListener {
            playC()
        }
    }

    private fun playC() {
        val soundC4 = Piano().makeKeyboard().get(PianoKey.C4)

        val audioTrack = AudioTrack.Builder()
            .setAudioAttributes(
                AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build())
            .setAudioFormat(
                AudioFormat.Builder()
                .setEncoding(AudioFormat.ENCODING_PCM_16BIT)
                .setSampleRate(Piano.SAMPLE_RATE)
                .setChannelMask(AudioFormat.CHANNEL_OUT_MONO)
                .build())
            .setBufferSizeInBytes(soundC4!!.size * java.lang.Double.SIZE / java.lang.Byte.SIZE)
            .build()

        audioTrack.play()

//        var floatArray: FloatArray = soundC4 as FloatArray
//        thread {
//            audioTrack.write(floatArray, 0, soundC4.size)
//            audioTrack.stop()
//            audioTrack.release()
//        }
    }
}