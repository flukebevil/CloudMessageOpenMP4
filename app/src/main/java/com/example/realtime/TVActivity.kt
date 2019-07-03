package com.example.realtime

import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.tv_main.*

class TVActivity : AppCompatActivity() {
    private lateinit var mediaController: MediaController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tv_main)

        mediaController = MediaController(this)
        mediaController.setAnchorView(vv)

        val url = intent?.extras?.getString(VIDEO_INTENT_KEY)
        url?.let {
            vv.setVideoPath(url)
            vv.start()
            vv.setMediaController(mediaController)
        }
    }

    companion object {
        const val VIDEO_INTENT_KEY = "video_intent_key"
    }
}