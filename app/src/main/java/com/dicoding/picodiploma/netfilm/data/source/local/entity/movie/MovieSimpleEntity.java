package com.dicoding.picodiploma.netfilm.data.source.local.entity.movie;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movieSimpleEntities")
public class MovieSimpleEntity {
    @PrimaryKey
    @ColumnInfo(name = "mvId")
    private int mvId;

    @ColumnInfo(name = "mvPoster")
    private String mvPoster;

    @ColumnInfo(name = "mvTitle")
    private String mvTitle;

    @ColumnInfo(name = "mvReleaseDate")
    private String mvReleaseDate;

    @ColumnInfo(name = "mvRating")
    private double mvRating;

    @ColumnInfo(name = "mvDescription")
    private String mvDescription;

    public MovieSimpleEntity(int mvId, String mvPoster, String mvTitle, String mvReleaseDate, double mvRating, String mvDescription) {
        this.mvId = mvId;
        this.mvPoster = mvPoster;
        this.mvTitle = mvTitle;
        this.mvReleaseDate = mvReleaseDate;
        this.mvRating = mvRating;
        this.mvDescription = mvDescription;
    }

    public int getMvId() {
        return mvId;
    }

    public void setMvId(int mvId) {
        this.mvId = mvId;
    }

    public String getMvPoster() {
        return mvPoster;
    }

    public void setMvPoster(String mvPoster) {
        this.mvPoster = mvPoster;
    }

    public String getMvTitle() {
        return mvTitle;
    }

    public void setMvTitle(String mvTitle) {
        this.mvTitle = mvTitle;
    }

    public String getMvReleaseDate() {
        return mvReleaseDate;
    }

    public void setMvReleaseDate(String mvReleaseDate) {
        this.mvReleaseDate = mvReleaseDate;
    }

    public double getMvRating() {
        return mvRating;
    }

    public void setMvRating(double mvRating) {
        this.mvRating = mvRating;
    }

    public String getMvDescription() {
        return mvDescription;
    }

    public void setMvDescription(String mvDescription) {
        this.mvDescription = mvDescription;
    }
}
