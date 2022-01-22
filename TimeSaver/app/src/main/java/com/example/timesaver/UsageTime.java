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

    public ArrayList<AppInfoList> getAppInfoList()
    {
        return appInfoList;
    }

    public void SetAllAppsNamesAndIcons()
    {
        Drawable appIco = null;
        String appName = "";
        String appPackage = "";
        int appTime = 0;

        PackageManager ppm = mcontext.getPackageManager();

        List<String> apps = new ArrayList<>();
        appInfoList = new ArrayList<>();

        AppInfoExtractor apk = new AppInfoExtractor(mcontext);
        apps = apk.GetAllInstalledApkInfo();

        for (int i = 0 ; i < apps.size(); i ++)
        {

            appPackage = apps.get(i);
            appName = apk.GetAppName(apps.get(i));
            appIco = apk.getAppIconByPackageName(apps.get(i));

            appInfoList.add(new AppInfoList(appIco,appName,appPackage,appTime));
        }

    }

    public void setAllUsageTimes()
    {
        final UsageStatsManager usageStatsManager = (UsageStatsManager) mcontext.getSystemService(Context.USAGE_STATS_SERVICE);// Context.USAGE_STATS_SERVICE);
        //Calendar beginCal = Calendar.getInstance();
        //beginCal.set(Calendar.DAY_OF_MONTH, 3);
        //beginCal.set(Calendar.MONTH, 6);
        //beginCal.set(Calendar.YEAR, 2019);

        //Calendar endCal = Calendar.getInstance();
        //endCal.set(Calendar.DAY_OF_MONTH, 9);
        //endCal.set(Calendar.MONTH, 6);
        //endCal.set(Calendar.YEAR, 2019);

        //final long currentTime = System.currentTimeMillis(); // Get current time in milliseconds

        //final Calendar cal = Calendar.getInstance();

        //cal.add(Calendar.DAY_OF_MONTH, -1);

        //final long beginTime = cal.getTimeInMillis(); // Get begin time in milliseconds

        //Log.d("tatataa",start.getTime().toString());
        //Log.d("tatataa",end.getTime().toString());

        final long startTime = start.getTimeInMillis();
        final long endTime = end.getTimeInMillis();

        final List<UsageStats> queryUsageStats=usageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, startTime, endTime);

        //final List<UsageStats> queryUsageStats = usageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, beginCal.getTimeInMillis(), endCal.getTimeInMillis());

        //Log.e("pkpkpk",Integer.toString(queryUsageStats.size()));

        for (UsageStats app : queryUsageStats) {
            //System.out.println(app.getPackageName() + " | " + (float) (app.getTotalTimeInForeground() / 1000));

            String s2 = app.getPackageName();
            //Log.e("pkpkpk",s2);

            for (int i = 0; i<appInfoList.size(); i++) {
                String s1 = appInfoList.get(i).appPackage;

                if (s1.equals(s2)) {
                    //Log.e("tatata", Integer.toString((int) app.getTotalTimeInForeground() / 1000));
                    appInfoList.get(i).setAppTime((int) ((app.getTotalTimeInForeground() / (1000*60))));
                }

            }
        }

    }

    public void removeDuplicates()
    {
        ArrayList<AppInfoList> newArr = new ArrayList<>();
        for (int i=0; i<appInfoList.size();i++)
        {
            for (int j = 0 ; j<appInfoList.size();j++)
            {
                if ((i!=j) &&(appInfoList.get(i).getAppName().equals(appInfoList.get(j).getAppName())))
                {
                    appInfoList.remove(j);
                }
            }
        }
    }

    public void checkTimes()
    {
        final UsageStatsManager usageStatsManager = (UsageStatsManager) mcontext.getSystemService(Context.USAGE_STATS_SERVICE);// Context.USAGE_STATS_SERVICE);

        //Log.d("tatataa",start.getTime().toString());
        //Log.d("tatataa",end.getTime().toString());

        final long startTime = start.getTimeInMillis();
        final long endTime = end.getTimeInMillis();

        final List<UsageStats> queryUsageStats=usageStatsManager.queryUsageStats(UsageStatsManager.INTERVAL_DAILY, startTime, endTime);

        //Log.e("pkpkpk",Integer.toString(queryUsageStats.size()));
        String s1 = appInfoList.get(appInfoList.size()-3).appPackage;

        for (UsageStats app : queryUsageStats) {
            //Log.e("tatata",(app.getPackageName() + " | " + (float) (app.getTotalTimeInForeground() / (1000*60))));

            String s2 = app.getPackageName();

            //Log.e("pkpkpk",s2);

                if (s1.equals(s2)) {
                    //Log.e("tatata", Integer.toString((int) app.getTotalTimeInForeground() / 1000));
                }
        }
    }

    public AppInfoList mostUsedApp()
    {
        return appInfoList.get(appInfoList.size()-1);
    }

    public int getTotalTime()
    {
        int sum = 0;
        for (int i = 0 ; i< appInfoList.size();i++)
        {
            sum = sum + appInfoList.get(i).getAppTime();
        }
        return sum;
    }
}
