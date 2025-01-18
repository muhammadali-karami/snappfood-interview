package com.snappfood.interview.domain

import com.snappfood.interview.data.api.ApiResult
import com.snappfood.interview.data.model.CharacterDetail
import com.snappfood.interview.data.repository.CharacterRepository
import javax.inject.Inject

class GetCharacterDetailUseCaseImpl @Inject constructor(private val repository: CharacterRepository) :
    GetCharacterDetailUseCase {
    override suspend operator fun invoke(url: String): ApiResult<CharacterDetail> {
        return repository.getCharacterDetail(url)
    }
}