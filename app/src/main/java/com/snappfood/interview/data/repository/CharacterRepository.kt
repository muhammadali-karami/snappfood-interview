package com.snappfood.interview.data.repository

import com.snappfood.interview.data.api.ApiService
import com.snappfood.interview.data.api.ApiResult
import com.snappfood.interview.data.model.CharacterDetail

class CharacterRepository(private val api: ApiService) {
    suspend fun searchCharacter(query: String): ApiResult<List<CharacterDetail>> {
        return try {
            val response = api.searchCharacter(query)
            ApiResult.Success(response.results)
        } catch (e: Exception) {
            ApiResult.Error("Failed to fetch characters: ${e.localizedMessage}")
        }
    }

    suspend fun getCharacterDetail(url: String): ApiResult<CharacterDetail> {
        return try {
            val response = api.getCharacterDetail(url)
            ApiResult.Success(response)
        } catch (e: Exception) {
            ApiResult.Error("Failed to fetch characters: ${e.localizedMessage}")
        }
    }
}