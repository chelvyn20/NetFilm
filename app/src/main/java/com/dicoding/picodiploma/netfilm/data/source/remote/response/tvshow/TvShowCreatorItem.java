package com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow;

import com.google.gson.annotations.SerializedName;

public class TvShowCreatorItem {

	@SerializedName("name")
	private String name;

	public TvShowCreatorItem(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}