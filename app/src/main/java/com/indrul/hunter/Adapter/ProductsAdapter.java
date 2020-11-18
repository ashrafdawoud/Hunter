package com.indrul.hunter.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.circularreveal.CircularRevealHelper;
import com.indrul.hunter.R;
import com.indrul.hunter.view.MealsDetailsActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewModel> {
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
      ArrayList<String> products_ida=new ArrayList<>();
      ArrayList<String> products_image_patha=new ArrayList<>();
      ArrayList<String> products_pricea=new ArrayList<>();
      ArrayList<String> products_kcala=new ArrayList<>();
      ArrayList<String> products_service_ida=new ArrayList<>();
      ArrayList<String> products_created_ata=new ArrayList<>();
      ArrayList<String> products_image_path_vala=new ArrayList<>();
      ArrayList<String> products_titlea=new ArrayList<>();
      ArrayList<String> products_descriptiona=new ArrayList<>();
      Context context;
      int position1;
    public ProductsAdapter(Context context,int position1,ArrayList<String> place_ida, ArrayList<String> place_image_patha, ArrayList<String> place_lata, ArrayList<String> place_lnga, ArrayList<String> place_addressa, ArrayList<String> place_promoteda, ArrayList<String> place_image_path_vala, ArrayList<String> place_namea, ArrayList<String> place_desca, ArrayList<String> categoriesa, ArrayList<String> categories_ida, ArrayList<String> categories_created_ata, ArrayList<String> categories_namea, ArrayList<String> categories_productsa, ArrayList<String> products_ida, ArrayList<String> products_image_patha, ArrayList<String> products_pricea, ArrayList<String> products_kcala, ArrayList<String> products_service_ida, ArrayList<String> products_created_ata, ArrayList<String> products_image_path_vala, ArrayList<String> products_titlea, ArrayList<String> products_descriptiona) {
       this.context=context;
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
        this.products_ida = products_ida;
        this.products_image_patha = products_image_patha;
        this.products_pricea = products_pricea;
        this.products_kcala = products_kcala;
        this.products_service_ida = products_service_ida;
        this.products_created_ata = products_created_ata;
        this.products_image_path_vala = products_image_path_vala;
        this.products_titlea = products_titlea;
        this.products_descriptiona = products_descriptiona;
        this.position1=position1;

    }

    @NonNull
    @Override
    public ViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from (parent.getContext ()).inflate (R.layout.product_item,parent,false);
        ViewModel vh=new ViewModel(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewModel holder, int position) {
        holder.title.setText(products_titlea.get(position));
        holder.disc.setText(products_descriptiona.get(position));
        holder.price.setText(products_pricea.get(position));
        Picasso.get().load(products_image_path_vala.get(position)).into(holder.image, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {
                holder.image.setImageDrawable(context.getResources().getDrawable(R.drawable.burger));
            }
        });
        holder.itemView.setOnClickListener(view -> {
            Intent intent=new Intent( context, MealsDetailsActivity.class);
            intent.putExtra("place_ida",place_ida.get(position1));
            intent.putExtra("place_image_patha",place_image_patha.get(position1));
            intent.putExtra("place_lata",place_lata.get(position1));
            intent.putExtra("place_lnga",place_lnga.get(position1));
            intent.putExtra("place_addressa",place_addressa.get(position1));
            intent.putExtra("place_promoteda",place_promoteda.get(position1));
            intent.putExtra("place_image_path_vala",place_image_path_vala.get(position1));
            intent.putExtra("place_namea",place_namea.get(position1));
            intent.putExtra("place_desca",place_desca.get(position1));
            intent.putExtra("products_ida",products_ida.get(position));
            intent.putExtra("products_image_patha",products_image_patha.get(position));
            intent.putExtra("products_pricea",products_pricea.get(position));
            intent.putExtra("products_kcala",products_kcala.get(position));
            intent.putExtra("products_service_ida",products_service_ida.get(position));
            intent.putExtra("products_created_ata",products_created_ata.get(position));
            intent.putExtra("products_image_path_vala",products_image_path_vala.get(position));
            intent.putExtra("products_titlea",products_titlea.get(position));
            intent.putExtra("products_descriptiona",products_descriptiona.get(position));
            intent.putExtra("category_id",categories_ida.get(position));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return products_created_ata.size();
    }

    public class ViewModel extends RecyclerView.ViewHolder {
        TextView title,disc,price;
        ImageView image;
        public ViewModel(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            disc=itemView.findViewById(R.id.discrition);
            price=itemView.findViewById(R.id.price);
            image=itemView.findViewById(R.id.placeimage);
        }
    }
}
