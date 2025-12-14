package com.example.premiumcalculator;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IndividualPersonalAccidentDisplay extends AppCompatActivity {

    TextView productNameDisplay;
    TextView riskCategoryDisplay;
    TextView coverTableDisplay;
    TextView totalBasicPremiumDisplay;
    TextView medicalExtensionDisplay;
    TextView grossPremiumDisplay;
    TextView gstDisplay;
    TextView netPremiumDisplay;
    TextView commissionTextView;
    TextView disclaimerTextView;
    TextView sumInsuredDisplay;
    Button shareQuoteButton;
    Button shareBrochureButton;
    View targetLayoutForShare;
    ArrayList<HashMap<String, String>> premiumAndCommission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_individual_personal_accident_display);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        productNameDisplay = findViewById(R.id.productNameDisplay);
        riskCategoryDisplay = findViewById(R.id.riskCategoryDisplay);
        coverTableDisplay = findViewById(R.id.coverTableDisplay);
        sumInsuredDisplay = findViewById(R.id.sumInsuredDisplay);
        totalBasicPremiumDisplay = findViewById(R.id.totalBasicPremiumDisplay);
        medicalExtensionDisplay = findViewById(R.id.medicalExtensionDisplay);
        grossPremiumDisplay = findViewById(R.id.grossPremiumDisplay);
        gstDisplay = findViewById(R.id.gstDisplay);
        netPremiumDisplay = findViewById(R.id.netPremiumDisplay);
        commissionTextView = findViewById(R.id.commissionTextView);
        disclaimerTextView = findViewById(R.id.disclaimerTextView);
        shareQuoteButton = findViewById(R.id.shareQuoteButton);
        shareBrochureButton = findViewById(R.id.shareBrochureButton);
        targetLayoutForShare = findViewById(R.id.targetLayoutForShare);


        Intent intent = getIntent();

        productNameDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_PRODUCT_NAME));
        riskCategoryDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_RISK_GROUP));
        coverTableDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_COVER_TABLE));
        sumInsuredDisplay.setText(CommonFunctions.setCurrencyFormat(intent.getStringExtra(CommonFunctions.INTENT_SUM_INSURED)));
        premiumAndCommission = (ArrayList<HashMap<String, String>>) intent.getSerializableExtra(CommonFunctions.INTENT_PREMIUM_AND_COMMISSION);
        disclaimerTextView.setText(CommonFunctions.DISCLAIMER_TEXT);
        for (int i = 0; i < premiumAndCommission.size(); i++) {
            HashMap<String, String> map = premiumAndCommission.get(i);
            for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                Map.Entry<String, String> entry = it.next();
                String key = entry.getKey();
                String value = entry.getValue();
                if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_BASIC_PREMIUM)) {
                    totalBasicPremiumDisplay.setText(CommonFunctions.setCurrencyFormat(value));
                } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_MEDICAL_EXTENSION_PREMUIM)) {
                    if (CommonFunctions.uptoTwoDecimal(value).equalsIgnoreCase("0.00")) {
                        CommonFunctions.deleteLayoutAndView(findViewById(R.id.medicalExtensionLinearLayout));
                    } else {
                        medicalExtensionDisplay.setText(CommonFunctions.setCurrencyFormat(value));
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

        shareQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap = CommonFunctions.getBitmapFromView(targetLayoutForShare);
                File pdfFile = CommonFunctions.saveBitmapToPdf(IndividualPersonalAccidentDisplay.this, bitmap, intent.getStringExtra(CommonFunctions.INTENT_PRODUCT_NAME));
                if (pdfFile != null) {
                    CommonFunctions.sharePdf(IndividualPersonalAccidentDisplay.this, pdfFile);
                }
            }
        });

        shareBrochureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonFunctions.shareBrochure(IndividualPersonalAccidentDisplay.this, intent.getStringExtra(CommonFunctions.INTENT_PRODUCT_NAME));
            }
        });
    }
}