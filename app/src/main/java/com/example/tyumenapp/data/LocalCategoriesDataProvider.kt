package com.example.tyumenapp.data

import com.example.tyumenapp.R
import com.example.tyumenapp.model.Categories
import java.util.Locale.Category

/*
 * Categories Data
 */
object LocalCategoriesDataProvider{
    // for preview
    val defaultCategory = getCategoryData()[0]

    fun getCategoryData(): List<Categories> {
        return listOf(
            Categories(
                id = 0,
                titleResourceId = R.string.coffee_shops,
                imageResourceId = R.drawable.coffee_cup,
                recommendationsList = listOf(
                    LocalRecommendationsDataProvider.getRecommendationById(1),
                    LocalRecommendationsDataProvider.getRecommendationById(2),
                    LocalRecommendationsDataProvider.getRecommendationById(3),
                )
            ),
            Categories(
                id = 1,
                titleResourceId = R.string.restaurants,
                imageResourceId = R.drawable.restaurant,
                recommendationsList = listOf(
                    LocalRecommendationsDataProvider.getRecommendationById(4),
                    LocalRecommendationsDataProvider.getRecommendationById(5),
                    LocalRecommendationsDataProvider.getRecommendationById(6),
                )
            ),
            Categories(
                id = 2,
                titleResourceId = R.string.kid_friendly_places,
                imageResourceId = R.drawable.kids_places,
                recommendationsList = listOf(
                    LocalRecommendationsDataProvider.getRecommendationById(7),
                    LocalRecommendationsDataProvider.getRecommendationById(8),
                    LocalRecommendationsDataProvider.getRecommendationById(9),
                )
            ),
            Categories(
                id = 3,
                titleResourceId = R.string.parks,
                imageResourceId = R.drawable.park,
                recommendationsList = listOf(
                    LocalRecommendationsDataProvider.getRecommendationById(10),
                    LocalRecommendationsDataProvider.getRecommendationById(11),
                    LocalRecommendationsDataProvider.getRecommendationById(12),
                )
            ),
            Categories(
                id = 4,
                titleResourceId = R.string.shopping_centers,
                imageResourceId = R.drawable.shopping,
                recommendationsList = listOf(
                    LocalRecommendationsDataProvider.getRecommendationById(13),
                    LocalRecommendationsDataProvider.getRecommendationById(14),
                    LocalRecommendationsDataProvider.getRecommendationById(15),
                )
            )
        )
    }

}