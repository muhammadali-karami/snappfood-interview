package com.snappfood.interview.data.model

data class CharacterSearchResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<CharacterDetailResponse>
)