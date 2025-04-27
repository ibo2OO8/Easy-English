package com.ibrohimapk3.easyenglish.domain.UseCase

import com.ibrohimapk3.easyenglish.domain.Word

import com.ibrohimapk3.easyenglish.domain.VocabularyRepository

class AddWordUseCase(private val vocabularyRepository: VocabularyRepository){
    fun addWord(words : Word){
        vocabularyRepository.addWordList(words)
    }
}