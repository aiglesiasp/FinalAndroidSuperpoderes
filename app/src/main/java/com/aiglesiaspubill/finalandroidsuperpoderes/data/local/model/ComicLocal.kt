package com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.Thumbnail

@Entity(tableName = "comics")
data class ComicLocal(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String?,
    @Embedded val thumbnail: Thumbnail
)