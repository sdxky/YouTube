package com.example.youtube.data.model.thumbnails


import com.google.gson.annotations.SerializedName

data class Standard(
    @SerializedName("height")
    val height: Int,
    @SerializedName("url")
    val url: String,
    @SerializedName("width")
    val width: Int
)