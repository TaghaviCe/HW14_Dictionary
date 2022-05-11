package com.example.hw14_dictionary

import android.content.Context
import androidx.lifecycle.LiveData

object WordRepository {
    var db:AppDatabase?=null
    var wordDao:WordDao?=null

    fun initDB(context: Context) {
        db = AppDatabase.getAppDataBase(context)
        wordDao=db?.wordDao()
        adddata()
    }

    private fun adddata() {
        wordDao?.addWord(WordEntity("hello","سلام","aaa","bbb","ccc"))
    }

    fun insertAccount(wordEntity: WordEntity){
        wordDao?.addWord(wordEntity)
    }

    fun getEnglishWord(englishWordEntity: String):WordEntity?{
        return wordDao?.getEnglishWord(englishWordEntity)
    }

    fun getPersianWord(persianWordEntity: String):WordEntity?{
        return wordDao?.getPersianWord(persianWordEntity)
    }

    fun deleteWord(wordEntity: WordEntity){
        wordDao?.deleteWord(wordEntity)
    }

    fun getCountAllWord():LiveData<Int>?{
       return wordDao?.getCount()
    }
}