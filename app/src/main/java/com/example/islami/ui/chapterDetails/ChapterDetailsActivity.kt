package com.example.islami.ui.chapterDetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.ui.chapterDetails.adapter.ChapterDetailsAdapter

import com.example.islami.ui.home.fragments.QuranFragment

class ChapterDetailsActivity : AppCompatActivity() {

    lateinit var adapter: ChapterDetailsAdapter
    private lateinit var recyclerView: RecyclerView
    lateinit var title: TextView
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_details)
        val chapterName = intent.getStringExtra(QuranFragment.CHAPTER_NAME) as String
        val chapterPosition = intent.getIntExtra(QuranFragment.CHAPTER_POSITION, 0)
        val verses = readFromFile("${chapterPosition + 1}.txt")
        title = findViewById(R.id.chapter_name_tv)
        title.text = chapterName

        adapter = ChapterDetailsAdapter(verses)
        initRecyclerview()

        setupToolbar()

    }

    private fun setupToolbar() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun initRecyclerview() {
        recyclerView = findViewById(R.id.rv_verses)
        recyclerView.adapter = adapter
    }

    private fun readFromFile(fileName: String): List<String> {
        val fileContent = application.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
        return fileContent.split("\n")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}