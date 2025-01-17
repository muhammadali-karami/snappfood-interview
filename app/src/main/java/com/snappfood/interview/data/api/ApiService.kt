package com.snappfood.interview.data.api

import com.snappfood.interview.data.model.CharacterDetailResponse
import com.snappfood.interview.data.model.CharacterSearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("people/")
    suspend fun searchCharacter(@Query("search") query: String): CharacterSearchResponse
}