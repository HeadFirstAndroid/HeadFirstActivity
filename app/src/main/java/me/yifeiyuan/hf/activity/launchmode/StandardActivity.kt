package me.yifeiyuan.hf.activity.launchmode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import me.yifeiyuan.hf.activity.BaseActivity
import me.yifeiyuan.hf.activity.R

class StandardActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("StandardActivity")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d(TAG, "onNewIntent() called with: intent = $intent")
    }
}