package com.indrul.hunter.model;

import java.util.ArrayList;

public class OrdersModel {
    ArrayList<String> id =new ArrayList<>();
    ArrayList<String>number =new ArrayList<>();
    ArrayList<String>deliver_lat =new ArrayList<>();
    ArrayList<String>deliver_lng =new ArrayList<>();
    ArrayList<String>deliver_address =new ArrayList<>();
    ArrayList<String>pickup_lat =new ArrayList<>();
    ArrayList<String>pickup_lng =new ArrayList<>();
    ArrayList<String>pickup_address =new ArrayList<>();
    ArrayList<String>description =new ArrayList<>();
    ArrayList<String>name =new ArrayList<>();
    ArrayList<String>total_price =new ArrayList<>();
    ArrayList<String>discount_cost =new ArrayList<>();
    ArrayList<String>total_price_after_discount =new ArrayList<>();
    ArrayList<String>payment_type =new ArrayList<>();
    ArrayList<String>status =new ArrayList<>();
    ArrayList<String>created_at =new ArrayList<>();
    ArrayList<String>image_path_val =new ArrayList<>();

    public OrdersModel(ArrayList<String> id, ArrayList<String> number, ArrayList<String> deliver_lat, ArrayList<String> deliver_lng, ArrayList<String> deliver_address, ArrayList<String> pickup_lat, ArrayList<String> pickup_lng, ArrayList<String> pickup_address, ArrayList<String> description, ArrayList<String> name, ArrayList<String> total_price, ArrayList<String> discount_cost, ArrayList<String> total_price_after_discount, ArrayList<String> payment_type, ArrayList<String> status, ArrayList<String> created_at, ArrayList<String> image_path_val) {
        this.id = id;
        this.number = number;
        this.deliver_lat = deliver_lat;
        this.deliver_lng = deliver_lng;
        this.deliver_address = deliver_address;
        this.pickup_lat = pickup_lat;
        this.pickup_lng = pickup_lng;
        this.pickup_address = pickup_address;
        this.description = description;
        this.name = name;
        this.total_price = total_price;
        this.discount_cost = discount_cost;
        this.total_price_after_discount = total_price_after_discount;
        this.payment_type = payment_type;
        this.status = status;
        this.created_at = created_at;
        this.image_path_val = image_path_val;
    }

    public ArrayList<String> getId() {
        return id;
    }

    public void setId(ArrayList<String> id) {
        this.id = id;
    }

    public ArrayList<String> getNumber() {
        return number;
    }

    public void setNumber(ArrayList<String> number) {
        this.number = number;
    }

    public ArrayList<String> getDeliver_lat() {
        return deliver_lat;
    }

    public void setDeliver_lat(ArrayList<String> deliver_lat) {
        this.deliver_lat = deliver_lat;
    }

    public ArrayList<String> getDeliver_lng() {
        return deliver_lng;
    }

    public void setDeliver_lng(ArrayList<String> deliver_lng) {
        this.deliver_lng = deliver_lng;
    }

    public ArrayList<String> getDeliver_address() {
        return deliver_address;
    }

    public void setDeliver_address(ArrayList<String> deliver_address) {
        this.deliver_address = deliver_address;
    }

    public ArrayList<String> getPickup_lat() {
        return pickup_lat;
    }

    public void setPickup_lat(ArrayList<String> pickup_lat) {
        this.pickup_lat = pickup_lat;
    }

    public ArrayList<String> getPickup_lng() {
        return pickup_lng;
    }

    public void setPickup_lng(ArrayList<String> pickup_lng) {
        this.pickup_lng = pickup_lng;
    }

    public ArrayList<String> getPickup_address() {
        return pickup_address;
    }

    public void setPickup_address(ArrayList<String> pickup_address) {
        this.pickup_address = pickup_address;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }

    public ArrayList<String> getName() {
        return name;
    }

    public void setName(ArrayList<String> name) {
        this.name = name;
    }

    public ArrayList<String> getTotal_price() {
        return total_price;
    }

    public void setTotal_price(ArrayList<String> total_price) {
        this.total_price = total_price;
    }

    public ArrayList<String> getDiscount_cost() {
        return discount_cost;
    }

    public void setDiscount_cost(ArrayList<String> discount_cost) {
        this.discount_cost = discount_cost;
    }

    public ArrayList<String> getTotal_price_after_discount() {
        return total_price_after_discount;
    }

    public void setTotal_price_after_discount(ArrayList<String> total_price_after_discount) {
        this.total_price_after_discount = total_price_after_discount;
    }

    public ArrayList<String> getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(ArrayList<String> payment_type) {
        this.payment_type = payment_type;
    }

    public ArrayList<String> getStatus() {
        return status;
    }

    public void setStatus(ArrayList<String> status) {
        this.status = status;
    }

    public ArrayList<String> getCreated_at() {
        return created_at;
    }

    public void setCreated_at(ArrayList<String> created_at) {
        this.created_at = created_at;
    }

    public ArrayList<String> getImage_path_val() {
        return image_path_val;
    }

    public void setImage_path_val(ArrayList<String> image_path_val) {
        this.image_path_val = image_path_val;
    }
}
