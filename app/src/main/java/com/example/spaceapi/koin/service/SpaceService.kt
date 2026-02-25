package com.example.spaceapi.koin.service

import com.example.spaceapi.koin.koinRepository.SpaceRepository
import com.example.spaceapi.koin.koinRepository.SpaceRepositoryImpl
import com.example.spaceapi.model.firstPage.SpaceResponse
import com.example.spaceapi.model.secondPage.SecondResponse
import com.example.spaceapi.remote.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


interface SpaceService {
    suspend fun loadResults() : Result<List<com.example.spaceapi.model.firstPage.Result>>
    suspend fun getResult(id: String) : Result<SecondResponse>
}

class SpaceServiceImpl(private val spaceRepository: SpaceRepository) : SpaceService {


    override suspend fun getResult(id: String): Result<SecondResponse> = spaceRepository.findResult(id)

    override suspend fun loadResults(): Result<List<com.example.spaceapi.model.firstPage.Result>> =
        withContext(Dispatchers.IO) {
            try {
                val response = RetrofitClient.api.getInfo()
                val info = response.results
                Result.success(info)
//                spaceRepository.getInfo()
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
}
