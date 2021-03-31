package com.dicoding.picodiploma.netfilm.utils;

import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.Movie;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.MovieCastResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.MovieDetailResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShow;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowCastResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowDetailResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/3/tv/popular")
    Call<TvShow> getTvShows(
            @Query("api_key") String apiKey);

    @GET("/3/tv/{id}")
    Call<TvShowDetailResponse> getTvShowDetail(
            @Path("id") int id,
            @Query("api_key") String apiKey);

    @GET("/3/tv/{id}/credits")
    Call<TvShowCastResponse> getTvShowCast(
            @Path("id") int id,
            @Query("api_key") String apiKey);

    @GET("/3/movie/popular")
    Call<Movie> getMovies(
            @Query("api_key") String apiKey);

    @GET("/3/movie/{id}")
    Call<MovieDetailResponse> getMovieDetail(
            @Path("id") int id,
            @Query("api_key") String apiKey);

    @GET("/3/movie/{id}/credits")
    Call<MovieCastResponse> getMovieCast(
            @Path("id") int id,
            @Query("api_key") String apiKey);
}
