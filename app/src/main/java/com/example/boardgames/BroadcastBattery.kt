package com.example.boardgames

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadcastBattery : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val isBatteryLow : Boolean = intent!!.getBooleanExtra("state",false)

        if (isBatteryLow){
            Toast.makeText(context,"Battery Low you should charge your phone",Toast.LENGTH_SHORT).show()
        }
        else{

        }

    }
}