package com.dicoding.picodiploma.netfilm.ui.detail;


import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.dicoding.picodiploma.netfilm.data.FilmRepository;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowDetailEntity;
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
public class DetailTvShowViewModelTest {
    private final TvShowDetailEntity dummyDetailTvShow = DataDummy.createDummyDetailTvShows().get(0);
    private final int tsId = dummyDetailTvShow.getTsId();
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private DetailTvShowViewModel viewModel;

    @Mock
    private FilmRepository filmRepository;

    @Mock
    private Observer<Resource<TvShowDetailEntity>> observer;

    @Before
    public void setUp() {
        viewModel = new DetailTvShowViewModel(filmRepository);
        viewModel.setTvShowId(tsId);
    }

    @Test
    public void getDetailTvShowById() {
        Resource<TvShowDetailEntity> dummyTvShowDetailResource = Resource.success(
                DataDummy.generateDummyDetailTvShow(dummyDetailTvShow, true));
        MutableLiveData<Resource<TvShowDetailEntity>> detailTvShow = new MutableLiveData<>();
        detailTvShow.setValue(dummyTvShowDetailResource);
        when(filmRepository.getDetailTvShowById(tsId)).thenReturn(detailTvShow);

        viewModel.detailTvShow.observeForever(observer);
        verify(observer).onChanged(dummyTvShowDetailResource);
    }

    @Test
    public void setFavorite() {
        boolean newState = !dummyDetailTvShow.isTsFavorite();

        Resource<TvShowDetailEntity> dummyDetailTvShowResource = Resource.success(DataDummy.generateDummyDetailTvShow(dummyDetailTvShow, false));
        MutableLiveData<Resource<TvShowDetailEntity>> detailTvShow = new MutableLiveData<>();
        detailTvShow.setValue(dummyDetailTvShowResource);
        when(filmRepository.getDetailTvShowById(tsId)).thenReturn(detailTvShow);

        viewModel.detailTvShow.observeForever(observer);
        viewModel.setFavorite();
        verify(filmRepository).setFavoriteTvShow(dummyDetailTvShow, newState);
    }

}