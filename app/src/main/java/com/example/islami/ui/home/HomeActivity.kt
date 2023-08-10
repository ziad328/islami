package com.example.islami.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islami.R
import com.example.islami.ui.home.fragments.HadeethFragment
import com.example.islami.ui.home.fragments.QuranFragment
import com.example.islami.ui.home.fragments.RadioFragment
import com.example.islami.ui.home.fragments.TasbeehFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigationView = findViewById(R.id.bottom_nav)
        pushFragment(fragment = QuranFragment())
        bottomNavigationView.setOnItemSelectedListener { menuItem ->

            if (menuItem.itemId == R.id.nav_quran) {
                pushFragment(fragment = QuranFragment())
            } else if (menuItem.itemId == R.id.nav_hadeeth) {
                pushFragment(fragment = HadeethFragment())
            } else if (menuItem.itemId == R.id.nav_sebha) {
                pushFragment(fragment = TasbeehFragment())
            } else if (menuItem.itemId == R.id.nav_radio) {
                pushFragment(fragment = RadioFragment())
            }

            return@setOnItemSelectedListener true
        }

    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack("$fragment")
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}