package com.dicoding.picodiploma.netfilm.ui.favorite.tvshow;

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
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowDetailEntity;
import com.dicoding.picodiploma.netfilm.databinding.ItemsFavTvShowBinding;
import com.dicoding.picodiploma.netfilm.ui.detail.DetailTvShowActivity;

public class FavTvShowAdapter extends PagedListAdapter<TvShowDetailEntity, FavTvShowAdapter.FilmViewHolder> {

    private static final DiffUtil.ItemCallback<TvShowDetailEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<TvShowDetailEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull TvShowDetailEntity oldItem, @NonNull TvShowDetailEntity newItem) {
                    return (oldItem.getTsId() == newItem.getTsId());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull TvShowDetailEntity oldItem, @NonNull TvShowDetailEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };

    FavTvShowAdapter() {
        super(DIFF_CALLBACK);
    }

    public TvShowDetailEntity getSwipeData(int swipedPosition) {
        return getItem(swipedPosition);
    }

    @NonNull
    @Override
    public FavTvShowAdapter.FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsFavTvShowBinding binding = ItemsFavTvShowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FilmViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavTvShowAdapter.FilmViewHolder holder, int position) {
        TvShowDetailEntity tvShow = getItem(position);
        if (tvShow != null) {
            holder.bind(tvShow);
        }
    }

    public static class FilmViewHolder extends RecyclerView.ViewHolder {
        private final ItemsFavTvShowBinding binding;

        public FilmViewHolder(@NonNull ItemsFavTvShowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(TvShowDetailEntity tvShow) {
            Glide.with(itemView.getContext())
                    .load("https://image.tmdb.org/t/p/w500" + tvShow.getTsPoster())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(binding.imgItemFavTsPoster);

            binding.tvItemFavTsTitle.setText(tvShow.getTsTitle());
            binding.tvItemFavTsFirstDate.setText(tvShow.getTsFirstDate());
            binding.tvItemFavTsRating.setText(String.valueOf(tvShow.getTsRating()));
            binding.tvItemFavTsDesc.setText(tvShow.getTsDescription());

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailTvShowActivity.class);
                intent.putExtra(DetailTvShowActivity.EXTRA_TVSHOW, tvShow.getTsId());
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
