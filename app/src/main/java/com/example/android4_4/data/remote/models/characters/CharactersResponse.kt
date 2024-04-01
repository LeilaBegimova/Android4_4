package com.example.android4_4.data.remote.models.characters


import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<ResultCharacters>
)