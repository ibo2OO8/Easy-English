package com.ibrohimapk3.easyenglish.DI

import androidx.room.Room
import com.ibrohimapk3.easyenglish.data.WordRepositoryImpl
import com.ibrohimapk3.easyenglish.data.local.MainDb
import com.ibrohimapk3.easyenglish.domain.VocabularyRepository
import com.ibrohimapk3.easyenglish.presentation.viewmodel.AddNewWordViewModel
import com.ibrohimapk3.easyenglish.presentation.viewmodel.MyVocabularyViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            MainDb::class.java,
            "Easy english"
        ).build()
    }
    single { get<MainDb>().getDao() }

    single <VocabularyRepository> { WordRepositoryImpl(get()) }

    viewModel { MyVocabularyViewModel(get()) }
    viewModel { AddNewWordViewModel(get()) }
}