package com.example.myapplication;

public class NhanVienModel {
    private int Id;
    private String HoTen;
    private String TinhThanh;
    private String QuanHuyen;
    private String Luong;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getTinhThanh() {
        return TinhThanh;
    }

    public void setTinhThanh(String tinhThanh) {
        TinhThanh = tinhThanh;
    }

    public String getQuanHuyen() {
        return QuanHuyen;
    }

    public void setQuanHuyen(String quanHuyen) {
        QuanHuyen = quanHuyen;
    }

    public String getLuong() {
        return Luong;
    }

    public void setLuong(String luong) {
        Luong = luong;
    }
    public NhanVienModel() {

    }
    public NhanVienModel(String hoTen, String tinhThanh, String quanHuyen, String luong) {

        HoTen = hoTen;
        TinhThanh = tinhThanh;
        QuanHuyen = quanHuyen;
        Luong = luong;
    }

    public NhanVienModel(int id, String hoTen, String tinhThanh, String quanHuyen, String luong) {
        Id = id;
        HoTen = hoTen;
        TinhThanh = tinhThanh;
        QuanHuyen = quanHuyen;
        Luong = luong;
    }
}
