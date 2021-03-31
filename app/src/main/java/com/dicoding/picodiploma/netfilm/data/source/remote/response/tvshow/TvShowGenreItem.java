package com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow;

import com.google.gson.annotations.SerializedName;

public class TvShowGenreItem {

	@SerializedName("name")
	private String name;

	public TvShowGenreItem(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}