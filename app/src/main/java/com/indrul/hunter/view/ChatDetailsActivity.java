package com.indrul.hunter.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.indrul.hunter.Adapter.ChatDetailsAdapter;
import com.indrul.hunter.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChatDetailsActivity extends AppCompatActivity {
    String TAG = "logloglog";
    @BindView(R.id.chat)
    RecyclerView chat;
    String key;
    ArrayList<String> date = new ArrayList<>();
    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> text = new ArrayList<>();
    ArrayList<String> sendby = new ArrayList<>();
    @BindView(R.id.bill)
    ImageView bill;
    @BindView(R.id.closechat)
    ImageView closechat;
    @BindView(R.id.track)
    ImageView track;
    @BindView(R.id.textsend)
    EditText textsend;
    @BindView(R.id.send)
    ImageView send;
    int last_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_details);
        Bundle bundle = getIntent().getExtras();
        /////////////////////////////////////
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setNavigationBarColor(this.getResources().getColor(R.color.homebagetabs));
        window.setStatusBarColor(this.getResources().getColor(R.color.homebagetabs));
        ///////////////////////////////////////////////
        if (bundle != null) {
            key = bundle.getString("key");
        }
        ButterKnife.bind(this);
        FirebaseFirestore.setLoggingEnabled(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        linearLayoutManager.setStackFromEnd(false);
        linearLayoutManager.setReverseLayout(false);
        chat.setLayoutManager(linearLayoutManager);
        chat.setHasFixedSize(true);
        getAllDatat();
        send.setOnClickListener(v->{
            if (!textsend.getText().toString().equals("")){
                addAdaLovelace();
            }else {
                Toast.makeText(this,"please write text",Toast.LENGTH_LONG).show();
            }
        });

    }

    public void addAdaLovelace() {
        // [START add_ada_lovelace]
        // Create a new user with a first and last name
        SharedPreferences sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        Map<String, Object> user = new HashMap<>();
        user.put("text", textsend.getText().toString());
        user.put("sendby", sharedpreferences.getString("email", ""));
        DateFormat df = new SimpleDateFormat("HH:mm");
        Date dateobj = new Date();
        user.put("sendat", dateobj + "");
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        // Add a new document with a generated ID
       /* db.collection("messages").document(key).collection("message")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                    }

                });*/
        db.collection("messages").document(key).collection("message").document(dateobj+"")
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        textsend.setText("");
                    }
                })
;

        // [END add_ada_lovelace]
    }

    void getAllDatat() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        final CollectionReference docRef = db.collection("messages").document(key).collection("message");
        docRef.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (value.size()==0){
                    Log.e("valuesize", "00");
                    last_id=0;
                }else {
                    id.clear();
                    for (int i = 0; i < value.size(); i++) {
                        id.add(value.getDocuments().get(i).getId());
                    }
                    //last_id=Collections.max(id);
                    Log.e("maxmax", last_id+"");
                    last_id=last_id+1;
                    Log.e("valuesize", last_id+"  00");
                }
                date.clear();
                text.clear();
                sendby.clear();
                for (int i = 0; i < value.size(); i++) {
                    //id.add(value.getDocuments().get(i).getId());
                    Log.e("hellodatass", value.getDocuments().get(i).getString("text") + " " + i);
                    date.add(String.valueOf(value.getDocuments().get(i).get("sendat")));
                    sendby.add(value.getDocuments().get(i).getString("sendby"));
                    text.add(value.getDocuments().get(i).getString("text"));
                }
                ChatDetailsAdapter chatAdapter = new ChatDetailsAdapter(ChatDetailsActivity.this, date, text, sendby);
                chat.setAdapter(chatAdapter);
                chat.scrollToPosition(date.size()-1);
                for (int i = 0; i < date.size(); i++) {
                    try {
                        Log.e("hellodatas2s", sendby.get(i));
                    } catch (NullPointerException e) {
                    }

                }
            }
        });

    }


    public void finish(View view) {
        finish();
    }
}