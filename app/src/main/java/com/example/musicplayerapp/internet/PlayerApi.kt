package com.example.musicplayerapp.internet;

import androidx.lifecycle.MutableLiveData;

import com.example.musicplayerapp.model.PlayerModel;

import retrofit2.Call;
import retrofit2.http.GET;

interface PlayerApi {

    @GET("studio")
    fun getSongs(): Call<MutableList<PlayerModel>>

}
