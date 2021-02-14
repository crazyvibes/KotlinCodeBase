package `in`.bk.kotlincodebase.presentation.di.tvshow

import `in`.bk.kotlincodebase.domain.usecase.GetTvShowsUseCase
import `in`.bk.kotlincodebase.domain.usecase.UpdateTvShowsUseCase
import `in`.bk.kotlincodebase.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }
}