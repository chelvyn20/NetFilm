package com.dicoding.picodiploma.netfilm.ui.tvshow;

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

import com.dicoding.picodiploma.netfilm.databinding.FragmentTvShowBinding;
import com.dicoding.picodiploma.netfilm.vm.ViewModelFactory;

import org.jetbrains.annotations.NotNull;

public class TvShowFragment extends Fragment {
    private FragmentTvShowBinding fragmentTvShowBinding;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(inflater, container, false);
        return fragmentTvShowBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getActivity() != null) {
            ViewModelFactory factory = ViewModelFactory.getInstance(getActivity());
            TvShowViewModel viewModel = new ViewModelProvider(this, factory).get(TvShowViewModel.class);

            TvShowAdapter tvShowAdapter = new TvShowAdapter();
            viewModel.getSimpleTvShows().observe(getViewLifecycleOwner(), listTvShows -> {
                if (listTvShows != null) {
                    switch (listTvShows.status) {
                        case LOADING:
                            fragmentTvShowBinding.progressBar.setVisibility(View.VISIBLE);
                            break;
                        case SUCCESS:
                            fragmentTvShowBinding.progressBar.setVisibility(View.GONE);
                            tvShowAdapter.submitList(listTvShows.data);
                            tvShowAdapter.notifyDataSetChanged();
                            break;
                        case ERROR:
                            fragmentTvShowBinding.progressBar.setVisibility(View.GONE);
                            Toast.makeText(getContext(), "There is an error", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });

            fragmentTvShowBinding.rvTvshow.setLayoutManager(new LinearLayoutManager(getContext()));
            fragmentTvShowBinding.rvTvshow.setHasFixedSize(true);
            fragmentTvShowBinding.rvTvshow.setAdapter(tvShowAdapter);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        fragmentTvShowBinding = null;
    }
}