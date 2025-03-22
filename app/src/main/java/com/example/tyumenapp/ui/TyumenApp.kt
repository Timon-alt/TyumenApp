package com.example.tyumenapp.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tyumenapp.R
import com.example.tyumenapp.data.LocalCategoriesDataProvider
import com.example.tyumenapp.model.Categories

/*
 * enum class that represent the screens in the app
 */
enum class TyumenScreen(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Reccommendations(title = R.string.recommendations_title),
    Description(title = R.string.description_title)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TyumenAppBar(
    currentScreen: TyumenScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBackIosNew,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun TyumenApp(
    navController: NavHostController = rememberNavController()
) {
    val viewModel: CategoriesViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = TyumenScreen.valueOf(
        backStackEntry?.destination?.route ?: TyumenScreen.Start.name
    )

    Scaffold(
        topBar = {
            TyumenAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = TyumenScreen.Start.name,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(route = TyumenScreen.Start.name) {
                OptionScreen(
                    options = LocalCategoriesDataProvider.getCategoryData(),
                    onClick = { categories: Categories ->
                        viewModel.getCurrentRecommendations(categoryId = categories.id)
                        navController.navigate(TyumenScreen.Reccommendations.name)
                    },
                    uiState = uiState

                )
            }
            composable(route = TyumenScreen.Reccommendations.name) {
                RecommendationScreen(
                    uiState = uiState
                )
            }
            composable(route = TyumenScreen.Description.name) {
                DescriptionScreen()
            }
        }
    }
}