package com.dicoding.picodiploma.netfilm.ui.favorite;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.dicoding.picodiploma.netfilm.databinding.ActivityFavoriteBinding;

public class FavoriteActivity extends AppCompatActivity {
    private ActivityFavoriteBinding activityFavoriteBinding;
    private SectionPagerFavAdapter sectionPagerFavAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityFavoriteBinding = ActivityFavoriteBinding.inflate(getLayoutInflater());
        setContentView(activityFavoriteBinding.getRoot());

        sectionPagerFavAdapter = new SectionPagerFavAdapter(this, getSupportFragmentManager());
        activityFavoriteBinding.viewPagerFav.setAdapter(sectionPagerFavAdapter);

        activityFavoriteBinding.tabFav.setupWithViewPager(activityFavoriteBinding.viewPagerFav);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityFavoriteBinding = null;
        sectionPagerFavAdapter = null;
    }
}