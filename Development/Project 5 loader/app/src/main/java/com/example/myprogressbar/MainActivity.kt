package com.example.myprogressbar

import android.content.DialogInterface
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private var i = 0
    private lateinit var txtView: TextView
    private val handler = Handler()
    private lateinit var mySnackbarButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById<ProgressBar>(R.id.progress_Bar) as ProgressBar

        txtView = findViewById<TextView>(R.id.text_view)

        val btn = findViewById<Button>(R.id.show_button)

        btn.setOnClickListener {
            progressBar.visibility = View.VISIBLE

            i = progressBar.progress

            Thread(Runnable {
                while (i < 100) {
                    i += 1
                    handler.post(Runnable {
                        progressBar.progress = i
//                        txtView!!.text = i.toString() + "/" + progressBar.max
                    })
                    try {
                        Thread.sleep(30)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

//                progressBar.visibility = View.GONE
                progressBar.visibility = View.INVISIBLE

            }).start()
        }

        val exitButton = findViewById<Button>(R.id.btnExitApp)
        exitButton.setOnClickListener {
            AlertDialog.Builder(this).setTitle("Warning").setMessage("Do you really want to exit the application ?")
                .setCancelable(true)
                .setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i -> finish() })
                .setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.cancel() })
                .show()
        }

        val a = ArrayList<Int>(2)
        a.add(10)
        a.add(20)
        mySnackbarButton = findViewById(R.id.mySnackbar)
        mySnackbarButton.setOnClickListener {
            Snackbar.make(mySnackbarButton, "You clicked me" , Snackbar.LENGTH_LONG)
                .setAction("OK" , View.OnClickListener { })
                .setAnimationMode(Snackbar.ANIMATION_MODE_FADE)
                .setTextColor(Color.BLACK)
                .setBackgroundTint(Color.CYAN)
                .setActionTextColor(Color.RED)
                .show()
        }
    }

}