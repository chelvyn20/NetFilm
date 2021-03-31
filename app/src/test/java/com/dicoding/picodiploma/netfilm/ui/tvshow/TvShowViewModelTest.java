package com.dicoding.picodiploma.netfilm.ui.tvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.dicoding.picodiploma.netfilm.data.FilmRepository;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowSimpleEntity;
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
public class TvShowViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private TvShowViewModel viewModel;

    @Mock
    private FilmRepository filmRepository;
    @Mock
    private PagedList<TvShowSimpleEntity> pagedList;
    @Mock
    private Observer<Resource<PagedList<TvShowSimpleEntity>>> observer;

    @Before
    public void setUp() {
        viewModel = new TvShowViewModel(filmRepository);
    }

    @Test
    public void getSimpleTvShows() {
        Resource<PagedList<TvShowSimpleEntity>> dummyTvShows = Resource.success(pagedList);
        when(dummyTvShows.data.size()).thenReturn(5);
        MutableLiveData<Resource<PagedList<TvShowSimpleEntity>>> tvShows = new MutableLiveData<>();
        tvShows.setValue(dummyTvShows);

        when(filmRepository.getAllSimpleTvShows()).thenReturn(tvShows);
        List<TvShowSimpleEntity> tvShowSimpleEntities = viewModel.getSimpleTvShows().getValue().data;
        verify(filmRepository).getAllSimpleTvShows();
        assertNotNull(tvShowSimpleEntities);
        assertEquals(5, tvShowSimpleEntities.size());

        viewModel.getSimpleTvShows().observeForever(observer);
        verify(observer).onChanged(dummyTvShows);
    }
}