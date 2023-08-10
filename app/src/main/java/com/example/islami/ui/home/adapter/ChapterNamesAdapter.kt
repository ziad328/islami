package com.example.islami.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R

class ChapterNamesAdapter(private val items: List<String>) :
    RecyclerView.Adapter<ChapterNamesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_chapter_name, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.chapterName.text = items[position]
        holder.itemView.setOnClickListener {
            onChapterClick.invoke(items[position], position)
        }
    }

    class ViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {

        val chapterName: TextView = viewItem.findViewById(R.id.chapter_name)

    }

    lateinit var onChapterClick: ((String, Int) -> Unit)

}