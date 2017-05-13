package com.mesihmalikkuru.ybuinformationapp;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, FoodMenuFragment.OnFragmentInteractionListener, AnnouncementsFragment.OnFragmentInteractionListener, NewsFragment.OnFragmentInteractionListener {

    private TabLayout mTabLayout;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);

        TabLayout.Tab foodMenuTab = mTabLayout.newTab();
        foodMenuTab.setIcon(R.drawable.ic_restourant_icon);
        foodMenuTab.setText("Food Menu");
        mTabLayout.addTab(foodMenuTab);

        TabLayout.Tab announcementsTab = mTabLayout.newTab();
        announcementsTab.setIcon(R.drawable.ic_announcements_icon);
        announcementsTab.setText("Announcements");
        mTabLayout.addTab(announcementsTab);

        TabLayout.Tab newsTab = mTabLayout.newTab();
        newsTab.setIcon(R.drawable.ic_news_icon);
        newsTab.setText("News");
        mTabLayout.addTab(newsTab);

        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        Pager adapter = new Pager(getSupportFragmentManager(), mTabLayout.getTabCount());

        mViewPager.setAdapter(adapter);

        mTabLayout.setOnTabSelectedListener(this);

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
