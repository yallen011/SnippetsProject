package com.android.sample.snippetsproject;

import android.content.Intent;

/**
 * Created by Yvonne on 7/16/2017.
 */

public class Snippet {

    int thumbnail;
    String title;
    String description;
    Intent intent;

    public Snippet(int thumbnail, String title, String description, Intent intent) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.description = description;
        this.intent = intent;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }
}
