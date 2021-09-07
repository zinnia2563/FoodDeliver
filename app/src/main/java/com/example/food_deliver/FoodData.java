
package com.example.food_deliver;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodData {

    @SerializedName("popular")
    @Expose
    private List<Popular> popular = null;
    @SerializedName("recommended")
    @Expose
    private List<com.rajendra.foodapp.model.Recommended> recommended = null;
    @SerializedName("allmenu")
    @Expose
    private List<Allmenu> allmenu = null;

    public List<Popular> getPopular() {
        return popular;
    }

    public void setPopular(List<Popular> popular) {
        this.popular = popular;
    }

    public List<com.rajendra.foodapp.model.Recommended> getRecommended() {
        return recommended;
    }

    public void setRecommended(List<com.rajendra.foodapp.model.Recommended> recommended) {
        this.recommended = recommended;
    }

    public List<Allmenu> getAllmenu() {
        return allmenu;
    }

    public void setAllmenu(List<Allmenu> allmenu) {
        this.allmenu = allmenu;
    }

}
