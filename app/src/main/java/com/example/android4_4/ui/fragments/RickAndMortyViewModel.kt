package com.example.android4_4.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4_4.data.remote.models.characters.ResultCharacters
import com.example.android4_4.data.remote.models.location.ResultLocation
import com.example.android4_4.data.repositories.RickAndMortyRepositories
import com.example.android4_4.ui.model.CharacterAndLocationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RickAndMortyViewModel @Inject constructor(
    private val repositories: RickAndMortyRepositories
) : ViewModel() {
    private var _locationCharacter = MutableLiveData<List<CharacterAndLocationModel>>()
    val locationCharacter: LiveData<List<CharacterAndLocationModel>> = _locationCharacter

    init {
        getModel()
    }

    fun getModel() {
        viewModelScope.launch {
            val characters = async { repositories.getCharacter() }
            val location = async { repositories.getLocation() }
            connectList(characters.await().results!!, location.await().results!!)
        }
    }

    private fun connectList(
        characterList: List<ResultCharacters>, locationList: List<ResultLocation>
    ) {
        val combinedList = characterList.zip(locationList).map { (character) ->
            CharacterAndLocationModel(
                character.name, character.location.name, character.image
            )
        }
        _locationCharacter.value = combinedList
    }
}