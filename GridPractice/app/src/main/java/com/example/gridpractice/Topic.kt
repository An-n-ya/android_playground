package com.example.gridpractice

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val category: Int,
    val numberOfCourses: Int,
    @DrawableRes val picture: Int,
)
