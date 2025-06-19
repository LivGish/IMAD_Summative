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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val songs = arrayListOf<String>()
        val names = arrayListOf<String>()
        val ratings = arrayListOf<Int>()
        val comments = arrayListOf<String>()

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
        val inputDisplay = findViewById<TextView>(R.id.txtDisplay)


        val songTitle = arrayOf("song0", "song1", "song2", "song3")

        val artistName = arrayOf("name0", "name1", "name2", "name3")

        val songRating = arrayOf(0, 1, 2, 3)

        val songComments = arrayOf("comment0", "comment1", "comment2", "comment3")

        //changes user input to a string variable
        val song: String = inputSong.text.toString()

        //changes user input to a string variable
        val name: String = inputName.text.toString()

        //changes user input to a string variable
        val ratingStr: String = inputRating.text.toString()

        //changes user input to a string variable
        val comment: String = inputComment.text.toString()

        //when button is clicked, data will be saved
        btnPlaylist.setOnClickListener {

            //error handling for it any fields are left blank
            if (song.isBlank() || name.isBlank() || ratingStr.isBlank()) {
                //displays a message that tells the user to fill in missing information
                Toast.makeText(
                    this,
                    "Please fill in all required fields (song name, artist name, and rating).",
                    Toast.LENGTH_SHORT
                )
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
            ratings.add(rating)
            comments.add(comment)

            //attach lists as extra data to send to next screen
            intent.putStringArrayListExtra("songs", songs)
            intent.putStringArrayListExtra("names", names)
            intent.putIntegerArrayListExtra("ratings", ratings)
            intent.putStringArrayListExtra("comments", comments)

            //switch to next screen when button is pressed
            btnNext.setOnClickListener {
                val intent = Intent(this, MainActivity2::class.java)
            }

            btnExit.setOnClickListener {
                //closes the app when the button is clicked; This code was adapted from a a Stack Overflow response by "James_Duh" (2018): https://stackoverflow.com/questions/51831820/how-to-close-android-application-in-kotlin
                finishAffinity()
            }

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