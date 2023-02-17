package com.example.homework2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent;
import android.content.res.Configuration
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework2.databinding.ActivityMainBinding


@Suppress("NAME_SHADOWING")
class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private val _configChangeCount = "configChangeCount"
    private var configChangeCount = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        val bundle = intent.extras
        configChangeCount = bundle?.getInt(_configChangeCount) ?: configChangeCount

        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.number1.text = configChangeCount.toString()
        binding.button1.setOnClickListener {
            val intent = Intent(
                this,
                SecondActivity::class.java
            ).apply {
                val bundle = Bundle().apply {
                    putInt(_configChangeCount, configChangeCount)
                }
                putExtras(bundle)
            }
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        Log.i(TAG, "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.i(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.i(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i(TAG, "onStop")
        super.onStop()
    }

    override fun onRestart() {
        Log.i(TAG, "onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.i(TAG, "onDestroy")
        super.onDestroy()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        Log.i(TAG, "onConfigurationChanged")
        super.onConfigurationChanged(newConfig)
        increment()
    }

    private fun increment(){
        Log.i(TAG, "increment")
        configChangeCount += 1
        binding.number1.text = configChangeCount.toString()
    }
}