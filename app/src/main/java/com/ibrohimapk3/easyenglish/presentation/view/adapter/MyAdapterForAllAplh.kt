package com.ibrohimapk3.easyenglish.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.ibrohimapk3.easyenglish.R


class MyAdapterForAllAplh() : RecyclerView.Adapter<MyAdapterForAllAplh.ViewHolder>() {

    val letters: List<Char> = ('a'..'z').toList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_for_alphabet, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.btn1.text = letters[position].toString()

    }

    override fun getItemCount(): Int {
        return letters.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var btn1 = itemView.findViewById<Button>(R.id.btn1)

    }
}