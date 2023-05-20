package com.example.data.di

import com.example.data.repository.AlbumRepositoryImpl
import com.example.data.repository.ArtistRepositoryImpl
import com.example.domain.repository.AlbumRepository
import com.example.domain.repository.ArtistRepository
import com.example.remote.datasource.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

/**
 * Hilt module that provided repositories instances.
 */
@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    /**
     * Provides instance of [ArtistRepository].
     */
    @Provides
    fun provideArtistRepository(remoteDataSource: RemoteDataSource): ArtistRepository =
        ArtistRepositoryImpl(remoteDataSource)

    /**
     * Provides instance of [AlbumRepository].
     */
    @Provides
    fun provideAlbumRepository(remoteDataSource: RemoteDataSource): AlbumRepository =
        AlbumRepositoryImpl(remoteDataSource)
}