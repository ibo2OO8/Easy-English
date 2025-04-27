package com.ibrohimapk3.easyenglish.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [WordEntity::class, DaoForVocabulary::class], version = 1)
abstract class MainDb : RoomDatabase() {
    abstract fun getDao(): DaoForVocabulary

    companion object {
        @Volatile
        private var db: MainDb? = null

        fun getDb(context: Context): MainDb {
            return db ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDb::class.java,
                    "Easy english"
                ).fallbackToDestructiveMigration()
                    .build()
                db = instance
                instance
            }
        }
    }
}
