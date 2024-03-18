package com.example.docgia;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterSach extends BaseAdapter {
    private ArrayList<ThongTinSach> dsthongtinsach;
    public AdapterSach(ArrayList<ThongTinSach> dsthongtinsach_) {
        this.dsthongtinsach = dsthongtinsach_;
    }
    @Override
    public int getCount() {
        return dsthongtinsach.size();
    }

    @Override
    public Object getItem(int i) {
        return dsthongtinsach.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewtemp;
        viewtemp=View.inflate(viewGroup.getContext(),R.layout.customlistview_quanlysach,null);
        ThongTinSach thongTinSach = dsthongtinsach.get(i);
        // Anh Xa
        TextView tvmasach,tvtensach,tvtacgia;
        tvmasach=viewtemp.findViewById(R.id.tvmasach);
        tvtensach=viewtemp.findViewById(R.id.tvtensach);
        ImageView img = viewtemp.findViewById(R.id.imgloaisach);
        tvtacgia= viewtemp.findViewById(R.id.tvtacgia);
        tvmasach.setText(thongTinSach.masach);
        tvtensach.setText(thongTinSach.tensach);
        tvtacgia.setText(thongTinSach.tacgia);
        String loaiSach = thongTinSach.loaisach;
        if (loaiSach.equals("SGK")){
            img.setImageResource(R.drawable.sgk);
        }
        if (loaiSach.equals("Tiểu Thuyết")){
            img.setImageResource(R.drawable.tt);
        }
        return viewtemp;
    }
}
