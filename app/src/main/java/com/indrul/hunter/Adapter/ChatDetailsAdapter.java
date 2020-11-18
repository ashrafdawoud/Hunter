package com.indrul.hunter.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indrul.hunter.R;

import java.util.ArrayList;

public class ChatDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<String> date=new ArrayList<>();
    ArrayList<String> text=new ArrayList<>();
    ArrayList<String> sendby=new ArrayList<>();
    SharedPreferences sharedpreferences;
    public ChatDetailsAdapter(Context context, ArrayList<String> date, ArrayList<String> text, ArrayList<String> sendby) {
        this.context = context;
        this.date = date;
        this.text = text;
        this.sendby = sendby;
        sharedpreferences = context.getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);

    }

    private class MessageInViewHolder extends RecyclerView.ViewHolder {

        TextView messageTV,dateTV;
        MessageInViewHolder(final View itemView) {
            super(itemView);
            messageTV = itemView.findViewById(R.id.message_text);
            dateTV = itemView.findViewById(R.id.date_text);
        }
        void bind(int position) {
            try {
                messageTV.setText(text.get(position));
                dateTV.setText(date.get(position));
            }catch (NullPointerException e){

            }

        }
    }

    private class MessageOutViewHolder extends RecyclerView.ViewHolder {

        TextView messageTV,dateTV;
        MessageOutViewHolder(final View itemView) {
            super(itemView);
            messageTV = itemView.findViewById(R.id.message_text);
            dateTV = itemView.findViewById(R.id.date_text);
        }
        void bind(int position) {
            try {
                messageTV.setText(text.get(position));
                dateTV.setText(date.get(position));
                Log.e("asdfghjkl", date.get(position));
            }catch (NullPointerException e){

            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new MessageInViewHolder(LayoutInflater.from(parent.getContext ()).inflate(R.layout.item_text_in, parent, false));
        }
        return new MessageOutViewHolder(LayoutInflater.from(parent.getContext ()).inflate(R.layout.item_text_out, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        try {
            if (sendby.get(position).equals(sharedpreferences.getString("email", ""))) {
                ((MessageInViewHolder) holder).bind(position);
            } else {
                ((MessageOutViewHolder) holder).bind(position);
            }
        }catch (NullPointerException e){}
    }

    @Override
    public int getItemCount() {
        return sendby.size();
    }

    @Override
    public int getItemViewType(int position) {
        try {
            Log.e("sendbyeq", sendby.get(position)+"    "+sharedpreferences.getString("email",""));
            if (sendby.get(position).equals(sharedpreferences.getString("email",""))) {
                Log.e("sendbyeq", "0");
                return 0;}else {
                Log.e("sendbyeq", "1");
                return 1;}
        }catch (NullPointerException e){return 3;}


    }
}

