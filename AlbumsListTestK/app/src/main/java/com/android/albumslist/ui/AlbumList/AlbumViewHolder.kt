package com.android.albumslist.ui.AlbumList

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.android.albumslist.R
import com.android.albumslist.model.Album
import com.android.albumslist.model.Photo
import com.bumptech.glide.Glide

class AlbumViewHolder(view: View)  : RecyclerView.ViewHolder(view) {
    private val albumName: TextView = view.findViewById(R.id.textViewAlbum)
    private val albumImage: ImageView = view.findViewById(R.id.imageViewAlbum)

    fun bind(photo: Photo?) {
        if (photo != null) {
            showAlbumListData(photo)
        }
    }

    private fun showAlbumListData(photo: Photo) {
        photo.apply {
            albumName.text = albumId.toString()

            Glide.with(itemView.context)
                    .load(thumbnailUrl)
                    .into(albumImage)
        }
    }

    companion object {
        fun create(parent: ViewGroup): AlbumViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.album_item, parent, false)
            return AlbumViewHolder(view)
        }
    }
}