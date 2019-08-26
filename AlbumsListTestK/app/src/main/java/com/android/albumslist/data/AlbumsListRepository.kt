package com.android.albumslist.data

import android.arch.lifecycle.LiveData
import com.android.albumslist.db.AlbumsListDao
import com.android.albumslist.model.Album
import com.android.albumslist.service.AlbumListService
import com.android.albumslist.service.requestAlbumList
import java.util.concurrent.Executor

class AlbumsListRepository(private val albumListListService: AlbumListService, private val albumsListDao: AlbumsListDao, private val ioExecutor: Executor) {

    fun getAllAlbumsList(): LiveData<List<Album>> {
        requestAlbumList(albumListListService, {
            album ->
            ioExecutor.execute {
                albumsListDao.insertAll(album)
            }
        }, { error ->

        })
        return albumsListDao.getAllAlbumList()
    }
}
