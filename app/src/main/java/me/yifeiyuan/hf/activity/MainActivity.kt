package me.yifeiyuan.hf.activity

import android.os.Bundle
import android.util.Log

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "MainActivity onCreate() called with: savedInstanceState = $savedInstanceState")
    }
}