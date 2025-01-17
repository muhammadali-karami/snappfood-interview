package com.snappfood.interview.data.model

data class CharacterSearch(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<CharacterDetail>
)