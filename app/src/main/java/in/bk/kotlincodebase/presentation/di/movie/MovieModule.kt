package `in`.bk.kotlincodebase.presentation.di.movie

import `in`.bk.kotlincodebase.domain.usecase.GetMoviesUseCase
import `in`.bk.kotlincodebase.domain.usecase.UpdateMoviesUsecase
import `in`.bk.kotlincodebase.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMoviesUsecase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }
}