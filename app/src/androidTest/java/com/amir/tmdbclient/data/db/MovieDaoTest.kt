package com.amir.tmdbclient.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.amir.tmdbclient.data.model.movie.Movie
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieDaoTest {

    //Since we are testing Architecture components, To execute those tasks synchronously, We need to use  InstantTaskExecutorRule.
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    //movieDao is subject under the test in this class
    private lateinit var dao: MovieDao
    private lateinit var database: TMDBDatabase

    /*
    Room library has a special data base builder named inMemoryDatabaseBuilder.
    This inMemoryDatabaseBuilder allows us to create temporary databases for testing.
    The database will be created in system memory, When we kill the process
    after testing the app, database will be removed and data will not be persisted.
     */
    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TMDBDatabase::class.java
        ).build()
        dao = database.movieDao()
    }

    //we need a function to close the database after the testing
    //@after will be run after testing
    @After
    fun tearDown() {
        database.close()
    }

    /*
    This is what I am going to do here.
     I will create a list of movie objects.
     Save them to the database .
     get the saved list from the database and compare that with the original list.
     */
    //to use the coroutine here we make use of runBlocking
    @Test
    fun saveMoviesTest(): Unit = runBlocking {
        val movies = listOf(
            Movie(1, "overview1", "posterPath1", "data1", "title1"),
            Movie(2, "overview2", "posterPath2", "data2", "title2"),
            Movie(3, "overview3", "posterPath3", "data3", "title3")
        )
        dao.saveMovies(movies)

        //Here, we have to assume that get movies function working correctly.
        val allMovies = dao.getMovies()
        Truth.assertThat(allMovies).isEqualTo(movies)
    }

    @Test
    fun deleteMoviesTest(): Unit = runBlocking {
        //we need some data in our database
        val movies = listOf(
            Movie(1, "overview1", "posterPath1", "data1", "title1"),
            Movie(2, "overview2", "posterPath2", "data2", "title2"),
            Movie(3, "overview3", "posterPath3", "data3", "title3")
        )
        dao.saveMovies(movies)
        dao.deleteAllMovies()
        val moviesResult = dao.getMovies()
        Truth.assertThat(moviesResult).isEmpty()
    }
}