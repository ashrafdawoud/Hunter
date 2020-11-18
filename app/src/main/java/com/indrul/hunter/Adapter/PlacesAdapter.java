package com.indrul.hunter.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indrul.hunter.R;
import com.indrul.hunter.view.PlacesDetailsMealsActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.ViewHolder> {
    ArrayList<String> place_ida=new ArrayList<>();
    ArrayList<String> place_image_patha=new ArrayList<>();
    ArrayList<String> place_lata=new ArrayList<>();
    ArrayList<String> place_lnga=new ArrayList<>();
    ArrayList<String> place_addressa=new ArrayList<>();
    ArrayList<String> place_promoteda=new ArrayList<>();
    ArrayList<String> place_image_path_vala=new ArrayList<>();
    ArrayList<String> place_namea=new ArrayList<>();
    ArrayList<String> place_desca=new ArrayList<>();
    ArrayList<String> categoriesa=new ArrayList<>();
    ArrayList<String> categories_ida=new ArrayList<>();
    ArrayList<String> categories_created_ata=new ArrayList<>();
    ArrayList<String> categories_namea=new ArrayList<>();
    ArrayList<String> categories_productsa=new ArrayList<>();
   /* ArrayList<String> products_ida=new ArrayList<>();
    ArrayList<String> products_image_patha=new ArrayList<>();
    ArrayList<String> products_pricea=new ArrayList<>();
    ArrayList<String> products_kcala=new ArrayList<>();
    ArrayList<String> products_service_ida=new ArrayList<>();
    ArrayList<String> products_created_ata=new ArrayList<>();
    ArrayList<String> products_image_path_vala=new ArrayList<>();
    ArrayList<String> products_titlea=new ArrayList<>();
    ArrayList<String> products_descriptiona=new ArrayList<>();*/
    ArrayList<String> productSrting=new ArrayList<>();
    Context context;
String id;
    public PlacesAdapter(ArrayList<String> place_ida, ArrayList<String> place_image_patha, ArrayList<String> place_lata, ArrayList<String> place_lnga, ArrayList<String> place_addressa, ArrayList<String> place_promoteda, ArrayList<String> place_image_path_vala, ArrayList<String> place_namea, ArrayList<String> place_desca, ArrayList<String> categoriesa, ArrayList<String> categories_ida, ArrayList<String> categories_created_ata, ArrayList<String> categories_namea, ArrayList<String> categories_productsa, ArrayList<String> productSrting, Context context, String id) {
        this.place_ida = place_ida;
        this.place_image_patha = place_image_patha;
        this.place_lata = place_lata;
        this.place_lnga = place_lnga;
        this.place_addressa = place_addressa;
        this.place_promoteda = place_promoteda;
        this.place_image_path_vala = place_image_path_vala;
        this.place_namea = place_namea;
        this.place_desca = place_desca;
        this.categoriesa = categoriesa;
        this.categories_ida = categories_ida;
        this.categories_created_ata = categories_created_ata;
        this.categories_namea = categories_namea;
        this.categories_productsa = categories_productsa;
        this.productSrting = productSrting;
        this.context = context;
        this.id = id;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from (parent.getContext ()).inflate (R.layout.places_item,parent,false);
        ViewHolder vh=new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SharedPreferences sharedpreferences = context.getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        holder.place.setText(place_namea.get(position));
        holder.discription.setText(place_desca.get(position));
        int distance=(int)distance(place_lata.get(position),place_lnga.get(position),sharedpreferences.getString("lat","0"),sharedpreferences.getString("lng","0"));
        String distances= distance+" km";
        holder.km.setText(distances);
       if (place_promoteda.get(position).equals("1"))
       { holder.promoted.setText("promoted");
       holder.promoted.setVisibility(View.VISIBLE);}
       else holder.promoted.setVisibility(View.GONE);
        Picasso.get().load(place_image_path_vala.get(position)).into(holder.image);
        holder.ordernow.setOnClickListener(view -> {
            Intent intent=new Intent(context, PlacesDetailsMealsActivity.class);
            intent.putExtra("id",id);
            intent.putExtra("position",position);
            intent.putExtra("place",place_namea.get(position));
            intent.putExtra("disc",place_desca.get(position));
            intent.putExtra("image",place_image_path_vala.get(position));
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return place_ida.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView place,discription,km,promoted,ordernow;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            place=itemView.findViewById(R.id.placesname);
            discription=itemView.findViewById(R.id.placedisc);
            km=itemView.findViewById(R.id.km);
            promoted=itemView.findViewById(R.id.promoted);
            ordernow=itemView.findViewById(R.id.ordernow);
            image=itemView.findViewById(R.id.image);
        }
    }
    private double distance(String lat11, String lon11, String lat22, String lon22) {
        double lat1=Double.parseDouble(lat11);
        double lon1=Double.parseDouble(lon11);
        double lat2=Double.parseDouble(lat22);
        double lon2=Double.parseDouble(lon22);

        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1))
                * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1))
                * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
