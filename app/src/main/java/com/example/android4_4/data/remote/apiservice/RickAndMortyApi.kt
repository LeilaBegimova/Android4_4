package com.example.android4_4.data.remote.apiservice

import com.example.android4_4.data.remote.models.characters.CharactersResponse
import com.example.android4_4.data.remote.models.location.LocationResponse
import retrofit2.http.GET

private const val CHARACTER_END_POINT = "character"
private const val LOCATION_END_POINT = "location"

interface RickAndMortyApi {
    @GET(CHARACTER_END_POINT)
    suspend fun getCharacter(): CharactersResponse

    @GET(LOCATION_END_POINT)
    suspend fun getLocation(): LocationResponse
}