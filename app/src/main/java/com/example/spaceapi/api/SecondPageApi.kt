package com.example.spaceapi.api

import com.example.spaceapi.model.secondPage.SecondResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SecondPageApi {
    @GET("articles/{id}")
    suspend fun getInfo(
        @Path("id") id: String,
        @Query("format") format: String = "json"
    ): SecondResponse

}