package com.dicoding.picodiploma.netfilm.ui.detail;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.dicoding.picodiploma.netfilm.data.FilmRepository;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieDetailEntity;
import com.dicoding.picodiploma.netfilm.utils.DataDummy;
import com.dicoding.picodiploma.netfilm.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DetailMovieViewModelTest {
    private final MovieDetailEntity dummyDetailMovie = DataDummy.createDummyDetailMovies().get(0);
    private final int mvId = dummyDetailMovie.getMvId();
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private DetailMovieViewModel viewModel;
    @Mock
    private FilmRepository filmRepository;

    @Mock
    private Observer<Resource<MovieDetailEntity>> observer;

    @Before
    public void setUp() {
        viewModel = new DetailMovieViewModel(filmRepository);
        viewModel.setMovieId(mvId);
    }

    @Test
    public void getDetailMovieById() {
        Resource<MovieDetailEntity> dummyMovieDetailResource = Resource.success(
                DataDummy.generateDummyDetailMovie(dummyDetailMovie, true));
        MutableLiveData<Resource<MovieDetailEntity>> detailMovie = new MutableLiveData<>();
        detailMovie.setValue(dummyMovieDetailResource);
        when(filmRepository.getDetailMovieById(mvId)).thenReturn(detailMovie);

        viewModel.detailMovie.observeForever(observer);
        verify(observer).onChanged(dummyMovieDetailResource);
    }

    @Test
    public void setFavorite() {
        boolean newState = !dummyDetailMovie.isMvFavorite();

        Resource<MovieDetailEntity> dummyDetailMovieResource = Resource.success(DataDummy.generateDummyDetailMovie(dummyDetailMovie, false));
        MutableLiveData<Resource<MovieDetailEntity>> detailMovie = new MutableLiveData<>();
        detailMovie.setValue(dummyDetailMovieResource);
        when(filmRepository.getDetailMovieById(mvId)).thenReturn(detailMovie);

        viewModel.detailMovie.observeForever(observer);
        viewModel.setFavorite();
        verify(filmRepository).setFavoriteMovie(dummyDetailMovie, newState);
    }


}