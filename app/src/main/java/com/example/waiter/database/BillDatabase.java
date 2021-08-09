package com.example.waiter.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.waiter.model.Bill;
import com.example.waiter.model.Tables;

import java.util.ArrayList;

public class BillDatabase extends SQLiteOpenHelper {
    Tables tables;
    public final static String a = "";
    public BillDatabase(Context context, String name) {
        super(context,name, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE BILL(ID INTEGER PRIMARY KEY, IMAGE INT, NAME TEXT , PRICE INT,QUANTITY INT,TT INT)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addBill (String image, String name,int price,int quantity ,int tt ){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("IMAGE",image);
        contentValues.put("NAME",name);
        contentValues.put("QUANTITY",quantity);
        contentValues.put("PRICE",price);
        contentValues.put("TT",tt);
        db.insert("BILL", null,contentValues);
        db.close();

    }

    public ArrayList<Bill> getAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query= "SELECT * FROM BILL";
        Cursor cursor = db.rawQuery(query,null);
        ArrayList<Bill> arrayList = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                Bill bill = new Bill();

                bill.setIdBill(cursor.getInt(cursor.getColumnIndex("ID")));
                bill.setImageBill(cursor.getString(cursor.getColumnIndex("IMAGE")));
                bill.setNameBill(cursor.getString(cursor.getColumnIndex("NAME")));
                bill.setQuantityBill(cursor.getInt(cursor.getColumnIndex("QUANTITY")));
                bill.setPriceBill(cursor.getInt(cursor.getColumnIndex("PRICE")));
                bill.settBill(cursor.getInt(cursor.getColumnIndex("TT")));


                arrayList.add(bill);
            }while (cursor.moveToNext());
        }
        db.close();

        return arrayList;
    }
    public void delete(Bill bill){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("BILL", "ID = "+bill.getIdBill(),null);
        db.close();
    }
    public void update(Bill bill){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("IMAGE", bill.getImageBill());
        contentValues.put("NAME",bill.getNameBill());
        contentValues.put("PRICE",bill.getPriceBill());
        contentValues.put("QUANTITY",bill.getQuantityBill());
        contentValues.put("TT",bill.gettBill());
        db.update("BILL",contentValues,"ID = " +bill.getIdBill(),null);
        db.close();
    }
    public void deleteAll()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("BILL",null,null);
        db.execSQL("DELETE FROM BILL");

        db.close();
    }
    public String nameaa(String name){
        return name;

    }

}