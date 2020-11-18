package com.indrul.hunter.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.indrul.hunter.view.HomePageFragments.AddFragment;
import com.indrul.hunter.view.HomePageFragments.HomeFragment;
import com.indrul.hunter.view.HomePageFragments.NotificationFragment;
import com.indrul.hunter.view.HomePageFragments.OrderFragment;
import com.indrul.hunter.view.HomePageFragments.SettingsFragment;
import com.indrul.hunter.view.LoginFragments.LoginFragment;
import com.indrul.hunter.view.LoginFragments.SignUpFragment;

public class HomePagerAdapter extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;

    public HomePagerAdapter(@NonNull FragmentManager fm, Context myContext, int totalTabs) {
        super(fm);
        this.myContext = myContext;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                NotificationFragment notificationFragment = new NotificationFragment();
                return notificationFragment;
            case 2:
                AddFragment addFragment = new AddFragment();
                return addFragment;
            case 3:
                OrderFragment orderFragment = new OrderFragment();
                return orderFragment;
            case 4:
                SettingsFragment settingsFragment = new SettingsFragment();
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
