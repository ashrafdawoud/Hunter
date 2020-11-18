package com.indrul.hunter.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.indrul.hunter.Adapter.CategoryAdapter;
import com.indrul.hunter.Adapter.ProductsAdapter;
import com.indrul.hunter.R;
import com.indrul.hunter.ViewModel.PlacesViewModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlacesDetailsMealsActivity extends AppCompatActivity implements CategoryAdapter.Choosecategory {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.place_name)
    ImageView placeName;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.backbtn)
    ImageView backbtn;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.category)
    RecyclerView category;
    @BindView(R.id.scroll)
    NestedScrollView scroll;
    PlacesViewModel placesViewModel;
    String id, place, disc;
    int position;
    @BindView(R.id.products)
    RecyclerView productsrecy;
    @BindView(R.id.placet)
    TextView placet;
    String imaget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_meals_details);
        /////////////////////////////////////

        ButterKnife.bind(this);
        Window window = this.getWindow();
        // window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setNavigationBarColor(this.getResources().getColor(R.color.homebagetabs));
        // window.setStatusBarColor(this.getResources().getColor(R.color.homebagetabs));

        ///////////////////////////////////////////////
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getString("id");
            place = bundle.getString("place");
            imaget = bundle.getString("image");
            disc = bundle.getString("disc");
            position = bundle.getInt("position");
            placet.setText(place);
            description.setText(disc);
            Log.e("image123",imaget);
            Picasso.get().load(imaget).into(image, new Callback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onError(Exception e) {
                image.setImageDrawable(getResources().getDrawable(R.drawable.burger));
                }
            });


        }


        category.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        category.setHasFixedSize(true);
        productsrecy.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        productsrecy.setHasFixedSize(true);
        placesViewModel = ViewModelProviders.of(this).get(PlacesViewModel.class);
        placesViewModel.connectApi(this, id, position);
        placesViewModel.placesModelMutableLiveData.observe(this, placesModel -> {
            CategoryAdapter categoryAdapter = new CategoryAdapter(this, this, id, placesModel.getPlace_ida(), placesModel.getPlace_image_patha(), placesModel.getPlace_lata(), placesModel.getPlace_lnga(), placesModel.getPlace_addressa(), placesModel.getPlace_promoteda(), placesModel.getPlace_image_path_vala(), placesModel.getPlace_namea(), placesModel.getPlace_desca(), placesModel.getCategoriesa(), placesModel.getCategories_ida(), placesModel.getCategories_created_ata(), placesModel.getCategories_namea(), placesModel.getCategories_productsa(), placesModel.getProductsString());
            category.setAdapter(categoryAdapter);
        });


    }

    ArrayList<String> products_ida = new ArrayList<>();
    ArrayList<String> products_image_patha = new ArrayList<>();
    ArrayList<String> products_pricea = new ArrayList<>();
    ArrayList<String> products_kcala = new ArrayList<>();
    ArrayList<String> products_service_ida = new ArrayList<>();
    ArrayList<String> products_created_ata = new ArrayList<>();
    ArrayList<String> products_image_path_vala = new ArrayList<>();
    ArrayList<String> products_titlea = new ArrayList<>();
    ArrayList<String> products_descriptiona = new ArrayList<>();
    private final static String products_id = "id";
    private final static String products_image_path = "image_path";
    private final static String products_price = "price";
    private final static String products_kcal = "kcal";
    private final static String products_service_id = "service_id";
    private final static String products_category_id = "category_id";
    private final static String products_created_at = "created_at";
    private final static String products_image_path_val = "image_path_val";
    private final static String products_title = "title";
    private final static String products_description = "description";


    @Override
    public void products(String product, ArrayList<String> place_ida, ArrayList<String> place_image_patha, ArrayList<String> place_lata, ArrayList<String> place_lnga, ArrayList<String> place_addressa, ArrayList<String> place_promoteda, ArrayList<String> place_image_path_vala, ArrayList<String> place_namea, ArrayList<String> place_desca, ArrayList<String> categoriesa, ArrayList<String> categories_ida, ArrayList<String> categories_created_ata, ArrayList<String> categories_namea) {
        products_ida.clear();
        products_image_patha.clear();
        products_pricea.clear();
        products_kcala.clear();
        products_service_ida.clear();
        products_created_ata.clear();
        products_image_path_vala.clear();
        products_titlea.clear();
        products_descriptiona.clear();
        try {
            JSONArray products = new JSONArray(product);
            for (int h = 0; h < products.length(); h++) {
                JSONObject prorecord = products.getJSONObject(h);
                products_ida.add(prorecord.optString(products_id));
                products_image_patha.add(prorecord.optString(products_image_path));
                products_pricea.add(prorecord.optString(products_price));
                products_kcala.add(prorecord.optString(products_kcal));
                products_service_ida.add(prorecord.optString(products_service_id));
                products_created_ata.add(prorecord.optString(products_created_at));
                products_image_path_vala.add(prorecord.optString(products_image_path_val));
                products_titlea.add(prorecord.optString(products_title));
                products_descriptiona.add(prorecord.optString(products_description));
                Log.e("produc1", prorecord.optString(products_title));
            }
            ProductsAdapter productsAdapter = new ProductsAdapter(PlacesDetailsMealsActivity.this,position,place_ida, place_image_patha, place_lata, place_lnga, place_addressa, place_promoteda, place_image_path_vala, place_namea, place_desca, categoriesa, categories_ida, categories_created_ata, categories_namea, null, products_ida, products_image_patha, products_pricea, products_kcala, products_service_ida, products_created_ata, products_image_path_vala, products_titlea, products_descriptiona);
            productsrecy.setAdapter(productsAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void finish(View view) {
        finish();
    }
}