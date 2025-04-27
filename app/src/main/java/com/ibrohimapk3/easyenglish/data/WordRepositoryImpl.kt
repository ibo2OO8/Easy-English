package com.ibrohimapk3.easyenglish.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ibrohimapk3.easyenglish.data.local.DaoForVocabulary
import com.ibrohimapk3.easyenglish.data.local.WordEntity
import com.ibrohimapk3.easyenglish.domain.Word
import com.ibrohimapk3.easyenglish.domain.VocabularyRepository

class WordRepositoryImpl(private val myDao: DaoForVocabulary) : VocabularyRepository {

    private val wordList = mutableListOf<Word>()
    private val liveData = MutableLiveData<List<Word>>(wordList)

    override fun getWordList(): LiveData<List<Word>> {
        return liveData
    }

    override fun addWordList(words: Word) {
        myDao.insertItem(
            WordEntity(
                words.id, words.english, words.russian
            )
        )
        wordList.add(words)
        liveData.value = wordList
    }

    override fun deleteItem(words: Word) {
        myDao.insertItem(
            WordEntity(
                words.id, words.english, words.russian
            )
        )
        wordList.remove(words)
        liveData.value = wordList
    }
}