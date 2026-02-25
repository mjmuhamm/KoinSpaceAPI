package com.example.spaceapi.api

import com.example.spaceapi.model.firstPage.SpaceResponse
import com.example.spaceapi.model.secondPage.SecondResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SpaceApi {
    @GET("articles")
    suspend fun getInfo(@Query("format") format: String = "json") : SpaceResponse
}



