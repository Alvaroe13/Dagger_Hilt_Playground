package com.example.dagger_hilt_playground.repository

import android.util.Log
import com.example.dagger_hilt_playground.service.Api
import javax.inject.Inject

private const val TAG = "MainRepository"

class MainRepository @Inject constructor(
    private val connectionApi : Api
) {

    init {
        Log.d(TAG, "called: ")
    }

    suspend fun getRecipeList(recipeType : String , page : Int) =
                 connectionApi.getRecipeList(recipeType, page)

}