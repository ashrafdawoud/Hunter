package com.indrul.hunter.model;

import com.indrul.hunter.ViewModel.ServicesViewModel;

import java.util.ArrayList;

public class ServicesModel {
    ArrayList<String> imagePath=new ArrayList<>();
    ArrayList<String> type=new ArrayList<>();
    ArrayList<String> image_path_val=new ArrayList<>();
    ArrayList<String> title=new ArrayList<>();
    ArrayList<String> id=new ArrayList<>();

    public ServicesModel( ArrayList<String> imagePath, ArrayList<String> type, ArrayList<String> image_path_val, ArrayList<String> title,ArrayList<String> id) {
        this.imagePath = imagePath;
        this.type = type;
        this.image_path_val = image_path_val;
        this.title = title;
        this.id=id;
    }

    public ArrayList<String> getImagePath() {
        return imagePath;
    }

    public void setImagePath(ArrayList<String> imagePath) {
        this.imagePath = imagePath;
    }

    public ArrayList<String> getType() {
        return type;
    }

    public void setType(ArrayList<String> type) {
        this.type = type;
    }

    public ArrayList<String> getImage_path_val() {
        return image_path_val;
    }

    public void setImage_path_val(ArrayList<String> image_path_val) {
        this.image_path_val = image_path_val;
    }

    public ArrayList<String> getTitle() {
        return title;
    }

    public void setTitle(ArrayList<String> title) {
        this.title = title;
    }

    public ArrayList<String> getId() {
        return id;
    }

    public void setId(ArrayList<String> id) {
        this.id = id;
    }
}
