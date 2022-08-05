package com.amir.tmdbclient.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.amir.tmdbclient.data.model.movie.Movie
import com.amir.tmdbclient.data.repository.movie.FakeMovieRepository
import com.amir.tmdbclient.domain.usecase.GetMoviesUseCases
import com.amir.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.amir.tmdbclient.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/*we are going to run simulated Android code in our test source set.
For that we need to use Robolectric dependency and the AndroidJUnit4 test runner.*/

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {

/*This InstantTaskExecutorRule is a class from JUnit library.
 This rule runs all Jetpack Architecture Components-related background jobs in the same thread.
  Because of that test results will happen synchronously, and in a repeatable order.
   When we write tests that include testing LiveData, we should use this InstantTaskExecutorRule*/

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    //subject under Test on this test class is MovieViewModel
    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMoviesUseCase = GetMoviesUseCases(fakeMovieRepository)
        val updateMoviesUseCase = UpdateMoviesUseCase(fakeMovieRepository)
        viewModel = MovieViewModel(getMoviesUseCase, updateMoviesUseCase)
    }

    @Test
    fun getMovies_returnCurrentList() {
        val movies = mutableListOf<Movie>()
        movies.add(Movie(1, "overview1", "posterPath1", "data1", "title1"))
        movies.add(Movie(2, "overview2", "posterPath2", "data2", "title2"))
        movies.add(Movie(3, "overview3", "posterPath3", "data3", "title3"))
/*
Here we have problem, this getMovies functions retruns the list as live data. To compare,
we need to convert in to a normal list of movies.There are different ways to do it.
The easiest way is using a live data extension function called LiveDataTestUtil.
LiveDataTestUtil is a reusable code sample you can find from google documentatons.
 */
        //we create another class in order to convert the liveData: LiveDataTestUtil
        //you can use this sample code every where you need to convert datalive
        val currentList = viewModel.getMovies().getOrAwaitValue()
        //from thruth asset libarary
        assertThat(currentList).isEqualTo(movies)
    }
    @Test
    fun updateMovies_returnUpdatedList() {
        val movies = mutableListOf<Movie>()
        movies.add(Movie(4, "overview4", "posterPath4", "data4", "title4"))
        movies.add(Movie(5, "overview5", "posterPath5", "data5", "title5"))

        val updatedList = viewModel.updateMovies().getOrAwaitValue()

        assertThat(updatedList).isEqualTo(movies)
    }
}