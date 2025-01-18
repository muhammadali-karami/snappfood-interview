package com.snappfood.interview.di

import com.snappfood.interview.data.api.ApiClient
import com.snappfood.interview.data.api.ApiService
import com.snappfood.interview.data.repository.CharacterRepository
import com.snappfood.interview.data.repository.CharacterRepositoryImpl
import com.snappfood.interview.domain.GetCharacterDetailUseCase
import com.snappfood.interview.domain.GetCharacterDetailUseCaseImpl
import com.snappfood.interview.domain.SearchCharactersUseCase
import com.snappfood.interview.domain.SearchCharactersUseCaseImpl
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
        return CharacterRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideSearchCharactersUseCase(
        repository: CharacterRepository
    ): SearchCharactersUseCase {
        return SearchCharactersUseCaseImpl(repository)
    }

    @Provides
    @Singleton
    fun provideGetCharacterDetailUseCase(
        repository: CharacterRepository
    ): GetCharacterDetailUseCase {
        return GetCharacterDetailUseCaseImpl(repository)
    }
}