package com.dicoding.picodiploma.netfilm.ui.favorite.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.dicoding.picodiploma.netfilm.data.FilmRepository;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieDetailEntity;
import com.dicoding.picodiploma.netfilm.utils.DataDummy;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FavMovieViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private FavMovieViewModel viewModel;

    @Mock
    private FilmRepository filmRepository;
    @Mock
    private PagedList<MovieDetailEntity> pagedList;
    @Mock
    private Observer<PagedList<MovieDetailEntity>> observer;

    @Before
    public void setUp() {
        viewModel = new FavMovieViewModel(filmRepository);
    }

    @Test
    public void getFavMovies() {
        PagedList<MovieDetailEntity> dummyMovies = pagedList;
        when(dummyMovies.size()).thenReturn(5);
        MutableLiveData<PagedList<MovieDetailEntity>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        when(filmRepository.getFavoriteMovies()).thenReturn(movies);
        List<MovieDetailEntity> movieDetailEntities = viewModel.getFavMovies().getValue();
        verify(filmRepository).getFavoriteMovies();
        assertNotNull(movieDetailEntities);
        assertEquals(5, movieDetailEntities.size());

        viewModel.getFavMovies().observeForever(observer);
        verify(observer).onChanged(dummyMovies);
    }

    @Test
    public void setFavMovie() {
        MovieDetailEntity dummyDetailMovie = DataDummy.createDummyDetailMovies().get(0);
        boolean newState = !dummyDetailMovie.isMvFavorite();

        viewModel.setFavMovie(dummyDetailMovie);
        verify(filmRepository, times(1)).setFavoriteMovie(dummyDetailMovie, newState);
    }
}