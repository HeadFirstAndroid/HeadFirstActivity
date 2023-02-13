package me.yifeiyuan.hf.activity

import android.app.Activity
import android.content.Context
import android.content.Intent

/**
 * Created by 程序亦非猿 on 2022/12/9.
 */

inline fun <reified A : Activity> Context.startActivity(intentBuilder: Intent.() -> Unit = {}) {
    val intent = Intent(this, A::class.java).apply(intentBuilder)
    if (this !is Activity) {
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    startActivity(intent)
}