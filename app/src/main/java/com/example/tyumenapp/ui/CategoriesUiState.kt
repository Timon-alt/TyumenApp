package com.example.tyumenapp.ui

import com.example.tyumenapp.data.LocalCategoriesDataProvider
import com.example.tyumenapp.model.Categories

data class CategoriesUiState(
    val categoriesList: List<Categories> = emptyList(),
    val currentCategory: Categories = LocalCategoriesDataProvider.defaultCategory,
    val isShowingRecommendationsPage: Boolean = false
)