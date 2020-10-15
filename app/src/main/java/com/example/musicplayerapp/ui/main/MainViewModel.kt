package com.example.musicplayerapp.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musicplayerapp.model.PlayerModel
import com.example.musicplayerapp.repository.Repository

class MainViewModel (private val repository: Repository):ViewModel() {
    var cover: MutableLiveData<MutableList<PlayerModel>> = MutableLiveData()

    init {
        getSongs()
    }

    fun getSongs() {
        cover = repository.getSongs()
    }
}