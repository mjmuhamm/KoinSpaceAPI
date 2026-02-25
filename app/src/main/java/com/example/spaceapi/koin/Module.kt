package com.example.spaceapi.koin

import com.example.spaceapi.koin.koinRepository.SpaceRepository
import com.example.spaceapi.koin.koinRepository.SpaceRepositoryImpl
import com.example.spaceapi.koin.service.SpaceService
import com.example.spaceapi.koin.service.SpaceServiceImpl
import com.example.spaceapi.koin.viewModel.KoinViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.dsl.single

val appModule = module {
    singleOf(::SpaceRepositoryImpl) bind SpaceRepository::class
    singleOf(::SpaceServiceImpl) bind SpaceService::class
    viewModel { (KoinViewModel(get())) }
}