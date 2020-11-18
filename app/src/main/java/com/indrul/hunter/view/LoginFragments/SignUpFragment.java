package com.indrul.hunter.view.LoginFragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.indrul.hunter.R;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class SignUpFragment extends Fragment {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.signup)
    CardView signup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    void loginFunction(String email, String password,String username) {
        Observable.create(emitter -> {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            MediaType mediaType = MediaType.parse("text/plain");
            RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("name", username)
                    .addFormDataPart("email", email)
                    .addFormDataPart("password", password)
                    .addFormDataPart("user_type", "1")
                    .addFormDataPart("email_verified_at", "123")
                    .addFormDataPart("recive_notification", "1")
                    .addFormDataPart("current_language", "ar")
                    .addFormDataPart("status", "1")
                    .build();
            Request request = new Request.Builder()
                    .url("https://the-green-hat.com/hunter/api/v1/en/register")
                    .method("POST", body)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                JSONObject tracksArray=new JSONObject(response.body().string());
                Log.e("asdf",String.valueOf(tracksArray.toString()+"12"));
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Toast.makeText(getActivity(),tracksArray.getString("errors"),Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            Toast.makeText(getActivity(),tracksArray.getString("message"),Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                });

            }catch (IllegalStateException e){
                e.printStackTrace();
            }
            emitter.onNext(1);
        }).subscribeOn(Schedulers.io()).doOnNext(c -> Log.e("Upstream", c + ""))
                .subscribe(a -> Log.e("downstream", a + ""));
    }

    @OnClick(R.id.signup)
    public void onViewClicked() {
        loginFunction(email.getText().toString(),password.getText().toString(),username.getText().toString());
    }
}