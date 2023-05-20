package com.example.data.repository

import com.example.data.mapper.toArtist
import com.example.data.mapper.toArtistList
import com.example.domain.model.Artist
import com.example.domain.repository.ArtistRepository
import com.example.remote.datasource.RemoteDataSource
import javax.inject.Inject

class ArtistRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): ArtistRepository {


    override suspend fun getArtists(query: String): List<Artist> =
        remoteDataSource.getArtists(query)?.toArtistList() ?: emptyList()

    override suspend fun getArtist(id: Int): Artist? =
        remoteDataSource.getArtist(id)?.toArtist()
}