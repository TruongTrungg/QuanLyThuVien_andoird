package com.example.docgia;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBBaoCao extends SQLiteOpenHelper {
    public DBBaoCao(@Nullable Context context) {
        super(context, "dbBaoCao", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table tbBaoCao(soLuongDG text,soLuongSachMuon text, soLuongSachTra text)";
        db.execSQL(sql);
    }
    public void ThemDL(ThongTinBaoCao baoCao) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sql = "insert into tbBaoCao values (?,?,?)";
        sqLiteDatabase.execSQL(sql, new String[]{baoCao.getSoLuongDocGia().toString(),baoCao.getSoLuongSachMuon().toString(),baoCao.getSoLuongSachMuon().toString()});
    }
    public List<ThongTinBaoCao> DocDL() {
        List<ThongTinBaoCao> data = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String sql = "select * from tbBaoCao";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                ThongTinBaoCao baoCao = new ThongTinBaoCao();
                baoCao.setSoLuongDocGia(cursor.getString(0));
                baoCao.setSoLuongSachMuon(cursor.getString(1));
                baoCao.setSoLuongSachDatra(cursor.getString(2));
                data.add(baoCao);
            }
            while (cursor.moveToNext());

        }
        return data;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
