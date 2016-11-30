package com.passwordvault.pojo;

import android.graphics.Color;

/**
 * Created by bpanchal on 11-Nov-16.
 */

public class TypeOfCategory {

    String title;
    String categoryName;
    int imageId ;
    int backgroundColorId;

    public int getBackgroundColorId() {
        return backgroundColorId;
    }

    public void setBackgroundColorId(int backgroundColorId) {
        this.backgroundColorId = backgroundColorId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
