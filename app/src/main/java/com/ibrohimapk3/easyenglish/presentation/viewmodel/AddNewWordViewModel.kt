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
import com.ibrohimapk3.easyenglish.domain.Word
import kotlinx.coroutines.launch

class AddNewWordViewModel(application: Application) : AndroidViewModel(application) {
    var wordRepositoryImpl: WordRepositoryImpl

    init {
        var dao = MainDb.getDb(application).getDao()
        wordRepositoryImpl = WordRepositoryImpl(dao)

    }

    var addWordUseCase = AddWordUseCase(wordRepositoryImpl)
    var deleteWordUseCase = DeleteWordUseCase(wordRepositoryImpl)
    var getWordUseCase = GetWordUseCase(wordRepositoryImpl)
    fun addWord(word: Word) {
        viewModelScope.launch {
            addWordUseCase.addWord(word)
        }
    }
}