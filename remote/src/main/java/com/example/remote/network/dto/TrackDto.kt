package com.example.remote.network.dto

import com.google.gson.annotations.SerializedName

/**
 * Data class defining the dto of a track.
 */
data class TrackDto(
    @SerializedName("id")
    var id: Int,

    @SerializedName("readable")
    var readable: Boolean,

    @SerializedName("title")
    var title: String,

    @SerializedName("link")
    var link: String,

    @SerializedName("duration")
    var duration: Int,

    @SerializedName("preview")
    var preview: String,

    @SerializedName("explicit_lyrics")
    var explicit: Boolean,


    @SerializedName("type")
    var type: String

)