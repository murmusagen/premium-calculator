package com.example.premiumcalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class TwoWheelerDataEntry extends AppCompatActivity {


    EditText odDiscount = null;

    CheckBox rsaCheckBox = null;
    EditText llToPaidDriver = null;


    // New Code
    Spinner typeSpinner;
    Spinner zoneSpinner;
    Spinner rtoStateSpinner;
    Spinner fuelTypeSpinner;
    EditText ccEditText;
    EditText idvEditText;
    Spinner ncbSpinner;
    Spinner twCPASpinner;
    Spinner paToPaidDriverSISpinner;
    Spinner paToPassengerSISpinner;
    Button calculateTwPremium;
    EditText regDate;
    EditText polStartDate;
    TextView discountLimitsTextView;
    String currentDate;
    Spinner policyTypeSpinner;
    EditText noOfPassengerEditText;
    ArrayList<HashMap<String, String>> premium;
    CheckBox ndCoverCheckBox;
    CheckBox consumablesCheckBox;
    CheckBox engineProtectionCheckBox;
    CheckBox rtiCheckbox;
    CheckBox lossOfKeyCheckBox;
    Spinner transactionTypeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_two_wheeler_data_entry);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //New Code

        policyTypeSpinner = findViewById(R.id.policyTypeSpinner);
        ArrayAdapter<String> policyTypeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.MOTOR_POLICY_TYPE_ARRAY);
        policyTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        policyTypeSpinner.setAdapter(policyTypeAdapter);

        typeSpinner = findViewById(R.id.typeSpinner);
        ArrayAdapter<String> typeAdapterNewPreOwned = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.TYPE_ARRAY);
        ArrayAdapter<String> typeAdapterPreOwnedOnly = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.TYPE_ARRAY_PRE_OWNED_ONLY);


        policyTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    findViewById(R.id.ownDamageLinearLayout).setVisibility(View.VISIBLE);
                    findViewById(R.id.liabilityOnlyLinearLayout).setVisibility(View.VISIBLE);
                    typeAdapterNewPreOwned.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    typeSpinner.setAdapter(typeAdapterNewPreOwned);
                } else if (i == 1) {
                    findViewById(R.id.ownDamageLinearLayout).setVisibility(View.VISIBLE);
                    findViewById(R.id.liabilityOnlyLinearLayout).setVisibility(View.GONE);
                    typeAdapterPreOwnedOnly.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    typeSpinner.setAdapter(typeAdapterPreOwnedOnly);
                } else if (i == 2) {
                    findViewById(R.id.ownDamageLinearLayout).setVisibility(View.GONE);
                    findViewById(R.id.liabilityOnlyLinearLayout).setVisibility(View.VISIBLE);
                    typeAdapterPreOwnedOnly.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    typeSpinner.setAdapter(typeAdapterPreOwnedOnly);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        typeSpinner = findViewById(R.id.typeSpinner);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.TYPE_ARRAY);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);

        transactionTypeSpinner = findViewById(R.id.transactionTypeSpinner);
        ArrayAdapter<String> transactionTypeAdapterWithNA = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.MOTOR_TRANSACTION_TYPE_ARRAY_WITH_NA);
        ArrayAdapter<String> transactionTypeAdapterWithoutNA = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.MOTOR_TRANSACTION_TYPE_ARRAY_WITHOUT_NA);
        transactionTypeAdapterWithNA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        transactionTypeAdapterWithoutNA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        zoneSpinner = findViewById(R.id.zoneSpinner);
        ArrayAdapter<String> zoneAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.ZONE_TW_PVT_ARRAY);
        zoneAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zoneSpinner.setAdapter(zoneAdapter);

        rtoStateSpinner = findViewById(R.id.rtoStateSpinner);
        ArrayAdapter<String> rtoStateAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.ALL_STATES_ARRAY);
        rtoStateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rtoStateSpinner.setAdapter(rtoStateAdapter);

        fuelTypeSpinner = findViewById(R.id.fuelTypeSpinner);
        ArrayAdapter<String> fuelTypeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.TW_FUEL_TYPE);
        fuelTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuelTypeSpinner.setAdapter(fuelTypeAdapter);

        ccEditText = findViewById(R.id.ccEditText);

        idvEditText = findViewById(R.id.idvEditText);

        ncbSpinner = findViewById(R.id.ncbSpinner);
        ArrayAdapter<String> ncbAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.NCB_ARRAY);
        ncbAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ncbSpinner.setAdapter(ncbAdapter);

        twCPASpinner = findViewById(R.id.twCPASpinner);
        ArrayAdapter<String> twCPAAdapterLongTerm = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.CPA_ARRAY_LONG_TERM);
        ArrayAdapter<String> twCPAAdapterOneYear = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.CPA_ARRAY_ONE_YEAR);
        twCPAAdapterLongTerm.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        twCPAAdapterOneYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    twCPASpinner.setAdapter(twCPAAdapterOneYear);
                    transactionTypeSpinner.setEnabled(true);
                    transactionTypeSpinner.setAdapter(transactionTypeAdapterWithoutNA);
                } else {
                    twCPASpinner.setAdapter(twCPAAdapterLongTerm);
                    transactionTypeSpinner.setEnabled(false);
                    transactionTypeSpinner.setAdapter(transactionTypeAdapterWithNA);
                    transactionTypeSpinner.setSelection(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        paToPaidDriverSISpinner = findViewById(R.id.paToPaidDriverSISpinner);
        ArrayAdapter<String> paToPaidDriverSIAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.PA_TP_PAID_DRIVE_PASSENGER_SI_ARRAY);
        paToPaidDriverSIAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paToPaidDriverSISpinner.setAdapter(paToPaidDriverSIAdapter);

        paToPassengerSISpinner = findViewById(R.id.paToPassengerSISpinner);
        ArrayAdapter<String> paToPassengerSIAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.PA_TP_PAID_DRIVE_PASSENGER_SI_ARRAY);
        paToPassengerSIAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paToPassengerSISpinner.setAdapter(paToPassengerSIAdapter);

        calculateTwPremium = findViewById(R.id.calculateTwPremium);

        regDate = findViewById(R.id.regDateEditText);
        polStartDate = findViewById(R.id.polStartDateEditText);

        discountLimitsTextView = findViewById(R.id.discountLimitsTextView);
        discountLimitsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.tw_discount_limit_dialog_layout, null);

                AlertDialog.Builder builder = new AlertDialog.Builder(TwoWheelerDataEntry.this);
                builder.setView(dialogView);
                builder.setTitle(CommonFunctions.DISCOUNT_LIMIT_DIALOG_BOX_TITLE);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.US).format(new Date());
        regDate.setText(currentDate);
        regDate.addTextChangedListener(new TextWatcher() {

            private String current = "";
            private String ddmmyyyy = "DDMMYYYY";

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(current)) {
                    String clean = s.toString().replaceAll("[^\\d]", "");
                    String cleanCurrent = current.replaceAll("[^\\d]", "");

                    int cl = clean.length();
                    int sel = cl;
                    for (int i = 2; i <= cl && i < 6; i += 2) {
                        sel++;
                    }
                    // Fix for deleting slash
                    if (clean.equals(cleanCurrent)) sel--;

                    if (clean.length() < 8) {
                        clean = clean + ddmmyyyy.substring(clean.length());
                    } else {
                        // Validate day, month, year separately if needed
                    }

                    clean = clean.substring(0, 8);
                    StringBuilder formatted = new StringBuilder();
                    formatted.append(clean.substring(0, 2)).append("/");
                    formatted.append(clean.substring(2, 4)).append("/");
                    formatted.append(clean.substring(4, 8));

                    current = formatted.toString();
                    regDate.setText(current);
                    regDate.setSelection(sel < current.length() ? sel : current.length());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        polStartDate.setText(currentDate);
        polStartDate.addTextChangedListener(new TextWatcher() {

            private String current = "";
            private String ddmmyyyy = "DDMMYYYY";

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals(current)) {
                    String clean = s.toString().replaceAll("[^\\d]", "");
                    String cleanCurrent = current.replaceAll("[^\\d]", "");

                    int cl = clean.length();
                    int sel = cl;
                    for (int i = 2; i <= cl && i < 6; i += 2) {
                        sel++;
                    }
                    // Fix for deleting slash
                    if (clean.equals(cleanCurrent)) sel--;

                    if (clean.length() < 8) {
                        clean = clean + ddmmyyyy.substring(clean.length());
                    } else {
                        // Validate day, month, year separately if needed
                    }

                    clean = clean.substring(0, 8);
                    StringBuilder formatted = new StringBuilder();
                    formatted.append(clean.substring(0, 2)).append("/");
                    formatted.append(clean.substring(2, 4)).append("/");
                    formatted.append(clean.substring(4, 8));

                    current = formatted.toString();
                    polStartDate.setText(current);
                    polStartDate.setSelection(sel < current.length() ? sel : current.length());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        noOfPassengerEditText = findViewById(R.id.noOfPassengerEditText);
        paToPassengerSISpinner = findViewById(R.id.paToPassengerSISpinner);
        ndCoverCheckBox = findViewById(R.id.ndCoverCheckBox);
        rsaCheckBox = findViewById(R.id.rsaCheckBox);
        llToPaidDriver = findViewById(R.id.llToPaidDriverEditText);
        odDiscount = findViewById(R.id.oddiscountEditText);
        consumablesCheckBox = findViewById(R.id.consumablesCheckBox);
        engineProtectionCheckBox = findViewById(R.id.engineProtectionCheckBox);
        rtiCheckbox = findViewById(R.id.rtiCheckBox);
        lossOfKeyCheckBox = findViewById(R.id.lossOfKeyCheckbox);
        rsaCheckBox = findViewById(R.id.rsaCheckBox);
        paToPaidDriverSISpinner = findViewById(R.id.paToPaidDriverSISpinner);


        calculateTwPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flag = false;
                if (ccEditText.getText().toString().equalsIgnoreCase("")) {
                    CommonFunctions.createAlertBuilder(TwoWheelerDataEntry.this, "Alert", "Please enter CC/kW", "Ok", "");
                    flag = true;
                } else if (idvEditText.getText().toString().trim().equalsIgnoreCase("") && !policyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.MOTOR_LIABILITY_ONLY)) {
                    CommonFunctions.createAlertBuilder(TwoWheelerDataEntry.this, "Alert", "Please enter IDV", "Ok", "");
                    flag = true;
                } else if (noOfPassengerEditText.getText().toString().trim().equalsIgnoreCase("")) {
                    if (!paToPassengerSISpinner.getSelectedItem().toString().equalsIgnoreCase("NA")) {
                        CommonFunctions.createAlertBuilder(TwoWheelerDataEntry.this, "Alert", "Please select No. Of Passenger for PA To Unnamed Passenger", "Ok", "");
                        flag = true;
                    }
                } else if (!noOfPassengerEditText.getText().toString().trim().equalsIgnoreCase("")) {
                    if (paToPassengerSISpinner.getSelectedItem().toString().equalsIgnoreCase("NA")) {
                        CommonFunctions.createAlertBuilder(TwoWheelerDataEntry.this, "Alert", "Please select Sum Insured for PA To Unnamed Passenger", "Ok", "");
                        flag = true;
                    }
                }

                if (!flag) {

                    long millisBetween = CommonFunctions.convertStringToCalenderObject(polStartDate.getText().toString().trim()) - CommonFunctions.convertStringToCalenderObject(regDate.getText().toString().trim());
                    double ageOfTheVehicle = millisBetween / (1000.0 * 60 * 60 * 24 * 365.2425);

                    int[] yearsAndMonthsFromAgeResult = CommonFunctions.getYearsAndMonthsFromAge(polStartDate.getText().toString().trim(), regDate.getText().toString().trim());
                    int years = yearsAndMonthsFromAgeResult[0];
                    int months = yearsAndMonthsFromAgeResult[1];

                    premium = CommonFunctions.calculatePremiumForTwoWheeler(
                            transactionTypeSpinner.getSelectedItem().toString(),
                            paToPassengerSISpinner.getSelectedItem().toString(),
                            noOfPassengerEditText.getText().toString().trim(),
                            paToPaidDriverSISpinner.getSelectedItem().toString(),
                            llToPaidDriver.getText().toString().trim(),
                            twCPASpinner.getSelectedItem().toString(),
                            typeSpinner.getSelectedItem().toString(),
                            years,
                            months,
                            Double.toString(ageOfTheVehicle),
                            policyTypeSpinner.getSelectedItem().toString(),
                            zoneSpinner.getSelectedItem().toString(),
                            rtoStateSpinner.getSelectedItem().toString(),
                            fuelTypeSpinner.getSelectedItem().toString(),
                            ccEditText.getText().toString().trim(),
                            idvEditText.getText().toString().trim(),
                            ncbSpinner.getSelectedItem().toString(),
                            odDiscount.getText().toString().trim(),
                            ndCoverCheckBox.isChecked(),
                            consumablesCheckBox.isChecked(),
                            engineProtectionCheckBox.isChecked(),
                            rtiCheckbox.isChecked(),
                            lossOfKeyCheckBox.isChecked(),
                            rsaCheckBox.isChecked()
                    );
                    Intent intent = new Intent(TwoWheelerDataEntry.this, MotorPremuimDisplay.class);
                    intent.putExtra(CommonFunctions.INTENT_PRODUCT_NAME, CommonFunctions.TWO_WHEELER);
                    intent.putExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE, policyTypeSpinner.getSelectedItem().toString());
                    intent.putExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_TYPE, typeSpinner.getSelectedItem().toString());
                    intent.putExtra(CommonFunctions.INTENT_MOTOR_TRANSACTION_TYPE, transactionTypeSpinner.getSelectedItem().toString());
                    intent.putExtra(CommonFunctions.INTENT_ZONE, zoneSpinner.getSelectedItem().toString());
                    intent.putExtra(CommonFunctions.INTENT_MOTOR_RTO_STATE, rtoStateSpinner.getSelectedItem().toString());
                    intent.putExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_AGE, String.format("%.3f", ageOfTheVehicle));
                    intent.putExtra(CommonFunctions.INTENT_MOTOR_FUEL_TYPE, fuelTypeSpinner.getSelectedItem().toString());
                    intent.putExtra(CommonFunctions.INTENT_MOTOR_CC, ccEditText.getText().toString().trim());
                    intent.putExtra(CommonFunctions.INTENT_MOTOR_IDV, idvEditText.getText().toString().trim());
                    intent.putExtra(CommonFunctions.INTENT_PREMIUM_AND_COMMISSION, premium);
                    startActivity(intent);

                }
            }
        });
    }
}