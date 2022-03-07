package com.example.thuongki2;

import android.graphics.Bitmap;

public class NhanVien {

    private String maso;
    private  String hoten;
    private  String gioitinh;
    private String donvi;
    private Bitmap hinhAnh;

    public NhanVien(String maso, String hoten, String gioitinh, String donvi, Bitmap hinhAnh) {
        this.maso = maso;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.donvi = donvi;
        this.hinhAnh = hinhAnh;
    }

    public NhanVien() {
    }

    public String getMaso() {
        return maso;
    }

    public void setMaso(String maso) {
        this.maso = maso;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public void setHinhAnh(Bitmap hinhAnh){
        this.hinhAnh = hinhAnh;
    }

    public Bitmap getHinhAnh(){
        return  hinhAnh;
    }
    @Override
    public String toString() {
        return "NhanVien" + maso + ","+hoten +"," + gioitinh +","+ donvi ;
    }
}
