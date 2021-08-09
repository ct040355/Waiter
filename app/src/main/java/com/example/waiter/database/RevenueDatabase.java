package com.example.waiter.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.waiter.model.Bill;
import com.example.waiter.model.Revenue;

import java.util.ArrayList;

public class RevenueDatabase extends SQLiteOpenHelper {
    public RevenueDatabase(Context context) {
        super(context, "Revenue", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE REVENUE(ID INTEGER PRIMARY KEY, DATE TEXT, MONTH TEXT , YEAR TEXT,TIME TEXT, NAME TEXT,MONEY INT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addRevenue (String date, String month,String year,String time, String name ,int money ){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE",date);
        contentValues.put("MONTH",month);
        contentValues.put("YEAR",year);
        contentValues.put("TIME",time);
        contentValues.put("NAME",name);
        contentValues.put("MONEY",money);
        db.insert("REVENUE", null,contentValues);
        db.close();

    }
    public ArrayList<Revenue> getAllR(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query= "SELECT * FROM REVENUE";
        Cursor cursor = db.rawQuery(query,null);
        ArrayList<Revenue> arrayList = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                Revenue revenue = new Revenue();

                revenue.setIdR(cursor.getInt(cursor.getColumnIndex("ID")));

                revenue.setDate(cursor.getString(cursor.getColumnIndex("DATE")));
                revenue.setMonth(cursor.getString(cursor.getColumnIndex("MONTH")));
                revenue.setYear(cursor.getString(cursor.getColumnIndex("YEAR")));
                revenue.setTime(cursor.getString(cursor.getColumnIndex("TIME")));
                revenue.setName(cursor.getString(cursor.getColumnIndex("NAME")));
                revenue.setMoney(cursor.getInt(cursor.getColumnIndex("MONEY")));



                arrayList.add(revenue);
            }while (cursor.moveToNext());
        }
        db.close();

        return arrayList;
    }
}
