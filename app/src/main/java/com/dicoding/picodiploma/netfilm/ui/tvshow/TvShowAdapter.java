package com.dicoding.picodiploma.netfilm.ui.tvshow;

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
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowSimpleEntity;
import com.dicoding.picodiploma.netfilm.databinding.ItemsTvshowBinding;
import com.dicoding.picodiploma.netfilm.ui.detail.DetailTvShowActivity;

public class TvShowAdapter extends PagedListAdapter<TvShowSimpleEntity, TvShowAdapter.FilmViewHolder> {

    private static final DiffUtil.ItemCallback<TvShowSimpleEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<TvShowSimpleEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull TvShowSimpleEntity oldItem, @NonNull TvShowSimpleEntity newItem) {
                    return (oldItem.getTsId() == newItem.getTsId());
                }

                @SuppressLint("DiffUtilEquals")
                @Override
                public boolean areContentsTheSame(@NonNull TvShowSimpleEntity oldItem, @NonNull TvShowSimpleEntity newItem) {
                    return oldItem.equals(newItem);
                }
            };

    TvShowAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsTvshowBinding binding = ItemsTvshowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FilmViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        TvShowSimpleEntity tvShow = getItem(position);
        if (tvShow != null) {
            holder.bind(tvShow);
        }
    }

    public static class FilmViewHolder extends RecyclerView.ViewHolder {
        private final ItemsTvshowBinding binding;

        public FilmViewHolder(@NonNull ItemsTvshowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(TvShowSimpleEntity tvShow) {
            Glide.with(itemView.getContext())
                    .load("https://image.tmdb.org/t/p/w500" + tvShow.getTsPoster())
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                    .into(binding.imgItemTsPoster);

            binding.tvItemTsTitle.setText(tvShow.getTsTitle());
            binding.tvItemTsFirstDate.setText(tvShow.getTsFirstDate());
            binding.tvItemTsRating.setText(String.valueOf(tvShow.getTsRating()));
            binding.tvItemTsDescription.setText(tvShow.getTsDescription());

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(itemView.getContext(), DetailTvShowActivity.class);
                intent.putExtra(DetailTvShowActivity.EXTRA_TVSHOW, tvShow.getTsId());
                itemView.getContext().startActivity(intent);
            });
        }
    }
}
