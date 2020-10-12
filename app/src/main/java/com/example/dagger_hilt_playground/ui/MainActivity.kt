package com.example.dagger_hilt_playground.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.dagger_hilt_playground.R
import com.example.dagger_hilt_playground.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivityView"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: init")
        val hello = viewModel.getHello()
        val content = viewModel.getContent()
        Log.d(TAG, "onCreate:  hello = $hello")
        Log.d(TAG, "onCreate: content = $content")

        tvHelloMessage.text = hello
        tvContentMessage.text = content
    }

}