package com.example.dagger_hilt_playground.viewModels

import android.content.Context
import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dagger_hilt_playground.model.RecipeResponse
import com.example.dagger_hilt_playground.repository.MainRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"

class MainViewModel @ViewModelInject constructor(
    private val repository: MainRepository,
    @ApplicationContext private val context: Context,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val recipeListResponse: MutableLiveData<RecipeResponse> = MutableLiveData()

    init {
        Log.d(TAG, " init called ")
    }

    fun getRecipeList( recipeCategory: String , page : Int) = viewModelScope.launch(IO) {

        val apiResponse = repository.getRecipeList(recipeCategory, page)
        if(apiResponse.isSuccessful){
            apiResponse.let {
                Log.d(TAG, "getRecipeList: response body = ${apiResponse.body()?.recipes?.size}")
                recipeListResponse.postValue(it.body())
            }
        } else{
            Log.d(TAG, "getRecipeList: response not successful")
        }
        
    }

}