package com.example.appcomponents.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import com.example.appcomponents.R

import kotlinx.android.synthetic.main.activity_send.*

class SendActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        processIntent()
    }

    private fun processIntent() {
        val intent = intent
        if (intent.action == Intent.ACTION_SEND && intent.hasExtra(Intent.EXTRA_TEXT)) {
            send(intent.getStringExtra(Intent.EXTRA_TEXT)!!)
        }
    }

    private fun send(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

}
