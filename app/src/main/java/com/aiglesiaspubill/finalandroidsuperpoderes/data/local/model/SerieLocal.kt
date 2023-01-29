package com.aiglesiaspubill.finalandroidsuperpoderes.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.aiglesiaspubill.finalandroidsuperpoderes.data.remote.response.Thumbnail

@Entity(tableName = "series")
data class SerieLocal (
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String?,
    @Embedded val thumbnail: Thumbnail,
    @ColumnInfo(name = "startYear") val startYear: Int,
    @ColumnInfo(name = "endYear") val endYear: Int
)


