package com.indrul.hunter.Adapter;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indrul.hunter.R;

import java.io.IOException;
import java.util.ArrayList;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewModel> {
    Activity activity;
    Context context;
    ArrayList<String> id=new ArrayList<>();
    ArrayList<String>quantity=new ArrayList<>();
    ArrayList<String>product_id=new ArrayList<>();
    ArrayList<String>cart_id=new ArrayList<>();
    ArrayList<String>image_path=new ArrayList<>();
    ArrayList<String>price=new ArrayList<>();
    ArrayList<String>kcal=new ArrayList<>();
    ArrayList<String>category_id=new ArrayList<>();
    ArrayList<String>title=new ArrayList<>();
    ArrayList<String>description=new ArrayList<>();

    public CardAdapter(Activity activity,Context context, ArrayList<String> id, ArrayList<String> quantity, ArrayList<String> product_id, ArrayList<String> cart_id, ArrayList<String> image_path, ArrayList<String> price, ArrayList<String> kcal, ArrayList<String> category_id, ArrayList<String> title, ArrayList<String> description) {
        this.activity=activity;
        this.context = context;
        this.id = id;
        this.quantity = quantity;
        this.product_id = product_id;
        this.cart_id = cart_id;
        this.image_path = image_path;
        this.price = price;
        this.kcal = kcal;
        this.category_id = category_id;
        this.title = title;
        this.description = description;
    }

    @NonNull
    @Override
    public ViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from (parent.getContext ()).inflate (R.layout.card_item,parent,false);
        ViewModel vh=new ViewModel(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewModel holder, int position) {
        holder.number.setText(quantity.get(position));
        holder.title.setText(title.get(position));
        holder.price.setText(price.get(position));
        holder.close.setOnClickListener(v->{
            deleteitem(id.get(position),holder);
            notifyDataSetChanged();
        });


    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class ViewModel extends RecyclerView.ViewHolder {
        TextView number,title,price;
        ImageView close;
        public ViewModel(@NonNull View itemView) {
            super(itemView);
            number=itemView.findViewById(R.id.number);
            title=itemView.findViewById(R.id.title);
            price=itemView.findViewById(R.id.price);
            close=itemView.findViewById(R.id.delete);
        }
    }
    void deleteitem(String id,ViewModel holder){
        SharedPreferences sharedpreferences = context.getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@io.reactivex.rxjava3.annotations.NonNull ObservableEmitter<Object> emitter) throws Throwable {
                OkHttpClient client = new OkHttpClient().newBuilder()
                        .build();
                MediaType mediaType = MediaType.parse("application/json");
                RequestBody body = RequestBody.create(mediaType, "{\n\t\"item_id\":"+id+"\n}");
                Request request = new Request.Builder()
                        .url("https://the-green-hat.com/hunter/api/v1/en/cart/remove-item")
                        .method("DELETE", body)
                        .addHeader("Authorization", sharedpreferences.getString("access_token","0"))
                        .addHeader("Content-Type", "application/json")
                        .build();
                try {
                    Response response = client.newCall(request).execute();
                    if (response.isSuccessful()){
                        activity.runOnUiThread(() -> {
                            Toast.makeText(context,"deleted",Toast.LENGTH_LONG).show();
                        });
                        holder.itemView.setVisibility(View.GONE);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).subscribeOn(Schedulers.io()).subscribe(v->{},throwable -> {activity.runOnUiThread(() -> {
            Toast.makeText(context,throwable.getMessage(),Toast.LENGTH_LONG).show();
        });});

    }
}
