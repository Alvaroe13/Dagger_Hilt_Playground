package com.example.dagger_hilt_playground.repository

import android.util.Log
import javax.inject.Inject

private const val TAG = "MainRepository"

class MainRepository @Inject constructor() {

    init {
        Log.d(TAG, "called: ")
    }

   fun getHello() = "This is hello with Coroutines"

   fun getContent() = "This is the content fetched with Coroutines"

}