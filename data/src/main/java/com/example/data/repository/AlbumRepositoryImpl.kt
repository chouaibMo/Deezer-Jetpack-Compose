package com.example.data.repository

import com.example.data.mapper.toAlbum
import com.example.domain.model.Album
import com.example.domain.repository.AlbumRepository
import com.example.remote.datasource.RemoteDataSource
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): AlbumRepository {

    override suspend fun getAlbum(albumId: Int): Album? {
        return remoteDataSource.getAlbum(albumId)?.toAlbum()
    }

    override suspend fun getArtistAlbums(artistId: Int): List<Album> {
        val albums = remoteDataSource.getArtistAlbums(artistId)
        return albums?.data?.let { list ->
            list.map { it.toAlbum() }
        } ?: emptyList()
    }
}