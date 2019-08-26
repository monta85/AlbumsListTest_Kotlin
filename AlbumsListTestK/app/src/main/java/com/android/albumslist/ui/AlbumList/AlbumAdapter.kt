package com.android.albumslist.ui.AlbumList

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.android.albumslist.model.Album

class AlbumAdapter : ListAdapter<Album, RecyclerView.ViewHolder>(ALBUM_LIST_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AlbumViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val repoItem = getItem(position)
        if (repoItem != null) {
            (holder as AlbumViewHolder).bind(repoItem)
        }
    }


    companion object {
        private val ALBUM_LIST_COMPARATOR = object : DiffUtil.ItemCallback<Album>() {
            override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean =
                    oldItem.albumId == newItem.albumId

            override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean =
                    oldItem == newItem
        }
    }
}