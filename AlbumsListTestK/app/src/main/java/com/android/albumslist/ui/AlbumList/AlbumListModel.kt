package com.android.albumslist.ui.AlbumList

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.android.albumslist.data.AlbumsListRepository
import com.android.albumslist.model.Album
import com.android.albumslist.model.Photo

class AlbumListModel(private val albumsListRepo: AlbumsListRepository) : ViewModel() {

    //list of all the album lists
    val albumsList : LiveData<List<Album>> = albumsListRepo.getAllAlbumsList()
    //list of all the album lists
    val photoList : LiveData<List<Photo>> = albumsListRepo.getAllPhotoList()
}