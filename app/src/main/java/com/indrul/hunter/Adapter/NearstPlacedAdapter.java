package com.indrul.hunter.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indrul.hunter.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NearstPlacedAdapter extends RecyclerView.Adapter<NearstPlacedAdapter.ViewHolder> {
    ArrayList<String> lat=new ArrayList<>();
    ArrayList<String> lng=new ArrayList<>();
    ArrayList<String> address_val=new ArrayList<>();
    ArrayList<String> name=new ArrayList<>();
    ArrayList<String> image_path_val=new ArrayList<>();
    ArrayList<String> map_place_id=new ArrayList<>();
    ArrayList<String> promoted=new ArrayList<>();
    ArrayList<String> ordering=new ArrayList<>();
    ArrayList<String> distance=new ArrayList<>();
    ArrayList<String> image_path=new ArrayList<>();
    Context context;

    public NearstPlacedAdapter(Context context,ArrayList<String> lat, ArrayList<String> lng, ArrayList<String> address_val, ArrayList<String> name, ArrayList<String> image_path_val, ArrayList<String> map_place_id, ArrayList<String> promoted, ArrayList<String> ordering, ArrayList<String> distance, ArrayList<String> image_path) {
        this.lat = lat;
        this.lng = lng;
        this.address_val = address_val;
        this.name = name;
        this.image_path_val = image_path_val;
        this.map_place_id = map_place_id;
        this.promoted = promoted;
        this.ordering = ordering;
        this.distance = distance;
        this.image_path = image_path;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from (parent.getContext ()).inflate (R.layout.nearstplace_item,parent,false);
        ViewHolder vh=new ViewHolder (view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (image_path_val.size()!=0&&image_path_val!=null&&image_path_val.get(position)!="null")
            Picasso.get().load(image_path_val.get(position)).into(holder.placesimage);
        else
        {holder.placesimage.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_map_location));
            Log.e("imagecalled","called");
        }
        holder.places.setText(name.get(position));
        holder.distance.setText(distance.get(position).substring(0, 4)+" KM");

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView places,distance;
        ImageView placesimage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            places=itemView.findViewById(R.id.places);
            distance=itemView.findViewById(R.id.distance);
            placesimage=itemView.findViewById(R.id.placeimage);
        }
    }
}
