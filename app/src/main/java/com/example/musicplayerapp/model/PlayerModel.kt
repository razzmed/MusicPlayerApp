package com.example.musicplayerapp.model

import com.google.gson.annotations.SerializedName

data class PlayerModel (
    var song: String? = null,
    var url: String? = null,
    var artists: String? = null,
    @SerializedName("cover_image")
    var coverImage: String? = null
)