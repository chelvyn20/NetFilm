package com.dicoding.picodiploma.netfilm.ui.favorite.tvshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.dicoding.picodiploma.netfilm.data.FilmRepository;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowDetailEntity;

public class FavTvShowViewModel extends ViewModel {
    private final FilmRepository filmRepository;

    public FavTvShowViewModel(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public LiveData<PagedList<TvShowDetailEntity>> getFavTvShows() {
        return filmRepository.getFavoriteTvShows();
    }

    void setFavTvShow(TvShowDetailEntity favTvShow) {
        final boolean newState = !favTvShow.isTsFavorite();
        filmRepository.setFavoriteTvShow(favTvShow, newState);
    }
}
