package com.indrul.hunter.Adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.indrul.hunter.view.LoginFragments.LoginFragment;
import com.indrul.hunter.view.LoginFragments.SignUpFragment;

public class PagerAdapter extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;

    public PagerAdapter(@NonNull FragmentManager fm, Context myContext, int totalTabs) {
        super(fm);
        this.myContext = myContext;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                LoginFragment homeFragment = new LoginFragment();
                return homeFragment;
            case 1:
                SignUpFragment sportFragment = new SignUpFragment();
                return sportFragment;
            default:
                LoginFragment homeFragmen = new LoginFragment();
                return homeFragmen;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
