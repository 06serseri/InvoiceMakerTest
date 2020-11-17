package com.s3cilabs.invoicemakertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditInvoiceActivity extends AppCompatActivity {
    private static final String TAG = "EditInvoiceActivity";
    EditText editTextInvoiceTaxAmount2,editTextInvoiceTerms2, editTextInvoiceNumber2, editTextInvoiceDate2,
            editTextInvoiceSubTotalAmount2, editTextInvoiceTotalAmount2;

    TextView textViewInvoiceDate2, textViewInvoiceNumber2, textViewInvoiceTerms2, textViewInvoiceSubTotalAmount2,
            textViewInvoiceTaxAmount2, textViewInvoiceTotalAmount2;
    Button buttonUpdate, buttonDelete;
    private int invoiceId;
    private String invoiceNumber, invoiceDate, invoiceTerms;
    private double invoiceSubTotalAmount, invoiceTaxAmount, invoiceTotalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_invoice);
        initViews();

        getAndSetIntentData();

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Invoice invoice;
                InvoiceDatabaseHelper invoiceDatabaseHelper = new InvoiceDatabaseHelper(EditInvoiceActivity.this);

                invoice = new Invoice(invoiceId, editTextInvoiceNumber2.getText().toString(),
                            editTextInvoiceDate2.getText().toString(),
                            editTextInvoiceTerms2.getText().toString(),
                            Double.parseDouble(editTextInvoiceSubTotalAmount2.getText().toString()),
                            Double.parseDouble(editTextInvoiceTaxAmount2.getText().toString()),
                            Double.parseDouble(editTextInvoiceTotalAmount2.getText().toString()));

                boolean success = invoiceDatabaseHelper.updateInvoice(invoice);
                Toast.makeText(EditInvoiceActivity.this, "Updated= " + success, Toast.LENGTH_LONG).show();
                //Go back to the Main Activity
                Intent intent = new Intent(EditInvoiceActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Invoice invoice;
                InvoiceDatabaseHelper invoiceDatabaseHelper = new InvoiceDatabaseHelper(EditInvoiceActivity.this);

                invoice = new Invoice(invoiceId, editTextInvoiceNumber2.getText().toString(),
                        editTextInvoiceDate2.getText().toString(),
                        editTextInvoiceTerms2.getText().toString(),
                        Double.parseDouble(editTextInvoiceSubTotalAmount2.getText().toString()),
                        Double.parseDouble(editTextInvoiceTaxAmount2.getText().toString()),
                        Double.parseDouble(editTextInvoiceTotalAmount2.getText().toString()));

                boolean success = invoiceDatabaseHelper.deleteInvoice(invoice);
                Toast.makeText(EditInvoiceActivity.this, "Deleted= " + success, Toast.LENGTH_LONG).show();
                //Go back to the Main Activity
                Intent intent = new Intent(EditInvoiceActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    void getAndSetIntentData(){
        Log.d(TAG, "getSet started");
        if (getIntent().hasExtra("invoiceId") && getIntent().hasExtra("invoiceNumber") &&
                getIntent().hasExtra("invoiceDate") && getIntent().hasExtra("invoiceTerms") &&
                getIntent().hasExtra("invoiceSubTotalAmount") &&
                getIntent().hasExtra("invoiceTaxAmount") && getIntent().hasExtra("invoiceTotalAmount")){
            //Getting data from intent
            invoiceId = getIntent().getIntExtra("invoiceId", 0);
            invoiceNumber = getIntent().getStringExtra("invoiceNumber");
            invoiceDate = getIntent().getStringExtra("invoiceDate");
            invoiceTerms = getIntent().getStringExtra("invoiceTerms");
            invoiceSubTotalAmount = getIntent().getDoubleExtra("invoiceSubTotalAmount", -1);
            invoiceTaxAmount = getIntent().getDoubleExtra("invoiceTaxAmount", -2);
            invoiceTotalAmount = getIntent().getDoubleExtra("invoiceTotalAmount", -3);

            //Set intent data
            editTextInvoiceNumber2.setText(invoiceNumber);
            editTextInvoiceDate2.setText(invoiceDate);
            editTextInvoiceTerms2.setText(invoiceTerms);
            editTextInvoiceSubTotalAmount2.setText(Double.toString(invoiceSubTotalAmount));
            editTextInvoiceTaxAmount2.setText(Double.toString(invoiceTaxAmount));
            editTextInvoiceTotalAmount2.setText(Double.toString(invoiceTotalAmount));

        } else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    private void initViews() {
        Log.d(TAG, "initViews: STARTED");
        editTextInvoiceTaxAmount2 = findViewById(R.id.editTextInvoiceTaxAmount2);
        editTextInvoiceTerms2 = findViewById(R.id.editTextInvoiceTerms2);
        editTextInvoiceNumber2 = findViewById(R.id.editTextInvoiceNumber2);
        editTextInvoiceDate2 = findViewById(R.id.editTextInvoiceDate2);
        editTextInvoiceSubTotalAmount2 = findViewById(R.id.editTextInvoiceSubTotalAmount2);
        editTextInvoiceTotalAmount2 = findViewById(R.id.editTextInvoiceTotalAmount2);

        textViewInvoiceDate2 = findViewById(R.id.textViewInvoiceDate2);
        textViewInvoiceNumber2 = findViewById(R.id.textViewInvoiceNumber2);
        textViewInvoiceTerms2 = findViewById(R.id.textViewInvoiceTerms2);
        textViewInvoiceSubTotalAmount2 = findViewById(R.id.textViewInvoiceSubTotalAmount2);
        textViewInvoiceTotalAmount2 = findViewById(R.id.textViewInvoiceTotalAmount2);
        textViewInvoiceTaxAmount2 = findViewById(R.id.textViewInvoiceTaxAmount2);

        buttonUpdate = findViewById(R.id.buttonUpdate);
        buttonDelete = findViewById(R.id.buttonDelete);
    }
}