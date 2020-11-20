package com.s3cilabs.invoicemakertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CompanyActivity extends AppCompatActivity {
    private static final String TAG = "CompanyActivity";
    TextView textViewCompanyName, textViewCompanyAddress, textViewCompanyPhone, textViewCompanyEmail,
            textViewCompanyHst, textViewCompanyRemittance, textViewTest;
    EditText editTextCompanyName, editTextCompanyAddress, editTextCompanyPhone, editTextCompanyEmail,
            editTextCompanyHst, editTextCompanyRemittance;
    Button buttonApplyCompany, buttonSaveCompany;

    //Constants to save data to shared preferences
    public static final String SHARED_PREFERENCES = "sharedPreferences";
    public static final String COMPANY_NAME_TEXT = "companyNameText";

    //Local variables to restore data from shared preferences
    private String companyName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        initViews();

        buttonApplyCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewTest.setText(editTextCompanyName.getText().toString());

//                Intent intent = new Intent(CompanyActivity.this, MainActivity.class);
//                startActivity(intent);
            }
        });

        buttonSaveCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
        loadData();
        updateData();
    }

    //Save data to from test view to shared preferences
    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //editor.putString(COMPANY_NAME_TEXT, textViewTest.getText().toString());
        editor.putString(COMPANY_NAME_TEXT, editTextCompanyName.getText().toString());
        editor.apply();
        Toast.makeText(this, "Company information saved", Toast.LENGTH_SHORT).show();
    }

    //Get data from shared preferences to a local variable
    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        companyName = sharedPreferences.getString(COMPANY_NAME_TEXT, "");
    }

    public void updateData(){
        textViewTest.setText(companyName);
    }

    private void initViews() {
        Log.d(TAG, "initViews Started");
        textViewCompanyName = findViewById(R.id.textViewCompanyName);
        textViewCompanyAddress = findViewById(R.id.textViewCompanyAddress);
        textViewCompanyPhone = findViewById(R.id.textViewCompanyPhone);
        textViewCompanyEmail = findViewById(R.id.textViewCompanyEmail);
        textViewCompanyHst = findViewById(R.id.textViewCompanyHst);
        textViewCompanyRemittance = findViewById(R.id.textViewCompanyRemittance);
        textViewTest = findViewById(R.id.textViewTest);

        editTextCompanyName = findViewById(R.id.editTextCompanyName);
        editTextCompanyAddress = findViewById(R.id.editTextCompanyAddress);
        editTextCompanyPhone = findViewById(R.id.editTextCompanyPhone);
        editTextCompanyEmail = findViewById(R.id.editTextCompanyEmail);
        editTextCompanyHst = findViewById(R.id.editTextCompanyHst);
        editTextCompanyRemittance = findViewById(R.id.editTextCompanyRemittance);

        buttonApplyCompany = findViewById(R.id.buttonApplyCompany);
        buttonSaveCompany = findViewById(R.id.buttonSaveCompany);
    }
}