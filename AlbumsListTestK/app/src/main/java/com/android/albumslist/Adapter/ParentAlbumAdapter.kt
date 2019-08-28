package com.android.albumslist.Adapter

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.android.albumslist.R
import com.android.albumslist.model.Album
import kotlinx.android.synthetic.main.parent_recycler.view.*

class ParentAlbumAdapter(private val albums : List<Album>) : RecyclerView.Adapter<ParentAlbumAdapter.ViewHolder>(){

    private val viewPool = RecyclerView.RecycledViewPool()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.parent_recycler,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
       return albums.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val parent = albums[position]
        //holder.textView.text = parent.albumId.toString()
        holder.recyclerView.apply {
            layoutManager = LinearLayoutManager(holder.recyclerView.context, LinearLayout.HORIZONTAL, false)
           // adapter = ChildAdapter(parent.childrenPhoto)
            setRecycledViewPool(viewPool)
        }
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val recyclerView : RecyclerView = itemView.rv_child
        val textView:TextView = itemView.textParent
    }
}