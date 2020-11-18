package com.indrul.hunter.model;

import java.util.ArrayList;

public class CardModel {
    ArrayList<String> id=new ArrayList<>();
    ArrayList<String>quantity=new ArrayList<>();
    ArrayList<String>product_id=new ArrayList<>();
    ArrayList<String>cart_id=new ArrayList<>();
    ArrayList<String>image_path=new ArrayList<>();
    ArrayList<String>price=new ArrayList<>();
    ArrayList<String>kcal=new ArrayList<>();
    ArrayList<String>category_id=new ArrayList<>();
    ArrayList<String>title=new ArrayList<>();
    ArrayList<String>description=new ArrayList<>();

    public CardModel(ArrayList<String> id, ArrayList<String> quantity, ArrayList<String> product_id, ArrayList<String> cart_id, ArrayList<String> image_path, ArrayList<String> price, ArrayList<String> kcal, ArrayList<String> category_id, ArrayList<String> title, ArrayList<String> description) {
        this.id = id;
        this.quantity = quantity;
        this.product_id = product_id;
        this.cart_id = cart_id;
        this.image_path = image_path;
        this.price = price;
        this.kcal = kcal;
        this.category_id = category_id;
        this.title = title;
        this.description = description;
    }

    public ArrayList<String> getId() {
        return id;
    }

    public void setId(ArrayList<String> id) {
        this.id = id;
    }

    public ArrayList<String> getQuantity() {
        return quantity;
    }

    public void setQuantity(ArrayList<String> quantity) {
        this.quantity = quantity;
    }

    public ArrayList<String> getProduct_id() {
        return product_id;
    }

    public void setProduct_id(ArrayList<String> product_id) {
        this.product_id = product_id;
    }

    public ArrayList<String> getCart_id() {
        return cart_id;
    }

    public void setCart_id(ArrayList<String> cart_id) {
        this.cart_id = cart_id;
    }

    public ArrayList<String> getImage_path() {
        return image_path;
    }

    public void setImage_path(ArrayList<String> image_path) {
        this.image_path = image_path;
    }

    public ArrayList<String> getPrice() {
        return price;
    }

    public void setPrice(ArrayList<String> price) {
        this.price = price;
    }

    public ArrayList<String> getKcal() {
        return kcal;
    }

    public void setKcal(ArrayList<String> kcal) {
        this.kcal = kcal;
    }

    public ArrayList<String> getCategory_id() {
        return category_id;
    }

    public void setCategory_id(ArrayList<String> category_id) {
        this.category_id = category_id;
    }

    public ArrayList<String> getTitle() {
        return title;
    }

    public void setTitle(ArrayList<String> title) {
        this.title = title;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }
}
