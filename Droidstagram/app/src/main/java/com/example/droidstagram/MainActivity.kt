package com.example.droidstagram

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facebook.litho.Component
import com.facebook.litho.ComponentScope
import com.facebook.litho.KComponent
import com.facebook.litho.LithoView

class MyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val lithoView = LithoView.create(this, MyComponent())
        setContentView(lithoView)
    }
}

class MyComponent() : KComponent() {
    override fun ComponentScope.render(): Component {
        val post = PostModel(
            0,
            UserModel(
                "Jack",
                R.drawable.profilepic,
            ),
            R.drawable.pic1,
            "Here's a cool cat"
        )

        return PostComponent(post)
    }
}
