package com.dicoding.picodiploma.netfilm.data.source.remote;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.Movie;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.MovieCastResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.MovieDetailResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.MovieResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShow;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowCastResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowDetailResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowResponse;
import com.dicoding.picodiploma.netfilm.utils.ApiConfig;
import com.dicoding.picodiploma.netfilm.utils.EspressoIdlingResource;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDataSource {
    private static final String TAG = "RemoteDataSource";
    private static final String apiKey = "62c20507bd01d0795c9ee23ee915cfb0";
    private static RemoteDataSource INSTANCE;

    private final MutableLiveData<Boolean> _isLoading = new MutableLiveData<>();

    public static RemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new RemoteDataSource();
        }
        return INSTANCE;
    }

    public LiveData<ApiResponse<List<TvShowResponse>>> getAllSimpleTvShows() {
        _isLoading.setValue(true);
        EspressoIdlingResource.increment();

        MutableLiveData<ApiResponse<List<TvShowResponse>>> tsResult = new MutableLiveData<>();
        Call<TvShow> client = ApiConfig.getApiService().getTvShows(apiKey);
        client.enqueue(new Callback<TvShow>() {
            @Override
            public void onResponse(@NotNull Call<TvShow> call, @NotNull Response<TvShow> response) {
                _isLoading.setValue(false);

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        tsResult.setValue(ApiResponse.success(response.body().getResults()));
                        EspressoIdlingResource.decrement();
                    }

                } else {
                    Log.e(TAG, "onFailure: ${response.message()}");
                }
            }

            @Override
            public void onFailure(@NotNull Call<TvShow> call, @NotNull Throwable t) {
                _isLoading.setValue(false);
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return tsResult;
    }

    public LiveData<ApiResponse<TvShowDetailResponse>> getDetailTvShowById(int tsId) {
        _isLoading.setValue(true);
        EspressoIdlingResource.increment();

        MutableLiveData<ApiResponse<TvShowDetailResponse>> tsDetailResult = new MutableLiveData<>();
        Call<TvShowDetailResponse> client = ApiConfig.getApiService().getTvShowDetail(tsId, apiKey);
        client.enqueue(new Callback<TvShowDetailResponse>() {
            @Override
            public void onResponse(@NotNull Call<TvShowDetailResponse> call, @NotNull Response<TvShowDetailResponse> response) {
                _isLoading.setValue(false);

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        tsDetailResult.setValue(ApiResponse.success(response.body()));
                        EspressoIdlingResource.decrement();
                    }

                } else {
                    Log.e(TAG, "onFailure: ${response.message()}");
                }
            }

            @Override
            public void onFailure(@NotNull Call<TvShowDetailResponse> call, @NotNull Throwable t) {
                _isLoading.setValue(false);
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return tsDetailResult;
    }

    public LiveData<ApiResponse<TvShowCastResponse>> getCastTvShowById(int tsId) {
        _isLoading.setValue(true);
        EspressoIdlingResource.increment();

        MutableLiveData<ApiResponse<TvShowCastResponse>> tsCastResult = new MutableLiveData<>();
        Call<TvShowCastResponse> client = ApiConfig.getApiService().getTvShowCast(tsId, apiKey);
        client.enqueue(new Callback<TvShowCastResponse>() {
            @Override
            public void onResponse(@NotNull Call<TvShowCastResponse> call, @NotNull Response<TvShowCastResponse> response) {
                _isLoading.setValue(false);

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        tsCastResult.setValue(ApiResponse.success(response.body()));
                        EspressoIdlingResource.decrement();
                    }

                } else {
                    Log.e(TAG, "onFailure: ${response.message()}");
                }
            }

            @Override
            public void onFailure(@NotNull Call<TvShowCastResponse> call, @NotNull Throwable t) {
                _isLoading.setValue(false);
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return tsCastResult;
    }


    public LiveData<ApiResponse<List<MovieResponse>>> getAllSimpleMovies() {
        _isLoading.setValue(true);
        EspressoIdlingResource.increment();

        MutableLiveData<ApiResponse<List<MovieResponse>>> mResult = new MutableLiveData<>();
        Call<Movie> client = ApiConfig.getApiService().getMovies(apiKey);
        client.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(@NotNull Call<Movie> call, @NotNull Response<Movie> response) {
                _isLoading.setValue(false);

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        mResult.setValue(ApiResponse.success(response.body().getResults()));
                        EspressoIdlingResource.increment();
                    }

                } else {
                    Log.e(TAG, "onFailure: ${response.message()}");
                }
            }

            @Override
            public void onFailure(@NotNull Call<Movie> call, @NotNull Throwable t) {
                _isLoading.setValue(false);
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return mResult;
    }


    public LiveData<ApiResponse<MovieDetailResponse>> getDetailMovieById(int mId) {
        _isLoading.setValue(true);
        EspressoIdlingResource.increment();

        MutableLiveData<ApiResponse<MovieDetailResponse>> mDetailResult = new MutableLiveData<>();
        Call<MovieDetailResponse> client = ApiConfig.getApiService().getMovieDetail(mId, apiKey);
        client.enqueue(new Callback<MovieDetailResponse>() {
            @Override
            public void onResponse(@NotNull Call<MovieDetailResponse> call, @NotNull Response<MovieDetailResponse> response) {
                _isLoading.setValue(false);

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        mDetailResult.setValue(ApiResponse.success(response.body()));
                        EspressoIdlingResource.decrement();
                    }

                } else {
                    Log.e(TAG, "onFailure: ${response.message()}");
                }
            }

            @Override
            public void onFailure(@NotNull Call<MovieDetailResponse> call, @NotNull Throwable t) {
                _isLoading.setValue(false);
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return mDetailResult;
    }


    public LiveData<ApiResponse<MovieCastResponse>> getCastMovieById(int mId) {
        _isLoading.setValue(true);
        EspressoIdlingResource.increment();

        MutableLiveData<ApiResponse<MovieCastResponse>> mCastResult = new MutableLiveData<>();
        Call<MovieCastResponse> client = ApiConfig.getApiService().getMovieCast(mId, apiKey);
        client.enqueue(new Callback<MovieCastResponse>() {
            @Override
            public void onResponse(@NotNull Call<MovieCastResponse> call, @NotNull Response<MovieCastResponse> response) {
                _isLoading.setValue(false);

                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        mCastResult.setValue(ApiResponse.success(response.body()));
                        EspressoIdlingResource.decrement();
                    }

                } else {
                    Log.e(TAG, "onFailure: ${response.message()}");
                }
            }

            @Override
            public void onFailure(@NotNull Call<MovieCastResponse> call, @NotNull Throwable t) {
                _isLoading.setValue(false);
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });

        return mCastResult;
    }
}
