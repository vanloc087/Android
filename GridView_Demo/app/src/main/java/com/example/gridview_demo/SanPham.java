package com.example.gridview_demo;

import android.graphics.Bitmap;

public class SanPham {
    private int id;
    private int hinhAnh;
    private double donGia;
    private String ten;
    private String ngaySX;
    private String hanSuDung;
    private String moTa;
    private String thuongHieu;

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getId() {
        return id;
    }

    public double getDonGia() {
        return donGia;
    }

    public String getTen() {
        return ten;
    }

    public String getNgaySX() {
        return ngaySX;
    }

    public String getHanSuDung() {
        return hanSuDung;
    }

    public String getMoTa() {
        return moTa;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNgaySX(String ngaySX) {
        this.ngaySX = ngaySX;
    }

    public void setHanSuDung(String hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public SanPham(int id, int hinhAnh, double donGia, String ten, String ngaySX, String hanSuDung, String moTa, String thuongHieu) {
        this.id = id;
        this.hinhAnh = hinhAnh;
        this.donGia = donGia;
        this.ten = ten;
        this.ngaySX = ngaySX;
        this.hanSuDung = hanSuDung;
        this.moTa = moTa;
        this.thuongHieu = thuongHieu;
    }

    public SanPham(int id, double donGia, String ten, String ngaySX, String hanSuDung, String moTa, String thuongHieu) {
        this.id = id;
        this.donGia = donGia;
        this.ten = ten;
        this.ngaySX = ngaySX;
        this.hanSuDung = hanSuDung;
        this.moTa = moTa;
        this.thuongHieu = thuongHieu;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "donGia=" + donGia +
                ", ten='" + ten + '\'' +
                ", ngaySX='" + ngaySX + '\'' +
                ", hanSuDung='" + hanSuDung + '\'' +
                ", moTa='" + moTa + '\'' +
                ", thuongHieu='" + thuongHieu + '\'' +
                '}';
    }
}
