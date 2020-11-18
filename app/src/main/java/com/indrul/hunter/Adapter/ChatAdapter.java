package com.indrul.hunter.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indrul.hunter.R;
import com.indrul.hunter.view.ChatDetailsActivity;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    Context context;
    ArrayList<String >key=new ArrayList<>();

    public ChatAdapter(Context context, ArrayList<String> key) {
        this.context = context;
        this.key = key;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from (parent.getContext ()).inflate (R.layout.chat_item,parent,false);
        ViewHolder vh=new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SharedPreferences sharedpreferences = context.getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
        String emails=key.get(position).replace(sharedpreferences.getString("email",""),"");
        emails=emails.replace("-","");
        Log.e("hellodata2", emails);
        holder.email.setText(emails);
        holder.itemView.setOnClickListener(v->{
            Intent in=new Intent(context, ChatDetailsActivity.class);
            in.putExtra("key",key.get(position));
            context.startActivity(in);
        });

    }

    @Override
    public int getItemCount() {
        return key.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView time,email;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            email=itemView.findViewById(R.id.email);
            time=itemView.findViewById(R.id.time);
        }
    }
}
