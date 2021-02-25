package com.mantzur.vynyl

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import com.mantzur.vynyl.ui.login.LoginActivity

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val singIn = findViewById<Button>(R.id.login)
        val signUp = findViewById<Button>(R.id.sign_up)
        val name = findViewById<EditText>(R.id.name);
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)

        var nameValue: String = ""
        var usernameValue: String = ""
        var passwordValue: String = ""

        singIn.setOnClickListener{
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent);
        }

        signUp.setOnClickListener{
            if (checkForm(nameValue, usernameValue, passwordValue)) {
                Toast.makeText(applicationContext,
                    "$nameValue, you have signed up! now let's log in",
                    Toast.LENGTH_SHORT)
                val intent = Intent(applicationContext, Welcome::class.java)
                startActivity(intent);
            } else {
                Toast.makeText(applicationContext,
                    "Something ain't right, please fill up the details and try again",
                    Toast.LENGTH_SHORT)
            }
        }

        name.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                nameValue = name.text.toString()
                if (!isNameValid(nameValue)) {
                    name.error = resources.getString(R.string.invalid_name);
                }
                checkForm(nameValue, usernameValue, passwordValue)
            }
        }
        username.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                usernameValue = username.text.toString()
                if (!isUsernameValid(usernameValue)) {
                    username.error = resources.getString(R.string.invalid_username)
                }
                checkForm(nameValue, usernameValue, passwordValue)
            }
        }
        password.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                passwordValue = password.text.toString()
                if (!isPasswordValid(passwordValue)) {
                    password.error = resources.getString(R.string.invalid_password)
                }
            } else {
              password.setText("")
            }
            checkForm(nameValue, usernameValue, passwordValue)
        }

    }

    private fun checkForm(name: String, username: String, password: String): Boolean {
        var signUp = findViewById<Button>(R.id.sign_up)
        signUp.isEnabled = isNameValid(name) && isUsernameValid(username) && isPasswordValid(password)
        return signUp.isEnabled
    }

    private fun isNameValid(name: String): Boolean {
        return name.isNotEmpty();
    }

    private fun isUsernameValid(name: String): Boolean {
        return  name.length > 3
    }

    private fun String.onlyLetters() = all { it.isLetter() }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 7  && !password.isDigitsOnly() && !password.onlyLetters()
    }
}