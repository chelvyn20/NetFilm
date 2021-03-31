package com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow;

import com.google.gson.annotations.SerializedName;

public class TvShowResponse {

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

	public TvShowResponse(int id, String posterPath, String name, String firstAirDate, double voteAverage, String overview) {
		this.id = id;
		this.posterPath = posterPath;
		this.name = name;
		this.firstAirDate = firstAirDate;
		this.voteAverage = voteAverage;
		this.overview = overview;
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
}