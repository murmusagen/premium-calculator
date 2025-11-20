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

        if(type.equalsIgnoreCase(CommonFunctions.FLOATER)){
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
                    if (key.equalsIgnoreCase("age")) {
                        View dynamicLayout = inflater.inflate(R.layout.health_member_data_entry_display, container, false);
                        String variableName = "Member ".concat(Integer.toString(i + 1));
                        TextView memberNoTextView = dynamicLayout.findViewById(R.id.memberNoTextView);
                        TextView memberAgeEditText = dynamicLayout.findViewById(R.id.memberAgeEditText);
                        memberNoTextView.setText(variableName);
                        memberAgeEditText.setText(value.concat(" Yrs"));
                        container.addView(dynamicLayout);
                        if(type.equalsIgnoreCase(CommonFunctions.FLOATER)){
                            CommonFunctions.deleteLayoutAndView(dynamicLayout.findViewById(R.id.healthMemberDataForIndividualLinearLayout));
                        }
                    } else if (key.equalsIgnoreCase("basic_premium")) {
                        Double a = Double.parseDouble(value);
                        Double b = Double.parseDouble(totalBasicPremium);
                        Double c = b + a;
                        totalBasicPremium = Double.toString(c);
                    } else if (key.equalsIgnoreCase("floater_discount")) {
                        Double a = Double.parseDouble(value);
                        Double b = Double.parseDouble(familyDiscount);
                        Double c = b + a;
                        familyDiscount = Double.toString(c);
                    } else if (key.equalsIgnoreCase("daily_cash_premium")) {
                        dailyCashPremium = value;
                    } else if (key.equalsIgnoreCase("daily_cash_amount")) {
                        dailyCashAmount = value;
                    } else if (key.equalsIgnoreCase("maternity_premium")) {
                        maternityPremiumAmount = value;
                    }
                }
            }

            String ncdAmount = Double.toString(Double.parseDouble(floaterNCD)/100.00 * Double.parseDouble(totalBasicPremium));
            String grossPremium = Double.toString(Double.parseDouble(totalBasicPremium) -
                    Double.parseDouble(ncdAmount) -
                    Double.parseDouble(familyDiscount));
            String grossPremiumWithAddOns = Double.toString(Double.parseDouble(grossPremium) +
                    Double.parseDouble(dailyCashPremium) +
                    Double.parseDouble(maternityPremiumAmount));
            String gst = Double.toString(CommonFunctions.GST_0 / 100 * Double.parseDouble(grossPremiumWithAddOns));
            String netPremium = Double.toString(Double.parseDouble(grossPremiumWithAddOns) + Double.parseDouble(gst));

            totalBasicPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(totalBasicPremium));
            ncdDisplay.setText(CommonFunctions.uptoTwoDecimal(ncdAmount));
            floaterDiscountdDisplay.setText(CommonFunctions.uptoTwoDecimal(familyDiscount));
            grossPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(grossPremium));
            gstDisplay.setText(CommonFunctions.uptoTwoDecimal(gst));
            netPremiumDisplay.setText(CommonFunctions.uptoTwoDecimal(netPremium));
            if(dailyCashPremium.equalsIgnoreCase("0.00")){
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.dailyCashLinearLayout));
            }else{
                dailyCashDisplay.setText(CommonFunctions.uptoTwoDecimal(dailyCashPremium).concat(" ( ").concat(dailyCashAmount).concat(" Per Day )"));
            }
            if(maternityPremiumAmount.equalsIgnoreCase("0.00")){
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.maternityLinearLayout));
            }else{
                maternityDisplay.setText(maternityPremiumAmount);
            }
        } else if (type.equalsIgnoreCase(CommonFunctions.INDIVIDUAL)) {
            CommonFunctions.deleteLayoutAndView(findViewById(R.id.floaterSIAndNCDInnerLayout));
            int count = 0;
            View dynamicLayout = null;
            for (int i = 0; i < premiumAndCommission.size(); i++) {
                if(count<premiumAndCommission.size()-1) {
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
                        if(key.equalsIgnoreCase("age")){
                            memberAgeTextView.setText(value.concat(" Yrs"));
                        } else if (key.equalsIgnoreCase("member_si")) {
                            memberSITextView.setText(value.concat(" /-"));
                        } else if (key.equalsIgnoreCase("member_ncd")) {
                            memberNCDTextView.setText(value.concat(" %"));
                        } else if (key.equalsIgnoreCase("member_daily_cash_amount")) {
                            if(value.equalsIgnoreCase("0.00")){
                                CommonFunctions.deleteLayoutAndView(dynamicLayout.findViewById(R.id.memberCashAllowanceLinearLayout));
                            }else{
                                memberCashAllowanceDisplay.setText(value.concat(" /- Per Day"));
                            }
                        }
                    }
                    count++;
                    container.addView(dynamicLayout);
                }else{
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ){
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();
                        if(key.equalsIgnoreCase("total_basic_premium")){
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
    }
}