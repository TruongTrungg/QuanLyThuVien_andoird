package com.example.docgia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBDocGia extends SQLiteOpenHelper {
    public DBDocGia(@Nullable Context context) {
        super(context, "dbDocGia", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table tbDocGia(madg text, tendg text, gioitinh text, ngaysinh text, cccd text)";
        db.execSQL(sql);
    }
    public void ThemDL(ThongTin dg) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "insert into tbDocGia values (?,?,?,?,?)";
        sqLiteDatabase.execSQL(sql, new String[]{dg.getMadg().toString(),dg.getTen().toString(), dg.getGioitinh().toString(), dg.getNgaysinh().toString(),dg.getCccd().toString()});

    }
    public void XoaDL(ThongTin dg) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "delete from tbDocGia where madg = ?";
        sqLiteDatabase.execSQL(sql, new String[]{dg.getMadg()});
    }
    public void CapNhat(ThongTin dg) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "Update tbDocGia set tendg=?,gioitinh=?,ngaysinh=?,cccd=? where madg=?";
        sqLiteDatabase.execSQL(sql, new String[]{ dg.getTen(),dg.getGioitinh(), dg.getNgaysinh(),dg.getCccd(),dg.getMadg()});
    }
    public  void XoaHetLuon(ThongTin dg)
    {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        String sql="delete from tbDocGia";
        sqLiteDatabase.execSQL(sql);
    }
    public List<ThongTin> DocDL() {
        List<ThongTin> data = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String sql = "select * from tbDocgia";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                ThongTin dg = new ThongTin();
                dg.setMadg(cursor.getString(0));
                dg.setTen(cursor.getString(1));
                dg.setGioitinh(cursor.getString(2));
                dg.setNgaysinh(cursor.getString(3));
                dg.setCccd(cursor.getString(4));
                data.add(dg);
            }
            while (cursor.moveToNext());

        }
        return data;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1 ) {
    }
}
