package com.tutorial.composecookbook

import android.widget.Space
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun RecipeCard(recipe: Recipe, modifier: Modifier) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary),
        shape = RoundedCornerShape(8.dp),
        tonalElevation = 2.dp,
        shadowElevation = 10.dp
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painterResource(recipe.imageResource),
                contentDescription = recipe.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(144.dp)

            )
            Row(modifier = Modifier.padding(16.dp)){
                Column {
                    Text(
                        text = recipe.title,
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight(700),
                    )
                    for (ingredient in recipe.ingredients) {
                        Text(
                            text = "• $ingredient",
                            style = MaterialTheme.typography.bodyMedium,

                        )
                    }
                }
                Column {
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = recipe.description,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(16.dp)
                    )
                }

            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun RecipeCardPreview() {
    val viewModel = RecipeListViewModel()
    val previewRecipe = Recipe(
        imageResource = R.drawable.ramen,
        title = "Ramen",
        ingredients = listOf("Noodles", "Eggs", "Mushrooms", "Carrots", "Soy sauce"),
        description = "Japan’s famous noodles-and-broth dish. It’s meant to be slurped LOUDLY."
    )
    RecipeCard(recipe = previewRecipe, modifier = Modifier.padding(16.dp) )
}