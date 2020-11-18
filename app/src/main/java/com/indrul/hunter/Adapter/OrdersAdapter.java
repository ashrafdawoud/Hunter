package com.indrul.hunter.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indrul.hunter.OrderDetailsActivity;
import com.indrul.hunter.R;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolder> {
    Context context;
    Activity activity;
    ArrayList<String> id =new ArrayList<>();
    ArrayList<String>number =new ArrayList<>();
    ArrayList<String>deliver_lat =new ArrayList<>();
    ArrayList<String>deliver_lng =new ArrayList<>();
    ArrayList<String>deliver_address =new ArrayList<>();
    ArrayList<String>pickup_lat =new ArrayList<>();
    ArrayList<String>pickup_lng =new ArrayList<>();
    ArrayList<String>pickup_address =new ArrayList<>();
    ArrayList<String>description =new ArrayList<>();
    ArrayList<String>name =new ArrayList<>();
    ArrayList<String>total_price =new ArrayList<>();
    ArrayList<String>discount_cost =new ArrayList<>();
    ArrayList<String>total_price_after_discount =new ArrayList<>();
    ArrayList<String>payment_type =new ArrayList<>();
    ArrayList<String>status =new ArrayList<>();
    ArrayList<String>created_at =new ArrayList<>();
    ArrayList<String>image_path_val =new ArrayList<>();

    public OrdersAdapter(Context context, Activity activity, ArrayList<String> id, ArrayList<String> number, ArrayList<String> deliver_lat, ArrayList<String> deliver_lng, ArrayList<String> deliver_address, ArrayList<String> pickup_lat, ArrayList<String> pickup_lng, ArrayList<String> pickup_address, ArrayList<String> description, ArrayList<String> name, ArrayList<String> total_price, ArrayList<String> discount_cost, ArrayList<String> total_price_after_discount, ArrayList<String> payment_type, ArrayList<String> status, ArrayList<String> created_at, ArrayList<String> image_path_val) {
        this.context = context;
        this.activity = activity;
        this.id = id;
        this.number = number;
        this.deliver_lat = deliver_lat;
        this.deliver_lng = deliver_lng;
        this.deliver_address = deliver_address;
        this.pickup_lat = pickup_lat;
        this.pickup_lng = pickup_lng;
        this.pickup_address = pickup_address;
        this.description = description;
        this.name = name;
        this.total_price = total_price;
        this.discount_cost = discount_cost;
        this.total_price_after_discount = total_price_after_discount;
        this.payment_type = payment_type;
        this.status = status;
        this.created_at = created_at;
        this.image_path_val = image_path_val;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from (parent.getContext ()).inflate (R.layout.orders_item,parent,false);
        ViewHolder vh=new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.number.setText(number.get(position));
        holder.price.setText(total_price_after_discount.get(position));
        holder.date.setText(created_at.get(position).substring(0,10));
        holder. itemView.setOnClickListener(i->{
            Intent intent=new Intent(context, OrderDetailsActivity.class);
            intent.putExtra("description",description.get(position));
            intent.putExtra("price",total_price_after_discount.get(position));
            intent.putExtra("placename",name.get(position));
            intent.putExtra("image",image_path_val.get(position));
            intent.putExtra("date",created_at.get(position).substring(0,10));
            context.startActivity(intent);
            activity.overridePendingTransition(R.anim.slide_out_bottom,R.anim.slide_in_bottom);
        });


    }

    @Override
    public int getItemCount() {
        return number.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView number,price,date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            number=itemView.findViewById(R.id.number);
            price=itemView.findViewById(R.id.price);
            date=itemView.findViewById(R.id.date);

        }
    }
}
