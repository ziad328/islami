package com.example.islami.ui.chapterDetails.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class ChapterDetailsAdapter(private val items: List<String>) :
    RecyclerView.Adapter<ChapterDetailsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_verse, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.verse.text = items[position]
    }

    class ViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {

        val verse: TextView = viewItem.findViewById(R.id.verse)
    }
}

