package com.example.docgia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBSach extends SQLiteOpenHelper {
    public DBSach(@Nullable Context context) {
        super(context, "dbsach", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table tbSach(masach text,tensach text,loaisach text,tacgia text)";
        db.execSQL(sql);
    }
    public void ThemDL(ThongTinSach sach) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "insert into tbSach values (?,?,?,?)";
        sqLiteDatabase.execSQL(sql, new String[]{sach.getMasach().toString(),sach.getTensach().toString(), sach.getLoaisach().toString(),sach.getTacgia().toString()});
    }
    public void XoaDL(ThongTinSach sach) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "delete from tbSach where masach = ?";
        sqLiteDatabase.execSQL(sql, new String[]{sach.getMasach()});
    }
    public void CapNhat(ThongTinSach sach) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "Update tbSach set tensach=?,loaisach=?,tacgia=? where masach=?";
        sqLiteDatabase.execSQL(sql, new String[]{ sach.getTensach(),sach.getLoaisach(),sach.getTacgia(),sach.getMasach()});
    }
    public List<ThongTinSach> DocDL() {
        List<ThongTinSach> data = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String sql = "select * from tbSach";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                ThongTinSach sach = new ThongTinSach();
                sach.setMasach(cursor.getString(0));
                sach.setTensach(cursor.getString(1));
                sach.setLoaisach(cursor.getString(2));
                sach.setTacgia(cursor.getString(3));
                data.add(sach);
            }
            while (cursor.moveToNext());

        }
        return data;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
