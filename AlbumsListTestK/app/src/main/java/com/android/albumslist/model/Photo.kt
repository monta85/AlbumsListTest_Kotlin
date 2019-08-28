package com.android.albumslist.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "photo_list")
data class Photo(@PrimaryKey @field:SerializedName("id") val photoId: Int,
                 @field:SerializedName("albumId") val albumId: Int,
                 @field:SerializedName("title") val name: String = "",
                 @field:SerializedName("url") val url: String = "",
                 @field:SerializedName("thumbnailUrl") val thumbnailUrl: String = "")