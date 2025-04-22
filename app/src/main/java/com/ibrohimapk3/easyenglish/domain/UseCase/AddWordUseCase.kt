package com.ibrohimapk3.easyenglish.domain.UseCase

import com.ibrohimapk3.easyenglish.domain.LanguagesDataClass

import com.ibrohimapk3.easyenglish.domain.VocabularyRepository

class AddWordUseCase(private val vocabularyRepository: VocabularyRepository){
    fun addWord(words : LanguagesDataClass){
        vocabularyRepository.addWordList(words)
    }
}