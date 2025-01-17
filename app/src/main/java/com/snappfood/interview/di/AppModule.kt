package com.snappfood.interview.di

import com.snappfood.interview.data.api.ApiService
import com.snappfood.interview.data.repository.CharacterRepository
import com.snappfood.interview.data.api.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return ApiClient.api
    }

    @Provides
    @Singleton
    fun provideCharacterRepository(apiService: ApiService): CharacterRepository {
        return CharacterRepository(apiService)
    }
}