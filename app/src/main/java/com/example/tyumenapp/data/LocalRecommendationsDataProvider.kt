package com.example.tyumenapp.data

import com.example.tyumenapp.R
import com.example.tyumenapp.model.Recommendations

/*
 * recommendations data for categories
 */
object LocalRecommendationsDataProvider {

    val defaultRecommendation = getRecommendationsData()[0]
    val currentRecommendation = emptyList<Recommendations>()

    fun getRecommendationsData(): List<Recommendations> {
        return listOf(
            Recommendations(
                id = 1,
                titleResourceId = R.string.coffee_cards_talking,
                subtitleResourceId = R.string.recomedations_description,
                imageResourceId = R.drawable.coffe_cards
            ),
            Recommendations(
                id = 2,
                titleResourceId = R.string.coffee_brut,
                subtitleResourceId = R.string.recomedations_description,
                imageResourceId = R.drawable.coffee_brut
            ),
            Recommendations(
                id = 3,
                titleResourceId = R.string.coffee_mogu,
                subtitleResourceId = R.string.recomedations_description,
                imageResourceId = R.drawable.mogu
            ),
            Recommendations(
                id = 4,
                titleResourceId = R.string.rest_ceh,
                subtitleResourceId = R.string.recomedations_description,
                imageResourceId = R.drawable.rest_ceh
            ),
            Recommendations(
                id = 5,
                titleResourceId = R.string.rest_tom,
                subtitleResourceId = R.string.recomedations_description,
                imageResourceId = R.drawable.rest_tom
            ),
            Recommendations(
                id = 6,
                titleResourceId = R.string.rest_puri,
                subtitleResourceId = R.string.recomedations_description,
                imageResourceId = R.drawable.rest_puri
            ),
            Recommendations(
                id = 7,
                titleResourceId = R.string.kids_place_atm,
                subtitleResourceId = R.string.recomedations_description,
                imageResourceId = R.drawable.places_atm
            ),
            Recommendations(
                id = 8,
                titleResourceId = R.string.kids_place_nev,
                subtitleResourceId = R.string.recomedations_description,
                imageResourceId = R.drawable.places_nev
            ),
            Recommendations(
                id = 9,
                titleResourceId = R.string.kids_place_maks,
                subtitleResourceId = R.string.recomedations_description,
                imageResourceId = R.drawable.kids_places
            ),
            Recommendations(
                id = 10,
                titleResourceId = R.string.park_zatyumenskyi,
                subtitleResourceId = R.string.recomedations_description,
                imageResourceId = R.drawable.park
            ),
            Recommendations(
                id = 11,
                titleResourceId = R.string.park_gagarin,
                subtitleResourceId = R.string.recomedations_description,
                imageResourceId = R.drawable.park
            ),
            Recommendations(
                id = 12,
                titleResourceId = R.string.park_gilev,
                subtitleResourceId = R.string.recomedations_description,
                imageResourceId = R.drawable.park
            ),
            Recommendations(
                id = 13,
                titleResourceId = R.string.center_kris,
                subtitleResourceId = R.string.recomedations_description,
                imageResourceId = R.drawable.center_kris
            ),
            Recommendations(
                id = 14,
                titleResourceId = R.string.center_moll,
                subtitleResourceId = R.string.recomedations_description,
                imageResourceId = R.drawable.center_moll
            ),
            Recommendations(
                id = 15,
                titleResourceId = R.string.center_gallery,
                subtitleResourceId = R.string.recomedations_description,
                imageResourceId = R.drawable.shopping
            )
        )
    }


    /*
     * Get the recommendation with the given [recommendationId]
     */
    fun getRecommendationById(recommendationId: Int): Recommendations {
        return getRecommendationsData().firstOrNull { it.id == recommendationId }
            ?: getRecommendationsData().first()
    }
}