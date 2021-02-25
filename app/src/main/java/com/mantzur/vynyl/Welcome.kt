package com.mantzur.vynyl

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.mantzur.vynyl.ui.login.LoginActivity

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val signIn = findViewById<Button>(R.id.sign_in)
        val signUp = findViewById<Button>(R.id.sign_up)

        signIn.setOnClickListener {
            val intent = Intent(baseContext, LoginActivity::class.java)
            startActivity(intent);
        }
        signUp.setOnClickListener{
            val intent = Intent(baseContext, SignUp::class.java)
            startActivity(intent)
        }
    }
}