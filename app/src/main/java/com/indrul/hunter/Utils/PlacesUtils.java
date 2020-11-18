package com.indrul.hunter.Utils;

import android.util.Log;

import com.google.gson.JsonObject;
import com.indrul.hunter.model.PlacesModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PlacesUtils {
    private final static String place_id = "id";
    private final static String place_image_path= "image_path";
    private final static String place_lat = "lat";
    private final static String place_lng = "lng";
    private final static String place_address = "address";
    private final static String place_promoted = "promoted";
    private final static String place_image_path_val = "image_path_val";
    private final static String place_name = "name";
    private final static String place_desc = "desc";
    private final static String categories = "categories";
    private final static String categories_id = "id";
    private final static String categories_created_at = "created_at";
    private final static String categories_name = "name";
    private final static String categories_products = "products";
    private final static String products_id = "id";
    private final static String products_image_path = "image_path";
    private final static String products_price = "price";
    private final static String products_kcal = "kcal";
    private final static String products_service_id = "service_id";
    private final static String products_category_id = "category_id";
    private final static String products_created_at = "created_at";
    private final static String products_image_path_val = "image_path_val";
    private final static String products_title = "title";
    private final static String products_description = "description";

    public static PlacesModel JsonParce(String Json,int Position){
        PlacesModel placesModel=null;
        if (!Json.isEmpty()&&Json!=null){
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
          /*  ArrayList<String> products_ida=new ArrayList<>();
            ArrayList<String> products_image_patha=new ArrayList<>();
            ArrayList<String> products_pricea=new ArrayList<>();
            ArrayList<String> products_kcala=new ArrayList<>();
            ArrayList<String> products_service_ida=new ArrayList<>();
            ArrayList<String> products_created_ata=new ArrayList<>();
            ArrayList<String> products_image_path_vala=new ArrayList<>();
            ArrayList<String> products_titlea=new ArrayList<>();
            ArrayList<String> products_descriptiona=new ArrayList<>();*/
            ArrayList<String> productString=new ArrayList<>();
            try {
                JSONObject jsonObject=new JSONObject(Json);
                Log.e("datadata1",jsonObject.toString());
                JSONObject data=jsonObject.optJSONObject("data");
                Log.e("datadata2",data.toString());
                place_ida.add(data.optString(place_id));
                place_image_patha.add(data.optString(place_image_path));
                place_lata.add(data.optString(place_lat));
                place_lnga.add(data.optString(place_lng));
                place_addressa.add(data.optString(place_address));
                place_promoteda.add(data.optString(place_promoted));
                place_image_path_vala.add(data.optString(place_image_path_val));
                place_namea.add(data.optString(place_name));
                place_desca.add(data.optString(place_desc));
                JSONArray categries=data.getJSONArray(categories);
                for (int i=0;i<categries.length();i++){
                    JSONObject record=categries.optJSONObject(i);
                    categories_ida.add(record.optString(categories_id));
                    categories_created_ata.add(record.optString(categories_created_at));
                    categories_namea.add(record.optString(categories_name));
                    JSONArray products=record.getJSONArray(categories_products);
                    productString.add(String.valueOf(products));
                    Log.e("products3",productString.size()+"");
                    for (int h=0;h<products.length();h++) {
                        JSONObject prorecord=products.getJSONObject(h);
                        
                   /*     products_ida.add(prorecord.optString(products_id));
                        products_image_patha.add(prorecord.optString(products_image_path));
                        products_pricea.add(prorecord.optString(products_price));
                        products_kcala.add(prorecord.optString(products_kcal));
                        products_service_ida.add(prorecord.optString(products_service_id));
                        products_created_ata.add(prorecord.optString(products_created_at));
                        products_image_path_vala.add(prorecord.optString(products_image_path_val));
                        products_titlea.add(prorecord.optString(products_title));
                        products_descriptiona.add(prorecord.optString(products_description));*/
                    }
                }
                Log.e("products7",productString+"");

            placesModel=new PlacesModel(place_ida,place_image_patha,place_lata,place_lnga,place_addressa,place_promoteda,place_image_path_vala,place_namea,place_desca,categoriesa,categories_ida,  categories_created_ata,   categories_namea,    categories_productsa,productString);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
        return placesModel;
    }
}
