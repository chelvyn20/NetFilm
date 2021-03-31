package com.dicoding.picodiploma.netfilm.data.source.remote.response.movie;

import com.google.gson.annotations.SerializedName;

public class MovieProducerItem {

	@SerializedName("name")
	private String name;

	public MovieProducerItem(String name) {
		this.name = name;
	}

	public String getName(){
		return name;
	}
}