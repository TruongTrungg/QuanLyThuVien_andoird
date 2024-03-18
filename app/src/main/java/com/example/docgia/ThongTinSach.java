package com.example.docgia;

public class ThongTinSach {
    String masach;
    String tensach;
    String loaisach;
    String tacgia;

    public ThongTinSach() {
    }

    @Override
    public String toString() {
        return "[Mã sách] : "+masach+" [Tên sách] : "+tensach+" [Loại sách] :"+loaisach+"[Tác giả] :"+tacgia;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public String getLoaisach() {
        return loaisach;
    }

    public void setLoaisach(String loaisach) {
        this.loaisach = loaisach;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public ThongTinSach(String masach, String tensach, String loaisach, String tacgia) {
        this.masach = masach;
        this.tensach = tensach;
        this.loaisach = loaisach;
        this.tacgia = tacgia;
    }
}
