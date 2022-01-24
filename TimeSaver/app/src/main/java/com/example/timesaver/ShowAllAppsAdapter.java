package com.example.timesaver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ShowAllAppsAdapter extends ArrayAdapter {

    boolean highest;
    int highestTime;

    public ShowAllAppsAdapter(Context context, int resource)
    {
        super(context, resource);
        highest=false;
        highestTime=1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row;
        row = convertView;

        AppsView appsView;

        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null)
        {
            row = inflater.inflate(R.layout.customlvallappstimes,parent,false);
            appsView = new AppsView();

            appsView.imageView = (ImageView) row.findViewById(R.id.appIcon);
            appsView.textView = (TextView) row.findViewById(R.id.appName);
            appsView.textView2 = (TextView) row.findViewById(R.id.appUsed);
            appsView.progressBar = (ProgressBar) row.findViewById(R.id.progressBar23);

            row.setTag(appsView);
        }
        else
        {
            appsView = (AppsView) row.getTag();
        }

        AppInfoList appInfoList = (AppInfoList)getItem(position);

        appsView.imageView.setImageDrawable(appInfoList.appIco);
        appsView.textView.setText(appInfoList.appName);

        String strTime = "";
        int hour = appInfoList.appTime/60;
        int min = appInfoList.appTime%60;
        strTime = hour+"H "+min+"M";

        appsView.textView2.setText(strTime);

        
        if (highest == false)
        {
            highestTime = appInfoList.getAppTime();
            highest = true;
        }



        int num = ((appInfoList.appTime*100)/highestTime);
        appsView.progressBar.setProgress(num);

        return row;
    }




    static class AppsView
    {
        ImageView imageView;
        TextView textView;
        TextView textView2;
        ProgressBar progressBar;
    }
}
