package com.tutorial.composecookbook

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RecipeList(recipes: List<Recipe>){
    LazyColumn {
        items(recipes){
            RecipeCard(it)
        }
    }
}
@Composable
@Preview
fun RecipeListPreview(){
    RecipeList(defaultRecipes)
}