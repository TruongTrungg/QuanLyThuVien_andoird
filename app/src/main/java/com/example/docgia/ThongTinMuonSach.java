package com.example.docgia;

public class ThongTinMuonSach {
    String masach;
    String madocgia;
    String ngaymuon;
    String ngaytra;
    String tinhtrang;
    String maphieu;

    public ThongTinMuonSach() {
    }

    public ThongTinMuonSach(String masach, String madocgia, String ngaymuon, String ngaytra, String tinhtrang, String maphieu) {
        this.masach = masach;
        this.madocgia = madocgia;
        this.ngaymuon = ngaymuon;
        this.ngaytra = ngaytra;
        this.tinhtrang = tinhtrang;
        this.maphieu = maphieu;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getMadocgia() {
        return madocgia;
    }

    public void setMadocgia(String madocgia) {
        this.madocgia = madocgia;
    }

    public String getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(String ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public String getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(String ngaytra) {
        this.ngaytra = ngaytra;
    }

    public String getTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        this.tinhtrang = tinhtrang;
    }

    public String getMaphieu() {
        return maphieu;
    }

    public void setMaphieu(String maphieu) {
        this.maphieu = maphieu;
    }

    @Override
    public String toString() {
        return "ThongTinMuonSach{" +
                "masach='" + masach + '\'' +
                ", madocgia='" + madocgia + '\'' +
                ", ngaymuon='" + ngaymuon + '\'' +
                ", ngaytra='" + ngaytra + '\'' +
                ", tinhtrang='" + tinhtrang + '\'' +
                ", maphieu='" + maphieu + '\'' +
                '}';
    }
}
