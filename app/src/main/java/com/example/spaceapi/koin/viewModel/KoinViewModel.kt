package com.example.spaceapi.koin.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spaceapi.koin.service.SpaceService
import com.example.spaceapi.model.secondPage.SecondResponse
import com.example.spaceapi.viewModel.SpaceState
import kotlinx.coroutines.launch

class KoinViewModel(private val spaceService: SpaceService) : ViewModel() {

    suspend fun getResults() {

        viewModelScope.launch {
            spaceService.loadResults()
        }
    }

    suspend fun getResult(id: String): Result<SecondResponse> {
        return spaceService.getResult(id)
    }



}