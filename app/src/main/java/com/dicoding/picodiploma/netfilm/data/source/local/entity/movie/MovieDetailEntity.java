package com.dicoding.picodiploma.netfilm.data.source.local.entity.movie;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movieDetailEntities")
public class MovieDetailEntity {
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

    @ColumnInfo(name = "mvFavorite")
    private boolean mvFavorite = false;

    @ColumnInfo(name = "mvDuration")
    private int mvDuration;

    @ColumnInfo(name = "mvGenre")
    private String mvGenre;

    @ColumnInfo(name = "mvBudget")
    private int mvBudget;

    @ColumnInfo(name = "mvRevenue")
    private int mvRevenue;

    @ColumnInfo(name = "mvProducer")
    private String mvProducer;

    public MovieDetailEntity() {
    }

    public MovieDetailEntity(int mvId, String mvPoster, String mvTitle, String mvReleaseDate, double mvRating, String mvDescription, Boolean mvFavorite, int mvDuration, String mvGenre, int mvBudget, int mvRevenue, String mvProducer) {
        this.mvId = mvId;
        this.mvPoster = mvPoster;
        this.mvTitle = mvTitle;
        this.mvReleaseDate = mvReleaseDate;
        this.mvRating = mvRating;
        this.mvDescription = mvDescription;
        if (mvFavorite != null) {
            this.mvFavorite = mvFavorite;
        }

        this.mvDuration = mvDuration;
        this.mvGenre = mvGenre;
        this.mvBudget = mvBudget;
        this.mvRevenue = mvRevenue;
        this.mvProducer = mvProducer;
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

    public boolean isMvFavorite() {
        return mvFavorite;
    }

    public void setMvFavorite(boolean mvFavorite) {
        this.mvFavorite = mvFavorite;
    }

    public int getMvDuration() {
        return mvDuration;
    }

    public void setMvDuration(int mvDuration) {
        this.mvDuration = mvDuration;
    }

    public String getMvGenre() {
        return mvGenre;
    }

    public void setMvGenre(String mvGenre) {
        this.mvGenre = mvGenre;
    }

    public int getMvBudget() {
        return mvBudget;
    }

    public void setMvBudget(int mvBudget) {
        this.mvBudget = mvBudget;
    }

    public int getMvRevenue() {
        return mvRevenue;
    }

    public void setMvRevenue(int mvRevenue) {
        this.mvRevenue = mvRevenue;
    }


    public String getMvProducer() {
        return mvProducer;
    }

    public void setMvProducer(String mvProducer) {
        this.mvProducer = mvProducer;
    }
}
