package com.ibrohimapk3.easyenglish.domain

import androidx.lifecycle.LiveData

interface VocabularyRepository {
    fun getWordList(): LiveData<List<Word>>
    fun addWordList(words : Word)
    fun deleteItem(words : Word)
}