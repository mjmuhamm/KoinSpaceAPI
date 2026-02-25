package com.example.spaceapi.koin.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spaceapi.koin.service.SpaceService
import com.example.spaceapi.model.secondPage.SecondResponse
import com.example.spaceapi.viewModel.SecondState
import com.example.spaceapi.viewModel.SpaceState
import kotlinx.coroutines.launch

class KoinViewModel(private val spaceService: SpaceService) : ViewModel() {

    private val _spaceState = MutableLiveData<SpaceState>(SpaceState.Loading)
    val spaceState = _spaceState

    private val _secondState = MutableLiveData<SecondState>(SecondState.Loading)
    val secondState = _secondState



    fun getResults() {
        viewModelScope.launch {
            _spaceState.value = SpaceState.Loading
            val result = spaceService.loadResults()
            _spaceState.value = if (result.isSuccess) {
                val info = result.getOrNull() ?: emptyList()
                SpaceState.Success(info)
            } else {
                SpaceState.Error(result.exceptionOrNull()?.message ?: "Unknown Error")
            }
        }
    }

    fun getResult(id: String) {
        viewModelScope.launch {
            _secondState.value = SecondState.Loading
            val result = spaceService.getResult(id)
            _secondState.value = if (result.isSuccess) {
                val info = result.getOrNull()
                if (info != null) {
                    SecondState.Success(info)  // pass the actual response
                } else {
                    SecondState.Error(result.exceptionOrNull()?.message ?: "Unknown Error")
                }
            } else {
                SecondState.Error(result.exceptionOrNull()?.message ?: "Unknown Error")
            }
        }
    }
}