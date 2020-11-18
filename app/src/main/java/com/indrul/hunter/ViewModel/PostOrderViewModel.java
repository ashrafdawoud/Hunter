package com.indrul.hunter.ViewModel;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.indrul.hunter.Utils.OrdersUtils;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PostOrderViewModel extends ViewModel {
    public void connectApi(Context context, Activity activity,String order, String from, String to, double lngd, double latd, double lngp, double latp){
        SharedPreferences sharedpreferences = context.getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");

        JSONObject jObjectData = new JSONObject();

        try {
            jObjectData.put("deliver_address", to);
            jObjectData.put("deliver_lat", latd);
            jObjectData.put("deliver_lng", lngd);
            jObjectData.put("pickup_address", from);
            jObjectData.put("pickup_lat", latp);
            jObjectData.put("pickup_lng", lngp);
            jObjectData.put("description", order);
            jObjectData.put("name", sharedpreferences.getString("name",""));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("tototot",jObjectData.toString());
        RequestBody body = RequestBody.create(mediaType,
                jObjectData.toString()
        );
       /* RequestBody body = RequestBody.create(mediaType, "{\n\t\"deliver_address\": \"deliver 5 Cairo Egypt\",\n    \"deliver_lat\": 30.111333,\n    \"deliver_lng\":31.11133,\n    \"pickup_address\": \"pickup 5 Cairo Egypt\",\n    \"pickup_lat\": 30.22333,\n    \"pickup_lng\":31.22333,\n    \"description\": \"custom order5 description\",\n    \"name\":\"ashraf\"\n}");*/
        Request request = new Request.Builder()
                .url("https://the-green-hat.com/hunter/api/v1/en/orders/custom-order")
                .method("POST", body)
                .addHeader("Authorization", sharedpreferences.getString("access_token","0"))
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("newcallhttpaaorders",e.getMessage());
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(activity,"Fail try again",Toast.LENGTH_LONG).show();
                    }
                });
                connectApi(context,activity, order, from, to, lngd, latd,lngp, latp);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful ( )) {
                    String respons = response.body ( ).string ( );
                    Log.e("newcallhttpaaorders",respons);
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(activity,"Sucsess",Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }
}
