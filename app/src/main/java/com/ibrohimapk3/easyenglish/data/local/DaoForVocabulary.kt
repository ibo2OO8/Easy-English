package com.ibrohimapk3.easyenglish.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoForVocabulary {
    @Insert
    suspend fun insertItem(item: WordEntity)

    @Query("SELECT * FROM items")
    fun getAllItem(): LiveData<List<WordEntity>>

    @Query("DELETE FROM items WHERE english = :english")
    fun deleteItemByTitle(english: String)

    @Query("SELECT items.english , items.russian FROM items")
    fun getNameAndCapital(): Flow<List<WordEntity>>

    @Query("DELETE FROM items WHERE id NOT IN (SELECT MIN(id) FROM items GROUP BY english)")
    fun deleteDuplicateData()


    @Query("DELETE FROM items")
    suspend fun deleteAllFromTable()
}
