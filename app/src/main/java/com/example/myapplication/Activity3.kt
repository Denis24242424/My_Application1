package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_3)
        val itemsList: RecyclerView = findViewById(R.id.item3)
        val items = arrayListOf<Item>()
        items.add(Item(1,"Валера", "Ножницы",200))
        items.add(Item(2,"Маша", "Платье",3000))
        items.add(Item(3,"Миша", "Перчатки",500))
        items.add(Item(4,"Ваня", "Дрель",9000))
        items.add(Item(5,"Александр", "Процессор",30000))
        items.add(Item(6,"Катя", "Кросовки",10000))
        items.add(Item(7,"Лиза", "Макияж",500))
        items.add(Item(8,"Вика", "Руль от автомобиля ",20000))
        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = Addapter3(items,this)
        }
    }
