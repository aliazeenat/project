package com.example.timesaver;

import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UsageTime
{
    ArrayList<AppInfoList> appInfoList;
    Context mcontext;
    Calendar start;
    Calendar end;

    UsageTime(Context c, Calendar s, Calendar e)
    {
        mcontext = c;
        start = s;
        end = e;
        SetAllAppsNamesAndIcons();
        removeDuplicates();
        setAllUsageTimes();

        Comparator<AppInfoList> compareByTime = new Comparator<AppInfoList>() {
            @Override
            public int compare(AppInfoList o1, AppInfoList o2) {
                if (o1.getAppTime()==o2.getAppTime())
                    return 0;
                if (o1.getAppTime()>o2.getAppTime())
                    return 1;
                if (o1.getAppTime()<o2.getAppTime())
                    return -1;
                else return 0;
            }
        };

        Collections.sort(appInfoList,compareByTime);
    }


}
