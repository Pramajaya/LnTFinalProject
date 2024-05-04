package com.example.lntfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CounterPageActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    TabLayout tabLayout;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_page);

        viewPager2 = findViewById(R.id.viewPager2);
        tabLayout = findViewById(R.id.tabLayout);

        setViewPager2(viewPager2);

        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText(pagerAdapter.getPageTitle(position))).attach();
    }

    public void setViewPager2(ViewPager2 viewPager2) {
        if(pagerAdapter == null) {
            pagerAdapter = new PagerAdapter(this);
            pagerAdapter.addFragment(new Fragment1Counter(), "Counter");
            pagerAdapter.addFragment(new Fragment2Luas(), "Area");
            pagerAdapter.addFragment(new Fragment3Volume(), "Volume");
            viewPager2.setAdapter(pagerAdapter);
        }
    }



}