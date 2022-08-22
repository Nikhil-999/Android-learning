package com.example.exoplayerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.ui.StyledPlayerView

class MainActivity : AppCompatActivity() , Player.Listener {
    private lateinit var myPlayer: ExoPlayer
    private lateinit var myPlayerView: PlayerView
    private lateinit var myProgressbar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myProgressbar = findViewById(R.id.progressBar)
        myPlayerView = findViewById(R.id.myPlayerView)

        setupPlayer()
        addmp3files()


    }

    private fun setupPlayer(){
        myPlayer = ExoPlayer.Builder(this).build()
        myPlayerView.player = myPlayer
        myPlayer.addListener(this)
    }

    private fun addmp3files(){
        val mediaItem = MediaItem.fromUri(getString(R.string.myOwn_mp3))
        myPlayer.setMediaItem(mediaItem)
        myPlayer.prepare()
    }

    override fun onPlaybackStateChanged(playbackState: Int) {
        super.onPlaybackStateChanged(playbackState)

        when(playbackState){
            Player.STATE_BUFFERING -> {
                myProgressbar.visibility = View.VISIBLE
            }
            Player.STATE_READY -> {
                myProgressbar.visibility = View.INVISIBLE
            }
        }
    }

//    override fun onMediaMetadataChanged(mediaMetadata: MediaMetadata) {
//        super.onMediaMetadataChanged(mediaMetadata)
//     this function is for setting up the title of the video.
//    }


}