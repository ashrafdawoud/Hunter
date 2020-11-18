package com.indrul.hunter.view.Driver;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.indrul.hunter.R;
import com.indrul.hunter.view.CurrentSiteActivity;
import com.indrul.hunter.view.Driver.HomePageDriverFragment.HomeDFragment;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SigninDriverActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login)
    CardView login;
    @BindView(R.id.forgetpassword)
    TextView forgetpassword;
    @BindView(R.id.register)
    CardView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_driver);
        ButterKnife.bind(this);
        /////////////////////////////////////
        ButterKnife.bind(this);
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setNavigationBarColor(this.getResources().getColor(R.color.homebagetabs));
        window.setStatusBarColor(this.getResources().getColor(R.color.homebagetabs));
        ///////////////////////////////////////////////
        sharedPreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
    }

    public void finish(View view) {
        finish();
    }
    @OnClick(R.id.login)
    public void onViewClicked() {
        loginFunction(email.getText().toString(),password.getText().toString());
    }
    void loginFunction(String email, String password) {
        Observable.create(emitter -> {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\r\n    \"email\":\"" + email + "\",\r\n    \"password\":\"" + password + "\"\r\n}");
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
                .subscribe(a -> Log.e("downstream", a + ""), throwable -> loginFunction(email, password));
    }

    void parsejson(String jason) {
        Log.e("responseresponse", jason);
        try {
            JSONObject tracksArray = new JSONObject(jason);
            if (tracksArray.getString("message").equals("Invalid Credentials")) {
                this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(SigninDriverActivity.this, "Account Not Found", Toast.LENGTH_LONG).show();
                    }
                });
            } else {
                JSONObject data = tracksArray.optJSONObject("data");
                JSONObject user = data.optJSONObject("user");
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("access_tokend", "Bearer " + data.getString("access_token"));
                editor.putString("named", user.getString("name"));
                editor.putString("emaild", user.getString("email"));
                editor.commit();
                Log.e("parse2", String.valueOf(jason));
                startActivity(new Intent(this, HomePageDriver.class));
                SigninDriverActivity.this.overridePendingTransition(R.anim.slide_out_bottom, R.anim.slide_in_bottom);
                SigninDriverActivity.this.finish();
            }

        } catch (JSONException e) {
            Log.e("parse2", String.valueOf(e.getMessage()));

        }
    }


}