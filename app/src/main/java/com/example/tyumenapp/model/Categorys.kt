package com.example.tyumenapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/*
 * Data model for Categories
 */
data class Categories(
    val id: Int,
    @StringRes val titleResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
