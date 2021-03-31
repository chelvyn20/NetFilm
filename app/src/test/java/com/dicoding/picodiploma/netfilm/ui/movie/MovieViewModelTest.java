package com.dicoding.picodiploma.netfilm.ui.movie;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.dicoding.picodiploma.netfilm.data.FilmRepository;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieSimpleEntity;
import com.dicoding.picodiploma.netfilm.vo.Resource;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private MovieViewModel viewModel;

    @Mock
    private FilmRepository filmRepository;
    @Mock
    private PagedList<MovieSimpleEntity> pagedList;
    @Mock
    private Observer<Resource<PagedList<MovieSimpleEntity>>> observer;

    @Before
    public void setUp() {
        viewModel = new MovieViewModel(filmRepository);
    }

    @Test
    public void getSimpleMovies() {
        Resource<PagedList<MovieSimpleEntity>> dummyMovies = Resource.success(pagedList);
        when(dummyMovies.data.size()).thenReturn(5);
        MutableLiveData<Resource<PagedList<MovieSimpleEntity>>> movies = new MutableLiveData<>();
        movies.setValue(dummyMovies);

        when(filmRepository.getAllSimpleMovies()).thenReturn(movies);
        List<MovieSimpleEntity> movieSimpleEntities = viewModel.getSimpleMovies().getValue().data;
        verify(filmRepository).getAllSimpleMovies();
        assertNotNull(movieSimpleEntities);
        assertEquals(5, movieSimpleEntities.size());

        viewModel.getSimpleMovies().observeForever(observer);
        verify(observer).onChanged(dummyMovies);
    }
}