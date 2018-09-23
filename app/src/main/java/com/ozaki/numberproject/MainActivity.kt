package com.ozaki.numberproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_display_message.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val score = intent.getStringExtra(EXTRA_MESSAGE)
        if (score != null){
        val textview =findViewById<TextView>(R.id.textView6).apply {
            text = score
        }}

    }
    fun sendMessage(view: View){
        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
    fun playGame(view: View){
        val scores = findViewById<TextView>(R.id.textView6)
        val score = scores.text.toString()
        val intent = Intent(this, NumberCompares::class.java).apply {
            putExtra(EXTRA_MESSAGE, score)
        }
        startActivity(intent)
    }
}
