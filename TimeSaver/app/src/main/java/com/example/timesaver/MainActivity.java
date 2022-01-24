package com.example.timesaver;

import android.Manifest;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.Settings;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Today.OnFragmentInteractionListener,Details.OnFragmentInteractionListener,History.OnFragmentInteractionListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private TabLayout tabLayout;
    private NavigationView navigationView;
    private Today todayFragment;
    private Details detailsFragment;
    private History historyFragment;

    public static int OVERLAY_PERMISSION_REQ_CODE = 41;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        //ScreenOnOffBroadcast screenOnOffBroadcast = new ScreenOnOffBroadcast();
        //IntentFilter lockFilter = new IntentFilter();
        //lockFilter.addAction(Intent.ACTION_SCREEN_ON);
        //lockFilter.addAction(Intent.ACTION_SCREEN_OFF);
        //registerReceiver(screenOnOffBroadcast, lockFilter);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00007f")));
        getSupportActionBar().setTitle("");

        navigationView = (NavigationView)findViewById(R.id.nav_view);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Today!"));
        tabLayout.addTab(tabLayout.newTab().setText("Details!"));
        tabLayout.addTab(tabLayout.newTab().setText("History!"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setOffscreenPageLimit(2);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        todayFragment = (Today)pagerAdapter.getItem(0);
        detailsFragment = (Details) pagerAdapter.getItem(1);
        historyFragment = (History) pagerAdapter.getItem(2);

        setTheme();
        postponeEnterTransition();

        SetAllAppsNamesAndIcons();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Mypref",0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        switch(item.getItemId())
        {
            case R.id.help:
            {
                Toast.makeText(this,"HELP",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,Help.class);
                startActivity(intent);
                return true;
            }
            case R.id.lightt:
            {
                lightTheme();
                todayFragment.setLightTheme();
                historyFragment.lightTheme();
                Toast.makeText(this,"LIGHT",Toast.LENGTH_SHORT).show();
                editor.putInt("Theme",0);
                editor.commit();
                return true;
            }
            case R.id.darkt:
            {
                darkTheme();
                todayFragment.setDarkTheme();
                historyFragment.darkTheme();
                Toast.makeText(this,"DARK",Toast.LENGTH_SHORT).show();
                editor.putInt("Theme",1);
                editor.commit();
                return true;
            }
            case R.id.setting:
            {
                Toast.makeText(this,"SETTINGS",Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        int i = R.menu.mainmenu;
        inflater.inflate(i,menu);
        return true;
    }

    @Override
    public void onFragmentInteraction(String arg) {

    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    public void lightTheme()
    {
        View vieww = navigationView.getHeaderView(0);

        LinearLayout linearLayout1 = (LinearLayout) vieww.findViewById(R.id.headerl1);

        drawerLayout.setBackground(ContextCompat.getDrawable(this,R.drawable.small2));
        tabLayout.setBackground(ContextCompat.getDrawable(this, R.drawable.gradientgraytablayout));
        linearLayout1.setBackground(ContextCompat.getDrawable(this, R.drawable.gradientgraytablayout));


        getSupportActionBar().setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.gradientgraytablayout));

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        window.setStatusBarColor(Color.parseColor("#085e72"));

    }

    public void darkTheme()
    {
        View vieww = navigationView.getHeaderView(0);

        LinearLayout linearLayout1 = (LinearLayout) vieww.findViewById(R.id.headerl1);

        drawerLayout.setBackground(ContextCompat.getDrawable(this, R.drawable.bluebg));
        tabLayout.setBackground(ContextCompat.getDrawable(this, R.drawable.gradientdarkbluetablauout));
        linearLayout1.setBackground(ContextCompat.getDrawable(this, R.drawable.gradientdarkbluetablauout));

        getSupportActionBar().setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.gradientdarkbluetablauout));

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        window.setStatusBarColor(Color.parseColor("#00004c"));

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

    public void SetAllAppsNamesAndIcons()
    {
        Drawable appIco = null;
        String appName = "";
        String appPackage = "";
        int appTime = 0;

        PackageManager ppm = getPackageManager();

        List<String> apps = new ArrayList<>();
        ArrayList<AppInfoList> appInfoList = new ArrayList<>();

        AppInfoExtractor apk = new AppInfoExtractor(this);
        apps = apk.GetAllInstalledApkInfo();

        for (int i = 0 ; i < apps.size(); i ++) {

            appPackage = apps.get(i);
            appName = apk.GetAppName(apps.get(i));
            appIco = apk.getAppIconByPackageName(apps.get(i));

            appInfoList.add(new AppInfoList(appIco,appName,appPackage,appTime));
        }
        detailsFragment.setArrayList(appInfoList);
        //todayFragment.setMostUsedApp(appInfoList.get(0));
    }

}
