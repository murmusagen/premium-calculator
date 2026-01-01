package com.example.premiumcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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

public class MotorPremuimDisplay extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_motor_premuim_display);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();

        ArrayList<HashMap<String, String>> premiumAndCommission = new ArrayList<>();
        TextView typeDisplay = findViewById(R.id.typeDisplay);
        TextView zoneDisplay = findViewById(R.id.zoneDisplay);
        TextView rtoStateDisplay = findViewById(R.id.rtoStateDisplay);
        TextView manufacturerDisplay = findViewById(R.id.manufacturerDisplay);
        TextView fuelTypeDisplay = findViewById(R.id.fuelTypeDisplay);
        TextView ccDisplay = findViewById(R.id.ccDisplay);
        TextView gvwDisplay = findViewById(R.id.gvwDisplay);
        TextView passengerCapacityDisplay = findViewById(R.id.passengerCapacityDisplay);
        TextView ageOfTheVehicle = findViewById(R.id.vehicleAgeDisplay);
        TextView idvDisplay = findViewById(R.id.idvDisplay);
        TextView basicODPremiumDisplay = findViewById(R.id.basicODPremium);
        TextView discountDisplay = findViewById(R.id.discountDisplay);
        TextView ncbDisplay = findViewById(R.id.ncbDisplay);
        TextView imt23Display = findViewById(R.id.imt23Display);
        TextView ndDisplay = findViewById(R.id.ndDisplay);
        TextView consumablesDisplay = findViewById(R.id.consumablesDisplay);
        TextView engineProtectionDisplay = findViewById(R.id.engineProtectionDisplay);
        TextView rtiDisplay = findViewById(R.id.rtiDisplay);
        TextView lossOfKeyDisplay = findViewById(R.id.lossOfKeyDisplay);
        TextView rsaPremiumDisplay = findViewById(R.id.rsaPremiumDisplay);
        TextView geoExtensionODPremiumDisplay = findViewById(R.id.geoExtensionODPremiumDisplay);
        TextView additionalTowingPremiumDisplay = findViewById(R.id.additionalTowingPremiumDisplay);
        TextView lpgCngKitODPremiumDisplay = findViewById(R.id.lpgCngKitODPremiumDisplay);
        TextView lpgCngKitTPPremiumDisplay = findViewById(R.id.lpgCngKitTPPremiumDisplay);
        TextView totalODPremiumDisplay = findViewById(R.id.totalODPremiumDisplay);
        TextView personalEffectPremiumDisplay = findViewById(R.id.personalEffectPremiumDisplay);
        TextView evProtectPremiumDisplay = findViewById(R.id.evProtectPremiumDisplay);
        TextView tyreAndRimProtectorPremiumDisplay = findViewById(R.id.tyreAndRimProtectorPremiumDisplay);

        TextView basicTPPremiumDiaplay = findViewById(R.id.basicTPPremiumDisplay);
        TextView passengerLiabilityPremiumDisplay = findViewById(R.id.passengerLiabilityPremiumDisplay);
        TextView cpaPremiumDisplay = findViewById(R.id.cpaPremiumDisplay);
        TextView llToPaidDriverPremiumDisplay = findViewById(R.id.llToPaidDriverPremiumDisplay);
        TextView paToPaidDriverPremiumDisplay = findViewById(R.id.paToPaidDriverPremiumDisplay);
        TextView paToPassengerPremiumDisplay = findViewById(R.id.paToPassengerPremiumDisplay);
        TextView geoExtensionTPPremiumDisplay = findViewById(R.id.geoExtensionTPPremiumDisplay);
        TextView totalTPPremiumDisplay = findViewById(R.id.totalTPPremiumDisplay);

        TextView netPremiumDisplay = findViewById(R.id.netPremiumDisplay);
        TextView gstPremiumDisplay = findViewById(R.id.gstPremiumDisplay);
        TextView grossPremiumDisplay = findViewById(R.id.grossPremiumDisplay);

        TextView commissionTextView = findViewById(R.id.commissionTextView);

        TextView disclaimerTextView = findViewById(R.id.disclaimerTextView);
        disclaimerTextView.setText(CommonFunctions.DISCLAIMER_TEXT);
        TextView policyTypeDisplay = findViewById(R.id.policyTypeDisplay);
        TextView transactionTypeDisplay = findViewById(R.id.transactionTypeDisplay);


        //New Code

        premiumAndCommission = (ArrayList<HashMap<String, String>>) intent.getSerializableExtra(CommonFunctions.INTENT_PREMIUM_AND_COMMISSION);

        if (intent.getStringExtra(CommonFunctions.INTENT_PRODUCT_NAME).equalsIgnoreCase(CommonFunctions.TWO_WHEELER)) {

            if (intent.getStringExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE).equalsIgnoreCase(CommonFunctions.MOTOR_PACKAGE)) {

                CommonFunctions.deleteLayoutAndView(findViewById(R.id.gvwLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.passengerCapacityLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.imt23LinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.personalEffectLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.geoExtensionODLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.additionalTowingLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.lpgCngKitODPremiumLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.passengerLiabilityLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.geoExtensionTPLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.lpgCngKitTPPremiumLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.manufacturerDisplayLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.evProtectLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.tyreAndRimProtectorLinearLayout));

                policyTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE));
                typeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_TYPE));
                transactionTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_TRANSACTION_TYPE));
                zoneDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_ZONE));
                rtoStateDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_RTO_STATE));
                ageOfTheVehicle.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_AGE).concat(" Yrs"));
                fuelTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_FUEL_TYPE));
                ccDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_CC));
                idvDisplay.setText(CommonFunctions.setCurrencyFormat(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_IDV)));

                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();

                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, basicODPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_OD_DISCOUNT_AMOUNT)) {
                            CommonFunctions.setDisplayValue(key, value, discountDisplay, findViewById(R.id.discountLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_NCB_AMOUNT)) {
                            CommonFunctions.setDisplayValue(key, value, ncbDisplay, findViewById(R.id.ncbLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_ND_AMOUNT)) {
                            CommonFunctions.setDisplayValue(key, value, ndDisplay, findViewById(R.id.nilDepLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_CONSUMABLES)) {
                            CommonFunctions.setDisplayValue(key, value, consumablesDisplay, findViewById(R.id.consumablesLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_ENGINE_PROTECTION)) {
                            CommonFunctions.setDisplayValue(key, value, engineProtectionDisplay, findViewById(R.id.engineProtectionLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_RTI)) {
                            CommonFunctions.setDisplayValue(key, value, rtiDisplay, findViewById(R.id.rtiLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_LOSS_OF_KEY_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, lossOfKeyDisplay, findViewById(R.id.lossOfKeyLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_RSA)) {
                            CommonFunctions.setDisplayValue(key, value, rsaPremiumDisplay, findViewById(R.id.rsaLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_TOTAL_OD_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, totalODPremiumDisplay, findViewById(R.id.totalODPremiumDisplayLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_BASIC)) {
                            CommonFunctions.setDisplayValue(key, value, basicTPPremiumDiaplay, findViewById(R.id.basicTPPremiumDisplayLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_CPA)) {
                            CommonFunctions.setDisplayValue(key, value, cpaPremiumDisplay, findViewById(R.id.cpaLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_LL_TO_PAID_DRIVER)) {
                            CommonFunctions.setDisplayValue(key, value, llToPaidDriverPremiumDisplay, findViewById(R.id.llToPaidDriverLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_PA_TO_PAID_DRIVER)) {
                            CommonFunctions.setDisplayValue(key, value, paToPaidDriverPremiumDisplay, findViewById(R.id.paToPaidDriverLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_PA_TO_PASSENGER_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, paToPassengerPremiumDisplay, findViewById(R.id.paToPassengerLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_TOTAL_TP_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, totalTPPremiumDisplay, findViewById(R.id.basicTPPremiumDisplayLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GROSS_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, grossPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST)) {
                            CommonFunctions.setDisplayValue(key, value, gstPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NET_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, netPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_PREMIUM_AND_COMMISSION)) {
                            commissionTextView.setText(value);
                        }
                    }
                }

                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();

                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, basicODPremiumDisplay, " ( ", "% )");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_DISCOUNT_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, discountDisplay, " ( ", "% )");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_NCB_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, ncbDisplay, " ( ", "% )");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_ND_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, ndDisplay, " ( ", "% )");
                        } /*else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, gstPremiumDisplay, " ( ", "% )");
                        }*/
                    }
                }

            } else if (intent.getStringExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE).equalsIgnoreCase(CommonFunctions.MOTOR_STANDALONE_OD)) {

                CommonFunctions.deleteLayoutAndView(findViewById(R.id.gvwLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.passengerCapacityLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.imt23LinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.personalEffectLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.geoExtensionODLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.additionalTowingLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.lpgCngKitODPremiumLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.passengerLiabilityLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.geoExtensionTPLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.lpgCngKitTPPremiumLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.tpPremiumLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.manufacturerDisplayLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.evProtectLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.tyreAndRimProtectorLinearLayout));


                policyTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE));
                typeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_TYPE));
                transactionTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_TRANSACTION_TYPE));
                zoneDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_ZONE));
                rtoStateDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_RTO_STATE));
                ageOfTheVehicle.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_AGE).concat(" Yrs"));
                fuelTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_FUEL_TYPE));
                ccDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_CC));
                idvDisplay.setText(CommonFunctions.setCurrencyFormat(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_IDV)));

                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();

                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, basicODPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_OD_DISCOUNT_AMOUNT)) {
                            CommonFunctions.setDisplayValue(key, value, discountDisplay, findViewById(R.id.discountLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_NCB_AMOUNT)) {
                            CommonFunctions.setDisplayValue(key, value, ncbDisplay, findViewById(R.id.ncbLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_ND_AMOUNT)) {
                            CommonFunctions.setDisplayValue(key, value, ndDisplay, findViewById(R.id.nilDepLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_CONSUMABLES)) {
                            CommonFunctions.setDisplayValue(key, value, consumablesDisplay, findViewById(R.id.consumablesLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_ENGINE_PROTECTION)) {
                            CommonFunctions.setDisplayValue(key, value, engineProtectionDisplay, findViewById(R.id.engineProtectionLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_RTI)) {
                            CommonFunctions.setDisplayValue(key, value, rtiDisplay, findViewById(R.id.rtiLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_LOSS_OF_KEY_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, lossOfKeyDisplay, findViewById(R.id.lossOfKeyLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_RSA)) {
                            CommonFunctions.setDisplayValue(key, value, rsaPremiumDisplay, findViewById(R.id.rsaLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_TOTAL_OD_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, totalODPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GROSS_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, grossPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST)) {
                            CommonFunctions.setDisplayValue(key, value, gstPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NET_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, netPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_PREMIUM_AND_COMMISSION)) {
                            commissionTextView.setText(value);
                        }
                    }
                }

                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();

                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, basicODPremiumDisplay, " ( ", "% )");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_DISCOUNT_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, discountDisplay, " ( ", "% )");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_NCB_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, ncbDisplay, " ( ", "% )");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_ND_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, ndDisplay, " ( ", "% )");
                        } /*else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, gstPremiumDisplay, " ( ", "% )");
                        }*/
                    }
                }

            } else if (intent.getStringExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE).equalsIgnoreCase(CommonFunctions.MOTOR_LIABILITY_ONLY)) {

                CommonFunctions.deleteLayoutAndView(findViewById(R.id.odPremiumLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.gvwLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.passengerCapacityLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.idvLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.manufacturerDisplayLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.passengerLiabilityLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.geoExtensionTPLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.lpgCngKitTPPremiumLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.evProtectLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.tyreAndRimProtectorLinearLayout));


                policyTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE));
                typeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_TYPE));
                transactionTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_TRANSACTION_TYPE));
                zoneDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_ZONE));
                rtoStateDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_RTO_STATE));
                ageOfTheVehicle.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_AGE).concat(" Yrs"));
                fuelTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_FUEL_TYPE));
                ccDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_CC));

                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();

                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_BASIC)) {
                            CommonFunctions.setDisplayValue(key, value, basicTPPremiumDiaplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_CPA)) {
                            CommonFunctions.setDisplayValue(key, value, cpaPremiumDisplay, findViewById(R.id.cpaLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_LL_TO_PAID_DRIVER)) {
                            CommonFunctions.setDisplayValue(key, value, llToPaidDriverPremiumDisplay, findViewById(R.id.llToPaidDriverLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_PA_TO_PAID_DRIVER)) {
                            CommonFunctions.setDisplayValue(key, value, paToPaidDriverPremiumDisplay, findViewById(R.id.paToPaidDriverLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_PA_TO_PASSENGER_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, paToPassengerPremiumDisplay, findViewById(R.id.paToPassengerLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_TOTAL_TP_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, totalTPPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GROSS_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, grossPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST)) {
                            CommonFunctions.setDisplayValue(key, value, gstPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NET_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, netPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_PREMIUM_AND_COMMISSION)) {
                            commissionTextView.setText(value);
                        }
                    }
                }
            }
        } else if (intent.getStringExtra(CommonFunctions.INTENT_PRODUCT_NAME).equalsIgnoreCase(CommonFunctions.PRIVATE_CAR)) {

            if (intent.getStringExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE).equalsIgnoreCase(CommonFunctions.MOTOR_PACKAGE)) {

                CommonFunctions.deleteLayoutAndView(findViewById(R.id.gvwLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.passengerCapacityLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.imt23LinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.geoExtensionODLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.additionalTowingLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.passengerLiabilityLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.geoExtensionTPLinearLayout));

                policyTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE));
                typeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_TYPE));
                transactionTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_TRANSACTION_TYPE));
                zoneDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_ZONE));
                rtoStateDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_RTO_STATE));
                manufacturerDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_MANUFACTURER));
                ageOfTheVehicle.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_AGE).concat(" Yrs"));
                fuelTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_FUEL_TYPE));
                ccDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_CC));
                idvDisplay.setText(CommonFunctions.setCurrencyFormat(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_IDV)));

                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();

                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, basicODPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_OD_DISCOUNT_AMOUNT)) {
                            CommonFunctions.setDisplayValue(key, value, discountDisplay, findViewById(R.id.discountLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_NCB_AMOUNT)) {
                            CommonFunctions.setDisplayValue(key, value, ncbDisplay, findViewById(R.id.ncbLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_ND_AMOUNT)) {
                            CommonFunctions.setDisplayValue(key, value, ndDisplay, findViewById(R.id.nilDepLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_CONSUMABLES)) {
                            CommonFunctions.setDisplayValue(key, value, consumablesDisplay, findViewById(R.id.consumablesLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_ENGINE_PROTECTION)) {
                            CommonFunctions.setDisplayValue(key, value, engineProtectionDisplay, findViewById(R.id.engineProtectionLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_RTI)) {
                            CommonFunctions.setDisplayValue(key, value, rtiDisplay, findViewById(R.id.rtiLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_LOSS_OF_KEY_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, lossOfKeyDisplay, findViewById(R.id.lossOfKeyLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_RSA)) {
                            CommonFunctions.setDisplayValue(key, value, rsaPremiumDisplay, findViewById(R.id.rsaLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_PERSONAL_EFFECT_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, personalEffectPremiumDisplay, findViewById(R.id.personalEffectLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_EV_PROTECT_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, evProtectPremiumDisplay, findViewById(R.id.evProtectLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_TYRE_AND_RIM_PROTECTOR_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, tyreAndRimProtectorPremiumDisplay, findViewById(R.id.tyreAndRimProtectorLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_LPG_CNG_KIT)) {
                            CommonFunctions.setDisplayValue(key, value, lpgCngKitODPremiumDisplay, findViewById(R.id.lpgCngKitODPremiumLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_TOTAL_OD_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, totalODPremiumDisplay, findViewById(R.id.totalODPremiumDisplayLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_BASIC)) {
                            CommonFunctions.setDisplayValue(key, value, basicTPPremiumDiaplay, findViewById(R.id.basicTPPremiumDisplayLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_CPA)) {
                            CommonFunctions.setDisplayValue(key, value, cpaPremiumDisplay, findViewById(R.id.cpaLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_LL_TO_PAID_DRIVER)) {
                            CommonFunctions.setDisplayValue(key, value, llToPaidDriverPremiumDisplay, findViewById(R.id.llToPaidDriverLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_PA_TO_PAID_DRIVER)) {
                            CommonFunctions.setDisplayValue(key, value, paToPaidDriverPremiumDisplay, findViewById(R.id.paToPaidDriverLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_PA_TO_PASSENGER_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, paToPassengerPremiumDisplay, findViewById(R.id.paToPassengerLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_TP_LPG_CNG_KIT)) {
                            CommonFunctions.setDisplayValue(key, value, lpgCngKitTPPremiumDisplay, findViewById(R.id.lpgCngKitTPPremiumLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_TOTAL_TP_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, totalTPPremiumDisplay, findViewById(R.id.basicTPPremiumDisplayLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GROSS_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, grossPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST)) {
                            CommonFunctions.setDisplayValue(key, value, gstPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NET_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, netPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_PREMIUM_AND_COMMISSION)) {
                            commissionTextView.setText(value);
                        }
                    }
                }

                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();

                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, basicODPremiumDisplay, " ( ", "% )");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_DISCOUNT_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, discountDisplay, " ( ", "% )");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_NCB_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, ncbDisplay, " ( ", "% )");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_ND_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, ndDisplay, " ( ", "% )");
                        } /*else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, gstPremiumDisplay, " ( ", "% )");
                        }*/ else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_LOSS_OF_KEY_SI)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, lossOfKeyDisplay, " ( SI - ", " /-)");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_PERSONAL_EFFECT_SI)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, personalEffectPremiumDisplay, " ( SI - ", " /-)");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_TYRE_AND_RIM_PROTECTOR_SI)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, tyreAndRimProtectorPremiumDisplay, " ( SI - ", " /-)");
                        }
                    }
                }
            } else if (intent.getStringExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE).equalsIgnoreCase(CommonFunctions.MOTOR_STANDALONE_OD)) {

                CommonFunctions.deleteLayoutAndView(findViewById(R.id.gvwLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.passengerCapacityLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.imt23LinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.geoExtensionODLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.additionalTowingLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.passengerLiabilityLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.geoExtensionTPLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.tpPremiumLinearLayout));

                policyTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE));
                typeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_TYPE));
                transactionTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_TRANSACTION_TYPE));
                zoneDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_ZONE));
                rtoStateDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_RTO_STATE));
                manufacturerDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_MANUFACTURER));
                ageOfTheVehicle.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_AGE).concat(" Yrs"));
                fuelTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_FUEL_TYPE));
                ccDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_CC));
                idvDisplay.setText(CommonFunctions.setCurrencyFormat(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_IDV)));

                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();

                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, basicODPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_OD_DISCOUNT_AMOUNT)) {
                            CommonFunctions.setDisplayValue(key, value, discountDisplay, findViewById(R.id.discountLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_NCB_AMOUNT)) {
                            CommonFunctions.setDisplayValue(key, value, ncbDisplay, findViewById(R.id.ncbLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_ND_AMOUNT)) {
                            CommonFunctions.setDisplayValue(key, value, ndDisplay, findViewById(R.id.nilDepLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_CONSUMABLES)) {
                            CommonFunctions.setDisplayValue(key, value, consumablesDisplay, findViewById(R.id.consumablesLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_ENGINE_PROTECTION)) {
                            CommonFunctions.setDisplayValue(key, value, engineProtectionDisplay, findViewById(R.id.engineProtectionLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_RTI)) {
                            CommonFunctions.setDisplayValue(key, value, rtiDisplay, findViewById(R.id.rtiLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_LOSS_OF_KEY_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, lossOfKeyDisplay, findViewById(R.id.lossOfKeyLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_RSA)) {
                            CommonFunctions.setDisplayValue(key, value, rsaPremiumDisplay, findViewById(R.id.rsaLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_PERSONAL_EFFECT_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, personalEffectPremiumDisplay, findViewById(R.id.personalEffectLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_EV_PROTECT_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, evProtectPremiumDisplay, findViewById(R.id.evProtectLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_TYRE_AND_RIM_PROTECTOR_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, tyreAndRimProtectorPremiumDisplay, findViewById(R.id.tyreAndRimProtectorLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_LPG_CNG_KIT)) {
                            CommonFunctions.setDisplayValue(key, value, lpgCngKitODPremiumDisplay, findViewById(R.id.lpgCngKitODPremiumLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_TOTAL_OD_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, totalODPremiumDisplay, findViewById(R.id.totalODPremiumDisplayLinearLayout));
                        }else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GROSS_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, grossPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST)) {
                            CommonFunctions.setDisplayValue(key, value, gstPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NET_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, netPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_PREMIUM_AND_COMMISSION)) {
                            commissionTextView.setText(value);
                        }
                    }
                }
                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();

                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, basicODPremiumDisplay, " ( ", "% )");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_DISCOUNT_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, discountDisplay, " ( ", "% )");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_NCB_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, ncbDisplay, " ( ", "% )");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_ND_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, ndDisplay, " ( ", "% )");
                        } /*else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, gstPremiumDisplay, " ( ", "% )");
                        }*/ else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_LOSS_OF_KEY_SI)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, lossOfKeyDisplay, " ( SI - ", " /-)");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_PERSONAL_EFFECT_SI)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, personalEffectPremiumDisplay, " ( SI - ", " /-)");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_TYRE_AND_RIM_PROTECTOR_SI)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, tyreAndRimProtectorPremiumDisplay, " ( SI - ", " /-)");
                        }
                    }
                }
            } else if (intent.getStringExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE).equalsIgnoreCase(CommonFunctions.MOTOR_LIABILITY_ONLY)) {

                CommonFunctions.deleteLayoutAndView(findViewById(R.id.odPremiumLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.gvwLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.passengerCapacityLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.imt23LinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.geoExtensionODLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.additionalTowingLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.geoExtensionTPLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.lpgCngKitTPPremiumLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.idvLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.passengerLiabilityLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.tyreAndRimProtectorLinearLayout));

                policyTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE));
                typeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_TYPE));
                transactionTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_TRANSACTION_TYPE));
                zoneDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_ZONE));
                rtoStateDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_RTO_STATE));
                manufacturerDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_MANUFACTURER));
                ageOfTheVehicle.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_AGE).concat(" Yrs"));
                fuelTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_FUEL_TYPE));
                ccDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_CC));

                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();

                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_BASIC)) {
                            CommonFunctions.setDisplayValue(key, value, basicTPPremiumDiaplay, findViewById(R.id.basicTPPremiumDisplayLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_CPA)) {
                            CommonFunctions.setDisplayValue(key, value, cpaPremiumDisplay, findViewById(R.id.cpaLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_LL_TO_PAID_DRIVER)) {
                            CommonFunctions.setDisplayValue(key, value, llToPaidDriverPremiumDisplay, findViewById(R.id.llToPaidDriverLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_PA_TO_PAID_DRIVER)) {
                            CommonFunctions.setDisplayValue(key, value, paToPaidDriverPremiumDisplay, findViewById(R.id.paToPaidDriverLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_PA_TO_PASSENGER_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, paToPassengerPremiumDisplay, findViewById(R.id.paToPassengerLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_TP_LPG_CNG_KIT)) {
                            CommonFunctions.setDisplayValue(key, value, lpgCngKitTPPremiumDisplay, findViewById(R.id.lpgCngKitTPPremiumLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_TOTAL_TP_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, totalTPPremiumDisplay, findViewById(R.id.basicTPPremiumDisplayLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GROSS_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, grossPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST)) {
                            CommonFunctions.setDisplayValue(key, value, gstPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NET_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, netPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_PREMIUM_AND_COMMISSION)) {
                            commissionTextView.setText(value);
                        }
                    }
                }
            }
        } else if (intent.getStringExtra(CommonFunctions.INTENT_PRODUCT_NAME).equalsIgnoreCase(CommonFunctions.GCV)) {
            if (intent.getStringExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE).equalsIgnoreCase(CommonFunctions.MOTOR_PACKAGE)) {

                CommonFunctions.deleteLayoutAndView(findViewById(R.id.ccLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.passengerCapacityLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.manufacturerDisplayLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.rtiLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.engineProtectionLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.personalEffectLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.lossOfKeyLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.passengerLiabilityLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.evProtectLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.tyreAndRimProtectorLinearLayout));


                policyTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE));
                typeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_TYPE));
                transactionTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_TRANSACTION_TYPE));
                zoneDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_ZONE));
                rtoStateDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_RTO_STATE));
                ageOfTheVehicle.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_AGE).concat(" Yrs"));
                fuelTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_FUEL_TYPE));
                gvwDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_GVW));
                idvDisplay.setText(CommonFunctions.setCurrencyFormat(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_IDV)));

                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();

                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, basicODPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_OD_DISCOUNT_AMOUNT)) {
                            CommonFunctions.setDisplayValue(key, value, discountDisplay, findViewById(R.id.discountLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_NCB_AMOUNT)) {
                            CommonFunctions.setDisplayValue(key, value, ncbDisplay, findViewById(R.id.ncbLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_ND_AMOUNT)) {
                            CommonFunctions.setDisplayValue(key, value, ndDisplay, findViewById(R.id.nilDepLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_CONSUMABLES)) {
                            CommonFunctions.setDisplayValue(key, value, consumablesDisplay, findViewById(R.id.consumablesLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_IMT23)) {
                            CommonFunctions.setDisplayValue(key, value, imt23Display, findViewById(R.id.imt23LinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_LPG_CNG_KIT)) {
                            CommonFunctions.setDisplayValue(key, value, lpgCngKitODPremiumDisplay, findViewById(R.id.lpgCngKitODPremiumLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_RSA)) {
                            CommonFunctions.setDisplayValue(key, value, rsaPremiumDisplay, findViewById(R.id.rsaLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_GEOGRAPHICAL_EXTENSION)) {
                            CommonFunctions.setDisplayValue(key, value, geoExtensionODPremiumDisplay, findViewById(R.id.geoExtensionODLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_ADDITIONAL_TOWING)) {
                            CommonFunctions.setDisplayValue(key, value, additionalTowingPremiumDisplay, findViewById(R.id.additionalTowingLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_TOTAL_OD_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, totalODPremiumDisplay, findViewById(R.id.totalODPremiumDisplayLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_BASIC)) {
                            CommonFunctions.setDisplayValue(key, value, basicTPPremiumDiaplay, findViewById(R.id.basicTPPremiumDisplayLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_CPA)) {
                            CommonFunctions.setDisplayValue(key, value, cpaPremiumDisplay, findViewById(R.id.cpaLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_LL_TO_PAID_DRIVER)) {
                            CommonFunctions.setDisplayValue(key, value, llToPaidDriverPremiumDisplay, findViewById(R.id.llToPaidDriverLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_PA_TO_PAID_DRIVER)) {
                            CommonFunctions.setDisplayValue(key, value, paToPaidDriverPremiumDisplay, findViewById(R.id.paToPaidDriverLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_PA_TO_PASSENGER_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, paToPassengerPremiumDisplay, findViewById(R.id.paToPassengerLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_TP_GEOGRAPHICAL_EXTENSION)) {
                            CommonFunctions.setDisplayValue(key, value, geoExtensionTPPremiumDisplay, findViewById(R.id.geoExtensionTPLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_TP_LPG_CNG_KIT)) {
                            CommonFunctions.setDisplayValue(key, value, lpgCngKitTPPremiumDisplay, findViewById(R.id.lpgCngKitTPPremiumLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_TOTAL_TP_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, totalTPPremiumDisplay, findViewById(R.id.basicTPPremiumDisplayLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GROSS_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, grossPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST)) {
                            CommonFunctions.setDisplayValue(key, value, gstPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NET_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, netPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_PREMIUM_AND_COMMISSION)) {
                            commissionTextView.setText(value);
                        }
                    }
                }
                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();

                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, basicODPremiumDisplay, " ( ", "% )");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_DISCOUNT_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, discountDisplay, " ( ", "% )");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_NCB_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, ncbDisplay, " ( ", "% )");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_ND_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, ndDisplay, " ( ", "% )");
                        } /*else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, gstPremiumDisplay, " ( ", "% )");
                        }*/
                    }
                }
            } else if (intent.getStringExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE).equalsIgnoreCase(CommonFunctions.MOTOR_LIABILITY_ONLY)) {

                CommonFunctions.deleteLayoutAndView(findViewById(R.id.ccLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.passengerCapacityLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.manufacturerDisplayLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.rtiLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.engineProtectionLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.personalEffectLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.lossOfKeyLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.passengerLiabilityLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.odPremiumLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.idvLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.evProtectLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.tyreAndRimProtectorLinearLayout));


                policyTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE));
                typeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_TYPE));
                transactionTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_TRANSACTION_TYPE));
                zoneDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_ZONE));
                rtoStateDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_RTO_STATE));
                ageOfTheVehicle.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_AGE).concat(" Yrs"));
                fuelTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_FUEL_TYPE));
                gvwDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_GVW));

                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();

                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_BASIC)) {
                            CommonFunctions.setDisplayValue(key, value, basicTPPremiumDiaplay, findViewById(R.id.basicTPPremiumDisplayLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_CPA)) {
                            CommonFunctions.setDisplayValue(key, value, cpaPremiumDisplay, findViewById(R.id.cpaLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_LL_TO_PAID_DRIVER)) {
                            CommonFunctions.setDisplayValue(key, value, llToPaidDriverPremiumDisplay, findViewById(R.id.llToPaidDriverLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_PA_TO_PAID_DRIVER)) {
                            CommonFunctions.setDisplayValue(key, value, paToPaidDriverPremiumDisplay, findViewById(R.id.paToPaidDriverLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_PA_TO_PASSENGER_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, paToPassengerPremiumDisplay, findViewById(R.id.paToPassengerLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_TP_GEOGRAPHICAL_EXTENSION)) {
                            CommonFunctions.setDisplayValue(key, value, geoExtensionTPPremiumDisplay, findViewById(R.id.geoExtensionTPLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_TP_LPG_CNG_KIT)) {
                            CommonFunctions.setDisplayValue(key, value, lpgCngKitTPPremiumDisplay, findViewById(R.id.lpgCngKitTPPremiumLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_TOTAL_TP_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, totalTPPremiumDisplay, findViewById(R.id.basicTPPremiumDisplayLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GROSS_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, grossPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST)) {
                            CommonFunctions.setDisplayValue(key, value, gstPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NET_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, netPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_PREMIUM_AND_COMMISSION)) {
                            commissionTextView.setText(value);
                        }
                    }
                }

                /*for (int i = 0; i < premiumAndCommission.size(); i++) {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();

                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, gstPremiumDisplay, " ( ", "% )");
                        }
                    }
                }*/
            }
        } else if (intent.getStringExtra(CommonFunctions.INTENT_PRODUCT_NAME).equalsIgnoreCase(CommonFunctions.PCV)) {
            if (intent.getStringExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE).equalsIgnoreCase(CommonFunctions.MOTOR_PACKAGE)) {

                CommonFunctions.deleteLayoutAndView(findViewById(R.id.gvwLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.manufacturerDisplayLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.rtiLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.engineProtectionLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.personalEffectLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.lossOfKeyLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.evProtectLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.tyreAndRimProtectorLinearLayout));

                policyTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE));
                typeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_TYPE));
                transactionTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_TRANSACTION_TYPE));
                zoneDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_ZONE));
                rtoStateDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_RTO_STATE));
                ageOfTheVehicle.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_AGE).concat(" Yrs"));
                fuelTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_FUEL_TYPE));
                if(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_CC).equalsIgnoreCase("")){
                    CommonFunctions.deleteLayoutAndView(findViewById(R.id.ccLinearLayout));
                }else{
                    ccDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_CC));
                }
                passengerCapacityDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_PASSENGER_CAPACITY));
                idvDisplay.setText(CommonFunctions.setCurrencyFormat(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_IDV)));

                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();

                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, basicODPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_OD_DISCOUNT_AMOUNT)) {
                            CommonFunctions.setDisplayValue(key, value, discountDisplay, findViewById(R.id.discountLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_NCB_AMOUNT)) {
                            CommonFunctions.setDisplayValue(key, value, ncbDisplay, findViewById(R.id.ncbLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_ND_AMOUNT)) {
                            CommonFunctions.setDisplayValue(key, value, ndDisplay, findViewById(R.id.nilDepLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_CONSUMABLES)) {
                            CommonFunctions.setDisplayValue(key, value, consumablesDisplay, findViewById(R.id.consumablesLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_IMT23)) {
                            CommonFunctions.setDisplayValue(key, value, imt23Display, findViewById(R.id.imt23LinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_LPG_CNG_KIT)) {
                            CommonFunctions.setDisplayValue(key, value, lpgCngKitODPremiumDisplay, findViewById(R.id.lpgCngKitODPremiumLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_RSA)) {
                            CommonFunctions.setDisplayValue(key, value, rsaPremiumDisplay, findViewById(R.id.rsaLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_GEOGRAPHICAL_EXTENSION)) {
                            CommonFunctions.setDisplayValue(key, value, geoExtensionODPremiumDisplay, findViewById(R.id.geoExtensionODLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_ADDITIONAL_TOWING)) {
                            CommonFunctions.setDisplayValue(key, value, additionalTowingPremiumDisplay, findViewById(R.id.additionalTowingLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_TOTAL_OD_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, totalODPremiumDisplay, findViewById(R.id.totalODPremiumDisplayLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_BASIC)) {
                            CommonFunctions.setDisplayValue(key, value, basicTPPremiumDiaplay, findViewById(R.id.basicTPPremiumDisplayLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_CPA)) {
                            CommonFunctions.setDisplayValue(key, value, cpaPremiumDisplay, findViewById(R.id.cpaLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_LL_TO_PAID_DRIVER)) {
                            CommonFunctions.setDisplayValue(key, value, llToPaidDriverPremiumDisplay, findViewById(R.id.llToPaidDriverLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_PA_TO_PAID_DRIVER)) {
                            CommonFunctions.setDisplayValue(key, value, paToPaidDriverPremiumDisplay, findViewById(R.id.paToPaidDriverLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_PA_TO_PASSENGER_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, paToPassengerPremiumDisplay, findViewById(R.id.paToPassengerLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_TP_GEOGRAPHICAL_EXTENSION)) {
                            CommonFunctions.setDisplayValue(key, value, geoExtensionTPPremiumDisplay, findViewById(R.id.geoExtensionTPLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_TP_LPG_CNG_KIT)) {
                            CommonFunctions.setDisplayValue(key, value, lpgCngKitTPPremiumDisplay, findViewById(R.id.lpgCngKitTPPremiumLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_PASSENGER_LIABILITY_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, passengerLiabilityPremiumDisplay, findViewById(R.id.passengerLiabilityLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_TOTAL_TP_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, totalTPPremiumDisplay, findViewById(R.id.basicTPPremiumDisplayLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GROSS_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, grossPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST)) {
                            CommonFunctions.setDisplayValue(key, value, gstPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NET_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, netPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_PREMIUM_AND_COMMISSION)) {
                            commissionTextView.setText(value);
                        }
                    }
                }
                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();

                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, basicODPremiumDisplay, " ( ", "% )");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_DISCOUNT_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, discountDisplay, " ( ", "% )");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_NCB_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, ncbDisplay, " ( ", "% )");
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_OD_ND_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, ndDisplay, " ( ", "% )");
                        } /*else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, gstPremiumDisplay, " ( ", "% )");
                        }*/
                    }
                }

            } else if (intent.getStringExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE).equalsIgnoreCase(CommonFunctions.MOTOR_LIABILITY_ONLY)) {

                CommonFunctions.deleteLayoutAndView(findViewById(R.id.gvwLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.manufacturerDisplayLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.rtiLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.engineProtectionLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.personalEffectLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.lossOfKeyLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.odPremiumLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.idvLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.evProtectLinearLayout));
                CommonFunctions.deleteLayoutAndView(findViewById(R.id.tyreAndRimProtectorLinearLayout));

                policyTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_POLICY_TYPE));
                typeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_TYPE));
                transactionTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_TRANSACTION_TYPE));
                zoneDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_ZONE));
                rtoStateDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_RTO_STATE));
                ageOfTheVehicle.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_VEHICLE_AGE).concat(" Yrs"));
                fuelTypeDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_FUEL_TYPE));
                if(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_CC).equalsIgnoreCase("")){
                    CommonFunctions.deleteLayoutAndView(findViewById(R.id.ccLinearLayout));
                }else{
                    ccDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_CC));
                }
                passengerCapacityDisplay.setText(intent.getStringExtra(CommonFunctions.INTENT_MOTOR_PASSENGER_CAPACITY).concat(" ( Excluding Driver )"));

                for (int i = 0; i < premiumAndCommission.size(); i++) {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();

                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_BASIC)) {
                            CommonFunctions.setDisplayValue(key, value, basicTPPremiumDiaplay, findViewById(R.id.basicTPPremiumDisplayLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_CPA)) {
                            CommonFunctions.setDisplayValue(key, value, cpaPremiumDisplay, findViewById(R.id.cpaLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_LL_TO_PAID_DRIVER)) {
                            CommonFunctions.setDisplayValue(key, value, llToPaidDriverPremiumDisplay, findViewById(R.id.llToPaidDriverLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_PA_TO_PAID_DRIVER)) {
                            CommonFunctions.setDisplayValue(key, value, paToPaidDriverPremiumDisplay, findViewById(R.id.paToPaidDriverLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_PA_TO_PASSENGER_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, paToPassengerPremiumDisplay, findViewById(R.id.paToPassengerLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_TP_GEOGRAPHICAL_EXTENSION)) {
                            CommonFunctions.setDisplayValue(key, value, geoExtensionTPPremiumDisplay, findViewById(R.id.geoExtensionTPLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_BASIC_TP_LPG_CNG_KIT)) {
                            CommonFunctions.setDisplayValue(key, value, lpgCngKitTPPremiumDisplay, findViewById(R.id.lpgCngKitTPPremiumLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_PASSENGER_LIABILITY_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, passengerLiabilityPremiumDisplay, findViewById(R.id.passengerLiabilityLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TP_TOTAL_TP_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, totalTPPremiumDisplay, findViewById(R.id.basicTPPremiumDisplayLinearLayout));
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GROSS_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, grossPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST)) {
                            CommonFunctions.setDisplayValue(key, value, gstPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_NET_PREMIUM)) {
                            CommonFunctions.setDisplayValue(key, value, netPremiumDisplay, null);
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_PREMIUM_AND_COMMISSION)) {
                            commissionTextView.setText(value);
                        }
                    }
                }

                /*for (int i = 0; i < premiumAndCommission.size(); i++) {
                    HashMap<String, String> map = premiumAndCommission.get(i);
                    for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, String> entry = it.next();
                        String key = entry.getKey();
                        String value = entry.getValue();

                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_TOTAL_GST_RATE)) {
                            CommonFunctions.setDisplayValueAdditional(key, value, gstPremiumDisplay, " ( ", "% )");
                        }
                    }
                }*/
            }
        }
    }
}