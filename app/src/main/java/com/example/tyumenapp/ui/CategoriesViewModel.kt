package com.example.tyumenapp.ui

import androidx.lifecycle.ViewModel
import com.example.tyumenapp.data.LocalCategoriesDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class CategoriesViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CategoriesUiState())
    val uiState:StateFlow<CategoriesUiState> = _uiState.asStateFlow()

    init {
        initializeUiState()
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
}



