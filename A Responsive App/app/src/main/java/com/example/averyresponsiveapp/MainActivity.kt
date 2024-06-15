package com.example.averyresponsiveapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val colors = mutableListOf(
        Color.GRAY,
        Color.DKGRAY,
        Color.MAGENTA,
        Color.RED,
        Color.BLUE,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        listOf(
            R.id.box_one_text,
            R.id.box_two_text,
            R.id.box_three_text,
            R.id.box_four_text,
            R.id.box_five_text
        ).forEach {
            val textView = findViewById<TextView>(it)
            textView.setOnClickListener {
                val index = (0..<colors.size).random()
                textView.setBackgroundColor(colors[index])
                colors.removeAt(index)

                textView.isEnabled = false
            }
        }

        listOf(R.id.red_btn, R.id.yellow_btn, R.id.green_btn).forEach { id ->
            val button = findViewById<Button>(id)
            button.setOnClickListener { btn ->
                if (id == R.id.red_btn) {
                    btn.setBackgroundColor(Color.RED)
                } else if (id == R.id.yellow_btn) {
                    btn.setBackgroundColor(Color.YELLOW)
                } else {
                    btn.setBackgroundColor(Color.GREEN)
                }
            }
        }
    }
}