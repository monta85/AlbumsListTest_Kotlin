package com.android.albumslist.service

import android.util.Log
import com.android.albumslist.BuildConfig
import com.android.albumslist.model.Album
import com.android.albumslist.model.Photo
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val TAG = "AlbumListService"

/**
 * Get all the Album List
 */
fun requestAlbumList(
        service: AlbumListService,
        onSuccess: (albumLists: List<Album>) -> Unit,
        onError: (error: String) -> Unit) {

    service.getAlbumLists().enqueue(
            object : Callback<List<Album>> {
                override fun onFailure(call: Call<List<Album>>?, throwable: Throwable) {
                    Log.e(TAG, "fail to get data", throwable)
                    onError(throwable.message ?: "unknown error")
                }

                override fun onResponse(
                        call: Call<List<Album>>?,
                        response: Response<List<Album>>
                ) {
                    Log.d(TAG, "got a response $response")
                    if (response.isSuccessful) {
                        val albumLists = response.body() ?: emptyList()
                        onSuccess(albumLists)
                    } else {
                        onError(response.errorBody()?.string() ?: "Unknown error")
                    }
                }
            }
    )
}

/**
 * Get all the Photo List
 */
fun requestPhotoList(
        service: AlbumListService,
        onSuccess: (photoLists: List<Photo>) -> Unit,
        onError: (error: String) -> Unit) {

    service.getPhotoLists().enqueue(
            object : Callback<List<Photo>> {
                override fun onFailure(call: Call<List<Photo>>?, throwable: Throwable) {
                    Log.e(TAG, "fail to get data", throwable)
                    onError(throwable.message ?: "unknown error")
                }

                override fun onResponse(
                        call: Call<List<Photo>>?,
                        response: Response<List<Photo>>
                ) {
                    Log.d(TAG, "got a response $response")
                    if (response.isSuccessful) {
                        val albumLists = response.body() ?: emptyList()
                        onSuccess(albumLists)
                    } else {
                        onError(response.errorBody()?.string() ?: "Unknown error")
                    }
                }
            }
    )
}
interface AlbumListService{

    /**
     * Get album list.
     */
    @GET("photos")
    fun getPhotoLists(): Call<List<Photo>>
    @GET("albums")
    fun getAlbumLists(): Call<List<Album>>

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun create(): AlbumListService {
            val logger = HttpLoggingInterceptor()
            logger.level = if(BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BASIC else HttpLoggingInterceptor.Level.NONE

            val client = OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .build()
            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(AlbumListService::class.java)
        }
    }
}