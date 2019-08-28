package com.android.albumslist.Adapter

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import com.android.albumslist.model.Photo
import com.android.albumslist.ui.AlbumList.AlbumViewHolder
import com.bumptech.glide.Glide

class AlbumAdapter : ListAdapter<Photo, RecyclerView.ViewHolder>(ALBUM_LIST_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AlbumViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val repoItem = getItem(position)
        Log.i("repoItem",""+repoItem);
        Log.i("repoItem albumId",""+repoItem.albumId.toString());
        Log.i("repoItem thumbnailUrl",""+repoItem.thumbnailUrl);
        if (repoItem != null) {
            (holder as AlbumViewHolder).bind(repoItem)

        }

    }




    companion object {
        private val ALBUM_LIST_COMPARATOR = object : DiffUtil.ItemCallback<Photo>() {
            override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean =
                    oldItem.albumId == newItem.albumId

            override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean =
                    oldItem == newItem
        }
    }
}