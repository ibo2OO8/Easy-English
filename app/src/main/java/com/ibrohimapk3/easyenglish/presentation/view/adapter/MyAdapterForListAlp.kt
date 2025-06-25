package com.ibrohimapk3.easyenglish.presentation.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ibrohimapk3.easyenglish.R
import com.ibrohimapk3.easyenglish.domain.Word
import com.ibrohimapk3.easyenglish.presentation.view.callBack.CallBack
import com.ibrohimapk3.easyenglish.presentation.view.callBack.CallBackForListAlp

class MyAdapterForListAlp( var callBack: CallBackForListAlp
) : RecyclerView.Adapter<MyAdapterForListAlp.ViewHolder>() {
    var shopList = mutableListOf<Word>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_for_list_alph, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shopItem = shopList[position]
        holder.tvEng.text = shopItem.english
        holder.tvRus.text = shopItem.russian
        holder.btnDelete.setOnClickListener {

            callBack.sound(shopItem)
        }
    }

    override fun getItemCount(): Int = shopList.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvEng = view.findViewById<TextView>(R.id.tv_english)
        val tvRus = view.findViewById<TextView>(R.id.tv_russian)
        val btnDelete = view.findViewById<Button>(R.id.btn_delete)
    }
    fun setList(list: MutableList<Word>) {
        shopList = list
        notifyDataSetChanged()
    }
}