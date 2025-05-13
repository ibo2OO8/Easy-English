package com.ibrohimapk3.easyenglish.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ibrohimapk3.easyenglish.data.WordRepositoryImpl
import com.ibrohimapk3.easyenglish.data.local.MainDb
import com.ibrohimapk3.easyenglish.domain.UseCase.GetWordUseCase
import com.ibrohimapk3.easyenglish.domain.Word
class MyVocabularyViewModel(application: Application) : AndroidViewModel(application) {
    private val getWordUseCase: GetWordUseCase
    val listLiveData: LiveData<List<Word>>

    init {
        val dao = MainDb.getDb(application).getDao()
        val wordRepositoryImpl = WordRepositoryImpl(dao)
        getWordUseCase = GetWordUseCase(wordRepositoryImpl)
        listLiveData = getWordUseCase.getWordList()
    }
}

