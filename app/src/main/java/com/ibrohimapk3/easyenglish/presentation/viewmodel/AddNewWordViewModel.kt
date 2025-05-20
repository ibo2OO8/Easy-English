package com.ibrohimapk3.easyenglish.presentation.viewmodel

import android.app.Application
import android.widget.ImageView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrohimapk3.easyenglish.data.WordRepositoryImpl
import com.ibrohimapk3.easyenglish.data.local.DaoForVocabulary
import com.ibrohimapk3.easyenglish.data.local.MainDb
import com.ibrohimapk3.easyenglish.domain.UseCase.AddWordUseCase
import com.ibrohimapk3.easyenglish.domain.UseCase.DeleteWordUseCase
import com.ibrohimapk3.easyenglish.domain.UseCase.GetWordUseCase
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