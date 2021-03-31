package com.dicoding.picodiploma.netfilm.ui.detail;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.netfilm.R;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieDetailEntity;
import com.dicoding.picodiploma.netfilm.databinding.ActivityDetailMovieBinding;
import com.dicoding.picodiploma.netfilm.databinding.ContentDetailMovieBinding;
import com.dicoding.picodiploma.netfilm.ui.favorite.FavoriteActivity;
import com.dicoding.picodiploma.netfilm.vm.ViewModelFactory;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    private ActivityDetailMovieBinding activityDetailMovieBinding;
    private ContentDetailMovieBinding contentDetailMovieBinding;
    private FloatingActionButton fabMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(getLayoutInflater());
        setContentView(activityDetailMovieBinding.getRoot());
        setSupportActionBar(activityDetailMovieBinding.toolbar);

        contentDetailMovieBinding = activityDetailMovieBinding.detailMovie;
        fabMovie = activityDetailMovieBinding.fabMovie;

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        DetailMovieViewModel viewModel = new ViewModelProvider(this, factory).get(DetailMovieViewModel.class);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            int mId = extras.getInt(EXTRA_MOVIE);

            viewModel.setMovieId(mId);
            viewModel.detailMovie.observe(this, detailMovieResource -> {
                if (detailMovieResource != null) {
                    switch (detailMovieResource.status) {
                        case LOADING:
                            activityDetailMovieBinding.progressBar.setVisibility(View.VISIBLE);
                            activityDetailMovieBinding.mContent.setVisibility(View.GONE);
                            break;
                        case SUCCESS:
                            if (detailMovieResource.data != null) {
                                activityDetailMovieBinding.progressBar.setVisibility(View.GONE);
                                activityDetailMovieBinding.mContent.setVisibility(View.VISIBLE);

                                populateMovie(detailMovieResource.data);

                                boolean state = detailMovieResource.data.isMvFavorite();
                                setFavoriteState(fabMovie, state);
                            }
                            break;

                        case ERROR:
                            activityDetailMovieBinding.progressBar.setVisibility(View.GONE);
                            Toast.makeText(this, "There is an error", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });

            viewModel.castMovie.observe(this, castMovieResource -> {
                if (castMovieResource != null) {
                    switch (castMovieResource.status) {
                        case LOADING:
                            activityDetailMovieBinding.progressBar.setVisibility(View.VISIBLE);
                            activityDetailMovieBinding.mContent.setVisibility(View.GONE);
                            break;

                        case SUCCESS:
                            if (castMovieResource.data != null) {
                                activityDetailMovieBinding.progressBar.setVisibility(View.GONE);
                                activityDetailMovieBinding.mContent.setVisibility(View.VISIBLE);
                                contentDetailMovieBinding.tvContentMCast.setText(castMovieResource.data.getMvCast());
                            }
                            break;

                        case ERROR:
                            activityDetailMovieBinding.progressBar.setVisibility(View.GONE);
                            Toast.makeText(this, "There is an error", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });

            fabMovie.setOnClickListener(view -> viewModel.setFavorite());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_favorite) {
            Intent intent = new Intent(DetailMovieActivity.this, FavoriteActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        contentDetailMovieBinding = null;
        activityDetailMovieBinding = null;
    }

    @SuppressLint("SetTextI18n")
    private void populateMovie(MovieDetailEntity detailMovie) {
        contentDetailMovieBinding.tvContentMTitle.setText(detailMovie.getMvTitle());
        contentDetailMovieBinding.tvContentMReleaseDate.setText(detailMovie.getMvReleaseDate());
        contentDetailMovieBinding.tvContentMRating.setText(String.valueOf(detailMovie.getMvRating()));
        contentDetailMovieBinding.tvContentMDuration.setText(detailMovie.getMvDuration() + "m");
        contentDetailMovieBinding.tvContentMDesc.setText(detailMovie.getMvDescription());

        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500" + detailMovie.getMvPoster())
                .transform(new RoundedCorners(50))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(contentDetailMovieBinding.imgContentMPoster);

        contentDetailMovieBinding.tvContentMGenre.setText(detailMovie.getMvGenre());
        contentDetailMovieBinding.tvContentMBudget.setText("$ " + detailMovie.getMvBudget());
        contentDetailMovieBinding.tvContentMRevenue.setText("$ " + detailMovie.getMvRevenue());
        contentDetailMovieBinding.tvContentMProducer.setText(detailMovie.getMvProducer());

    }

    @SuppressLint("ClickableViewAccessibility")
    private void setFavoriteState(FloatingActionButton fabMovie, boolean state) {
        if (state) {
            fabMovie.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite));
        } else {
            fabMovie.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_border));
        }

        fabMovie.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                if (!state) {
                    Toast.makeText(getApplicationContext(), "Click for adding to Favorite",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Click for removing from Favorite",
                            Toast.LENGTH_SHORT).show();
                }
            }
            return false;
        });
    }
}