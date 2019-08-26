package com.android.albumslist.ui.AlbumList

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.android.albumslist.data.AlbumsListRepository

class ViewModelFactoryAlbumList(private val albumsListRepo: AlbumsListRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlbumListModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AlbumListModel(albumsListRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}