package com.snappfood.interview.domain

import com.snappfood.interview.data.api.ApiResult
import com.snappfood.interview.data.model.CharacterDetail

interface GetCharacterDetailUseCase {
    suspend operator fun invoke(url: String): ApiResult<CharacterDetail>
}