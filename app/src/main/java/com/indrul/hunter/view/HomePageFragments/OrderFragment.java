package com.indrul.hunter.view.HomePageFragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.indrul.hunter.Adapter.OrdersAdapter;
import com.indrul.hunter.R;
import com.indrul.hunter.ViewModel.OrdersViewModel;
import com.indrul.hunter.view.ChatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class OrderFragment extends Fragment {
    @BindView(R.id.ordersRecy)
    RecyclerView ordersRecy;
    @BindView(R.id.my_view1)
    LinearLayout myView1;
    @BindView(R.id.my_view2)
    LinearLayout myView2;
    @BindView(R.id.my_view3)
    LinearLayout myView3;
    @BindView(R.id.my_view4)
    LinearLayout myView4;
    @BindView(R.id.my_view5)
    LinearLayout myView5;
    @BindView(R.id.mockoutlinear3)
    LinearLayout mockoutlinear3;
    OrdersViewModel ordersViewModel;
    @BindView(R.id.chat)
    ImageView chat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        ButterKnife.bind(this, view);
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.mockanim);
        mockoutlinear3.startAnimation(animation);
        myView1.setVisibility(View.VISIBLE);
        myView2.setVisibility(View.VISIBLE);
        myView3.setVisibility(View.VISIBLE);
        myView4.setVisibility(View.VISIBLE);
        myView5.setVisibility(View.VISIBLE);
        mockoutlinear3.setVisibility(View.VISIBLE);
        ordersViewModel = ViewModelProviders.of(OrderFragment.this).get(OrdersViewModel.class);
        Activity thisActivity2 = (Activity) getActivity();
        ordersViewModel.connectApi(getActivity());
        ordersRecy.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        ordersRecy.setHasFixedSize(true);
        ordersViewModel.ordersViewModelMutableLiveData.observe(this, ordersModel -> {
            Activity thisActivity = (Activity) getActivity();
            OrdersAdapter ordersAdapter = new OrdersAdapter(getActivity(), thisActivity, ordersModel.getId(), ordersModel.getNumber(), ordersModel.getDeliver_lat(), ordersModel.getDeliver_lng(), ordersModel.getDeliver_address(), ordersModel.getPickup_lat(), ordersModel.getPickup_lng(), ordersModel.getPickup_address(), ordersModel.getDescription(), ordersModel.getName(), ordersModel.getTotal_price(), ordersModel.getDiscount_cost(), ordersModel.getTotal_price_after_discount(), ordersModel.getPayment_type(), ordersModel.getStatus(), ordersModel.getCreated_at(), ordersModel.getImage_path_val());
            ordersRecy.setAdapter(ordersAdapter);
            mockoutlinear3.setVisibility(View.GONE);
            ordersRecy.setVisibility(View.VISIBLE);
            myView1.setVisibility(View.GONE);
            myView2.setVisibility(View.GONE);
            myView3.setVisibility(View.GONE);
            myView4.setVisibility(View.GONE);
            myView5.setVisibility(View.GONE);
        });
        chat.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), ChatActivity.class));
        });
        return view;
    }
}