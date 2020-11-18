package com.indrul.hunter.view.HomePageFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;
import com.indrul.hunter.R;
import com.indrul.hunter.ReviewsActivity;
import com.indrul.hunter.WalletActivity;
import com.indrul.hunter.view.ChatActivity;
import com.indrul.hunter.view.Driver.SigninDriverActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsFragment extends Fragment {

    @BindView(R.id.wallet)
    RelativeLayout wallet;
    @BindView(R.id.icon)
    CardView icon;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.mail)
    TextView mail;
    @BindView(R.id.f1)
    ImageView f1;
    @BindView(R.id.f2)
    ImageView f2;
    @BindView(R.id.f3)
    ImageView f3;
    @BindView(R.id.f4)
    ImageView f4;
    @BindView(R.id.request)
    RelativeLayout request;
    @BindView(R.id.f5)
    ImageView f5;
    @BindView(R.id.f7)
    ImageView f7;
    @BindView(R.id.rates)
    RelativeLayout rates;
    @BindView(R.id.f6)
    ImageView f6;
    @BindView(R.id.settings)
    RelativeLayout settings;
    @BindView(R.id.f9)
    ImageView f9;
    @BindView(R.id.addpromo)
    RelativeLayout addpromo;
    @BindView(R.id.f10)
    ImageView f10;
    @BindView(R.id.telegram)
    RelativeLayout telegram;
    @BindView(R.id.f11)
    ImageView f11;
    @BindView(R.id.signupdriver)
    RelativeLayout signupdriver;
    @BindView(R.id.chat)
    ImageView chat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        ButterKnife.bind(this, view);
        chat.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), ChatActivity.class));
        });
        return view;
    }

    @OnClick({R.id.wallet, R.id.request, R.id.rates, R.id.settings, R.id.addpromo, R.id.telegram, R.id.signupdriver})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wallet:
                Intent intent = new Intent(getActivity(), WalletActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_bottom);
                break;
            case R.id.request:
                TabLayout host = (TabLayout) getActivity().findViewById(R.id.tabLayout);
                host.selectTab(host.getTabAt(3));
                break;
            case R.id.rates:
                Intent intent2 = new Intent(getActivity(), ReviewsActivity.class);
                startActivity(intent2);
                getActivity().overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_bottom);
                break;
            case R.id.settings:
                break;
            case R.id.addpromo:
                break;
            case R.id.telegram:
                break;
            case R.id.signupdriver:
                break;
        }
    }

    @OnClick(R.id.signupdriver)
    public void onViewClicked() {
        getActivity().startActivity(new Intent(getActivity(), SigninDriverActivity.class));
    }
}