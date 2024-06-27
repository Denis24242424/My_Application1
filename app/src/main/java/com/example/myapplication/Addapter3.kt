package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class Addapter3(var items: List<Item>, var contex: Context): RecyclerView.Adapter<Addapter3.myViewHolder>() {
    class myViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val Name: TextView = view.findViewById(R.id.item_item3)
        val prodname: TextView = view.findViewById(R.id.item_prodname3)
        val price: TextView = view.findViewById(R.id.item_price3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.iteminlist, parent, false)
        return myViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        holder.Name.text = items[position].Name
        holder.price.text = items[position].price.toString()
        holder.prodname.text = items[position].prodname.toString()

    }

}