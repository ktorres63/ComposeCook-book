package com.tutorial.composecookbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tutorial.composecookbook.ui.theme.ComposeCookbookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeCookbookTheme {
                Cookbook()

            }
        }
    }
}

@Composable
fun Cookbook() {
    RecipeList(recipes = defaultRecipes)
}

@Preview(showBackground = true)
@Composable
fun CookbookPreview() {
    ComposeCookbookTheme {
        Cookbook()
    }
}
