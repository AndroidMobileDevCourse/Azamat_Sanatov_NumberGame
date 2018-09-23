package com.ozaki.numberproject

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.TextView
import java.util.*

class NumberCompares : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_compares)
        val number1 = findViewById<TextView>(R.id.first_number)
        val number2 = findViewById<TextView>(R.id.second_number)
        number1.apply {
            text = ""+(Random().nextInt((10-1))+1)
        }
        number2.apply {
            text = ""+ (Random().nextInt((10-1))+1)
        }

        val score = intent.getStringExtra(EXTRA_MESSAGE)
        if (score != null){
            val textview =findViewById<TextView>(R.id.score_count).apply {
                text = score
            }}
    }
    fun less(view: View) {
        val number1 = findViewById<TextView>(R.id.first_number)
        val number2 = findViewById<TextView>(R.id.second_number)
        val scores = findViewById<TextView>(R.id.score_count)
        val fn = Integer.parseInt(number1.text.toString())
        val sn = Integer.parseInt(number2.text.toString())
        val sc = Integer.parseInt(scores.text.toString())

        if (fn<sn) {
            scores.apply { text = ""+(sc+1) }
        } else{
            scores.apply { text = ""+(sc-1) }
        }
        number1.apply {
            text = ""+(Random().nextInt((10-1))+1)
        }
        number2.apply {
            text = ""+ (Random().nextInt((10-1))+1)
        }
        checkforfinish()
        }
    fun equal(view: View) {
        val number1 = findViewById<TextView>(R.id.first_number)
        val number2 = findViewById<TextView>(R.id.second_number)
        val scores = findViewById<TextView>(R.id.score_count)
        val fn = Integer.parseInt(number1.text.toString())
        val sn = Integer.parseInt(number2.text.toString())
        val sc = Integer.parseInt(scores.text.toString())

        if (fn==sn) {
            scores.apply { text = ""+(sc+1) }
        } else{
            scores.apply { text = ""+(sc-1) }
        }
        number1.apply {
            text = ""+(Random().nextInt((10-1))+1)
        }
        number2.apply {
            text = ""+ (Random().nextInt((10-1))+1)
        }
        checkforfinish()
    }
    fun bigger(view: View) {
        val number1 = findViewById<TextView>(R.id.first_number)
        val number2 = findViewById<TextView>(R.id.second_number)
        val scores = findViewById<TextView>(R.id.score_count)
        val fn = Integer.parseInt(number1.text.toString())
        val sn = Integer.parseInt(number2.text.toString())
        val sc = Integer.parseInt(scores.text.toString())

        if (fn>sn) {
            scores.apply { text = ""+(sc+1) }
        } else{
            scores.apply { text = ""+(sc-1) }
        }
        number1.apply {
            text = ""+(Random().nextInt((10-1))+1)
        }
        number2.apply {
            text = ""+ (Random().nextInt((10-1))+1)
        }
        checkforfinish()
    }
    fun checkforfinish(){
        val scores = findViewById<TextView>(R.id.score_count)
        val scc = Integer.parseInt(scores.text.toString())
        if (scc>=10){
            uwon()
        }else if (scc<=0){
            ulose()
        }
    }
    fun go_back_mm(view: View){
        val scores = findViewById<TextView>(R.id.score_count)
        val score = scores.text.toString()
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, score)
        }
        startActivity(intent)

    }



    fun uwon(){
        val intent = Intent(this, MainActivity::class.java)
        val builder = AlertDialog.Builder(this)
        builder.setTitle("You Won!")
        builder.setMessage("You have won the game!")
        builder.setPositiveButton("Yes") { _: DialogInterface, _: Int ->
            startActivity(intent)
        }
        builder.show()
    }
    fun ulose(){
        val intent = Intent(this, MainActivity::class.java)
        val builder = AlertDialog.Builder(this)
        builder.setTitle("You lose!")
        builder.setMessage("You have lose the game!")
        builder.setPositiveButton("Ok") { _: DialogInterface, _: Int ->
            startActivity(intent)
        }
        builder.show()
    }
    }



