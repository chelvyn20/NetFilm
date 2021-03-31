package com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TvShowDetailResponse {

    @SerializedName("id")
    private int id;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("name")
    private String name;

    @SerializedName("first_air_date")
    private String firstAirDate;

    @SerializedName("vote_average")
    private double voteAverage;

    @SerializedName("overview")
    private String overview;

    @SerializedName("genres")
    private List<TvShowGenreItem> genres;

    @SerializedName("number_of_seasons")
    private int numberOfSeasons;

    @SerializedName("networks")
    private List<TvShowNetworkItem> networks;

    @SerializedName("production_companies")
    private List<TvShowProducerItem> productionCompanies;

    @SerializedName("created_by")
    private List<TvShowCreatorItem> createdBy;

    public TvShowDetailResponse(int id, String posterPath, String name, String firstAirDate, double voteAverage, String overview, List<TvShowGenreItem> genres, int numberOfSeasons, List<TvShowNetworkItem> networks, List<TvShowProducerItem> productionCompanies, List<TvShowCreatorItem> createdBy) {
        this.id = id;
        this.posterPath = posterPath;
        this.name = name;
        this.firstAirDate = firstAirDate;
        this.voteAverage = voteAverage;
        this.overview = overview;
        this.genres = genres;
        this.numberOfSeasons = numberOfSeasons;
        this.networks = networks;
        this.productionCompanies = productionCompanies;
        this.createdBy = createdBy;
    }

    public int getId() {
        return id;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getName() {
        return name;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public List<TvShowGenreItem> getGenres() {
        return genres;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public List<TvShowNetworkItem> getNetworks() {
        return networks;
    }

    public List<TvShowProducerItem> getProductionCompanies() {
        return productionCompanies;
    }

    public List<TvShowCreatorItem> getCreatedBy() {
        return createdBy;
    }
}