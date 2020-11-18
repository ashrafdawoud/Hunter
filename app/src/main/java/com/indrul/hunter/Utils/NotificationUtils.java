package com.indrul.hunter.Utils;

import com.indrul.hunter.model.NotyModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NotificationUtils {
    private final static String id_JSON_KEY = "id";
    private final static String type_JSON_KEY = "type";
    private final static String date_time_JSON_KEY = "date_time";
    private final static String date_human_JSON_KEY = "date_human";
    private final static String title_JSON_KEY = "title";
    private final static String message_JSON_KEY = "message";
    public static NotyModel parsejason(String json){
        NotyModel notyModel=null;
        if (!json.isEmpty()&&json!=null){
            ArrayList<String> id=new ArrayList<>();
            ArrayList<String> type=new ArrayList<>();
            ArrayList<String> date_time=new ArrayList<>();
            ArrayList<String> date_human=new ArrayList<>();
            ArrayList<String> title=new ArrayList<>();
            ArrayList<String> message=new ArrayList<>();
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(json);
                JSONArray noty=jsonObject.getJSONArray("data");
                for (int i=0;i<noty.length();i++){
                    JSONObject record=noty.optJSONObject(i);
                    id.add(record.optString(id_JSON_KEY));
                    type.add(record.optString(type_JSON_KEY));
                    date_time.add(record.optString(date_time_JSON_KEY));
                    date_human.add(record.optString(date_human_JSON_KEY));
                    title.add(record.optString(title_JSON_KEY));
                    message.add(record.optString(message_JSON_KEY));

                }
                notyModel=new NotyModel(id,type,date_time,date_human,title,message);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return notyModel;
    }
}
