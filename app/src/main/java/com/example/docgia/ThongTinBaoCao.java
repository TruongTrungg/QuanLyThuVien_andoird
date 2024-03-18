package com.example.docgia;

public class ThongTinBaoCao {
    String soLuongDocGia;
    String soLuongSachMuon;
    String soLuongSachDatra;

    public ThongTinBaoCao() {
    }

    public ThongTinBaoCao(String soLuongDocGia, String soLuongSachMuon, String soLuongSachDatra) {
        this.soLuongDocGia = soLuongDocGia;
        this.soLuongSachMuon = soLuongSachMuon;
        this.soLuongSachDatra = soLuongSachDatra;
    }

    public String getSoLuongDocGia() {
        return soLuongDocGia;
    }

    public void setSoLuongDocGia(String soLuongDocGia) {
        this.soLuongDocGia = soLuongDocGia;
    }

    public String getSoLuongSachMuon() {
        return soLuongSachMuon;
    }

    public void setSoLuongSachMuon(String soLuongSachMuon) {
        this.soLuongSachMuon = soLuongSachMuon;
    }

    public String getSoLuongSachDatra() {
        return soLuongSachDatra;
    }

    public void setSoLuongSachDatra(String soLuongSachDatra) {
        this.soLuongSachDatra = soLuongSachDatra;
    }

    @Override
    public String toString() {
        return "ThongTinBaoCao{" +
                "soLuongDocGia='" + soLuongDocGia + '\'' +
                ", soLuongSachMuon='" + soLuongSachMuon + '\'' +
                ", soLuongSachDatra='" + soLuongSachDatra + '\'' +
                '}';
    }
}
