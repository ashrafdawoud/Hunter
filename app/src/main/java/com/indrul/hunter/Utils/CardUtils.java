package com.indrul.hunter.Utils;

import android.util.Log;

import com.google.gson.JsonObject;
import com.indrul.hunter.model.CardModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CardUtils {
    private final static String id_JSON_KEY = "id";
    private final static String quantity_JSON_KEY = "quantity";
    private final static String product_id_JSON_KEY = "product_id";
    private final static String cart_id_JSON_KEY = "cart_id";
    private final static String image_path_JSON_KEY = "image_path";
    private final static String price_JSON_KEY = "price";
    private final static String kcal_JSON_KEY = "kcal";
    private final static String category_id_JSON_KEY = "category_id";
    private final static String title_JSON_KEY = "title";
    private final static String description_JSON_KEY = "description";
   public static CardModel jsonparsing(String json){
       CardModel cardModel=null;
       if (json!=null&&!json.isEmpty()){
           ArrayList<String>id=new ArrayList<>();
           ArrayList<String>quantity=new ArrayList<>();
           ArrayList<String>product_id=new ArrayList<>();
           ArrayList<String>cart_id=new ArrayList<>();
           ArrayList<String>image_path=new ArrayList<>();
           ArrayList<String>price=new ArrayList<>();
           ArrayList<String>kcal=new ArrayList<>();
           ArrayList<String>category_id=new ArrayList<>();
           ArrayList<String>title=new ArrayList<>();
           ArrayList<String>description=new ArrayList<>();

           try {
               JSONObject data=new JSONObject(json);
               JSONObject data1=data.optJSONObject("data");
               JSONObject items=data1.optJSONObject("items");
               JSONArray data2=items.optJSONArray("data");
               for (int i=0;i<data2.length();i++){
                   JSONObject record=data2.optJSONObject(i);
                   id.add(record.optString(id_JSON_KEY));
                   quantity.add(record.optString(quantity_JSON_KEY));
                   product_id.add(record.optString(product_id_JSON_KEY));
                   cart_id.add(record.optString(cart_id_JSON_KEY));
                   JSONObject product=new JSONObject(record.optString("product"));
                   image_path.add(product.optString(image_path_JSON_KEY));
                   price.add(product.optString(price_JSON_KEY));
                   kcal.add(product.optString(kcal_JSON_KEY));
                   category_id.add(product.optString(category_id_JSON_KEY));
                   title.add(product.optString(title_JSON_KEY));
                   description.add(product.optString(description_JSON_KEY));
               }
            cardModel=new CardModel(id,quantity,product_id,cart_id,image_path,price,kcal,category_id,title,description);
           } catch (JSONException e) {
               e.printStackTrace();
           }

       }
       return cardModel;
   }
}
