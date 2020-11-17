package com.s3cilabs.invoicemakertest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity Started";

    Button buttonAddInvoice,buttonCompanyInfo, buttonCustomerInfo, buttonViewAll;
    List<Invoice> invoiceList = new ArrayList<Invoice>();

    private RecyclerView recyclerViewInvoice;
    private RecyclerViewAdapter mApapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        //TODO is onCreate initiated each time we go back from another activity?

        InvoiceDatabaseHelper invoiceDatabaseHelper = new InvoiceDatabaseHelper(MainActivity.this);
        List<Invoice> invoiceList = invoiceDatabaseHelper.getAllInvoices();
        recyclerViewInvoice.hasFixedSize();
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerViewInvoice.setLayoutManager(layoutManager);
        mApapter = new RecyclerViewAdapter(invoiceList, MainActivity.this);
        recyclerViewInvoice.setAdapter(mApapter);

        //Add invoice
        buttonAddInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddInvoiceActivity.class);
                startActivity(intent);
            }
        });

        //View all invoices
        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InvoiceDatabaseHelper invoiceDatabaseHelper = new InvoiceDatabaseHelper(MainActivity.this);
                List<Invoice> invoiceList = invoiceDatabaseHelper.getAllInvoices();

                recyclerViewInvoice.hasFixedSize();
                layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerViewInvoice.setLayoutManager(layoutManager);

                mApapter = new RecyclerViewAdapter(invoiceList, MainActivity.this);
                recyclerViewInvoice.setAdapter(mApapter);
            }
        });

        //Delete invoice by swiping left
//        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
//            @Override
//            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
//                return false;
//            }
//
//            @Override
//            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//                Invoice invoice =
//                invoiceDatabaseHelper.deleteInvoice(invoice)
//            }
//        })

    }

    private void initViews() {
        recyclerViewInvoice = findViewById(R.id.recyclerViewInvoice);
        buttonAddInvoice = findViewById(R.id.buttonAddInvoice);
        buttonCompanyInfo = findViewById(R.id.buttonCompanyInfo);
        buttonCustomerInfo = findViewById(R.id.buttonCustomerInfo);
        buttonViewAll = findViewById(R.id.buttonViewAll);
    }
}