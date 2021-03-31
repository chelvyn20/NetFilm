package com.dicoding.picodiploma.netfilm.vm;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.dicoding.picodiploma.netfilm.data.FilmRepository;
import com.dicoding.picodiploma.netfilm.di.Injection;
import com.dicoding.picodiploma.netfilm.ui.detail.DetailMovieViewModel;
import com.dicoding.picodiploma.netfilm.ui.detail.DetailTvShowViewModel;
import com.dicoding.picodiploma.netfilm.ui.favorite.movie.FavMovieViewModel;
import com.dicoding.picodiploma.netfilm.ui.favorite.tvshow.FavTvShowViewModel;
import com.dicoding.picodiploma.netfilm.ui.movie.MovieViewModel;
import com.dicoding.picodiploma.netfilm.ui.tvshow.TvShowViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private static volatile ViewModelFactory INSTANCE;
    private final FilmRepository filmRepository;

    private ViewModelFactory(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public static ViewModelFactory getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory(Injection.provideRepository(context));
                }
            }
        }
        return INSTANCE;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(TvShowViewModel.class)) {
            return (T) new TvShowViewModel(filmRepository);
        } else if (modelClass.isAssignableFrom(DetailTvShowViewModel.class)) {
            return (T) new DetailTvShowViewModel(filmRepository);
        } else if (modelClass.isAssignableFrom(FavTvShowViewModel.class)) {
            return (T) new FavTvShowViewModel(filmRepository);
        } else if (modelClass.isAssignableFrom(MovieViewModel.class)) {
            return (T) new MovieViewModel(filmRepository);
        } else if (modelClass.isAssignableFrom(DetailMovieViewModel.class)) {
            return (T) new DetailMovieViewModel(filmRepository);
        } else if (modelClass.isAssignableFrom(FavMovieViewModel.class)) {
            return (T) new FavMovieViewModel(filmRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }
}
