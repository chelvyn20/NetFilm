package com.dicoding.picodiploma.netfilm.ui.movie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.dicoding.picodiploma.netfilm.databinding.FragmentMovieBinding;
import com.dicoding.picodiploma.netfilm.vm.ViewModelFactory;

public class MovieFragment extends Fragment {
    private FragmentMovieBinding fragmentMovieBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentMovieBinding = FragmentMovieBinding.inflate(inflater, container, false);
        return fragmentMovieBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            MovieViewModel viewModel = new ViewModelProvider(this, factory).get(MovieViewModel.class);
            MovieAdapter movieAdapter = new MovieAdapter();


            viewModel.getSimpleMovies().observe(getViewLifecycleOwner(), listMovies -> {
                if (listMovies != null) {
                    switch (listMovies.status) {
                        case LOADING:
                            fragmentMovieBinding.progressBar.setVisibility(View.VISIBLE);
                            break;

                        case SUCCESS:
                            fragmentMovieBinding.progressBar.setVisibility(View.GONE);
                            movieAdapter.submitList(listMovies.data);
                            movieAdapter.notifyDataSetChanged();
                            break;

                        case ERROR:
                            fragmentMovieBinding.progressBar.setVisibility(View.GONE);
                            Toast.makeText(getContext(), "There is an error", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });

            fragmentMovieBinding.rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentMovieBinding.rvMovie.setHasFixedSize(true);
            fragmentMovieBinding.rvMovie.setAdapter(movieAdapter);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        fragmentMovieBinding = null;
    }
}