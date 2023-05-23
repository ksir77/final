package com.example.exchanger4;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class datPicker extends AppCompatActivity {

    private static final String PREFS_NAME = "com.example.exchanger4";
    private static final String PREFS_KEY_IS_FIRST_RUN = "is_first_run";

    private CurrencyDBHelper dbHelper;
    private SQLiteDatabase db;
    //    private RecyclerView recyclerView;
//    private CurrencyAdapter adapter;
    private List<Currency> currencies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dbHelper = new CurrencyDBHelper(this);
        db = dbHelper.getWritableDatabase();

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean isFirstRun = prefs.getBoolean(PREFS_KEY_IS_FIRST_RUN, true);
        if (isFirstRun) {
            insertCurrencyData("USD", 70.5, 73.5);
            insertCurrencyData("EUR", 80.2, 83.4);
            insertCurrencyData("GBP", 90.1, 94.7);
            // добавьте сюда другие валюты
            prefs.edit().putBoolean(PREFS_KEY_IS_FIRST_RUN, false).apply();
        }

        currencies = getCurrencyData();

//        adapter = new CurrencyAdapter(currencies);
//        recyclerView.setAdapter(adapter);
    }

    private void insertCurrencyData(String name, double buyPrice, double sellPrice) {
        ContentValues values = new ContentValues();
        values.put(CurrencyDBHelper.COLUMN_NAME, name);
        values.put(CurrencyDBHelper.COLUMN_BUY_PRICE, buyPrice);
        values.put(CurrencyDBHelper.COLUMN_SELL_PRICE, sellPrice);

        long newRowId = db.insert(CurrencyDBHelper.TABLE_NAME, null, values);
    }

    private List<Currency> getCurrencyData() {
        String[] projection = {
                CurrencyDBHelper.COLUMN_NAME,
                CurrencyDBHelper.COLUMN_BUY_PRICE,
                CurrencyDBHelper.COLUMN_SELL_PRICE
        };

        Cursor cursor = db.query(
                CurrencyDBHelper.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        List<Currency> currencies = new ArrayList<>();
        while(cursor.moveToNext()) {
            String name = cursor.getString(
                    cursor.getColumnIndexOrThrow(CurrencyDBHelper.COLUMN_NAME));
            double buyPrice = cursor.getDouble(
                    cursor.getColumnIndexOrThrow(CurrencyDBHelper.COLUMN_BUY_PRICE));
            double sellPrice = cursor.getDouble(
                    cursor.getColumnIndexOrThrow(CurrencyDBHelper.COLUMN_SELL_PRICE));

            currencies.add(new Currency(name, buyPrice, sellPrice));
        }
        cursor.close();

        return currencies;
    }





}