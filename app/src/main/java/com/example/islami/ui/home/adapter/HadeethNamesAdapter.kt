package com.example.islami.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class HadeethNamesAdapter(private val items: List<String>) :
    RecyclerView.Adapter<HadeethNamesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_hadeeth_name, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.hadeethName.text = items[position]
        holder.itemView.setOnClickListener {
            onHadeethClick.invoke(position)
        }
    }

    class ViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {

        val hadeethName: TextView = viewItem.findViewById(R.id.hadeeth_name)

    }

    lateinit var onHadeethClick: ((Int) -> Unit)

}