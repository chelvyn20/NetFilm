package com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow;

import com.google.gson.annotations.SerializedName;

public class TvShowNetworkItem {

	@SerializedName("name")
	private String name;

	public TvShowNetworkItem(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}