package com.dicoding.picodiploma.netfilm.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.dicoding.picodiploma.netfilm.data.FilmRepository;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieCastEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieDetailEntity;
import com.dicoding.picodiploma.netfilm.vo.Resource;

public class DetailMovieViewModel extends ViewModel {
    private final MutableLiveData<Integer> mvId = new MutableLiveData<>();

    private FilmRepository filmRepository;

    public LiveData<Resource<MovieDetailEntity>> detailMovie = Transformations.switchMap(mvId,
            id -> filmRepository.getDetailMovieById(id));

    public LiveData<Resource<MovieCastEntity>> castMovie = Transformations.switchMap(mvId,
            id -> filmRepository.getCastMovieById(id));

    public DetailMovieViewModel(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public void setMovieId(int mvId) {
        this.mvId.setValue(mvId);
    }

    void setFavorite() {
        Resource<MovieDetailEntity> movieResource = detailMovie.getValue();

        if (movieResource != null) {
            MovieDetailEntity movieEntity = movieResource.data;

            if (movieEntity != null) {
                final boolean newState = !movieEntity.isMvFavorite();
                filmRepository.setFavoriteMovie(movieEntity, newState);
            }
        }
    }
}
