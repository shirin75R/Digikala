package com.example.digikala1.data.model.home

import com.google.gson.annotations.SerializedName

data class Slider(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("image")
    val image: String,
    val url: String,
    val category: String,
    val priority: Int
)