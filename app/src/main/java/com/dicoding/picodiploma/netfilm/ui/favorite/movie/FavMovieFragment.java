package com.dicoding.picodiploma.netfilm.ui.favorite.movie;

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
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieDetailEntity;
import com.dicoding.picodiploma.netfilm.databinding.FragmentFavMovieBinding;
import com.dicoding.picodiploma.netfilm.vm.ViewModelFactory;
import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;


public class FavMovieFragment extends Fragment {
    private FragmentFavMovieBinding fragmentFavMovieBinding;
    private FavMovieViewModel viewModel;
    private FavMovieAdapter adapter;

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
                MovieDetailEntity favMovie = adapter.getSwipeData(swipedPosition);
                viewModel.setFavMovie(favMovie);
                Snackbar snackbar = Snackbar.make(getView(), "Do you want to cancel deleting item?", Snackbar.LENGTH_LONG);
                snackbar.setAction(R.string.message_ok, v -> viewModel.setFavMovie(favMovie));
                snackbar.show();
            }
        }
    });

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentFavMovieBinding = FragmentFavMovieBinding.inflate(inflater, container, false);
        return fragmentFavMovieBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        itemTouchHelper.attachToRecyclerView(fragmentFavMovieBinding.rvFavMovie);

        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            viewModel = new ViewModelProvider(this, factory).get(FavMovieViewModel.class);
            adapter = new FavMovieAdapter();

            fragmentFavMovieBinding.progressBar.setVisibility(View.VISIBLE);

            viewModel.getFavMovies().observe(getViewLifecycleOwner(), listFavMovie -> {
                if (listFavMovie != null) {
                    fragmentFavMovieBinding.progressBar.setVisibility(View.GONE);
                    adapter.submitList(listFavMovie);
                    adapter.notifyDataSetChanged();
                }
            });

            fragmentFavMovieBinding.rvFavMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentFavMovieBinding.rvFavMovie.setHasFixedSize(true);
            fragmentFavMovieBinding.rvFavMovie.setAdapter(adapter);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        fragmentFavMovieBinding = null;
    }
}