package com.example.spaceapi.repository

import com.example.spaceapi.api.SecondPageApi
import com.example.spaceapi.remote.SecondRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SecondRepository(private var api: SecondPageApi = SecondRetrofitClient.api) {

    suspend fun getSecondPageInfo(id: String): Result<com.example.spaceapi.model.secondPage.SecondResponse> = withContext(Dispatchers.IO) {
        try {
            val info = api.getInfo(id)
            Result.success(info)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}