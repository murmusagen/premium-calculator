package com.example.premiumcalculator;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class PrivateCarDataEntry extends AppCompatActivity {

    final Calendar myCalender1 = Calendar.getInstance();
    final Calendar myCalender2 = Calendar.getInstance();
    String basicODRate = "0.00";
    String basicODPremium = "0.00";
    String discountApplied = "0.00";
    String basicODPremiumAfterDiscount = "0.00";
    String ncbAmount = "0.00";
    String consumablesPremium = "0.00";
    String totalODPremium = "0.00";
    String basicTPPremium = "0.00";
    String cpaPremium = "0.00";
    String llToPaidDriverPremium = "0.00";
    String totalTPPremium = "0.00";
    String netPremium = "0.00";
    String gstAmount = "0.00";
    String grossPremium = "0.00";
    ArrayList<String> payout = new ArrayList<String>();
    String paToPaidDriverPremium = "0.00";
    String paToPassengerPremium = "0.00";
    String paToPassengerSI = "0.00";
    String paToPassengerTotalSI = "0.00";
    String ndCoverPremium = "0.00";
    String ndCoverRate = "0.00";
    String engineProtectionPremium = "0.00";
    String rtiPremium = "0.00";
    String lossOfKeyPremium = "0.00";
    String personalEffectPremium = "0.00";
    String personalEffectSI = "0.00";
    String lossOfKeySI = "0.00";
    String rsaPremium = "0.00";
    Calendar regDateCalendar = Calendar.getInstance();
    Calendar polStartDateCalendar = Calendar.getInstance();
    EditText idv = null;
    EditText cc = null;
    EditText odDiscount = null;
    CheckBox ncCover = null;
    CheckBox consumables = null;
    CheckBox engineProtection = null;
    CheckBox rti = null;
    CheckBox lossOfKey = null;
    CheckBox rsaCheckBox = null;
    EditText llToPaidDriver = null;
    EditText noOfPassenger = null;
    CheckBox lossOfKeyCheckBox = null;
    CheckBox personalEffectCheckBox = null;
    Spinner lossOfKeySISpinner = null;
    Spinner personalEffectSISpinner = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_private_car_data_entry);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner typeSpinner = findViewById(R.id.typeSpinner);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.TYPE_ARRAY);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);

        Spinner isSAODSpinner = findViewById(R.id.isSAODSpinner);
        ArrayAdapter<String> isSAODAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.IS_SAOD_ARRAY);
        isSAODAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        isSAODSpinner.setAdapter(isSAODAdapter);

        Spinner zoneSpinner = findViewById(R.id.zoneSpinner);
        ArrayAdapter<String> zoneAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.ZONE_TW_PVT_ARRAY);
        zoneAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zoneSpinner.setAdapter(zoneAdapter);

        Spinner rtoStateSpinner = findViewById(R.id.rtoStateSpinner);
        ArrayAdapter<String> rtoStateAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.ALL_STATES_ARRAY);
        rtoStateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rtoStateSpinner.setAdapter(rtoStateAdapter);

        Spinner pvtCarManufacturerSpinner = findViewById(R.id.pvtCarManufacturerSpinner);
        ArrayAdapter<String> pvtCarManufacturerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.PVT_CAR_MANUFACTURER_ARRAY);
        pvtCarManufacturerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pvtCarManufacturerSpinner.setAdapter(pvtCarManufacturerAdapter);

        Spinner fuelTypeSpinner = findViewById(R.id.fuelTypeSpinner);
        ArrayAdapter<String> fuelTypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.PVT_FUEL_TYPE);
        fuelTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fuelTypeSpinner.setAdapter(fuelTypeAdapter);

        EditText ccEditText = findViewById(R.id.ccEditText);

        Spinner ncbSpinner = findViewById(R.id.ncbSpinner);
        ArrayAdapter<String> ncbAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.NCB_ARRAY);
        ncbAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ncbSpinner.setAdapter(ncbAdapter);

        lossOfKeySISpinner = findViewById(R.id.lossOfKeySISpinner);
        ArrayAdapter<String> lossOfKeySIAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.LOSS_OF_KEY_SI_ARRAY);
        lossOfKeySIAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lossOfKeySISpinner.setAdapter(lossOfKeySIAdapter);

        personalEffectSISpinner = findViewById(R.id.personalEffectSISpinner);
        ArrayAdapter<String> personalEffectSIAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.PERSONAL_EFFECT_SI_ARRAY);
        personalEffectSIAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        personalEffectSISpinner.setAdapter(personalEffectSIAdapter);

        Spinner twCPASpinner = findViewById(R.id.twCPASpinner);
        ArrayAdapter<String> twCPAAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.CPA_ARRAY);
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

        Button calculateTwPremium = findViewById(R.id.calculateTwPremium);


        lossOfKeyCheckBox = findViewById(R.id.lossOfKeyCheckBox);
        lossOfKeySISpinner = findViewById(R.id.lossOfKeySISpinner);
        lossOfKeySISpinner.setEnabled(false);

        lossOfKeyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    lossOfKeySISpinner.setSelection(0);
                    lossOfKeySISpinner.setEnabled(true);
                } else {
                    lossOfKeySISpinner.setSelection(0);
                    lossOfKeySISpinner.setEnabled(false);
                }
            }
        });

        personalEffectCheckBox = findViewById(R.id.personalEffectCheckBox);
        personalEffectSISpinner = findViewById(R.id.personalEffectSISpinner);
        personalEffectSISpinner.setEnabled(false);

        personalEffectCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChekcked) {
                if (isChekcked) {
                    personalEffectSISpinner.setSelection(0);
                    personalEffectSISpinner.setEnabled(true);
                } else {
                    personalEffectSISpinner.setSelection(0);
                    personalEffectSISpinner.setEnabled(false);
                }
            }
        });

        EditText regDate = findViewById(R.id.regDateEditText);
        EditText polStartDate = findViewById(R.id.polStartDateEditText);

        TextView discountLimitsTextView = findViewById(R.id.discountLimitsTextView);

        discountLimitsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.private_car_discount_limit_dialog_layout, null);

                AlertDialog.Builder builder = new AlertDialog.Builder(PrivateCarDataEntry.this);
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

        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 1){
                    isSAODSpinner.setSelection(0);
                    isSAODSpinner.setEnabled(false);
                }else{
                    isSAODSpinner.setEnabled(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        calculateTwPremium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*valid = true;*/

                ArrayList<Boolean> inValid = new ArrayList<>();

                basicODRate = "0.00";
                basicODPremium = "0.00";
                discountApplied = "0.00";
                basicODPremiumAfterDiscount = "0.00";
                ncbAmount = "0.00";
                consumablesPremium = "0.00";
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
                paToPassengerSI = "0.00";
                paToPassengerTotalSI = "0.00";
                ndCoverPremium = "0.00";
                ndCoverRate = "0.00";
                engineProtectionPremium = "0.00";
                rtiPremium = "0.00";
                lossOfKeyPremium = "0.00";
                lossOfKeySI = "0.00";
                rsaPremium = "0.00";
                personalEffectPremium = "0.00";

                idv = findViewById(R.id.idvEditText);
                cc = findViewById(R.id.ccEditText);
                odDiscount = findViewById(R.id.oddiscountEditText);
                ncCover = findViewById(R.id.ndCoverCheckBox);
                consumables = findViewById(R.id.consumablesCheckBox);
                engineProtection = findViewById(R.id.engineProtectionCheckBox);
                rti = findViewById(R.id.rtiCheckbox);
                lossOfKey = findViewById(R.id.lossOfKeyCheckbox);
                rsaCheckBox = findViewById(R.id.rsaCheckBox);
                llToPaidDriver = findViewById(R.id.llToPaidDriverEditText);
                noOfPassenger = findViewById(R.id.noOfPassengerEditText);
                lossOfKeyCheckBox = findViewById(R.id.lossOfKeyCheckBox);
                lossOfKeySISpinner = findViewById(R.id.lossOfKeySISpinner);
                personalEffectSISpinner = findViewById(R.id.personalEffectSISpinner);

                if(cc.getText().toString().trim().equalsIgnoreCase("")){
                    inValid.add(true);
                    Toast.makeText(PrivateCarDataEntry.this, "Please Enter CC/KW", Toast.LENGTH_SHORT).show();

                }

                lossOfKeyCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                        if (isChecked) {
                            lossOfKeySISpinner.setSelection(0);
                            lossOfKeySISpinner.setEnabled(true);
                        } else {
                            lossOfKeySISpinner.setSelection(0);
                            lossOfKeySISpinner.setEnabled(false);
                        }
                    }
                });


                long millisBetween = CommonFunctions.convertStringToCalenderObject(polStartDate.getText().toString().trim()) - CommonFunctions.convertStringToCalenderObject(regDate.getText().toString().trim());
                double ageOfTheVehicle = millisBetween / (1000.0 * 60 * 60 * 24 * 365.2425);

                int[] yearsAndMonthsFromAgeResult = CommonFunctions.getYearsAndMonthsFromAge(polStartDate.getText().toString().trim(), regDate.getText().toString().trim());
                int years = yearsAndMonthsFromAgeResult[0];
                int months = yearsAndMonthsFromAgeResult[1];

                if(inValid.isEmpty()){
                    basicODRate = CommonFunctions.calculateBasicODRateForPvtCar(Double.toString(ageOfTheVehicle), zoneSpinner, ccEditText.getText().toString().trim(), fuelTypeSpinner.getSelectedItem().toString());
                }else{
                    basicODRate = "0.00";
                }

                if (idv.getText().toString().trim().equalsIgnoreCase("")) {
                    basicODRate = "0.00";
                } else {
                    basicODPremium = Double.toString((Double.parseDouble(basicODRate) / 100) * Double.parseDouble(idv.getText().toString()));
                }

                if (!idv.getText().toString().trim().equalsIgnoreCase("")) {
                    if (odDiscount.getText().toString().trim().equalsIgnoreCase("")) {
                        basicODPremiumAfterDiscount = basicODPremium;
                    } else {
                        discountApplied = Double.toString((Double.parseDouble(odDiscount.getText().toString()) / 100) * Double.parseDouble(basicODPremium));
                        basicODPremiumAfterDiscount = Double.toString(Double.parseDouble(basicODPremium) - Double.parseDouble(discountApplied));
                    }

                    if (ncCover.isChecked()) {
                        String[] result = CommonFunctions.calculateNDCoverPremium(CommonFunctions.PRIVATE_CAR, years, months, ndCoverRate, basicODPremium);
                        ndCoverPremium = result[0];
                        ndCoverRate = result[1];
                    }

                    if (consumables.isChecked()) {
                        consumablesPremium = CommonFunctions.calculateConsumablesPremium(CommonFunctions.PRIVATE_CAR, ageOfTheVehicle, idv);
                    }

                    if (engineProtection.isChecked()) {
                        engineProtectionPremium = CommonFunctions.calculateEngineProtectionPremium(CommonFunctions.PRIVATE_CAR, ageOfTheVehicle, idv);
                    }

                    if (rti.isChecked()) {
                        rtiPremium = CommonFunctions.calculateRTIPremium(CommonFunctions.PRIVATE_CAR, ageOfTheVehicle, idv);
                    }

                    if (!lossOfKeySISpinner.getSelectedItem().toString().equalsIgnoreCase("NA")) {
                        if (lossOfKeySISpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.LOSS_OF_KEY_SI_10000)) {
                            String[] result = CommonFunctions.calculateLossOfKey(CommonFunctions.PRIVATE_CAR, lossOfKeySISpinner.getSelectedItem().toString());
                            lossOfKeyPremium = result[0];
                            lossOfKeySI = result[1];
                        }
                    }

                    if (!personalEffectSISpinner.getSelectedItem().toString().equalsIgnoreCase("NA")) {
                        String[] result = CommonFunctions.calculatePersonalEffectPremium(CommonFunctions.PRIVATE_CAR, personalEffectSISpinner.getSelectedItem().toString());
                        personalEffectPremium = result[0];
                        personalEffectSI = result[1];
                    }

                    if (rsaCheckBox.isChecked()) {
                        rsaPremium = CommonFunctions.calculateRSAPremium(CommonFunctions.PRIVATE_CAR);
                    }

                    totalODPremium = Double.toString(Double.parseDouble(basicODPremium) -
                            Double.parseDouble(discountApplied) +
                            Double.parseDouble(ndCoverPremium) +
                            Double.parseDouble(rtiPremium));

                    ncbAmount = Double.toString(Double.parseDouble(ncbSpinner.getSelectedItem().toString()) / 100 * Double.parseDouble(totalODPremium));
                    totalODPremium = Double.toString(Double.parseDouble(totalODPremium) -
                            Double.parseDouble(ncbAmount) +
                            Double.parseDouble(consumablesPremium) +
                            Double.parseDouble(engineProtectionPremium) +
                            Double.parseDouble(lossOfKeyPremium) +
                            Double.parseDouble(rsaPremium) +
                            Double.parseDouble(personalEffectPremium));
                    totalODPremium = CommonFunctions.roundUp(totalODPremium);
                }

                // Third Party
                if(inValid.isEmpty()){
                    basicTPPremium = CommonFunctions.calculateBasicTPPremiumForPrivateCar(fuelTypeSpinner, typeSpinner, ccEditText.getText().toString().trim());
                }else{
                    basicTPPremium = "0.00";
                }
                cpaPremium = CommonFunctions.calculateCPAPremium(twCPASpinner);

                if (llToPaidDriver.getText().toString().trim().equalsIgnoreCase("")) {
                    llToPaidDriverPremium = "0.00";
                } else {
                    llToPaidDriverPremium = Double.toString(Double.parseDouble(llToPaidDriver.getText().toString()) * 50);
                }

                if (!paToPaidDriverSISpinner.getSelectedItem().toString().equalsIgnoreCase("NA")) {
                    paToPaidDriverPremium = Double.toString((Double.parseDouble(paToPaidDriverSISpinner.getSelectedItem().toString()) / 10000.00) * 5.00);
                }

                if (!noOfPassenger.getText().toString().trim().equalsIgnoreCase("")) {
                    if (paToPassengerSISpinner.getSelectedItem().toString().equalsIgnoreCase("NA")) {
                        inValid.add(true);
                        Toast.makeText(PrivateCarDataEntry.this, "Please Select SI For Unnamed Passenger", Toast.LENGTH_SHORT).show();
                    } else {
                        String[] paToPassengerArray = CommonFunctions.calculatePAToPassenger(CommonFunctions.PRIVATE_CAR, paToPassengerSISpinner, noOfPassenger);
                        paToPassengerPremium = paToPassengerArray[0];
                        paToPassengerTotalSI = paToPassengerArray[1];
                    }
                }

                totalTPPremium = Double.toString(Double.parseDouble(basicTPPremium) +
                        Double.parseDouble(cpaPremium) +
                        Double.parseDouble(llToPaidDriverPremium) +
                        Double.parseDouble(paToPaidDriverPremium) +
                        Double.parseDouble(paToPassengerPremium));

                if(isSAODSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.YES)){
                    basicTPPremium = "0.00";
                    totalTPPremium = "0.00";
                }

                netPremium = Double.toString(Double.parseDouble(totalODPremium) + Double.parseDouble(totalTPPremium));
                gstAmount = CommonFunctions.roundUp(Double.toString(CommonFunctions.GST_18 / 100.00 * (Double.parseDouble(netPremium))));
                grossPremium = Double.toString(Double.parseDouble(netPremium) + Double.parseDouble(gstAmount));

                payout = CommonFunctions.calculatePayoutForPvtCar(fuelTypeSpinner.getSelectedItem().toString(), ccEditText.getText().toString().trim(), isSAODSpinner.getSelectedItem().toString(), typeSpinner.getSelectedItem().toString(), pvtCarManufacturerSpinner.getSelectedItem().toString(), netPremium, totalODPremium, totalTPPremium, rtoStateSpinner.getSelectedItem().toString());

                Intent intent = new Intent(PrivateCarDataEntry.this, MotorPremuimDisplay.class);
                intent.putExtra("msg_product", CommonFunctions.PRIVATE_CAR);
                intent.putExtra("msg_type", typeSpinner.getSelectedItem().toString());
                intent.putExtra("msg_zone", zoneSpinner.getSelectedItem().toString());
                intent.putExtra("msg_rtoState", rtoStateSpinner.getSelectedItem().toString());
                intent.putExtra("msg_fuelType", fuelTypeSpinner.getSelectedItem().toString());
                intent.putExtra("msg_cc", ccEditText.getText().toString().trim());
                intent.putExtra("msg_ageOfTheVehicle", CommonFunctions.uptoTwoDecimal(Double.toString(ageOfTheVehicle)));
                intent.putExtra("msg_idv", CommonFunctions.uptoTwoDecimal(idv.getText().toString()));
                intent.putExtra("msg_basicODRate", basicODRate);
                intent.putExtra("msg_basicODPremium", CommonFunctions.uptoTwoDecimal(basicODPremium));
                intent.putExtra("msg_discountPercentage", odDiscount.getText().toString());
                intent.putExtra("msg_discountAmount", CommonFunctions.uptoTwoDecimal(discountApplied));
                intent.putExtra("msg_ncbPercentage", ncbSpinner.getSelectedItem().toString());
                intent.putExtra("msg_ncbAmount", CommonFunctions.uptoTwoDecimal(ncbAmount));
                intent.putExtra("msg_ndCoverPremium", CommonFunctions.uptoTwoDecimal(ndCoverPremium));
                intent.putExtra("msg_ndCoverRate", ndCoverRate);
                intent.putExtra("msg_consumables", CommonFunctions.uptoTwoDecimal(consumablesPremium));
                intent.putExtra("msg_engineProtection", CommonFunctions.uptoTwoDecimal(engineProtectionPremium));
                intent.putExtra("msg_rti", CommonFunctions.uptoTwoDecimal(rtiPremium));
                intent.putExtra("msg_lossOfKeyPremium", CommonFunctions.uptoTwoDecimal(lossOfKeyPremium));
                intent.putExtra("msg_rsaPremium", CommonFunctions.uptoTwoDecimal(rsaPremium));
                intent.putExtra("msg_lossOfkeySI", CommonFunctions.uptoTwoDecimal(lossOfKeySI));
                intent.putExtra("msg_personalEffectPremium", CommonFunctions.uptoTwoDecimal(personalEffectPremium));
                intent.putExtra("msg_personalEffectSI", CommonFunctions.uptoTwoDecimal(personalEffectSI));
                intent.putExtra("msg_totalODPremium", CommonFunctions.uptoTwoDecimal(totalODPremium));

                intent.putExtra("msg_basicTPPremium", CommonFunctions.uptoTwoDecimal(basicTPPremium));
                intent.putExtra("msg_cpaPremium", CommonFunctions.uptoTwoDecimal(cpaPremium));
                intent.putExtra("msg_llToPaidDriverPremium", CommonFunctions.uptoTwoDecimal(llToPaidDriverPremium));
                intent.putExtra("msg_paToPaidDriverSI", paToPaidDriverSISpinner.getSelectedItem().toString());
                intent.putExtra("msg_paToPaidDriverPremium", CommonFunctions.uptoTwoDecimal(paToPaidDriverPremium));
                intent.putExtra("msg_paToPassengerPremium", CommonFunctions.uptoTwoDecimal(paToPassengerPremium));
                intent.putExtra("msg_paToPassengerSI", paToPassengerTotalSI);
                intent.putExtra("msg_totalTPPremium", CommonFunctions.uptoTwoDecimal(totalTPPremium));

                intent.putExtra("msg_netPremium", CommonFunctions.uptoTwoDecimal(netPremium));
                intent.putExtra("msg_gstAmount", CommonFunctions.uptoTwoDecimal(gstAmount));
                intent.putExtra("msg_grossPremium", CommonFunctions.uptoTwoDecimal(grossPremium));

                intent.putExtra("msg_commission", CommonFunctions.uptoTwoDecimal(payout.get(0)));
                intent.putExtra("msg_commission_description", payout.get(1));
                intent.putExtra("msg_incentive", CommonFunctions.uptoTwoDecimal(payout.get(2)));
                intent.putExtra("msg_incentive_description", payout.get(3));
                intent.putExtra("msg_portalCharges", CommonFunctions.uptoTwoDecimal(payout.get(4)));
                intent.putExtra("msg_portalCharges_description", payout.get(5));
                intent.putExtra("msg_portalIncentive", CommonFunctions.uptoTwoDecimal(payout.get(6)));
                intent.putExtra("msg_portalIncentive_description", payout.get(7));
                intent.putExtra("msg_additionalIncentiveOD", CommonFunctions.uptoTwoDecimal(payout.get(8)));
                intent.putExtra("msg_additionalIncentiveOD_description", payout.get(9));
                intent.putExtra("msg_additionalIncentiveTP", CommonFunctions.uptoTwoDecimal(payout.get(10)));
                intent.putExtra("msg_additionalIncentiveTP_description", payout.get(11));

                if (inValid.isEmpty()) {
                    startActivity(intent);
                }
            }
        });
    }
}