package `in`.bk.kotlincodebase.presentation.artist

import `in`.bk.kotlincodebase.R
import `in`.bk.kotlincodebase.presentation.di.Injector
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject

@Inject
lateinit var factory: ArtistViewModelFactory
private lateinit var artistViewModel: ArtistViewModel
private lateinit var adapter: ArtistAdapter
private lateinit var tvRecyclerView: RecyclerView
private lateinit var tvProgressBar: ProgressBar

class ArtistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist)
        (application as Injector).createArtistSubComponent()
            .inject(this)

        artistViewModel= ViewModelProvider(this,factory)
            .get(ArtistViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        tvRecyclerView=findViewById<RecyclerView>(R.id.tv_recyclerView)
        tvProgressBar=findViewById<ProgressBar>(R.id.tv_progressBar)
        tvRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        tvRecyclerView.adapter = adapter
        displayPopularArtists()
    }
    private fun displayPopularArtists(){
        tvProgressBar.visibility = View.VISIBLE
        val responseLiveData = artistViewModel.getArtists()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                tvProgressBar.visibility = View.GONE
            }else{
                tvProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateTvShows(){
        tvProgressBar.visibility = View.VISIBLE
        val response = artistViewModel.updateArtists()
        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                tvProgressBar.visibility = View.GONE
            }else{
                tvProgressBar.visibility = View.GONE
            }
        })
    }
}