package com.indrul.hunter.model;

import java.util.ArrayList;

public class NearestModel {
    ArrayList<String> lat=new ArrayList<>();
    ArrayList<String> lng=new ArrayList<>();
    ArrayList<String> address_val=new ArrayList<>();
    ArrayList<String> name=new ArrayList<>();
    ArrayList<String> image_path_val=new ArrayList<>();
    ArrayList<String> map_place_id=new ArrayList<>();
    ArrayList<String> promoted=new ArrayList<>();
    ArrayList<String> ordering=new ArrayList<>();
    ArrayList<String> distance=new ArrayList<>();
    ArrayList<String> image_path=new ArrayList<>();

    public NearestModel(ArrayList<String> lat, ArrayList<String> lng, ArrayList<String> address_val, ArrayList<String> name, ArrayList<String> image_path_val, ArrayList<String> map_place_id, ArrayList<String> promoted, ArrayList<String> ordering, ArrayList<String> distance, ArrayList<String> image_path) {
        this.lat = lat;
        this.lng = lng;
        this.address_val = address_val;
        this.name = name;
        this.image_path_val = image_path_val;
        this.map_place_id = map_place_id;
        this.promoted = promoted;
        this.ordering = ordering;
        this.distance = distance;
        this.image_path = image_path;
    }

    public ArrayList<String> getLat() {
        return lat;
    }

    public void setLat(ArrayList<String> lat) {
        this.lat = lat;
    }

    public ArrayList<String> getLng() {
        return lng;
    }

    public void setLng(ArrayList<String> lng) {
        this.lng = lng;
    }

    public ArrayList<String> getAddress_val() {
        return address_val;
    }

    public void setAddress_val(ArrayList<String> address_val) {
        this.address_val = address_val;
    }

    public ArrayList<String> getName() {
        return name;
    }

    public void setName(ArrayList<String> name) {
        this.name = name;
    }

    public ArrayList<String> getImage_path_val() {
        return image_path_val;
    }

    public void setImage_path_val(ArrayList<String> image_path_val) {
        this.image_path_val = image_path_val;
    }

    public ArrayList<String> getMap_place_id() {
        return map_place_id;
    }

    public void setMap_place_id(ArrayList<String> map_place_id) {
        this.map_place_id = map_place_id;
    }

    public ArrayList<String> getPromoted() {
        return promoted;
    }

    public void setPromoted(ArrayList<String> promoted) {
        this.promoted = promoted;
    }

    public ArrayList<String> getOrdering() {
        return ordering;
    }

    public void setOrdering(ArrayList<String> ordering) {
        this.ordering = ordering;
    }

    public ArrayList<String> getDistance() {
        return distance;
    }

    public void setDistance(ArrayList<String> distance) {
        this.distance = distance;
    }

    public ArrayList<String> getImage_path() {
        return image_path;
    }

    public void setImage_path(ArrayList<String> image_path) {
        this.image_path = image_path;
    }
}
