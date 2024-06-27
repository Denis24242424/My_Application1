package com.example.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

class dphelp (val context: Context, val factory: SQLiteDatabase.CursorFactory?): SQLiteOpenHelper(context, "app", factory,1 ) {
    override fun onCreate(dp: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INT PRIMARY KEY, login TEXT, email TEXT, password TEXT)"
        dp!!.execSQL(query)
    }

    override fun onUpgrade(dp: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        dp!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(dp)
    }
    fun addUser(user: User) {
        val values = ContentValues()
        values.put("login", user.login)
        values.put("email", user.email)
        values.put("password", user.password)
        val dp = this.writableDatabase
        dp.insert("users",null, values)
        dp.close()
    }
    fun getUser(login:String, password:String): Boolean{
        val dp = this.readableDatabase
        val result = dp.rawQuery("SELECT * FROM users WHERE login = '$login' AND password = '$password'",null)
        return result.moveToFirst()
    }

}