package com.snappfood.interview.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snappfood.interview.data.api.ApiResult
import com.snappfood.interview.data.model.CharacterSearch
import com.snappfood.interview.domain.SearchCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchCharactersViewModel @Inject constructor(private val searchCharactersUseCase: SearchCharactersUseCase) :
    ViewModel() {
    private val _characters = MutableStateFlow<ApiResult<CharacterSearch>>(ApiResult.Empty)
    val characters: StateFlow<ApiResult<CharacterSearch>> = _characters

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
            _characters.value = searchCharactersUseCase.invoke(query)
        }
    }
}