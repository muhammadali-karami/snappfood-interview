package com.snappfood.interview.data.repository

import com.snappfood.interview.data.api.ApiService
import com.snappfood.interview.data.api.ApiResult
import com.snappfood.interview.data.model.CharacterDetailResponse

class CharacterRepository(private val api: ApiService) {
    suspend fun searchCharacter(query: String): ApiResult<List<CharacterDetailResponse>> {
        return try {
            val response = api.searchCharacter(query)
            ApiResult.Success(response.results)
        } catch (e: Exception) {
            ApiResult.Error("Failed to fetch characters: ${e.localizedMessage}")
        }
    }
}