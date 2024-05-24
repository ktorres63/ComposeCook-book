package com.tutorial.composecookbook

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RecipeList(viewModel: RecipeListViewModel){
    //convert the flow(of MutableStateList) into a State
    val recipeListState = viewModel.recipeListFlow.collectAsState()
    LazyColumn {
        items(recipeListState.value){
            RecipeCard(recipe = it, modifier = Modifier.padding(16.dp))
        }
    }
}
@Composable
@Preview
fun RecipeListPreview(){
    val viewModel = RecipeListViewModel()
    RecipeList(viewModel = viewModel)
}