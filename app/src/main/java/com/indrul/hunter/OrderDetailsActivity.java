package com.indrul.hunter;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderDetailsActivity extends AppCompatActivity {

    @BindView(R.id.places)
    TextView places;
    @BindView(R.id.clock)
    ImageView clock;
    @BindView(R.id.km)
    TextView km;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.image)
    ImageView images;
    @BindView(R.id.discription)
    TextView discription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        ButterKnife.bind(this);
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setNavigationBarColor(this.getResources().getColor(R.color.homebagetabs));
        window.setStatusBarColor(this.getResources().getColor(R.color.homebagetabs));
        ////////////////////////////////////////////////////////////////
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String description = bundle.getString("description");
            String price = bundle.getString("price");
            String name = bundle.getString("placename");
            String image = bundle.getString("image");
            String date2 = bundle.getString("date");
            places.setText(name);
            discription.setText(description);
            km.setText(price);
            date.setText(date2);
            if (image != null) Picasso.get().load(image).into(images);
        }
    }

    public void finish(View view) {
        finish();
    }
}