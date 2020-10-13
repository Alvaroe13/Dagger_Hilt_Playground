package com.example.dagger_hilt_playground.service

import com.example.dagger_hilt_playground.model.RecipeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("api/search")  //fetch list of all recipes from server
    suspend fun getRecipeList(
        @Query("q") recipeType : String,
        @Query("page") pageNumber : Int) : Response<RecipeResponse>

}