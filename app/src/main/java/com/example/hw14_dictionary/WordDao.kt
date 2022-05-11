package com.example.hw14_dictionary

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordDao {
    @Query("SELECT * FROM WordEntity WHERE persianWord LIKE :persianWordEntity")
    fun getPersianWord(persianWordEntity: String?):WordEntity

    @Query("SELECT * FROM WordEntity WHERE englishWord LIKE :englishWordEntity")
    fun getEnglishWord(englishWordEntity: String?):WordEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addWord(vararg word:WordEntity)

    @Query ("SELECT COUNT(*) FROM WordEntity")
    fun getCount(): LiveData<Int>

    @Update
    fun updateWord(word:WordEntity)

    @Delete(entity = WordEntity::class)
    fun deleteWord(word:WordEntity)

}