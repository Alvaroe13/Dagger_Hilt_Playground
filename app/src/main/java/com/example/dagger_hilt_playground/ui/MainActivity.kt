package com.example.dagger_hilt_playground.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.dagger_hilt_playground.R
import com.example.dagger_hilt_playground.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "MainActivityView"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val category = "Chicken"
    private val page = 1

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: called!")
        viewModel.getRecipeList(category, page)
        initObserver()
    }

    private fun initObserver() {
        viewModel.recipeListResponse.observe(this , Observer {
            Log.d(TAG, "initObserver: response = ${it.recipes.size}")
        })
    }

}