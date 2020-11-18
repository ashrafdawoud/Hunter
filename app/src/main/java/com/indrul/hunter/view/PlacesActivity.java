package com.indrul.hunter.view;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.indrul.hunter.Adapter.NearstPlacedAdapter;
import com.indrul.hunter.Adapter.PlacesAdapter;
import com.indrul.hunter.R;
import com.indrul.hunter.ViewModel.PlacesViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PlacesActivity extends AppCompatActivity {

    @BindView(R.id.placesRecy)
    RecyclerView placesRecy;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.header)
    RelativeLayout header;
    PlacesViewModel placesViewModel;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        /////////////////////////////////////
        ButterKnife.bind(this);
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setNavigationBarColor(this.getResources().getColor(R.color.homebagetabs));
        window.setStatusBarColor(this.getResources().getColor(R.color.homebagetabs));
        ///////////////////////////////////////////////
        ButterKnife.bind(this);
        Bundle bundle=getIntent().getExtras();
        if (bundle!=null){
            id=bundle.getString("id");
        }
        placesRecy.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        placesRecy.setHasFixedSize(true);
        placesViewModel= ViewModelProviders.of(this).get(PlacesViewModel.class);
        placesViewModel.connectApi(this,id,-1);
        placesViewModel.placesModelMutableLiveData.observe(this,placesModel -> {
            Log.e("placesMod",placesModel.getPlace_ida().get(0));
            PlacesAdapter placesAdapter = new PlacesAdapter( placesModel.getPlace_ida(),placesModel.getPlace_image_patha(),placesModel.getPlace_lata(),placesModel.getPlace_lnga(),placesModel.getPlace_addressa(),placesModel.getPlace_promoteda(),placesModel.getPlace_image_path_vala(),placesModel.getPlace_namea(),placesModel.getPlace_desca(),placesModel.getCategoriesa(),placesModel.getCategories_ida(),placesModel.getCategories_created_ata(),placesModel.getCategories_namea(),placesModel.getCategories_productsa(),placesModel.getProductsString(),this,id);
            placesRecy.setAdapter(placesAdapter);
        });

    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}