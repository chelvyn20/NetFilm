package com.dicoding.picodiploma.netfilm.data;

import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.dicoding.picodiploma.netfilm.data.source.local.LocalDataSource;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieCastEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieDetailEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieSimpleEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowCastEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowDetailEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowSimpleEntity;
import com.dicoding.picodiploma.netfilm.data.source.remote.ApiResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.RemoteDataSource;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.MovieCastItem;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.MovieCastResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.MovieDetailResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.MovieGenreItem;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.MovieProducerItem;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.MovieResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowCastItem;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowCastResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowCreatorItem;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowDetailResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowGenreItem;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowNetworkItem;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowProducerItem;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowResponse;
import com.dicoding.picodiploma.netfilm.utils.AppExecutors;
import com.dicoding.picodiploma.netfilm.vo.Resource;

import java.util.ArrayList;
import java.util.List;

public class FilmRepository implements FilmDataSource {

    private volatile static FilmRepository INSTANCE;
    private final RemoteDataSource remoteDataSource;
    private final LocalDataSource localDataSource;
    private final AppExecutors appExecutors;

    public FilmRepository(RemoteDataSource remoteDataSource, LocalDataSource localDataSource, AppExecutors appExecutors) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
        this.appExecutors = appExecutors;
    }

    public static FilmRepository getInstance(RemoteDataSource remoteDataSource, LocalDataSource localDataSource, AppExecutors appExecutors) {
        if (INSTANCE == null) {
            synchronized (FilmRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FilmRepository(remoteDataSource, localDataSource, appExecutors);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public LiveData<Resource<PagedList<TvShowSimpleEntity>>> getAllSimpleTvShows() {
        return new NetworkBoundResource<PagedList<TvShowSimpleEntity>, List<TvShowResponse>>(appExecutors) {
            @Override
            protected Boolean shouldFetch(PagedList<TvShowSimpleEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<PagedList<TvShowSimpleEntity>> loadFromDB() {
                PagedList.Config config = new PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(5)
                        .setPageSize(5)
                        .build();
                return new LivePagedListBuilder<>(localDataSource.getAllSimpleTvShows(), config).build();
            }

            @Override
            protected LiveData<ApiResponse<List<TvShowResponse>>> createCall() {
                return remoteDataSource.getAllSimpleTvShows();
            }

            @Override
            protected void saveCallResult(List<TvShowResponse> data) {
                ArrayList<TvShowSimpleEntity> tvShowList = new ArrayList<>();
                for (TvShowResponse response : data) {
                    TvShowSimpleEntity tvShowItem = new TvShowSimpleEntity(response.getId(),
                            response.getPosterPath(),
                            response.getName(),
                            response.getFirstAirDate(),
                            response.getVoteAverage(),
                            response.getOverview());

                    tvShowList.add(tvShowItem);
                }

                localDataSource.insertSimpleTvShows(tvShowList);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<TvShowDetailEntity>> getDetailTvShowById(int tsId) {
        return new NetworkBoundResource<TvShowDetailEntity, TvShowDetailResponse>(appExecutors) {
            @Override
            protected Boolean shouldFetch(TvShowDetailEntity data) {
                return (data == null);
            }

            @Override
            protected LiveData<TvShowDetailEntity> loadFromDB() {
                return localDataSource.getDetailTvShowById(tsId);
            }

            @Override
            protected LiveData<ApiResponse<TvShowDetailResponse>> createCall() {
                return remoteDataSource.getDetailTvShowById(tsId);
            }

            @Override
            protected void saveCallResult(TvShowDetailResponse data) {

                List<TvShowGenreItem> genreItems = data.getGenres();
                StringBuilder sbGenre = new StringBuilder();
                if (genreItems.size() != 0) {
                    for (int i = 0; i < genreItems.size(); i++) {
                        sbGenre.append(genreItems.get(i).getName());
                        sbGenre.append(", ");
                    }

                } else {
                    sbGenre.append("Unknown..");
                }
                String genre = sbGenre.toString();
                genre = genre.substring(0, genre.length() - 2);

                List<TvShowNetworkItem> publisherItems = data.getNetworks();
                StringBuilder sbPublisher = new StringBuilder();
                if (publisherItems.size() != 0) {
                    for (int i = 0; i < publisherItems.size(); i++) {
                        sbPublisher.append(publisherItems.get(i).getName());
                        sbPublisher.append(", ");
                    }

                } else {
                    sbPublisher.append("Unknown..");
                }
                String publisher = sbPublisher.toString();
                publisher = publisher.substring(0, publisher.length() - 2);

                List<TvShowProducerItem> producerItems = data.getProductionCompanies();
                StringBuilder sbProducer = new StringBuilder();
                if (producerItems.size() != 0) {
                    for (int i = 0; i < producerItems.size(); i++) {
                        sbProducer.append(producerItems.get(i).getName());
                        sbProducer.append(", ");
                    }

                } else {
                    sbProducer.append("Unknown..");
                }
                String producer = sbProducer.toString();
                producer = producer.substring(0, producer.length() - 2);

                List<TvShowCreatorItem> creatorItems = data.getCreatedBy();
                StringBuilder sbCreator = new StringBuilder();
                if (creatorItems.size() != 0) {
                    for (int i = 0; i < creatorItems.size(); i++) {
                        sbCreator.append(creatorItems.get(i).getName());
                        sbCreator.append(", ");
                    }

                } else {
                    sbCreator.append("Unknown..");
                }
                String creator = sbCreator.toString();
                creator = creator.substring(0, creator.length() - 2);

                TvShowDetailEntity detailTvShow = new TvShowDetailEntity(
                        data.getId(),
                        data.getPosterPath(),
                        data.getName(),
                        data.getFirstAirDate(),
                        data.getVoteAverage(),
                        data.getOverview(),
                        null,
                        data.getNumberOfSeasons(),
                        genre,
                        publisher,
                        producer,
                        creator
                );

                localDataSource.insertDetailTvShow(detailTvShow);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<TvShowCastEntity>> getCastTvShowById(int tsId) {
        return new NetworkBoundResource<TvShowCastEntity, TvShowCastResponse>(appExecutors) {
            @Override
            protected Boolean shouldFetch(TvShowCastEntity data) {
                return (data == null) || (data.getTsCast() == null);
            }

            @Override
            protected LiveData<TvShowCastEntity> loadFromDB() {
                return localDataSource.getCastTvShowById(tsId);
            }

            @Override
            protected LiveData<ApiResponse<TvShowCastResponse>> createCall() {
                return remoteDataSource.getCastTvShowById(tsId);
            }

            @Override
            protected void saveCallResult(TvShowCastResponse data) {

                List<TvShowCastItem> castItems = data.getCast();
                StringBuilder sbCast = new StringBuilder();
                if (castItems.size() != 0) {
                    for (int i = 0; i < castItems.size(); i++) {
                        sbCast.append(castItems.get(i).getName());
                        sbCast.append(", ");
                    }

                } else {
                    sbCast.append("Unknown..");
                }
                String cast = sbCast.toString();
                cast = cast.substring(0, cast.length() - 2);

                TvShowCastEntity castTvShow = new TvShowCastEntity(
                        data.getId(), cast);

                localDataSource.insertCastTvShow(castTvShow);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<PagedList<TvShowDetailEntity>> getFavoriteTvShows() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(5)
                .setPageSize(5)
                .build();
        return new LivePagedListBuilder<>(localDataSource.getFavoriteTvShows(), config).build();
    }

    @Override
    public void setFavoriteTvShow(TvShowDetailEntity tvShowEntity, boolean state) {
        appExecutors.diskIO().execute(() -> localDataSource.setFavoriteTvShow(tvShowEntity, state));
    }

    @Override
    public LiveData<Resource<PagedList<MovieSimpleEntity>>> getAllSimpleMovies() {
        return new NetworkBoundResource<PagedList<MovieSimpleEntity>, List<MovieResponse>>(appExecutors) {
            @Override
            protected Boolean shouldFetch(PagedList<MovieSimpleEntity> data) {
                return (data == null) || (data.size() == 0);
            }

            @Override
            protected LiveData<PagedList<MovieSimpleEntity>> loadFromDB() {
                PagedList.Config config = new PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(5)
                        .setPageSize(5)
                        .build();
                return new LivePagedListBuilder<>(localDataSource.getAllSimpleMovies(), config).build();
            }

            @Override
            protected LiveData<ApiResponse<List<MovieResponse>>> createCall() {
                return remoteDataSource.getAllSimpleMovies();
            }

            @Override
            protected void saveCallResult(List<MovieResponse> data) {
                ArrayList<MovieSimpleEntity> movieList = new ArrayList<>();
                for (MovieResponse response : data) {
                    MovieSimpleEntity movieItem = new MovieSimpleEntity(response.getId(),
                            response.getPosterPath(),
                            response.getTitle(),
                            response.getReleaseDate(),
                            response.getVoteAverage(),
                            response.getOverview());

                    movieList.add(movieItem);
                }

                localDataSource.insertSimpleMovies(movieList);
            }

        }.asLiveData();
    }

    @Override
    public LiveData<Resource<MovieDetailEntity>> getDetailMovieById(int mvId) {
        return new NetworkBoundResource<MovieDetailEntity, MovieDetailResponse>(appExecutors) {
            @Override
            protected Boolean shouldFetch(MovieDetailEntity data) {
                return (data == null);
            }

            @Override
            protected LiveData<MovieDetailEntity> loadFromDB() {
                return localDataSource.getDetailMovieById(mvId);
            }

            @Override
            protected LiveData<ApiResponse<MovieDetailResponse>> createCall() {
                return remoteDataSource.getDetailMovieById(mvId);
            }

            @Override
            protected void saveCallResult(MovieDetailResponse data) {
                List<MovieGenreItem> genreItems = data.getGenres();
                StringBuilder sbGenre = new StringBuilder();
                if (genreItems.size() != 0) {
                    for (int i = 0; i < genreItems.size(); i++) {
                        sbGenre.append(genreItems.get(i).getName());
                        sbGenre.append(", ");
                    }

                } else {
                    sbGenre.append("Unknown..");
                }
                String genre = sbGenre.toString();
                genre = genre.substring(0, genre.length() - 2);

                List<MovieProducerItem> producerItems = data.getProductionCompanies();
                StringBuilder sbProducer = new StringBuilder();
                if (producerItems.size() != 0) {
                    for (int i = 0; i < producerItems.size(); i++) {
                        sbProducer.append(producerItems.get(i).getName());
                        sbProducer.append(", ");
                    }

                } else {
                    sbProducer.append("Unknown..");
                }
                String producer = sbProducer.toString();
                producer = producer.substring(0, producer.length() - 2);

                MovieDetailEntity detailMovie = new MovieDetailEntity(data.getId(),
                        data.getPosterPath(),
                        data.getTitle(),
                        data.getReleaseDate(),
                        data.getVoteAverage(),
                        data.getOverview(),
                        null,
                        data.getRuntime(),
                        genre,
                        data.getBudget(),
                        data.getRevenue(),
                        producer);

                localDataSource.insertDetailMovie(detailMovie);
            }
        }.asLiveData();
    }

    @Override
    public LiveData<Resource<MovieCastEntity>> getCastMovieById(int mvId) {
        return new NetworkBoundResource<MovieCastEntity, MovieCastResponse>(appExecutors) {
            @Override
            protected Boolean shouldFetch(MovieCastEntity data) {
                return (data == null || data.getMvCast() == null);
            }

            @Override
            protected LiveData<MovieCastEntity> loadFromDB() {
                return localDataSource.getCastMovieById(mvId);
            }

            @Override
            protected LiveData<ApiResponse<MovieCastResponse>> createCall() {
                return remoteDataSource.getCastMovieById(mvId);
            }

            @Override
            protected void saveCallResult(MovieCastResponse data) {

                List<MovieCastItem> castItems = data.getCast();
                StringBuilder sbCast = new StringBuilder();
                if (castItems.size() != 0) {
                    for (int i = 0; i < castItems.size(); i++) {
                        sbCast.append(castItems.get(i).getName());
                        sbCast.append(", ");
                    }

                } else {
                    sbCast.append("Unknown..");
                }
                String cast = sbCast.toString();
                cast = cast.substring(0, cast.length() - 2);

                MovieCastEntity castMovie = new MovieCastEntity(
                        data.getId(), cast);

                localDataSource.insertCastMovie(castMovie);
            }

        }.asLiveData();
    }

    @Override
    public LiveData<PagedList<MovieDetailEntity>> getFavoriteMovies() {
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(5)
                .setPageSize(5)
                .build();
        return new LivePagedListBuilder<>(localDataSource.getFavoriteMovies(), config).build();
    }

    @Override
    public void setFavoriteMovie(MovieDetailEntity movieEntity, boolean state) {
        appExecutors.diskIO().execute(() -> localDataSource.setFavoriteMovie(movieEntity, state));
    }
}
