package com.dicoding.picodiploma.netfilm.data.source.remote.response.movie;

import com.google.gson.annotations.SerializedName;

public class MovieResponse {

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

	public MovieResponse(int id, String posterPath, String title, String releaseDate, double voteAverage, String overview) {
		this.id = id;
		this.posterPath = posterPath;
		this.title = title;
		this.releaseDate = releaseDate;
		this.voteAverage = voteAverage;
		this.overview = overview;
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
}