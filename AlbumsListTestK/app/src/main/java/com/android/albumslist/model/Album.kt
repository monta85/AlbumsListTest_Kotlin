package com.android.albumslist.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "album_list")
data class Album(@PrimaryKey @field:SerializedName("id") val albumId: Int,
                 @field:SerializedName("title") val name: String = "")

                 //@field:SerializedName("url") val url: String = "",
                 //@field:SerializedName("thumbnailUrl") val thumbnailUrl: String = "")
                // val childrenPhoto : List<Photo>)