package com.indrul.hunter.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.indrul.hunter.Adapter.CardAdapter;
import com.indrul.hunter.R;
import com.indrul.hunter.ViewModel.CartViewModel;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CheckOutActivity extends AppCompatActivity {

    @BindView(R.id.orderdetailsrecy)
    RecyclerView orderdetailsrecy;
    @BindView(R.id.cash)
    TextView cash;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.coupon)
    EditText coupon;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.discount)
    TextView discount;
    @BindView(R.id.total)
    TextView total;
    CartViewModel cartViewModel;
    int totalprice = 0;
    @BindView(R.id.checkout)
    CardView checkout;
    SharedPreferences sharedpreferences;
    String lng,lat,placeaddress,placename;
    String mealsname="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        /////////////////////////////////////
        ButterKnife.bind(this);
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setNavigationBarColor(this.getResources().getColor(R.color.homebagetabs));
        window.setStatusBarColor(this.getResources().getColor(R.color.homebagetabs));
        ///////////////////////////////////////////////
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            lat = bundle.getString("lat");
            lng = bundle.getString("lng");
            placeaddress = bundle.getString("placeAdress");
            placename = bundle.getString("placename");
        }
        orderdetailsrecy.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        orderdetailsrecy.setHasFixedSize(true);
        cartViewModel = ViewModelProviders.of(this).get(CartViewModel.class);
        cartViewModel.connectApi(this);
        cartViewModel.cardModelMutableLiveData.observe(this, cardModel -> {
            CardAdapter cardAdapter = new CardAdapter(CheckOutActivity.this, this, cardModel.getId(), cardModel.getQuantity(), cardModel.getProduct_id(), cardModel.getCart_id(), cardModel.getImage_path(), cardModel.getPrice(), cardModel.getKcal(), cardModel.getCategory_id(), cardModel.getTitle(), cardModel.getDescription());
            orderdetailsrecy.setAdapter(cardAdapter);
            for (int i = 0; i < cardModel.getPrice().size(); i++) {
                totalprice += Integer.parseInt(cardModel.getPrice().get(i)) * Integer.parseInt(cardModel.getQuantity().get(i));
                mealsname=mealsname+" \n "+"x"+cardModel.getQuantity()+" "+cardModel.getTitle().get(i);
            }
            Log.e("totaltotal", totalprice + "");
            price.setText(totalprice + " JOD");
            discount.setText("0 JOD");
            int i = Integer.parseInt(price.getText().toString().replace(" JOD", "")) + Integer.parseInt(discount.getText().toString().replace(" JOD", ""));
            total.setText(i + " JOD");
        });
        sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        address.setText(sharedpreferences.getString("Location", "unknown"));
        coupon.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
               /* OkHttpClient client = new OkHttpClient().newBuilder()
                        .build();
                MediaType mediaType = MediaType.parse("application/json");
                RequestBody body = RequestBody.create(mediaType, "{\r\n    \"code\":\""+charSequence+"\"\r\n}");
                Request request = new Request.Builder()
                        .url("https://the-green-hat.com/hunter/api/v1/en/promocodes/apply")
                        .method("POST", body)
                        .addHeader("Authorization", sharedpreferences.getString("access_token","0"))
                        .addHeader("Content-Type", "application/json")
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    if (response.isSuccessful()){

                    }else {

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        checkout.setOnClickListener(v->{
            checkout();
        });


    }

    public void finish(View view) {
        finish();
    }
    void  checkout(){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        JSONObject jsonObject=new JSONObject();

        try {
            jsonObject.put("deliver_address",sharedpreferences.getString("Location", "unknown"));
            jsonObject.put("deliver_lat",Double.parseDouble(sharedpreferences.getString("lat", "unknown")));
            //jsonObject.put("deliver_lat",0);
            jsonObject.put("deliver_lng",Double.parseDouble(sharedpreferences.getString("lng", "unknown")));
           // jsonObject.put("deliver_lng",0);
            jsonObject.put("pickup_address",placeaddress);
            jsonObject.put("pickup_lat",Double.parseDouble(lat));
            //jsonObject.put("pickup_lat",0);
            jsonObject.put("pickup_lng",Double.parseDouble(lng));
           // jsonObject.put("pickup_lng",0);
            jsonObject.put("description",mealsname);
            jsonObject.put("map_place_id","ChIJpV5W1Xo-WBQRNO55h1yCBJY");
            jsonObject.put("name",placename);
            jsonObject.put("reference","asd");
            Log.e("totalprice",totalprice+"  "+Double.parseDouble(sharedpreferences.getString("lat", "unknown"))+" "+Double.parseDouble(sharedpreferences.getString("lng", "unknown")));
            jsonObject.put("total_price_after_discount",Double.parseDouble(String.valueOf(totalprice)));
           // jsonObject.put("total_price_after_discount",4000);
        } catch (JSONException e) {
            e.printStackTrace();
        }
       RequestBody body = RequestBody.create(mediaType,jsonObject.toString());
        RequestBody body2 = RequestBody.create(mediaType, "" +
                "{\n\t\"deliver_address\": \"deliver Cairo Egypt\",\n " +
                "   \"deliver_lat\": 30.111333,\n  " +
                "  \"deliver_lng\":31.11133,\n " +
                "   \"pickup_address\": \"pickup Cairo Egypt\",\n" +
                "    \"pickup_lat\": 30.22333,\n  " +
                "  \"pickup_lng\":31.22333,\n  " +
                "  \"description\": \"custom order description\",\n " +
                "   \n    \"map_place_id\": \"ChIJpV5W1Xo-WBQRNO55h1yCBJY\",\n " +
                "   \"name\":\"دجاج تكا\",\n  " +
                "  \"reference\":\"CkQ0AAAAnkfaR0kLV_idOx3TZ8DaF9z3QD4EaOGM-t_7E-SragdBkcDyRcW9SXwiQ2zfYK53NCGhtoyEWQDgf3wmQnDsYRIQq0KScjmLaaiMp-4GCNwAHRoUDGiaNak9IBJQiO0XTlMLVzp2zQA\",\n   " +
                " \"total_price_after_discount\":\"2000\"\n}");
        SharedPreferences sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        Request request = new Request.Builder()
                .url("https://the-green-hat.com/hunter/api/v1/en/orders/google-map-order")
                //.url("https://the-green-hat.com/hunter/api/v1/en/orders/custom-order")
                .method("POST", body)
                .addHeader("Authorization", sharedpreferences.getString("access_token","0"))
                .addHeader("Content-Type", "application/json")
                .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                    Log.e("postpost",e.getMessage());
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                    Log.e("postpost",response.body().string());
                }
            });

    }
}