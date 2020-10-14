package com.example.dagger_hilt_playground.repository

import android.util.Log
import com.example.dagger_hilt_playground.cache.RecipeDatabase
import com.example.dagger_hilt_playground.model.Recipe
import com.example.dagger_hilt_playground.service.Api
import javax.inject.Inject

private const val TAG = "MainRepository"

class MainRepository @Inject constructor(
    private val connectionApi : Api,
    private val database: RecipeDatabase
) {

    init {
        Log.d(TAG, "called: ")
    }

    suspend fun getRecipeList(recipeType : String , page : Int) =
                 connectionApi.getRecipeList(recipeType, page)

    suspend fun insertRecipe( recipe : Recipe) =
                 database.getDao().insertRecipe(recipe)

    suspend fun getRecipeFromCache() =
                database.getDao().getRecipesList()

}