package com.ibrohimapk3.easyenglish.domain

import androidx.lifecycle.LiveData

interface VocabularyRepository {
    fun getWordList(): LiveData<List<LanguagesDataClass>>
    fun addWordList(words : LanguagesDataClass)
    fun deleteItem(words : LanguagesDataClass)
}