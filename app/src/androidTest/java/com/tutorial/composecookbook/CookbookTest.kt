package com.tutorial.composecookbook

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CookbookTest {
    private val viewModel = RecipeListViewModel()

    @get:Rule(order = 0)
    val composeTestRule = createComposeRule()

    @Before
    fun before(){
        composeTestRule.setContent{
            Cookbook(viewModel = viewModel)
        }
    }

    @Test
    fun toAppBarShouldBeVisibleAndShowCorrectTitle(){
        composeTestRule.onNodeWithTag("topAppBar").assertIsDisplayed()
        composeTestRule.onNodeWithTag("topApparText").assertTextContains("Compose Cookbok")

    }
    @Test
    fun whenAddPlaceHolderButtonClicked_recipeCountShouldIncreaseBy1() {
        val oldRecipeCount = viewModel.recipeListFlow.value.count()
        composeTestRule.onNodeWithTag("addPlaceholderButton").performClick()
        val newRecipeCount = viewModel.recipeListFlow.value.count()
        assert(newRecipeCount - oldRecipeCount == 1)
    }

    @Test
    fun whenRemoveLastButtonClicked_recipeCountShouldDecreaseBy1() {
        val oldRecipeCount = viewModel.recipeListFlow.value.count()
        composeTestRule.onNodeWithTag("removeLastButton").performClick()
        val newRecipeCount = viewModel.recipeListFlow.value.count()
        assert(oldRecipeCount - newRecipeCount == 1)
    }
}