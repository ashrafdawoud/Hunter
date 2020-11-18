package com.indrul.hunter.view.LoginFragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.indrul.hunter.R;
import com.indrul.hunter.view.CurrentSiteActivity;
import com.indrul.hunter.view.HomeActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class LoginFragment extends Fragment {
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login)
    CardView login;
    @BindView(R.id.forgetpassword)
    TextView forgetpassword;
    SharedPreferences sharedpreferences;
    static {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this,view);
        Observer observer = new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d("onSubscribe", "");
            }

            @Override
            public void onNext(Object o) {
                Log.d("onNext", o + "");
            }
            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("onError", e + "");
            }
            @Override
            public void onComplete() {
                Log.d("onComplete", "");

            }
        };
        sharedpreferences = getActivity().getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);

        return view;
    }

    void loginFunction(String email, String password) {
        Observable.create(emitter -> {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n    \"email\":\""+email+"\",\r\n    \"password\":\""+password+"\"\r\n}");
            Request request = new Request.Builder()
                    .url("https://the-green-hat.com/hunter/api/v1/en/login")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build();
            try {
                Response response = client.newCall(request).execute();
                parsejson(String.valueOf(response.body().string()));


            } catch (IllegalStateException e) {

            }
            emitter.onNext(1);
        }).subscribeOn(Schedulers.io()).doOnNext(c -> Log.e("Upstream", c + ""))
                .subscribe(a -> Log.e("downstream", a+"" ),throwable ->loginFunction(email,password) );
    }

    @OnClick(R.id.login)
    public void onViewClicked() {
        if (!email.getText().toString().equals("")||!password.getText().toString().equals(""))
        loginFunction(email.getText().toString(),password.getText().toString());
        else Toast.makeText(getActivity(),"The email and Password fields are required",Toast.LENGTH_LONG).show();
    }
    void  parsejson(String jason){
        Log.e("responseresponse", jason);
        try {
            JSONObject tracksArray=new JSONObject(jason);
            if (tracksArray.getString("message").equals("Invalid Credentials")){
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(),"Account Not Found",Toast.LENGTH_LONG).show();
                    }
                });
            }else {
                JSONObject data=tracksArray.optJSONObject("data");
                JSONObject user=data.optJSONObject("user");
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("access_token", "Bearer "+data.getString("access_token"));
                editor.putString("name",user.getString("name"));
                editor.putString("email",user.getString("email"));
                editor.commit();
                Log.e("parse2", String.valueOf(jason));
                startActivity(new Intent(getActivity(), CurrentSiteActivity.class));
                getActivity().overridePendingTransition(R.anim.slide_out_bottom,R.anim.slide_in_bottom);
                getActivity().finish();
            }

        } catch (JSONException e) {
            Log.e("parse2", String.valueOf(e.getMessage()));

        }
    }
}