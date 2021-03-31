package com.dicoding.picodiploma.netfilm.ui.movie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagedList;

import com.dicoding.picodiploma.netfilm.data.FilmRepository;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieSimpleEntity;
import com.dicoding.picodiploma.netfilm.vo.Resource;

public class MovieViewModel extends ViewModel {
    private final FilmRepository filmRepository;

    public MovieViewModel(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public LiveData<Resource<PagedList<MovieSimpleEntity>>> getSimpleMovies() {
        return filmRepository.getAllSimpleMovies();
    }
}
