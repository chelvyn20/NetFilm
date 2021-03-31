package com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TvShow{

	@SerializedName("page")
	private int page;

	@SerializedName("total_pages")
	private int totalPages;

	@SerializedName("results")
	private List<TvShowResponse> results;

	@SerializedName("total_results")
	private int totalResults;

	public int getPage(){
		return page;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public List<TvShowResponse> getResults(){
		return results;
	}

	public int getTotalResults(){
		return totalResults;
	}
}