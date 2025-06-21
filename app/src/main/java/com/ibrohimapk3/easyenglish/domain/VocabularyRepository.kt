package com.ibrohimapk3.easyenglish.domain

import androidx.lifecycle.LiveData

interface VocabularyRepository {
    fun getWordList(): LiveData<MutableList<Word>>
    suspend fun addWordList(words : Word)
    suspend fun deleteItem(words : Word)
}