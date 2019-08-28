package com.android.albumslist.ui.AlbumList

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.android.albumslist.Adapter.AlbumAdapter
import com.android.albumslist.InjectionAlbum
import com.android.albumslist.R
import com.android.albumslist.model.Photo
import kotlinx.android.synthetic.main.activity_album_list.*

class AlbumListActivity : AppCompatActivity() {

    private lateinit var viewModelAlbumList: AlbumListModel

    private var adapter = AlbumAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_list)

        viewModelAlbumList = ViewModelProviders.of(this, InjectionAlbum.provideViewModelFactoryAlbumList(this))
                .get(AlbumListModel::class.java)

        initAdapter()
    }

    private fun initAdapter(){
        list.layoutManager = LinearLayoutManager(applicationContext)
        list.adapter = adapter

        /**
         * Observe changes in the list of album
         */
        viewModelAlbumList.photoList.observe(this, Observer<List<Photo>> {
            adapter.submitList(it)
        })
    }
}
