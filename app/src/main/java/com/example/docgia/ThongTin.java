package com.example.docgia;

public class ThongTin {
    String ten;
    String gioitinh;
    String ngaysinh;
    String cccd;
    String madg;

    public ThongTin() {
    }

    public ThongTin(String ten, String gioitinh, String ngaysinh, String cccd, String madg) {
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.cccd = cccd;
        this.madg = madg;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getMadg() {
        return madg;
    }

    public void setMadg(String madg) {
        this.madg = madg;
    }

    @Override
    public String toString() {
        return "[Mã Đọc Giả] :"+madg+"[Tên] :"+ten+" [Giới Tính] : "+gioitinh+" [Ngày Sinh] :"+ngaysinh+"[CCCD] :"+cccd;
    }
}
