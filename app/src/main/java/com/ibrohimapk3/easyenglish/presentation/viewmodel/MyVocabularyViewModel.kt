package com.ibrohimapk3.easyenglish.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ibrohimapk3.easyenglish.data.WordRepositoryImpl
import com.ibrohimapk3.easyenglish.data.local.MainDb
import com.ibrohimapk3.easyenglish.domain.UseCase.GetWordUseCase
import com.ibrohimapk3.easyenglish.domain.VocabularyRepository
import com.ibrohimapk3.easyenglish.domain.Word

class MyVocabularyViewModel(private val repository: VocabularyRepository) : ViewModel() {
    val listLiveData: LiveData<List<Word>>

    init {
        listLiveData = repository.getWordList()
    }
}

