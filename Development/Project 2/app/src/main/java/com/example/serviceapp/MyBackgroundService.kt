package com.example.serviceapp

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyBackgroundService : Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Thread(
            Runnable {
                fun run(){
                    while (true){
                        Log.e("Service", "This is the service running in the background.", )
                        Thread.sleep(2000)
                    }
                }
            }
        ).start()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}