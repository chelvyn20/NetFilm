package com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tvShowSimpleEntities")
public class TvShowSimpleEntity {
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

    public TvShowSimpleEntity(int tsId, String tsPoster, String tsTitle, String tsFirstDate, double tsRating, String tsDescription) {
        this.tsId = tsId;
        this.tsPoster = tsPoster;
        this.tsTitle = tsTitle;
        this.tsFirstDate = tsFirstDate;
        this.tsRating = tsRating;
        this.tsDescription = tsDescription;
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
}
