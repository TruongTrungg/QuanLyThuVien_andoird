package com.example.docgia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBMuonSach extends SQLiteOpenHelper {
    public DBMuonSach(@Nullable Context context) {
        super(context, "dbMuonSach", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
       String sql = "Create table tbMuonSach(maphieu text,masach text,madocgia text,ngaymuon text,ngaytra text,tinhtrang text)";
       db.execSQL(sql);
    }
    public void ThemDL(ThongTinMuonSach ms) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
//        String sql = "drop table tbMuonSach";
//        sqLiteDatabase.execSQL(sql);
        String sql = "insert into tbMuonSach values (?,?,?,?,?,?)";
        sqLiteDatabase.execSQL(sql, new String[]{ms.getMaphieu().toString(),ms.getMasach().toString(),ms.getMadocgia().toString(),ms.getNgaymuon().toString(),ms.getNgaytra().toString(),ms.getTinhtrang().toString()});

    }
    public void XoaDL(ThongTinMuonSach ms) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
//        String sql = "Create table tbMuonSach(maphieu text,masach text,madocgia text,ngaymuon text,ngaytra text,tinhtrang text)";
//        sqLiteDatabase.execSQL(sql);
        String sql = "delete from tbMuonSach where maphieu = ?";
        sqLiteDatabase.execSQL(sql, new String[]{ms.getMaphieu()});
    }
    public void CapNhat(ThongTinMuonSach ms) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "Update tbMuonSach set masach=?,madocgia=?,ngaymuon=?,ngaytra=?,tinhtrang=? where maphieu=?";
        sqLiteDatabase.execSQL(sql, new String[]{ ms.getMasach(), ms.getMadocgia(),ms.getNgaymuon(),ms.getNgaytra(), ms.getTinhtrang(),ms.getMaphieu()});

    }
    public  void XoaHetLuon(ThongTinMuonSach ms)
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="delete from tbMuonSach";
        sqLiteDatabase.execSQL(sql);
    }
    public List<ThongTinMuonSach> DocDL() {
        List<ThongTinMuonSach> data = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String sql = "select * from tbMuonSach";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                ThongTinMuonSach ms = new ThongTinMuonSach();
                ms.setMaphieu(cursor.getString(0));
                ms.setMasach(cursor.getString(1));
                ms.setMadocgia(cursor.getString(2));
                ms.setNgaymuon(cursor.getString(3));
                ms.setNgaytra(cursor.getString(4));
                ms.setTinhtrang(cursor.getString(5));
                data.add(ms);
            }
            while (cursor.moveToNext());

        }
        return data;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
