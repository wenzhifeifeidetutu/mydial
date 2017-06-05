package com.mycompany.mydial;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        dialViewPagerAdapter mydialViewPagerAdapter =  new dialViewPagerAdapter(this, getSupportFragmentManager());

        viewPager.setAdapter(mydialViewPagerAdapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}
