package com.mantzur.vynyl

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.mantzur.vynyl.ui.login.LoginActivity

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            val intent = Intent(this, Welcome::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}
