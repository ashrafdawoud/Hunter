package com.indrul.hunter.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.indrul.hunter.Utils.ServicesUtils;
import com.indrul.hunter.model.ServicesModel;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ServicesViewModel extends ViewModel {
    public MutableLiveData<ServicesModel> servicesLiveData=new MutableLiveData<>();
    ServicesModel servicesModel;
    public void getservices(){
       connectApi();
    }

    public  ServicesModel  connectApi(){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://the-green-hat.com/hunter/api/v1/en/services?page=1")
                .method("GET", null)
                .addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvdGhlLWdyZWVuLWhhdC5jb21cL2h1bnRlclwvYXBpXC92MVwvZW5cL2xvZ2luIiwiaWF0IjoxNjAwNDEyMjI2LCJleHAiOjE2MDA0MTU4MjYsIm5iZiI6MTYwMDQxMjIyNiwianRpIjoicXQ2VHA2Z0hGQzNjUGdUbCIsInN1YiI6MSwicHJ2IjoiMjNiZDVjODk0OWY2MDBhZGIzOWU3MDFjNDAwODcyZGI3YTU5NzZmNyJ9.uhhdM6Rj9Nf_0j6ziEzrvZgUNYV-y3nMMAoo9u-Jl8Q")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("newcallhttp",e.getMessage());
                connectApi();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful ( )) {
                    String respons = response.body ( ).string ( );
                    servicesModel= ServicesUtils.parseServices(respons);
                    Log.e("newcallhttp", String.valueOf(servicesModel));
                    servicesLiveData.postValue(servicesModel);
                }
            }
        });

        return servicesModel;
    }
}
