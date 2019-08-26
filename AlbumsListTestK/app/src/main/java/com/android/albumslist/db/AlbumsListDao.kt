package com.android.albumslist.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.android.albumslist.model.Album

/**
 * DAO for album List
 */
@Dao
interface AlbumsListDao{

    //Add a list of album List
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(albumsList: List<Album>)

    //Get all the album List
    @Query("SELECT albumId, name, url, thumbnailUrl FROM album_list")
    fun getAllAlbumList(): LiveData<List<Album>>
}