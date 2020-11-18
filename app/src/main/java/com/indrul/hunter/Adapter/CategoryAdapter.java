package com.indrul.hunter.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.transition.Hold;
import com.indrul.hunter.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    Context context;
    String id;
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
    ArrayList<String> productsString=new ArrayList<>();

    Choosecategory choosecategory;

    public CategoryAdapter(Choosecategory choosecategory,Context context, String id, ArrayList<String> place_ida, ArrayList<String> place_image_patha, ArrayList<String> place_lata, ArrayList<String> place_lnga, ArrayList<String> place_addressa, ArrayList<String> place_promoteda, ArrayList<String> place_image_path_vala, ArrayList<String> place_namea, ArrayList<String> place_desca, ArrayList<String> categoriesa, ArrayList<String> categories_ida, ArrayList<String> categories_created_ata, ArrayList<String> categories_namea, ArrayList<String> categories_productsa, ArrayList<String> productsString) {
        this.choosecategory=choosecategory;
        this.context = context;
        this.id = id;
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
       this.productsString=productsString;
       if (!categoriesa.equals("[]")) {
           try {
               choosecategory.products(productsString.get(0), place_ida, place_image_patha, place_lata, place_lnga, place_addressa, place_promoteda, place_image_path_vala, place_namea, place_desca, categoriesa, categories_ida, categories_created_ata, categories_namea);
               Log.e("calledfromif","called");
           }catch (IndexOutOfBoundsException e){}

       }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from (parent.getContext ()).inflate (R.layout.categry_item,parent,false);
        ViewHolder vh=new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text.setText(categories_namea.get(position));
        holder.itemView.setOnClickListener(view -> {
            if (!categoriesa.equals("[]"))
            choosecategory.products(productsString.get(position),place_ida,place_image_patha,place_lata,place_lnga,place_addressa,place_promoteda,place_image_path_vala,place_namea,place_desca,categoriesa,categories_ida,categories_created_ata,categories_namea);
        });
    }

    @Override
    public int getItemCount() {
        return categories_namea.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.text);
        }
    }
    public  interface Choosecategory{
        void products(String product,ArrayList<String> place_ida, ArrayList<String> place_image_patha, ArrayList<String> place_lata, ArrayList<String> place_lnga, ArrayList<String> place_addressa, ArrayList<String> place_promoteda, ArrayList<String> place_image_path_vala, ArrayList<String> place_namea, ArrayList<String> place_desca, ArrayList<String> categoriesa, ArrayList<String> categories_ida, ArrayList<String> categories_created_ata, ArrayList<String> categories_namea);
    }
}
