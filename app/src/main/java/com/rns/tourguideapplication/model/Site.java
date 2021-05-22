package com.rns.tourguideapplication.model;

public class Site {
    private String mSiteName;
    private String mSiteLocation;
    private int mSiteImage;

    public Site(String mSiteName, String mSiteLocation, int mSiteImage) {
        this.mSiteName = mSiteName;
        this.mSiteLocation = mSiteLocation;
        this.mSiteImage = mSiteImage;
    }

    public String getmSiteLocation() {
        return mSiteLocation;
    }

    public String getmSiteName() {
        return mSiteName;
    }

    public int getmSiteImage() {
        return mSiteImage;
    }

}
