package com.example.timesaver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // First pull request test
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitleTextColor(Color.WHITE);
            setSupportActionBar(toolbar);



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

    }
}