package com.ibrohimapk3.easyenglish.domain.UseCase

import com.ibrohimapk3.easyenglish.domain.Word
import com.ibrohimapk3.easyenglish.domain.VocabularyRepository

class DeleteWordUseCase(private val vocabularyRepository: VocabularyRepository) {
   suspend fun deleteWord(words : Word){
        vocabularyRepository.deleteItem(words)
    }
}