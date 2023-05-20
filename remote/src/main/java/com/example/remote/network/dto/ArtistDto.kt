package com.example.remote.network.dto

import com.google.gson.annotations.SerializedName

/**
 * Data class defining the dto of an artist.
 */
data class ArtistDto(
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("link")
    var link: String,

    @SerializedName("share")
    var share: String,

    @SerializedName("picture")
    var picture: String,

    @SerializedName("picture_medium")
    var pictureMedium: String,

    @SerializedName("nb_album")
    var nbAlbum: Int,

    @SerializedName("nb_fan")
    var nbFan: Int,

    @SerializedName("radio")
    var radio: Boolean,

    @SerializedName("tracklist")
    var tracklist: String,
)