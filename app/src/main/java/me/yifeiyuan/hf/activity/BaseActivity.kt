package me.yifeiyuan.hf.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import me.yifeiyuan.hf.activity.launchmode.SingleInstanceActivity
import me.yifeiyuan.hf.activity.launchmode.SingleTaskActivity
import me.yifeiyuan.hf.activity.launchmode.SingleTopActivity
import me.yifeiyuan.hf.activity.launchmode.StandardActivity

open class BaseActivity : AppCompatActivity() {

    var TAG = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    fun goA(view: View) {
        startActivity(Intent(this, AActivity::class.java))
    }

    fun goB(view: View) {
        startActivity(Intent(this, BActivity::class.java))

    }

    fun goC(view: View) {
        startActivity(Intent(this, CActivity::class.java))
    }


    fun goSingleInstance(view: View) {
        startActivity(Intent(this, SingleInstanceActivity::class.java))
    }

    fun goSingleTask(view: View) {
        startActivity(Intent(this, SingleTaskActivity::class.java))
    }

    fun goSingleStandard(view: View) {
        startActivity(Intent(this, StandardActivity::class.java))
    }

    fun goSingleTop(view: View) {
        startActivity(Intent(this, SingleTopActivity::class.java))
    }
}