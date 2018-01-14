package com.android.sample.snippetsproject.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Yvonne on 8/14/2017.
 * Entity to store product data
 */
@Entity
public class Product {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    //column info is optional; @ColumnInfo defines the column name of the current table
    //if you don't want to use your variable name as a column name.
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "image_url")
    private String imageUrl;

    public Product() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
