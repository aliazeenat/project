package com.example.timesaver;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.HashMap;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int NoOfTabs;

    private Today todayReturn;
    private Details detailsReturn;
    private History historyReturn;
    private HashMap<Integer, Fragment> fragmentHashMap = new HashMap<>();

   public PagerAdapter(FragmentManager fm,int noOfTabs)
   {
        super(fm);
        this.NoOfTabs = noOfTabs;
   }

  
}
