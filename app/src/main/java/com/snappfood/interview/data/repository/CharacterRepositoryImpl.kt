package com.snappfood.interview.data.repository

import com.snappfood.interview.data.api.ApiResult
import com.snappfood.interview.data.api.ApiService
import com.snappfood.interview.data.model.CharacterDetail
import com.snappfood.interview.data.model.CharacterSearch

class CharacterRepositoryImpl(private val api: ApiService) : CharacterRepository {
    override suspend fun searchCharacters(query: String): ApiResult<CharacterSearch> {
        return try {
            val result = api.searchCharacter(query)
            ApiResult.Success(result)
        } catch (e: Exception) {
            handleException(e)
        }
    }

    override suspend fun getCharacterDetail(url: String): ApiResult<CharacterDetail> {
        return try {
            val result = api.getCharacterDetail(url)
            ApiResult.Success(result)
        } catch (e: Exception) {
            handleException(e)
        }
    }

    private fun handleException(e: Exception): ApiResult.Error {
        return ApiResult.Error(e.message ?: "An unknown error occurred", e)
    }
}