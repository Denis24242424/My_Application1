package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        val userLogin: EditText = findViewById(R.id.user_Login2)
        val userPassword: EditText = findViewById(R.id.user_pass2)
        val button: Button = findViewById(R.id.button_reg2)
            val regist: TextView = findViewById(R.id.registr)
        regist.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val password = userPassword.text.toString().trim()
            if(login == "" || password == "")
                Toast.makeText(this,"не все поля заполнены", Toast.LENGTH_LONG).show()
            else {
                val dp = dphelp(this, null)
                val isAust = dp.getUser(login,password)
                if (isAust){
                    Toast.makeText(this,"пользователь $login авторизован", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPassword.text.clear()
                    val intent = Intent(this, Activity3::class.java)
                    startActivity(intent)

                }
                else
                    Toast.makeText(this,"пользователь $login не существует", Toast.LENGTH_LONG).show()
                userLogin.text.clear()
                userPassword.text.clear()
            }
        }
    }
}