package com.example.dagger_hilt_playground.model

data class RecipeResponse (
    val count : Int,
    val recipes: MutableList<Recipe>
)