package com.dicoding.picodiploma.netfilm.ui.favorite.movie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.netfilm.R;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieDetailEntity;
import com.dicoding.picodiploma.netfilm.databinding.ItemsFavMovieBinding;
import com.dicoding.picodiploma.netfilm.ui.detail.DetailMovieActivity;

public class FavMovieAdapter extends PagedListAdapter<MovieDetailEntity, FavMovieAdapter.FilmViewHolder> {

    private static final DiffUtil.ItemCallback<MovieDetailEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MovieDetailEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull MovieDetailEntity oldItem, @NonNull MovieDetailEntity newItem) {
                    return (oldItem.getMvId() == newItem.getMvId());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull MovieDetailEntity oldItem, @NonNull MovieDetailEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };

    FavMovieAdapter() {
        super(DIFF_CALLBACK);
    }

    public MovieDetailEntity getSwipeData(int swipedPosition) {
        return getItem(swipedPosition);
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsFavMovieBinding binding = ItemsFavMovieBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FilmViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        MovieDetailEntity movie = getItem(position);
        if (movie != null) {
            holder.bind(movie);
        }
    }

    public static class FilmViewHolder extends RecyclerView.ViewHolder {
        private final ItemsFavMovieBinding binding;

        public FilmViewHolder(@NonNull ItemsFavMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(MovieDetailEntity movie) {
            Glide.with(itemView.getContext())
                    .load("https://image.tmdb.org/t/p/w500" + movie.getMvPoster())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(binding.imgItemFavMvPoster);

            binding.tvItemFavMvTitle.setText(movie.getMvTitle());
            binding.tvItemFavMvReleaseDate.setText(movie.getMvReleaseDate());
            binding.tvItemFavMvRating.setText(String.valueOf(movie.getMvRating()));
            binding.tvItemFavMvDesc.setText(movie.getMvDescription());

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.getMvId());
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
