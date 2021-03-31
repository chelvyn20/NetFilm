package com.dicoding.picodiploma.netfilm.data.source.local.entity.tvshow;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tvShowCastEntities")
public class TvShowCastEntity {
    @PrimaryKey
    @ColumnInfo(name = "tsId")
    private int tsId;

    @ColumnInfo(name = "tsCast")
    private String tsCast;

    public TvShowCastEntity(int tsId, String tsCast) {
        this.tsId = tsId;
        this.tsCast = tsCast;
    }

    public int getTsId() {
        return tsId;
    }

    public void setTsId(int tsId) {
        this.tsId = tsId;
    }

    public String getTsCast() {
        return tsCast;
    }

    public void setTsCast(String tsCast) {
        this.tsCast = tsCast;
    }
}
