package com.example.appfutbol

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://www.thesportsdb.com/api/v1/json/3/"

    private var retrofit: Retrofit?=null;
    fun getClient(): Retrofit {
        if(retrofit==null){
            retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
        }
        return retrofit!!
    }
}