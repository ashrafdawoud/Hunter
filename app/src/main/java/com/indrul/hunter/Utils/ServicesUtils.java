package com.indrul.hunter.Utils;

import android.util.Log;

import com.indrul.hunter.ViewModel.ServicesViewModel;
import com.indrul.hunter.model.ServicesModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ServicesUtils {
    private final static String image_path_JSON_KEY = "image_path";
    private final static String type_JSON_KEY = "type";
    private final static String image_path_val_JSON_KEY = "image_path_val";
    private final static String title_JSON_KEY = "title";
    public static ServicesModel parseServices(String json){
        ServicesModel ServicesModel=null;
        ArrayList<String> imagePath=new ArrayList<>();
        ArrayList<String> id=new ArrayList<>();
        ArrayList<String> type=new ArrayList<>();
        ArrayList<String> image_path_val=new ArrayList<>();
        ArrayList<String> title=new ArrayList<>();
        if (json!=null&&!json.isEmpty()){
            try {
                JSONObject data=new JSONObject(json);
                Log.e("a1",data.toString());
                JSONArray services=data.getJSONArray("data");
                Log.e("a2",services.toString());
                for (int i=0;i<services.length();i++){
                    JSONObject record = services.optJSONObject(i);
                    Log.e("a3",record.toString());
                    id.add(record.optString("id"));
                    image_path_val.add(record.optString(image_path_val_JSON_KEY));
                    imagePath.add(record.optString(image_path_JSON_KEY));
                    type.add(record.optString(type_JSON_KEY));
                    title.add(record.optString(title_JSON_KEY));
                    Log.e("a4",id.get(i));

                }
                ServicesModel=new ServicesModel(imagePath,type,image_path_val,title,id);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return ServicesModel;
    }
}
