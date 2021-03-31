package com.dicoding.picodiploma.netfilm.ui.favorite.tvshow;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.paging.PagedList;

import com.dicoding.picodiploma.netfilm.data.FilmRepository;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowDetailEntity;
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
public class FavTvShowViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private FavTvShowViewModel viewModel;

    @Mock
    private FilmRepository filmRepository;
    @Mock
    private PagedList<TvShowDetailEntity> pagedList;
    @Mock
    private Observer<PagedList<TvShowDetailEntity>> observer;

    @Before
    public void setUp() {
        viewModel = new FavTvShowViewModel(filmRepository);
    }

    @Test
    public void getFavTvShows() {
        PagedList<TvShowDetailEntity> dummyTvShows = pagedList;
        when(dummyTvShows.size()).thenReturn(5);
        MutableLiveData<PagedList<TvShowDetailEntity>> tvShows = new MutableLiveData<>();
        tvShows.setValue(dummyTvShows);

        when(filmRepository.getFavoriteTvShows()).thenReturn(tvShows);
        List<TvShowDetailEntity> tvShowDetailEntities = viewModel.getFavTvShows().getValue();
        verify(filmRepository).getFavoriteTvShows();
        assertNotNull(tvShowDetailEntities);
        assertEquals(5, tvShowDetailEntities.size());

        viewModel.getFavTvShows().observeForever(observer);
        verify(observer).onChanged(dummyTvShows);
    }

    @Test
    public void setFavTvShow() {
        TvShowDetailEntity dummyDetailTvShow = DataDummy.createDummyDetailTvShows().get(0);
        boolean newState = !dummyDetailTvShow.isTsFavorite();

        viewModel.setFavTvShow(dummyDetailTvShow);
        verify(filmRepository, times(1)).setFavoriteTvShow(dummyDetailTvShow, newState);
    }

}