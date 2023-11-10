package me.yifeiyuan.hf.activity

import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.util.Log
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.math.log

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "MainActivity onCreate() called with: savedInstanceState = $savedInstanceState")
    }

    override fun onResume() {
        super.onResume()
//        val result = checkPhoneNumber("187****0713", "18758260713")
//        Log.d(TAG, "onResume: "+result)
        checkLock()
    }

    private fun checkLock() {

        Handler().postDelayed(object : Runnable {
            override fun run() {
//                lock.set(false)
            }
        }, 1000)

        repeat(100){
            Thread {
                tryLock()
            }.start()
        }
    }

    private fun tryLock() {
        if (lock.compareAndSet(false, true)) {
            Log.e(TAG, "checkLock: enter  222,"+Thread.currentThread().name)
        }
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

    val lock = AtomicBoolean(false)

}