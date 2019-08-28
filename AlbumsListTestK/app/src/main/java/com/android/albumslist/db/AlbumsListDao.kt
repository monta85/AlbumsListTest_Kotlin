package com.android.albumslist.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.android.albumslist.model.Album
import com.android.albumslist.model.Photo

/**
 * DAO for album List
 */
@Dao
interface AlbumsListDao{


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPhoto(photoList: List<Photo>)
    //Get all the photo List
    @Query("SELECT photoId, albumId, name, url, thumbnailUrl FROM photo_list")
    fun getAllPhotoList(): LiveData<List<Photo>>

    //Add a list of album List
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllAlbums(albumsList: List<Album>)
    //Get all the album List
    @Query("SELECT albumId, name FROM album_list")
    fun getAllAlbumList(): LiveData<List<Album>>
}