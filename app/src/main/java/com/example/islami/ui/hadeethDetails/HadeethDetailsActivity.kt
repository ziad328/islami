package com.example.islami.ui.hadeethDetails

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.WindowCompat
import com.example.islami.R
import com.example.islami.ui.home.fragments.HadeethFragment


class HadeethDetailsActivity : AppCompatActivity() {

    lateinit var titleTextView: TextView
    lateinit var toolbar: Toolbar
    lateinit var hadeethContent: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hadeeth_details)
        val hadeethPosition = intent.getIntExtra(HadeethFragment.HADEETH_POSITION, 0)
        val hadeeth = readFromFile("hadeeth.txt", hadeethPosition)
        titleTextView = findViewById(R.id.hadeeth_name_tv)
        hadeethContent = findViewById(R.id.hadeeth_content)
        hadeethContent.movementMethod = ScrollingMovementMethod()
        val title = getHadeethTitle(hadeeth, hadeethPosition)
        titleTextView.text = title
        setupToolbar()
        hadeethContent.text = getHadeethContent(hadeeth, title)
    }

    private fun getHadeethContent(hadeeth: String, title: String): String {

        return hadeeth.replace(title.toRegex(), "")
    }

    private fun setupToolbar() {
        toolbar = findViewById(R.id.toolbar_hadeeth)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun readFromFile(fileName: String, position: Int): String {
        val fileContent = application.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
        return fileContent.split("#")[position]
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun getHadeethTitle(hadeeth: String, position: Int): String {
        if (position == 0) {
            return hadeeth.split("\n")[0]
        } else {
            return hadeeth.split("\n")[1]
        }
    }

}