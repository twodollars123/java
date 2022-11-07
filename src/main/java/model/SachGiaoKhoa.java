package model;

import java.io.Serializable;

public class SachGiaoKhoa implements Serializable {

    private String MaS;
    private float donGia;
    private int soLuong;
    private String nhaXuatBan;
    private String tinhTrang;
    private float thanhTien;

    public SachGiaoKhoa() {
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

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(String tinhTrang) {
        if (tinhTrang.equals("Mới")) {
            thanhTien = soLuong * donGia;
        } else {
            thanhTien = soLuong * donGia * 50 / 100;
        }
    }

}
