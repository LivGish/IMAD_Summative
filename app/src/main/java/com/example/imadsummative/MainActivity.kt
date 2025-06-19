package com.example.imadsummative

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val songs = arrayListOf<String>()
    val names = arrayListOf<String>()
    val ratings = arrayListOf<Int>()
    val comments = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //declare variables to be used in the code
        val btnPlaylist = findViewById<Button>(R.id.btnPlaylist)

        //declare variables to be used in the code
        val btnNext = findViewById<Button>(R.id.btnNext)

        //declare variables to be used in the code
        val btnExit = findViewById<Button>(R.id.btnExit)

        //declare variables to be used in the code
        val inputComment = findViewById<EditText>(R.id.edtComment)

        //declare variables to be used in the code
        val inputSong = findViewById<EditText>(R.id.edtSong)

        //declare variables to be used in the code
        val inputName = findViewById<EditText>(R.id.edtName)

        //declare variables to be used in the code
        val inputRating = findViewById<EditText>(R.id.edtRating)

        //declare variables to be used in the code
        val txtDisplay = findViewById<TextView>(R.id.txtDisplay)

        var count = 0

        //displays text when app runs
        txtDisplay.text = """
            Welcome to the playlist app. 
            Add the details for the songs 
            of your choice into the spaces
            below then click 'add to playlist' 
            to add them to your playlist. Click 
            next to go to the next page when 
            you are done.
        """.trimIndent()

        while (count < 4) {

            //when user clicks button, code will run
            btnPlaylist.setOnClickListener {

                //changes user input to a string variable
                val song = inputSong.text.toString()
                //changes user input to a string variable
                val name = inputName.text.toString()
                //changes user input to a string variable
                val ratingStr = inputRating.text.toString()
                //changes user input to a string variable
                val comment = inputComment.text.toString()

                //error handling for it any fields are left blank
                if (song.isBlank() || name.isBlank() || ratingStr.isBlank()) {
                    //displays a message that tells the user to fill in missing information
                    Toast.makeText(
                        this,
                        "Please fill in all required fields (song name, artist name, and rating).",
                        Toast.LENGTH_SHORT
                    ).show()
                    //Exit button click to avoid adding invalid data
                    return@setOnClickListener
                }

                //convert rating from string to int
                val rating = ratingStr.toIntOrNull()

                //display an error message if the number is invalid
                if (rating == null || rating < 0 || rating > 5) {
                    Toast.makeText(
                        this,
                        "Quantity must be a whole number between 0 and 5.",
                        Toast.LENGTH_SHORT
                    ).show()
                    //exit button click to avoid adding invalid data
                    return@setOnClickListener
                } else {
                    // Now Kotlin knows rating is non-null inside here
                    ratings.add(rating)
                }


                //If input is valid, add information into respective lists
                songs.add(song)
                names.add(name)
                comments.add(comment)

                //attach lists as extra data to send to next screen
                val intent = Intent(this, MainActivity2::class.java)
                intent.putStringArrayListExtra("songs", songs)
                intent.putStringArrayListExtra("names", names)
                intent.putIntegerArrayListExtra("ratings", ratings)
                intent.putStringArrayListExtra("comments", comments)
                startActivity(intent)

            }
            count += 1
        }
            //switch to next screen when button is pressed
            btnNext.setOnClickListener {
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            }

            btnExit.setOnClickListener {
                //closes the app when the button is clicked; This code was adapted from a a Stack Overflow response by "James_Duh" (2018): https://stackoverflow.com/questions/51831820/how-to-close-android-application-in-kotlin
                finishAffinity()
            }


    }
}


// Title: How to navigate from one page to another on android? (Total:3 pages)
// Author: Zer0 on StackOverflow
// Date: 22 June 2014
// Version: 1.0
// Available: https://stackoverflow.com/questions/10036157/how-to-navigate-from-one-page-to-another-on-androidtotal3-pages

// Title: How to close Android application in Kotlin
// Author: James_Duh on StackOverflow
// Date: 14 August 2018
// Version: 1.0
// Available: https://stackoverflow.com/questions/51831820/how-to-close-android-application-in-kotlin