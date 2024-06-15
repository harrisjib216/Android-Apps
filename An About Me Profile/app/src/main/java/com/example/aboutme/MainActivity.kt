package com.example.aboutme

import android.content.Context
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val person: Person = Person("Jay","Jack")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = ActivityMainBinding.inflate(layoutInflater)
//        binding.person = person
//        binding.doneBtn.setOnClickListener {
//            onDonePressed()
//        }
//        setContentView(binding.root)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.person = person

    }

    private fun onDonePressed() {
        binding.nameLabel.text = binding.nickNameEdit.text.toString()
        binding.nickNameEdit.text.clear()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.doneBtn.windowToken, 0)
    }
}
