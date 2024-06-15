package com.example.matcher

import android.animation.AnimatorSet
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.animation.ObjectAnimator
import android.graphics.BitmapFactory
import android.graphics.Color
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val backBitmap = BitmapFactory.decodeResource(resources, R.drawable.card_back)
        val frontBitmap = BitmapFactory.decodeResource(resources, R.drawable.card_front)

        findViewById<ImageView>(R.id.image_back).setImageBitmap(backBitmap)
        findViewById<ImageView>(R.id.image_front).apply {
            setImageBitmap(frontBitmap)
            scaleX = -1f
        }

        val cardBack = findViewById<FrameLayout>(R.id.image_back)
        val cardFront = findViewById<FrameLayout>(R.id.card_front)

        val a = ObjectAnimator.ofFloat(cardFront, "scaleX", -1f, 1f)
        a.duration = 1000 // Set the animation duration (in milliseconds)

        val b = ObjectAnimator.ofFloat(cardBack, "scaleX", 1f, -1f)
        b.duration = 1000 // Set the animation duration (in milliseconds)

        val animatorSet = AnimatorSet()
        animatorSet.playTogether(a, b)

        animatorSet.start()

    }
}