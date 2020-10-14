package com.example.dagger_hilt_playground.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.dagger_hilt_playground.R
import com.example.dagger_hilt_playground.model.Recipe
import com.example.dagger_hilt_playground.util.Constants.PAGE_NUMBER
import com.example.dagger_hilt_playground.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "MainActivityView"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val category = "Chicken"

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: called!")
        viewModel.getRecipeList(category, PAGE_NUMBER)
        initObserver()

    }

    private fun initObserver() {
        viewModel.recipeListResponse.observe(this , Observer {
            Log.d(TAG, "initObserver: response = ${it.recipes.size}")

            insertRecipe(it.recipes[0])
        })

        getRecipe()
    }

    private fun insertRecipe(recipe: Recipe){
        Log.d(TAG, "insertRecipe:  called")
        Log.d(TAG, "insertRecipe: recipe inserted =${recipe.title}")
        viewModel.insertRecipe(recipe)
    }
    
    private fun getRecipe() {
        viewModel.getRecipe()
        viewModel.recipeFromCache.observe(this, Observer { recipeFetched ->
            if(recipeFetched != null){
                Log.d(TAG, "getRecipe: recipe fetched = ${recipeFetched.title}")
            }else{
                Log.d(TAG, "getRecipe: recipe fetched came null")
            }
            
        })
    }

}