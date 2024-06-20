package com.example.boardgames

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class GamesAdapter(
    var context: Context,
    var nameList: ArrayList<String>,
    var imageList: ArrayList<Int>
) :BaseAdapter() {
    override fun getCount(): Int {
        return nameList.size
    }

    override fun getItem(position: Int): Any? {
        return nameList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.custom_layout, parent, false)
        var gameName : TextView = view.findViewById(R.id.textView)
        var gameImage : ImageView =view.findViewById(R.id.imageView)

        gameName.text = nameList.get(position)
        gameImage.setImageResource(imageList.get(position))

        return view
    }

}