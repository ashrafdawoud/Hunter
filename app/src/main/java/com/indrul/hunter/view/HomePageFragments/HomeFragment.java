package com.indrul.hunter.view.HomePageFragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.indrul.hunter.Adapter.NearstPlacedAdapter;
import com.indrul.hunter.Adapter.ServicesAdapter;
import com.indrul.hunter.R;
import com.indrul.hunter.ViewModel.NearsetPlacesViewModel;
import com.indrul.hunter.ViewModel.ServicesViewModel;
import com.indrul.hunter.view.ChatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeFragment extends Fragment {
    @BindView(R.id.nearestplacesrecy)
    RecyclerView nearestplacesrecy;
    @BindView(R.id.servicesRecy)
    RecyclerView servicesRecy;
    ServicesViewModel servicesViewModel;
    ServicesAdapter servicesAdapter;
    @BindView(R.id.my_view1)
    CardView myView1;
    @BindView(R.id.my_view2)
    CardView myView2;
    @BindView(R.id.mockoutlinear)
    LinearLayout mockoutlinear;
    NearsetPlacesViewModel nearsetPlacesViewModel;
    @BindView(R.id.my_view3)
    LinearLayout myView3;
    @BindView(R.id.my_view8)
    LinearLayout myView8;
    @BindView(R.id.mockoutlinear2)
    LinearLayout mockoutlinear2;
    @BindView(R.id.chat)
    ImageView chat;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        RecyclrviewSetup();
        //  shimmerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        //  shimmerRecyclerView.showShimmerAdapter();
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.mockanim);
        myView1.startAnimation(animation);
        myView2.startAnimation(animation);
        myView3.startAnimation(animation);
        myView8.startAnimation(animation);

        servicesViewModel = ViewModelProviders.of(this).get(ServicesViewModel.class);
        nearsetPlacesViewModel = ViewModelProviders.of(this).get(NearsetPlacesViewModel.class);
        servicesViewModel.getservices();
        nearsetPlacesViewModel.connectApi(getActivity());
        servicesViewModel.servicesLiveData.observe(this, servicesModel -> {
            Activity thisActivity = (Activity) getActivity();
            Log.e("ashraf", String.valueOf(servicesModel.getImage_path_val()) + " " + servicesModel.getTitle());
            servicesAdapter = new ServicesAdapter(getActivity(), thisActivity, servicesModel.getImagePath(), servicesModel.getType(), servicesModel.getImage_path_val(), servicesModel.getTitle(), servicesModel.getId());
            servicesRecy.setAdapter(servicesAdapter);
            mockoutlinear.setVisibility(View.GONE);
            servicesRecy.setVisibility(View.VISIBLE);
        });
        nearsetPlacesViewModel.nearestModelMutableLiveData.observe(this, nearestModel -> {
            NearstPlacedAdapter nearstPlacedAdapter = new NearstPlacedAdapter(getActivity(), nearestModel.getLat(), nearestModel.getLng(), nearestModel.getAddress_val(), nearestModel.getName(), nearestModel.getImage_path_val(), nearestModel.getMap_place_id(), nearestModel.getPromoted(), nearestModel.getOrdering(), nearestModel.getDistance(), nearestModel.getImage_path());
            nearestplacesrecy.setAdapter(nearstPlacedAdapter);
            mockoutlinear2.setVisibility(View.GONE);
            nearestplacesrecy.setVisibility(View.VISIBLE);
        });
        chat.setOnClickListener(v->{
            startActivity(new Intent(getActivity(), ChatActivity.class));
        });

        return view;
    }

    void RecyclrviewSetup() {
        nearestplacesrecy.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        nearestplacesrecy.setHasFixedSize(true);
        ////////////
        servicesRecy.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        servicesRecy.setHasFixedSize(true);
    }
}