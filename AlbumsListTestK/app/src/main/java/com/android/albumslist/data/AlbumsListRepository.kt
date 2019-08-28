package com.android.albumslist.data

import android.arch.lifecycle.LiveData
import com.android.albumslist.db.AlbumsListDao
import com.android.albumslist.model.Album
import com.android.albumslist.model.Photo
import com.android.albumslist.service.AlbumListService
import com.android.albumslist.service.requestAlbumList
import com.android.albumslist.service.requestPhotoList
import java.util.concurrent.Executor

class AlbumsListRepository(private val albumListListService: AlbumListService, private val albumsListDao: AlbumsListDao, private val ioExecutor: Executor) {

    fun getAllPhotoList(): LiveData<List<Photo>> {
        requestPhotoList(albumListListService, {
            photo ->
            ioExecutor.execute {
                albumsListDao.insertAllPhoto(photo)
            }
        }, { error ->

        })
        return albumsListDao.getAllPhotoList()
    }

    fun getAllAlbumsList(): LiveData<List<Album>> {
        requestAlbumList(albumListListService, {
            album ->
            ioExecutor.execute {
                albumsListDao.insertAllAlbums(album)
            }
        }, { error ->

        })
        return albumsListDao.getAllAlbumList()
    }
}
