package com.indrul.hunter.Utils;

import com.indrul.hunter.model.OrdersModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class OrdersUtils {
    private final static String id_JSON_KEY = "id";
    private final static String number_JSON_KEY = "number";
    private final static String deliver_lat_JSON_KEY = "deliver_lat";
    private final static String deliver_lng_JSON_KEY = "deliver_lng";
    private final static String deliver_address_JSON_KEY = "deliver_address";
    private final static String pickup_lat_JSON_KEY = "pickup_lat";
    private final static String pickup_lng_JSON_KEY = " pickup_lng";
    private final static String pickup_address_JSON_KEY = "pickup_address";
    private final static String description_JSON_KEY = "description";
    private final static String name_JSON_KEY = "name";
    private final static String total_price_JSON_KEY = "total_price";
    private final static String discount_cost_JSON_KEY = "discount_cost";
    private final static String total_price_after_discount_JSON_KEY = "total_price_after_discount";
    private final static String payment_type_JSON_KEY = "payment_type";
    private final static String status_JSON_KEY = "status";
    private final static String created_at_JSON_KEY = "created_at";
    private final static String image_path_val_cost_JSON_KEY = "image_path_val";

    public static OrdersModel parsejason(String json){
        OrdersModel ordersModel=null;
        ArrayList<String>id =new ArrayList<>();
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


        if (!json.isEmpty()&&json!=null){
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(json);
                JSONArray orders=jsonObject.getJSONArray("data");
                for (int i=0;i<orders.length();i++){
                    JSONObject record=orders.optJSONObject(i);
                    id.add(record.optString(id_JSON_KEY));
                    number.add(record.optString(number_JSON_KEY));
                    deliver_lat.add(record.optString(deliver_lat_JSON_KEY));
                    deliver_lng.add(record.optString(deliver_lng_JSON_KEY));
                    deliver_address.add(record.optString(deliver_address_JSON_KEY));
                    pickup_lat.add(record.optString(pickup_lat_JSON_KEY));
                    pickup_lng.add(record.optString(pickup_lng_JSON_KEY));
                    pickup_address.add(record.optString(pickup_address_JSON_KEY));
                    description.add(record.optString(description_JSON_KEY));
                    name.add(record.optString(name_JSON_KEY));
                    total_price.add(record.optString(total_price_JSON_KEY));
                    discount_cost.add(record.optString(discount_cost_JSON_KEY));
                    total_price_after_discount.add(record.optString(total_price_after_discount_JSON_KEY));
                    payment_type.add(record.optString(payment_type_JSON_KEY));
                    status.add(record.optString(status_JSON_KEY));
                    created_at.add(record.optString(created_at_JSON_KEY));
                    image_path_val.add(record.optString(image_path_val_cost_JSON_KEY));
                }
                ordersModel=new OrdersModel(id,number,deliver_lat,deliver_lng,deliver_address,pickup_lat,pickup_lng,pickup_address,description,name,total_price,discount_cost,total_price_after_discount,payment_type,status,created_at,image_path_val);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


        return ordersModel;
    }
}
