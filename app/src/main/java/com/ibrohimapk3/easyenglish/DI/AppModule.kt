package com.ibrohimapk3.easyenglish.DI

import android.content.Context
import androidx.room.Room
import com.ibrohimapk3.easyenglish.data.WordRepositoryImpl
import com.ibrohimapk3.easyenglish.data.local.DaoForVocabulary
import com.ibrohimapk3.easyenglish.data.local.MainDb
import com.ibrohimapk3.easyenglish.domain.VocabularyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object appModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): MainDb {
        return Room.databaseBuilder(
            context,
            MainDb::class.java,
            "word_database"
        ).build()
    }

    @Provides
    fun provideWordDao(db: MainDb): DaoForVocabulary {
        return db.getDao()
    }

    @Provides
    fun provideMyVocabularyRepository(dao: DaoForVocabulary): VocabularyRepository {
        return WordRepositoryImpl(dao)
    }

}