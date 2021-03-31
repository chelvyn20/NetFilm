package com.dicoding.picodiploma.netfilm.data.source.remote.response.movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieCastResponse {
    @SerializedName("id")
    private int id;

    @SerializedName("cast")
    private List<MovieCastItem> cast;

    public MovieCastResponse(int id, List<MovieCastItem> cast) {
        this.id = id;
        this.cast = cast;
    }

    public int getId() {
        return id;
    }

    public List<MovieCastItem> getCast() {
        return cast;
    }
}