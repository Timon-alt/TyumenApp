package com.example.tyumenapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/*
 * Data model for recommendations
 */
data class Recommendations(
    val id: Int,
    @StringRes val titleResourceId: Int,
    @StringRes val subtitleResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
