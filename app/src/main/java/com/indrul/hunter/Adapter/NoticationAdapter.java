package com.indrul.hunter.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.indrul.hunter.R;

import java.util.ArrayList;

public class NoticationAdapter extends RecyclerView.Adapter<NoticationAdapter.ViewHolder> {
    ArrayList<String> id=new ArrayList<>();
    ArrayList<String> type=new ArrayList<>();
    ArrayList<String> date_time=new ArrayList<>();
    ArrayList<String> date_human=new ArrayList<>();
    ArrayList<String> title=new ArrayList<>();
    ArrayList<String> message=new ArrayList<>();
    public NoticationAdapter(ArrayList<String> id, ArrayList<String> type, ArrayList<String> date_time, ArrayList<String> date_human, ArrayList<String> title, ArrayList<String> message) {
        this.id = id;
        this.type = type;
        this.date_time = date_time;
        this.date_human = date_human;
        this.title = title;
        this.message = message;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from (parent.getContext ()).inflate (R.layout.notification_item,parent,false);
        ViewHolder vh=new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(title.get(position));
        holder.message.setText(message.get(position));
        holder.time.setText(date_human.get(position));
    }

    @Override
    public int getItemCount() {
        return message.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,message,time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            message=itemView.findViewById(R.id.message);
            time=itemView.findViewById(R.id.time);
        }
    }
}
