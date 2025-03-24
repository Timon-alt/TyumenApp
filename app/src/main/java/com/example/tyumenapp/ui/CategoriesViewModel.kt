package com.example.tyumenapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.tyumenapp.data.LocalCategoriesDataProvider
import com.example.tyumenapp.data.LocalRecommendationsDataProvider
import com.example.tyumenapp.model.Recommendations
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class CategoriesViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CategoriesUiState())
    val uiState:StateFlow<CategoriesUiState> = _uiState.asStateFlow()

    init {
        initializeUiState()
        Log.d("viewModelCheck", "Инициализировался виюмодел")
    }

    private fun initializeUiState() {
        _uiState.value =
            CategoriesUiState(
                categoriesList = LocalCategoriesDataProvider.getCategoryData(),
                currentCategory = LocalCategoriesDataProvider.getCategoryData().getOrElse(0) {
                    LocalCategoriesDataProvider.defaultCategory
                }
            )
    }

    private fun setCurrentListRecommendations(categoryId: Int): List<Recommendations> {
        return LocalCategoriesDataProvider.getCategoryData()[categoryId].recommendationsList
    }

    fun getCurrentListRecommendations(categoryId: Int) {
        _uiState.update {
            CategoriesUiState(
                currentListRecommendations = setCurrentListRecommendations(categoryId)
            )
        }
    }

    private fun setCurrentRecommendation(recommendationId: Int): Recommendations {
        return LocalRecommendationsDataProvider.getRecommendationById(recommendationId)
    }

    fun getRecommendation(recommendationId: Int) {
        _uiState.update {
            CategoriesUiState(
                currentRecommendation = setCurrentRecommendation(recommendationId)
            )
        }
    }
}



