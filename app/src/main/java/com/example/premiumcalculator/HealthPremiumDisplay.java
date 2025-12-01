package com.example.premiumcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HealthPremiumDisplay extends AppCompatActivity {

    LayoutInflater inflater;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_health_premium_display);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        container = findViewById(R.id.floaterSIAndNCDLayout);
        inflater = LayoutInflater.from(this);
        LinearLayout myLinearLayout = findViewById(R.id.myLinearLayout);
        Intent intent = getIntent();
        TextView productNameDisplay = findViewById(R.id.productNameDisplay);
        TextView typeDisplay = findViewById(R.id.typeDisplay);
        TextView zoneDisplay = findViewById(R.id.zoneDisplay);
        TextView floaterSIDisplay = findViewById(R.id.floaterSIDisplay);
        TextView floaterNCDDisplay = findViewById(R.id.floaterNCDDisplay);
        ArrayList<HashMap<String, String>> premiumAndCommission = new ArrayList<>();
        TextView totalBasicPremiumDisplay = findViewById(R.id.totalBasicPremiumDisplay);
        TextView ncdDisplay = findViewById(R.id.ncdDisplay);
        TextView floaterDiscountdDisplay = findViewById(R.id.floaterDiscountdDisplay);
        TextView grossPremiumDisplay = findViewById(R.id.grossPremiumDisplay);
        TextView gstDisplay = findViewById(R.id.gstDisplay);
        TextView netPremiumDisplay = findViewById(R.id.netPremiumDisplay);
        TextView dailyCashDisplay = findViewById(R.id.dailyCashDisplay);
        TextView dailyCashAmountDisplay = findViewById(R.id.dailyCashAmountDisplay);
        TextView maternityDisplay = findViewById(R.id.maternityDisplay);
        TextView disclaimerTextView = findViewById(R.id.disclaimerTextView);
        TextView commissionTextView = findViewById(R.id.commissionTextView);
        TextView floaterThresholdDisplay = findViewById(R.id.floaterThresholdDisplay);

        disclaimerTextView.setText(CommonFunctions.DISCLAIMER_TEXT);

        String productName = intent.getStringExtra(CommonFunctions.INTENT_PRODUCT_NAME);
        String type = intent.getStringExtra(CommonFunctions.INTENT_TYPE);
        String zone = intent.getStringExtra(CommonFunctions.INTENT_ZONE);
        String floaterSI = intent.getStringExtra(CommonFunctions.INTENT_FLOATER_SI);
        String floaterNCD = intent.getStringExtra(CommonFunctions.INTENT_FLOATER_NCD);
        String familyDiscount = "0.00";
        String dailyCashPremium = "0.00";
        String dailyCashAmount = "0.00";
        String maternityPremiumAmount = "0.00";
        premiumAndCommission = (ArrayList<HashMap<String, String>>) intent.getSerializableExtra(CommonFunctions.INTENT_PREMIUM_AND_COMMISSION);

        productNameDisplay.setText(productName);
        typeDisplay.setText(type);
        zoneDisplay.setText(zone);

        if (productName.equalsIgnoreCase(CommonFunctions.FAMILY_MEDICARE_POLICY)) {
            CommonFunctions.deleteLayoutAndView(findViewById(R.id.floaterThresholdLinearLayout));
            if (type.equalsIgnoreCase(CommonFunctions.FLOATER)) {
                if (type.equalsIgnoreCase(CommonFunctions.FLOATER)) {
                    floaterSIDisplay.setText(floaterSI);
                    floaterNCDDisplay.setText(floaterNCD.concat(" %"));
                } else if (type.equalsIgnoreCase(CommonFunctions.INDIVIDUAL)) {
                    CommonFunctions.deleteLayoutAndView(findViewById(R.id.floaterSIAndNCDLayout));
                }
                String totalBasicPremium = "0.00";
                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_AGE)) {
                            View dynamicLayout = inflater.inflate(R.layout.health_member_data_entry_display, container, false);
/*
                            CommonFunctions.deleteLayout(dynamicLayout.findViewById(R.id.healthMemberDataForSTUMPIndividualLinearLayout));
*/
                            String variableName = "Member ".concat(Integer.toString(i + 1));
                            TextView memberNoTextView = dynamicLayout.findViewById(R.id.memberNoTextView);
                            TextView memberAgeEditText = dynamicLayout.findViewById(R.id.memberAgeEditText);
                            memberNoTextView.setText(variableName);
                            memberAgeEditText.setText(value.concat(" Yrs"));
                            container.addView(dynamicLayout);
                            if (type.equalsIgnoreCase(CommonFunctions.FLOATER)) {
                                CommonFunctions.deleteLayoutAndView(dynamicLayout.findViewById(R.id.healthMemberDataForIndividualLinearLayout));
                            }
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_BASIC_PREMIUM)) {
                            totalBasicPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NCD_AMOUNT)) {
                            ncdDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_FAMILY_DISCOUNT)) {
                            floaterDiscountdDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GROSS_PREMIUM)) {
                            grossPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_DAILY_CASH_PREMIUM)) {
                            if (value.equalsIgnoreCase("0.00")) {
                                CommonFunctions.deleteLayoutAndView(findViewById(R.id.dailyCashLinearLayout));
                            } else {
                                dailyCashDisplay.setText(value);
                            }
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_DAILY_CASH_AMOUNT)) {
                            if (!value.equalsIgnoreCase("0.00")) {
                                dailyCashAmountDisplay.setText(value.concat(" Per Day"));
                            }
                        } else if (key.equalsIgnoreCase(CommonFunctions.TOTAL_MATERNITY_PREMIUM)) {
                            if (value.equalsIgnoreCase("0.00")) {
                                CommonFunctions.deleteLayoutAndView(findViewById(R.id.maternityLinearLayout));
                            } else {
                                maternityDisplay.setText(value);
                            }
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST)) {
                            gstDisplay.setText(value);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NET_PREMIUM)) {
                            netPremiumDisplay.setText(value);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_COMMISSION)) {
                            commissionTextView.setText(value);
                        }
                    }
                }
            } else if (type.equalsIgnoreCase(CommonFunctions.INDIVIDUAL)) {
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.floaterSIAndNCDInnerLayout));
                int count = 0;
                View dynamicLayout = null;
                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    if (count < premiumAndCommission.size() - 1) {
                        dynamicLayout = inflater.inflate(R.layout.health_member_data_entry_display, container, false);
                        CommonFunctions.deleteLayoutAndView(dynamicLayout.findViewById(R.id.healthMemberDataForSTUMPIndividualLinearLayout));
                        String variableName = "Member ".concat(Integer.toString(i + 1));
                        TextView memberNoTextView = dynamicLayout.findViewById(R.id.memberNoTextView);
                        TextView memberAgeTextView = dynamicLayout.findViewById(R.id.memberAgeEditText);
                        TextView memberSITextView = dynamicLayout.findViewById(R.id.memberSITextView);
                        TextView memberNCDTextView = dynamicLayout.findViewById(R.id.memberNCDTextView);
                        TextView memberCashAllowanceDisplay = dynamicLayout.findViewById(R.id.memberCashAllowanceDisplay);
                        memberNoTextView.setText(variableName);
                        HashMap<String, String> map = premiumAndCommission.get(i);
                        for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                            Map.Entry<String, String> entry = it.next();
                            String key = entry.getKey();
                            String value = entry.getValue();
                            if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_AGE)) {
                                memberAgeTextView.setText(value.concat(" Yrs"));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_SI)) {
                                memberSITextView.setText(value.concat(" /-"));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_NCD_PERCENTAGE)) {
                                memberNCDTextView.setText(value.concat(" %"));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_DAILY_CASH_AMOUNT)) {
                                memberCashAllowanceDisplay.setText(value.concat(" Per Day"));
                            } else if (key.equalsIgnoreCase(CommonFunctions.TOTAL_MATERNITY_PREMIUM)) {
                                if (value.equalsIgnoreCase("0.00")) {
                                    CommonFunctions.deleteLayoutAndView(dynamicLayout.findViewById(R.id.maternityLinearLayout));
                                } else {
                                    maternityDisplay.setText(value);
                                }
                            }
                        }
                        count++;
                        container.addView(dynamicLayout);
                    } else {
                        HashMap<String, String> map = premiumAndCommission.get(i);
                        for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                            Map.Entry<String, String> entry = it.next();
                            String key = entry.getKey();
                            String value = entry.getValue();
                            if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_BASIC_PREMIUM)) {
                                totalBasicPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NCD_AMOUNT)) {
                                ncdDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_FAMILY_DISCOUNT)) {
                                floaterDiscountdDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_DAILY_CASH_PREMIUM)) {
                                dailyCashDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GROSS_PREMIUM)) {
                                grossPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST)) {
                                gstDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NET_PREMIUM)) {
                                netPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_COMMISSION)) {
                                commissionTextView.setText(value);
                            }
                        }
                    }
                }
            }
        } else if (productName.equalsIgnoreCase(CommonFunctions.INDIVIDUAL_HEALTH_POLICY)) {
            CommonFunctions.deleteLayoutAndView(findViewById(R.id.floaterThresholdLinearLayout));
            CommonFunctions.deleteLayoutAndView(findViewById(R.id.floaterSIAndNCDInnerLayout));


            CommonFunctions.deleteLayoutAndView(findViewById(R.id.maternityLinearLayout));

            int count = 0;
            View dynamicLayout = null;
            for (int i = 0; i < premiumAndCommission.size(); i++) {
                if (count < premiumAndCommission.size() - 1) {
                    dynamicLayout = inflater.inflate(R.layout.health_member_data_entry_display, container, false);
/*
                    CommonFunctions.deleteLayoutAndView(dynamicLayout.findViewById(R.id.healthMemberDataForSTUMPIndividualLinearLayout));
*/
                    String variableName = "Member ".concat(Integer.toString(i + 1));
                    TextView memberNoTextView = dynamicLayout.findViewById(R.id.memberNoTextView);
                    TextView memberAgeTextView = dynamicLayout.findViewById(R.id.memberAgeEditText);
                    TextView memberSITextView = dynamicLayout.findViewById(R.id.memberSITextView);
                    TextView memberNCDTextView = dynamicLayout.findViewById(R.id.memberNCDTextView);
                    TextView memberCashAllowanceDisplay = dynamicLayout.findViewById(R.id.memberCashAllowanceDisplay);
                    memberNoTextView.setText(variableName);
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_AGE)) {
                            memberAgeTextView.setText(value.concat(" Yrs"));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_SI)) {
                            memberSITextView.setText(value.concat(" /-"));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_NCD_PERCENTAGE)) {
                            memberNCDTextView.setText(value.concat(" %"));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_DAILY_CASH_AMOUNT)) {
                            if (value.equalsIgnoreCase("0.00")) {
                                CommonFunctions.deleteLayoutAndView(dynamicLayout.findViewById(R.id.memberCashAllowanceLinearLayoutForIHP));
                            } else {
                                memberCashAllowanceDisplay.setText(value.concat(" /- Per Day"));
                            }
                        }
                    }
                    count++;
                    container.addView(dynamicLayout);
                } else {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_BASIC_PREMIUM)) {
                            totalBasicPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NCD_AMOUNT)) {
                            ncdDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_FAMILY_DISCOUNT)) {
                            floaterDiscountdDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_DAILY_CASH_PREMIUM)) {
                            if (CommonFunctions.uptoTwoDecimal(value).equalsIgnoreCase("0.00")) {
                                CommonFunctions.deleteLayoutAndView(findViewById(R.id.dailyCashLinearLayout));
                            } else {
                                dailyCashDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            }
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GROSS_PREMIUM)) {
                            grossPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST)) {
                            gstDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NET_PREMIUM)) {
                            netPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_COMMISSION)) {
                            commissionTextView.setText(value);
                        }
                    }
                }
            }
        } else if (productName.equalsIgnoreCase(CommonFunctions.YUVAAN_HEALTH_POLICY)) {

            CommonFunctions.deleteLayoutAndView(findViewById(R.id.floaterThresholdLinearLayout));
            CommonFunctions.deleteLayoutAndView(findViewById(R.id.maternityLinearLayout));

            if (type.equalsIgnoreCase(CommonFunctions.FLOATER)) {
                if (type.equalsIgnoreCase(CommonFunctions.FLOATER)) {
                    floaterSIDisplay.setText(floaterSI);
                    floaterNCDDisplay.setText(floaterNCD.concat(" %"));
                } else if (type.equalsIgnoreCase(CommonFunctions.INDIVIDUAL)) {
                    CommonFunctions.deleteLayoutAndView(findViewById(R.id.floaterSIAndNCDLayout));
                }
                String totalBasicPremium = "0.00";
                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_AGE)) {
                            View dynamicLayout = inflater.inflate(R.layout.health_member_data_entry_display, container, false);
                            //CommonFunctions.deleteLayoutAndView(dynamicLayout.findViewById(R.id.healthMemberDataForSTUMPIndividualLinearLayout));
                            String variableName = "Member ".concat(Integer.toString(i + 1));
                            TextView memberNoTextView = dynamicLayout.findViewById(R.id.memberNoTextView);
                            TextView memberAgeEditText = dynamicLayout.findViewById(R.id.memberAgeEditText);
                            memberNoTextView.setText(variableName);
                            memberAgeEditText.setText(value.concat(" Yrs"));
                            container.addView(dynamicLayout);
                            if (type.equalsIgnoreCase(CommonFunctions.FLOATER)) {
                                CommonFunctions.deleteLayoutAndView(dynamicLayout.findViewById(R.id.healthMemberDataForIndividualLinearLayout));
                            }
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_BASIC_PREMIUM)) {
                            totalBasicPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NCD_AMOUNT)) {
                            ncdDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_FAMILY_DISCOUNT)) {
                            floaterDiscountdDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GROSS_PREMIUM)) {
                            grossPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_DAILY_CASH_PREMIUM)) {
                            if (value.equalsIgnoreCase("0.00")) {
                                CommonFunctions.deleteLayoutAndView(findViewById(R.id.dailyCashLinearLayout));
                            } else {
                                dailyCashDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            }
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_DAILY_CASH_AMOUNT)) {
                            if (value.equalsIgnoreCase("0.00")) {
                                CommonFunctions.deleteLayoutAndView(findViewById(R.id.dailyCashLinearLayout));
                            } else {
                                dailyCashAmountDisplay.setText(CommonFunctions.uptoTwoDecimal(value).concat(" Per Day"));
                            }
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST)) {
                            gstDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NET_PREMIUM)) {
                            netPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_COMMISSION)) {
                            commissionTextView.setText(value);
                        }
                    }
                }
            } else if (type.equalsIgnoreCase(CommonFunctions.INDIVIDUAL)) {
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.floaterSIAndNCDInnerLayout));
                int count = 0;
                View dynamicLayout = null;
                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    if (count < premiumAndCommission.size() - 1) {
                        dynamicLayout = inflater.inflate(R.layout.health_member_data_entry_display, container, false);
                        CommonFunctions.deleteLayoutAndView(dynamicLayout.findViewById(R.id.healthMemberDataForSTUMPIndividualLinearLayout));
                        String variableName = "Member ".concat(Integer.toString(i + 1));
                        TextView memberNoTextView = dynamicLayout.findViewById(R.id.memberNoTextView);
                        TextView memberAgeTextView = dynamicLayout.findViewById(R.id.memberAgeEditText);
                        TextView memberSITextView = dynamicLayout.findViewById(R.id.memberSITextView);
                        TextView memberNCDTextView = dynamicLayout.findViewById(R.id.memberNCDTextView);
                        TextView memberCashAllowanceDisplay = dynamicLayout.findViewById(R.id.memberCashAllowanceDisplay);
                        memberNoTextView.setText(variableName);
                        HashMap<String, String> map = premiumAndCommission.get(i);
                        for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                            Map.Entry<String, String> entry = it.next();
                            String key = entry.getKey();
                            String value = entry.getValue();
                            if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_AGE)) {
                                memberAgeTextView.setText(value.concat(" Yrs"));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_SI)) {
                                memberSITextView.setText(value.concat(" /-"));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_NCD_PERCENTAGE)) {
                                memberNCDTextView.setText(value.concat(" %"));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_DAILY_CASH_AMOUNT)) {
                                memberCashAllowanceDisplay.setText(value.concat(" Per Day"));
                            }
                        }
                        count++;
                        container.addView(dynamicLayout);
                    } else {
                        HashMap<String, String> map = premiumAndCommission.get(i);
                        for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                            Map.Entry<String, String> entry = it.next();
                            String key = entry.getKey();
                            String value = entry.getValue();
                            if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_BASIC_PREMIUM)) {
                                totalBasicPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NCD_AMOUNT)) {
                                ncdDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_FAMILY_DISCOUNT)) {
                                floaterDiscountdDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_DAILY_CASH_PREMIUM)) {
                                dailyCashDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GROSS_PREMIUM)) {
                                grossPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST)) {
                                gstDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NET_PREMIUM)) {
                                netPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_COMMISSION)) {
                                commissionTextView.setText(value);
                            }
                        }
                    }
                }
            }
        } else if (productName.equalsIgnoreCase(CommonFunctions.STUMP)) {
            CommonFunctions.deleteLayoutAndView(findViewById(R.id.floaterNCDLinearLayout));
            CommonFunctions.deleteLayoutAndView(findViewById(R.id.totalNcdDisplay));
            CommonFunctions.deleteLayoutAndView(findViewById(R.id.maternityLinearLayout));
            if (type.equalsIgnoreCase(CommonFunctions.FLOATER)) {
                floaterThresholdDisplay.setText(CommonFunctions.setCurrencyFormat(intent.getStringExtra(CommonFunctions.INTENT_FLOATER_THRESHOLD)));
                floaterSIDisplay.setText(CommonFunctions.setCurrencyFormat(intent.getStringExtra(CommonFunctions.INTENT_FLOATER_SI)));
            } else if (type.equalsIgnoreCase(CommonFunctions.INDIVIDUAL)) {
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.floaterThresholdLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.floaterSILinearLayout));
            }
            if (type.equalsIgnoreCase(CommonFunctions.FLOATER)) {
                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();

                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_AGE)) {
                            View dynamicLayout = inflater.inflate(R.layout.health_member_data_entry_display, container, false);

                            CommonFunctions.deleteLayout(dynamicLayout.findViewById(R.id.healthMemberDataForIndividualLinearLayout));
                            CommonFunctions.deleteLayout(dynamicLayout.findViewById(R.id.healthMemberDataForSTUMPIndividualLinearLayout));


                            String variableName = "Member ".concat(Integer.toString(i + 1));
                            TextView memberNoTextView = dynamicLayout.findViewById(R.id.memberNoTextView);
                            TextView memberAgeEditText = dynamicLayout.findViewById(R.id.memberAgeEditText);
                            memberNoTextView.setText(variableName);
                            memberAgeEditText.setText(value.concat(" Yrs"));
                            container.addView(dynamicLayout);

                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_BASIC_PREMIUM)) {
                            totalBasicPremiumDisplay.setText(CommonFunctions.setCurrencyFormat(value));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_FAMILY_DISCOUNT)) {
                            if (value.equalsIgnoreCase("0.00")) {
                                CommonFunctions.deleteLayoutAndView(findViewById(R.id.totalFamilyDiscountLinearLayout));
                            } else {
                                floaterDiscountdDisplay.setText(CommonFunctions.setCurrencyFormat(value));
                            }
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GROSS_PREMIUM)) {
                            grossPremiumDisplay.setText(CommonFunctions.setCurrencyFormat(value));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_DAILY_CASH_PREMIUM)) {
                            if (value.equalsIgnoreCase("0.00")) {
                                CommonFunctions.deleteLayoutAndView(findViewById(R.id.dailyCashLinearLayout));
                            } else {
                                dailyCashDisplay.setText(CommonFunctions.setCurrencyFormat(value));
                            }
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_DAILY_CASH_AMOUNT)) {
                            if (value.equalsIgnoreCase("0.00")) {
                                if (findViewById(R.id.dailyCashLinearLayout) != null) {
                                    CommonFunctions.deleteLayoutAndView(findViewById(R.id.dailyCashLinearLayout));
                                }
                            } else {
                                dailyCashAmountDisplay.setText(CommonFunctions.setCurrencyFormat(value).concat(" Per Day"));
                            }
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST)) {
                            gstDisplay.setText(CommonFunctions.setCurrencyFormat(value));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NET_PREMIUM)) {
                            netPremiumDisplay.setText(CommonFunctions.setCurrencyFormat(value));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_COMMISSION)) {
                            commissionTextView.setText(value);
                        }
                    }
                }
            } else if (type.equalsIgnoreCase(CommonFunctions.INDIVIDUAL)) {
                int count = 0;
                View dynamicLayout = null;

                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    if (count < premiumAndCommission.size() - 1) {
                        dynamicLayout = inflater.inflate(R.layout.health_member_data_entry_display, container, false);
                        CommonFunctions.deleteLayout(dynamicLayout.findViewById(R.id.healthMemberDataForIndividualLinearLayout));
                        String variableName = "Member ".concat(Integer.toString(i + 1));
                        TextView memberNoTextView = dynamicLayout.findViewById(R.id.memberNoTextView);
                        TextView memberAgeTextView = dynamicLayout.findViewById(R.id.memberAgeEditText);
                        TextView memberThresholdTextView = dynamicLayout.findViewById(R.id.memberThresholdTextView);
                        TextView memberSITextView = dynamicLayout.findViewById(R.id.memberSITextView);
                        TextView memberDailyCashAllowanceTextView = dynamicLayout.findViewById(R.id.memberCashAllowanceDisplay);
                        memberNoTextView.setText(variableName);
                        HashMap<String, String> map = premiumAndCommission.get(i);
                        for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                            Map.Entry<String, String> entry = it.next();
                            String key = entry.getKey();
                            String value = entry.getValue();
                            if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_AGE)) {
                                memberAgeTextView.setText(value.concat(" Yrs"));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_THRESHOLD)) {
                                memberThresholdTextView.setText(CommonFunctions.setCurrencyFormat(value));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_SI)) {
                                memberSITextView.setText(CommonFunctions.setCurrencyFormat(value));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_DAILY_CASH_AMOUNT)) {
                                if (value.equalsIgnoreCase("0.00")) {
                                    CommonFunctions.deleteLayout(dynamicLayout.findViewById(R.id.memberCashAllowanceLinearLayoutForSTUMP));
                                } else {
                                    memberDailyCashAllowanceTextView.setText(CommonFunctions.setCurrencyFormat(value).concat(" Per Day"));
                                }
                            }
                        }
                        count++;
                        container.addView(dynamicLayout);
                    } else {
                        HashMap<String, String> map = premiumAndCommission.get(i);
                        for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                            Map.Entry<String, String> entry = it.next();
                            String key = entry.getKey();
                            String value = entry.getValue();
                            if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_BASIC_PREMIUM)) {
                                totalBasicPremiumDisplay.setText(CommonFunctions.setCurrencyFormat(value));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_FAMILY_DISCOUNT)) {
                                if(CommonFunctions.uptoTwoDecimal(value).equalsIgnoreCase("0.00")){
                                    CommonFunctions.deleteLayoutAndView(findViewById(R.id.totalFamilyDiscountLinearLayout));
                                }else{
                                    floaterDiscountdDisplay.setText(CommonFunctions.setCurrencyFormat(value));
                                }
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_DAILY_CASH_PREMIUM)) {
                                if(CommonFunctions.uptoTwoDecimal(value).equalsIgnoreCase("0.00")){
                                    CommonFunctions.deleteLayoutAndView(findViewById(R.id.dailyCashLinearLayout));
                                }else{
                                    dailyCashDisplay.setText(CommonFunctions.setCurrencyFormat(value));
                                }
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GROSS_PREMIUM)) {
                                grossPremiumDisplay.setText(CommonFunctions.setCurrencyFormat(value));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST)) {
                                gstDisplay.setText(CommonFunctions.setCurrencyFormat(value));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NET_PREMIUM)) {
                                netPremiumDisplay.setText(CommonFunctions.setCurrencyFormat(value));
                            } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_COMMISSION)) {
                                commissionTextView.setText(value);
                            }
                        }
                    }
                }
            }
        }
    }
}
