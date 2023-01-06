package com.resto.resto.dto;

public class PemesananProduk {
    private int id_pemesanan;
    private int id_menu;
    private int quantity;

    public PemesananProduk() {
    }

    public PemesananProduk(int id_pemesanan, int id_menu, int quantity) {
        this.id_pemesanan = id_pemesanan;
        this.id_menu = id_menu;
        this.quantity = quantity;
    }

    public int getId_pemesanan() {
        return id_pemesanan;
    }

    public void setId_pemesanan(int id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
    }

    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}