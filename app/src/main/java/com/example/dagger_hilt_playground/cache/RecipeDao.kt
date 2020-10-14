package com.example.dagger_hilt_playground.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dagger_hilt_playground.model.Recipe

@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe :Recipe) : Long

    @Query("SELECT * FROM recipes")
    suspend fun getRecipesList(): List<Recipe>

}