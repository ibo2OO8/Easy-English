package com.ibrohimapk3.easyenglish.domain.UseCase

import com.ibrohimapk3.easyenglish.domain.LanguagesDataClass
import com.ibrohimapk3.easyenglish.domain.VocabularyRepository

class DeleteWordUseCase(private val vocabularyRepository: VocabularyRepository) {
    fun deleteWord(words : LanguagesDataClass){
        vocabularyRepository.deleteItem(words)
    }
}