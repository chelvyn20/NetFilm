package com.dicoding.picodiploma.netfilm.data.source.local;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;

import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieCastEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieDetailEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieSimpleEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowCastEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowDetailEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowSimpleEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.room.FilmDao;

import java.util.List;

public class LocalDataSource {
    private static LocalDataSource INSTANCE;
    private final FilmDao filmDao;

    private LocalDataSource(FilmDao filmDao) {
        this.filmDao = filmDao;
    }

    public static LocalDataSource getInstance(FilmDao filmDao) {
        if (INSTANCE == null) {
            INSTANCE = new LocalDataSource(filmDao);
        }
        return INSTANCE;
    }

    public DataSource.Factory<Integer, TvShowSimpleEntity> getAllSimpleTvShows() {
        return filmDao.getAllSimpleTvShows();
    }

    public LiveData<TvShowDetailEntity> getDetailTvShowById(int tsId) {
        return filmDao.getDetailTvShowById(tsId);
    }

    public LiveData<TvShowCastEntity> getCastTvShowById(int tsId) {
        return filmDao.getCastTvShowById(tsId);
    }

    public DataSource.Factory<Integer, TvShowDetailEntity> getFavoriteTvShows() {
        return filmDao.getFavoriteTvShows();
    }

    public void setFavoriteTvShow(TvShowDetailEntity detailTvShow, boolean newState) {
        detailTvShow.setTsFavorite(newState);
        filmDao.updateFavoriteTvShow(detailTvShow);
    }

    public void insertSimpleTvShows(List<TvShowSimpleEntity> simpleTvShows) {
        filmDao.insertSimpleTvShows(simpleTvShows);
    }

    public void insertDetailTvShow(TvShowDetailEntity detailTvShows) {
        filmDao.insertDetailTvShow(detailTvShows);
    }

    public void insertCastTvShow(TvShowCastEntity castTvShows) {
        filmDao.insertCastTvShow(castTvShows);
    }


    public DataSource.Factory<Integer, MovieSimpleEntity> getAllSimpleMovies() {
        return filmDao.getAllSimpleMovies();
    }

    public LiveData<MovieDetailEntity> getDetailMovieById(int mId) {
        return filmDao.getDetailMovieById(mId);
    }

    public LiveData<MovieCastEntity> getCastMovieById(int mId) {
        return filmDao.getCastMovieById(mId);
    }

    public DataSource.Factory<Integer, MovieDetailEntity> getFavoriteMovies() {
        return filmDao.getFavoriteMovies();
    }

    public void setFavoriteMovie(MovieDetailEntity detailMovie, boolean newState) {
        detailMovie.setMvFavorite(newState);
        filmDao.updateFavoriteMovie(detailMovie);
    }

    public void insertSimpleMovies(List<MovieSimpleEntity> simpleMovies) {
        filmDao.insertSimpleMovies(simpleMovies);
    }

    public void insertDetailMovie(MovieDetailEntity detailMovie) {
        filmDao.insertDetailMovie(detailMovie);
    }

    public void insertCastMovie(MovieCastEntity castMovie) {
        filmDao.insertCastMovie(castMovie);
    }

}
