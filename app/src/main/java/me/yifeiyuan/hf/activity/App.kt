package me.yifeiyuan.hf.activity

import android.app.Application
import me.yifeiyuan.adh.DebugConfig
import me.yifeiyuan.adh.DebugHelper

/**
 * Created by 程序亦非猿 on 2021/5/6.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DebugConfig().apply {
            debuggable = true
            application = this@App
            enableStrictMode = true
            detectActivityLifecycle = true
            detectFragmentLifecycle = true
            logLevel = DebugConfig.LogLevel.I
        }.also {
            DebugHelper.setup(it)
        }
    }

}