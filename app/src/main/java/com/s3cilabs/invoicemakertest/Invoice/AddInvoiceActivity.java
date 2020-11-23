package com.s3cilabs.invoicemakertest.Invoice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.s3cilabs.invoicemakertest.MainActivity;
import com.s3cilabs.invoicemakertest.R;

public class AddInvoiceActivity extends AppCompatActivity {
    private static final String TAG = "AddEdit Started";
    EditText editTextInvoiceTaxAmount, editTextInvoiceTerms, editTextInvoiceId,
            editTextInvoiceNumber, editTextInvoiceDate, editTextInvoiceSubTotalAmount,
            editTextInvoiceTotalAmount;
    TextView textViewInvoiceDate, textViewInvoiceNumber, textViewInvoiceId, textViewInvoiceTerms,
            textViewInvoiceSubTotalAmount, textViewInvoiceTaxAmount, textViewInvoiceTotalAmount;
    Button buttonAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_invoice);
        initViews();

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Invoice invoice;
                try {
                    invoice = new Invoice(-1, editTextInvoiceNumber.getText().toString(),
                            editTextInvoiceDate.getText().toString(),
                            editTextInvoiceTerms.getText().toString(),
                            Double.parseDouble(editTextInvoiceSubTotalAmount.getText().toString()),
                            Double.parseDouble(editTextInvoiceTaxAmount.getText().toString()),
                            Double.parseDouble(editTextInvoiceTotalAmount.getText().toString()));

                    Toast.makeText(AddInvoiceActivity.this, invoice.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    Toast.makeText(AddInvoiceActivity.this, "Error creating invoice", Toast.LENGTH_SHORT).show();
                    invoice = new Invoice(-1, "Error", "Error",
                            "Error", 0,0,0);
                }

                //Add invoice to the database
                InvoiceDatabaseHelper invoiceDatabaseHelper = new InvoiceDatabaseHelper(AddInvoiceActivity.this);
                boolean success = invoiceDatabaseHelper.addInvoice(invoice);
                Toast.makeText(AddInvoiceActivity.this, "Success= " + success, Toast.LENGTH_SHORT).show();

                //Go back to the Main Activity
                Intent intent = new Intent(AddInvoiceActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        Log.d(TAG, "initViews:");
        editTextInvoiceTaxAmount = findViewById(R.id.editTextCustomerPhone);
        editTextInvoiceTerms = findViewById(R.id.editTextShipToAddress);
        editTextInvoiceNumber = findViewById(R.id.editTextCustomerName);
        editTextInvoiceDate = findViewById(R.id.editTextBillToAddress);
        editTextInvoiceSubTotalAmount = findViewById(R.id.editTextCustomerEmail);
        editTextInvoiceTotalAmount = findViewById(R.id.editTextInvoiceTotalAmount);

        textViewInvoiceDate = findViewById(R.id.textViewBillToAddress);
        textViewInvoiceNumber = findViewById(R.id.textViewInvoiceNumber);
        textViewInvoiceTerms = findViewById(R.id.textViewShipToAddress);
        textViewInvoiceSubTotalAmount = findViewById(R.id.textViewCustomerEmail);
        textViewInvoiceTotalAmount = findViewById(R.id.textViewInvoiceTotalAmount);
        textViewInvoiceTaxAmount = findViewById(R.id.textViewCustomerPhone);

        buttonAdd = findViewById(R.id.buttonAdd);
    }
}