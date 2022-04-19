package com.example.myapplication2project.service

import com.example.myapplication2project.model.ShowDetailsResponse
import com.example.myapplication2project.model.mostpopulartvs
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Episodeservice {

    @GET("/api/most-popular")
    fun getpopular(@Query("page")page: Int=1): Call<mostpopulartvs>

    @GET("api/show-details?q=29560")
    fun getShowDetails (@Query("q")tvshowid: Long): Call<ShowDetailsResponse>


    companion object{
        private var _instance : Episodeservice? = null

        fun getInstance():Episodeservice {
            if (_instance== null){

                val retrofit = Retrofit.Builder()
                    .baseUrl("https://www.episodate.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(OkHttpClient.Builder().build())
                    .build();

                _instance =retrofit.create(Episodeservice::class.java)

            }
            return _instance!!;
        }
    }
}