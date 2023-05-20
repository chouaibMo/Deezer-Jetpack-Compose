package com.example.remote.di

import com.example.remote.datasource.RemoteDataSource
import com.example.remote.datasource.RemoteDataSourceImpl
import com.example.remote.network.api.DeezerApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Hilt module that provides remote datasource related instances.
 */
@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {

    /**
     * Provides an instance of [RemoteDataSource].
     */
    @Singleton
    @Provides
    fun provideRemoteDataSource(api: DeezerApi): RemoteDataSource =
        RemoteDataSourceImpl(api)
}