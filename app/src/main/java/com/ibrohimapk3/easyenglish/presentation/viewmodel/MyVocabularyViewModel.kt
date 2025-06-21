package com.ibrohimapk3.easyenglish.presentation.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrohimapk3.easyenglish.domain.VocabularyRepository
import com.ibrohimapk3.easyenglish.domain.Word
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyVocabularyViewModel(private val repository: VocabularyRepository) : ViewModel() {
    val listLiveData: LiveData<MutableList<Word>>

    init {
        listLiveData = repository.getWordList()
    }

    fun deleteWord(word: Word){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteItem(word)
        }
    }
}

