package com.indrul.hunter.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.indrul.hunter.view.Driver.HomePageDriverFragment.ChatDFragment;
import com.indrul.hunter.view.Driver.HomePageDriverFragment.HomeDFragment;
import com.indrul.hunter.view.Driver.HomePageDriverFragment.NotificationDFragment;
import com.indrul.hunter.view.Driver.HomePageDriverFragment.OrdersDFragment;
import com.indrul.hunter.view.Driver.HomePageDriverFragment.SettingsDFrragment;
import com.indrul.hunter.view.HomePageFragments.AddFragment;
import com.indrul.hunter.view.HomePageFragments.HomeFragment;
import com.indrul.hunter.view.HomePageFragments.NotificationFragment;
import com.indrul.hunter.view.HomePageFragments.OrderFragment;
import com.indrul.hunter.view.HomePageFragments.SettingsFragment;

public class FHomepagerAdapter extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;

    public FHomepagerAdapter(@NonNull FragmentManager fm, Context myContext, int totalTabs) {
        super(fm);
        this.myContext = myContext;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                HomeDFragment homeFragment = new HomeDFragment();
                return homeFragment;
            case 1:
                NotificationDFragment notificationFragment = new NotificationDFragment();
                return notificationFragment;
            case 2:
                OrdersDFragment addFragment = new OrdersDFragment();
                return addFragment;
            case 3:
                ChatDFragment orderFragment = new ChatDFragment();
                return orderFragment;
            case 4:
                SettingsDFrragment settingsFragment = new SettingsDFrragment();
                return settingsFragment;
            default:
                HomeFragment homeFragment2 = new HomeFragment();
                return homeFragment2;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
