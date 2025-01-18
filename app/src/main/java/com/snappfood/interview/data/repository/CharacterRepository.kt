package com.snappfood.interview.data.repository

import com.snappfood.interview.data.api.ApiResult
import com.snappfood.interview.data.model.CharacterDetail
import com.snappfood.interview.data.model.CharacterSearch

interface CharacterRepository {
    suspend fun searchCharacters(query: String): ApiResult<CharacterSearch>
    suspend fun getCharacterDetail(url: String): ApiResult<CharacterDetail>
}