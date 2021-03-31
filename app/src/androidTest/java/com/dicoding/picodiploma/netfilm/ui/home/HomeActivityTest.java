package com.dicoding.picodiploma.netfilm.ui.home;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.action.ViewActions;

import com.dicoding.picodiploma.netfilm.R;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieCastEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieDetailEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieSimpleEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowCastEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowDetailEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowSimpleEntity;
import com.dicoding.picodiploma.netfilm.utils.DataDummy;
import com.dicoding.picodiploma.netfilm.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class HomeActivityTest {
    private final List<TvShowSimpleEntity> dummySimpleTvShows = DataDummy.createDummySimpleTvShows();
    private final List<TvShowDetailEntity> dummyDetailTvShows = DataDummy.createDummyDetailTvShows();
    private final TvShowCastEntity dummyCastTvShow = DataDummy.createDummyCastTvShow();

    private final List<MovieSimpleEntity> dummySimpleMovies = DataDummy.createDummySimpleMovies();
    private final List<MovieDetailEntity> dummyDetailMovies = DataDummy.createDummyDetailMovies();
    private final MovieCastEntity dummyCastMovies = DataDummy.createDummyCastMovie();

    /*

    SKENARIO INSTRUMENTAL TESTING:

1.  Menampilkan data Tv Show
    > Memastikan rv_tvshow dalam keadaan tampil.
    > Gulir rv_tvshow ke posisi data terakhir.

2.  Menampilkan data detail Tv Show
    > Memberi tindakan klik pada data pertama di rv_tvshow.
    > Memastikan TextView untuk "title", "firstDate", "rating", "season", "poster", "genre", "publisher", "producer", "creator", cast dan "description" tampil sesuai dengan yang diharapkan.

3.  Menampilkan data Movie
    > Memastikan rv_movie dalam keadaan tampil.
    > Gulir rv_movie ke posisi data terakhir.

4.  Menampilkan data detail Movie
    > Memberi tindakan klik pada data pertama di rv_movie.
    > Memastikan TextView untuk "title", "releaseDate", "rating", "duration", "poster", "genre", "producer", "budget", "revenue", cast dan "description" tampil sesuai dengan yang diharapkan.
    > Memberi tindakan pressBack

5.  Menampilkan data Favorite Tv Shows
    > Memberi tindakan klik pada data pertama di rv_tvshow.
    > Memberi tindakan klik pada tombol fab_tv_show. (utk menambahkan ke favorite)
    > Memberi tindakan klik pada menu menu_favorite. (utk membuka FavTvShowFragment di FavoriteActivity)
    > Memastikan rv_fav_tv_show dalam keadaan tampil.
    > Memberi tindakan klik pada data pertama di rv_fav_tv_show. (utk membuka DetailTvShowActivity)
    > Memastikan TextView untuk "title", "firstDate", "rating", "season", "poster", "genre", "publisher", "producer", "creator", cast dan "description" tampil sesuai dengan yang diharapkan.
    > Memberi tindakan klik pada tombol fab_tv_show. (utk menghilangkan dari favorite)
    > Memberi tindakan pressBack

6.  Menampilkan data Favorite Movies
    > Memberi tindakan klik pada data pertama di rv_movie.
    > Memberi tindakan klik pada tombol fab_movie. (utk menambahkan ke favorite)
    > Memberi tindakan klik pada menu menu_favorite. (utk membuka FavMovieFragment di FavoriteActivity)
    > Memastikan rv_fav_movie dalam keadaan tampil.
    > Memberi tindakan klik pada data pertama di rv_fav_movie. (utk membuka DetailMovieActivity)
    > Memastikan TextView untuk "title", "releaseDate", "rating", "duration", "poster", "genre", "budget", "revenue", "producer", cast dan "description" tampil sesuai dengan yang diharapkan.
    > Memberi tindakan klik pada tombol fab_movie. (utk menghilangkan dari favorite)
    > Memberi tindakan pressBack

     */


    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
        ActivityScenario.launch(HomeActivity.class);
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadTvShows() {
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tvshow)).perform(scrollToPosition(dummySimpleTvShows.size()));
    }

    @Test
    public void loadDetailTvShow() {
        onView(withId(R.id.rv_tvshow)).perform(actionOnItemAtPosition(0, click()));

        onView(withId(R.id.img_content_ts_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_title)).check(matches(withText(dummyDetailTvShows.get(0).getTsTitle())));
        onView(withId(R.id.tv_content_ts_firstDate)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_firstDate)).check(matches(withText(dummyDetailTvShows.get(0).getTsFirstDate())));
        onView(withId(R.id.tv_content_ts_rating)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_rating)).check(matches(withText(String.valueOf(dummyDetailTvShows.get(0).getTsRating()))));

        onView(withId(R.id.tv_content_ts_season)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_season)).check(matches(withText(String.format("%d Seasons", dummyDetailTvShows.get(0).getTsSeason()))));
        onView(withId(R.id.tv_content_ts_genre)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_genre)).check(matches(withText(dummyDetailTvShows.get(0).getTsGenre())));
        onView(withId(R.id.tv_content_ts_publisher)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_publisher)).check(matches(withText(dummyDetailTvShows.get(0).getTsPublisher())));
        onView(withId(R.id.tv_content_ts_producer)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_producer)).check(matches(withText(dummyDetailTvShows.get(0).getTsProducer())));
        onView(withId(R.id.tv_content_ts_creator)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_creator)).check(matches(withText(dummyDetailTvShows.get(0).getTsCreator())));

        onView(withId(R.id.tsContent)).perform(swipeUp());

        onView(withId(R.id.tv_content_ts_cast)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_cast)).check(matches(withText(dummyCastTvShow.getTsCast())));

        onView(withId(R.id.tv_content_ts_desc)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_desc)).check(matches(withText(dummyDetailTvShows.get(0).getTsDescription())));
    }

    @Test
    public void loadMovies() {
        onView(withText("MOVIES")).perform(click());
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie)).perform(scrollToPosition(dummySimpleMovies.size()));
    }

    @Test
    public void loadDetailMovie() {
        onView(withText("MOVIES")).perform(click());
        onView(withId(R.id.rv_movie)).perform(actionOnItemAtPosition(0, click()));

        onView(withId(R.id.img_content_m_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_title)).check(matches(withText(dummyDetailMovies.get(0).getMvTitle())));
        onView(withId(R.id.tv_content_m_releaseDate)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_releaseDate)).check(matches(withText(dummyDetailMovies.get(0).getMvReleaseDate())));
        onView(withId(R.id.tv_content_m_rating)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_rating)).check(matches(withText(String.valueOf(dummyDetailMovies.get(0).getMvRating()))));

        onView(withId(R.id.tv_content_m_duration)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_duration)).check(matches(withText(dummyDetailMovies.get(0).getMvDuration() + "m")));
        onView(withId(R.id.tv_content_m_genre)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_genre)).check(matches(withText(dummyDetailMovies.get(0).getMvGenre())));
        onView(withId(R.id.tv_content_m_producer)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_producer)).check(matches(withText(dummyDetailMovies.get(0).getMvProducer())));
        onView(withId(R.id.tv_content_m_budget)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_budget)).check(matches(withText("$ " + dummyDetailMovies.get(0).getMvBudget())));
        onView(withId(R.id.tv_content_m_revenue)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_revenue)).check(matches(withText("$ " + dummyDetailMovies.get(0).getMvRevenue())));

        onView(withId(R.id.mContent)).perform(swipeUp());

        onView(withId(R.id.tv_content_m_cast)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_cast)).check(matches(withText(dummyCastMovies.getMvCast())));

        onView(withId(R.id.tv_content_m_desc)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_desc)).check(matches(withText(dummyDetailMovies.get(0).getMvDescription())));

        onView(isRoot()).perform(ViewActions.pressBack());
    }

    @Test
    public void loadFavoriteTvShows() {
        onView(withId(R.id.rv_tvshow)).perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.fab_tv_show)).perform(click());
        onView(withId(R.id.menu_favorite)).perform(click());

        onView(withId(R.id.rv_fav_tv_show)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fav_tv_show)).perform(actionOnItemAtPosition(0, click()));

        onView(withId(R.id.img_content_ts_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_title)).check(matches(withText(dummyDetailTvShows.get(0).getTsTitle())));
        onView(withId(R.id.tv_content_ts_firstDate)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_firstDate)).check(matches(withText(dummyDetailTvShows.get(0).getTsFirstDate())));
        onView(withId(R.id.tv_content_ts_rating)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_rating)).check(matches(withText(String.valueOf(dummyDetailTvShows.get(0).getTsRating()))));

        onView(withId(R.id.tv_content_ts_season)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_season)).check(matches(withText(String.format("%d Seasons", dummyDetailTvShows.get(0).getTsSeason()))));
        onView(withId(R.id.tv_content_ts_genre)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_genre)).check(matches(withText(dummyDetailTvShows.get(0).getTsGenre())));
        onView(withId(R.id.tv_content_ts_publisher)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_publisher)).check(matches(withText(dummyDetailTvShows.get(0).getTsPublisher())));
        onView(withId(R.id.tv_content_ts_producer)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_producer)).check(matches(withText(dummyDetailTvShows.get(0).getTsProducer())));
        onView(withId(R.id.tv_content_ts_creator)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_creator)).check(matches(withText(dummyDetailTvShows.get(0).getTsCreator())));

        onView(withId(R.id.tsContent)).perform(swipeUp());

        onView(withId(R.id.tv_content_ts_cast)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_cast)).check(matches(withText(dummyCastTvShow.getTsCast())));

        onView(withId(R.id.tv_content_ts_desc)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_ts_desc)).check(matches(withText(dummyDetailTvShows.get(0).getTsDescription())));

        onView(withId(R.id.fab_tv_show)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
    }

    @Test
    public void loadFavoriteMovies() {
        onView(withText("MOVIES")).perform(click());
        onView(withId(R.id.rv_movie)).perform(actionOnItemAtPosition(0, click()));
        onView(withId(R.id.fab_movie)).perform(click());
        onView(withId(R.id.menu_favorite)).perform(click());

        onView(withText("MOVIES")).perform(click());
        onView(withId(R.id.rv_fav_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fav_movie)).perform(actionOnItemAtPosition(0, click()));

        onView(withId(R.id.img_content_m_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_title)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_title)).check(matches(withText(dummyDetailMovies.get(0).getMvTitle())));
        onView(withId(R.id.tv_content_m_releaseDate)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_releaseDate)).check(matches(withText(dummyDetailMovies.get(0).getMvReleaseDate())));
        onView(withId(R.id.tv_content_m_rating)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_rating)).check(matches(withText(String.valueOf(dummyDetailMovies.get(0).getMvRating()))));

        onView(withId(R.id.tv_content_m_duration)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_duration)).check(matches(withText(dummyDetailMovies.get(0).getMvDuration() + "m")));
        onView(withId(R.id.tv_content_m_genre)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_genre)).check(matches(withText(dummyDetailMovies.get(0).getMvGenre())));
        onView(withId(R.id.tv_content_m_producer)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_producer)).check(matches(withText(dummyDetailMovies.get(0).getMvProducer())));
        onView(withId(R.id.tv_content_m_budget)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_budget)).check(matches(withText("$ " + dummyDetailMovies.get(0).getMvBudget())));
        onView(withId(R.id.tv_content_m_revenue)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_revenue)).check(matches(withText("$ " + dummyDetailMovies.get(0).getMvRevenue())));

        onView(withId(R.id.mContent)).perform(swipeUp());

        onView(withId(R.id.tv_content_m_cast)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_cast)).check(matches(withText(dummyCastMovies.getMvCast())));

        onView(withId(R.id.tv_content_m_desc)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_content_m_desc)).check(matches(withText(dummyDetailMovies.get(0).getMvDescription())));

        onView(withId(R.id.fab_movie)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
    }

}