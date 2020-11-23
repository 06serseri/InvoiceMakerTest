package com.s3cilabs.invoicemakertest.Customer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.s3cilabs.invoicemakertest.R;

public class CustomerActivity extends AppCompatActivity {
    Button buttonAddCustomerActivity, buttonViewCustomer;
    RecyclerView recyclerViewCustomer;
    RelativeLayout relativeLayoutCustomer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        initViews();

        CustomerDatabaseHelper customerDatabaseHelper = new CustomerDatabaseHelper(CustomerActivity.this);


    }

    private void initViews() {
        buttonAddCustomerActivity = findViewById(R.id.buttonAddCustomerActivity);
        buttonViewCustomer = findViewById(R.id.buttonViewCustomer);
        recyclerViewCustomer = findViewById(R.id.recyclerViewCustomer);
        relativeLayoutCustomer = findViewById(R.id.relativeLayoutCustomer);
    }
}