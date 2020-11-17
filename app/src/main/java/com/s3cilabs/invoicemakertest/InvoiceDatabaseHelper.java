package com.s3cilabs.invoicemakertest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class InvoiceDatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "InvoiceDBHelper";

    public static final String INVOICE_TABLE = "INVOICE_TABLE";
    public static final String COLUMN_INVOICE_NUMBER = "INVOICE_NUMBER";
    public static final String COLUMN_INVOICE_DATE = "INVOICE_DATE";
    public static final String COLUMN_INVOICE_TERMS = "INVOICE_TERMS";
    public static final String COLUMN_INVOICE_SUB_TOTAL_AMOUNT = "INVOICE_SUB_TOTAL_AMOUNT";
    public static final String COLUMN_INVOICE_TAX_AMOUNT = "INVOICE_TAX_AMOUNT";
    public static final String COLUMN_INVOICE_TOTAL_AMOUNT = "INVOICE_TOTAL_AMOUNT";
    public static final String COLUMN_ID = "ID";
    private Context context;

    public InvoiceDatabaseHelper(@Nullable Context context) {
        super(context, "invoice.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + INVOICE_TABLE + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_INVOICE_NUMBER + " TEXT, " +
                COLUMN_INVOICE_DATE + " TEXT, " +
                COLUMN_INVOICE_TERMS + " TEXT, " +
                COLUMN_INVOICE_SUB_TOTAL_AMOUNT + " DEC, " +
                COLUMN_INVOICE_TAX_AMOUNT + " DEC, " +
                COLUMN_INVOICE_TOTAL_AMOUNT + " DEC)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addInvoice(Invoice invoice){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_INVOICE_NUMBER, invoice.getInvoiceNumber());
        cv.put(COLUMN_INVOICE_DATE, invoice.getInvoiceDate());
        cv.put(COLUMN_INVOICE_TERMS, invoice.getInvoiceTerms());
        cv.put(COLUMN_INVOICE_SUB_TOTAL_AMOUNT, invoice.getInvoiceSubTotalAmount());
        cv.put(COLUMN_INVOICE_TAX_AMOUNT, invoice.getInvoiceTaxAmount());
        cv.put(COLUMN_INVOICE_TOTAL_AMOUNT, invoice.getInvoiceTotalAmount());

        long insert = db.insert(INVOICE_TABLE, null, cv);
        if(insert == -1){
            return false;
        } else {
            return true;
        }
    }

    public boolean updateInvoice(Invoice invoice){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

//        cv.put(COLUMN_ID, invoice.getInvoiceId());
        cv.put(COLUMN_INVOICE_NUMBER, invoice.getInvoiceNumber());
        cv.put(COLUMN_INVOICE_DATE, invoice.getInvoiceDate());
        cv.put(COLUMN_INVOICE_TERMS, invoice.getInvoiceTerms());
        cv.put(COLUMN_INVOICE_SUB_TOTAL_AMOUNT, invoice.getInvoiceSubTotalAmount());
        cv.put(COLUMN_INVOICE_TAX_AMOUNT, invoice.getInvoiceTaxAmount());
        cv.put(COLUMN_INVOICE_TOTAL_AMOUNT, invoice.getInvoiceTotalAmount());

        //TODO How to pass the ID as the last parameter?
        long result = db.update(INVOICE_TABLE, cv, "ID=?", new String[]{String.valueOf(invoice.getInvoiceId())});
//        long result = db.update(INVOICE_TABLE, cv, "ID=?", new String[]{COLUMN_ID});

        if (result == -1){
            Log.d(TAG, "updateData: failed");
            return false;
        } else {
            Log.d(TAG, "updateData: started");
            return true;
        }
    }

    public List<Invoice> getAllInvoices(){
        List<Invoice> returnList = new ArrayList<>();
        //Get data from the database

        String queryString = "SELECT * FROM " + INVOICE_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        //Cursor is the result set
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            //Loop through the cursor (result set) and create new customer objects.
            //Put them into the return list.
            do {
                int invoiceID = cursor.getInt(0);
                String invoiceNumber = cursor.getString(1);
                String invoiceDate = cursor.getString(2);
                String invoiceTerms = cursor.getString(3);
                double invoiceSubTotalAmount = cursor.getDouble(4);
                double invoiceTaxAmount = cursor.getDouble(5);
                double invoiceTotalAmount = cursor.getDouble(6);

                Invoice newInvoice = new Invoice(invoiceID, invoiceNumber, invoiceDate, invoiceTerms,
                        invoiceSubTotalAmount, invoiceTaxAmount, invoiceTotalAmount);
                returnList.add(newInvoice);

            } while (cursor.moveToNext());
        } else {
            //Failure. Do not anything to the list.
        }

        cursor.close();
        db.close();
        return returnList;
    }

    public boolean deleteInvoice(Invoice invoice){
        //Find invoice in the database. If it is found, delete it and return true.
        //If it is not found return false.
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + INVOICE_TABLE + " WHERE " + COLUMN_ID + " = " + invoice.getInvoiceId();

        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()){
            return true;
        } else {
            return false;
        }
    }
}
