package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import storage.AppPreferences
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    var textHighScore : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val btnNewGame = findViewById<Button>(R.id.new_game)
        val btnReset = findViewById<Button>(R.id.reset)
        val btnExit = findViewById<Button>(R.id.exit)
        val textHighScore = findViewById<TextView>(R.id.high_score)

        btnNewGame.setOnClickListener(this::onBtnNewGameClick)
        btnExit.setOnClickListener(this::onBtnExitClick)
        btnReset.setOnClickListener(this::onBtnResetClick)
    }

    private fun onBtnNewGameClick(view: View) {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    @SuppressLint("SetTextI18n")
    private fun onBtnResetClick(view: View) {
        val preferences = AppPreferences(this)
        preferences.clearHighSore()
        Snackbar.make(
            view, "Score successfully reset",
            Snackbar.LENGTH_SHORT
        ).show()
        textHighScore?.text = "High score: ${preferences.getHighScore()}"
    }

    private fun onBtnExitClick(view: View) {
        exitProcess(0)
    }
}