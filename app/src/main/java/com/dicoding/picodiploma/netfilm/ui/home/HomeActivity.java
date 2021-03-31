package com.dicoding.picodiploma.netfilm.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.dicoding.picodiploma.netfilm.R;
import com.dicoding.picodiploma.netfilm.databinding.ActivityHomeBinding;
import com.dicoding.picodiploma.netfilm.ui.detail.DetailMovieActivity;
import com.dicoding.picodiploma.netfilm.ui.favorite.FavoriteActivity;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding activityHomeBinding;
    private SectionPagerHomeAdapter sectionPagerHomeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(activityHomeBinding.getRoot());

        sectionPagerHomeAdapter = new SectionPagerHomeAdapter(this, getSupportFragmentManager());
        activityHomeBinding.viewPagerHome.setAdapter(sectionPagerHomeAdapter);

        activityHomeBinding.tabHome.setupWithViewPager(activityHomeBinding.viewPagerHome);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
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
            Intent intent = new Intent(HomeActivity.this, FavoriteActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        activityHomeBinding = null;
        sectionPagerHomeAdapter = null;
    }
}