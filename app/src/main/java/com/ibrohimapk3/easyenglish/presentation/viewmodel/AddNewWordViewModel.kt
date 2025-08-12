package com.ibrohimapk3.easyenglish.presentation.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrohimapk3.easyenglish.domain.VocabularyRepository
import com.ibrohimapk3.easyenglish.domain.Word
import kotlinx.coroutines.launch
class AddNewWordViewModel(private val repository: VocabularyRepository) : ViewModel() {
    fun addWord(word: Word) {
        viewModelScope.launch {
            repository.addWordList(word)
        }
    }
}