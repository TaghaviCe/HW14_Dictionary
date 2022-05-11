package com.example.hw14_dictionary

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel (app: Application) : AndroidViewModel(app) {
    lateinit var wordCount: LiveData<Int>
    var englishWord= MutableLiveData<String>()
    var persianWord=MutableLiveData<String>()

    init {
        WordRepository.initDB(app.applicationContext)
        wordCount= WordRepository.getCountAllWord()!!
    }

    fun getAllWord(): LiveData<Int>? {
        wordCount= WordRepository.getCountAllWord()!!
        return WordRepository.getCountAllWord()
    }

    fun addWord(wordEntity: WordEntity){
        WordRepository.insertAccount(wordEntity)
    }
    fun getPersianWord(persianWord:String):WordEntity?{
        return WordRepository.getPersianWord(persianWord)
    }

    fun getEnglishWord(englishWord:String):WordEntity?{
        return WordRepository.getEnglishWord(englishWord)
    }

    fun deleteWord(wordEntity: WordEntity){
        WordRepository.deleteWord(wordEntity)
    }



}