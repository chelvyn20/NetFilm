package com.dicoding.picodiploma.netfilm.ui.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.dicoding.picodiploma.netfilm.data.FilmRepository;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowSimpleEntity;
import com.dicoding.picodiploma.netfilm.vo.Resource;

public class TvShowViewModel extends ViewModel {
    private final FilmRepository filmRepository;

    public TvShowViewModel(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public LiveData<Resource<PagedList<TvShowSimpleEntity>>> getSimpleTvShows() {
        return filmRepository.getAllSimpleTvShows();
    }

}
