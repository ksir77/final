package com.example.exchanger4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CurrencyDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "currency.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "currency";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_BUY_PRICE = "buy_price";
    public static final String COLUMN_SELL_PRICE = "sell_price";

    public CurrencyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_NAME + " TEXT," +
                COLUMN_BUY_PRICE + " REAL," +
                COLUMN_SELL_PRICE + " REAL" +
                ")";

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public void clearData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null); // TABLE_NAME - имя вашей таблицы
        db.close();
    }

}
