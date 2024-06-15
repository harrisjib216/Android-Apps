package com.example.udacitydiceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.udacitydiceroller.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.rollBtn.setOnClickListener {
            rollDice()
        }

        setContentView(binding.root)
    }

    private fun rollDice() {
        val newDiceValue = Random.nextInt(6) + 1
        val newDiceImage = when (newDiceValue) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        binding.diceImage.setImageResource(newDiceImage)
        binding.rollText.text = "$newDiceValue"
    }
}