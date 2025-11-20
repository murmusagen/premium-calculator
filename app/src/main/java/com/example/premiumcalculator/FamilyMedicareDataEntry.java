package com.example.premiumcalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FamilyMedicareDataEntry extends AppCompatActivity {

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
        floateNCDLinearLayout = findViewById(R.id.floateNCDLinearLayout);
        noOfMembersEditText = findViewById(R.id.noOfMembersEditText);
        dailyCashCoverCheckBox = findViewById(R.id.dailyCashCoverCheckBox);
        maternityCheckBox = findViewById(R.id.maternityCheckBox);
        findZoneButton = findViewById(R.id.findZoneButton);


        Button calculateFmpPremiumButton = findViewById(R.id.calculateFmpPremiumButton);
        ArrayList<Map<String, View>> memberDetailsArrayList = new ArrayList<Map<String, View>>();

        Spinner typeSpinner = findViewById(R.id.typeSpinner);
        ArrayAdapter<String> typeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.HEALTH_TYPE_ARRAY);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typeAdapter);

        ArrayAdapter<String> familyMedicareMemberSIAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.FAMILY_MEDICARE_SI_ARRAY);
        ArrayAdapter<String> floaterSIAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.FAMILY_MEDICARE_SI_ARRAY);
        ArrayAdapter<String> memberNCDAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.HEALTH_NCD_ARRAY);

        Spinner familyTypeSpinner = findViewById(R.id.familyTypeSpinner);
        ArrayAdapter<String> familyTypeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CommonFunctions.FAMILY_TYPE_ARRAY);
        familyTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        familyTypeSpinner.setAdapter(familyTypeAdapter);

        Spinner floaterSISpinner = findViewById(R.id.floaterSISpinner);
        familyMedicareMemberSIAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        floaterSISpinner.setAdapter(familyMedicareMemberSIAdapter);
        floaterSISpinner.setSelection(5);

        Spinner floaterNCDSpinner = findViewById(R.id.floaterNCDSpinner);
        memberNCDAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        floaterNCDSpinner.setAdapter(memberNCDAdapter);

        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    floaterSILinearLayout.setVisibility(View.VISIBLE);
                    floateNCDLinearLayout.setVisibility(View.VISIBLE);
                    if (!noOfMembersEditText.getText().toString().equalsIgnoreCase("")) {
                        noOfMembersEditText.setText("");
                    }
                } else if (i == 1) {
                    floaterSILinearLayout.setVisibility(View.GONE);
                    floateNCDLinearLayout.setVisibility(View.GONE);
                    if (!noOfMembersEditText.getText().toString().equalsIgnoreCase("")) {
                        noOfMembersEditText.setText("");
                    }
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

                            if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ONE_ADULT_ANY_CHILD)) {
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

                            EditText a = dynamicLayout.findViewById(R.id.memberAgeEditText);


                            Spinner familyMedicareMemberSISpinner = dynamicLayout.findViewById(R.id.familyMedicareMemberSISpinner);
                            familyMedicareMemberSIAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            familyMedicareMemberSISpinner.setAdapter(familyMedicareMemberSIAdapter);
                            if (typeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.FLOATER)) {
                                familyMedicareMemberSISpinner.setSelection(0);
                                familyMedicareMemberSISpinner.setEnabled(false);
                            } else {
                                familyMedicareMemberSISpinner.setSelection(1);
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


                            //String age = dynamicLayout.findViewById(R.id.memberAgeEditText).toString().trim();


                            map.put("member_age", a);
                            map.put("member_si", familyMedicareMemberSISpinner);
                            map.put("member_ncd", memberNCDSpinner);
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
        ArrayAdapter<String> zoneAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, healthZoneArray);
        zoneAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zoneSpinner.setAdapter(zoneAdapter);

        findZoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FamilyMedicareDataEntry.this);
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

        calculateFmpPremiumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<Boolean> errorList = new ArrayList<Boolean>();
                if (noOfMembersEditText.getText().toString().trim().equalsIgnoreCase("")) {
                    Toast.makeText(FamilyMedicareDataEntry.this, "Please Enter No. Of Members", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ONE_ADULT_ANY_CHILD) &&
                            Integer.parseInt(noOfMembersEditText.getText().toString().trim()) < 2) {
                        Toast.makeText(FamilyMedicareDataEntry.this, "Please Select Proper Family Type/No Of Family", Toast.LENGTH_SHORT).show();
                    } else if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.TWO_ADULT) &&
                            Integer.parseInt(noOfMembersEditText.getText().toString().trim()) != 2) {
                        Toast.makeText(FamilyMedicareDataEntry.this, "Please Select Proper Family Type/No Of Family", Toast.LENGTH_SHORT).show();
                    } else if (familyTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.TWO_ADULT_ANY_CHILD) &&
                            Integer.parseInt(noOfMembersEditText.getText().toString().trim()) < 3) {
                        Toast.makeText(FamilyMedicareDataEntry.this, "Please Select Proper Family Type/No Of Family", Toast.LENGTH_SHORT).show();
                    } else {
                        if (typeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.FLOATER)) {
                            if (floaterSISpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.FMP_SI_0)) {
                                Toast.makeText(FamilyMedicareDataEntry.this, "Please Enter Floater SI", Toast.LENGTH_SHORT).show();
                                return;
                            } else {
                                premium = CommonFunctions.calculateFamilyMedicarePremium(typeSpinner.getSelectedItem().toString(),
                                        zoneSpinner.getSelectedItem().toString(),
                                        noOfMembersEditText.getText().toString(),
                                        floaterSISpinner.getSelectedItem().toString(),
                                        floaterNCDSpinner.getSelectedItem().toString(),
                                        memberDetailsArrayList, FamilyMedicareDataEntry.this,
                                        familyTypeSpinner.getSelectedItem().toString(),
                                        dailyCashCoverCheckBox.isChecked(),
                                        maternityCheckBox.isChecked());
                                Intent intent = new Intent(FamilyMedicareDataEntry.this, HealthPremiumDisplay.class);
                                intent.putExtra("product_name", "Family Medicare Policy");
                                intent.putExtra("type", typeSpinner.getSelectedItem().toString());
                                intent.putExtra("zone", zoneSpinner.getSelectedItem().toString());
                                intent.putExtra("floaterSI", floaterSISpinner.getSelectedItem().toString());
                                intent.putExtra("floaterNCD", floaterNCDSpinner.getSelectedItem().toString());
                                intent.putExtra("premiumAndCommission", premium);
                                startActivity(intent);
                            }
                        } else if (typeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.INDIVIDUAL)) {
                            ArrayList<String> checkForAllMembersSIEntry = new ArrayList<>();
                            checkForAllMembersSIEntry = checkForAllMembersSIEntry(memberDetailsArrayList);
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
                                        maternityCheckBox.isChecked());

                                Intent intent = new Intent(FamilyMedicareDataEntry.this, HealthPremiumDisplay.class);
                                intent.putExtra("product_name", "Family Medicare Policy");
                                intent.putExtra("type", typeSpinner.getSelectedItem().toString());
                                intent.putExtra("zone", zoneSpinner.getSelectedItem().toString());
                                intent.putExtra("premiumAndCommission", premium);
                                startActivity(intent);
                            }
                        }
                    }
                }
            }
        });
    }

    private ArrayList<String> checkForAllMembersSIEntry(ArrayList<Map<String, View>> memberDetailsArrayList) {
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
                String t = "";
                String si = "";
                String age = "";
                if (v instanceof Spinner) {
                    HashMap<String, String> map1 = new HashMap<>();
                    si = ((Spinner) v).getSelectedItem().toString();
                    if (s.equalsIgnoreCase("member_si")) {
                        if (si.equalsIgnoreCase(CommonFunctions.FMP_SI_0)) {
                            allOK = false;
                            error = "Yes";
                            errorMsg = "Please Enter Sum Insured";
                            output.add(error);
                            output.add(errorMsg);
                            break;
                        }
                    }
                } else if (v instanceof EditText) {
                    HashMap<String, String> map1 = new HashMap<>();
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