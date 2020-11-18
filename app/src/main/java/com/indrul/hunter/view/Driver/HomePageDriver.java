package com.indrul.hunter.view.Driver;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.indrul.hunter.Adapter.FHomepagerAdapter;
import com.indrul.hunter.Adapter.HomePagerAdapter;
import com.indrul.hunter.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomePageDriver extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page_driver);
        /////////////////////////////////////
        ButterKnife.bind(this);
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setNavigationBarColor(this.getResources().getColor(R.color.homebagetabs));
        window.setStatusBarColor(this.getResources().getColor(R.color.homebagetabs));

        ///////////////////////////////////////////////
        TabsGetReady();
    }

    void TabsGetReady() {
        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.ic_baseline_home_24)));
        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.ic_baseline_notifications_none_24)));
        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.ic_outline_layers_24)));
        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.ic_round_chat_bubble_24)));
        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.ic_outline_settings_24)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.selectTab(tabLayout.getTabAt(0));
        final FHomepagerAdapter adapter = new FHomepagerAdapter(getSupportFragmentManager(), this, tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()) {
                    case 0:
                        tabLayout.getTabAt(0).setIcon(getResources().getDrawable(R.drawable.ic_baseline_home_24));
                        break;
                    case 1:
                        tabLayout.getTabAt(1).setIcon(getResources().getDrawable(R.drawable.ic_baseline_notifications_24));
                        break;
                    case 2:
                        tabLayout.getTabAt(2).setIcon(getResources().getDrawable(R.drawable.ic_baseline_add_circle_24));
                        break;
                    case 3:
                        tabLayout.getTabAt(3).setIcon(getResources().getDrawable(R.drawable.ic_baseline_layers_24));
                        break;
                    case 4:
                        tabLayout.getTabAt(4).setIcon(getResources().getDrawable(R.drawable.ic_baseline_settings_24));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tabLayout.getTabAt(0).setIcon(getResources().getDrawable(R.drawable.ic_outline_home_24));
                        break;
                    case 1:
                        tabLayout.getTabAt(1).setIcon(getResources().getDrawable(R.drawable.ic_baseline_notifications_none_24));
                        break;
                    case 2:
                        tabLayout.getTabAt(2).setIcon(getResources().getDrawable(R.drawable.ic_baseline_add_circle_outline_24));
                        break;
                    case 3:
                        tabLayout.getTabAt(3).setIcon(getResources().getDrawable(R.drawable.ic_outline_layers_24));
                        break;
                    case 4:
                        tabLayout.getTabAt(4).setIcon(getResources().getDrawable(R.drawable.ic_outline_settings_24));
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}