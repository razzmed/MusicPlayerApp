package com.example.musicplayerapp.repository

import androidx.lifecycle.MutableLiveData
import com.example.musicplayerapp.internet.PlayerApi
import com.example.musicplayerapp.model.PlayerModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository (private val api: PlayerApi) {

    fun getSongs(): MutableLiveData<MutableList<PlayerModel>> {
        val data: MutableLiveData<MutableList<PlayerModel>> = MutableLiveData()
        api.getSongs().enqueue(object : Callback<MutableList<PlayerModel>> {
            override fun onResponse(
                call: Call<MutableList<PlayerModel>>,
                response: Response<MutableList<PlayerModel>>
            ) {
                data.value = response.body()
            }

            override fun onFailure(call: Call<MutableList<PlayerModel>>, t: Throwable) {
                data.value = null
            }
        })
        return data
    }
}