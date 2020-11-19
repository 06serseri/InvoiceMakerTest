package com.s3cilabs.invoicemakertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CompanyActivity extends AppCompatActivity {
    private static final String TAG = "CompanyActivity";
    TextView textViewCompanyName, textViewCompanyAddress, textViewCompanyPhone, textViewCompanyEmail,
            textViewCompanyHst, textViewCompanyRemittance;
    EditText editTextCompanyName, editTextCompanyAddress, editTextCompanyPhone, editTextCompanyEmail,
            editTextCompanyHst, editTextCompanyRemittance;
    Button buttonSaveCompany;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        initViews();

        buttonSaveCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompanyActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initViews() {
        Log.d(TAG, "initViews Started");
        textViewCompanyName = findViewById(R.id.textViewCompanyName);
        textViewCompanyAddress = findViewById(R.id.textViewCompanyAddress);
        textViewCompanyPhone = findViewById(R.id.textViewCompanyPhone);
        textViewCompanyEmail = findViewById(R.id.textViewCompanyEmail);
        textViewCompanyHst = findViewById(R.id.textViewCompanyHst);
        textViewCompanyRemittance = findViewById(R.id.textViewCompanyRemittance);

        editTextCompanyName = findViewById(R.id.editTextCompanyName);
        editTextCompanyAddress = findViewById(R.id.editTextCompanyAddress);
        editTextCompanyPhone = findViewById(R.id.editTextCompanyPhone);
        editTextCompanyEmail = findViewById(R.id.editTextCompanyEmail);
        editTextCompanyHst = findViewById(R.id.editTextCompanyHst);
        editTextCompanyRemittance = findViewById(R.id.editTextCompanyRemittance);

        buttonSaveCompany = findViewById(R.id.buttonSaveCompany);
    }
}