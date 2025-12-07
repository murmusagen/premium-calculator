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

public class FamilyMedicareDataEntry extends AppCompatActivity {

    LinearLayout container;
    LayoutInflater inflater;
    LinearLayout floaterSILinearLayout;
    View floateSISingleLineView;
    LinearLayout floateNCDLinearLayout;
    View floateNCDSingleLineView;
    EditText noOfMembersEditText;
    EditText memberAgeEditText;
    ArrayList<HashMap<String, String>> premium = new ArrayList<>();
    CheckBox dailyCashCoverCheckBox;
    CheckBox maternityCheckBox;
    Button findZoneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_family_medicare_data_entry);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        container = findViewById(R.id.container);
        inflater = LayoutInflater.from(this);
        floaterSILinearLayout = findViewById(R.id.floaterSILinearLayout);
        floateSISingleLineView = findViewById(R.id.floateSISingleLineView);
        floateNCDLinearLayout = findViewById(R.id.floateNCDLinearLayout);
        floateNCDSingleLineView = findViewById(R.id.floateNCDSingleLineView);
        noOfMembersEditText = findViewById(R.id.noOfMembersEditText);
        dailyCashCoverCheckBox = findViewById(R.id.dailyCashCoverCheckBox);
        maternityCheckBox = findViewById(R.id.maternityCheckBox);
        findZoneButton = findViewById(R.id.findZoneButton);


        Button calculateFmpPremiumButton = findViewById(R.id.calculateFmpPremiumButton);
        ArrayList<Map<String, View>> memberDetailsArrayList = new ArrayList<>();

        Spinner typeSpinner = findViewById(R.id.typeSpinner);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.HEALTH_TYPE_ARRAY);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);

        ArrayAdapter<String> familyMedicareMemberSIAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.FAMILY_MEDICARE_SI_ARRAY);
        ArrayAdapter<String> memberNCDAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.HEALTH_NCD_ARRAY);

        Spinner familyTypeSpinner = findViewById(R.id.familyTypeSpinner);
        ArrayAdapter<String> familyTypeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.FAMILY_TYPE_ARRAY);
        ArrayAdapter<String> familyTypeAdapterWithOneAdultOption = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, CommonFunctions.FAMILY_TYPE_ARRAY_WITH_ONE_ADULT_SELECTION_ALSO);
        familyTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        familyTypeAdapterWithOneAdultOption.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        Spinner floaterSISpinner = findViewById(R.id.floaterSISpinner);
        familyMedicareMemberSIAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        floaterSISpinner.setAdapter(familyMedicareMemberSIAdapter);
        floaterSISpinner.setSelection(4);

        Spinner floaterNCDSpinner = findViewById(R.id.floaterNCDSpinner);
        memberNCDAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        floaterNCDSpinner.setAdapter(memberNCDAdapter);

        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    floaterSILinearLayout.setVisibility(View.VISIBLE);
                    floateSISingleLineView.setVisibility(View.VISIBLE);
                    floateNCDLinearLayout.setVisibility(View.VISIBLE);
                    floateNCDSingleLineView.setVisibility(View.VISIBLE);
                    if (!noOfMembersEditText.getText().toString().equalsIgnoreCase("")) {
                        noOfMembersEditText.setText("");
                    }
                    familyTypeSpinner.setAdapter(familyTypeAdapter);
                } else if (i == 1) {
                    floaterSILinearLayout.setVisibility(View.GONE);
                    floateSISingleLineView.setVisibility(View.GONE);
                    floateNCDLinearLayout.setVisibility(View.GONE);
                    floateNCDSingleLineView.setVisibility(View.GONE);
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
                        int count = 1;
                        for (int j = 0; j < i; j++) {
                            Map<String, View> map = new HashMap<>();
                            View dynamicLayout = inflater.inflate(R.layout.health_member_data_entry, container, false);
                            CommonFunctions.deleteLayoutAndView(dynamicLayout.findViewById(R.id.healthMemberDataForSTUMPIndividualLinearLayout));

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


                            Spinner familyMedicareMemberSISpinner = dynamicLayout.findViewById(R.id.familyMedicareMemberSISpinner);
                            familyMedicareMemberSIAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            familyMedicareMemberSISpinner.setAdapter(familyMedicareMemberSIAdapter);
                            if (typeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.FLOATER)) {
                                familyMedicareMemberSISpinner.setSelection(0);
                                familyMedicareMemberSISpinner.setEnabled(false);
                            } else {
                                familyMedicareMemberSISpinner.setSelection(4);
                            }

                            Spinner memberNCDSpinner = dynamicLayout.findViewById(R.id.memberNCDSpinner);
                            memberNCDAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            memberNCDSpinner.setAdapter(memberNCDAdapter);
                            if (typeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.FLOATER)) {
                                memberNCDSpinner.setEnabled(false);
                            }

                            if (typeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.FLOATER)) {
                                CommonFunctions.deleteLayoutAndView(dynamicLayout.findViewById(R.id.healthMemberDataForIndividualLinearLayout));
                            }

                            container.addView(dynamicLayout);
                            count = count + 1;

                            map.put(CommonFunctions.INTENT_MEMBER_AGE, memberAge);
                            map.put(CommonFunctions.INTENT_MEMBER_SI, familyMedicareMemberSISpinner);
                            map.put(CommonFunctions.INTENT_MEMBER_NCD_PERCENTAGE, memberNCDSpinner);
                            memberDetailsArrayList.add(map);
                        }
                    }
                } else {
                    container.removeAllViews();
                    memberDetailsArrayList.clear();
                }
            }
        });

        String[] healthZoneArray = {CommonFunctions.ZONE_C, CommonFunctions.ZONE_B, CommonFunctions.ZONE_A};
        Spinner zoneSpinner = findViewById(R.id.zoneSpinner);
        ArrayAdapter<String> zoneAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, healthZoneArray);
        zoneAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zoneSpinner.setAdapter(zoneAdapter);

        findZoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonFunctions.createAlertBuilder(FamilyMedicareDataEntry.this, "Zone Information", CommonFunctions.ALL_ZONE_TEXT, "Ok", "");
            }
        });

        calculateFmpPremiumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (noOfMembersEditText.getText().toString().trim().equalsIgnoreCase("")) {
                    CommonFunctions.createAlertBuilder(FamilyMedicareDataEntry.this, "Alert", "Please Enter No. Of Members", "Ok", "");
                } else {
                    if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ONE_ADULT) &&
                            Integer.parseInt(noOfMembersEditText.getText().toString().trim()) != 1) {
                        CommonFunctions.createAlertBuilder(FamilyMedicareDataEntry.this, "Alert", "Please Select Proper Family Type/No Of Family", "Ok", "");
                    } else if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ONE_ADULT_ANY_CHILD) &&
                            Integer.parseInt(noOfMembersEditText.getText().toString().trim()) < 2) {
                        CommonFunctions.createAlertBuilder(FamilyMedicareDataEntry.this, "Alert", "Please Select Proper Family Type/No Of Family", "Ok", "");
                    } else if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.TWO_ADULT) &&
                            Integer.parseInt(noOfMembersEditText.getText().toString().trim()) != 2) {
                        CommonFunctions.createAlertBuilder(FamilyMedicareDataEntry.this, "Alert", "Please Select Proper Family Type/No Of Family", "Ok", "");
                    } else if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.TWO_ADULT_ANY_CHILD) &&
                            Integer.parseInt(noOfMembersEditText.getText().toString().trim()) < 3) {
                        CommonFunctions.createAlertBuilder(FamilyMedicareDataEntry.this, "Alert", "Please Select Proper Family Type/No Of Family", "Ok", "");
                    } else {
                        if (typeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.FLOATER)) {
                            if (maternityCheckBox.isChecked() && Double.parseDouble(floaterSISpinner.getSelectedItem().toString()) < 350000) {
                                CommonFunctions.createAlertBuilder(FamilyMedicareDataEntry.this, "Alert", "Maternity Cannot Be Opted For SI Less Than 350000", "Ok", "");
                            } else {
                                premium = CommonFunctions.calculateFamilyMedicarePremiumFloater(typeSpinner.getSelectedItem().toString(),
                                        zoneSpinner.getSelectedItem().toString(),
                                        noOfMembersEditText.getText().toString(),
                                        floaterSISpinner.getSelectedItem().toString(),
                                        floaterNCDSpinner.getSelectedItem().toString(),
                                        memberDetailsArrayList, FamilyMedicareDataEntry.this,
                                        familyTypeSpinner.getSelectedItem().toString(),
                                        dailyCashCoverCheckBox.isChecked(),
                                        maternityCheckBox.isChecked());
                                Intent intent = new Intent(FamilyMedicareDataEntry.this, HealthPremiumDisplay.class);
                                intent.putExtra(CommonFunctions.INTENT_PRODUCT_NAME, CommonFunctions.FAMILY_MEDICARE_POLICY);
                                intent.putExtra(CommonFunctions.INTENT_TYPE, typeSpinner.getSelectedItem().toString());
                                intent.putExtra(CommonFunctions.INTENT_ZONE, zoneSpinner.getSelectedItem().toString());
                                intent.putExtra(CommonFunctions.INTENT_FLOATER_SI, floaterSISpinner.getSelectedItem().toString());
                                intent.putExtra(CommonFunctions.INTENT_FLOATER_NCD, floaterNCDSpinner.getSelectedItem().toString());
                                intent.putExtra(CommonFunctions.INTENT_PREMIUM_AND_COMMISSION, premium);
                                startActivity(intent);
                            }
                        } else if (typeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.INDIVIDUAL)) {
                            ArrayList<String> checkForAllMembersSIEntry = new ArrayList<>();
                            int memberSelectedForMaternity = 0;
                            if (maternityCheckBox.isChecked()) {
                                if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ONE_ADULT) || familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ONE_ADULT_ANY_CHILD)) {
                                    memberSelectedForMaternity = 0;
                                } else if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.TWO_ADULT) || familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.TWO_ADULT_ANY_CHILD)) {
                                    memberSelectedForMaternity = 1;
                                }
                            }
                            checkForAllMembersSIEntry = checkForAllMembersSIEntry(memberDetailsArrayList, maternityCheckBox.isChecked(), memberSelectedForMaternity);
                            if (checkForAllMembersSIEntry.size() > 0) {
                                Toast.makeText(FamilyMedicareDataEntry.this, checkForAllMembersSIEntry.get(1), Toast.LENGTH_SHORT).show();
                            } else {
                                premium = CommonFunctions.calculateFamilyMedicarePremiumIndividual(typeSpinner.getSelectedItem().toString(),
                                        zoneSpinner.getSelectedItem().toString(),
                                        noOfMembersEditText.getText().toString(),
                                        floaterSISpinner.getSelectedItem().toString(),
                                        floaterNCDSpinner.getSelectedItem().toString(),
                                        memberDetailsArrayList, FamilyMedicareDataEntry.this,
                                        familyTypeSpinner.getSelectedItem().toString(),
                                        dailyCashCoverCheckBox.isChecked(),
                                        maternityCheckBox.isChecked(),
                                        memberSelectedForMaternity);

                                Intent intent = new Intent(FamilyMedicareDataEntry.this, HealthPremiumDisplay.class);
                                intent.putExtra(CommonFunctions.INTENT_PRODUCT_NAME, CommonFunctions.FAMILY_MEDICARE_POLICY);
                                intent.putExtra(CommonFunctions.INTENT_TYPE, typeSpinner.getSelectedItem().toString());
                                intent.putExtra(CommonFunctions.INTENT_ZONE, zoneSpinner.getSelectedItem().toString());
                                intent.putExtra(CommonFunctions.INTENT_PREMIUM_AND_COMMISSION, premium);
                                startActivity(intent);
                            }
                        }
                    }
                }
            }
        });
    }

    private ArrayList<String> checkForAllMembersSIEntry(ArrayList<Map<String, View>> memberDetailsArrayList, boolean maternityCheckBox, int memberSelectedForMaternity) {
        boolean allOK = true;
        ArrayList<String> output = new ArrayList<>();
        String error = "No";
        String errorMsg = "";
        for (int j = 0; j < memberDetailsArrayList.size(); j++) {
            if (!allOK) {
                break;
            }
            Map<String, View> map = memberDetailsArrayList.get(j);
            for (Iterator<Map.Entry<String, View>> it = map.entrySet().iterator(); it.hasNext(); ) {
                Map.Entry<String, View> entry = it.next();
                String s = entry.getKey();
                View v = entry.getValue();
                String si = "";
                String age = "";
                if (v instanceof Spinner) {
                    si = ((Spinner) v).getSelectedItem().toString();
                    if (s.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_SI)) {
                        if (maternityCheckBox) {
                            if (memberSelectedForMaternity == j) {
                                if (Double.parseDouble(si) < 350000) {
                                    allOK = false;
                                    error = "Yes";
                                    errorMsg = "Maternity Cannot Be Opted For SI < 350000";
                                    output.add(error);
                                    output.add(errorMsg);
                                    break;
                                }
                            }
                        }
                    }
                } else if (v instanceof EditText) {
                    age = ((EditText) v).getText().toString().trim();
                    if (age.equalsIgnoreCase("")) {
                        allOK = false;
                        error = "Yes";
                        errorMsg = "Please Enter Age";
                        output.add(error);
                        output.add(errorMsg);
                        break;
                    }
                }
            }
        }

        return output;
    }
}