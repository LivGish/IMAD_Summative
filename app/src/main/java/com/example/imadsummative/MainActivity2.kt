package com.example.imadsummative

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        //declare variables to be used in the code
        val btnPlaylist = findViewById<Button>(R.id.btnPlaylist)

        //declare variables to be used in the code
        val btnAverage = findViewById<Button>(R.id.btnAverage)

        //declare variables to be used in the code
        val btnBack = findViewById<Button>(R.id.btnBack)

        //declare variables to be used in the code
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)

        val songs = arrayListOf<String>()
        val names = arrayListOf<String>()
        val ratings = arrayListOf<Int>()
        val comments = arrayListOf<String>()

        var count = 0

        var average = 0

        //get data from previous screen
        val intent = Intent(this, MainActivity2::class.java)
        intent.getStringArrayListExtra("songs") ?: arrayListOf()
        intent.getStringArrayListExtra("names") ?: arrayListOf()
        intent.getIntegerArrayListExtra("ratings") ?: arrayListOf()
        intent.getStringArrayListExtra("comments") ?: arrayListOf()
        startActivity(intent)

        //displays details from all 4 songs
        while (count < 4){
            btnPlaylist.setOnClickListener{
                txtDisplay.text = """
                    Song name: $songs[count]
                    Artist name: $names[count]
                    Rating: $ratings[count]
                    Comment: $comments[count]
                """.trimIndent()

            }
        }

        //calculates average rating when button is clicked
        btnAverage.setOnClickListener{
            average = ratings[0] + ratings[1] + ratings[2] + ratings [3]
            average = average / 4
            txtDisplay.text = "The average rating of the songs in your playlist is: $average"

        }
        //switch to next screen when button is pressed
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}