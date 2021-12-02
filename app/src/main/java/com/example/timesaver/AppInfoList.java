package com.example.timesaver;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class AppInfoList implements Serializable {
    Drawable appIco;
    String appName;
    String appPackage;
    int appTime;

    public AppInfoList()
    {
        appIco = null;
        appName = "";
        appPackage = "";
        appTime = 0;
    }

    public AppInfoList(Drawable appIco, String appName, String appPackage, int appTime) {
        this.appIco = appIco;
        this.appName = appName;
        this.appPackage = appPackage;
        this.appTime = appTime;
    }

    public Drawable getAppIco() {
        return appIco;
    }

    public void setAppIco(Drawable appIco) {
        this.appIco = appIco;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public int getAppTime() {
        return appTime;
    }

    public void setAppTime(int appTime) {
        this.appTime = appTime;
    }
}
