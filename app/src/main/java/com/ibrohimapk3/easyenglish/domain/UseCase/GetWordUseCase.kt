package com.ibrohimapk3.easyenglish.domain.UseCase

import androidx.lifecycle.LiveData
import com.ibrohimapk3.easyenglish.domain.Word
import com.ibrohimapk3.easyenglish.domain.VocabularyRepository

class GetWordUseCase(private var vocabularyRepository: VocabularyRepository) {
    fun getWordList(): LiveData<List<Word>> {
        return vocabularyRepository.getWordList()
    }
}