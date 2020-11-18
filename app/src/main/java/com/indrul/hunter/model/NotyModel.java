package com.indrul.hunter.model;

import java.util.ArrayList;

public class NotyModel {
    ArrayList<String> id=new ArrayList<>();
    ArrayList<String> type=new ArrayList<>();
    ArrayList<String> date_time=new ArrayList<>();
    ArrayList<String> date_human=new ArrayList<>();
    ArrayList<String> title=new ArrayList<>();
    ArrayList<String> message=new ArrayList<>();

    public NotyModel(ArrayList<String> id, ArrayList<String> type, ArrayList<String> date_time, ArrayList<String> date_human, ArrayList<String> title, ArrayList<String> message) {
        this.id = id;
        this.type = type;
        this.date_time = date_time;
        this.date_human = date_human;
        this.title = title;
        this.message = message;
    }

    public ArrayList<String> getId() {
        return id;
    }

    public void setId(ArrayList<String> id) {
        this.id = id;
    }

    public ArrayList<String> getType() {
        return type;
    }

    public void setType(ArrayList<String> type) {
        this.type = type;
    }

    public ArrayList<String> getDate_time() {
        return date_time;
    }

    public void setDate_time(ArrayList<String> date_time) {
        this.date_time = date_time;
    }

    public ArrayList<String> getDate_human() {
        return date_human;
    }

    public void setDate_human(ArrayList<String> date_human) {
        this.date_human = date_human;
    }

    public ArrayList<String> getTitle() {
        return title;
    }

    public void setTitle(ArrayList<String> title) {
        this.title = title;
    }

    public ArrayList<String> getMessage() {
        return message;
    }

    public void setMessage(ArrayList<String> message) {
        this.message = message;
    }
}
