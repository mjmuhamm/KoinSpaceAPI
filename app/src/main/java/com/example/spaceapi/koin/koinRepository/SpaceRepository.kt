package com.example.spaceapi.koin.koinRepository

import com.example.spaceapi.model.firstPage.Result
import com.example.spaceapi.model.firstPage.SpaceResponse
import com.example.spaceapi.model.secondPage.SecondResponse
import com.example.spaceapi.remote.RetrofitClient
import com.example.spaceapi.remote.SecondRetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

interface SpaceRepository {
    suspend fun getInfo() : kotlin.Result<List<Result>>
    suspend fun findResult(id: String): kotlin.Result<SecondResponse>
}

class SpaceRepositoryImpl : SpaceRepository {

    override suspend fun getInfo(): kotlin.Result<List<Result>> = withContext(Dispatchers.IO) {
        try {
            val response = RetrofitClient.api.getInfo()
            val info = response.results
            kotlin.Result.success(info)
        } catch (e: Exception) {
            kotlin.Result.failure(e)
        }
    }

    override suspend fun findResult(id: String): kotlin.Result<SecondResponse> = withContext(Dispatchers.IO) {
        try {
            val info = SecondRetrofitClient.api.getInfo(id)
            kotlin.Result.success(info)
        } catch (e: Exception) {
            kotlin.Result.failure(e)
        }
    }

}