package `in`.bk.kotlincodebase.data.repository.tvshow.datasourceImpl

import `in`.bk.kotlincodebase.data.db.TvShowDao
import `in`.bk.kotlincodebase.data.model.tvshow.TvShow
import `in`.bk.kotlincodebase.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl (private val tvDao: TvShowDao):
    TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvDao.deleteAllTvShows()
        }
    }
}