package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val userLogin: EditText = findViewById(R.id.user_Login)
        val userEmail: EditText = findViewById(R.id.user_Email)
        val userPassword: EditText = findViewById(R.id.user_pass)
        val button: Button = findViewById(R.id.button_reg)
        val linktoregistr: TextView = findViewById(R.id.link_to_registr)
        linktoregistr.setOnClickListener{
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)
        }
        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val password = userPassword.text.toString().trim()
            if(login == "" || email == "" || password == "")
                Toast.makeText(this,"не все поля заполнены",Toast.LENGTH_LONG).show()
            else {
                val user = User(login, email,password)
                val dp = dphelp(this, null)
                dp.addUser(user)
                userLogin.text.clear()
                userEmail.text.clear()
                userPassword.text.clear()
                Toast.makeText(this,"пользователь $login добавлен",Toast.LENGTH_LONG).show()
            }
        }
    }

}

