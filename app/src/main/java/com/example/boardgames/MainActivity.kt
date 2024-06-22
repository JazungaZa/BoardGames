package com.example.boardgames

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var gridView : GridView

    var nameList = ArrayList<String>()
    var imageList = ArrayList<Int>()
    var battery = BroadcastBattery()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLinearVertical)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        gridView = findViewById(R.id.gridView)
        val gameNames = resources.getStringArray(R.array.board_games)
        nameList.addAll(gameNames)
        fillImages()

        val adapter = GamesAdapter(this, nameList, imageList)
        gridView.adapter = adapter

        gridView.setOnItemClickListener { adapterView, view, position, id ->

            var gameName : String = nameList.get(position)
            var gameImage : Int = imageList.get(position)

            var  intent = Intent(this@MainActivity, Game::class.java)

           intent.putExtra("gameName", gameName)
            intent.putExtra("gameImage",gameImage)

            startActivity(intent)

            //Toast.makeText(applicationContext, "We are playing: ${nameList.get(position)}", Toast.LENGTH_SHORT).show()

        }
        var filter = IntentFilter()
        filter.addAction(Intent.ACTION_BATTERY_LOW)
        this.registerReceiver(battery,filter)



    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(battery)
    }
    fun fillImages(){
        imageList.add(R.drawable.alias)
        imageList.add(R.drawable.hive)
        imageList.add(R.drawable.spark)
        imageList.add(R.drawable.codenames)
        imageList.add(R.drawable.railroad)
        imageList.add(R.drawable.werewolf)
        imageList.add(R.drawable.similo)
        imageList.add(R.drawable.selfish)
        imageList.add(R.drawable.azul)
        imageList.add(R.drawable.skull)
        imageList.add(R.drawable.astra)
        imageList.add(R.drawable.rummy)
        imageList.add(R.drawable.catan)
        imageList.add(R.drawable.dixit)
        imageList.add(R.drawable.pandemic)
        imageList.add(R.drawable.rizik)
    }
}