package com.example.remote.network.dto

import com.google.gson.annotations.SerializedName

/**
 * Data class defining the dto of a list of albums.
 */
data class AlbumListDto(

    @SerializedName("data")
    var data: List<AlbumDto>,

    @SerializedName("total")
    var total: Int,

    @SerializedName("next")
    var next: String

)