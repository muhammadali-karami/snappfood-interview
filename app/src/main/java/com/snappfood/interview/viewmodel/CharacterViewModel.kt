package com.snappfood.interview.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snappfood.interview.data.model.CharacterDetailResponse
import com.snappfood.interview.data.repository.CharacterRepository
import com.snappfood.interview.data.api.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val repository: CharacterRepository) :
    ViewModel() {
    private val _characters =
        MutableStateFlow<ApiResult<List<CharacterDetailResponse>>>(ApiResult.Success(emptyList()))
    val characters: StateFlow<ApiResult<List<CharacterDetailResponse>>> = _characters

    private var searchJob: Job? = null

    fun searchCharacters(query: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            _characters.value = ApiResult.Loading
            _characters.value = repository.searchCharacter(query)
        }
    }
}