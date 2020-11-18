package com.indrul.hunter.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.flarebit.flarebarlib.FlareBar;
import com.flarebit.flarebarlib.Flaretab;
import com.flarebit.flarebarlib.TabEventObject;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.tabs.TabLayout;
import com.indrul.hunter.Adapter.HomePagerAdapter;
import com.indrul.hunter.Adapter.PagerAdapter;
import com.indrul.hunter.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HomeActivity extends AppCompatActivity {
    private GoogleMap mMap;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
    void TabsGetReady(){
        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.ic_baseline_home_24)));
        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.ic_baseline_notifications_none_24)));
        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.ic_baseline_add_circle_outline_24)));
        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.ic_outline_layers_24)));
        tabLayout.addTab(tabLayout.newTab().setIcon(getResources().getDrawable(R.drawable.ic_outline_settings_24)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.selectTab(tabLayout.getTabAt(0));
        final com.indrul.hunter.Adapter.HomePagerAdapter adapter = new HomePagerAdapter( getSupportFragmentManager(),this, tabLayout.getTabCount()) ;
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                switch (tab.getPosition()){
                    case 0:tabLayout.getTabAt(0).setIcon(getResources().getDrawable(R.drawable.ic_baseline_home_24)); break;
                    case 1:tabLayout.getTabAt(1).setIcon(getResources().getDrawable(R.drawable.ic_baseline_notifications_24)); break;
                    case 2:tabLayout.getTabAt(2).setIcon(getResources().getDrawable(R.drawable.ic_baseline_add_circle_24)); break;
                    case 3:tabLayout.getTabAt(3).setIcon(getResources().getDrawable(R.drawable.ic_baseline_layers_24)); break;
                    case 4:tabLayout.getTabAt(4).setIcon(getResources().getDrawable(R.drawable.ic_baseline_settings_24)); break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:tabLayout.getTabAt(0).setIcon(getResources().getDrawable(R.drawable.ic_outline_home_24)); break;
                    case 1:tabLayout.getTabAt(1).setIcon(getResources().getDrawable(R.drawable.ic_baseline_notifications_none_24)); break;
                    case 2:tabLayout.getTabAt(2).setIcon(getResources().getDrawable(R.drawable.ic_baseline_add_circle_outline_24)); break;
                    case 3:tabLayout.getTabAt(3).setIcon(getResources().getDrawable(R.drawable.ic_outline_layers_24)); break;
                    case 4:tabLayout.getTabAt(4).setIcon(getResources().getDrawable(R.drawable.ic_outline_settings_24)); break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    void getservices() {
        Observable.create(emitter -> {
                    OkHttpClient client = new OkHttpClient().newBuilder()
                            .build();
                    Request request = new Request.Builder()
                            .url("https://the-green-hat.com/hunter/api/v1/en/services?page=1")
                            .method("GET", null)
                            .addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvdGhlLWdyZWVuLWhhdC5jb21cL2h1bnRlclwvYXBpXC92MVwvZW5cL2xvZ2luIiwiaWF0IjoxNjAwNDEyMjI2LCJleHAiOjE2MDA0MTU4MjYsIm5iZiI6MTYwMDQxMjIyNiwianRpIjoicXQ2VHA2Z0hGQzNjUGdUbCIsInN1YiI6MSwicHJ2IjoiMjNiZDVjODk0OWY2MDBhZGIzOWU3MDFjNDAwODcyZGI3YTU5NzZmNyJ9.uhhdM6Rj9Nf_0j6ziEzrvZgUNYV-y3nMMAoo9u-Jl8Q")
                            .build();
                    try {
                        Response response = client.newCall(request).execute();
                        Log.e("asdf",response.body().string());
                    } catch (IllegalStateException e) {

                    }
                    emitter.onNext(1);
        }).subscribeOn(Schedulers.io()).doOnNext(c -> Log.e("Upstream", c + ""))
                .subscribe(a -> Log.e("downstream", a+"" ));
    }


}