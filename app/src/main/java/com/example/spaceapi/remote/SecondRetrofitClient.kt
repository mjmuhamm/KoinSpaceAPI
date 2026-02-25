package com.example.spaceapi.remote

import com.example.spaceapi.api.SecondPageApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SecondRetrofitClient {
    const val BASE_URL = "https://api.spaceflightnewsapi.net/v4/"
        val api : SecondPageApi by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build().create(SecondPageApi::class.java)
        }
    }
