package com.dicoding.picodiploma.netfilm.data.source.local.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieCastEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieDetailEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieSimpleEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowCastEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowDetailEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowSimpleEntity;

@Database(entities = {
        TvShowSimpleEntity.class, TvShowDetailEntity.class, TvShowCastEntity.class,
        MovieSimpleEntity.class, MovieDetailEntity.class, MovieCastEntity.class},
        version = 1, exportSchema = false
)
public abstract class FilmDatabase extends RoomDatabase {
    private static volatile FilmDatabase INSTANCE;

    public static FilmDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (FilmDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FilmDatabase.class, "Films.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract FilmDao filmDao();

}
