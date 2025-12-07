package com.example.premiumcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
import java.util.Iterator;
import java.util.Map;

public class UniCritiCareDataEntry extends AppCompatActivity {
    LinearLayout container;
    LayoutInflater inflater;
    EditText noOfMembersEditText;
    EditText memberAgeEditText;
    ArrayList<HashMap<String, String>> premium = new ArrayList<>();
    Button calculateUniCritiCarePremiumButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_uni_criti_care_data_entry);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        container = findViewById(R.id.container);
        inflater = LayoutInflater.from(this);
        noOfMembersEditText = findViewById(R.id.noOfMembersEditText);
        calculateUniCritiCarePremiumButton = findViewById(R.id.calculateUniCritiCarePremiumButton);

        String[] individualHealthType = {CommonFunctions.INDIVIDUAL};
        Spinner typeSpinner = findViewById(R.id.typeSpinner);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, individualHealthType);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);

        Spinner familyTypeSpinner = findViewById(R.id.familyTypeSpinner);
        ArrayAdapter<String> familyTypeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.FAMILY_TYPE_ARRAY_WITH_ONE_ADULT_SELECTION_ALSO);
        familyTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        familyTypeSpinner.setAdapter(familyTypeAdapter);

        ArrayList<Map<String, View>> memberDetailsArrayList = new ArrayList<>();
        ArrayAdapter<String> individualHealthMemberSIAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.UNI_CRITI_CARE_SI_ARRAY);


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
                    } else {
                        container.removeAllViews();
                        memberDetailsArrayList.clear();
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

                            EditText memberAgeEditText = dynamicLayout.findViewById(R.id.memberAgeEditText);


                            Spinner individualHealthMemberSISpinner = dynamicLayout.findViewById(R.id.familyMedicareMemberSISpinner);
                            individualHealthMemberSIAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            individualHealthMemberSISpinner.setAdapter(individualHealthMemberSIAdapter);
                            CommonFunctions.deleteLayout(dynamicLayout.findViewById(R.id.healthMemberDataEntryNCDLinearLayout));
                            CommonFunctions.deleteLayout(dynamicLayout.findViewById(R.id.healthMemberDataForSTUMPIndividualLinearLayout));

                            container.addView(dynamicLayout);
                            count = count + 1;

                            map.put(CommonFunctions.INTENT_MEMBER_AGE, memberAgeEditText);
                            map.put(CommonFunctions.INTENT_MEMBER_SI, individualHealthMemberSISpinner);
                            memberDetailsArrayList.add(map);
                        }
                    }
                } else {
                    container.removeAllViews();
                    memberDetailsArrayList.clear();
                }
            }
        });

        calculateUniCritiCarePremiumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (noOfMembersEditText.getText().toString().trim().equalsIgnoreCase("")) {
                    Toast.makeText(UniCritiCareDataEntry.this, "Please Enter No. Of Members", Toast.LENGTH_SHORT).show();
                } else {
                    if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ONE_ADULT) &&
                            Integer.parseInt(noOfMembersEditText.getText().toString().trim()) != 1) {
                        Toast.makeText(UniCritiCareDataEntry.this, "Please Select Proper Family Type/No Of Family", Toast.LENGTH_SHORT).show();
                    } else if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ONE_ADULT_ANY_CHILD) &&
                            Integer.parseInt(noOfMembersEditText.getText().toString().trim()) < 2) {
                        Toast.makeText(UniCritiCareDataEntry.this, "Please Select Proper Family Type/No Of Family", Toast.LENGTH_SHORT).show();
                    } else if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.TWO_ADULT) &&
                            Integer.parseInt(noOfMembersEditText.getText().toString().trim()) != 2) {
                        Toast.makeText(UniCritiCareDataEntry.this, "Please Select Proper Family Type/No Of Family", Toast.LENGTH_SHORT).show();
                    } else if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.TWO_ADULT_ANY_CHILD) &&
                            Integer.parseInt(noOfMembersEditText.getText().toString().trim()) < 3) {
                        Toast.makeText(UniCritiCareDataEntry.this, "Please Select Proper Family Type/No Of Family", Toast.LENGTH_SHORT).show();
                    } else {
                        //Check If Age Is 21
                        boolean ageCheck = true;
                        for (int i = 0; i < memberDetailsArrayList.size(); i++) {
                            if (ageCheck) {
                                Map<String, View> map = memberDetailsArrayList.get(i);
                                for (Iterator<Map.Entry<String, View>> it = map.entrySet().iterator(); it.hasNext(); ) {
                                    Map.Entry<String, View> entry = it.next();
                                    String key = entry.getKey();
                                    View v = entry.getValue();
                                    if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_AGE)) {
                                        if (v instanceof EditText) {
                                            String memberAge = ((EditText) v).getText().toString().trim();
                                            if (Integer.parseInt(memberAge) < 21) {
                                                Toast.makeText(UniCritiCareDataEntry.this, "Age Cannot be Less Than 21", Toast.LENGTH_SHORT).show();
                                                ageCheck = false;
                                                break;
                                            }
                                        }
                                    }
                                }
                            } else {
                                break;
                            }

                        }
                        if(ageCheck){
                            premium = CommonFunctions.calculateUniCritiCarePremium(typeSpinner.getSelectedItem().toString(),
                                    "",
                                    noOfMembersEditText.getText().toString(),
                                    memberDetailsArrayList,
                                    UniCritiCareDataEntry.this,
                                    familyTypeSpinner.getSelectedItem().toString(),
                                    false,
                                    false,
                                    "");

                            Intent intent = new Intent(UniCritiCareDataEntry.this, HealthPremiumDisplay.class);
                            intent.putExtra(CommonFunctions.INTENT_PRODUCT_NAME, CommonFunctions.UNI_CRITI_CARE_HEALTH_POLICY);
                            intent.putExtra(CommonFunctions.INTENT_TYPE, typeSpinner.getSelectedItem().toString());
                            intent.putExtra(CommonFunctions.INTENT_PREMIUM_AND_COMMISSION, premium);
                            startActivity(intent);
                        }
                    }
                }
            }
        });
    }
}