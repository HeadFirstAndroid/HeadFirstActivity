package me.yifeiyuan.hf.activity.web

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import me.yifeiyuan.hf.activity.R
import me.yifeiyuan.hf.activity.databinding.ActivityWebBinding

class WebActivity : AppCompatActivity() {

    lateinit var binding :ActivityWebBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setupTheme()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        binding = ActivityWebBinding.bind(findViewById(R.id.root))

        binding.root.setBackgroundColor(Color.parseColor("#33000000"))
        binding.root.setBackgroundColor(Color.parseColor("#33ff0000"))

        setupToolbar()
        setupStatusBar(false)

        binding.webView.loadUrl("https://juejin.cn/")
//        binding.root.setBackgroundColor(Color.BLUE)
    }

    var transparent = true
    private fun setupTheme() {
        if (transparent) {
            setTheme(R.style.Theme_Transparent)
        }else{
            setTheme(R.style.Theme_HeadFirstActivity)
        }
    }

    private fun setupToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.hide()

//        setSupportActionBar(binding.toolbar)

        binding.toolbar.setNavigationOnClickListener{

        }
//        binding.toolbar.navigationIcon =

        binding.toolbar.title = "Title Web"
    }

    /**
     * 还需要在布局的根设置 android:fitsSystemWindows="true"
     */
    open fun setupStatusBar(needStatusBarTextBlack: Boolean) {
        //兼容5.0及以上支持全透明
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            var systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
////            if (needStatusBarTextBlack && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (needStatusBarTextBlack && Build.VERSION.SDK_INT >= 23) {
//                systemUiVisibility =
//                    systemUiVisibility or 0x00002000 //View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//            }
////            }
//            val window = this.window
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//            window.decorView.systemUiVisibility = systemUiVisibility
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//            window.statusBarColor = Color.TRANSPARENT
//        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (needStatusBarTextBlack) {
                getWindow().getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
            } else {
                //非沉浸式
                getWindow().getDecorView()
                    .setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE)
            }
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(0,0)
    }
}