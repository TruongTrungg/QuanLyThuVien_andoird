package com.example.docgia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapterttms extends BaseAdapter {
    private ArrayList<ThongTinMuonSach> dsthongtinmuosach;
    public Adapterttms(ArrayList<ThongTinMuonSach> dsthongtinmuosach) {
        this.dsthongtinmuosach = dsthongtinmuosach;
    }

    @Override
    public int getCount() {
        return dsthongtinmuosach.size();
    }

    @Override
    public Object getItem(int i) {
        return dsthongtinmuosach.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
      View viewtemp;
       viewtemp=View.inflate(viewGroup.getContext(),R.layout.customlistviewmuonsach,null);
        ThongTinMuonSach thongTinMuonSach = dsthongtinmuosach.get(i);
        // anh xa
        TextView tvmaphieu,tvmasach,tvmadocgia,tvngaymuon,tvngaytra;
        tvmaphieu= viewtemp.findViewById(R.id.tvMaPhieu);
        tvmasach=viewtemp.findViewById(R.id.tvMaSach);
        tvmadocgia=viewtemp.findViewById(R.id.tvMaDocGia);
        tvngaymuon=viewtemp.findViewById(R.id.tvNgayMuon);
        tvngaytra=viewtemp.findViewById(R.id.tvNgayTra);
        ImageView imgtinhtrang = viewtemp.findViewById(R.id.imgTinhTrang);
        tvmaphieu.setText((thongTinMuonSach.maphieu));
        tvmasach.setText(thongTinMuonSach.masach);
        tvmadocgia.setText(thongTinMuonSach.madocgia);
        tvngaymuon.setText(thongTinMuonSach.ngaymuon);
        tvngaytra.setText(thongTinMuonSach.ngaytra);
        String tinhTrang = thongTinMuonSach.tinhtrang;
        if (tinhTrang.equals("Chưa Trả")){
            imgtinhtrang.setImageResource(R.drawable.x);
        }
        if (tinhTrang.equals("Đã Trả")){
            imgtinhtrang.setImageResource(R.drawable.v);
        }
        return viewtemp;
    }
}
