package `in`.bk.kotlincodebase.data.model.tvshow

import com.google.gson.annotations.SerializedName


data class TvShowList (
    @SerializedName("results")
    val tvShows: List<TvShow>
)