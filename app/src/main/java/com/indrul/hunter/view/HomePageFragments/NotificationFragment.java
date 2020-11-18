package com.indrul.hunter.view.HomePageFragments;

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

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.indrul.hunter.Adapter.NoticationAdapter;
import com.indrul.hunter.R;
import com.indrul.hunter.ViewModel.NotificationViewModel;
import com.indrul.hunter.view.ChatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NotificationFragment extends Fragment {

    @BindView(R.id.notificationrecy)
    RecyclerView notificationrecy;
    @BindView(R.id.mockoutlinear3)
    LinearLayout mockoutlinear3;
    NotificationViewModel notyViewModell;
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
    @BindView(R.id.chat)
    ImageView chat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        ButterKnife.bind(this, view);
        notificationrecy.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        notificationrecy.setHasFixedSize(true);
        ///////////////////////////////////////////////////
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.mockanim);
        mockoutlinear3.startAnimation(animation);
        chat.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), ChatActivity.class));
        });
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            notyViewModell = ViewModelProviders.of(this).get(NotificationViewModel.class);
            notyViewModell.connectApi(getActivity());
            notyViewModell.modelMutableLiveData.observe(this, notyModel -> {
                Log.e("asdfg", "asdf");
                NoticationAdapter placesAdapter = new NoticationAdapter(notyModel.getId(), notyModel.getType(), notyModel.getDate_time(), notyModel.getDate_human(), notyModel.getTitle(), notyModel.getMessage());
                notificationrecy.setAdapter(placesAdapter);
                notificationrecy.setVisibility(View.VISIBLE);
                mockoutlinear3.setVisibility(View.GONE);
                myView1.setVisibility(View.GONE);
                myView2.setVisibility(View.GONE);
                myView3.setVisibility(View.GONE);
                myView4.setVisibility(View.GONE);
                myView5.setVisibility(View.GONE);

            });

        }
    }
}