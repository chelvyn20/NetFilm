package com.dicoding.picodiploma.netfilm.ui.favorite.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.dicoding.picodiploma.netfilm.data.FilmRepository;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieDetailEntity;

public class FavMovieViewModel extends ViewModel {
    private final FilmRepository filmRepository;

    public FavMovieViewModel(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public LiveData<PagedList<MovieDetailEntity>> getFavMovies() {
        return filmRepository.getFavoriteMovies();
    }

    void setFavMovie(MovieDetailEntity favMovie) {
        final boolean newState = !favMovie.isMvFavorite();
        filmRepository.setFavoriteMovie(favMovie, newState);
    }
}
