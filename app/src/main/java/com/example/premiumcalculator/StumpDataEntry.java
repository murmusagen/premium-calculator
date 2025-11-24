package com.example.premiumcalculator;

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
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StumpDataEntry extends AppCompatActivity {

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
    TextView commissionTextView;
    LinearLayout floaterThresholdLinearLayout;
    Button calculateSTUMPPremiumButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_stump_data_entry);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        container = findViewById(R.id.container);
        inflater = LayoutInflater.from(this);
        floaterThresholdLinearLayout = findViewById(R.id.floaterThresholdLinearLayout);
        floaterSILinearLayout = findViewById(R.id.floaterSILinearLayout);
        noOfMembersEditText = findViewById(R.id.noOfMembersEditText);
        dailyCashCoverCheckBox = findViewById(R.id.dailyCashCoverCheckBox);
        commissionTextView = findViewById(R.id.commissionTextView);
        calculateSTUMPPremiumButton = findViewById(R.id.calculateSTUMPPremiumButton);

        ArrayList<Map<String, View>> memberDetailsArrayList = new ArrayList<Map<String, View>>();

        Spinner typeSpinner = findViewById(R.id.typeSpinner);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.HEALTH_TYPE_ARRAY);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);

        Spinner familyTypeSpinner = findViewById(R.id.familyTypeSpinner);
        ArrayAdapter<String> familyTypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.FAMILY_TYPE_ARRAY);
        ArrayAdapter<String> familyTypeAdapterWithOneAdultOption = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.FAMILY_TYPE_ARRAY_WITH_ONE_ADULT_SELECTION_ALSO);
        familyTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        familyTypeAdapterWithOneAdultOption.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    floaterSILinearLayout.setVisibility(View.VISIBLE);
                    floaterThresholdLinearLayout.setVisibility(View.VISIBLE);
                    if (!noOfMembersEditText.getText().toString().equalsIgnoreCase("")) {
                        noOfMembersEditText.setText("");
                    }
                    familyTypeSpinner.setAdapter(familyTypeAdapter);
                } else if (i == 1) {
                    floaterSILinearLayout.setVisibility(View.GONE);
                    floaterThresholdLinearLayout.setVisibility(View.GONE);
                    if (!noOfMembersEditText.getText().toString().equalsIgnoreCase("")) {
                        noOfMembersEditText.setText("");
                    }
                    familyTypeSpinner.setAdapter(familyTypeAdapterWithOneAdultOption);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Spinner floaterThresholdSpinner = findViewById(R.id.floaterThresholdSpinner);
        Spinner floaterSISpinner = findViewById(R.id.floaterSISpinner);

        ArrayAdapter<String> floaterThresholdArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.STUMP_THRESHOLD_ARRAY);
        floaterThresholdArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        floaterThresholdSpinner.setAdapter(floaterThresholdArrayAdapter);

        ArrayAdapter<String> floaterSIWhen200000ArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.SUMP_SI_WHEN_THRESHOLD_200000_ARRAY);
        ArrayAdapter<String> floaterSIWhen300000ArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.SUMP_SI_WHEN_THRESHOLD_300000_ARRAY);
        ArrayAdapter<String> floaterSIWhen500000ArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.SUMP_SI_WHEN_THRESHOLD_500000_ARRAY);
        ArrayAdapter<String> floaterSIWhen1000000ArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.SUMP_SI_WHEN_THRESHOLD_1000000_ARRAY);
        ArrayAdapter<String> floaterSIWhen1500000ArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.SUMP_SI_WHEN_THRESHOLD_1500000_ARRAY);
        ArrayAdapter<String> floaterSIWhen2000000ArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.SUMP_SI_WHEN_THRESHOLD_2000000_ARRAY);
        ArrayAdapter<String> floaterSIWhen2500000ArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.SUMP_SI_WHEN_THRESHOLD_2500000_ARRAY);

        floaterThresholdSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    floaterSIWhen200000ArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    floaterSISpinner.setAdapter(floaterSIWhen200000ArrayAdapter);
                } else if (i == 1) {
                    floaterSIWhen300000ArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    floaterSISpinner.setAdapter(floaterSIWhen300000ArrayAdapter);
                } else if (i == 2) {
                    floaterSIWhen500000ArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    floaterSISpinner.setAdapter(floaterSIWhen500000ArrayAdapter);
                } else if (i == 3) {
                    floaterSIWhen1000000ArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    floaterSISpinner.setAdapter(floaterSIWhen1000000ArrayAdapter);
                } else if (i == 4) {
                    floaterSIWhen1500000ArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    floaterSISpinner.setAdapter(floaterSIWhen1500000ArrayAdapter);
                } else if (i == 5) {
                    floaterSIWhen2000000ArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    floaterSISpinner.setAdapter(floaterSIWhen2000000ArrayAdapter);
                } else if (i == 6) {
                    floaterSIWhen2500000ArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    floaterSISpinner.setAdapter(floaterSIWhen2500000ArrayAdapter);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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

                            if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ONE_ADULT)) {
                                memberNoTextView.setText("Self");
                            } else if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ONE_ADULT_ANY_CHILD)) {
                                if (count == 1) {
                                    memberNoTextView.setText("Self");
                                } else {
                                    memberNoTextView.setText("Child");
                                }
                            } else if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.TWO_ADULT)) {
                                if (count == 1) {
                                    memberNoTextView.setText("Self");
                                } else {
                                    memberNoTextView.setText("Spouse");
                                }
                            } else if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.TWO_ADULT_ANY_CHILD)) {
                                if (count == 1) {
                                    memberNoTextView.setText("Self");
                                } else if (count == 2) {
                                    memberNoTextView.setText("Spouse");
                                } else {
                                    memberNoTextView.setText("Child");
                                }
                            }

                            memberAgeEditText = dynamicLayout.findViewById(R.id.memberAgeEditText);

                            EditText memberAge = dynamicLayout.findViewById(R.id.memberAgeEditText);
                            CommonFunctions.deleteLayout(dynamicLayout.findViewById(R.id.healthMemberDataForIndividualLinearLayout));

                            Spinner stumpMemberThresholdSpinner = dynamicLayout.findViewById(R.id.stumpMemberThresholdSpinner);
                            floaterThresholdArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            stumpMemberThresholdSpinner.setAdapter(floaterThresholdArrayAdapter);
                            if (typeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.FLOATER)) {
                                stumpMemberThresholdSpinner.setSelection(0);
                                stumpMemberThresholdSpinner.setEnabled(false);
                            }


                            Spinner stumpMemberSISpinner = dynamicLayout.findViewById(R.id.stumpMemberSISpinner);
                            stumpMemberThresholdSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                                    if(i == 0){
                                        floaterSIWhen200000ArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                        stumpMemberSISpinner.setAdapter(floaterSIWhen200000ArrayAdapter);
                                    } else if (i == 1) {
                                        floaterSIWhen300000ArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                        stumpMemberSISpinner.setAdapter(floaterSIWhen300000ArrayAdapter);
                                    } else if (i == 2) {
                                        floaterSIWhen500000ArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                        stumpMemberSISpinner.setAdapter(floaterSIWhen500000ArrayAdapter);
                                    } else if (i == 3) {
                                        floaterSIWhen1000000ArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                        stumpMemberSISpinner.setAdapter(floaterSIWhen1000000ArrayAdapter);
                                    } else if (i == 4) {
                                        floaterSIWhen1500000ArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                        stumpMemberSISpinner.setAdapter(floaterSIWhen1500000ArrayAdapter);
                                    } else if (i == 5) {
                                        floaterSIWhen2000000ArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                        stumpMemberSISpinner.setAdapter(floaterSIWhen2000000ArrayAdapter);
                                    } else if (i == 6) {
                                        floaterSIWhen2500000ArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                        stumpMemberSISpinner.setAdapter(floaterSIWhen2500000ArrayAdapter);
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {

                                }
                            });
                            if (typeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.FLOATER)) {
                                stumpMemberSISpinner.setSelection(0);
                                stumpMemberSISpinner.setEnabled(false);
                            } else {
                                stumpMemberThresholdSpinner.setSelection(0);
                            }

                            if (typeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.FLOATER)) {
                                CommonFunctions.deleteLayoutAndView(dynamicLayout.findViewById(R.id.healthMemberDataForSTUMPIndividualLinearLayout));
                            }

                            container.addView(dynamicLayout);
                            count = count + 1;

                            map.put(CommonFunctions.INTENT_MEMBER_AGE, memberAge);
                            map.put(CommonFunctions.INTENT_MEMBER_THRESHOLD, stumpMemberThresholdSpinner);
                            map.put(CommonFunctions.INTENT_MEMBER_SI, stumpMemberSISpinner);
                            memberDetailsArrayList.add(map);

                        }
                    }
                } else {
                    container.removeAllViews();
                    memberDetailsArrayList.clear();
                }
            }
        });


        calculateSTUMPPremiumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (noOfMembersEditText.getText().toString().trim().equalsIgnoreCase("")) {
                    Toast.makeText(StumpDataEntry.this, "Please Enter No. Of Members", Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ONE_ADULT) &&
                            Integer.parseInt(noOfMembersEditText.getText().toString().trim()) != 1) {
                        Toast.makeText(StumpDataEntry.this, "Please Select Proper Family Type/No Of Family", Toast.LENGTH_SHORT).show();
                    } else if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ONE_ADULT_ANY_CHILD) &&
                            Integer.parseInt(noOfMembersEditText.getText().toString().trim()) < 2) {
                        Toast.makeText(StumpDataEntry.this, "Please Select Proper Family Type/No Of Family", Toast.LENGTH_SHORT).show();
                    } else if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.TWO_ADULT) &&
                            Integer.parseInt(noOfMembersEditText.getText().toString().trim()) != 2) {
                        Toast.makeText(StumpDataEntry.this, "Please Select Proper Family Type/No Of Family", Toast.LENGTH_SHORT).show();
                    } else if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.TWO_ADULT_ANY_CHILD) &&
                            Integer.parseInt(noOfMembersEditText.getText().toString().trim()) < 3) {
                        Toast.makeText(StumpDataEntry.this, "Please Select Proper Family Type/No Of Family", Toast.LENGTH_SHORT).show();
                    }else{
                        if(typeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.FLOATER)){

                        } else if (typeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.INDIVIDUAL)) {

                            premium = CommonFunctions.calculateSTUMPPremiumFloater(typeSpinner.getSelectedItem().toString(),
                                    noOfMembersEditText.getText().toString(),
                                    floaterThresholdSpinner.getSelectedItem().toString(),
                                    floaterSISpinner.getSelectedItem().toString(),
                                    memberDetailsArrayList,
                                    StumpDataEntry.this,
                                    familyTypeSpinner.getSelectedItem().toString(),
                                    dailyCashCoverCheckBox.isChecked());
                        }
                    }

                }
            }
        });
    }
}