package com.example.spaceapi.viewModel

import com.example.spaceapi.model.secondPage.SecondResponse

sealed class SecondState {
    object Loading: SecondState()
    data class Success(val data: SecondResponse): SecondState()
    data class Error(val message: String): SecondState()
}