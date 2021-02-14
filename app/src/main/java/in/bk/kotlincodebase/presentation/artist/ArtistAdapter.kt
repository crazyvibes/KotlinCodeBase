package `in`.bk.kotlincodebase.presentation.artist

import `in`.bk.kotlincodebase.R
import `in`.bk.kotlincodebase.data.model.artist.Artist
import `in`.bk.kotlincodebase.data.model.tvshow.TvShow
import `in`.bk.kotlincodebase.presentation.tv.TvShowAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ArtistAdapter: RecyclerView.Adapter<ArtistAdapter.MyViewHolder>() {
    private val artistList = ArrayList<Artist>()
    fun setList(artist: List<Artist>) {
        artistList.clear()
        artistList.addAll(artist)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistAdapter.MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ArtistAdapter.MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(artist: Artist) {

            val titleTextView = itemView.findViewById<TextView>(R.id.title_text_view)
            val deccriptionTextView = itemView.findViewById<TextView>(R.id.description_text_view)
            val imageView = itemView.findViewById<ImageView>(R.id.description_text_view)

            titleTextView.text = artist.name
           // deccriptionTextView.text = artist.popularity

            val posterURL = "https://image.tmdb.org/t/p/w500" + artist.profilePath
            Glide.with(imageView.context)
                .load(posterURL)
                .into(imageView)
        }
    }
}