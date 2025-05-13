package com.ibrohimapk3.easyenglish.domain

import androidx.lifecycle.LiveData

interface VocabularyRepository {
    fun getWordList(): LiveData<List<Word>>
    suspend fun addWordList(words : Word)
    suspend fun deleteItem(words : Word)
}