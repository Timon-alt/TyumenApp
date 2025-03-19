package com.example.tyumenapp.data

import com.example.tyumenapp.R
import com.example.tyumenapp.model.Categories
import java.util.Locale.Category

/*
 * Categories Data
 */
object LocalCategoriesDataProvider{
    val defaultCategory = getCategoryData()[0]

    fun getCategoryData(): List<Categories> {
        return listOf(
            Categories(
                id = 1,
                titleResourceId = R.string.coffee_shops,
                imageResourceId = R.drawable.coffee_cup
            ),
            Categories(
                id = 2,
                titleResourceId = R.string.restaurants,
                imageResourceId = R.drawable.restaurant
            ),
            Categories(
                id = 3,
                titleResourceId = R.string.kid_friendly_places,
                imageResourceId = R.drawable.kids_places,
            ),
            Categories(
                id = 4,
                titleResourceId = R.string.parks,
                imageResourceId = R.drawable.park
            ),
            Categories(
                id = 5,
                titleResourceId = R.string.shopping_centers,
                imageResourceId = R.drawable.shopping
            )
        )
    }

}