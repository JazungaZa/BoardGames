package com.example.boardgames

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Game : AppCompatActivity() {

    lateinit var naslov : TextView
    lateinit var slika : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLinearVertical)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        naslov = findViewById(R.id.textViewNaslov1)
        slika = findViewById(R.id.imageViewIgra)

        naslov.text = intent.getStringExtra("gameName").toString()
        slika.setImageResource(intent.getIntExtra("gameImage",0))

    }
}