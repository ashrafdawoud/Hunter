package com.indrul.hunter.ViewModel;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.indrul.hunter.Utils.NotificationUtils;
import com.indrul.hunter.Utils.OrdersUtils;
import com.indrul.hunter.model.OrdersModel;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OrdersViewModel extends ViewModel {
    OrdersModel ordersModel;
   public MutableLiveData<OrdersModel> ordersViewModelMutableLiveData=new MutableLiveData<>();
    public void connectApi(Context context){
        SharedPreferences sharedpreferences = context.getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://the-green-hat.com/hunter/api/v1/en/orders")
                .method("GET", null)
                .addHeader("Authorization", sharedpreferences.getString("access_token","0"))
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("newcallhttporders",e.getMessage());
                connectApi(context);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful ( )) {
                    String respons = response.body ( ).string ( );
                    Log.e("newcallhttpnorders",respons);
                    ordersModel= OrdersUtils.parsejason(respons);
                    ordersViewModelMutableLiveData.postValue(ordersModel);
                }
            }
        });
    }
}
