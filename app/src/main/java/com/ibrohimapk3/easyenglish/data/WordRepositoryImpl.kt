package com.ibrohimapk3.easyenglish.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.ibrohimapk3.easyenglish.data.local.DaoForVocabulary
import com.ibrohimapk3.easyenglish.data.local.WordEntity
import com.ibrohimapk3.easyenglish.domain.Word
import com.ibrohimapk3.easyenglish.domain.VocabularyRepository
class WordRepositoryImpl(private val myDao: DaoForVocabulary) : VocabularyRepository {

    private val wordList = mutableListOf<Word>()
    private val liveData = MutableLiveData<List<Word>>(wordList)

    override fun getWordList(): LiveData<List<Word>> {
        return myDao.getAllItem().map { list ->
            list.map { Word(it.id,  it.russian.toString(), it.english.toString()) }
        }
    }
    override suspend fun addWordList(words: Word) {
        myDao.insertItem(
            WordEntity(
                words.id, words.english, words.russian
            )
        )
        wordList.add(words)
        liveData.value = wordList
    }
    override suspend fun deleteItem(words: Word) {
        myDao.deleteItemByTitle(
            words.english
        )
        wordList.remove(words)
        liveData.value = wordList
    }

}