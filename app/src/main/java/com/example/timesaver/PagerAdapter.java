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

    @Override
    public Fragment getItem(int position) {

        if (fragmentHashMap.get(position) != null) {
            return fragmentHashMap.get(position);
        }
        else {

            switch (position) {
                case 0:
                    Today today = new Today();
                    fragmentHashMap.put(position, today);
                    return today;
                case 1:
                    Details details = new Details();
                    fragmentHashMap.put(position, details);
                    return details;
                case 2:
                    History history = new History();
                    fragmentHashMap.put(position, history);
                    return history;
                default:
                    return null;
            }
        }
    }

    @Override
    public int getCount() {
        return NoOfTabs;
    }

    public Today getToday() {
        return todayReturn;
    }

    public Details getDetails() {
        return detailsReturn;
    }

    public History getHistory() {
        return historyReturn;
    }
}
