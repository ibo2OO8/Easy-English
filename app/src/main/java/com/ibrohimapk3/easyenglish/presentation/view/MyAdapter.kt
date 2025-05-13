package com.ibrohimapk3.easyenglish.presentation.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ibrohimapk3.easyenglish.R
import com.ibrohimapk3.easyenglish.domain.Word

class MyAdapter() : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    var shopList = listOf<Word>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shopItem = shopList[position]
        holder.tvEng.text = shopItem.english
        holder.tvRus.text = shopItem.russian
    }

    override fun getItemCount(): Int = shopList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvEng = view.findViewById<TextView>(R.id.tv_english)
        val tvRus = view.findViewById<TextView>(R.id.tv_russian)
    }

    fun setList(list: List<Word>) {
        shopList = list
        notifyDataSetChanged()
    }
}
