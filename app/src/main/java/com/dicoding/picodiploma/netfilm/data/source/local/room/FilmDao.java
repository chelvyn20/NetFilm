package com.dicoding.picodiploma.netfilm.data.source.local.room;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieCastEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieDetailEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieSimpleEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowCastEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowDetailEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowSimpleEntity;

import java.util.List;

@Dao
public interface FilmDao {

    @Query("SELECT * FROM tvShowSimpleEntities")
    DataSource.Factory<Integer, TvShowSimpleEntity> getAllSimpleTvShows();

    @Query("SELECT * FROM tvShowDetailEntities WHERE tsId = :tsId")
    LiveData<TvShowDetailEntity> getDetailTvShowById(int tsId);

    @Query("SELECT * FROM tvShowCastEntities WHERE tsId = :tsId")
    LiveData<TvShowCastEntity> getCastTvShowById(int tsId);

    @Query("SELECT * FROM tvShowDetailEntities WHERE tsFavorite = 1")
    DataSource.Factory<Integer, TvShowDetailEntity> getFavoriteTvShows();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSimpleTvShows(List<TvShowSimpleEntity> simpleTvShows);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDetailTvShow(TvShowDetailEntity detailTvShow);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCastTvShow(TvShowCastEntity castTvShow);

    @Update
    void updateFavoriteTvShow(TvShowDetailEntity detailTvShow);


    @Query("SELECT * FROM movieSimpleEntities")
    DataSource.Factory<Integer, MovieSimpleEntity> getAllSimpleMovies();

    @Query("SELECT * FROM movieDetailEntities WHERE mvId = :mvId")
    LiveData<MovieDetailEntity> getDetailMovieById(int mvId);

    @Query("SELECT * FROM movieCastEntities WHERE mvId = :mvId")
    LiveData<MovieCastEntity> getCastMovieById(int mvId);

    @Query("SELECT * FROM movieDetailEntities WHERE mvFavorite = 1")
    DataSource.Factory<Integer, MovieDetailEntity> getFavoriteMovies();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSimpleMovies(List<MovieSimpleEntity> simpleMovies);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDetailMovie(MovieDetailEntity detailMovie);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCastMovie(MovieCastEntity castMovie);

    @Update
    void updateFavoriteMovie(MovieDetailEntity detailMovie);
}
