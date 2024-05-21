package com.tutorial.composecookbook

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun RecipeCard(recipe: Recipe) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Image(
            painterResource(recipe.imageResource),
            contentDescription = recipe.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(144.dp)

        )
        Row {
            Column {
                Text(
                    recipe.title,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight(700)
                )
                for (ingredient in recipe.ingredients) {
                    Text("• $ingredient", style = MaterialTheme.typography.bodyMedium)
                }
            }
            Text(
                text = recipe.description,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun RecipeCardPreview() {
    RecipeCard(defaultRecipes[0])
}