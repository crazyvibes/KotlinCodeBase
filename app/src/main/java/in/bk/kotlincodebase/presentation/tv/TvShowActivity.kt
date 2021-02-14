package `in`.bk.kotlincodebase.presentation.tv

import `in`.bk.kotlincodebase.R
import `in`.bk.kotlincodebase.presentation.di.Injector
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject

@Inject
lateinit var factory: TvShowViewModelFactory
private lateinit var tvShowViewModel: TvShowViewModel
private lateinit var adapter: TvShowAdapter
private lateinit var tvRecyclerView: RecyclerView
private lateinit var tvProgressBar: ProgressBar
class TvShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show)

        (application as Injector).createTvShowSubComponent()
            .inject(this)

        tvShowViewModel= ViewModelProvider(this,factory)
            .get(TvShowViewModel::class.java)

        initRecyclerView()
      
    }

    private fun initRecyclerView(){
         tvRecyclerView=findViewById<RecyclerView>(R.id.tv_recyclerView)
         tvProgressBar=findViewById<ProgressBar>(R.id.tv_progressBar)
        
        tvRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        tvRecyclerView.adapter = adapter
        displayPopularTvShows()
    }

    private fun displayPopularTvShows(){
        tvProgressBar.visibility = View.VISIBLE
        val responseLiveData = tvShowViewModel.getTvShows()
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
        val response = tvShowViewModel.updateTvShows()
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