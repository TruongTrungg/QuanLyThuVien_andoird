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

public class MuonsachActivity extends AppCompatActivity {
    String tinhTrang;
    Button docgia,btnthemsach,btncapnhatsach,btnxoasach,btndocdata,btsach,bthome,btThongKe;
    EditText edngaymuon,edngaytra,edmaphieu;
    Spinner spMaSach,spMaDocGia,spTinhTrang;
    ListView lvmuonsach;
    ArrayAdapter adapter;
    DBMuonSach dbMuonSach;
    List<ThongTinMuonSach> data_ms = new ArrayList<>();
    static ArrayList<ThongTinMuonSach> dsthongtinmuonsach = new ArrayList<>();
    Adapterttms adapterttms;
    ArrayList<ThongTinSach> ttSach = new ArrayList<>();
    DBSach dbSach;
    ArrayList<ThongTin> ttdocgia = new ArrayList<>();
    DBDocGia dbDocGia;
    int vitri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muonsach);
        setTitle("Quản Lý Thư Viện");
        setControl();
        setEvent();
    }
    private void setEvent() {

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data_ms);
        dbMuonSach = new DBMuonSach(this);
        docgia = findViewById(R.id.btndocgia);
        btThongKe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MuonsachActivity.this,BaoCaoActivity.class);
                startActivity(intent);
            }
        });
        bthome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MuonsachActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
        btsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MuonsachActivity.this,SachActivity.class);
                startActivity(intent);
            }
        });
        docgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MuonsachActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        // khoi tao ma doc gia
        ArrayList<String> armadocgia = new ArrayList<>();
        dbDocGia = new DBDocGia(this);
        ttdocgia.addAll(dbDocGia.DocDL());
        for (int i = 0; i < ttdocgia.size(); i++){
            armadocgia.add(ttdocgia.get(i).madg);
        }
        ArrayAdapter arrayAdapterMaDocGia=new ArrayAdapter(MuonsachActivity.this, android.R.layout.simple_spinner_dropdown_item,armadocgia);
        spMaDocGia.setAdapter(arrayAdapterMaDocGia);
        //khoi tao ma sach
        ArrayList<String> armasach = new ArrayList<>();
        dbSach = new DBSach(this);
        ttSach.addAll(dbSach.DocDL());
        for (int i = 0;i<ttSach.size();i++){
            armasach.add(ttSach.get(i).masach);
        }
        ArrayAdapter arrayAdapterMaSach=new ArrayAdapter(MuonsachActivity.this, android.R.layout.simple_spinner_dropdown_item,armasach);
        spMaSach.setAdapter(arrayAdapterMaSach);
        //khoi tao tinh trang
        ArrayList<String> ar = new ArrayList<>();
        ar.add("Chưa Trả");
        ar.add("Đã Trả");
        ArrayAdapter arrayAdapter=new ArrayAdapter(MuonsachActivity.this, android.R.layout.simple_spinner_dropdown_item,ar);
        spTinhTrang.setAdapter(arrayAdapter);
        // lay gia tri Tinh Trang
        spTinhTrang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                 tinhTrang = ar.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        lvmuonsach.setAdapter(adapterttms);
        //them
        btnthemsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThongTinMuonSach muonSach = new ThongTinMuonSach();
                muonSach.setMaphieu(edmaphieu.getText().toString());
                muonSach.setMasach(spMaSach.getSelectedItem().toString());
                muonSach.setMadocgia(spMaDocGia.getSelectedItem().toString());
                muonSach.setNgaymuon(edngaymuon.getText().toString());
                muonSach.setNgaytra(edngaytra.getText().toString());
                muonSach.setTinhtrang(spTinhTrang.getSelectedItem().toString());
                dbMuonSach.ThemDL(muonSach);
                Toast.makeText(MuonsachActivity.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();

            }
        });
        //lay vi tri view duoc chon
        lvmuonsach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ThongTinMuonSach ms = dsthongtinmuonsach.get(i);
              //  Toast.makeText(MuonsachActivity.this,dbSach.DocDL().get(1).masach.toString() , Toast.LENGTH_SHORT).show();
                edmaphieu.setText(ms.getMaphieu());
                for(int j = 0;j<dbSach.DocDL().size();j++)
                {
                    if(ms.getMasach().toString().equals(ttSach.get(j).masach.toString())){
                        spMaSach.setSelection(j);
                        break;
                    }
                }
                for(int j = 0;j<dbDocGia.DocDL().size();j++)
                {
                    if(ms.getMadocgia().toString().equals(dbDocGia.DocDL().get(j).madg)){
                        spMaDocGia.setSelection(j);
                        break;
                    }
                }
                edngaymuon.setText(ms.getNgaymuon());
                edngaytra.setText(ms.getNgaytra());
                if(ms.getTinhtrang().equals("Chưa Trả")){
                    spTinhTrang.setSelection(0);
                }
                else {
                    spTinhTrang.setSelection(1);
                }

            }
        });
        // xoa
        btnxoasach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThongTinMuonSach muonSach = new ThongTinMuonSach();
                muonSach.setMaphieu(edmaphieu.getText().toString());
                dbMuonSach.XoaDL(muonSach);
                Toast.makeText(MuonsachActivity.this, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                adapterttms.notifyDataSetChanged();// cap nhat lai listview
            }
        });
        //cap nhat
        btncapnhatsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThongTinMuonSach muonSach = new ThongTinMuonSach();
                muonSach.setMaphieu(edmaphieu.getText().toString());
                muonSach.setMasach(spMaSach.getSelectedItem().toString());
                muonSach.setMadocgia(spMaDocGia.getSelectedItem().toString());
                muonSach.setNgaymuon(edngaymuon.getText().toString());
                muonSach.setNgaytra(edngaytra.getText().toString());
                muonSach.setTinhtrang(spTinhTrang.getSelectedItem().toString());
                dbMuonSach.CapNhat(muonSach);
                Toast.makeText(MuonsachActivity.this, "Cập Nhật Thành Công", Toast.LENGTH_SHORT).show();
                adapterttms.notifyDataSetChanged();
            }
        });
        //Đoc data
        btndocdata.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dsthongtinmuonsach.clear();
                dsthongtinmuonsach.addAll(dbMuonSach.DocDL());
                adapterttms = new Adapterttms(dsthongtinmuonsach );
                adapterttms.notifyDataSetChanged();
                lvmuonsach.setAdapter(adapterttms);
                // Toast.makeText(MuonsachActivity.this, "Đọc Thành Công", Toast.LENGTH_SHORT).show();
//                Toast.makeText(MuonsachActivity.this, dsthongtinmuonsach.get(1).tinhtrang.toString(), Toast.LENGTH_SHORT).show();
            }
        }));
    }
    private void setControl() {
        edmaphieu = findViewById(R.id.edMaPhieu);
        bthome = findViewById(R.id.bthome);
        btsach = findViewById(R.id.btSach);
        edngaymuon = findViewById(R.id.edngaymuon);
        edngaytra = findViewById(R.id.edngaytra);
        btnthemsach = findViewById(R.id.btnthemsach);
        btncapnhatsach = findViewById(R.id.btncapnhatsach);
        btnxoasach = findViewById(R.id.btnxoasach);
        lvmuonsach = findViewById(R.id.lvmuonsach);
        btndocdata = findViewById(R.id.btndocdatams);
        spMaDocGia = findViewById(R.id.spMaDocGia);
        spMaSach = findViewById(R.id.spMaSach);
        spTinhTrang = findViewById(R.id.spTinhTrang);
        btThongKe = findViewById(R.id.btThongKe);
    }
}