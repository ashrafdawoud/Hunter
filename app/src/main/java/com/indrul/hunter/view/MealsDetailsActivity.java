package com.indrul.hunter.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.indrul.hunter.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MealsDetailsActivity extends AppCompatActivity {


    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.meal_name)
    ImageView mealName;
    @BindView(R.id.backbtn)
    ImageView backbtn;
    @BindView(R.id.placet)
    TextView placet;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.mealname)
    TextView mealname;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.discountnumber)
    TextView discountnumber;
    @BindView(R.id.add)
    ImageView add;
    @BindView(R.id.counter)
    TextView counter;
    @BindView(R.id.min)
    ImageView min;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.addtocart)
    CardView addtocart;
    @BindView(R.id.checkout)
    CardView checkout;
    @BindView(R.id.scroll)
    NestedScrollView scroll;
    String place_ida,place_image_patha,place_lata,place_lnga,place_addressa,place_promoteda,place_image_path_vala,
            place_namea,place_desca,products_ida,products_image_patha,products_pricea,products_kcala,products_service_ida,products_created_ata,
            products_image_path_vala,products_titlea,products_descriptiona,category_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_places_details_meals);
        /////////////////////////////////////
        ButterKnife.bind(this);
        Window window = this.getWindow();
        window.setNavigationBarColor(this.getResources().getColor(R.color.homebagetabs));
        ///////////////////////////////////////////////
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            place_ida=bundle.getString("place_ida");
            place_image_patha=bundle.getString("place_image_patha");
            place_lata=bundle.getString("place_lata");
            place_lnga=bundle.getString("place_lnga");
            place_addressa=bundle.getString("place_addressa");
            place_promoteda=bundle.getString("place_promoteda");
            place_image_path_vala=bundle.getString("place_image_path_vala");
            place_namea=bundle.getString("place_namea");
            place_desca=bundle.getString("place_desca");
            products_ida=bundle.getString("products_ida");
            products_image_patha=bundle.getString("products_image_patha");
            products_pricea=bundle.getString("products_pricea");
            products_kcala=bundle.getString("products_kcala");
            products_service_ida=bundle.getString("products_service_ida");
            products_created_ata=bundle.getString("products_created_ata");
            products_image_path_vala=bundle.getString("products_image_path_vala");
            products_titlea=bundle.getString("products_titlea");
            products_descriptiona=bundle.getString("products_descriptiona");
            category_id=bundle.getString("category_id");
        }
        Picasso.get().load(products_image_path_vala).into(image, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {
                image.setImageDrawable(getResources().getDrawable(R.drawable.burger));
            }
        });
        placet.setText(products_titlea);
        mealname.setText(products_titlea);
        description.setText(products_descriptiona);
        price.setText(products_pricea+" JOD");
        add.setOnClickListener(view -> {
            String s=counter.getText().toString();
            int i= Integer.parseInt(s);
            i+=1;
            Log.e("iiiii",i+"");
            counter.setText("");
            counter.setText(i+"");
            price.setText(String.valueOf(i*Integer.parseInt(products_pricea))+" JOD");
        });
        min.setOnClickListener(view -> {
            String s=counter.getText().toString();
            int i= Integer.parseInt(s);
            i-=1;
            Log.e("iiiii",i+"");
            counter.setText("");
            counter.setText(i+"");
            price.setText(String.valueOf(i*Integer.parseInt(products_pricea))+" JOD");
        });
        addtocart.setOnClickListener(view -> {
            postCart();
        });
        checkout.setOnClickListener(v->{
            Intent intent=new Intent(this,CheckOutActivity.class);
            intent.putExtra("lng",place_lnga);
            intent.putExtra("lat",place_lata);
            intent.putExtra("placeAdress",place_addressa);
            intent.putExtra("placename",place_namea);
            startActivity(intent);
        });

    }

    public void finish(View view) {
        finish();
    }
    void postCart(){
        SharedPreferences sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject Product = new JSONObject();

        try {
            Product.put("product_id", products_ida);
            Product.put("quantity", counter.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(mediaType,
                Product.toString()
        );
        //RequestBody body = RequestBody.create(mediaType, "{\n\t\"product_id\": 1,\n\t\"quantity\": 4\n}");
        Request request = new Request.Builder()
                .url("https://the-green-hat.com/hunter/api/v1/en/cart/add-item")
                .method("POST", body)
                .addHeader("Authorization", sharedpreferences.getString("access_token","0"))
                .build();
        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("newcallhttpcart",e.getMessage());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MealsDetailsActivity.this,"Fail try again",Toast.LENGTH_LONG).show();
                    }
                });
                postCart();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful ( )) {
                    String respons = response.body ( ).string ( );
                    Log.e("newcallhttpcart",respons);
                   runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MealsDetailsActivity.this,"Sucsess",Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }
}