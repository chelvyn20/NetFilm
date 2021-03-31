package com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tvShowDetailEntities")
public class TvShowDetailEntity {
    @PrimaryKey
    @ColumnInfo(name = "tsId")
    private int tsId;

    @ColumnInfo(name = "tsPoster")
    private String tsPoster;

    @ColumnInfo(name = "tsTitle")
    private String tsTitle;

    @ColumnInfo(name = "tsFirstDate")
    private String tsFirstDate;

    @ColumnInfo(name = "tsRating")
    private double tsRating;

    @ColumnInfo(name = "tsDescription")
    private String tsDescription;

    @ColumnInfo(name = "tsFavorite")
    private boolean tsFavorite = false;

    @ColumnInfo(name = "tsSeason")
    private int tsSeason;

    @ColumnInfo(name = "tsGenre")
    private String tsGenre;

    @ColumnInfo(name = "tsPublisher")
    private String tsPublisher;

    @ColumnInfo(name = "tsProducer")
    private String tsProducer;

    @ColumnInfo(name = "tsCreator")
    private String tsCreator;

    public TvShowDetailEntity() {
    }

    public TvShowDetailEntity(int tsId, String tsPoster, String tsTitle, String tsFirstDate, double tsRating, String tsDescription, Boolean tsFavorite, int tsSeason, String tsGenre, String tsPublisher, String tsProducer, String tsCreator) {
        this.tsId = tsId;
        this.tsPoster = tsPoster;
        this.tsTitle = tsTitle;
        this.tsFirstDate = tsFirstDate;
        this.tsRating = tsRating;
        this.tsDescription = tsDescription;
        if (tsFavorite != null) {
            this.tsFavorite = tsFavorite;
        }

        this.tsSeason = tsSeason;
        this.tsGenre = tsGenre;
        this.tsPublisher = tsPublisher;
        this.tsProducer = tsProducer;
        this.tsCreator = tsCreator;
    }

    public int getTsId() {
        return tsId;
    }

    public void setTsId(int tsId) {
        this.tsId = tsId;
    }

    public String getTsPoster() {
        return tsPoster;
    }

    public void setTsPoster(String tsPoster) {
        this.tsPoster = tsPoster;
    }

    public String getTsTitle() {
        return tsTitle;
    }

    public void setTsTitle(String tsTitle) {
        this.tsTitle = tsTitle;
    }

    public String getTsFirstDate() {
        return tsFirstDate;
    }

    public void setTsFirstDate(String tsFirstDate) {
        this.tsFirstDate = tsFirstDate;
    }

    public double getTsRating() {
        return tsRating;
    }

    public void setTsRating(double tsRating) {
        this.tsRating = tsRating;
    }

    public String getTsDescription() {
        return tsDescription;
    }

    public void setTsDescription(String tsDescription) {
        this.tsDescription = tsDescription;
    }

    public boolean isTsFavorite() {
        return tsFavorite;
    }

    public void setTsFavorite(boolean tsFavorite) {
        this.tsFavorite = tsFavorite;
    }

    public int getTsSeason() {
        return tsSeason;
    }

    public void setTsSeason(int tsSeason) {
        this.tsSeason = tsSeason;
    }

    public String getTsGenre() {
        return tsGenre;
    }

    public void setTsGenre(String tsGenre) {
        this.tsGenre = tsGenre;
    }

    public String getTsPublisher() {
        return tsPublisher;
    }

    public void setTsPublisher(String tsPublisher) {
        this.tsPublisher = tsPublisher;
    }

    public String getTsProducer() {
        return tsProducer;
    }

    public void setTsProducer(String tsProducer) {
        this.tsProducer = tsProducer;
    }

    public String getTsCreator() {
        return tsCreator;
    }

    public void setTsCreator(String tsCreator) {
        this.tsCreator = tsCreator;
    }
}
