package com.ibrohimapk3.easyenglish.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ibrohimapk3.easyenglish.domain.VocabularyRepository
import com.ibrohimapk3.easyenglish.domain.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyVocabularyViewModel @Inject constructor(private val repository: VocabularyRepository) : ViewModel() {
    val listLiveData: LiveData<List<Word>>

    init {
        listLiveData = repository.getWordList()
    }
}

