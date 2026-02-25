package com.example.spaceapi.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spaceapi.repository.SecondRepository
import com.example.spaceapi.repository.SpaceRepository
import kotlinx.coroutines.launch

class SecondViewModel(private val repository: SecondRepository = SecondRepository()) : ViewModel() {

    private val _secondState = MutableLiveData<SecondState>(SecondState.Loading)
    val secondState = _secondState


    fun secondPage(id: String) {
        viewModelScope.launch {
            _secondState.value = SecondState.Loading
            val result = repository.getSecondPageInfo(id)
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