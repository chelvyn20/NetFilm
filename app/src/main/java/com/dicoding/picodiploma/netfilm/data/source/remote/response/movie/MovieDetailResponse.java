package com.dicoding.picodiploma.netfilm.data.source.remote.response.movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieDetailResponse {

    @SerializedName("id")
    private int id;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("title")
    private String title;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("vote_average")
    private double voteAverage;

    @SerializedName("overview")
    private String overview;

    @SerializedName("runtime")
    private int runtime;

    @SerializedName("genres")
    private List<MovieGenreItem> genres;

    @SerializedName("budget")
    private int budget;

    @SerializedName("revenue")
    private int revenue;

    @SerializedName("production_companies")
    private List<MovieProducerItem> productionCompanies;

    public MovieDetailResponse(int id, String posterPath, String title, String releaseDate, double voteAverage, String overview, int runtime, List<MovieGenreItem> genres, int budget, int revenue, List<MovieProducerItem> productionCompanies) {
        this.id = id;
        this.posterPath = posterPath;
        this.title = title;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
        this.overview = overview;
        this.runtime = runtime;
        this.genres = genres;
        this.budget = budget;
        this.revenue = revenue;
        this.productionCompanies = productionCompanies;
    }

    public int getId() {
        return id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public int getRuntime() {
        return runtime;
    }

    public List<MovieGenreItem> getGenres() {
        return genres;
    }

    public int getBudget() {
        return budget;
    }

    public int getRevenue() {
        return revenue;
    }

    public List<MovieProducerItem> getProductionCompanies() {
        return productionCompanies;
    }
}