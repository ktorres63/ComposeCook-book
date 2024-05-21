package com.tutorial.composecookbook

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
        Text(recipe.title)
    }

}

@Composable
@Preview(showBackground = true)
fun RecipeCardPreview() {
    RecipeCard(defaultRecipes[0])
}