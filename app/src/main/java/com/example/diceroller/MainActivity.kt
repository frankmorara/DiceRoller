package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            val resultTextView: TextView = findViewById(R.id.textView)
//            resultTextView.text = "6"
//            Toast.makeText(this,"Dice Rolled!",Toast.LENGTH_LONG).show()
            rollButton.setOnClickListener {
                rollDice()
                rollDice2()
            }
//            Toast.makeText(this, "Dice Rolled !", Toast.LENGTH_LONG).show()

        }

    }

    private fun rollDice2() {
        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()
        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView2.text = diceRoll2.toString()

    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}