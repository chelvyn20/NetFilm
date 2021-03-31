package com.dicoding.picodiploma.netfilm.ui.movie;

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
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieSimpleEntity;
import com.dicoding.picodiploma.netfilm.databinding.ItemsMovieBinding;
import com.dicoding.picodiploma.netfilm.ui.detail.DetailMovieActivity;

public class MovieAdapter extends PagedListAdapter<MovieSimpleEntity, MovieAdapter.FilmViewHolder> {

    private static final DiffUtil.ItemCallback<MovieSimpleEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<MovieSimpleEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull MovieSimpleEntity oldItem, @NonNull MovieSimpleEntity newItem) {
                    return (oldItem.getMvId() == newItem.getMvId());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull MovieSimpleEntity oldItem, @NonNull MovieSimpleEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };

    MovieAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsMovieBinding binding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FilmViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        MovieSimpleEntity movie = getItem(position);
        if (movie != null) {
            holder.bind(movie);
        }
    }

    public static class FilmViewHolder extends RecyclerView.ViewHolder {
        private final ItemsMovieBinding binding;

        public FilmViewHolder(@NonNull ItemsMovieBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(MovieSimpleEntity movie) {
            Glide.with(itemView.getContext())
                    .load("https://image.tmdb.org/t/p/w500" + movie.getMvPoster())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(binding.imgItemMvPoster);

            binding.tvItemMvTitle.setText(movie.getMvTitle());
            binding.tvItemMvReleaseDate.setText(movie.getMvReleaseDate());
            binding.tvItemMvRating.setText(String.valueOf(movie.getMvRating()));
            binding.tvItemMvDesc.setText(movie.getMvDescription());

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.getMvId());
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
