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

        TextView typeDisplay = findViewById(R.id.typeDisplay);
        TextView zoneDisplay = findViewById(R.id.zoneDisplay);
        TextView rtoStateDisplay = findViewById(R.id.rtoStateDisplay);
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

        if (intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.TWO_WHEELER) || intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.PRIVATE_CAR)) {
            if (intent.getStringExtra("msg_type").equalsIgnoreCase(CommonFunctions.PRE_OWNED)) {
                typeDisplay.setText(CommonFunctions.ONE_YEAR_OD_OR_TP);
            } else {
                typeDisplay.setText(CommonFunctions.PNE_YEAR_OD_PLUS_ONE_YEAR_TP);
            }
        } else if (intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.GCV) || intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.PCV)) {
            typeDisplay.setText(intent.getStringExtra("msg_type"));
        }

        zoneDisplay.setText(intent.getStringExtra("msg_zone"));

        rtoStateDisplay.setText(intent.getStringExtra("msg_rtoState"));
        checkAndDeleteLayoutAndView(intent.getStringExtra("msg_rtoState"), findViewById(R.id.rtoStateLinearLayout));

        fuelTypeDisplay.setText(intent.getStringExtra("msg_fuelType"));

        if (intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.TWO_WHEELER) || intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.PRIVATE_CAR)) {
            deleteLayoutAndView(findViewById(R.id.gvwLinearLayout));
            deleteLayoutAndView(findViewById(R.id.passengerCapacityLinearLayout));
            ccDisplay.setText(intent.getStringExtra("msg_cc"));
        } else if (intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.GCV)) {
            deleteLayoutAndView(findViewById(R.id.ccLinearLayout));
            deleteLayoutAndView(findViewById(R.id.passengerCapacityLinearLayout));
            gvwDisplay.setText(intent.getStringExtra("msg_gvw"));
        } else if (intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.PCV)) {
            if (intent.getStringExtra("msg_type").equalsIgnoreCase(CommonFunctions.THREE_WHEELER_PCV)) {
                deleteLayoutAndView(findViewById(R.id.gvwLinearLayout));
                deleteLayoutAndView(findViewById(R.id.ccLinearLayout));
                passengerCapacityDisplay.setText(intent.getStringExtra("msg_passenger"));
            }else if(intent.getStringExtra("msg_type").equalsIgnoreCase(CommonFunctions.FOUR_WHEELER_PCV)){
                deleteLayoutAndView(findViewById(R.id.gvwLinearLayout));
                ccDisplay.setText(intent.getStringExtra("msg_cc"));
                passengerCapacityDisplay.setText(intent.getStringExtra("msg_passenger"));
            } else if (intent.getStringExtra("msg_type").equalsIgnoreCase(CommonFunctions.BUS_MAXI_LUXURY_PCV)) {
                deleteLayoutAndView(findViewById(R.id.gvwLinearLayout));
                deleteLayoutAndView(findViewById(R.id.ccLinearLayout));
                passengerCapacityDisplay.setText(intent.getStringExtra("msg_passenger"));
            }
        }

        ageOfTheVehicle.setText(intent.getStringExtra("msg_ageOfTheVehicle").concat(" Yrs"));

        idvDisplay.setText(intent.getStringExtra("msg_idv"));
        checkAndDeleteLayoutAndView(intent.getStringExtra("msg_idv"), findViewById(R.id.idvLinearLayout));

        basicODPremiumDisplay.setText(intent.getStringExtra("msg_basicODPremium").concat(" (").concat(intent.getStringExtra("msg_basicODRate")).concat("%)"));
        checkAndDeleteLayoutAndView(intent.getStringExtra("msg_basicODPremium"), findViewById(R.id.basicODPremiumLinearLayout));

        discountDisplay.setText(intent.getStringExtra("msg_discountAmount").concat(" (").concat(intent.getStringExtra("msg_discountPercentage")).concat("%)"));
        checkAndDeleteLayoutAndView(intent.getStringExtra("msg_discountAmount"), findViewById(R.id.discountLinearLayout));

        ncbDisplay.setText(intent.getStringExtra("msg_ncbAmount").concat(" (").concat(intent.getStringExtra("msg_ncbPercentage")).concat("%)"));
        checkAndDeleteLayoutAndView(intent.getStringExtra("msg_ncbAmount"), findViewById(R.id.ncbLinearLayout));

        if (intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.TWO_WHEELER) || intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.PRIVATE_CAR)) {
            deleteLayoutAndView(findViewById(R.id.imt23LinearLayout));
        } else {
            imt23Display.setText(intent.getStringExtra("msg_imt23Premium"));
            checkAndDeleteLayoutAndView(intent.getStringExtra("msg_imt23Premium"), findViewById(R.id.imt23LinearLayout));
        }

        ndDisplay.setText(intent.getStringExtra("msg_ndCoverPremium").concat(" (").concat(intent.getStringExtra("msg_ndCoverRate")).concat("%)"));
        checkAndDeleteLayoutAndView(intent.getStringExtra("msg_ndCoverPremium"), findViewById(R.id.nilDepLinearLayout));

        consumablesDisplay.setText(intent.getStringExtra("msg_consumables"));
        checkAndDeleteLayoutAndView(intent.getStringExtra("msg_consumables"), findViewById(R.id.consumablesLinearLayout));

        engineProtectionDisplay.setText(intent.getStringExtra("msg_engineProtection"));
        checkAndDeleteLayoutAndView(intent.getStringExtra("msg_engineProtection"), findViewById(R.id.engineProtectionLinearLayout));

        rtiDisplay.setText(intent.getStringExtra("msg_rti"));
        checkAndDeleteLayoutAndView(intent.getStringExtra("msg_rti"), findViewById(R.id.rtiLinearLayout));

        if (intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.TWO_WHEELER) || intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.PRIVATE_CAR)) {
            if (!intent.getStringExtra("msg_lossOfKeyPremium").equalsIgnoreCase("0.00")) {
                lossOfKeyDisplay.setText(intent.getStringExtra("msg_lossOfKeyPremium").
                        concat(" (SI: ").
                        concat(intent.getStringExtra("msg_lossOfkeySI")).
                        concat(")"));
            } else {
                lossOfKeyDisplay.setText(intent.getStringExtra("msg_lossOfKeyPremium"));
            }
            checkAndDeleteLayoutAndView(intent.getStringExtra("msg_lossOfKeyPremium"), findViewById(R.id.lossOfKeyLinearLayout));
        } else if (intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.GCV) || intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.PCV)) {
            deleteLayoutAndView(findViewById(R.id.lossOfKeyLinearLayout));
        }

        rsaPremiumDisplay.setText(intent.getStringExtra("msg_rsaPremium"));
        checkAndDeleteLayoutAndView(intent.getStringExtra("msg_rsaPremium"), findViewById(R.id.rsaLinearLayout));

        if (intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.PRIVATE_CAR)) {

            if (!intent.getStringExtra("msg_personalEffectPremium").equalsIgnoreCase("0.00")) {
                personalEffectPremiumDisplay.setText(intent.getStringExtra("msg_personalEffectPremium").
                        concat("(SI : ").
                        concat(intent.getStringExtra("msg_personalEffectSI")).
                        concat(")"));
            }
            checkAndDeleteLayoutAndView(intent.getStringExtra("msg_personalEffectPremium"), findViewById(R.id.personalEffectLinearLayout));
        } else {
            deleteLayoutAndView(findViewById(R.id.personalEffectLinearLayout));
        }


        if (intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.TWO_WHEELER) || intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.PRIVATE_CAR)) {
            deleteLayoutAndView(findViewById(R.id.geoExtensionODLinearLayout));
        } else {
            geoExtensionODPremiumDisplay.setText(intent.getStringExtra("msg_geoExtensionODPremium"));
            checkAndDeleteLayoutAndView(intent.getStringExtra("msg_geoExtensionODPremium"), findViewById(R.id.geoExtensionODLinearLayout));
        }

        if (intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.TWO_WHEELER) || intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.PRIVATE_CAR)) {
            deleteLayoutAndView(findViewById(R.id.additionalTowingLinearLayout));
        } else {
            additionalTowingPremiumDisplay.setText(intent.getStringExtra("msg_additionalTowingPremium"));
            checkAndDeleteLayoutAndView(intent.getStringExtra("msg_additionalTowingPremium"), findViewById(R.id.additionalTowingLinearLayout));
        }

        if (intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.TWO_WHEELER) || intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.PRIVATE_CAR)) {
            deleteLayoutAndView(findViewById(R.id.lpgCngKitODPremiumLinearLayout));
        } else {
            lpgCngKitODPremiumDisplay.setText(intent.getStringExtra("msg_lpgCngKitODPremium"));
            checkAndDeleteLayoutAndView(intent.getStringExtra("msg_lpgCngKitODPremium"), findViewById(R.id.lpgCngKitODPremiumLinearLayout));
        }

        totalODPremiumDisplay.setText(intent.getStringExtra("msg_totalODPremium"));

        basicTPPremiumDiaplay.setText(intent.getStringExtra("msg_basicTPPremium"));

        if (intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.PCV)) {
            passengerLiabilityPremiumDisplay.setText(intent.getStringExtra("msg_llToPassengerPremium"));
        } else {
            deleteLayoutAndView(findViewById(R.id.passengerLiabilityLinearLayout));
        }

        cpaPremiumDisplay.setText(intent.getStringExtra("msg_cpaPremium"));
        checkAndDeleteLayoutAndView(intent.getStringExtra("msg_cpaPremium"), findViewById(R.id.cpaLinearLayout));

        llToPaidDriverPremiumDisplay.setText(intent.getStringExtra("msg_llToPaidDriverPremium"));
        checkAndDeleteLayoutAndView(intent.getStringExtra("msg_llToPaidDriverPremium"), findViewById(R.id.llToPaidDriverLinearLayout));

        if (intent.getStringExtra("msg_paToPaidDriverPremium").equalsIgnoreCase("0.00")) {
            paToPaidDriverPremiumDisplay.setText(intent.getStringExtra("msg_paToPaidDriverPremium"));
        } else {
            paToPaidDriverPremiumDisplay.setText(intent.getStringExtra("msg_paToPaidDriverPremium").concat(" (SI: ").concat(intent.getStringExtra("msg_paToPaidDriverSI")).concat(")"));
        }
        checkAndDeleteLayoutAndView(intent.getStringExtra("msg_paToPaidDriverPremium"), findViewById(R.id.paToPaidDriverLinearLayout));

        if (intent.getStringExtra("msg_paToPassengerPremium").equalsIgnoreCase("0.00")) {
            paToPassengerPremiumDisplay.setText(intent.getStringExtra("msg_paToPassengerPremium"));
        } else {
            paToPassengerPremiumDisplay.setText(intent.getStringExtra("msg_paToPassengerPremium").concat(" (SI: ").concat(intent.getStringExtra("msg_paToPassengerSI")).concat(")"));
        }
        checkAndDeleteLayoutAndView(intent.getStringExtra("msg_paToPassengerPremium"), findViewById(R.id.paToPassengerLinearLayout));

        if (intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.TWO_WHEELER) || intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.PRIVATE_CAR)) {
            deleteLayoutAndView(findViewById(R.id.geoExtensionTPLinearLayout));
        } else {
            geoExtensionTPPremiumDisplay.setText(intent.getStringExtra("msg_geoExtensionTPPremium"));
            checkAndDeleteLayoutAndView(intent.getStringExtra("msg_geoExtensionTPPremium"), findViewById(R.id.geoExtensionTPLinearLayout));
        }

        if (intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.TWO_WHEELER) || intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.PRIVATE_CAR)) {
            deleteLayoutAndView(findViewById(R.id.lpgCngKitTPPremiumLinearLayout));
        } else {
            lpgCngKitTPPremiumDisplay.setText(intent.getStringExtra("msg_lpgCngKitTPPremium"));
            checkAndDeleteLayoutAndView(intent.getStringExtra("msg_lpgCngKitTPPremium"), findViewById(R.id.lpgCngKitTPPremiumLinearLayout));
        }

        totalTPPremiumDisplay.setText(intent.getStringExtra("msg_totalTPPremium"));

        netPremiumDisplay.setText(intent.getStringExtra("msg_netPremium"));
        if (intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.TWO_WHEELER) || intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.PRIVATE_CAR) || intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.PCV)) {
            gstPremiumDisplay.setText(intent.getStringExtra("msg_gstAmount").concat(" (18%)"));
        } else if (intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.GCV)) {
            gstPremiumDisplay.setText(intent.getStringExtra("msg_gstAmount").concat(" (5% Basic TP, 18% Others)"));
        }
        grossPremiumDisplay.setText(intent.getStringExtra("msg_grossPremium"));

        String commissionStatement = "";

        if (intent.getStringExtra("msg_product").equalsIgnoreCase(CommonFunctions.PRIVATE_CAR)) {
            commissionStatement = "Approx Commission: ".
                    concat(intent.getStringExtra("msg_commission")).
                    concat(intent.getStringExtra("msg_commission_description")).
                    concat("\n").
                    concat("Approx Incentive: ").
                    concat(intent.getStringExtra("msg_incentive")).
                    concat(intent.getStringExtra("msg_incentive_description")).
                    concat("\n").
                    concat("Approx Portal Charges: ").
                    concat(intent.getStringExtra("msg_portalCharges")).
                    concat(intent.getStringExtra("msg_portalCharges_description")).
                    concat("\n").
                    concat("Approx Portal Incentive: ").
                    concat(intent.getStringExtra("msg_portalIncentive")).
                    concat(intent.getStringExtra("msg_portalIncentive_description").
                            concat("\n").
                            concat("Additional OD Incentive: ").
                            concat(intent.getStringExtra("msg_additionalIncentiveOD")).
                            concat(intent.getStringExtra("msg_additionalIncentiveOD_description")).
                            concat("\n").
                            concat("Additional TP Incentive: ").
                            concat(intent.getStringExtra("msg_additionalIncentiveTP")).
                            concat(intent.getStringExtra("msg_additionalIncentiveTP_description")));
        } else {
            commissionStatement = "Approx Commission: ".
                    concat(intent.getStringExtra("msg_commission")).
                    concat(intent.getStringExtra("msg_commission_description")).
                    concat("\n").
                    concat("Approx Incentive: ").
                    concat(intent.getStringExtra("msg_incentive")).
                    concat(intent.getStringExtra("msg_incentive_description")).
                    concat("\n").
                    concat("Approx Portal Charges: ").
                    concat(intent.getStringExtra("msg_portalCharges")).
                    concat(intent.getStringExtra("msg_portalCharges_description")).
                    concat("\n").
                    concat("Approx Portal Incentive: ").
                    concat(intent.getStringExtra("msg_portalIncentive")).
                    concat(intent.getStringExtra("msg_portalIncentive_description"));
        }
        commissionTextView.setText(commissionStatement);

    }

    private void deleteLayoutAndView(LinearLayout linearLayout) {
        ViewGroup parentLayout = (ViewGroup) linearLayout.getParent();
        View nextView = parentLayout.getChildAt(parentLayout.indexOfChild(linearLayout) + 1);
        parentLayout.removeView(linearLayout);
        parentLayout.removeView(nextView);
    }

    private void checkAndDeleteLayoutAndView(String message, LinearLayout linearLayout) {
        if (message.equalsIgnoreCase("0.00")) {
            ViewGroup parentLayout = (ViewGroup) linearLayout.getParent();
            View nextView = parentLayout.getChildAt(parentLayout.indexOfChild(linearLayout) + 1);
            parentLayout.removeView(linearLayout);
            parentLayout.removeView(nextView);
        }
    }
}