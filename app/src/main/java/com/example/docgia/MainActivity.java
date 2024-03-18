package com.example.docgia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String gioitinh;
    Button btnthem,btncapnhat,btnxoa,btndocdata;
    EditText edten,edngaysinh,edcccd,edmadg;
    Button btnmuonsach,btqlysach,bthome,btThongKe;
    ListView lv;
    Spinner spinner;
    ArrayAdapter adapter;
    DBDocGia dbDocGia;
    List<ThongTin> data_dg = new ArrayList<>();
   static ArrayList<ThongTin> dsthongtin = new ArrayList<>();
    Adaptertt adaptertt;
    int vitri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Quản Lý Thư Viện");
            setControl();
            setEvent();
    }

    private void setEvent() {

        dbDocGia = new DBDocGia(this);
        //adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data_dg);

        bthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        btnmuonsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MuonsachActivity.class);
                startActivity(intent);
            }
        });
        btqlysach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SachActivity.class);
                startActivity(intent);
            }
        });
        btThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,BaoCaoActivity.class);
                startActivity(intent);
            }
        });

        ArrayList<String> ar = new ArrayList<>();
        ar.add("Nam");
        ar.add("Nu");
        ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item,ar);
        spinner.setAdapter(arrayAdapter);
        // lay gia tri gioi tinh
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                gioitinh = ar.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //them
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThongTin docgia = new ThongTin();
                docgia.setMadg(edmadg.getText().toString());
                docgia.setTen(edten.getText().toString());
                docgia.setNgaysinh(edngaysinh.getText().toString());
                docgia.setGioitinh(spinner.getSelectedItem().toString());
                docgia.setCccd(edcccd.getText().toString());
                dbDocGia.ThemDL(docgia);
                Toast.makeText(MainActivity.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();

            }
        });
        //lay vi tri view duoc chon
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ThongTin thongTin = dsthongtin.get(i);
                edmadg.setText(thongTin.getMadg());
                edten.setText(thongTin.getTen());
                edngaysinh.setText(thongTin.getNgaysinh());
                edcccd.setText(thongTin.getCccd());
                if(thongTin.getGioitinh().equals("Nam")){
                    spinner.setSelection(0);
                }
               else {
                    spinner.setSelection(1);
                }
            }
        });
        // xoa
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThongTin tt = new ThongTin();
                tt.setMadg(edmadg.getText().toString());
                dbDocGia.XoaDL(tt);
                adaptertt.notifyDataSetChanged();// cap nhat lai listview
            }
        });
        //cap nhat
        btncapnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThongTin docgia = new ThongTin();
                docgia.setMadg(edmadg.getText().toString());
                docgia.setTen(edten.getText().toString());
                docgia.setNgaysinh(edngaysinh.getText().toString());
                docgia.setGioitinh(spinner.getSelectedItem().toString());
                docgia.setCccd(edcccd.getText().toString());
                dbDocGia.CapNhat(docgia);
                Toast.makeText(MainActivity.this, "Cập Nhật Thành Công", Toast.LENGTH_SHORT).show();
                adaptertt.notifyDataSetChanged();
            }
        });
        //Đoc data
        btndocdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dsthongtin.clear();
                dsthongtin.addAll(dbDocGia.DocDL());
                adaptertt = new Adaptertt(dsthongtin);
                adaptertt.notifyDataSetChanged();
                lv.setAdapter(adaptertt);
                Toast.makeText(MainActivity.this, "Đọc Thành Công", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void setControl() {
        bthome = findViewById(R.id.bthome);
        btqlysach = findViewById(R.id.btquanlysach);
        btnmuonsach = findViewById(R.id.btnmuonsach);
        edmadg = findViewById(R.id.edmadocgia);
        edten = findViewById(R.id.edten);
        edngaysinh = findViewById(R.id.edngaysinh);
        edcccd = findViewById(R.id.edcccd);
        spinner = findViewById(R.id.spinner);
        lv = findViewById(R.id.lv);
        btnthem = findViewById(R.id.btnthem);
        btncapnhat = findViewById(R.id.btncapnhat);
        btnxoa = findViewById(R.id.btnxoa);
        btndocdata = findViewById(R.id.btndocdbdocgia);
        btThongKe = findViewById(R.id.btThongKe);
    }
}