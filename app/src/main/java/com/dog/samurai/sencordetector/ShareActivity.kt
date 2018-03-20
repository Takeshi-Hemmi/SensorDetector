package com.dog.samurai.sencordetector

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class ShareActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_share)
        val intent = intent
        val data = intent.data

        if (intent.type.indexOf("image/") != -1) {

        } else if (intent.type == "text/plain") {

        }

        val result = Intent("com.dog.samurai.RESULT_ACTION", Uri.parse("content://result_uri"))
        finish()

    }
}