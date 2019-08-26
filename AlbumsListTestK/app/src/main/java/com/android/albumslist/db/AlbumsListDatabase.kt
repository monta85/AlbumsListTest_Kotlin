package com.android.albumslist.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.android.albumslist.model.Album

/**
 * Database to store all album List
 */
@Database(
        entities = [Album::class],
        version = 1,
        exportSchema = false
)
abstract class AlbumsListDatabase : RoomDatabase() {

    abstract fun albumListDao(): AlbumsListDao

    companion object {

        @Volatile
        private var INSTANCE: AlbumsListDatabase? = null

        fun getInstance(context: Context): AlbumsListDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE
                            ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        AlbumsListDatabase::class.java, "albumList.db")
                        .build()
    }
}