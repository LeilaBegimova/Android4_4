package com.example.android4_4.data.remote.models.location


import com.google.gson.annotations.SerializedName

data class LocationResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<ResultLocation>
)