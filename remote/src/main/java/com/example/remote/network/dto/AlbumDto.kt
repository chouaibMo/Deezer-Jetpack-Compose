package com.example.remote.network.dto

import com.google.gson.annotations.SerializedName

/**
 * Data class defining the dto of an album.
 */
data class AlbumDto(

    @SerializedName("id")
    var id: Int,

    @SerializedName("title")
    var title: String,

    @SerializedName("link")
    var link: String,

    @SerializedName("share")
    var share: String,

    @SerializedName("cover")
    var cover: String,

    @SerializedName("cover_medium")
    var coverMedium: String,

    @SerializedName("duration")
    var duration: Int,

    @SerializedName("fans")
    var fans: Int,

    @SerializedName("label")
    var label: String,

    @SerializedName("release_date")
    var releaseDate: String,

    @SerializedName("available")
    var available: Boolean,

    @SerializedName("explicit_lyrics")
    var explicitLyrics: Boolean,

    @SerializedName("tracks")
    var tracks: TrackListDto?

)


/**
 * Data class defining the dto of a track list.
 */
data class TrackListDto(
    @SerializedName("data")
    var data: List<TrackDto>
)