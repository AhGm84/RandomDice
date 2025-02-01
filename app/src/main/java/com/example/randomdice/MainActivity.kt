package com.example.randomdice

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.randomdice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            rollBtn.setOnClickListener{
                rollBtn.isEnabled=false
                rollDice()
                rollBtn.text="Repeat"
                rollBtn.isEnabled=true

            }
        }
    }
    private fun getImgDice():Int{
        return when((1..6).random()){
            1->R.drawable.tas_one
            2->R.drawable.tas_two
            3->R.drawable.tas_three
            4->R.drawable.tas_four
            5->R.drawable.tas_five
            else->R.drawable.tas_six
        }
    }
    private fun rollDice(){
        binding.apply {
            val diceRoller=object:Runnable{
                var counter=8
                override fun run() {
                    counter++
                    if (counter>20){
                        imgDice.setImageResource(getImgDice())
                        rollBtn.isEnabled=true
                    }
                    else{
                        imgDice.setImageResource(getImgDice())
                        Handler(Looper.getMainLooper()).postDelayed(this,100)

                    }
                }
            }
            Handler(Looper.getMainLooper()).postDelayed(diceRoller,0)
        }
    }
}