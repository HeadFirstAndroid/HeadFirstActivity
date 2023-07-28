package me.yifeiyuan.hf.activity

import android.os.Bundle
import android.text.TextUtils
import android.util.Log

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "MainActivity onCreate() called with: savedInstanceState = $savedInstanceState")
    }

    override fun onResume() {
        super.onResume()
        val result = checkPhoneNumber("187****0713", "18758260713")
        Log.d(TAG, "onResume: "+result)
    }

    private fun checkPhoneNumber(maskPhone: String, mobilePhone: String): Boolean {
        if (TextUtils.isEmpty(maskPhone) || TextUtils.isEmpty(mobilePhone)) {
            return false
        }
        try {
            val prefix = maskPhone.substring(0, 3)
            val suffix = maskPhone.substring(7, 11)
            return mobilePhone.startsWith(prefix) && mobilePhone.endsWith(suffix)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return false
    }
}