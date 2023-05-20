package com.example.remote.network.dto

import com.google.gson.annotations.SerializedName

/**
 * Data class defining the dto of an artist's search result.
 */
data class ArtistListDto(

    @SerializedName("data")
    var data: List<ArtistDto>,

    @SerializedName("total")
    var total: Int,

    @SerializedName("next")
    var next: String

)
