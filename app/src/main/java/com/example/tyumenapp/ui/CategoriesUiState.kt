package com.example.tyumenapp.ui

import com.example.tyumenapp.data.LocalCategoriesDataProvider
import com.example.tyumenapp.model.Categories
import com.example.tyumenapp.model.Recommendations

data class CategoriesUiState(
    val categoriesList: List<Categories> = emptyList(),
    val currentCategory: Categories = LocalCategoriesDataProvider.defaultCategory,
    val currentRecommendations: List<Recommendations> = emptyList(),
    val isShowingRecommendationsPage: Boolean = false
)