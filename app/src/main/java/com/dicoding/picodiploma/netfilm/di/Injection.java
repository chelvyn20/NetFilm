package com.dicoding.picodiploma.netfilm.di;

import android.content.Context;

import com.dicoding.picodiploma.netfilm.data.FilmRepository;
import com.dicoding.picodiploma.netfilm.data.source.local.LocalDataSource;
import com.dicoding.picodiploma.netfilm.data.source.local.room.FilmDatabase;
import com.dicoding.picodiploma.netfilm.data.source.remote.RemoteDataSource;
import com.dicoding.picodiploma.netfilm.utils.AppExecutors;

public class Injection {
    public static FilmRepository provideRepository(Context context) {
        FilmDatabase database = FilmDatabase.getInstance(context);

        RemoteDataSource remoteDataResource = RemoteDataSource.getInstance();
        LocalDataSource localDataSource = LocalDataSource.getInstance(database.filmDao());
        AppExecutors appExecutors = new AppExecutors();

        return FilmRepository.getInstance(remoteDataResource, localDataSource, appExecutors);
    }
}
