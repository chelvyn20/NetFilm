package com.dicoding.picodiploma.netfilm.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.dicoding.picodiploma.netfilm.data.FilmRepository;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowCastEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowDetailEntity;
import com.dicoding.picodiploma.netfilm.vo.Resource;

public class DetailTvShowViewModel extends ViewModel {
    private final MutableLiveData<Integer> tsId = new MutableLiveData<>();

    private FilmRepository filmRepository;

    public LiveData<Resource<TvShowDetailEntity>> detailTvShow = Transformations.switchMap(tsId,
            id -> filmRepository.getDetailTvShowById(id));
    public LiveData<Resource<TvShowCastEntity>> castTvShow = Transformations.switchMap(tsId,
            id -> filmRepository.getCastTvShowById(id));

    public DetailTvShowViewModel(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public void setTvShowId(int tsId) {
        this.tsId.setValue(tsId);
    }

    void setFavorite() {
        Resource<TvShowDetailEntity> tvShowResource = detailTvShow.getValue();

        if (tvShowResource != null) {
            TvShowDetailEntity tvShowEntity = tvShowResource.data;

            if (tvShowEntity != null) {
                final boolean newState = !tvShowEntity.isTsFavorite();
                filmRepository.setFavoriteTvShow(tvShowEntity, newState);
            }
        }
    }
}
