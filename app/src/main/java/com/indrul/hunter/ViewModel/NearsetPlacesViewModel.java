package com.indrul.hunter.ViewModel;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.indrul.hunter.Utils.NearsetUtils;
import com.indrul.hunter.Utils.ServicesUtils;
import com.indrul.hunter.model.NearestModel;
import com.indrul.hunter.model.ServicesModel;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NearsetPlacesViewModel extends ViewModel {
    public MutableLiveData<NearestModel>nearestModelMutableLiveData=new MutableLiveData<>();
    NearestModel nearestModel;
    public void connectApi(Context context){
        SharedPreferences sharedpreferences = context.getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://the-green-hat.com/hunter/api/v1/ar/places?serviceId=1&lat=30.057073&lng=31.337745&radius=1000&page=2")
                .method("GET", null)
                .addHeader("Authorization", sharedpreferences.getString("access_token","0"))
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("newcallhttpnearser",e.getMessage());
                connectApi(context);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful ( )) {
                    String respons = response.body ( ).string ( );
                    Log.e("newcallhttpnearser",respons);
                    nearestModel= NearsetUtils.jsonparsing(respons);
                    nearestModelMutableLiveData.postValue(nearestModel);

                }
            }
        });
}}
