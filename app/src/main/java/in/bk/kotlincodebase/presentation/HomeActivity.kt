package `in`.bk.kotlincodebase.presentation

import `in`.bk.kotlincodebase.R
import `in`.bk.kotlincodebase.presentation.artist.ArtistActivity
import `in`.bk.kotlincodebase.presentation.movie.MovieActivity
import `in`.bk.kotlincodebase.presentation.tv.TvShowActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initId()



    }


    private fun initId() {
        val movieButton=findViewById<Button>(R.id.movie_button)
        val tvButton=findViewById<Button>(R.id.tv_button)
        val artistsButton=findViewById<Button>(R.id.artists_button)

        movieButton.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        tvButton.setOnClickListener {
            val intent = Intent(this, TvShowActivity::class.java)
            startActivity(intent)
        }

        artistsButton.setOnClickListener {
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }
    }



}