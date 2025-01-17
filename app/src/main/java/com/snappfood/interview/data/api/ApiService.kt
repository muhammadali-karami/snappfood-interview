package com.snappfood.interview.data.api

import com.snappfood.interview.data.model.CharacterDetail
import com.snappfood.interview.data.model.CharacterSearch
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ApiService {
    @GET("people/")
    suspend fun searchCharacter(@Query("search") query: String): CharacterSearch

    @GET
    suspend fun getCharacterDetail(@Url url: String): CharacterDetail
}