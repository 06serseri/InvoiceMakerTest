package com.s3cilabs.invoicemakertest.Customer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CustomerDatabaseHelper extends SQLiteOpenHelper {

    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String COLUMN_CUSTOMER_NAME = "CUSTOMER_NAME";
    public static final String COLUMN_CUSTOMER_BILL_TO_ADDRESS = "CUSTOMER_BILL_TO_ADDRESS";
    public static final String COLUMN_CUSTOMER_SHIP_TO_ADDRESS = "CUSTOMER_SHIP_TO_ADDRESS";
    public static final String COLUMN_CUSTOMER_EMAIL = "CUSTOMER_EMAIL";
    public static final String COLUMN_CUSTOMER_PHONE = "CUSTOMER_PHONE";
    public static final String COLUMN_ID = "ID";

    public CustomerDatabaseHelper(@Nullable Context context) {
        super(context, "customer.db", null, 1);
    }

    //TODO https://www.youtube.com/watch?v=Hxt5S1hfg9g&list=PLhPyEFL5u-i1j8UdN4i5awkrhfRCT_pnl&index=66 5.30

    //This is called the first time database is accessed. THere should be code in here to create a new database
    @Override
    public void onCreate(SQLiteDatabase db) {
            String createTableStatement = "CREATE TABLE " + CUSTOMER_TABLE + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_CUSTOMER_NAME + " TEXT,  " +
                    COLUMN_CUSTOMER_BILL_TO_ADDRESS + " TEXT, " +
                    COLUMN_CUSTOMER_SHIP_TO_ADDRESS + " TEXT, " +
                    COLUMN_CUSTOMER_EMAIL + " TEXT, " +
                    COLUMN_CUSTOMER_PHONE + " INT)";

            db.execSQL(createTableStatement);

    }
    //This is called if the database number changes. It prevents previous users apps from breaking when you change the database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
