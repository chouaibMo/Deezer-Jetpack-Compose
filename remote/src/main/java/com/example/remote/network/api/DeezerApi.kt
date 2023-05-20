package com.example.remote.network.api

import com.example.remote.network.dto.AlbumDto
import com.example.remote.network.dto.AlbumListDto
import com.example.remote.network.dto.ArtistDto
import com.example.remote.network.dto.ArtistListDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Deezer api interface.
 */
interface DeezerApi {

    /**
     * Retrieves all artists matching the [query], as a list of [ArtistDto].
     */
    @GET("search/artist")
    suspend fun getArtists(@Query("q") query: String): Response<ArtistListDto>

    /**
     * Retrieves the artist having [id] as identifier.
     */
    @GET("artist/{id}")
    suspend fun getArtist(@Path("id") id: Int): Response<ArtistDto>

    /**
     * Retrieves all albums of the artist having [id] as identifier.
     */
    @GET("artist/{id}/albums")
    suspend fun getArtistAlbums(@Path("id") id: Int): Response<AlbumListDto>

    /**
     * Retrieves the album having [id] as identifier.
     */
    @GET("album/{id}")
    suspend fun getAlbum(@Path("id") id: Int): Response<AlbumDto>
}