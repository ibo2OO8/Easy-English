package com.ibrohimapk3.easyenglish.domain.UseCase

import androidx.lifecycle.LiveData
import com.ibrohimapk3.easyenglish.domain.Word
import com.ibrohimapk3.easyenglish.domain.VocabularyRepository

class GetWordUseCase(private var vocabularyRepository: VocabularyRepository) {
    fun getWordList(): LiveData<MutableList<Word>> {
        return vocabularyRepository.getWordList()
    }
}