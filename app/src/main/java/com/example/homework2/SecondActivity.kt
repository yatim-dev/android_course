package com.example.homework2;

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.homework2.databinding.ActivitySecondBinding


@Suppress("NAME_SHADOWING")
class SecondActivity : AppCompatActivity() {

    private val TAG = "SecondActivity"
    private lateinit var binding: ActivitySecondBinding
    private val _configChangeCount = "configChangeCount"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        val bundle = intent.extras
        val configChangeCount = bundle?.getInt(_configChangeCount) ?: error("incorrect key")
        setContentView(view)

        val pow = configChangeCount * configChangeCount
        binding.number3.text = pow.toString()
        binding.button3.setOnClickListener {
            val intent = Intent(
                this,
                MainActivity::class.java
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


}
