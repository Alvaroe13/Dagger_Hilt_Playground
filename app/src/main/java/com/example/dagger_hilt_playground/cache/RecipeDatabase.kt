package com.example.dagger_hilt_playground.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dagger_hilt_playground.model.Recipe

@Database( entities = [Recipe::class], version = 1 )
abstract class RecipeDatabase : RoomDatabase() {

    abstract fun getDao() : RecipeDao
}