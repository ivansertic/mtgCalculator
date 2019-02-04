package com.example.serticivan.mtgcalculator;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private SecondFragment firstPlayerCounters = new SecondFragment();
    private SecondFragment secondPlayerCoutners = new SecondFragment();
    private FirstFragment scoreboard = new FirstFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(firstPlayerCounters,"First player Counters");
        viewPagerAdapter.addFragment(scoreboard, "Players");
        viewPagerAdapter.addFragment(secondPlayerCoutners,"Second player counters");

        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(1,false);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.setOffscreenPageLimit(4);
    }
}
