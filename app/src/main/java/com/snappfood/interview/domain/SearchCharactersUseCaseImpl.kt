package com.snappfood.interview.domain

import com.snappfood.interview.data.api.ApiResult
import com.snappfood.interview.data.model.CharacterSearch
import com.snappfood.interview.data.repository.CharacterRepository
import javax.inject.Inject

class SearchCharactersUseCaseImpl @Inject constructor(private val repository: CharacterRepository) :
    SearchCharactersUseCase {
    override suspend operator fun invoke(query: String): ApiResult<CharacterSearch> {
        return repository.searchCharacters(query)
    }
}