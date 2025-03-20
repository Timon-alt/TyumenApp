package com.example.tyumenapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tyumenapp.R
import com.example.tyumenapp.data.LocalCategoriesDataProvider
import com.example.tyumenapp.model.Categories
import com.example.tyumenapp.model.Recommendations
import com.example.tyumenapp.ui.theme.AppTheme

@Composable
fun OptionScreen() {

    val viewModel: CategoriesViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()
    CategoriesList(
        categories = uiState.categoriesList,
        onClick = {}
    )

}

@Composable
private fun CategoriesListItem(
    categories: Categories,
    onItemClick: (Categories) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(),
        modifier = modifier,
        onClick = { onItemClick(categories) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .size(dimensionResource(R.dimen.card_image_height))
        ) {
            CategoriesListImageItem(
                categories = categories,
                modifier = Modifier.size(dimensionResource(R.dimen.card_image_height))
            )
            Column(
                modifier = Modifier
                    .padding(
                        vertical = dimensionResource(R.dimen.padding_small),
                        horizontal = dimensionResource(R.dimen.padding_medium),
                    )
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(categories.titleResourceId),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = dimensionResource(R.dimen.card_text_vertical_space))
                )
            }
        }
    }
}

@Composable
fun CategoriesListImageItem(categories: Categories, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(categories.imageResourceId),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.FillWidth
        )
    }
}


@Composable
private fun CategoriesList(
    categories: List<Categories>,
    onClick: (Categories) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        contentPadding = contentPadding,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        modifier = modifier.padding(top = dimensionResource(R.dimen.padding_medium))
    ) {
        items(categories, key = { category -> category.id }) { category ->
            CategoriesListItem(
                categories = category,
                onItemClick = onClick
            )
        }
    }
}

@Preview
@Composable
fun CategoriesListPreview() {
    AppTheme {
        CategoriesList(
            categories = LocalCategoriesDataProvider.getCategoryData(),
            onClick = {}
        )
    }
}

@Preview
@Composable
fun CategoriesListItemPreview() {
    AppTheme {
        CategoriesListItem(
            categories = LocalCategoriesDataProvider.defaultCategory,
            onItemClick = {}
        )
    }
}