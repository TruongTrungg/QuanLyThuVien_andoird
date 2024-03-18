package com.example.docgia;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptertt extends BaseAdapter {
    private ArrayList<ThongTin> dsthongtin;

    public Adaptertt(ArrayList<ThongTin> dsthongtin) {
        this.dsthongtin = dsthongtin;
    }

    @Override
    public int getCount() {
        return dsthongtin.size(); // do dai mang
    }

    @Override
    public Object getItem(int i) {
        return dsthongtin.get(i); // vi tri
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewtemp;
        viewtemp=View.inflate(viewGroup.getContext(),R.layout.customlistview,null);
        ThongTin tt = dsthongtin.get(i);
        // anh xa
        TextView tvten,tvngaysinh,tvcccd,tvmadg;
        tvmadg=viewtemp.findViewById(R.id.tvmadocgia);
        tvten=viewtemp.findViewById(R.id.tvten);
        tvngaysinh=viewtemp.findViewById(R.id.tvngaysinh);
        tvcccd=viewtemp.findViewById(R.id.tvcccd);
        ImageView img = viewtemp.findViewById(R.id.img);
        tvmadg.setText(tt.madg);
        tvten.setText(tt.ten);
        tvngaysinh.setText(tt.ngaysinh);
        tvcccd.setText(tt.cccd);
        String gt = tt.gioitinh;
        if (gt.equals("Nam")){
            img.setImageResource(R.drawable.boy);
        }
        if (gt.equals("Nu")){
            img.setImageResource(R.drawable.girl);
        }
        return viewtemp;
    }
}
