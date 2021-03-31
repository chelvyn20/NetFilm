package com.dicoding.picodiploma.netfilm.data;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;

import com.dicoding.picodiploma.netfilm.data.source.local.LocalDataSource;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieCastEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieDetailEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.movie.MovieSimpleEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowCastEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowDetailEntity;
import com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow.TvShowSimpleEntity;
import com.dicoding.picodiploma.netfilm.data.source.remote.RemoteDataSource;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.MovieCastResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.MovieDetailResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.movie.MovieResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowCastResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowDetailResponse;
import com.dicoding.picodiploma.netfilm.data.source.remote.response.tvshow.TvShowResponse;
import com.dicoding.picodiploma.netfilm.utils.AppExecutors;
import com.dicoding.picodiploma.netfilm.utils.DataDummy;
import com.dicoding.picodiploma.netfilm.utils.FakeFilmRepository;
import com.dicoding.picodiploma.netfilm.utils.LiveDataTestUtil;
import com.dicoding.picodiploma.netfilm.utils.PagedListUtil;
import com.dicoding.picodiploma.netfilm.utils.TestExecutor;
import com.dicoding.picodiploma.netfilm.vo.Resource;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FilmRepositoryTest {

    private final RemoteDataSource remote = mock(RemoteDataSource.class);
    private final LocalDataSource local = mock(LocalDataSource.class);
    private final AppExecutors appExecutors = mock(AppExecutors.class);
    private final AppExecutors testExecutors = new AppExecutors(new TestExecutor(), new TestExecutor(), new TestExecutor());
    private final FakeFilmRepository filmRepository = new FakeFilmRepository(remote, local, appExecutors);

    private final ArrayList<TvShowResponse> tvShowResponses = DataDummy.createTvShowResponses();
    private final int tsId = tvShowResponses.get(0).getId();
    private final TvShowDetailResponse tvShowDetailResponse = DataDummy.createTvShowDetailResponse();
    private final TvShowCastResponse tvShowCastResponse = DataDummy.createTvShowCastResponse();

    private final ArrayList<MovieResponse> movieResponses = DataDummy.createMovieResponses();
    private final int mvId = movieResponses.get(0).getId();
    private final MovieDetailResponse movieDetailResponse = DataDummy.createMovieDetailResponse();
    private final MovieCastResponse movieCastResponse = DataDummy.createMovieCastResponse();

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Test
    public void getAllSimpleTvShows() {
        DataSource.Factory<Integer, TvShowSimpleEntity> dummySimpleTvShows = mock(DataSource.Factory.class);
        when(local.getAllSimpleTvShows()).thenReturn(dummySimpleTvShows);
        filmRepository.getAllSimpleTvShows();

        Resource<PagedList<TvShowSimpleEntity>> tvShowSimpleResource = Resource.success(PagedListUtil.mockPagedList(DataDummy.createDummySimpleTvShows()));
        verify(local).getAllSimpleTvShows();
        assertNotNull(tvShowSimpleResource.data);
        assertEquals(tvShowResponses.size(), tvShowSimpleResource.data.size());
    }


    @Test
    public void getDetailTvShowById() {
        MutableLiveData<TvShowDetailEntity> dummyDetailTvShow = new MutableLiveData<>();
        List<TvShowDetailEntity> tvShowDetailList = DataDummy.createDummyDetailTvShows();
        TvShowDetailEntity tvShowDetailEntity = tvShowDetailList.stream().filter(
                tvShowDetail -> tvShowDetail.getTsId() == tsId).collect(Collectors.toList()).get(0);
        dummyDetailTvShow.setValue(tvShowDetailEntity);
        when(local.getDetailTvShowById(tsId)).thenReturn(dummyDetailTvShow);

        Resource<TvShowDetailEntity> tvShowDetailResource = LiveDataTestUtil.getValue(filmRepository.getDetailTvShowById(tsId));
        verify(local).getDetailTvShowById(tsId);
        assertNotNull(tvShowDetailResource);
        assertNotNull(tvShowDetailResource.data);
        assertNotNull(tvShowDetailResource.data.getTsTitle());

        assertEquals(tvShowDetailResponse.getId(), tvShowDetailResource.data.getTsId());
        assertEquals(tvShowDetailResponse.getPosterPath(), tvShowDetailResource.data.getTsPoster());
        assertEquals(tvShowDetailResponse.getName(), tvShowDetailResource.data.getTsTitle());
        assertEquals(tvShowDetailResponse.getFirstAirDate(), tvShowDetailResource.data.getTsFirstDate());
        assertEquals(tvShowDetailResponse.getVoteAverage(), tvShowDetailResource.data.getTsRating(), 0.01);
        assertEquals(tvShowDetailResponse.getOverview(), tvShowDetailResource.data.getTsDescription());
        assertEquals(tvShowDetailResponse.getNumberOfSeasons(), tvShowDetailResource.data.getTsSeason());

        StringBuilder sbGenre = new StringBuilder();
        if (tvShowDetailResponse.getGenres().size() != 0) {
            for (int i = 0; i < tvShowDetailResponse.getGenres().size(); i++) {
                sbGenre.append(tvShowDetailResponse.getGenres().get(i).getName());
                sbGenre.append(", ");
            }

        } else {
            sbGenre.append("Unknown..");
        }
        String genre = sbGenre.toString();
        genre = genre.substring(0, genre.length() - 2);

        StringBuilder sbPublisher = new StringBuilder();
        if (tvShowDetailResponse.getNetworks().size() != 0) {
            for (int i = 0; i < tvShowDetailResponse.getNetworks().size(); i++) {
                sbPublisher.append(tvShowDetailResponse.getNetworks().get(i).getName());
                sbPublisher.append(", ");
            }

        } else {
            sbPublisher.append("Unknown..");
        }
        String publisher = sbPublisher.toString();
        publisher = publisher.substring(0, publisher.length() - 2);

        StringBuilder sbProducer = new StringBuilder();
        if (tvShowDetailResponse.getProductionCompanies().size() != 0) {
            for (int i = 0; i < tvShowDetailResponse.getProductionCompanies().size(); i++) {
                sbProducer.append(tvShowDetailResponse.getProductionCompanies().get(i).getName());
                sbProducer.append(", ");
            }

        } else {
            sbProducer.append("Unknown..");
        }
        String producer = sbProducer.toString();
        producer = producer.substring(0, producer.length() - 2);

        StringBuilder sbCreator = new StringBuilder();
        if (tvShowDetailResponse.getCreatedBy().size() != 0) {
            for (int i = 0; i < tvShowDetailResponse.getCreatedBy().size(); i++) {
                sbCreator.append(tvShowDetailResponse.getCreatedBy().get(i).getName());
                sbCreator.append(", ");
            }

        } else {
            sbCreator.append("Unknown..");
        }
        String creator = sbCreator.toString();
        creator = creator.substring(0, creator.length() - 2);


        assertEquals(genre, tvShowDetailResource.data.getTsGenre());
        assertEquals(publisher, tvShowDetailResource.data.getTsPublisher());
        assertEquals(producer, tvShowDetailResource.data.getTsProducer());
        assertEquals(creator, tvShowDetailResource.data.getTsCreator());
    }


    @Test
    public void getCastTvShowById() {
        MutableLiveData<TvShowCastEntity> dummyCastTvShow = new MutableLiveData<>();
        TvShowCastEntity tvShowCastEntity = DataDummy.createDummyCastTvShow();
        dummyCastTvShow.setValue(tvShowCastEntity);
        when(local.getCastTvShowById(tsId)).thenReturn(dummyCastTvShow);

        Resource<TvShowCastEntity> tvShowCastResource = LiveDataTestUtil.getValue(filmRepository.getCastTvShowById(tsId));
        verify(local).getCastTvShowById(tsId);
        assertNotNull(tvShowCastResource);
        assertNotNull(tvShowCastResource.data);
        assertNotNull(tvShowCastResource.data.getTsCast());

        StringBuilder sbCast = new StringBuilder();
        if (tvShowCastResponse.getCast().size() != 0) {
            for (int i = 0; i < tvShowCastResponse.getCast().size(); i++) {
                sbCast.append(tvShowCastResponse.getCast().get(i).getName());
                sbCast.append(", ");
            }

        } else {
            sbCast.append("Unknown..");
        }
        String cast = sbCast.toString();
        cast = cast.substring(0, cast.length() - 2);

        assertEquals(tvShowCastResponse.getId(), tvShowCastResource.data.getTsId());
        assertEquals(cast, tvShowCastResource.data.getTsCast());
    }


    @Test
    public void getFavoriteTvShows() {
        DataSource.Factory<Integer, TvShowDetailEntity> dummyFavoriteTvShows = mock(DataSource.Factory.class);
        when(local.getFavoriteTvShows()).thenReturn(dummyFavoriteTvShows);
        filmRepository.getFavoriteTvShows();

        Resource<PagedList<TvShowDetailEntity>> tvShowFavoriteResource = Resource.success(PagedListUtil.mockPagedList(DataDummy.createDummyDetailTvShows()));
        verify(local).getFavoriteTvShows();
        assertNotNull(tvShowFavoriteResource.data);
        assertEquals(tvShowResponses.size(), tvShowFavoriteResource.data.size());
    }

    @Test
    public void setFavoriteTvShow() {
        TvShowDetailEntity dummyDetailTvShow = DataDummy.createDummyDetailTvShows().get(0);
        boolean newState = !dummyDetailTvShow.isTsFavorite();

        when(appExecutors.diskIO()).thenReturn(testExecutors.diskIO());
        doNothing().when(local).setFavoriteTvShow(dummyDetailTvShow, newState);

        filmRepository.setFavoriteTvShow(dummyDetailTvShow, newState);
        verify(local, times(1)).setFavoriteTvShow(dummyDetailTvShow, newState);
    }


    @Test
    public void getAllSimpleMovies() {
        DataSource.Factory<Integer, MovieSimpleEntity> dummySimpleMovies = mock(DataSource.Factory.class);
        when(local.getAllSimpleMovies()).thenReturn(dummySimpleMovies);
        filmRepository.getAllSimpleMovies();

        Resource<PagedList<MovieSimpleEntity>> movieSimpleResource = Resource.success(PagedListUtil.mockPagedList(DataDummy.createDummySimpleMovies()));
        verify(local).getAllSimpleMovies();
        assertNotNull(movieSimpleResource.data);
        assertEquals(movieResponses.size(), movieSimpleResource.data.size());
    }


    @Test
    public void getDetailMovieById() {
        MutableLiveData<MovieDetailEntity> dummyDetailMovie = new MutableLiveData<>();
        List<MovieDetailEntity> movieDetailList = DataDummy.createDummyDetailMovies();
        MovieDetailEntity movieDetailEntity = movieDetailList.stream().filter(
                movieDetail -> movieDetail.getMvId() == mvId).collect(Collectors.toList()).get(0);
        dummyDetailMovie.setValue(movieDetailEntity);
        when(local.getDetailMovieById(mvId)).thenReturn(dummyDetailMovie);

        Resource<MovieDetailEntity> movieDetailResource = LiveDataTestUtil.getValue(filmRepository.getDetailMovieById(mvId));
        verify(local).getDetailMovieById(mvId);
        assertNotNull(movieDetailResource);
        assertNotNull(movieDetailResource.data);
        assertNotNull(movieDetailResource.data.getMvTitle());

        assertEquals(movieDetailResponse.getId(), movieDetailResource.data.getMvId());
        assertEquals(movieDetailResponse.getPosterPath(), movieDetailResource.data.getMvPoster());
        assertEquals(movieDetailResponse.getTitle(), movieDetailResource.data.getMvTitle());
        assertEquals(movieDetailResponse.getReleaseDate(), movieDetailResource.data.getMvReleaseDate());
        assertEquals(movieDetailResponse.getVoteAverage(), movieDetailResource.data.getMvRating(), 0.01);
        assertEquals(movieDetailResponse.getOverview(), movieDetailResource.data.getMvDescription());
        assertEquals(movieDetailResponse.getRuntime(), movieDetailResource.data.getMvDuration());

        StringBuilder sbGenre = new StringBuilder();
        if (movieDetailResponse.getGenres().size() != 0) {
            for (int i = 0; i < movieDetailResponse.getGenres().size(); i++) {
                sbGenre.append(movieDetailResponse.getGenres().get(i).getName());
                sbGenre.append(", ");
            }

        } else {
            sbGenre.append("Unknown..");
        }
        String genre = sbGenre.toString();
        genre = genre.substring(0, genre.length() - 2);

        StringBuilder sbProducer = new StringBuilder();
        if (movieDetailResponse.getProductionCompanies().size() != 0) {
            for (int i = 0; i < movieDetailResponse.getProductionCompanies().size(); i++) {
                sbProducer.append(movieDetailResponse.getProductionCompanies().get(i).getName());
                sbProducer.append(", ");
            }

        } else {
            sbProducer.append("Unknown..");
        }
        String producer = sbProducer.toString();
        producer = producer.substring(0, producer.length() - 2);


        assertEquals(genre, movieDetailResource.data.getMvGenre());
        assertEquals(movieDetailResponse.getBudget(), movieDetailResource.data.getMvBudget());
        assertEquals(movieDetailResponse.getRevenue(), movieDetailResource.data.getMvRevenue());
        assertEquals(producer, movieDetailResource.data.getMvProducer());
    }


    @Test
    public void getCastMovieById() {
        MutableLiveData<MovieCastEntity> dummyCastMovie = new MutableLiveData<>();
        MovieCastEntity movieCastEntity = DataDummy.createDummyCastMovie();
        dummyCastMovie.setValue(movieCastEntity);
        when(local.getCastMovieById(tsId)).thenReturn(dummyCastMovie);

        Resource<MovieCastEntity> movieCastResource = LiveDataTestUtil.getValue(filmRepository.getCastMovieById(tsId));
        verify(local).getCastMovieById(tsId);
        assertNotNull(movieCastResource);
        assertNotNull(movieCastResource.data);
        assertNotNull(movieCastResource.data.getMvCast());

        StringBuilder sbCast = new StringBuilder();
        if (movieCastResponse.getCast().size() != 0) {
            for (int i = 0; i < movieCastResponse.getCast().size(); i++) {
                sbCast.append(movieCastResponse.getCast().get(i).getName());
                sbCast.append(", ");
            }

        } else {
            sbCast.append("Unknown..");
        }
        String cast = sbCast.toString();
        cast = cast.substring(0, cast.length() - 2);

        assertEquals(movieCastResponse.getId(), movieCastResource.data.getMvId());
        assertEquals(cast, movieCastResource.data.getMvCast());
    }


    @Test
    public void getFavoriteMovies() {
        DataSource.Factory<Integer, MovieDetailEntity> dummyFavoriteMovies = mock(DataSource.Factory.class);
        when(local.getFavoriteMovies()).thenReturn(dummyFavoriteMovies);
        filmRepository.getFavoriteMovies();

        Resource<PagedList<MovieDetailEntity>> movieFavoriteResource = Resource.success(PagedListUtil.mockPagedList(DataDummy.createDummyDetailMovies()));
        verify(local).getFavoriteMovies();
        assertNotNull(movieFavoriteResource.data);
        assertEquals(movieResponses.size(), movieFavoriteResource.data.size());
    }

    @Test
    public void setFavoriteMovie() {
        MovieDetailEntity dummyDetailMovie = DataDummy.createDummyDetailMovies().get(0);
        boolean newState = !dummyDetailMovie.isMvFavorite();

        when(appExecutors.diskIO()).thenReturn(testExecutors.diskIO());
        doNothing().when(local).setFavoriteMovie(dummyDetailMovie, newState);

        filmRepository.setFavoriteMovie(dummyDetailMovie, newState);
        verify(local, times(1)).setFavoriteMovie(dummyDetailMovie, newState);
    }
}