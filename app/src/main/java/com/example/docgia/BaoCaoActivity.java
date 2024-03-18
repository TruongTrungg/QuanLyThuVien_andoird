package com.example.docgia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BaoCaoActivity extends AppCompatActivity {
    TextView tvSoLuongDocGia,tvsoLuongSachMuon,tvSoLuongSachTra;
    Button btdocgia,btsach,btmuonsach,bthome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bao_cao);
        setTitle("Quản Lý Thư Viện");
        setControl();
        setEvent();
    }
DBDocGia dbDocGia = new DBDocGia(BaoCaoActivity.this);
DBMuonSach dbMuonSach = new DBMuonSach(BaoCaoActivity.this);

    private void setEvent() {
        btdocgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BaoCaoActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btmuonsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BaoCaoActivity.this,MuonsachActivity.class);
                startActivity(intent);
            }
        });
        btsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BaoCaoActivity.this,SachActivity.class);
                startActivity(intent);
            }
        });
        bthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BaoCaoActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        int slMaDG = 0,slChuaTra = 0, slDaTra = 0;

        for (int i = 0;i<dbDocGia.DocDL().size();i++){
            slMaDG += 1;

        }
        for (int i = 0;i<dbMuonSach.DocDL().size();i++){
           if (dbMuonSach.DocDL().get(i).tinhtrang.equals("Chưa Trả")){
               slChuaTra+=1;
           }

        }
        for (int i = 0;i<dbMuonSach.DocDL().size();i++){
            if (dbMuonSach.DocDL().get(i).tinhtrang.equals("Đã Trả")){
                slDaTra+=1;
            }

        }

        tvsoLuongSachMuon.setText(slChuaTra+"");
        tvSoLuongDocGia.setText(slMaDG+"");
        tvSoLuongSachTra.setText(slDaTra+"");
    }
    private void setControl() {
        tvSoLuongDocGia = findViewById(R.id.tvSoLuongDocGia);
        tvsoLuongSachMuon = findViewById(R.id.tvSoLuongSachMuon);
        tvSoLuongSachTra = findViewById(R.id.tvSoLuongSachTra);
        bthome = findViewById(R.id.bthome);
        btdocgia= findViewById(R.id.btdocgia);
        btmuonsach = findViewById(R.id.btmuontrasach);
        btsach = findViewById(R.id.btsach);
    }
}