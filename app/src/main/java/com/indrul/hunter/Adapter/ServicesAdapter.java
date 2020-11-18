package com.indrul.hunter.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indrul.hunter.R;
import com.indrul.hunter.view.PlacesActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ViewHolder> {
    Context context;
    Activity activity;
    ArrayList<String> imagePath = new ArrayList<>();
    ArrayList<String> type = new ArrayList<>();
    ArrayList<String> image_path_val = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> id = new ArrayList<>();

    public ServicesAdapter(Context context, Activity activity, ArrayList<String> imagePath, ArrayList<String> type, ArrayList<String> image_path_val, ArrayList<String> title,ArrayList<String> id) {
        this.context = context;
        this.activity = activity;
        this.imagePath = imagePath;
        this.type = type;
        this.image_path_val = image_path_val;
        this.title = title;
        this.id = id;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.services_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (image_path_val.size()!=0)
        Picasso.get().load(image_path_val.get(position)).into(holder.image);
        holder.title.setText(title.get(position));
        holder.itemView.setOnClickListener(l -> {
            Intent intent = new Intent(context, PlacesActivity.class);
            Log.e("extrasextras",id.get(position)+"");
            intent.putExtra("id",id.get(position));
            context.startActivity(intent);
            activity.overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_bottom);

        });
    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            title=itemView.findViewById(R.id.title);

        }
    }
}
