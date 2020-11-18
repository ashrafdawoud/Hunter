package com.indrul.hunter.model;

import android.util.Log;

import java.util.ArrayList;

public class PlacesModel {
    ArrayList<String> place_ida=new ArrayList<>();
    ArrayList<String> place_image_patha=new ArrayList<>();
    ArrayList<String> place_lata=new ArrayList<>();
    ArrayList<String> place_lnga=new ArrayList<>();
    ArrayList<String> place_addressa=new ArrayList<>();
    ArrayList<String> place_promoteda=new ArrayList<>();
    ArrayList<String> place_image_path_vala=new ArrayList<>();
    ArrayList<String> place_namea=new ArrayList<>();
    ArrayList<String> place_desca=new ArrayList<>();
    ArrayList<String> categoriesa=new ArrayList<>();
    ArrayList<String> categories_ida=new ArrayList<>();
    ArrayList<String> categories_created_ata=new ArrayList<>();
    ArrayList<String> categories_namea=new ArrayList<>();
    ArrayList<String> categories_productsa=new ArrayList<>();
   /* ArrayList<String> products_ida=new ArrayList<>();
    ArrayList<String> products_image_patha=new ArrayList<>();
    ArrayList<String> products_pricea=new ArrayList<>();
    ArrayList<String> products_kcala=new ArrayList<>();
    ArrayList<String> products_service_ida=new ArrayList<>();
    ArrayList<String> products_created_ata=new ArrayList<>();
    ArrayList<String> products_image_path_vala=new ArrayList<>();
    ArrayList<String> products_titlea=new ArrayList<>();
    ArrayList<String> products_descriptiona=new ArrayList<>();*/
    ArrayList<String> productsString=new ArrayList<>();

    public PlacesModel(ArrayList<String> place_ida, ArrayList<String> place_image_patha, ArrayList<String> place_lata, ArrayList<String> place_lnga, ArrayList<String> place_addressa, ArrayList<String> place_promoteda, ArrayList<String> place_image_path_vala, ArrayList<String> place_namea, ArrayList<String> place_desca, ArrayList<String> categoriesa, ArrayList<String> categories_ida, ArrayList<String> categories_created_ata, ArrayList<String> categories_namea, ArrayList<String> categories_productsa, ArrayList<String> productsString) {
        this.place_ida = place_ida;
        this.place_image_patha = place_image_patha;
        this.place_lata = place_lata;
        this.place_lnga = place_lnga;
        this.place_addressa = place_addressa;
        this.place_promoteda = place_promoteda;
        this.place_image_path_vala = place_image_path_vala;
        this.place_namea = place_namea;
        this.place_desca = place_desca;
        this.categoriesa = categoriesa;
        this.categories_ida = categories_ida;
        this.categories_created_ata = categories_created_ata;
        this.categories_namea = categories_namea;
        this.categories_productsa = categories_productsa;
        this.productsString = productsString;
    }

    public ArrayList<String> getPlace_ida() {
        return place_ida;
    }

    public void setPlace_ida(ArrayList<String> place_ida) {
        this.place_ida = place_ida;
    }

    public ArrayList<String> getPlace_image_patha() {
        return place_image_patha;
    }

    public void setPlace_image_patha(ArrayList<String> place_image_patha) {
        this.place_image_patha = place_image_patha;
    }

    public ArrayList<String> getPlace_lata() {
        return place_lata;
    }

    public void setPlace_lata(ArrayList<String> place_lata) {
        this.place_lata = place_lata;
    }

    public ArrayList<String> getPlace_lnga() {
        return place_lnga;
    }

    public void setPlace_lnga(ArrayList<String> place_lnga) {
        this.place_lnga = place_lnga;
    }

    public ArrayList<String> getPlace_addressa() {
        return place_addressa;
    }

    public void setPlace_addressa(ArrayList<String> place_addressa) {
        this.place_addressa = place_addressa;
    }

    public ArrayList<String> getPlace_promoteda() {
        return place_promoteda;
    }

    public void setPlace_promoteda(ArrayList<String> place_promoteda) {
        this.place_promoteda = place_promoteda;
    }

    public ArrayList<String> getPlace_image_path_vala() {
        return place_image_path_vala;
    }

    public void setPlace_image_path_vala(ArrayList<String> place_image_path_vala) {
        this.place_image_path_vala = place_image_path_vala;
    }

    public ArrayList<String> getPlace_namea() {
        return place_namea;
    }

    public void setPlace_namea(ArrayList<String> place_namea) {
        this.place_namea = place_namea;
    }

    public ArrayList<String> getPlace_desca() {
        return place_desca;
    }

    public void setPlace_desca(ArrayList<String> place_desca) {
        this.place_desca = place_desca;
    }

    public ArrayList<String> getCategoriesa() {
        return categoriesa;
    }

    public void setCategoriesa(ArrayList<String> categoriesa) {
        this.categoriesa = categoriesa;
    }

    public ArrayList<String> getCategories_ida() {
        return categories_ida;
    }

    public void setCategories_ida(ArrayList<String> categories_ida) {
        this.categories_ida = categories_ida;
    }

    public ArrayList<String> getCategories_created_ata() {
        return categories_created_ata;
    }

    public void setCategories_created_ata(ArrayList<String> categories_created_ata) {
        this.categories_created_ata = categories_created_ata;
    }

    public ArrayList<String> getCategories_namea() {
        return categories_namea;
    }

    public void setCategories_namea(ArrayList<String> categories_namea) {
        this.categories_namea = categories_namea;
    }

    public ArrayList<String> getCategories_productsa() {
        return categories_productsa;
    }

    public void setCategories_productsa(ArrayList<String> categories_productsa) {
        this.categories_productsa = categories_productsa;
    }

    public ArrayList<String> getProductsString() {
        return productsString;
    }

    public void setProductsString(ArrayList<String> productsString) {
        this.productsString = productsString;
    }
}
