package com.example.premiumcalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IndividualHealthDataEntry extends AppCompatActivity {

    LinearLayout container;
    LayoutInflater inflater;
    LinearLayout floaterSILinearLayout;
    LinearLayout floateNCDLinearLayout;
    EditText noOfMembersEditText;
    EditText memberAgeEditText;
    ArrayList<HashMap<String, String>> premium = new ArrayList<>();
    CheckBox dailyCashCoverCheckBox;
    CheckBox maternityCheckBox;
    Button findZoneButton;
    Button calculateIHPPremiumButton;
    Spinner dailyCashAllowanceAmountSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_individual_health_data_entry);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        container = findViewById(R.id.container);
        inflater = LayoutInflater.from(this);
        noOfMembersEditText = findViewById(R.id.noOfMembersEditText);
        dailyCashCoverCheckBox = findViewById(R.id.dailyCashCoverCheckBox);
        findZoneButton = findViewById(R.id.findZoneButton);
        calculateIHPPremiumButton = findViewById(R.id.calculateIHPPremiumButton);

        dailyCashAllowanceAmountSpinner = findViewById(R.id.dailyCashAllowanceAmountSpinner);
        ArrayAdapter<String> dailyCashAllowanceAmountAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.DAILY_CASH_ALLOWANCE_ARRAY);
        dailyCashAllowanceAmountAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dailyCashAllowanceAmountSpinner.setAdapter(dailyCashAllowanceAmountAdapter);
        dailyCashAllowanceAmountSpinner.setEnabled(false);

        dailyCashCoverCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dailyCashCoverCheckBox.isChecked()){
                    dailyCashAllowanceAmountSpinner.setEnabled(true);
                }else{
                    dailyCashAllowanceAmountSpinner.setEnabled(false);
                }
            }
        });

        ArrayList<Map<String, View>> memberDetailsArrayList = new ArrayList<Map<String, View>>();

        String[] individualHealthType = {CommonFunctions.INDIVIDUAL};
        Spinner typeSpinner = findViewById(R.id.typeSpinner);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, individualHealthType);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);

        ArrayAdapter<String> individualHealthMemberSIAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.IHP_SI_ARRAY);
        ArrayAdapter<String> individualHealthNCDAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.NCB_ARRAY);


        String[] healthZoneArray = {CommonFunctions.ZONE_C, CommonFunctions.ZONE_B, CommonFunctions.ZONE_A};
        Spinner zoneSpinner = findViewById(R.id.zoneSpinner);
        ArrayAdapter<String> zoneAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, healthZoneArray);
        zoneAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zoneSpinner.setAdapter(zoneAdapter);

        findZoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(IndividualHealthDataEntry.this);
                builder.setTitle("Zone Information");
                builder.setMessage(CommonFunctions.ALL_ZONE_TEXT);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.create().show();
            }
        });

        Spinner familyTypeSpinner = findViewById(R.id.familyTypeSpinner);
        ArrayAdapter<String> familyTypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.FAMILY_TYPE_ARRAY_WITH_ONE_ADULT_SELECTION_ALSO);
        familyTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        familyTypeSpinner.setAdapter(familyTypeAdapter);

        noOfMembersEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().trim().equalsIgnoreCase("")) {
                    int i = Integer.parseInt(editable.toString().trim());
                    if (i == 0) {
                        container.removeAllViews();
                        memberDetailsArrayList.clear();
                        return;
                    } else {
                        container.removeAllViews();
                        int count = 1;
                        for (int j = 0; j < i; j++) {
                            Map<String, View> map = new HashMap<>();
                            View dynamicLayout = inflater.inflate(R.layout.health_member_data_entry, container, false);

                            TextView memberNoTextView = dynamicLayout.findViewById(R.id.memberNoTextView);

                            memberNoTextView.setText("Member ".concat(Integer.toString(j + 1)));

                            memberAgeEditText = dynamicLayout.findViewById(R.id.memberAgeEditText);

                            EditText memberAgeEditText = dynamicLayout.findViewById(R.id.memberAgeEditText);


                            Spinner individualHealthMemberSISpinner = dynamicLayout.findViewById(R.id.familyMedicareMemberSISpinner);
                            individualHealthMemberSIAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            individualHealthMemberSISpinner.setAdapter(individualHealthMemberSIAdapter);
                            individualHealthMemberSISpinner.setSelection(6);

                            Spinner individualHealthMemberNCDSpinner = dynamicLayout.findViewById(R.id.memberNCDSpinner);
                            individualHealthNCDAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            individualHealthMemberNCDSpinner.setAdapter(individualHealthNCDAdapter);

                            container.addView(dynamicLayout);
                            count = count + 1;

                            map.put(CommonFunctions.INTENT_MEMBER_AGE, memberAgeEditText);
                            map.put(CommonFunctions.INTENT_MEMBER_SI, individualHealthMemberSISpinner);
                            map.put(CommonFunctions.INTENT_MEMBER_NCD_PERCENTAGE, individualHealthMemberNCDSpinner);
                            memberDetailsArrayList.add(map);
                        }
                    }
                } else {
                    container.removeAllViews();
                    memberDetailsArrayList.clear();
                }
            }
        });

        calculateIHPPremiumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(noOfMembersEditText.getText().toString().trim().equalsIgnoreCase("")){
                    Toast.makeText(IndividualHealthDataEntry.this, "Please Enter No. Of Members", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ONE_ADULT) &&
                            Integer.parseInt(noOfMembersEditText.getText().toString().trim()) != 1) {
                        Toast.makeText(IndividualHealthDataEntry.this, "Please Select Proper Family Type/No Of Family", Toast.LENGTH_SHORT).show();
                    } else if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ONE_ADULT_ANY_CHILD) &&
                            Integer.parseInt(noOfMembersEditText.getText().toString().trim()) < 2) {
                        Toast.makeText(IndividualHealthDataEntry.this, "Please Select Proper Family Type/No Of Family", Toast.LENGTH_SHORT).show();
                    } else if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.TWO_ADULT) &&
                            Integer.parseInt(noOfMembersEditText.getText().toString().trim()) != 2) {
                        Toast.makeText(IndividualHealthDataEntry.this, "Please Select Proper Family Type/No Of Family", Toast.LENGTH_SHORT).show();
                    } else if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.TWO_ADULT_ANY_CHILD) &&
                            Integer.parseInt(noOfMembersEditText.getText().toString().trim()) < 3) {
                        Toast.makeText(IndividualHealthDataEntry.this, "Please Select Proper Family Type/No Of Family", Toast.LENGTH_SHORT).show();
                    } else {
                        premium = CommonFunctions.calculateIndividualHealthPremium(typeSpinner.getSelectedItem().toString(),
                                zoneSpinner.getSelectedItem().toString(),
                                noOfMembersEditText.getText().toString(),
                                memberDetailsArrayList,
                                IndividualHealthDataEntry.this,
                                familyTypeSpinner.getSelectedItem().toString(),
                                dailyCashCoverCheckBox.isChecked(),
                                false,
                                dailyCashAllowanceAmountSpinner.getSelectedItem().toString());

                        Intent intent = new Intent(IndividualHealthDataEntry.this, HealthPremiumDisplay.class);
                        intent.putExtra(CommonFunctions.INTENT_PRODUCT_NAME, CommonFunctions.INDIVIDUAL_HEALTH_POLICY);
                        intent.putExtra(CommonFunctions.INTENT_TYPE, typeSpinner.getSelectedItem().toString());
                        intent.putExtra(CommonFunctions.INTENT_ZONE, zoneSpinner.getSelectedItem().toString());
                        intent.putExtra(CommonFunctions.INTENT_PREMIUM_AND_COMMISSION, premium);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}