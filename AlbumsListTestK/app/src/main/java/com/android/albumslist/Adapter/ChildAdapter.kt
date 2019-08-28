package com.android.albumslist.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.android.albumslist.R
import com.android.albumslist.model.Photo
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.album_item.view.*

class ChildAdapter(private val photos : List<Photo>)
    : RecyclerView.Adapter<ChildAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =  LayoutInflater.from(parent.context)
                      .inflate(R.layout.album_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val childPhoto = photos[position]
        Glide.with(holder.itemView.context)
                .load(childPhoto.thumbnailUrl)
                .into(holder.imageView)
        holder.textView.text = childPhoto.name
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val textView : TextView = itemView.textViewAlbum
        val imageView: ImageView = itemView.imageViewAlbum

    }
}