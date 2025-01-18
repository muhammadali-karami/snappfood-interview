package com.snappfood.interview.domain

import com.snappfood.interview.data.api.ApiResult
import com.snappfood.interview.data.model.CharacterSearch

interface SearchCharactersUseCase {
    suspend operator fun invoke(query: String): ApiResult<CharacterSearch>
}