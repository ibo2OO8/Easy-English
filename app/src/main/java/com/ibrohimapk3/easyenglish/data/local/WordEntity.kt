package com.ibrohimapk3.easyenglish.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class WordEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "english")
    var english: String? = "",

    @ColumnInfo(name = "russian")
    var russian: String? = ""
)
