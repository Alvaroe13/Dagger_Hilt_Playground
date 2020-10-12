package com.example.dagger_hilt_playground.viewModels

import android.content.Context
import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.dagger_hilt_playground.repository.MainRepository
import dagger.hilt.android.qualifiers.ApplicationContext

private const val TAG = "MainViewModel"

class MainViewModel @ViewModelInject constructor(
    private val repository: MainRepository,
    @ApplicationContext private val context: Context,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {
        Log.d(TAG, " init called ")
    }

    fun getHello() : String {
        Log.d(TAG, "getHello: called")
        val hello = repository.getHello()
        return  hello
    }

    fun getContent() :String {
        val content = repository.getContent()
        return content
    }
}