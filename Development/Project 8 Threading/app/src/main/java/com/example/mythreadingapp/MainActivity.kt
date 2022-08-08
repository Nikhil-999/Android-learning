package com.example.mythreadingapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private var mainHandler: Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.StartButton)
    }

    fun startThreading(view: View) {
        //Below is Calling the thread method using Thread class.
//        val demo = MyThread()
//        demo.start()

        // Below is calling the Thread method using Runnable Interface.
        val myRunVar = MySecondThread(15)
        val demo2 = Thread(myRunVar)
        demo2.start()
    }
    fun stopThreading(view: View) {

    }

    // Below is creating a Thread by using Thread Class
//    class MyThread: Thread() {
//        override fun run() {
//            for(i in 0..10){
//                Log.e("myThread", "run: $i")
//                Thread.sleep(1000)
//            }
//        }
//    }

    // Below is creating a Thread by using Runnable Interface.
    inner class MySecondThread(var timer: Int) : Runnable {
        override fun run() {
            for(i in 0..timer){
                if(i == 3){
                    val insideHandler = Handler(Looper.getMainLooper())           // Looper.getMainLooper() method had to be passed to constructor or else it gives error.
                    insideHandler.post(
                        Runnable {
                            run(){
                                button.text = "using Inner handler."
                                button.setBackgroundColor(Color.RED)
                            }
                        }
                    )


                }

                if(i == 6){
                    mainHandler.post(                                             //// Here handler is posting 'inside code' to UI(main) thread hence it is working.
                        Runnable {
                            run(){
                                button.text = "using Main Handler."
                                button.setBackgroundColor(Color.GREEN)
                            }
                        }
                    )
                }

                if(i == 9){
                    button.post(
                        Runnable {
                            run(){
                                button.text = "Using button.post method"
                                button.setBackgroundColor(Color.MAGENTA)
                            }
                        }
                    )
                }

                if(i == 12){
                    runOnUiThread(Runnable {                            // this method is an Activity method.
                        run(){
                            button.text = "Using runOnUiThread Method"
                            button.setBackgroundColor(Color.CYAN)
                        }
                    })
                }
                Log.e("Runnable Thread" , "We are doing runnable thread $i")
                Thread.sleep(1000)
            }
        }
    }
}