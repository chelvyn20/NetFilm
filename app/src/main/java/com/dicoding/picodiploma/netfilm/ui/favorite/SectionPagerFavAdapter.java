package com.dicoding.picodiploma.netfilm.ui.favorite;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.dicoding.picodiploma.netfilm.R;
import com.dicoding.picodiploma.netfilm.ui.favorite.movie.FavMovieFragment;
import com.dicoding.picodiploma.netfilm.ui.favorite.tvshow.FavTvShowFragment;

public class SectionPagerFavAdapter extends FragmentPagerAdapter {
    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tvshow, R.string.movie};
    private final Context context;

    public SectionPagerFavAdapter(Context context, @NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FavTvShowFragment();
            case 1:
                return new FavMovieFragment();
            default:
                return new Fragment();
        }
    }

    @NonNull
    @Override
    public CharSequence getPageTitle(int position) {
        return context.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return TAB_TITLES.length;
    }
}
