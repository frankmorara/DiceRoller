package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
            rollDice2()
        }

//        Do a dice roll when the app starts
        rollDice()
        rollDice2()


    }

    /**
     * Roll the dice and update the screen with the result
     */

    private fun rollDice() {
//        Create new Dice object with 6 sides and roll the dice
        val dice = Dice(6)
        val diceRoll = dice.roll()
//        Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView3)
//            This code calls the `setImageResource()` method on the `ImageView`, passing the resource ID for the `dice_2` image. This will update the `ImageView` on screen to display the `dice_2` image.
//        diceImage.setImageResource(R.drawable.dice_1)

//        Determine which drawable resource ID to use based on the dice roll
       val drawableResource =  when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
//        Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()

    }
    private fun rollDice2(){
        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        val drawableResource2 =  when(diceRoll2){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage2.setImageResource(drawableResource2)
        diceImage2.contentDescription = diceRoll2.toString()

    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}