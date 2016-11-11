package com.gabe.android.aca.snoozecamp;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Gabe on 11/2/16.
 */

public class Lookbook implements Serializable {

    public static final String IMAGE_PATH = "http://www.snoozecamp.com/lookbook/";


    @SerializedName("poster_path")
    private String mPoster;


    @SerializedName("overview")
    private String mDescription;

    @SerializedName("backdrop_path")
    private String mBackdrop;


    public Lookbook() {}






    public String getPoster() {
        return IMAGE_PATH + mPoster;
    }

    public void setPoster(String poster) {
        mPoster = poster;
    }





    public String getBackdrop() {
        return IMAGE_PATH + mBackdrop;
    }

    public void setBackdrop(String backdrop) {
        mBackdrop = backdrop;
    }

    public static class LookbookResult {
        private List<Lookbook> results;

        public List<Lookbook> getResults() {
            return results;
        }
    }
}

