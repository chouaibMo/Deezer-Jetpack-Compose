package com.example.domain.di

import com.example.domain.repository.AlbumRepository
import com.example.domain.repository.ArtistRepository
import com.example.domain.usecase.ArtistAlbumUseCase
import com.example.domain.usecase.ArtistSearchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

/**
 * Hilt module that provided use-cases instances.
 */
@Module
@InstallIn(ActivityRetainedComponent::class)
object UseCaseModule {

    /**
     * Provides instance of [ArtistAlbumUseCase].
     */
    @Provides
    fun providesArtistAlbumUseCase(albumRepository: AlbumRepository): ArtistAlbumUseCase =
        ArtistAlbumUseCase(albumRepository)

    /**
     * Provides instance of [ArtistSearchUseCase].
     */
    @Provides
    fun providesArtistSearchUseCase(artistRepository: ArtistRepository): ArtistSearchUseCase =
        ArtistSearchUseCase(artistRepository)

}