package com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TvShowCastResponse {
    @SerializedName("id")
    private int id;

    @SerializedName("cast")
    private List<TvShowCastItem> cast;

    public TvShowCastResponse(int id, List<TvShowCastItem> cast) {
        this.id = id;
        this.cast = cast;
    }

    public int getId() {
        return id;
    }

    public List<TvShowCastItem> getCast() {
        return cast;
    }
}