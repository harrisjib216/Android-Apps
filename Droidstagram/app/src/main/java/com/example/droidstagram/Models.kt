package com.example.droidstagram

import androidx.annotation.DrawableRes

class UserModel(
    val name: String,
    @DrawableRes val avatarRes: Int
)

class PostModel(
    val id: Int,
    val user: UserModel,
    @DrawableRes val imageRes: Int,
    val text: String = ""
)