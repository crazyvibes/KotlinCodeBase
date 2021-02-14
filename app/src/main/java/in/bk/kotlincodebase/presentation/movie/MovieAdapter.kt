package `in`.bk.kotlincodebase.presentation.movie

import `in`.bk.kotlincodebase.R
import `in`.bk.kotlincodebase.data.model.movie.Movie
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter : RecyclerView.Adapter<MyViewHolder>(){
    private val movieList = ArrayList<Movie>()
    fun setList(movies:List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindItems(movie:Movie) {

        val titleTextView=itemView.findViewById<TextView>(R.id.title_text_view)
        val deccriptionTextView=itemView.findViewById<TextView>(R.id.description_text_view)
        val imageView=itemView.findViewById<ImageView>(R.id.description_text_view)

        titleTextView.text=movie.title
        deccriptionTextView.text=movie.overview

        val posterURL = "https://image.tmdb.org/t/p/w500"+movie.posterPath
        Glide.with(imageView.context)
            .load(posterURL)
            .into(imageView)
    }
}


