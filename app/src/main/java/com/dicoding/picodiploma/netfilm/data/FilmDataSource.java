package com.dicoding.picodiploma.netfilm.data;

import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;

import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieCastEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieDetailEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieSimpleEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowCastEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowDetailEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowSimpleEntity;
import com.dicoding.picodiploma.netfilm.vo.Resource;

import java.util.List;

public interface FilmDataSource {

    LiveData<Resource<PagedList<TvShowSimpleEntity>>> getAllSimpleTvShows();

    LiveData<Resource<TvShowDetailEntity>> getDetailTvShowById(int tsId);

    LiveData<Resource<TvShowCastEntity>> getCastTvShowById(int tsId);

    LiveData<PagedList<TvShowDetailEntity>> getFavoriteTvShows();

    void setFavoriteTvShow(TvShowDetailEntity detailTvShow, boolean state);

    LiveData<Resource<PagedList<MovieSimpleEntity>>> getAllSimpleMovies();

    LiveData<Resource<MovieDetailEntity>> getDetailMovieById(int tsId);

    LiveData<Resource<MovieCastEntity>> getCastMovieById(int tsId);

    LiveData<PagedList<MovieDetailEntity>> getFavoriteMovies();

    void setFavoriteMovie(MovieDetailEntity detailMovie, boolean state);

}
