package com.dicoding.picodiploma.netfilm.data.source.local.entity.movie;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "movieCastEntities")
public class MovieCastEntity {
    @PrimaryKey
    @ColumnInfo(name = "mvId")
    private int mvId;

    @ColumnInfo(name = "mvCast")
    private String mvCast;

    public MovieCastEntity(int mvId, String mvCast) {
        this.mvId = mvId;
        this.mvCast = mvCast;
    }

    public int getMvId() {
        return mvId;
    }

    public void setMvId(int mvId) {
        this.mvId = mvId;
    }

    public String getMvCast() {
        return mvCast;
    }

    public void setMvCast(String mvCast) {
        this.mvCast = mvCast;
    }
}
