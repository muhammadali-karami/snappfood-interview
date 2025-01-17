package com.snappfood.interview.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snappfood.interview.data.api.ApiResult
import com.snappfood.interview.data.model.CharacterDetail
import com.snappfood.interview.data.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchCharacterViewModel @Inject constructor(private val repository: CharacterRepository) :
    ViewModel() {
    private val _characters = MutableStateFlow<ApiResult<List<CharacterDetail>>>(ApiResult.Empty)
    val characters: StateFlow<ApiResult<List<CharacterDetail>>> = _characters

    private var searchJob: Job? = null

    fun searchCharacterWithDebounce(query: String) {
        searchJob?.cancel() // Cancel the previous job (to improve performance)
        if (query.isEmpty()) {
            _characters.value = ApiResult.Empty
        } else {
            searchJob = viewModelScope.launch {
                delay(300)
                searchCharacter(query)
            }
        }
    }

    private fun searchCharacter(query: String) {
        viewModelScope.launch {
            _characters.value = ApiResult.Loading
            _characters.value = repository.searchCharacter(query)
        }
    }
}