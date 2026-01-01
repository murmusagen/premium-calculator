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
import android.widget.CompoundButton;
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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class GcvDataEntry extends AppCompatActivity {

    final Calendar myCalender1 = Calendar.getInstance();
    final Calendar myCalender2 = Calendar.getInstance();
    String basicODRate = "0.00";
    String basicODPremium = "0.00";
    String discountApplied = "0.00";
    String imt23Premium = "0.00";
    String basicODPremiumAfterDiscount = "0.00";
    String lpgCngKitOD = "0.00";
    String lpgCngKitTP = "0.00";
    String ncbAmount = "0.00";
    String consumablesPremium = "0.00";
    String additionalTowingPremium = "0.00";
    String totalODPremium = "0.00";
    String basicTPPremium = "0.00";
    String cpaPremium = "0.00";
    String llToPaidDriverPremium = "0.00";
    String totalTPPremium = "0.00";
    String netPremium = "0.00";
    String gstAmount = "0.00";
    String grossPremium = "0.00";
    String[] payout = new String[8];
    String paToPaidDriverPremium = "0.00";
    Boolean valid = true;
    String paToPassengerPremium = "0.00";
    String paToPassengerTotalSI = "0.00";
    String paToPassengerSI = "0.00";
    String ndCoverPremium = "0.00";
    String ndCoverRate = "0.00";
    String engineProtectionPremium = "0.00";
    String rtiPremium = "0.00";
    String rsaPremium = "0.00";
    String geoExtensionODPremium = "0.00";
    String geoExtensionTPPremium = "0.00";
    Calendar regDateCalendar = Calendar.getInstance();
    Calendar polStartDateCalendar = Calendar.getInstance();

    EditText idv = null;
    EditText gvw = null;
    EditText odDiscount = null;
    CheckBox ncCover = null;
    CheckBox lpgCngCheckBox = null;
    CheckBox consumables = null;
    CheckBox rti = null;
    CheckBox rsaCheckBox = null;
    CheckBox imt23CheckBox = null;
    CheckBox geoExtensionCheckBox = null;
    CheckBox additionalTowingCheckBox = null;
    EditText additionalTowingEditText = null;
    EditText llToPaidDriver = null;
    EditText noOfPassenger = null;

    //New Code

    Spinner policyTypeSpinner,
            vehicleTypeSpinner,
            transactionTypeSpinner,
            zoneSpinner,
            rtoStateSpinner,
            ncbSpinner,
            twCPASpinner,
            gcvTypeSpinner,
            paToPaidDriverSISpinner,
            paToPassengerSISpinner,
            fuelTypeSpinner;
    EditText gvwEditText,
            idvEditText,
            regDate,
            polStartDate,
            noOfPassengerEditText;
    CheckBox ndCoverCheckBox,
            consumablesCheckBox,
            rtiCheckbox;

    Button calculateTwPremium;

    TextView discountLimitsTextView;

    String currentDate;
    ArrayList<HashMap<String, String>> premium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gcv_data_entry);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // New Code

        policyTypeSpinner = findViewById(R.id.policyTypeSpinner);
        ArrayAdapter<String> policyTypeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.MOTOR_POLICY_TYPE_WITHOUT_SAOD_ARRAY);
        policyTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        policyTypeSpinner.setAdapter(policyTypeAdapter);

        policyTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    findViewById(R.id.ownDamageLinearLayout).setVisibility(View.VISIBLE);
                    findViewById(R.id.liabilityOnlyLinearLayout).setVisibility(View.VISIBLE);
                } else if (i == 1) {
                    findViewById(R.id.ownDamageLinearLayout).setVisibility(View.GONE);
                    findViewById(R.id.liabilityOnlyLinearLayout).setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        vehicleTypeSpinner = findViewById(R.id.typeSpinner);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.TYPE_ARRAY);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vehicleTypeSpinner.setAdapter(typeAdapter);

        transactionTypeSpinner = findViewById(R.id.transactionTypeSpinner);
        ArrayAdapter<String> transactionTypeAdapterWithNA = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.MOTOR_TRANSACTION_TYPE_ARRAY_WITH_NA);
        ArrayAdapter<String> transactionTypeAdapterWithoutNA = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.MOTOR_TRANSACTION_TYPE_ARRAY_WITHOUT_NA);
        transactionTypeAdapterWithNA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        transactionTypeAdapterWithoutNA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        gcvTypeSpinner = findViewById(R.id.gcvTypeSpinner);
        ArrayAdapter<String> gcvTypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.MOTOR_GCV_TYPE_ARRAY);
        gcvTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gcvTypeSpinner.setAdapter(gcvTypeAdapter);

        zoneSpinner = findViewById(R.id.zoneSpinner);
        ArrayAdapter<String> zoneAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.ZONE_GCV);
        zoneAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zoneSpinner.setAdapter(zoneAdapter);

        rtoStateSpinner = findViewById(R.id.rtoStateSpinner);
        ArrayAdapter<String> rtoStateAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.ALL_STATES_ARRAY);
        rtoStateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rtoStateSpinner.setAdapter(rtoStateAdapter);

        gvwEditText = findViewById(R.id.gvwEditText);

        idvEditText = findViewById(R.id.idvEditText);

        ncbSpinner = findViewById(R.id.ncbSpinner);
        ArrayAdapter<String> ncbAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.NCB_ARRAY);
        ncbAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ncbSpinner.setAdapter(ncbAdapter);

        twCPASpinner = findViewById(R.id.twCPASpinner);
        ArrayAdapter<String> twCPAAdapterOneYear = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.CPA_ARRAY_ONE_YEAR);
        twCPAAdapterOneYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        twCPASpinner.setAdapter(twCPAAdapterOneYear);

        vehicleTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    transactionTypeSpinner.setEnabled(true);
                    transactionTypeSpinner.setAdapter(transactionTypeAdapterWithoutNA);
                } else {
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
                View dialogView = inflater.inflate(R.layout.gcv_discount_limit_dialog_layout, null);

                AlertDialog.Builder builder = new AlertDialog.Builder(GcvDataEntry.this);
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

        fuelTypeSpinner = findViewById(R.id.fuelTypeSpinner);
        ArrayAdapter<String> fuelTypeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.PVT_FUEL_TYPE);
        fuelTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuelTypeSpinner.setAdapter(fuelTypeAdapter);

        noOfPassengerEditText = findViewById(R.id.noOfPassengerEditText);
        paToPassengerSISpinner = findViewById(R.id.paToPassengerSISpinner);
        ndCoverCheckBox = findViewById(R.id.ndCoverCheckBox);
        consumablesCheckBox = findViewById(R.id.consumablesCheckBox);
        rsaCheckBox = findViewById(R.id.rsaCheckBox);
        llToPaidDriver = findViewById(R.id.llToPaidDriverEditText);
        odDiscount = findViewById(R.id.oddiscountEditText);
        rtiCheckbox = findViewById(R.id.rtiCheckBox);
        lpgCngCheckBox = findViewById(R.id.lpgCngCheckBox);
        imt23CheckBox = findViewById(R.id.imt23CheckBox);
        geoExtensionCheckBox = findViewById(R.id.geoExtensionCheckBox);
        additionalTowingCheckBox = findViewById(R.id.additionalTowingCheckBox);

        additionalTowingCheckBox = findViewById(R.id.additionalTowingCheckBox);
        additionalTowingEditText = findViewById(R.id.additionalTowingEditText);
        additionalTowingEditText.setEnabled(false);
        additionalTowingCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    additionalTowingEditText.setText("");
                    additionalTowingEditText.setEnabled(true);
                } else {
                    additionalTowingEditText.setText("");
                    additionalTowingEditText.setEnabled(false);
                }
            }
        });

        calculateTwPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flag = false;
                if (gvwEditText.getText().toString().equalsIgnoreCase("")) {
                    CommonFunctions.createAlertBuilder(GcvDataEntry.this, "Alert", "Please enter GVW", "Ok", "");
                    flag = true;
                } else if (idvEditText.getText().toString().trim().equalsIgnoreCase("") && !policyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.MOTOR_LIABILITY_ONLY)) {
                    CommonFunctions.createAlertBuilder(GcvDataEntry.this, "Alert", "Please enter IDV", "Ok", "");
                    flag = true;
                } else if (noOfPassengerEditText.getText().toString().trim().equalsIgnoreCase("")) {
                    if (!paToPassengerSISpinner.getSelectedItem().toString().equalsIgnoreCase("NA")) {
                        CommonFunctions.createAlertBuilder(GcvDataEntry.this, "Alert", "Please select No. Of Passenger for PA To Unnamed Passenger", "Ok", "");
                        flag = true;
                    }
                } else if (!noOfPassengerEditText.getText().toString().trim().equalsIgnoreCase("")) {
                    if (paToPassengerSISpinner.getSelectedItem().toString().equalsIgnoreCase("NA")) {
                        CommonFunctions.createAlertBuilder(GcvDataEntry.this, "Alert", "Please select Sum Insured for PA To Unnamed Passenger", "Ok", "");
                        flag = true;
                    }
                } else if (ndCoverCheckBox.isChecked()) {
                    if(!imt23CheckBox.isChecked()){
                        imt23CheckBox.setChecked(true);
                    }
                }

                if (!flag) {
                    long millisBetween = CommonFunctions.convertStringToCalenderObject(polStartDate.getText().toString().trim()) - CommonFunctions.convertStringToCalenderObject(regDate.getText().toString().trim());
                    double ageOfTheVehicle = millisBetween / (1000.0 * 60 * 60 * 24 * 365.2425);

                    int[] yearsAndMonthsFromAgeResult = CommonFunctions.getYearsAndMonthsFromAge(polStartDate.getText().toString().trim(), regDate.getText().toString().trim());
                    int years = yearsAndMonthsFromAgeResult[0];
                    int months = yearsAndMonthsFromAgeResult[1];

                    premium = CommonFunctions.calculatePremiumForGCV(
                            gcvTypeSpinner.getSelectedItem().toString(),
                            transactionTypeSpinner.getSelectedItem().toString(),
                            paToPassengerSISpinner.getSelectedItem().toString(),
                            noOfPassengerEditText.getText().toString().trim(),
                            paToPaidDriverSISpinner.getSelectedItem().toString(),
                            llToPaidDriver.getText().toString().trim(),
                            twCPASpinner.getSelectedItem().toString(),
                            vehicleTypeSpinner.getSelectedItem().toString(),
                            years,
                            months,
                            Double.toString(ageOfTheVehicle),
                            policyTypeSpinner.getSelectedItem().toString(),
                            zoneSpinner.getSelectedItem().toString(),
                            rtoStateSpinner.getSelectedItem().toString(),
                            fuelTypeSpinner.getSelectedItem().toString(),
                            gvwEditText.getText().toString().trim(),
                            idvEditText.getText().toString().trim(),
                            ncbSpinner.getSelectedItem().toString(),
                            odDiscount.getText().toString().trim(),
                            ndCoverCheckBox.isChecked(),
                            consumablesCheckBox.isChecked(),
                            rtiCheckbox.isChecked(),
                            rsaCheckBox.isChecked(),
                            lpgCngCheckBox.isChecked(),
                            geoExtensionCheckBox.isChecked(),
                            additionalTowingCheckBox.isChecked(),
                            additionalTowingEditText.getText().toString().trim(),
                            imt23CheckBox.isChecked()
                    );

                    Intent intent = new Intent(GcvDataEntry.this, MotorPremuimDisplay.class);
                    intent.putExtra(CommonFunctions.INTENT_PRODUCT_NAME, CommonFunctions.GCV);
                    intent.putExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE, policyTypeSpinner.getSelectedItem().toString());
                    intent.putExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_TYPE, vehicleTypeSpinner.getSelectedItem().toString());
                    intent.putExtra(CommonFunctions.INTENT_MOTOR_TRANSACTION_TYPE, transactionTypeSpinner.getSelectedItem().toString());
                    intent.putExtra(CommonFunctions.INTENT_MOTOR_GCV_TYPE, gcvTypeSpinner.getSelectedItem().toString());
                    intent.putExtra(CommonFunctions.INTENT_ZONE, zoneSpinner.getSelectedItem().toString());
                    intent.putExtra(CommonFunctions.INTENT_MOTOR_RTO_STATE, rtoStateSpinner.getSelectedItem().toString());
                    intent.putExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_AGE, String.format("%.3f", ageOfTheVehicle));
                    intent.putExtra(CommonFunctions.INTENT_MOTOR_FUEL_TYPE, fuelTypeSpinner.getSelectedItem().toString());
                    intent.putExtra(CommonFunctions.INTENT_MOTOR_GVW, gvwEditText.getText().toString().trim());
                    intent.putExtra(CommonFunctions.INTENT_MOTOR_IDV, idvEditText.getText().toString().trim());
                    intent.putExtra(CommonFunctions.INTENT_PREMIUM_AND_COMMISSION, premium);
                    startActivity(intent);
                }
            }
        });







        /*String[] gcv_type_array = {CommonFunctions.OTHER_THAN_THREE_WHEELER, CommonFunctions.THREE_WHEELER};
        Spinner typeSpinner = findViewById(R.id.gcvTypeSpinner);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gcv_type_array);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);

        String[] zone_gcv_array = {CommonFunctions.ZONE_C, CommonFunctions.ZONE_B, CommonFunctions.ZONE_A};
        Spinner zoneSpinner = findViewById(R.id.zoneSpinner);
        ArrayAdapter<String> zoneAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, zone_gcv_array);
        zoneAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zoneSpinner.setAdapter(zoneAdapter);

        Spinner rtoStateSpinner = findViewById(R.id.rtoStateSpinner);
        ArrayAdapter<String> rtoStateAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.ALL_STATES_ARRAY);
        rtoStateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rtoStateSpinner.setAdapter(rtoStateAdapter);

        String[] gcv_fuel_type = {CommonFunctions.PETROL, CommonFunctions.DIESEL, CommonFunctions.HYBRID, CommonFunctions.ELECTRIC};
        Spinner fuelTypeSpinner = findViewById(R.id.fuelTypeSpinner);
        ArrayAdapter<String> fuelTypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, gcv_fuel_type);
        fuelTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuelTypeSpinner.setAdapter(fuelTypeAdapter);

        String[] ncb_array = {CommonFunctions.NCB_0, CommonFunctions.NCB_20, CommonFunctions.NCB_25, CommonFunctions.NCB_35, CommonFunctions.NCB_45, CommonFunctions.NCB_50};
        Spinner ncbSpinner = findViewById(R.id.ncbSpinner);
        ArrayAdapter<String> ncbAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ncb_array);
        ncbAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ncbSpinner.setAdapter(ncbAdapter);

        Spinner twCPASpinner = findViewById(R.id.twCPASpinner);
        ArrayAdapter<String> twCPAAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.CPA_ARRAY_LONG_TERM);
        twCPAAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        twCPASpinner.setAdapter(twCPAAdapter);

        Spinner paToPaidDriverSISpinner = findViewById(R.id.paToPaidDriverSISpinner);
        ArrayAdapter<String> paToPaidDriverSIAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.PA_TP_PAID_DRIVE_PASSENGER_SI_ARRAY);
        paToPaidDriverSIAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paToPaidDriverSISpinner.setAdapter(paToPaidDriverSIAdapter);

        Spinner paToPassengerSISpinner = findViewById(R.id.paToPassengerSISpinner);
        ArrayAdapter<String> paToPassengerSIAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.PA_TP_PAID_DRIVE_PASSENGER_SI_ARRAY);
        paToPassengerSIAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paToPassengerSISpinner.setAdapter(paToPassengerSIAdapter);

        additionalTowingCheckBox = findViewById(R.id.additionalTowingCheckBox);
        additionalTowingEditText = findViewById(R.id.additionalTowingEditText);
        additionalTowingEditText.setEnabled(false);
        additionalTowingCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    additionalTowingEditText.setText("");
                    additionalTowingEditText.setEnabled(true);
                } else {
                    additionalTowingEditText.setText("");
                    additionalTowingEditText.setEnabled(false);
                }
            }
        });

        Button calculateTwPremium = findViewById(R.id.calculateTwPremium);

        EditText regDate = findViewById(R.id.regDateEditText);
        EditText polStartDate = findViewById(R.id.polStartDateEditText);

        TextView discountLimitsTextView = findViewById(R.id.discountLimitsTextView);

        discountLimitsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.gcv_discount_limit_dialog_layout, null);

                AlertDialog.Builder builder = new AlertDialog.Builder(GcvDataEntry.this);
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


        String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.US).format(new Date());
        regDate.setText(currentDate);
        regDate.addTextChangedListener(new TextWatcher() {

            private String current = "";
            private String ddmmyyyy = "DDMMYYYY";
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

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

                    if (clean.length() < 8){
                        clean = clean + ddmmyyyy.substring(clean.length());
                    } else {
                        // Validate day, month, year separately if needed
                    }

                    clean = clean.substring(0, 8);
                    StringBuilder formatted = new StringBuilder();
                    formatted.append(clean.substring(0,2)).append("/");
                    formatted.append(clean.substring(2,4)).append("/");
                    formatted.append(clean.substring(4,8));

                    current = formatted.toString();
                    regDate.setText(current);
                    regDate.setSelection(sel < current.length() ? sel : current.length());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
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

                    if (clean.length() < 8){
                        clean = clean + ddmmyyyy.substring(clean.length());
                    } else {
                        // Validate day, month, year separately if needed
                    }

                    clean = clean.substring(0, 8);
                    StringBuilder formatted = new StringBuilder();
                    formatted.append(clean.substring(0,2)).append("/");
                    formatted.append(clean.substring(2,4)).append("/");
                    formatted.append(clean.substring(4,8));

                    current = formatted.toString();
                    polStartDate.setText(current);
                    polStartDate.setSelection(sel < current.length() ? sel : current.length());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        calculateTwPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valid = true;

                basicODRate = "0.00";
                basicODPremium = "0.00";
                discountApplied = "0.00";
                imt23Premium = "0.00";
                basicODPremiumAfterDiscount = "0.00";
                lpgCngKitOD = "0.00";
                lpgCngKitTP = "0.00";
                ncbAmount = "0.00";
                consumablesPremium = "0.00";
                additionalTowingPremium = "0.00";
                totalODPremium = "0.00";
                basicTPPremium = "0.00";
                cpaPremium = "0.00";
                llToPaidDriverPremium = "0.00";
                totalTPPremium = "0.00";
                netPremium = "0.00";
                gstAmount = "0.00";
                grossPremium = "0.00";
                paToPaidDriverPremium = "0.00";
                paToPassengerPremium = "0.00";
                paToPassengerTotalSI = "0.00";
                paToPassengerSI = "0.00";
                ndCoverPremium = "0.00";
                ndCoverRate = "0.00";
                engineProtectionPremium = "0.00";
                rtiPremium = "0.00";
                rsaPremium = "0.00";
                geoExtensionODPremium = "0.00";
                geoExtensionTPPremium = "0.00";


                idv = findViewById(R.id.idvEditText);
                gvw = findViewById(R.id.gvwEditText);
                odDiscount = findViewById(R.id.oddiscountEditText);
                ncCover = findViewById(R.id.ndCoverCheckBox);
                lpgCngCheckBox = findViewById(R.id.lpgCngCheckBox);
                consumables = findViewById(R.id.consumablesCheckBox);
                rti = findViewById(R.id.rtiCheckbox);
                rsaCheckBox = findViewById(R.id.rsaCheckBox);
                imt23CheckBox = findViewById(R.id.imt23CheckBox);
                geoExtensionCheckBox = findViewById(R.id.geoExtensionCheckBox);
                additionalTowingCheckBox = findViewById(R.id.additionalTowingCheckBox);
                llToPaidDriver = findViewById(R.id.llToPaidDriverEditText);
                noOfPassenger = findViewById(R.id.noOfPassengerEditText);
                additionalTowingEditText = findViewById(R.id.additionalTowingEditText);


                additionalTowingCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if (isChecked) {
                            additionalTowingEditText.setText("");
                            additionalTowingEditText.setEnabled(true);
                        } else {
                            additionalTowingEditText.setText("");
                            additionalTowingEditText.setEnabled(false);
                        }
                    }
                });

                long millisBetween = CommonFunctions.convertStringToCalenderObject(polStartDate.getText().toString().trim()) - CommonFunctions.convertStringToCalenderObject(regDate.getText().toString().trim());

                double ageOfTheVehicle = millisBetween / (1000.0 * 60 * 60 * 24 * 365.2425);

                int[] yearsAndMonthsFromAgeResult = CommonFunctions.getYearsAndMonthsFromAge(polStartDate.getText().toString().trim(), regDate.getText().toString().trim());
                int years = yearsAndMonthsFromAgeResult[0];
                int months = yearsAndMonthsFromAgeResult[1];

                basicODRate = CommonFunctions.calculateBasicODRateForGCV(Double.toString(ageOfTheVehicle), typeSpinner, zoneSpinner);

                if (idv.getText().toString().trim().equalsIgnoreCase("")) {
                    basicODRate = "0.00";
                } else {
                    String extraPremium = "0.00";
                    if (!gvw.getText().toString().trim().equalsIgnoreCase("")) {
                        if (Double.parseDouble(gvw.getText().toString().trim()) > 12000) {
                            extraPremium = Double.toString((Double.parseDouble(gvw.getText().toString().trim()) - 12000) / 100 * 27);
                        }
                    }
                    basicODPremium = Double.toString(((Double.parseDouble(basicODRate) / 100) * Double.parseDouble(idv.getText().toString())) + Double.parseDouble(extraPremium));
                }
                if (gvw.getText().toString().trim().equalsIgnoreCase("")) {
                    valid = false;
                    Toast.makeText(GcvDataEntry.this, "Please Enter GVW", Toast.LENGTH_SHORT).show();
                }
                if (!idv.getText().toString().trim().equalsIgnoreCase("")) {
                    if (odDiscount.getText().toString().trim().equalsIgnoreCase("")) {
                        basicODPremiumAfterDiscount = basicODPremium;
                    } else {
                        discountApplied = Double.toString((Double.parseDouble(odDiscount.getText().toString()) / 100) * Double.parseDouble(basicODPremium));
                        basicODPremiumAfterDiscount = Double.toString(Double.parseDouble(basicODPremium) - Double.parseDouble(discountApplied));
                    }

                    if (lpgCngCheckBox.isChecked()) {
                        lpgCngKitOD = Double.toString(5.00 / 100.00 * Double.parseDouble(basicODPremiumAfterDiscount));
                    }

                    if (ncCover.isChecked()) {

                        String[] result = CommonFunctions.calculateNDCoverPremium(CommonFunctions.GCV, years, months, ndCoverRate, basicODPremium);
                        ndCoverPremium = result[0];
                        ndCoverRate = result[1];

                        if (!imt23CheckBox.isChecked()) {
                            imt23CheckBox.setChecked(true);
                        }
                    }

                    if (imt23CheckBox.isChecked()) {
                        imt23Premium = Double.toString(15.00 / 100.00 * (Double.parseDouble(basicODPremiumAfterDiscount)));
                    }

                    if (consumables.isChecked()) {
                        consumablesPremium = CommonFunctions.calculateConsumablesPremium(CommonFunctions.GCV, ageOfTheVehicle, idv);
                    }

                    if (rti.isChecked()) {
                        rtiPremium = CommonFunctions.calculateRTIPremium(CommonFunctions.GCV, ageOfTheVehicle, idv);
                    }

                    if (rsaCheckBox.isChecked()) {
                        rsaPremium = CommonFunctions.calculateRSAPremium(CommonFunctions.GCV);
                    }

                    if (geoExtensionCheckBox.isChecked()) {
                        geoExtensionODPremium = CommonFunctions.GEO_EXTENSION_OD_PREMIUM;
                        geoExtensionTPPremium = CommonFunctions.GEO_EXTENSION_TP_PREMIUM;

                    }

                    if (!additionalTowingEditText.getText().toString().trim().equalsIgnoreCase("")) {
                        additionalTowingPremium = Double.toString(5.00 / 100.00 * Double.parseDouble(additionalTowingEditText.getText().toString().trim()));
                    }

                    totalODPremium = Double.toString(Double.parseDouble(basicODPremiumAfterDiscount) +
                            Double.parseDouble(imt23Premium) +
                            Double.parseDouble(ndCoverPremium) +
                            Double.parseDouble(rtiPremium) +
                            Double.parseDouble(geoExtensionODPremium));

                    ncbAmount = Double.toString(Double.parseDouble(ncbSpinner.getSelectedItem().toString()) / 100 * Double.parseDouble(totalODPremium));
                    totalODPremium = CommonFunctions.roundUp(Double.toString(Double.parseDouble(totalODPremium) -
                            Double.parseDouble(ncbAmount) +
                            Double.parseDouble(consumablesPremium) +
                            Double.parseDouble(engineProtectionPremium) +
                            Double.parseDouble(rsaPremium) +
                            Double.parseDouble(additionalTowingPremium) +
                            Double.parseDouble(lpgCngKitOD)));
                }

                // Third Party

                basicTPPremium = CommonFunctions.calculateBasicTPPremiumForGCV(gvw, typeSpinner, fuelTypeSpinner.getSelectedItem().toString());

                if (lpgCngCheckBox.isChecked()) {
                    lpgCngKitTP = CommonFunctions.CNG_LPG_KIT_TP_PREMIUM;
                }
                cpaPremium = CommonFunctions.calculateCPAPremium(twCPASpinner);
                if (llToPaidDriver.getText().toString().trim().equalsIgnoreCase("")) {
                    llToPaidDriverPremium = "0.00";
                } else {
                    llToPaidDriverPremium = Double.toString(Double.parseDouble(llToPaidDriver.getText().toString()) * 50);
                }

                if (!paToPaidDriverSISpinner.getSelectedItem().toString().equalsIgnoreCase("NA")) {
                    paToPaidDriverPremium = Double.toString((Double.parseDouble(paToPaidDriverSISpinner.getSelectedItem().toString()) / 10000.00) * 7.00);
                }

                if (!noOfPassenger.getText().toString().trim().equalsIgnoreCase("")) {
                    if (paToPassengerSISpinner.getSelectedItem().toString().equalsIgnoreCase("NA")) {
                        valid = false;
                        Toast.makeText(GcvDataEntry.this, "Please Select SI For Unnamed Passenger", Toast.LENGTH_SHORT).show();
                    } else {
                        String[] paToPassengerArray = CommonFunctions.calculatePAToPassenger(CommonFunctions.TWO_WHEELER, paToPassengerSISpinner, noOfPassenger);
                        paToPassengerPremium = paToPassengerArray[0];
                        paToPassengerTotalSI = paToPassengerArray[1];
                        valid = true;
                    }
                }

                totalTPPremium = Double.toString(Double.parseDouble(basicTPPremium) +
                        Double.parseDouble(cpaPremium) +
                        Double.parseDouble(llToPaidDriverPremium) +
                        Double.parseDouble(paToPaidDriverPremium) +
                        Double.parseDouble(paToPassengerPremium) +
                        Double.parseDouble(geoExtensionTPPremium) +
                        Double.parseDouble(lpgCngKitTP));

                netPremium = Double.toString(Double.parseDouble(totalODPremium) + Double.parseDouble(totalTPPremium));
                gstAmount = CommonFunctions.roundUp(Double.toString((CommonFunctions.GST_18 / 100.00 * (Double.parseDouble(netPremium) - Double.parseDouble(basicTPPremium))) +
                        (CommonFunctions.GST_5 / 100.00 * Double.parseDouble(basicTPPremium))));
                grossPremium = Double.toString(Double.parseDouble(netPremium) + Double.parseDouble(gstAmount));

                //payout = CommonFunctions.calculatePayout(CommonFunctions.GCV, fuelTypeSpinner.getSelectedItem().toString(), gvw.getText().toString(), netPremium, rtoStateSpinner.getSelectedItem().toString(), CommonFunctions.NO);
                payout = CommonFunctions.calculatePayoutForGVW(gvw.getText().toString(), rtoStateSpinner.getSelectedItem().toString(), netPremium);


                Intent intent = new Intent(GcvDataEntry.this, MotorPremuimDisplay.class);
                intent.putExtra("msg_product", CommonFunctions.GCV);
                intent.putExtra("msg_type", typeSpinner.getSelectedItem().toString());
                intent.putExtra("msg_zone", zoneSpinner.getSelectedItem().toString());
                intent.putExtra("msg_rtoState", rtoStateSpinner.getSelectedItem().toString());
                intent.putExtra("msg_fuelType", fuelTypeSpinner.getSelectedItem().toString());
                intent.putExtra("msg_gvw", gvw.getText().toString());
                intent.putExtra("msg_ageOfTheVehicle", CommonFunctions.uptoTwoDecimal(Double.toString(ageOfTheVehicle)));
                intent.putExtra("msg_idv", CommonFunctions.uptoTwoDecimal(idv.getText().toString()));
                intent.putExtra("msg_basicODRate", basicODRate);
                intent.putExtra("msg_basicODPremium", CommonFunctions.uptoTwoDecimal(basicODPremium));
                intent.putExtra("msg_discountPercentage", odDiscount.getText().toString());
                intent.putExtra("msg_discountAmount", CommonFunctions.uptoTwoDecimal(discountApplied));
                intent.putExtra("msg_ncbPercentage", ncbSpinner.getSelectedItem().toString());
                intent.putExtra("msg_ncbAmount", CommonFunctions.uptoTwoDecimal(ncbAmount));
                intent.putExtra("msg_imt23Premium", CommonFunctions.uptoTwoDecimal(imt23Premium));
                intent.putExtra("msg_ndCoverPremium", CommonFunctions.uptoTwoDecimal(ndCoverPremium));
                intent.putExtra("msg_ndCoverRate", ndCoverRate);
                intent.putExtra("msg_consumables", CommonFunctions.uptoTwoDecimal(consumablesPremium));
                intent.putExtra("msg_engineProtection", CommonFunctions.uptoTwoDecimal(engineProtectionPremium));
                intent.putExtra("msg_rti", CommonFunctions.uptoTwoDecimal(rtiPremium));
                intent.putExtra("msg_rsaPremium", CommonFunctions.uptoTwoDecimal(rsaPremium));
                intent.putExtra("msg_geoExtensionODPremium", CommonFunctions.uptoTwoDecimal(geoExtensionODPremium));
                intent.putExtra("msg_additionalTowingPremium", CommonFunctions.uptoTwoDecimal(additionalTowingPremium));
                intent.putExtra("msg_lpgCngKitODPremium", CommonFunctions.uptoTwoDecimal(lpgCngKitOD));
                intent.putExtra("msg_totalODPremium", CommonFunctions.uptoTwoDecimal(totalODPremium));

                intent.putExtra("msg_basicTPPremium", CommonFunctions.uptoTwoDecimal(basicTPPremium));
                intent.putExtra("msg_cpaPremium", CommonFunctions.uptoTwoDecimal(cpaPremium));
                intent.putExtra("msg_llToPaidDriverPremium", CommonFunctions.uptoTwoDecimal(llToPaidDriverPremium));
                intent.putExtra("msg_paToPaidDriverSI", paToPaidDriverSISpinner.getSelectedItem().toString());
                intent.putExtra("msg_paToPaidDriverPremium", CommonFunctions.uptoTwoDecimal(paToPaidDriverPremium));
                intent.putExtra("msg_paToPassengerPremium", CommonFunctions.uptoTwoDecimal(paToPassengerPremium));
                intent.putExtra("msg_paToPassengerSI", paToPassengerTotalSI);
                intent.putExtra("msg_geoExtensionTPPremium", CommonFunctions.uptoTwoDecimal(geoExtensionTPPremium));
                intent.putExtra("msg_lpgCngKitTPPremium", CommonFunctions.uptoTwoDecimal(lpgCngKitTP));
                intent.putExtra("msg_totalTPPremium", CommonFunctions.uptoTwoDecimal(totalTPPremium));

                intent.putExtra("msg_netPremium", CommonFunctions.uptoTwoDecimal(netPremium));
                intent.putExtra("msg_gstAmount", CommonFunctions.uptoTwoDecimal(gstAmount));
                intent.putExtra("msg_grossPremium", CommonFunctions.uptoTwoDecimal(grossPremium));

                intent.putExtra("msg_commission", CommonFunctions.uptoTwoDecimal(payout[0]));
                intent.putExtra("msg_commission_description", payout[1]);
                intent.putExtra("msg_incentive", CommonFunctions.uptoTwoDecimal(payout[2]));
                intent.putExtra("msg_incentive_description", payout[3]);
                intent.putExtra("msg_portalCharges", CommonFunctions.uptoTwoDecimal(payout[4]));
                intent.putExtra("msg_portalCharges_description", payout[5]);
                intent.putExtra("msg_portalIncentive", CommonFunctions.uptoTwoDecimal(payout[6]));
                intent.putExtra("msg_portalIncentive_description", payout[7]);

                if (valid) {
                    startActivity(intent);
                }
            }
        });*/
    }
}