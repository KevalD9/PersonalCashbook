package com.rikin.personalcashbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String TABLE_NAME = "people_table";
    private static final String COL1 = "ID";
    private static final String COL2 = "amount";
    private static final String COL3 = "name";


    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " VARCHAR(20), " + COL3 + " VARCHAR(50))";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean addData1(String amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues1 = new ContentValues();
        contentValues1.put(COL2, amount);

        Log.d(TAG, "addData: Adding " + amount + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues1);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean addData2(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(COL3, name);

        Log.d(TAG, "addData: Adding " + name + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues2);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor getItemID(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL1 + " FROM " + TABLE_NAME +
                " WHERE " + COL2 + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void updateName(String newName, int id, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COL2 +
                " = '" + newName + "' WHERE " + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + oldName + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query);
    }

    /**
     * Delete from database
     * @param id
     * @param name
     */
    public void deleteName(int id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COL1 + " = '" + id + "'" +
                " AND " + COL2 + " = '" + name + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + name + " from database.");
        db.execSQL(query);
    }

    public void insertDatax(String s_Amount,String s_Name)
    {
        ContentValues contentValuesx = new ContentValues();
        contentValuesx.put(COL2,s_Amount);
        contentValuesx.put(COL3,s_Name);

        SQLiteDatabase sqLiteDB = this.getWritableDatabase();
        sqLiteDB.insert(TABLE_NAME,null,contentValuesx);
        sqLiteDB.close();
    }

    public ArrayList<DataModel> getAllData() {
         ArrayList<DataModel> list = new ArrayList<>();
         String sql = "select * from " + TABLE_NAME;
         SQLiteDatabase db = this.getWritableDatabase();
         Cursor cursor = db.rawQuery(sql,null);
         if(cursor.moveToFirst()){
             do{
                 DataModel sm = new DataModel();
                 sm.setId(cursor.getInt(0));
                 sm.setAmount(cursor.getString(1));
                 sm.setDescription(cursor.getString(2));
                 list.add(sm);
             }while(cursor.moveToNext());
         }
         return list;
    }

}

