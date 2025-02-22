package com.snappfood.interview.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.snappfood.interview.data.api.ApiResult
import com.snappfood.interview.data.model.CharacterDetail
import com.snappfood.interview.domain.GetCharacterDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(private val getCharacterDetailUseCase: GetCharacterDetailUseCase) :
    ViewModel() {
    private val _characterDetail = MutableStateFlow<ApiResult<CharacterDetail>>(ApiResult.Empty)
    val characterDetail: StateFlow<ApiResult<CharacterDetail>> = _characterDetail

    fun getCharacterDetail(url: String) {
        viewModelScope.launch {
            _characterDetail.value = ApiResult.Loading
            _characterDetail.value = getCharacterDetailUseCase.invoke(url)
        }
    }
}