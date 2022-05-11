package com.example.hw14_dictionary

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WordEntity(
    @PrimaryKey var englishWord:String,
    var persianWord:String,
    var wordDetails:String,
    var synonym : String,
    val wordUrl : String
)
