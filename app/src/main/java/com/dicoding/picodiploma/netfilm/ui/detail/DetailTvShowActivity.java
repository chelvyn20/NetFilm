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
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowDetailEntity;
import com.dicoding.picodiploma.netfilm.databinding.ActivityDetailTvShowBinding;
import com.dicoding.picodiploma.netfilm.databinding.ContentDetailTvShowBinding;
import com.dicoding.picodiploma.netfilm.ui.favorite.FavoriteActivity;
import com.dicoding.picodiploma.netfilm.vm.ViewModelFactory;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailTvShowActivity extends AppCompatActivity {
    public static final String EXTRA_TVSHOW = "extra_tvshow";
    private ActivityDetailTvShowBinding activityDetailTvShowBinding;
    private ContentDetailTvShowBinding contentDetailTvShowBinding;
    private FloatingActionButton fabTvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityDetailTvShowBinding = ActivityDetailTvShowBinding.inflate(getLayoutInflater());
        setContentView(activityDetailTvShowBinding.getRoot());
        setSupportActionBar(activityDetailTvShowBinding.toolbar);

        contentDetailTvShowBinding = activityDetailTvShowBinding.detailTvShow;
        fabTvShow = activityDetailTvShowBinding.fabTvShow;

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        DetailTvShowViewModel viewModel = new ViewModelProvider(this, factory).get(DetailTvShowViewModel.class);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            int tsId = extras.getInt(EXTRA_TVSHOW);

            viewModel.setTvShowId(tsId);
            viewModel.detailTvShow.observe(this, detailTvShowResource -> {
                if (detailTvShowResource != null) {
                    switch (detailTvShowResource.status) {
                        case LOADING:
                            activityDetailTvShowBinding.progressBar.setVisibility(View.VISIBLE);
                            activityDetailTvShowBinding.tsContent.setVisibility(View.GONE);
                            break;
                        case SUCCESS:
                            if (detailTvShowResource.data != null) {
                                activityDetailTvShowBinding.progressBar.setVisibility(View.GONE);
                                activityDetailTvShowBinding.tsContent.setVisibility(View.VISIBLE);

                                populateTvShow(detailTvShowResource.data);

                                boolean state = detailTvShowResource.data.isTsFavorite();
                                setFavoriteState(fabTvShow, state);
                            }
                            break;

                        case ERROR:
                            activityDetailTvShowBinding.progressBar.setVisibility(View.GONE);
                            Toast.makeText(this, "There is an error", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });

            viewModel.castTvShow.observe(this, castTvShowResource -> {
                if (castTvShowResource != null) {
                    switch (castTvShowResource.status) {
                        case LOADING:
                            activityDetailTvShowBinding.progressBar.setVisibility(View.VISIBLE);
                            activityDetailTvShowBinding.tsContent.setVisibility(View.GONE);
                            break;

                        case SUCCESS:
                            if (castTvShowResource.data != null) {
                                activityDetailTvShowBinding.progressBar.setVisibility(View.GONE);
                                activityDetailTvShowBinding.tsContent.setVisibility(View.VISIBLE);
                                contentDetailTvShowBinding.tvContentTsCast.setText(castTvShowResource.data.getTsCast());
                            }
                            break;

                        case ERROR:
                            activityDetailTvShowBinding.progressBar.setVisibility(View.GONE);
                            Toast.makeText(this, "There is an error", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });

            fabTvShow.setOnClickListener(view -> viewModel.setFavorite());
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
            Intent intent = new Intent(DetailTvShowActivity.this, FavoriteActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        contentDetailTvShowBinding = null;
        activityDetailTvShowBinding = null;
    }

    private void populateTvShow(TvShowDetailEntity detailTvShow) {
        contentDetailTvShowBinding.tvContentTsTitle.setText(detailTvShow.getTsTitle());
        contentDetailTvShowBinding.tvContentTsFirstDate.setText(detailTvShow.getTsFirstDate());
        contentDetailTvShowBinding.tvContentTsRating.setText(String.valueOf(detailTvShow.getTsRating()));

        String pluralSeason = getResources().getQuantityString(R.plurals.season, detailTvShow.getTsSeason(), detailTvShow.getTsSeason());
        contentDetailTvShowBinding.tvContentTsSeason.setText(pluralSeason);

        Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500" + detailTvShow.getTsPoster())
                .transform(new RoundedCorners(50))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(contentDetailTvShowBinding.imgContentTsPoster);

        contentDetailTvShowBinding.tvContentTsGenre.setText(detailTvShow.getTsGenre());
        contentDetailTvShowBinding.tvContentTsPublisher.setText(detailTvShow.getTsPublisher());
        contentDetailTvShowBinding.tvContentTsProducer.setText(detailTvShow.getTsProducer());
        contentDetailTvShowBinding.tvContentTsCreator.setText(detailTvShow.getTsCreator());
        contentDetailTvShowBinding.tvContentTsDesc.setText(detailTvShow.getTsDescription());
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setFavoriteState(FloatingActionButton fabTvShow, boolean state) {
        if (state) {
            fabTvShow.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite));
        } else {
            fabTvShow.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_border));
        }

        fabTvShow.setOnTouchListener((v, event) -> {
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