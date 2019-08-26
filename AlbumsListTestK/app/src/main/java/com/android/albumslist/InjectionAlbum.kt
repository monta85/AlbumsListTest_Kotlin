package com.android.albumslist

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.android.albumslist.data.AlbumsListRepository
import com.android.albumslist.db.AlbumsListDatabase
import com.android.albumslist.service.AlbumListService
import com.android.albumslist.ui.AlbumList.ViewModelFactoryAlbumList
import java.util.concurrent.Executors

object InjectionAlbum{

    private fun provideAlbumListRepo(context: Context): AlbumsListRepository {
        val database = AlbumsListDatabase.getInstance(context)
        return AlbumsListRepository(AlbumListService.create(), database.albumListDao(), Executors.newSingleThreadExecutor())
    }

    fun provideViewModelFactoryAlbumList(context: Context): ViewModelProvider.Factory {
        return ViewModelFactoryAlbumList(provideAlbumListRepo(context))
    }
}