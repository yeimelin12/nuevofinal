package com.example.myapplication2project.model

import com.google.gson.annotations.SerializedName

class tvshow {
    var id: Long = 0

    var name: String = ""

    @SerializedName("image_thumbnail_path")
    var image : String=""

    @SerializedName("start_date")
    var startDate: String = ""
    var country: String = ""
    var network: String = ""
    var status: String = ""
    var descripcion:String=""

}


class mostpopulartvs{
    var total: Int = 0
    var page: Int = 1
    var pages: Int = 0

    @SerializedName("tv_shows")
    var tvshows: List<tvshow>? = null
}

class ShowDetailsResponse{
    var tvshow:tvshow? = null
}

