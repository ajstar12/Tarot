package com.arjunsinh.tarot.Activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.arjunsinh.tarot.MainActivity
import com.arjunsinh.tarot.R
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.Runnable

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inIt()
        setClick()
    }

    private fun inIt() {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(Runnable {
            run {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }
        },2000)
    }

    private fun setClick() {

    }
}