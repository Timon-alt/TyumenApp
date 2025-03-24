package com.example.tyumenapp.ui

import android.graphics.pdf.content.PdfPageGotoLinkContent.Destination
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tyumenapp.R
import com.example.tyumenapp.data.LocalRecommendationsDataProvider
import com.example.tyumenapp.model.Recommendations

@Composable
fun DescriptionScreen(
    uiState: CategoriesUiState
) {
    Details(
        recommendations = uiState.currentRecommendation
    )

}

@Composable
fun Details(
    recommendations: Recommendations
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(recommendations.imageResourceId),
            contentDescription = null
        )
        Text(
            text = stringResource(recommendations.subtitleResourceId),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun PreviewDetails() {
    Details(
        recommendations = LocalRecommendationsDataProvider.getRecommendationById(1)
    )
}