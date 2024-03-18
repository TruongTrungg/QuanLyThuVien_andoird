package com.example.docgia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SachActivity extends AppCompatActivity {
    String loaisach;
    EditText edmasach,edtensach,edtacgia;
    Spinner sploaisach;
    Button btdocdata,btthem,btcapnhat,btxoa,btdocgia,btmuosach,bthome,btThongKe;
    ListView lv;
    ArrayAdapter adapter;
    DBSach dbSach;
    List<ThongTinSach> data_sach = new ArrayList<>();
    static ArrayList<ThongTinSach> dsThongtinsach = new ArrayList<>();
    AdapterSach adapterSach;
    int vitri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sach);
        setTitle("Quản Lý Thư Viện");
        setControl();
        setEvent();
    }

    private void setEvent() {
        btThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SachActivity.this,BaoCaoActivity.class);
                startActivity(intent);
            }
        });
        bthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SachActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        btmuosach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SachActivity.this,MuonsachActivity.class);
                startActivity(intent);
            }
        });
        btdocgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SachActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        dbSach = new DBSach(this);
        ArrayList<String> ar = new ArrayList<>();
        ar.add("SGK");
        ar.add("Tiểu Thuyết");
        ArrayAdapter arrayAdapter=new ArrayAdapter(SachActivity.this, android.R.layout.simple_spinner_dropdown_item,ar);
        sploaisach.setAdapter(arrayAdapter);
        sploaisach.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                loaisach = ar.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //lay vi tri view duoc chon
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ThongTinSach thongTinSach = dsThongtinsach.get(i);
                edmasach.setText(thongTinSach.getMasach());
                edtensach.setText(thongTinSach.getTensach());
                edtacgia.setText(thongTinSach.getTacgia());
                if(thongTinSach.getLoaisach().equals("SGK")){
                    sploaisach.setSelection(0  );
                }
                else {
                    sploaisach.setSelection(1);
                }
            }
        });
        // xoa
        btxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThongTinSach thongTinSach = new ThongTinSach();
                thongTinSach.setMasach(edmasach.getText().toString());
                dbSach.XoaDL(thongTinSach);
                adapterSach.notifyDataSetChanged();// cap nhat lai listview
            }
        });
        //them
        btthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThongTinSach sach = new ThongTinSach();
                sach.setMasach(edmasach.getText().toString());
                sach.setTensach(edtensach.getText().toString());
                sach.setLoaisach(sploaisach.getSelectedItem().toString());
                sach.setTacgia(edtacgia.getText().toString());
                dbSach.ThemDL(sach);
                Toast.makeText(SachActivity.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();

            }
        });
        //cap nhat
        btcapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThongTinSach sach = new ThongTinSach();
                sach.setMasach(edmasach.getText().toString());
                sach.setTensach(edtensach.getText().toString());
                sach.setLoaisach(sploaisach.getSelectedItem().toString());
                sach.setTacgia(edtacgia.getText().toString());
                dbSach.CapNhat(sach);
                Toast.makeText(SachActivity.this, "Cập Nhật Thành Công", Toast.LENGTH_SHORT).show();
                adapterSach.notifyDataSetChanged();
            }
        });
        //Đoc data
        btdocdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dsThongtinsach.clear();
                dsThongtinsach.addAll(dbSach.DocDL());
                adapterSach = new AdapterSach(dsThongtinsach);
                adapterSach.notifyDataSetChanged();
                lv.setAdapter(adapterSach);
                Toast.makeText(SachActivity.this, "Đọc Thành Công", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void setControl() {
        bthome = findViewById(R.id.bthome);
        btmuosach = findViewById(R.id.btmuonsach);
        btdocgia = findViewById(R.id.btdocgia);
        btdocdata = findViewById(R.id.btdocdatasach);
        edmasach = findViewById(R.id.edmasach);
        edtensach = findViewById(R.id.edtensach);
        edtacgia = findViewById(R.id.edtacgia);
        btthem = findViewById(R.id.btthemsach);
        btcapnhat = findViewById(R.id.btcapnhatsach);
        btxoa = findViewById(R.id.btxoasach);
        sploaisach = findViewById(R.id.sploaisach);
        lv = findViewById(R.id.lvquanlysach);
        btThongKe = findViewById(R.id.btThongKe);
    }
}