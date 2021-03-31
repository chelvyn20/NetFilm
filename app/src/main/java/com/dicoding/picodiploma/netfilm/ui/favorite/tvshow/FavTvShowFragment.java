package com.dicoding.picodiploma.netfilm.ui.favorite.tvshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dicoding.picodiploma.netfilm.R;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowDetailEntity;
import com.dicoding.picodiploma.netfilm.databinding.FragmentFavTvShowBinding;
import com.dicoding.picodiploma.netfilm.vm.ViewModelFactory;
import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;


public class FavTvShowFragment extends Fragment {
    private FragmentFavTvShowBinding fragmentFavTvShowBinding;
    private FavTvShowViewModel viewModel;
    private FavTvShowAdapter adapter;

    private final ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
        @Override
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            return makeMovementFlags(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return true;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            if (getView() != null) {
                int swipedPosition = viewHolder.getAdapterPosition();
                TvShowDetailEntity favTvShow = adapter.getSwipeData(swipedPosition);
                viewModel.setFavTvShow(favTvShow);
                Snackbar snackbar = Snackbar.make(getView(), "Do you want to cancel deleting item?", Snackbar.LENGTH_LONG);
                snackbar.setAction(R.string.message_ok, v -> viewModel.setFavTvShow(favTvShow));
                snackbar.show();
            }
        }
    });

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentFavTvShowBinding = FragmentFavTvShowBinding.inflate(inflater, container, false);
        return fragmentFavTvShowBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        itemTouchHelper.attachToRecyclerView(fragmentFavTvShowBinding.rvFavTvShow);

        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            viewModel = new ViewModelProvider(this, factory).get(FavTvShowViewModel.class);
            adapter = new FavTvShowAdapter();

            fragmentFavTvShowBinding.progressBar.setVisibility(View.VISIBLE);

            viewModel.getFavTvShows().observe(getViewLifecycleOwner(), listFavTvShow -> {
                if (listFavTvShow != null) {
                    fragmentFavTvShowBinding.progressBar.setVisibility(View.GONE);
                    adapter.submitList(listFavTvShow);
                    adapter.notifyDataSetChanged();
                }
            });

            fragmentFavTvShowBinding.rvFavTvShow.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentFavTvShowBinding.rvFavTvShow.setHasFixedSize(true);
            fragmentFavTvShowBinding.rvFavTvShow.setAdapter(adapter);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        fragmentFavTvShowBinding = null;
    }
}