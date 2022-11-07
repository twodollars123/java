package model;

import java.io.Serializable;

public class SachThamKhoa implements Serializable {

    private String MaS;
    private float donGia;
    private int soLuong;
    private String nhaXuatBan;
    private float thue;
    private float thanhTien;

    public SachThamKhoa() {
    }

    public String getMaS() {
        return MaS;
    }

    public void setMaS(String MaS) {
        this.MaS = MaS;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public float getThue() {
        return thue;
    }

    public void setThue(float thue) {
        this.thue = thue;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thue) {
        this.thanhTien = soLuong * donGia + thue;
    }
}
