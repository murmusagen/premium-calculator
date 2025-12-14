package com.example.premiumcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class IndividualPersonalAccidentDataEntry extends AppCompatActivity {

    Button riskCategoryDescriptionButton;
    Spinner riskCategorySpinner;
    Spinner coverTableSpinner;
    EditText sumInsuredEditText;
    CheckBox medicalExtensionCheckBox;
    Button calculateIPAPremiumButton;
    ArrayList<HashMap<String, String>> premium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_individual_personal_accident_data_entry);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        riskCategoryDescriptionButton = findViewById(R.id.riskCategoryDescriptionButton);
        riskCategorySpinner = findViewById(R.id.riskCategorySpinner);
        coverTableSpinner = findViewById(R.id.coverTableSpinner);
        sumInsuredEditText = findViewById(R.id.sumInsuredEditText);
        medicalExtensionCheckBox = findViewById(R.id.medicalExtensionCheckBox);
        calculateIPAPremiumButton = findViewById(R.id.calculateIHPPremiumButton);


        riskCategoryDescriptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonFunctions.createAlertBuilder(IndividualPersonalAccidentDataEntry.this, "Risk Category Information", CommonFunctions.ALL_RISK_CATEGORY_TEXT, "Ok", "");

            }
        });

        ArrayAdapter<String> riskCategoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.PA_RISK_CATEGORY_ARRAY);
        riskCategoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        riskCategorySpinner.setAdapter(riskCategoryAdapter);

        ArrayAdapter<String> coverTableAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.PA_COVER_TABLE_ARRAY);
        coverTableAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        coverTableSpinner.setAdapter(coverTableAdapter);

        calculateIPAPremiumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sumInsuredEditText.getText().toString().trim().equalsIgnoreCase("")){
                    CommonFunctions.createAlertBuilder(IndividualPersonalAccidentDataEntry.this, "Alert", "Please Enter Sum Insured", "Ok", "");
                }else{
                    premium = CommonFunctions.calculateIPAPremium(riskCategorySpinner.getSelectedItem().toString(),coverTableSpinner.getSelectedItem().toString(), sumInsuredEditText.getText().toString(), medicalExtensionCheckBox.isChecked(), false);
                    Intent intent = new Intent(IndividualPersonalAccidentDataEntry.this, IndividualPersonalAccidentDisplay.class);
                    intent.putExtra(CommonFunctions.INTENT_RISK_GROUP, riskCategorySpinner.getSelectedItem().toString());
                    intent.putExtra(CommonFunctions.INTENT_COVER_TABLE, coverTableSpinner.getSelectedItem().toString());
                    intent.putExtra(CommonFunctions.INTENT_SUM_INSURED, sumInsuredEditText.getText().toString().trim());
                    intent.putExtra(CommonFunctions.INTENT_PRODUCT_NAME, CommonFunctions.INDIVIDUAL_PERSONAL_ACCIDENT);
                    intent.putExtra(CommonFunctions.INTENT_PREMIUM_AND_COMMISSION, premium);
                    startActivity(intent);
                }
            }
        });
    }
}