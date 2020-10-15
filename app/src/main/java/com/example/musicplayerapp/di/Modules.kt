package com.example.musicplayerapp.di

import com.example.musicplayerapp.internet.RetrofitClient
import com.example.musicplayerapp.repository.Repository
import com.example.musicplayerapp.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var playerModule = module {

    single { RetrofitClient().provideSongs() }

    factory { Repository(get()) }

    viewModel { MainViewModel(get()) }
}
