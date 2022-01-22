package com.example.timesaver;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class HistoryDetails extends AppCompatActivity {

    ArrayList<AppInfoList> appInfoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_details);

        int day = 0;

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            day = bundle.getInt("day");
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTheme();
        //appInfoList = new ArrayList<>();
        //Intent intent = getIntent();
        //ArrayList<AppInfoList> appInfoList = (ArrayList<AppInfoList>) getIntent().getSerializableExtra("list");

        final Calendar cal1 = Calendar.getInstance();
        cal1.add(Calendar.DATE, day);
        cal1.set(Calendar.HOUR_OF_DAY,00);
        cal1.set(Calendar.MINUTE,00);
        cal1.set(Calendar.SECOND,00);

        final Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DATE, day);
        cal2.set(Calendar.HOUR_OF_DAY,23);
        cal2.set(Calendar.MINUTE,59);
        cal2.set(Calendar.SECOND,59);

        UsageTime usageTime = new UsageTime(getApplicationContext(),cal1,cal2);
        appInfoList = usageTime.getAppInfoList();

        //Bundle extra = getIntent().getBundleExtra("extra");
        //appInfoList = (ArrayList<AppInfoList>) extra.getSerializable("objects");

        ShowAllAppsAdapter showAllAppsAdapter = new ShowAllAppsAdapter(this,R.layout.customlvallappstimes);
        ListView listView = (ListView) findViewById(R.id.listview2);

        for(int i = appInfoList.size()-1; i>=0 ; i--)
        {
            showAllAppsAdapter.add(appInfoList.get(i));

        }

        listView.setAdapter(showAllAppsAdapter);


        TextView tv = (TextView) findViewById(R.id.tv312);

        int totalTime = usageTime.getTotalTime();
        String strTime = "";
        int hour = (totalTime/60)%24;
        int min = totalTime%60;
        strTime = hour+"H "+min+"M";
        tv.setText(strTime);
        tv.setText(strTime);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    public void setTheme()
    {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Mypref",0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        int theme = sharedPreferences.getInt("Theme",0);
        if (theme == 0)
            lightTheme();
        else
            darkTheme();
    }

    public void lightTheme()
    {

        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.showall);

        linearLayout1.setBackground(ContextCompat.getDrawable(this, R.drawable.small2));


        getSupportActionBar().setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.gradientgraytablayout));

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        window.setStatusBarColor(Color.parseColor("#085e72"));

    }

    public void darkTheme()
    {

        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.showall);

        linearLayout1.setBackground(ContextCompat.getDrawable(this, R.drawable.bluebg));

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00007f")));

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        window.setStatusBarColor(Color.parseColor("#00004c"));


    }

}
