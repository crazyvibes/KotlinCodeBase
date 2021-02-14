package `in`.bk.kotlincodebase.presentation.tv

import `in`.bk.kotlincodebase.R
import `in`.bk.kotlincodebase.data.model.tvshow.TvShow
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.MyViewHolder>() {
    private val tvList = ArrayList<TvShow>()
    fun setList(tvShow: List<TvShow>) {
        tvList.clear()
        tvList.addAll(tvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(tvList[position])
    }

    override fun getItemCount(): Int {
        return tvList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(tvShow: TvShow) {

            val titleTextView = itemView.findViewById<TextView>(R.id.title_text_view)
            val deccriptionTextView = itemView.findViewById<TextView>(R.id.description_text_view)
            val imageView = itemView.findViewById<ImageView>(R.id.description_text_view)

            titleTextView.text = tvShow.name
            deccriptionTextView.text = tvShow.overview

            val posterURL = "https://image.tmdb.org/t/p/w500" + tvShow.posterPath
            Glide.with(imageView.context)
                .load(posterURL)
                .into(imageView)
        }
    }
}