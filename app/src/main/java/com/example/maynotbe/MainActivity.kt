package com.example.maynotbe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.maynotbe.R.id.appBar
import com.example.maynotbe.R.id.mainDrawer

class MainActivity : AppCompatActivity() {
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpViews()

    }

    fun setUpViews(){
        setUpDrawerLayout()
    }

    fun setUpDrawerLayout(){
        setSupportActionBar(findViewById(appBar))
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, findViewById(mainDrawer), R.string.app_name, R.string.app_name)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}