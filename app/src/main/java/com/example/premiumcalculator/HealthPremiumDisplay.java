package com.example.premiumcalculator;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

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
        TextView maternityDisplay = findViewById(R.id.maternityDisplay);
        TextView disclaimerTextView = findViewById(R.id.disclaimerTextView);
        TextView commissionTextView = findViewById(R.id.commissionTextView);

        disclaimerTextView.setText(CommonFunctions.DISCLAIMER_TEXT);

        String productName = intent.getStringExtra("product_name");
        String type = intent.getStringExtra("type");
        String zone = intent.getStringExtra("zone");
        String floaterSI = intent.getStringExtra("floaterSI");
        String floaterNCD = intent.getStringExtra("floaterNCD");
        String familyDiscount = "0.00";
        String dailyCashPremium = "0.00";
        String dailyCashAmount = "0.00";
        String maternityPremiumAmount = "0.00";
        premiumAndCommission = (ArrayList<HashMap<String, String>>) intent.getSerializableExtra("premiumAndCommission");

        productNameDisplay.setText(productName);
        typeDisplay.setText(type);
        zoneDisplay.setText(zone);

        if(productName.equalsIgnoreCase(CommonFunctions.FAMILY_MEDICARE_POLICY)){
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
                        if (key.equalsIgnoreCase("member_age")) {
                            View dynamicLayout = inflater.inflate(R.layout.health_member_data_entry_display, container, false);
                            String variableName = "Member ".concat(Integer.toString(i + 1));
                            TextView memberNoTextView = dynamicLayout.findViewById(R.id.memberNoTextView);
                            TextView memberAgeEditText = dynamicLayout.findViewById(R.id.memberAgeEditText);
                            memberNoTextView.setText(variableName);
                            memberAgeEditText.setText(value.concat(" Yrs"));
                            container.addView(dynamicLayout);
                            if (type.equalsIgnoreCase(CommonFunctions.FLOATER)) {
                                CommonFunctions.deleteLayoutAndView(dynamicLayout.findViewById(R.id.healthMemberDataForIndividualLinearLayout));
                            }
                        } else if (key.equalsIgnoreCase("total_basic_premium")) {
                            totalBasicPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase("total_ncd_amount")) {
                            ncdDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase("total_family_discount")) {
                            floaterDiscountdDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase("total_gross_premium")) {
                            grossPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase("daily_cash_premium")) {
                            if (value.equalsIgnoreCase("0.00")) {
                                CommonFunctions.deleteLayoutAndView(findViewById(R.id.dailyCashLinearLayout));
                            } else {
                                dailyCashDisplay.setText(value);
                            }
                        } else if (key.equalsIgnoreCase("maternity_premium")) {
                            if (value.equalsIgnoreCase("0.00")) {
                                CommonFunctions.deleteLayoutAndView(findViewById(R.id.maternityLinearLayout));
                            } else {
                                maternityDisplay.setText(value);
                            }
                        } else if (key.equalsIgnoreCase("gst")) {
                            gstDisplay.setText(value);
                        } else if (key.equalsIgnoreCase("net_premium")) {
                            netPremiumDisplay.setText(value);
                        } else if (key.equalsIgnoreCase("total_commission")) {
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
                            if (key.equalsIgnoreCase("age")) {
                                memberAgeTextView.setText(value.concat(" Yrs"));
                            } else if (key.equalsIgnoreCase("member_si")) {
                                memberSITextView.setText(value.concat(" /-"));
                            } else if (key.equalsIgnoreCase("member_ncd")) {
                                memberNCDTextView.setText(value.concat(" %"));
                            } else if (key.equalsIgnoreCase("member_daily_cash_amount")) {
                                if (value.equalsIgnoreCase("0.00")) {
                                    CommonFunctions.deleteLayoutAndView(dynamicLayout.findViewById(R.id.memberCashAllowanceLinearLayout));
                                } else {
                                    memberCashAllowanceDisplay.setText(value.concat(" /- Per Day"));
                                }
                            } else if (key.equalsIgnoreCase("maternity_premium")) {
                                if(value.equalsIgnoreCase("0.00")){
                                    CommonFunctions.deleteLayoutAndView(dynamicLayout.findViewById(R.id.maternityLinearLayout));
                                }else{
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
                            if (key.equalsIgnoreCase("total_basic_premium")) {
                                totalBasicPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            } else if (key.equalsIgnoreCase("total_ncd_amount")) {
                                ncdDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            } else if (key.equalsIgnoreCase("totalFamilyDiscount")) {
                                floaterDiscountdDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            } else if (key.equalsIgnoreCase("total_daily_cash_premium")) {
                                dailyCashDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            } else if (key.equalsIgnoreCase("gross_premium")) {
                                grossPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            } else if (key.equalsIgnoreCase("gst")) {
                                gstDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            } else if (key.equalsIgnoreCase("net_premium")) {
                                netPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                            }
                        }
                    }
                }
            }
        } else if (productName.equalsIgnoreCase(CommonFunctions.INDIVIDUAL_HEALTH_POLICY)) {
            CommonFunctions.deleteLayoutAndView(findViewById(R.id.floaterSIAndNCDLayout));
            CommonFunctions.deleteLayoutAndView(findViewById(R.id.maternityLinearLayout));

            int count = 0;
            View dynamicLayout = null;
            for (int i = 0; i < premiumAndCommission.size(); i++) {
                if (count < premiumAndCommission.size() - 1) {
                    dynamicLayout = inflater.inflate(R.layout.health_member_data_entry_display, container, false);
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
                        if (key.equalsIgnoreCase("age")) {
                            memberAgeTextView.setText(value.concat(" Yrs"));
                        } else if (key.equalsIgnoreCase("member_si")) {
                            memberSITextView.setText(value.concat(" /-"));
                        } else if (key.equalsIgnoreCase("member_ncd")) {
                            memberNCDTextView.setText(value.concat(" %"));
                        } else if (key.equalsIgnoreCase("member_daily_cash_amount")) {
                            if (value.equalsIgnoreCase("0.00")) {
                                CommonFunctions.deleteLayoutAndView(dynamicLayout.findViewById(R.id.memberCashAllowanceLinearLayout));
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
                        if (key.equalsIgnoreCase("total_basic_premium")) {
                            totalBasicPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase("total_ncd_amount")) {
                            ncdDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase("total_family_discount")) {
                            floaterDiscountdDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase("total_daily_cash_premium")) {
                            dailyCashDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase("total_gross_premium")) {
                            grossPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase("gst")) {
                            gstDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase("net_premium")) {
                            netPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(value));
                        } else if (key.equalsIgnoreCase("total_commission")) {
                            commissionTextView.setText(value);
                        }
                    }
                }
            }
        }
    }
}