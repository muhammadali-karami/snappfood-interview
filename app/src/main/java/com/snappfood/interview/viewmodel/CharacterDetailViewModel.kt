package com.snappfood.interview.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snappfood.interview.data.model.CharacterDetail
import com.snappfood.interview.data.repository.CharacterRepository
import com.snappfood.interview.data.api.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(private val repository: CharacterRepository) :
    ViewModel() {
    private val _characterDetail = MutableStateFlow<ApiResult<CharacterDetail>>(ApiResult.Empty)
    val characterDetail: StateFlow<ApiResult<CharacterDetail>> = _characterDetail

    fun getCharacterDetail(url: String) {
        viewModelScope.launch {
            _characterDetail.value = ApiResult.Loading
            _characterDetail.value = repository.getCharacterDetail(url)
        }
    }
}