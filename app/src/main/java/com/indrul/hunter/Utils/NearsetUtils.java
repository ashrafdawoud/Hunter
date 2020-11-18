package com.indrul.hunter.Utils;

import com.indrul.hunter.model.NearestModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NearsetUtils {
    private final static String lat_JSON_KEY = "lat";
    private final static String lng_JSON_KEY = "lng";
    private final static String address_val_JSON_KEY = "address";
    private final static String name_JSON_KEY = "name";
    private final static String image_path_val_JSON_KEY = "image_path_val";
    private final static String map_place_id_JSON_KEY = "map_place_id";
    private final static String promoted_JSON_KEY = "promoted";
    private final static String ordering_JSON_KEY = "ordering";
    private final static String distance_JSON_KEY = "distance";
    private final static String image_path_JSON_KEY = "image_path";
    public  static NearestModel jsonparsing(String json){
        NearestModel nearestModel=null;
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

        if (json!=null&&!json.isEmpty()) {
            try {
                JSONObject jsonObject = new JSONObject(json);
                JSONArray places=jsonObject.getJSONArray("data");
                for (int i=0;i<places.length();i++){
                    JSONObject record = places.optJSONObject(i);
                    lat.add(record.optString(lat_JSON_KEY));
                    address_val.add(record.optString(address_val_JSON_KEY));
                    name.add(record.optString(name_JSON_KEY));
                    image_path_val.add(record.optString(image_path_val_JSON_KEY));
                    map_place_id.add(record.optString(map_place_id_JSON_KEY));
                    promoted.add(record.optString(promoted_JSON_KEY));
                    ordering.add(record.optString(ordering_JSON_KEY));
                    distance.add(record.optString(distance_JSON_KEY));
                    image_path.add(record.optString(image_path_JSON_KEY));
                    lng.add(record.optString(lng_JSON_KEY));
                    nearestModel=new NearestModel(  lat,   lng,   address_val,   name,   image_path_val,   map_place_id,   promoted,   ordering,   distance,   image_path);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return nearestModel;
    }

}
