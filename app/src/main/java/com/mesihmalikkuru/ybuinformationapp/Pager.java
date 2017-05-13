package com.mesihmalikkuru.ybuinformationapp;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by mesihmalikkuru on 13/05/2017.
 */

public class Pager extends FragmentStatePagerAdapter{

    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem


    @Override
    public int getCount() {
        return tabCount;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position) {
            case 0:
                FoodMenuFragment foodMenuTab = new FoodMenuFragment();
                return foodMenuTab;
            case 1:
                AnnouncementsFragment announcementsTab = new AnnouncementsFragment();
                return announcementsTab;
            case 2:
                NewsFragment newsTab = new NewsFragment();
                return newsTab;
            default:
                return null;
        }
    }
}
