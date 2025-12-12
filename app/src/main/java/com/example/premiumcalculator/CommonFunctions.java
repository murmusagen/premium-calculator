package com.example.premiumcalculator;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.core.content.FileProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import android.graphics.pdf.PdfDocument;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;  // ← ADD THIS
import android.graphics.drawable.ColorDrawable;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



public class CommonFunctions {


    public static String ALL_ZONE_TEXT = "Zone - A : All Districts in NCT of Delhi (incl. Shahdara), Faridabad, Palwal, Gurugram, Rohtak, Jhajjar, Ghaziabad, Gautam Buddh Nagar, Bulandshahr, Ahmedabad, Ahmedabad City, Gandhi Nagar, Vadodara, Surat, Mumbai, Mumbai Suburban, Thane, Raigad (MH), Palghar\n\nZone - B : Ahmed Nagar, Amritsar, Anand, Bengaluru, Bhopal, Chennai, Coimbatore, Dakshina Kannada, Ernakulam, Howrah, Hyderabad, Indore, Jaipur, Jalgaon, Jodhpur, Kanpur Nagar, Kheda, Kolhapur, Kolkata, Kottayam, Krishna, Lucknow, Ludhiana, Nagpur, Nashik, North 24 Parganas, Pune, Rajkot, Ranga Reddy, Solapur, Thiruvananthapuram, Tiruvallur, Valsad, Visakhapatnam\n\nZone - C : Rest of India";
    public static String ANDAMAN_AND_NICOBAR_ISLANDS = "Andaman and Nicobar Islands";
    public static String ANDHRA_PRADESH = "Andhra Pradesh";
    public static String ARUNACHAL_PRADESH = "Arunachal Pradesh";
    public static String ASSAM = "Assam";
    public static String BIHAR = "Bihar";
    public static String CHANDIGARH = "Chandigarh";
    public static String DELHI = "Delhi";
    public static String GOA = "Goa";
    public static String GUJARAT = "Gujarat";
    public static String HARYANA = "Haryana";
    public static String HIMACHAL_PRADESH = "Himachal Pradesh";
    public static String JAMMU_AND_KASHMIR = "Jammu and Kashmir";
    public static String JHARKHAND = "Jharkhand";
    public static String KARNATAKA = "Karnataka";
    public static String KERALA = "Kerala";
    public static String MADHYA_PRADESH = "Madhya Pradesh";
    public static String MAHARASHTRA = "Maharashtra";
    public static String MANIPUR = "Manipur";
    public static String MEGHALAYA = "Meghalaya";
    public static String MIZORAM = "Mizoram";
    public static String NAGALAND = "Nagaland";
    public static String ODISHA = "Odisha";
    public static String PUDUCHERRY = "Puducherry";
    public static String PUNJAB = "Punjab";
    public static String RAJASTHAN = "Rajasthan";
    public static String TAMIL_NADU = "Tamil Nadu";
    public static String TELANGANA = "Telangana";
    public static String TRIPURA = "Tripura";
    public static String UTTAR_PRADESH = "Uttar Pradesh";
    public static String UTTARAKHAND = "Uttarakhand";
    public static String WEST_BENGAL = "West Bengal";
    public static String APP_VERSION = "VERSION 1.1";
    public static String STUMP = "Super Top-Up";
    public static String INTENT_MEMBER_THRESHOLD = "member_threshold";
    public static String INTENT_MEMBER_NET_PREMIUM = "member_net_premium";
    public static String INTENT_MEMBER_COMMISSION = "member_commission";
    public static String YUVAAN_HEALTH_POLICY = "Yuvaan Health Policy";
    public static String INTENT_FLOATER_SI = "floater_si";
    public static String INTENT_FLOATER_THRESHOLD = "floater_threshold";
    public static String INTENT_FLOATER_NCD = "floater_ncd";
    public static String INTENT_TOTAL_MATERNITY_PREMIUM = "total_maternity_premium";
    public static String INTENT_MEMBER_DAILY_CASH_AMOUNT = "member_daily_cash_amount";
    public static String INTENT_MEMBER_DAILY_CASH_PREMIUM = "member_daily_cash_premium";
    public static String INTENT_TOTAL_DAILY_CASH_AMOUNT = "daily_cash_amount";
    public static String INTENT_TOTAL_BASIC_PREMIUM = "total_basic_premium";
    public static String INTENT_TOTAL_NCD_AMOUNT = "total_ncd_amount";
    public static String INTENT_TOTAL_FAMILY_DISCOUNT = "total_family_discount";
    public static String INTENT_TOTAL_GROSS_PREMIUM = "total_gross_premium";
    public static String INTENT_TOTAL_DAILY_CASH_PREMIUM = "total_daily_cash_premium";
    public static String INTENT_TOTAL_GST = "total_gst";
    public static String INTENT_TOTAL_NET_PREMIUM = "total_net_premium";
    public static String INTENT_TOTAL_COMMISSION = "total_commission";
    public static String INTENT_MEMBER_GROSS_PREMIUM = "member_gross_premium";
    public static String INTENT_MEMBER_FAMILY_DISCOUNT = "member_family_discount";
    public static String INTENT_MEMBER_NCD_AMOUNT = "member_ncd_amount";
    public static String INTENT_MEMBER_NCD_PERCENTAGE = "member_ncd_percentage";
    public static String INTENT_MEMBER_BASIC_PREMIUM = "member_basic_premium";
    public static String INTENT_PREMIUM_AND_COMMISSION = "premium_and_commission";
    public static String INTENT_ZONE = "zone";
    public static String INTENT_TYPE = "type";
    public static String INTENT_PRODUCT_NAME = "product_name";
    public static String INTENT_MEMBER_AGE = "member_age";
    public static String INTENT_MEMBER_SI = "member_si";
    public static String FAMILY_MEDICARE_POLICY = "Family Medicare Policy";
    public static String SPECTRA_HEALTH_POLICY = "Spectra Health Policy";
    public static String INDIVIDUAL_HEALTH_POLICY = "Individual Health Policy";
    public static String DAILY_CASH_ALLOWANCE_500 = "500.00";
    public static String DAILY_CASH_ALLOWANCE_1000 = "1000.00";
    public static String DAILY_CASH_ALLOWANCE_2000 = "2000.00";
    public static String[] DAILY_CASH_ALLOWANCE_ARRAY = {DAILY_CASH_ALLOWANCE_500, DAILY_CASH_ALLOWANCE_1000, DAILY_CASH_ALLOWANCE_2000};
    public static String DISCLAIMER_TEXT = "The premium calculation provided by this app is for informational purposes only and does not constitute a binding quote or offer of insurance. Insurance premiums are subject to approval by the insurer and may vary due to underwriting criteria, changes in policy terms, state regulations, and other factors beyond the app's control. We recommend consulting with an authorized insurance agent or company to obtain an official premium quote before making any decisions.";
    public static String FLOATER = "Floater";
    public static String INDIVIDUAL = "Individual";
    public static String TWO_WHEELER = "two_wheeler";
    public static String PRIVATE_CAR = "private_car";
    public static String GCV = "gcv";
    public static String PCV = "pcv";
    public static String PRE_OWNED = "Pre-Owned";
    public static String YES = "Yes";
    public static String NO = "No";
    public static String NEW = "New";
    public static String ZONE_A = "Zone A";
    public static String ZONE_B = "Zone B";
    public static String ZONE_C = "Zone C";
    public static String PETROL = "Petrol";
    public static String ELECTRIC = "Electric";
    public static String DIESEL = "Diesel";
    public static String CNG_LPG = "CNG/LPG";
    public static String HYBRID = "Hybrid";
    public static String HYBRID_DISCOUNT = "7.5";
    public static String E_RIKSHAW = "E-Rikshaw";
    public static String UPTO_75 = "Upto 75";
    public static String BETWEEN_76_150 = "76 to 150";
    public static String BETWEEN_151_350 = "151 to 350";
    public static String UPTO_1000 = "Upto 1000";
    public static String BETWEEN_1001_1500 = "1001 to 1500";
    public static String BETWEEN_1501_2500 = "1501 to 2500";
    public static String ABOVE_2500 = "Above 2500";
    public static String ABOVE_1500 = "Above 1500";
    public static String UPTO_30KW = "<=30kW";
    public static String BETWEEN_30KW_65KW = ">30kW <=65kW";
    public static String ABOVE_65KW = ">65kW";
    public static String ABOVE_350 = "Above 350";
    public static String UPTO_3KW = "<=3Kw";
    public static String ONE_YEAR = "1 Year";
    public static String FIVE_YEAR = "5 Year";
    public static String BETWEEN_3KW_7KW = ">3kW <=7kW";
    public static String BETWEEN_7KW_16KW = ">7kW <=16kW";
    public static String ABOVE_16KW = ">16kW";
    public static String NCB_0 = "0";
    public static String NCB_20 = "20";
    public static String NCB_25 = "25";
    public static String NCB_35 = "35";
    public static String NCB_45 = "45";
    public static String NCB_50 = "50";
    public static String OTHER_THAN_THREE_WHEELER = "Other Than 3 Wheeler";
    public static String THREE_WHEELER = "3 Wheeler";
    public static String THREE_WHEELER_PCV = "3 Wheeler PCV";
    public static String FOUR_WHEELER_PCV = "Taxi/Cab";
    public static String BUS_MAXI_LUXURY_PCV = "Bus/Maxi/Luxury Cab";
    public static String SI_10000 = "10000";
    public static String SI_20000 = "20000";
    public static String SI_30000 = "30000";
    public static String SI_40000 = "40000";
    public static String SI_50000 = "50000";
    public static String SI_60000 = "60000";
    public static String SI_70000 = "70000";
    public static String SI_80000 = "80000";
    public static String SI_90000 = "90000";
    public static String SI_100000 = "100000";
    public static String SI_110000 = "110000";
    public static String SI_120000 = "120000";
    public static String SI_130000 = "130000";
    public static String SI_140000 = "140000";
    public static String SI_150000 = "150000";
    public static String SI_160000 = "160000";
    public static String SI_170000 = "170000";
    public static String SI_180000 = "180000";
    public static String SI_190000 = "190000";
    public static String SI_200000 = "200000";
    public static String GEO_EXTENSION_OD_PREMIUM = "400";
    public static String GEO_EXTENSION_TP_PREMIUM = "50";
    public static String CNG_LPG_KIT_TP_PREMIUM = "60";
    public static String ONE_YEAR_OD_OR_TP = "1 Year OD/TP";
    public static String PNE_YEAR_OD_PLUS_ONE_YEAR_TP = "1 Year OD + 3 Year TP";
    public static String[] PA_TP_PAID_DRIVE_PASSENGER_SI_ARRAY = {"NA", SI_10000, SI_20000, SI_30000, SI_40000, SI_50000, SI_60000, SI_70000, SI_80000, SI_90000, SI_100000, SI_110000, SI_120000, SI_130000, SI_140000, SI_150000, SI_160000, SI_170000, SI_180000, SI_190000, SI_200000};
    public static String[] TYPE_ARRAY = {PRE_OWNED, NEW};
    public static String[] HEALTH_TYPE_ARRAY = {FLOATER, INDIVIDUAL};
    public static String[] IS_SAOD_ARRAY = {NO, YES};
    public static String[] ZONE_TW_PVT_ARRAY = {ZONE_B, ZONE_A};
    public static String[] TW_FUEL_TYPE = {PETROL, ELECTRIC};
    public static String[] PVT_FUEL_TYPE = {PETROL, DIESEL, ELECTRIC};
    public static String[] CPA_ARRAY = {"No", ONE_YEAR, FIVE_YEAR};
    public static String[] TW_CC_PETROL_ARRAY = {UPTO_75, BETWEEN_76_150, BETWEEN_151_350, ABOVE_350};
    //public static String[] PVT_CC_PETROL_ARRAY = {UPTO_1000, BETWEEN_1001_1500, ABOVE_1500};
    //02/11/2025
    public static String[] PVT_CC_PETROL_ARRAY = {UPTO_1000, BETWEEN_1001_1500, BETWEEN_1501_2500, ABOVE_2500};
    public static String[] PVT_CC_ELECTRIC_ARRAY = {UPTO_30KW, BETWEEN_30KW_65KW, ABOVE_65KW};
    public static String[] TW_CC_ELECTRIC_ARRAY = {UPTO_3KW, BETWEEN_3KW_7KW, BETWEEN_7KW_16KW, ABOVE_16KW};
    public static String[] NCB_ARRAY = {NCB_0, NCB_20, NCB_25, NCB_35, NCB_45, NCB_50};
    public static String LOSS_OF_KEY_SI_10000 = "10000";
    public static String LOSS_OF_KEY_SI_25000 = "25000";
    public static String PERSONAL_EFFECT_SI_5000 = "5000";
    public static String PERSONAL_EFFECT_SI_10000 = "10000";
    public static String[] LOSS_OF_KEY_SI_ARRAY = {"NA", LOSS_OF_KEY_SI_10000, LOSS_OF_KEY_SI_25000};
    public static String[] PERSONAL_EFFECT_SI_ARRAY = {"NA", PERSONAL_EFFECT_SI_5000, PERSONAL_EFFECT_SI_10000};
    public static double GST_18 = 18.00;
    public static double GST_12 = 12.00;
    public static double GST_5 = 5.00;
    public static double GST_0 = 0.00;
    public static String DISCOUNT_LIMIT_DIALOG_BOX_TITLE = "Discount Limit:";
    public static String LESS_THAN_6_PASSENGER = "Less Than 6 Passenger";
    public static String MORE_THAN_6_PASSENGER = "More Than 6 Passenger";
    public static String OTHERS = "Others";
    public static String INSTITUTION_BUS = "Institution Bus";
    public static String TATA = "Tata";
    public static String MARUTI = "Maruti";
    public static String MAHINDRA = "Mahindra";
    public static String TOYOTA = "Toyota";
    public static String HYUNDAI = "Hyundai";
    public static String HONDA = "Honda";
    public static String KIA = "Kia";
    public static String SI_0 = "0";
    public static String SI_250000 = "250000";
    public static String SI_300000 = "300000";
    public static String SI_350000 = "350000";
    public static String SI_400000 = "400000";
    public static String SI_450000 = "450000";
    public static String SI_500000 = "500000";
    public static String SI_600000 = "600000";
    public static String SI_700000 = "700000";
    public static String SI_800000 = "800000";
    public static String SI_900000 = "900000";
    public static String SI_1000000 = "1000000";
    public static String SI_1500000 = "1500000";
    public static String SI_2000000 = "2000000";
    public static String SI_2500000 = "2500000";
    public static String SI_4500000 = "4500000";
    public static String SI_7000000 = "7000000";
    public static String SI_9500000 = "9500000";
    public static String SI_75000 = "75000";
    public static String SI_125000 = "125000";
    public static String SI_175000 = "175000";
    public static String SI_225000 = "225000";
    public static String SI_275000 = "275000";
    public static String SI_325000 = "325000";
    public static String SI_375000 = "375000";
    public static String SI_425000 = "425000";
    public static String SI_475000 = "475000";
    public static String SI_525000 = "525000";
    public static String SI_550000 = "550000";
    public static String SI_575000 = "575000";
    public static String SI_625000 = "625000";
    public static String SI_650000 = "650000";
    public static String SI_675000 = "675000";
    public static String SI_725000 = "725000";
    public static String SI_750000 = "750000";
    public static String SI_775000 = "775000";
    public static String SI_825000 = "825000";
    public static String SI_850000 = "850000";
    public static String SI_875000 = "875000";
    public static String SI_925000 = "925000";
    public static String SI_950000 = "950000";
    public static String SI_975000 = "975000";
    public static String SI_4000000 = "4000000";
    public static String SI_6500000 = "6500000";
    public static String SI_9000000 = "9000000";
    public static String SI_3500000 = "3500000";
    public static String SI_6000000 = "6000000";
    public static String SI_8500000 = "8500000";
    public static String SI_3000000 = "3000000";
    public static String SI_5500000 = "5500000";
    public static String SI_8000000 = "8000000";
    public static String SI_5000000 = "5000000";
    public static String SI_7500000 = "7500000";

    public static String[] IHP_SI_ARRAY = {SI_50000, SI_75000, SI_100000, SI_125000, SI_150000, SI_175000, SI_200000, SI_225000, SI_250000, SI_275000, SI_300000, SI_325000, SI_350000, SI_375000, SI_400000, SI_425000, SI_450000, SI_475000, SI_500000, SI_525000, SI_550000, SI_575000, SI_600000, SI_625000, SI_650000, SI_675000, SI_700000, SI_725000, SI_750000, SI_775000, SI_800000, SI_825000, SI_850000, SI_875000, SI_900000, SI_925000, SI_950000, SI_975000, SI_1000000, SI_1500000, SI_2000000};
    public static String[] YUVAAN_SI_ARRAY = {SI_500000, SI_1000000, SI_1500000, SI_2000000};

    public static String ONE_ADULT = "1A";
    public static String ONE_ADULT_ANY_CHILD = "1A + Any Child";
    public static String TWO_ADULT = "2A";
    public static String TWO_ADULT_ANY_CHILD = "2A + Any Child";
    public static String HEALTH_NCD_0 = "0";
    public static String HEALTH_NCD_2_5 = "2.5";
    public static String HEALTH_NCD_5 = "5";
    public static String HEALTH_NCD_10 = "10";
    public static String HEALTH_NCD_15 = "15";
    public static String HEALTH_NCD_20 = "20";
    public static String HEALTH_NCD_25 = "25";
    public static String HEALTH_NCD_27_5 = "27.5";
    public static String HEALTH_NCD_30 = "30";
    public static String HEALTH_NCD_32_5 = "32.5";
    public static String HEALTH_NCD_35 = "35";
    public static String HEALTH_NCD_37_5 = "37.5";
    public static String HEALTH_NCD_40 = "40";
    public static String HEALTH_NCD_42_5 = "42.5";
    public static String HEALTH_NCD_45 = "45";
    public static String HEALTH_NCD_47_5 = "47.5";
    public static String HEALTH_NCD_50 = "50";
    public static String[] YUVAAN_NCD_ARRAY = {HEALTH_NCD_0, HEALTH_NCD_10, HEALTH_NCD_20};
    public static String[] ALL_STATES_ARRAY = {ANDAMAN_AND_NICOBAR_ISLANDS, ANDHRA_PRADESH, ARUNACHAL_PRADESH, ASSAM, BIHAR, CHANDIGARH, DELHI, GOA, GUJARAT, HARYANA, HIMACHAL_PRADESH, JAMMU_AND_KASHMIR, JHARKHAND, KARNATAKA, KERALA, MADHYA_PRADESH, MAHARASHTRA, MANIPUR, MEGHALAYA, MIZORAM, NAGALAND, ODISHA, PUDUCHERRY, PUNJAB, RAJASTHAN, TAMIL_NADU, TELANGANA, TRIPURA, UTTAR_PRADESH, UTTARAKHAND, WEST_BENGAL};

    public static String[] PVT_CAR_MANUFACTURER_ARRAY = {TATA, MARUTI, MAHINDRA, TOYOTA, HYUNDAI, HONDA, KIA, OTHERS};

    public static String[] SPECTRA_SI_ARRAY = {
            SI_200000,
            SI_300000,
            SI_400000,
            SI_500000,
            SI_600000,
            SI_700000,
            SI_800000,
            SI_900000,
            SI_1000000,
            SI_1500000,
            SI_2000000,
            SI_2500000
    };
    public static String[] SPECTRA_NCD_ARRAY = {
            HEALTH_NCD_0,
            HEALTH_NCD_2_5,
            HEALTH_NCD_5
    };
    public static String[] FAMILY_MEDICARE_SI_ARRAY = {SI_100000, SI_150000, SI_200000, SI_250000, SI_300000, SI_350000, SI_400000, SI_450000, SI_500000, SI_600000, SI_700000, SI_800000, SI_900000, SI_1000000, SI_1500000, SI_2000000, SI_2500000};
    public static String[] STUMP_THRESHOLD_ARRAY = {SI_200000, SI_300000, SI_500000, SI_1000000, SI_1500000, SI_2000000, SI_2500000};

    public static String[] SUMP_SI_WHEN_THRESHOLD_200000_ARRAY = {SI_300000, SI_500000};

    public static String[] SUMP_SI_WHEN_THRESHOLD_300000_ARRAY = {SI_300000, SI_500000, SI_700000};

    public static String[] SUMP_SI_WHEN_THRESHOLD_500000_ARRAY = {SI_500000, SI_1000000, SI_1500000, SI_2000000, SI_4500000, SI_7000000, SI_9500000};

    public static String[] SUMP_SI_WHEN_THRESHOLD_1000000_ARRAY = {SI_1000000, SI_1500000, SI_2000000, SI_4000000, SI_6500000, SI_9000000};

    public static String[] SUMP_SI_WHEN_THRESHOLD_1500000_ARRAY = {SI_1500000, SI_3500000, SI_6000000, SI_8500000};

    public static String[] SUMP_SI_WHEN_THRESHOLD_2000000_ARRAY = {SI_2000000, SI_3000000, SI_5500000, SI_8000000};

    public static String[] SUMP_SI_WHEN_THRESHOLD_2500000_ARRAY = {SI_2500000, SI_5000000, SI_7500000};

    public static String[] FAMILY_TYPE_ARRAY = {ONE_ADULT_ANY_CHILD, TWO_ADULT, TWO_ADULT_ANY_CHILD};
    public static String UNI_CRITI_CARE_HEALTH_POLICY = "Uni Criti Care";
    public static String[] FAMILY_TYPE_ARRAY_WITH_ONE_ADULT_SELECTION_ALSO = {ONE_ADULT, ONE_ADULT_ANY_CHILD, TWO_ADULT, TWO_ADULT_ANY_CHILD,};
    public static String[] UNI_CRITI_CARE_SI_ARRAY = {
            SI_100000,
            SI_300000,
            SI_500000,
            SI_1000000
    };

    public static String[] HEALTH_NCD_ARRAY = {HEALTH_NCD_0, HEALTH_NCD_5, HEALTH_NCD_10, HEALTH_NCD_15, HEALTH_NCD_20, HEALTH_NCD_25, HEALTH_NCD_27_5, HEALTH_NCD_30, HEALTH_NCD_32_5, HEALTH_NCD_35, HEALTH_NCD_37_5, HEALTH_NCD_40, HEALTH_NCD_42_5, HEALTH_NCD_45, HEALTH_NCD_47_5, HEALTH_NCD_50};

    public static String commissionRate = "0.00";
    public static String commissionAmount = "0.00";
    public static String incentiveRate = "0.00";
    public static String incentiveAmount = "0.00";
    public static String portalChargesRate = "0.00";
    public static String portalChargesRateAmount = "0.00";
    public static String portalIncentiveRate = "0.00";
    public static String portalIncentiveAmount = "0.00";
    public static String additionalIncentiveODRate = "0.00";
    public static String additionalIncentiveODAmount = "0.00";
    public static String additionalIncentiveTPRate = "0.00";
    public static String additionalIncentiveTPAmount = "0.00";


    public static String[] calculateNDCoverPremium(String vehicle, int years, int months, String ndCoverRate, String basicODPremium) {

        String ndCoverPremium = "0.00";
        if (vehicle.equalsIgnoreCase(TWO_WHEELER)) {
            if (years == 0 || years < 0) {
                if (months <= 5) {
                    ndCoverRate = "10";
                } else {
                    ndCoverRate = "20";
                }
            } else if (years == 1 || years == 2 || years == 3) {
                if (months <= 5) {
                    ndCoverRate = "20";
                } else {
                    ndCoverRate = "30";
                }
            } else {
                ndCoverRate = "40";
            }
        } else if (vehicle.equalsIgnoreCase(GCV)) {
            if (years == 0 || years < 0) {
                if (months <= 5) {
                    ndCoverRate = "10";
                } else {
                    ndCoverRate = "20";
                }
            } else if (years == 1) {
                if (months <= 5) {
                    ndCoverRate = "20";
                } else {
                    ndCoverRate = "30";
                }
            } else if (years == 2) {
                if (months <= 5) {
                    ndCoverRate = "30";
                } else {
                    ndCoverRate = "40";
                }
            } else {
                ndCoverRate = "40";
            }
        } else if (vehicle.equalsIgnoreCase(PRIVATE_CAR)) {
            if (years == 0 || years < 0) {
                if (months <= 5) {
                    ndCoverRate = "10";
                } else {
                    ndCoverRate = "20";
                }
            } else if (years == 1) {
                if (months <= 5) {
                    ndCoverRate = "20";
                } else {
                    ndCoverRate = "30";
                }
            } else if (years == 2 || years == 3) {
                if (months <= 5) {
                    ndCoverRate = "30";
                } else {
                    ndCoverRate = "30";
                }
            } else if (years == 4) {
                if (months <= 5) {
                    ndCoverRate = "30";
                } else {
                    ndCoverRate = "40";
                }
            } else {
                ndCoverRate = "40";
            }

        } else if (vehicle.equalsIgnoreCase(PCV)) {
            if (years == 0 || years < 0) {
                if (months <= 5) {
                    ndCoverRate = "10";
                } else {
                    ndCoverRate = "20";
                }
            } else if (years == 1) {
                if (months <= 5) {
                    ndCoverRate = "20";
                } else {
                    ndCoverRate = "30";
                }
            } else if (years == 2) {
                if (months <= 5) {
                    ndCoverRate = "30";
                } else {
                    ndCoverRate = "40";
                }
            } else {
                ndCoverRate = "40";
            }
        }
        ndCoverPremium = Double.toString(Double.parseDouble(ndCoverRate) / 100.00 * Double.parseDouble(basicODPremium));
        return new String[]{ndCoverPremium, ndCoverRate};
    }

    public static String calculateEngineProtectionPremium(String vehicle, double ageOfTheVehicle, EditText idv) {
        String engineProtectionPremium = "0.00";
        if (vehicle.equalsIgnoreCase(TWO_WHEELER)) {
            if ((int) Math.round(ageOfTheVehicle) < 1) {
                engineProtectionPremium = Double.toString(0.07 / 100 * Double.parseDouble(idv.getText().toString().trim()));
            } else if ((int) Math.round(ageOfTheVehicle) >= 1 && (int) Math.round(ageOfTheVehicle) < 2) {
                engineProtectionPremium = Double.toString(0.09 / 100 * Double.parseDouble(idv.getText().toString().trim()));
            } else if ((int) Math.round(ageOfTheVehicle) >= 2 && (int) Math.round(ageOfTheVehicle) < 3) {
                engineProtectionPremium = Double.toString(0.12 / 100 * Double.parseDouble(idv.getText().toString().trim()));
            } else if ((int) Math.round(ageOfTheVehicle) >= 3 && (int) Math.round(ageOfTheVehicle) < 4) {
                engineProtectionPremium = Double.toString(0.17 / 100 * Double.parseDouble(idv.getText().toString().trim()));
            } else if ((int) Math.round(ageOfTheVehicle) >= 4) {
                engineProtectionPremium = Double.toString(0.22 / 100 * Double.parseDouble(idv.getText().toString().trim()));
            }
        } else if (vehicle.equalsIgnoreCase(PRIVATE_CAR)) {
            if ((int) Math.round(ageOfTheVehicle) < 1) {
                engineProtectionPremium = Double.toString(0.13 / 100 * Double.parseDouble(idv.getText().toString().trim()));
            } else if ((int) Math.round(ageOfTheVehicle) >= 1 && (int) Math.round(ageOfTheVehicle) < 2) {
                engineProtectionPremium = Double.toString(0.16 / 100 * Double.parseDouble(idv.getText().toString().trim()));
            } else if ((int) Math.round(ageOfTheVehicle) >= 2 && (int) Math.round(ageOfTheVehicle) < 3) {
                engineProtectionPremium = Double.toString(0.21 / 100 * Double.parseDouble(idv.getText().toString().trim()));
            } else if ((int) Math.round(ageOfTheVehicle) >= 3 && (int) Math.round(ageOfTheVehicle) < 4) {
                engineProtectionPremium = Double.toString(0.27 / 100 * Double.parseDouble(idv.getText().toString().trim()));
            } else if ((int) Math.round(ageOfTheVehicle) >= 4) {
                engineProtectionPremium = Double.toString(0.32 / 100 * Double.parseDouble(idv.getText().toString().trim()));
            }
        }
        return engineProtectionPremium;
    }

    public static String calculateRTIPremium(String vehicle, double ageOfTheVehicle, EditText idv) {
        String rtiPremium = "0.00";
        if (vehicle.equalsIgnoreCase(TWO_WHEELER) || vehicle.equalsIgnoreCase(PRIVATE_CAR) || vehicle.equalsIgnoreCase(GCV)) {
            if (ageOfTheVehicle <= 0.5) {
                rtiPremium = Double.toString(0.15 / 100 * Double.parseDouble(idv.getText().toString().trim()));
            } else if (ageOfTheVehicle > 0.5 && ageOfTheVehicle <= 1.5) {
                rtiPremium = Double.toString(0.20 / 100 * Double.parseDouble(idv.getText().toString().trim()));
            } else if (ageOfTheVehicle > 1.5) {
                rtiPremium = Double.toString(0.25 / 100 * Double.parseDouble(idv.getText().toString().trim()));
            }
        }
        return rtiPremium;
    }

    public static String calculateRTIPremiumPCV(String vehicle, double ageOfTheVehicle, EditText idv, String type) {
        String rtiPremium = "0.00";
        if (type.equalsIgnoreCase(FOUR_WHEELER_PCV) || type.equalsIgnoreCase(THREE_WHEELER_PCV)) {
            if (ageOfTheVehicle <= 0.5) {
                rtiPremium = Double.toString(0.15 / 100 * Double.parseDouble(idv.getText().toString().trim()));
            } else if (ageOfTheVehicle > 0.5 && ageOfTheVehicle <= 1.5) {
                rtiPremium = Double.toString(0.20 / 100 * Double.parseDouble(idv.getText().toString().trim()));
            } else if (ageOfTheVehicle > 1.5) {
                rtiPremium = Double.toString(0.25 / 100 * Double.parseDouble(idv.getText().toString().trim()));
            }
        } else if (type.equalsIgnoreCase(BUS_MAXI_LUXURY_PCV)) {
            if (ageOfTheVehicle <= 0.5) {
                rtiPremium = Double.toString(0.20 / 100 * Double.parseDouble(idv.getText().toString().trim()));
            } else if (ageOfTheVehicle > 0.5 && ageOfTheVehicle <= 1.5) {
                rtiPremium = Double.toString(0.25 / 100 * Double.parseDouble(idv.getText().toString().trim()));
            } else if (ageOfTheVehicle > 1.5) {
                rtiPremium = Double.toString(0.30 / 100 * Double.parseDouble(idv.getText().toString().trim()));
            }
        }
        return rtiPremium;
    }

    public static String calculateRSAPremium(String vehicle) {
        String rsaPremium = "0.00";
        if (vehicle.equalsIgnoreCase(TWO_WHEELER)) {
            rsaPremium = "25.00";
        } else if (vehicle.equalsIgnoreCase(GCV)) {
            rsaPremium = "200.00";
        } else if (vehicle.equalsIgnoreCase(PRIVATE_CAR)) {
            rsaPremium = "50.00";
        }
        return rsaPremium;
    }

    public static String calculateRSAPremiumPCV(String vehicle, String type) {
        String rsaPremium = "0.00";
        if (type.equalsIgnoreCase(FOUR_WHEELER_PCV)) {
            rsaPremium = "75.00";
        } else {
            rsaPremium = "200.00";
        }
        return rsaPremium;
    }

    public static String calculateBasicODRateForTW(String ageOfTheVehicle, Spinner zoneSpinner, Spinner ccSpinner) {
        String basicODRate = "0.00";
        if (zoneSpinner.getSelectedItem().toString().equalsIgnoreCase(ZONE_A)) {
            if (Double.parseDouble(ageOfTheVehicle) < 5.00) {
                if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(UPTO_75) || ccSpinner.getSelectedItem().toString().equalsIgnoreCase(BETWEEN_76_150)) {
                    basicODRate = "1.708";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(BETWEEN_151_350)) {
                    basicODRate = "1.793";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(ABOVE_350)) {
                    basicODRate = "1.879";
                }
            } else if (Double.parseDouble(ageOfTheVehicle) >= 5.00 && Double.parseDouble(ageOfTheVehicle) < 10.00) {
                if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(UPTO_75) || ccSpinner.getSelectedItem().toString().equalsIgnoreCase(BETWEEN_76_150)) {
                    basicODRate = "1.793";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(BETWEEN_151_350)) {
                    basicODRate = "1.883";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(ABOVE_350)) {
                    basicODRate = "1.973";
                }
            } else if (Double.parseDouble(ageOfTheVehicle) >= 10.00) {
                if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(UPTO_75) || ccSpinner.getSelectedItem().toString().equalsIgnoreCase(BETWEEN_76_150)) {
                    basicODRate = "1.836";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(BETWEEN_151_350)) {
                    basicODRate = "1.928";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(ABOVE_350)) {
                    basicODRate = "2.020";
                }
            }
        } else if (zoneSpinner.getSelectedItem().toString().equalsIgnoreCase(ZONE_B)) {
            if (Double.parseDouble(ageOfTheVehicle) < 5.00) {
                if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(UPTO_75) || ccSpinner.getSelectedItem().toString().equalsIgnoreCase(BETWEEN_76_150)) {
                    basicODRate = "1.676";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(BETWEEN_151_350)) {
                    basicODRate = "1.760";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(ABOVE_350)) {
                    basicODRate = "1.844";
                }
            } else if (Double.parseDouble(ageOfTheVehicle) >= 5.00 && Double.parseDouble(ageOfTheVehicle) < 10.00) {
                if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(UPTO_75) || ccSpinner.getSelectedItem().toString().equalsIgnoreCase(BETWEEN_76_150)) {
                    basicODRate = "1.760";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(BETWEEN_151_350)) {
                    basicODRate = "1.848";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(ABOVE_350)) {
                    basicODRate = "1.936";
                }
            } else if (Double.parseDouble(ageOfTheVehicle) >= 10.00) {
                if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(UPTO_75) || ccSpinner.getSelectedItem().toString().equalsIgnoreCase(BETWEEN_76_150)) {
                    basicODRate = "1.802";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(BETWEEN_151_350)) {
                    basicODRate = "1.892";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(ABOVE_350)) {
                    basicODRate = "1.982";
                }
            }
        }
        return basicODRate;
    }

    public static String calculateBasicODRateForGCV(String ageOfTheVehicle, Spinner typeSpinner, Spinner zoneSpinner) {
        String basicODRate = "0.00";
        if (typeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.OTHER_THAN_THREE_WHEELER)) {
            if (zoneSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ZONE_A)) {
                if (Double.parseDouble(ageOfTheVehicle) < 5.00) {
                    basicODRate = "1.751";
                } else if (Double.parseDouble(ageOfTheVehicle) >= 5.00 && Double.parseDouble(ageOfTheVehicle) < 7.00) {
                    basicODRate = "1.795";
                } else if (Double.parseDouble(ageOfTheVehicle) >= 7.00) {
                    basicODRate = "1.839";
                }
            } else if (zoneSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ZONE_B)) {
                if (Double.parseDouble(ageOfTheVehicle) < 5.00) {
                    basicODRate = "1.743";
                } else if (Double.parseDouble(ageOfTheVehicle) >= 5.00 && Double.parseDouble(ageOfTheVehicle) < 7.00) {
                    basicODRate = "1.787";
                } else if (Double.parseDouble(ageOfTheVehicle) >= 7.00) {
                    basicODRate = "1.830";
                }
            } else if (zoneSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ZONE_C)) {
                if (Double.parseDouble(ageOfTheVehicle) < 5.00) {
                    basicODRate = "1.726";
                } else if (Double.parseDouble(ageOfTheVehicle) >= 5.00 && Double.parseDouble(ageOfTheVehicle) < 7.00) {
                    basicODRate = "1.770";
                } else if (Double.parseDouble(ageOfTheVehicle) >= 7.00) {
                    basicODRate = "1.812";
                }
            }
        } else {
            if (zoneSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ZONE_A)) {
                if (Double.parseDouble(ageOfTheVehicle) < 5.00) {
                    basicODRate = "1.664";
                } else if (Double.parseDouble(ageOfTheVehicle) >= 5.00 && Double.parseDouble(ageOfTheVehicle) < 7.00) {
                    basicODRate = "1.706";
                } else if (Double.parseDouble(ageOfTheVehicle) >= 7.00) {
                    basicODRate = "1.747";
                }
            } else if (zoneSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ZONE_B)) {
                if (Double.parseDouble(ageOfTheVehicle) < 5.00) {
                    basicODRate = "1.656";
                } else if (Double.parseDouble(ageOfTheVehicle) >= 5.00 && Double.parseDouble(ageOfTheVehicle) < 7.00) {
                    basicODRate = "1.697";
                } else if (Double.parseDouble(ageOfTheVehicle) >= 7.00) {
                    basicODRate = "1.739";
                }
            } else if (zoneSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ZONE_C)) {
                if (Double.parseDouble(ageOfTheVehicle) < 5.00) {
                    basicODRate = "1.640";
                } else if (Double.parseDouble(ageOfTheVehicle) >= 5.00 && Double.parseDouble(ageOfTheVehicle) < 7.00) {
                    basicODRate = "1.681";
                } else if (Double.parseDouble(ageOfTheVehicle) >= 7.00) {
                    basicODRate = "1.722";
                }
            }
        }
        return basicODRate;
    }

    public static String calculateBasicODRateForPCV(String ageOfTheVehicle, String type, String zone, String cubicCapacity, String passengerCapacity) {

        String basicODRate = "0.00";
        Double age = Double.parseDouble(ageOfTheVehicle);
        Double cc = 0.00;
        if (!cubicCapacity.trim().equalsIgnoreCase("")) {
            cc = Double.parseDouble(cubicCapacity);
        }
        Double passenger = Double.parseDouble(passengerCapacity);

        if (type.equalsIgnoreCase(THREE_WHEELER_PCV)) {
            if (passenger <= 6) {
                if (age <= 5) {
                    if (zone.equalsIgnoreCase(ZONE_A)) {
                        basicODRate = "1.278";
                    } else if (zone.equalsIgnoreCase(ZONE_B)) {
                        basicODRate = "1.272";
                    } else if (zone.equalsIgnoreCase(ZONE_C)) {
                        basicODRate = "1.260";
                    }
                } else if (age > 5 && age <= 7) {
                    if (zone.equalsIgnoreCase(ZONE_A)) {
                        basicODRate = "1.310";
                    } else if (zone.equalsIgnoreCase(ZONE_B)) {
                        basicODRate = "1.304";
                    } else if (zone.equalsIgnoreCase(ZONE_C)) {
                        basicODRate = "1.292";
                    }
                } else if (age > 7) {
                    if (zone.equalsIgnoreCase(ZONE_A)) {
                        basicODRate = "1.342";
                    } else if (zone.equalsIgnoreCase(ZONE_B)) {
                        basicODRate = "1.336";
                    } else if (zone.equalsIgnoreCase(ZONE_C)) {
                        basicODRate = "1.323";
                    }
                }
            } else {
                if (age <= 5) {
                    if (zone.equalsIgnoreCase(ZONE_A)) {
                        basicODRate = "1.785";
                    } else if (zone.equalsIgnoreCase(ZONE_B)) {
                        basicODRate = "1.777";
                    } else if (zone.equalsIgnoreCase(ZONE_C)) {
                        basicODRate = "1.759";
                    }
                } else if (age > 5 && age <= 7) {
                    if (zone.equalsIgnoreCase(ZONE_A)) {
                        basicODRate = "1.830";
                    } else if (zone.equalsIgnoreCase(ZONE_B)) {
                        basicODRate = "1.821";
                    } else if (zone.equalsIgnoreCase(ZONE_C)) {
                        basicODRate = "1.803";
                    }
                } else if (age > 7) {
                    if (zone.equalsIgnoreCase(ZONE_A)) {
                        basicODRate = "1.874";
                    } else if (zone.equalsIgnoreCase(ZONE_B)) {
                        basicODRate = "1.866";
                    } else if (zone.equalsIgnoreCase(ZONE_C)) {
                        basicODRate = "1.847";
                    }
                }
            }
        } else if (type.equalsIgnoreCase(FOUR_WHEELER_PCV)) {
            if (age <= 5) {
                if (zone.equalsIgnoreCase(ZONE_A)) {
                    if (cc <= 1000) {
                        basicODRate = "3.284";
                    } else if (cc > 1000 && cc <= 1500) {
                        basicODRate = "3.448";
                    } else if (cc > 1500) {
                        basicODRate = "3.612";
                    }
                } else if (zone.equalsIgnoreCase(ZONE_B)) {
                    if (cc <= 1000) {
                        basicODRate = "3.191";
                    } else if (cc > 1000 && cc <= 1500) {
                        basicODRate = "3.351";
                    } else if (cc > 1500) {
                        basicODRate = "3.510";
                    }
                }
            } else if (age > 5 && age <= 7) {
                if (zone.equalsIgnoreCase(ZONE_A)) {
                    if (cc <= 1000) {
                        basicODRate = "3.366";
                    } else if (cc > 1000 && cc <= 1500) {
                        basicODRate = "3.534";
                    } else if (cc > 1500) {
                        basicODRate = "3.703";
                    }
                } else if (zone.equalsIgnoreCase(ZONE_B)) {
                    if (cc <= 1000) {
                        basicODRate = "3.271";
                    } else if (cc > 1000 && cc <= 1500) {
                        basicODRate = "3.435";
                    } else if (cc > 1500) {
                        basicODRate = "3.598";
                    }
                }
            } else if (age > 7) {
                if (zone.equalsIgnoreCase(ZONE_A)) {
                    if (cc <= 1000) {
                        basicODRate = "3.448";
                    } else if (cc > 1000 && cc <= 1500) {
                        basicODRate = "3.620";
                    } else if (cc > 1500) {
                        basicODRate = "3.793";
                    }
                } else if (zone.equalsIgnoreCase(ZONE_B)) {
                    if (cc <= 1000) {
                        basicODRate = "3.351";
                    } else if (cc > 1000 && cc <= 1500) {
                        basicODRate = "3.519";
                    } else if (cc > 1500) {
                        basicODRate = "3.686";
                    }
                }
            }
        } else if (type.equalsIgnoreCase(BUS_MAXI_LUXURY_PCV)) {
            if (age <= 5) {
                if (zone.equalsIgnoreCase(ZONE_A)) {
                    basicODRate = "1.680";
                } else if (zone.equalsIgnoreCase(ZONE_B)) {
                    basicODRate = "1.672";
                } else if (zone.equalsIgnoreCase(ZONE_C)) {
                    basicODRate = "1.656";
                }
            } else if (age > 5 && age <= 7) {
                if (zone.equalsIgnoreCase(ZONE_A)) {
                    basicODRate = "1.722";
                } else if (zone.equalsIgnoreCase(ZONE_B)) {
                    basicODRate = "1.714";
                } else if (zone.equalsIgnoreCase(ZONE_C)) {
                    basicODRate = "1.697";
                }
            } else if (age > 7) {
                if (zone.equalsIgnoreCase(ZONE_A)) {
                    basicODRate = "1.764";
                } else if (zone.equalsIgnoreCase(ZONE_B)) {
                    basicODRate = "1.756";
                } else if (zone.equalsIgnoreCase(ZONE_C)) {
                    basicODRate = "1.739";
                }
            }
        }
        return basicODRate;
    }

    public static String calculateBasicTPPremiumForTW(Spinner fuelTypeSpinner, Spinner typeSpinner, Spinner ccSpinner) {
        String basicTPPremium = "0.00";
        if (fuelTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(PETROL)) {
            if (typeSpinner.getSelectedItem().toString().equalsIgnoreCase(PRE_OWNED)) {
                if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.UPTO_75)) {
                    basicTPPremium = "538";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.BETWEEN_76_150)) {
                    basicTPPremium = "714";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.BETWEEN_151_350)) {
                    basicTPPremium = "1366";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ABOVE_350)) {
                    basicTPPremium = "2804";
                }
            } else {
                if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.UPTO_75)) {
                    basicTPPremium = "2901";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.BETWEEN_76_150)) {
                    basicTPPremium = "3851";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.BETWEEN_151_350)) {
                    basicTPPremium = "7365";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ABOVE_350)) {
                    basicTPPremium = "15117";
                }
            }
        } else {

            if (typeSpinner.getSelectedItem().toString().equalsIgnoreCase(PRE_OWNED)) {
                if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.UPTO_3KW)) {
                    basicTPPremium = "457";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.BETWEEN_3KW_7KW)) {
                    basicTPPremium = "607";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.BETWEEN_7KW_16KW)) {
                    basicTPPremium = "1161";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ABOVE_16KW)) {
                    basicTPPremium = "2383";
                }
            } else {
                if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.UPTO_3KW)) {
                    basicTPPremium = "2466";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.BETWEEN_3KW_7KW)) {
                    basicTPPremium = "3273";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.BETWEEN_7KW_16KW)) {
                    basicTPPremium = "6260";
                } else if (ccSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ABOVE_16KW)) {
                    basicTPPremium = "12849";
                }
            }
        }


        return basicTPPremium;
    }

    public static String calculateCPAPremium(Spinner twCPASpinner) {
        String cpaPremium = "0.00";
        if (twCPASpinner.getSelectedItem().toString().equalsIgnoreCase("No")) {
            cpaPremium = "0";
        } else if (twCPASpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.ONE_YEAR)) {
            cpaPremium = "275";
        } else if (twCPASpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.FIVE_YEAR)) {
            cpaPremium = "1375";
        }
        return cpaPremium;
    }

    public static String calculateBasicTPPremiumForGCV(EditText gvw, Spinner typeSpinner, String fuel) {
        String basicTPPremium = "0.00";
        if (!gvw.getText().toString().trim().equalsIgnoreCase("")) {
            if (fuel.equalsIgnoreCase(ELECTRIC)) {
                if (typeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.OTHER_THAN_THREE_WHEELER)) {
                    if (Double.parseDouble(gvw.getText().toString().trim()) <= 7500) {
                        basicTPPremium = "13642";
                    } else if (Double.parseDouble(gvw.getText().toString().trim()) > 7500 && Double.parseDouble(gvw.getText().toString().trim()) <= 12000) {
                        basicTPPremium = "23108";
                    } else if (Double.parseDouble(gvw.getText().toString().trim()) > 12000 && Double.parseDouble(gvw.getText().toString().trim()) <= 20000) {
                        basicTPPremium = "30016";
                    } else if (Double.parseDouble(gvw.getText().toString().trim()) > 20000 && Double.parseDouble(gvw.getText().toString().trim()) <= 40000) {
                        basicTPPremium = "37357";
                    } else if (Double.parseDouble(gvw.getText().toString().trim()) > 40000) {
                        basicTPPremium = "37606";
                    }
                } else {
                    basicTPPremium = "3139";
                }
            } else if (fuel.equalsIgnoreCase(PETROL) || fuel.equalsIgnoreCase(DIESEL) || fuel.equalsIgnoreCase(HYBRID)) {
                if (typeSpinner.getSelectedItem().toString().equalsIgnoreCase(CommonFunctions.OTHER_THAN_THREE_WHEELER)) {
                    if (Double.parseDouble(gvw.getText().toString().trim()) <= 7500) {
                        basicTPPremium = "16049";
                    } else if (Double.parseDouble(gvw.getText().toString().trim()) > 7500 && Double.parseDouble(gvw.getText().toString().trim()) <= 12000) {
                        basicTPPremium = "27186";
                    } else if (Double.parseDouble(gvw.getText().toString().trim()) > 12000 && Double.parseDouble(gvw.getText().toString().trim()) <= 20000) {
                        basicTPPremium = "35313";
                    } else if (Double.parseDouble(gvw.getText().toString().trim()) > 20000 && Double.parseDouble(gvw.getText().toString().trim()) <= 40000) {
                        basicTPPremium = "43950";
                    } else if (Double.parseDouble(gvw.getText().toString().trim()) > 40000) {
                        basicTPPremium = "44242";
                    }
                } else {
                    basicTPPremium = "4492";
                }

                if (fuel.equalsIgnoreCase(HYBRID)) {
                    basicTPPremium = Double.toString(Double.parseDouble(basicTPPremium) - (Double.parseDouble(HYBRID_DISCOUNT) / 100.00) * Double.parseDouble(basicTPPremium));
                }
            }
        }

        return basicTPPremium;
    }

    public static String[] calculateBasicTPPremiumForPCV(String type, String category, String psgr, String cubicCapacity, String fuel) {
        Double passenger = Double.parseDouble(psgr);
        Double cc = 0.00;
        if (!cubicCapacity.equalsIgnoreCase("")) {
            cc = Double.parseDouble(cubicCapacity);
        }
        String tpPremium = "0.00";
        String perPassenger = "0.00";
        String[] tpArray = new String[2];

        if (type.equalsIgnoreCase(THREE_WHEELER_PCV)) {
            if (passenger <= 6) {
                if (fuel.equalsIgnoreCase(E_RIKSHAW)) {
                    tpPremium = "1539";
                    perPassenger = "737";
                } else {
                    tpPremium = "2371.00";
                    perPassenger = "1134.00";
                }

            }
        } else if (type.equalsIgnoreCase(FOUR_WHEELER_PCV)) {
            if (cc <= 1000) {
                tpPremium = "6040.00";
                perPassenger = "1162.00";
            } else if (cc > 1000 && cc <= 1500) {
                tpPremium = "7940.00";
                perPassenger = "978";
            } else if (cc > 1500) {
                tpPremium = "10523.00";
                perPassenger = "1117.00";
            }
        } else if (type.equalsIgnoreCase(BUS_MAXI_LUXURY_PCV)) {
            if (category.equalsIgnoreCase(INSTITUTION_BUS)) {
                tpPremium = "12192.00";
                perPassenger = "745.00";
            } else {
                tpPremium = "14343.00";
                perPassenger = "877.00";
            }
        }

        if (fuel.equalsIgnoreCase(HYBRID)) {
            tpPremium = Double.toString(Double.parseDouble(tpPremium) - (Double.parseDouble(HYBRID_DISCOUNT) / 100.00 * Double.parseDouble(tpPremium)));
            perPassenger = Double.toString(Double.parseDouble(perPassenger) - (Double.parseDouble(HYBRID_DISCOUNT) / 100.00 * Double.parseDouble(perPassenger)));
        }

        tpArray[0] = tpPremium;
        tpArray[1] = perPassenger;

        return tpArray;

    }

    public static String calculateBasicTPPremiumForPrivateCar(Spinner fuelTypeSpinner, Spinner typeSpinner, String cc) {
        String basicTPPremium = "0.00";
        Double doubleCc = Double.parseDouble(cc);

        if (fuelTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(PETROL) || fuelTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(DIESEL)) {
            if (typeSpinner.getSelectedItem().toString().equalsIgnoreCase(PRE_OWNED)) {
                if (doubleCc <= 1000.00) {
                    basicTPPremium = "2094";
                } else if (doubleCc > 1000.00 && doubleCc <= 1500.00) {
                    basicTPPremium = "3416";
                } else if (doubleCc > 1500.00) {
                    basicTPPremium = "7897";
                }
            } else {
                if (doubleCc <= 1000.00) {
                    basicTPPremium = "6521";
                } else if (doubleCc > 1000.00 && doubleCc <= 1500.00) {
                    basicTPPremium = "10640";
                } else if (doubleCc > 1500.00) {
                    basicTPPremium = "24596";
                }
            }
        } else {
            if (typeSpinner.getSelectedItem().toString().equalsIgnoreCase(PRE_OWNED)) {
                if (doubleCc <= 30.00) {
                    basicTPPremium = "1780";
                } else if (doubleCc > 30.00 && doubleCc <= 65.00) {
                    basicTPPremium = "2904";
                } else if (doubleCc > 65.00) {
                    basicTPPremium = "6712";
                }
            } else {
                if (doubleCc <= 30.00) {
                    basicTPPremium = "5543";
                } else if (doubleCc > 30.00 && doubleCc <= 65.00) {
                    basicTPPremium = "9044";
                } else if (doubleCc > 65.00) {
                    basicTPPremium = "20907";
                }
            }
        }

        return basicTPPremium;
    }

    public static String calculateBasicTPPremiumForPCV(Spinner typeSpinner, Spinner pcvCategorySpinner, Spinner fuelTypeSpinner) {
        String basicTPPremium = "0.00";

        if (!fuelTypeSpinner.getSelectedItem().toString().equalsIgnoreCase(ELECTRIC)) {
            if (typeSpinner.getSelectedItem().toString().equalsIgnoreCase(LESS_THAN_6_PASSENGER)) {

            } else if (typeSpinner.getSelectedItem().toString().equalsIgnoreCase(MORE_THAN_6_PASSENGER)) {
                if (pcvCategorySpinner.getSelectedItem().toString().equalsIgnoreCase(OTHERS)) {
                    basicTPPremium = "14343";
                } else if (pcvCategorySpinner.getSelectedItem().toString().equalsIgnoreCase(INSTITUTION_BUS)) {
                    basicTPPremium = "12192";
                }
            }
        }

        return basicTPPremium;
    }

    public static String uptoTwoDecimal(String input) {
        String output = "0.00";
        if (input != null) {
            if (!input.trim().equalsIgnoreCase("")) {
                Double value = Double.parseDouble(input);
                output = String.format("%.2f", value);
            }
        }
        return output;
    }

    public static String uptoZeroDecimal(String input) {
        String output = "0.00";
        double value = Double.parseDouble(input);
        long rounded = Math.round(value);
        output = String.valueOf(rounded);
        return output;
    }

    public static String calculateConsumablesPremium(String vehicle, double ageOfTheVehicle, EditText idv) {
        String consumablesPremium = "0.00";
        double consumableRate = 0.00;
        if (vehicle.equalsIgnoreCase(TWO_WHEELER) || vehicle.equalsIgnoreCase(PRIVATE_CAR)) {
            if ((int) Math.round(ageOfTheVehicle) < 1) {
                consumableRate = 0.10;
            } else if ((int) Math.round(ageOfTheVehicle) >= 1 && (int) Math.round(ageOfTheVehicle) < 2) {
                consumableRate = 0.12;
            } else if ((int) Math.round(ageOfTheVehicle) >= 2 && (int) Math.round(ageOfTheVehicle) < 3) {
                consumableRate = 0.15;
            } else if ((int) Math.round(ageOfTheVehicle) >= 3 && (int) Math.round(ageOfTheVehicle) < 4) {
                consumableRate = 0.17;
            } else if ((int) Math.round(ageOfTheVehicle) >= 4) {
                consumableRate = 0.20;
            }
        } else if (vehicle.equalsIgnoreCase(GCV) || vehicle.equalsIgnoreCase(PCV)) {
            if ((int) Math.round(ageOfTheVehicle) < 1) {
                consumableRate = 0.15;
            } else if ((int) Math.round(ageOfTheVehicle) >= 1 && (int) Math.round(ageOfTheVehicle) < 2) {
                consumableRate = 0.18;
            } else if ((int) Math.round(ageOfTheVehicle) >= 2 && (int) Math.round(ageOfTheVehicle) < 3) {
                consumableRate = 0.22;
            } else if ((int) Math.round(ageOfTheVehicle) >= 3 && (int) Math.round(ageOfTheVehicle) < 4) {
                consumableRate = 0.25;
            } else if ((int) Math.round(ageOfTheVehicle) >= 4) {
                consumableRate = 0.30;
            }
        }
        consumablesPremium = Double.toString(consumableRate / 100 * Double.parseDouble(idv.getText().toString().trim()));
        return consumablesPremium;
    }

    public static String[] calculateLossOfKey(String vehicle, String lossOfKeySI) {
        String[] result = null;
        if (vehicle.equalsIgnoreCase(TWO_WHEELER)) {
            result = new String[]{"50.00", "3000.00"};
        } else if (vehicle.equalsIgnoreCase(PRIVATE_CAR)) {
            if (lossOfKeySI.equalsIgnoreCase(LOSS_OF_KEY_SI_10000)) {
                result = new String[]{"300.00", "10000"};
            } else if (lossOfKeySI.equalsIgnoreCase(LOSS_OF_KEY_SI_25000)) {
                result = new String[]{"750", "25000"};
            }
        }
        return result;
    }

    // Commission w.e.f 01/10/2025
    public static String[] calculatePayoutForTwoWheeler(String fuel, String cc, String rtoState, String isSAOD, String netPremium) {

        commissionRate = "0.00";
        commissionAmount = "0.00";
        incentiveRate = "0.00";
        incentiveAmount = "0.00";
        portalChargesRate = "0.00";
        portalChargesRateAmount = "0.00";
        portalIncentiveRate = "0.00";
        portalIncentiveAmount = "0.00";

        if (Double.parseDouble(netPremium) <= 500.00) {
            portalChargesRate = "20.00";
        } else {
            portalChargesRate = "50.00";
        }
        portalIncentiveRate = "0.75";
        String[] payout = new String[8];

        if (isSAOD.equalsIgnoreCase(CommonFunctions.YES)) {
            commissionRate = "20.00";
        } else {
            if (fuel.equalsIgnoreCase(PETROL)) {
                if (cc.equalsIgnoreCase(UPTO_75) || cc.equalsIgnoreCase(BETWEEN_76_150) || cc.equalsIgnoreCase(BETWEEN_151_350)) {
                    if (rtoState.equalsIgnoreCase(TAMIL_NADU) || rtoState.equalsIgnoreCase(KERALA) || rtoState.equalsIgnoreCase(KARNATAKA) || rtoState.equalsIgnoreCase(MADHYA_PRADESH) || rtoState.equalsIgnoreCase(ASSAM)) {
                        commissionRate = "5.00";
                        incentiveRate = "0.00";
                    } else {
                        commissionRate = "5.00";
                        incentiveRate = "17.50";
                    }
                } else if (cc.equalsIgnoreCase(ABOVE_350)) {
                    if (rtoState.equalsIgnoreCase(TAMIL_NADU) || rtoState.equalsIgnoreCase(KERALA) || rtoState.equalsIgnoreCase(KARNATAKA) || rtoState.equalsIgnoreCase(MADHYA_PRADESH) || rtoState.equalsIgnoreCase(ASSAM)) {
                        commissionRate = "5.00";
                        incentiveRate = "0.00";
                    } else {
                        commissionRate = "5.00";
                        incentiveRate = "12.50";
                    }
                }
            } else if (fuel.equalsIgnoreCase(ELECTRIC)) {
                if (rtoState.equalsIgnoreCase(TAMIL_NADU) || rtoState.equalsIgnoreCase(KERALA) || rtoState.equalsIgnoreCase(KARNATAKA) || rtoState.equalsIgnoreCase(MADHYA_PRADESH) || rtoState.equalsIgnoreCase(ASSAM)) {
                    commissionRate = "5.00";
                    incentiveRate = "0.00";
                } else {
                    commissionRate = "5.00";
                    incentiveRate = "17.50";
                }
            }
        }

        payout[0] = Double.toString((Double.parseDouble(commissionRate) / 100.00) * Double.parseDouble(netPremium));
        payout[1] = " ( ".concat(commissionRate).concat(" % of Net Premium )");
        payout[2] = Double.toString((Double.parseDouble(incentiveRate) / 100.00) * Double.parseDouble(netPremium));
        ;
        payout[3] = " ( ".concat(incentiveRate).concat(" % of Net Premium )");
        payout[4] = portalChargesRate;
        payout[5] = " ( Fixed Charges )";
        payout[6] = Double.toString((Double.parseDouble(portalIncentiveRate) / 100.00) * Double.parseDouble(netPremium));
        ;
        payout[7] = " ( ".concat(portalIncentiveRate).concat(" % of Net Premium )");

        return payout;
    }

    public static ArrayList<String> calculatePayoutForPvtCar(String fuel, String cc, String isSAOD, String type, String manufacturer, String netPremium, String totalODPremium, String totalTPPremium, String rtoState) {

        commissionRate = "0.00";
        commissionAmount = "0.00";
        incentiveRate = "0.00";
        incentiveAmount = "0.00";
        portalChargesRate = "0.00";
        portalChargesRateAmount = "0.00";
        portalIncentiveRate = "0.00";
        portalIncentiveAmount = "0.00";
        additionalIncentiveODRate = "0.00";
        additionalIncentiveODAmount = "0.00";
        additionalIncentiveTPRate = "0.00";
        additionalIncentiveTPAmount = "0.00";

        Double doubleCc = Double.parseDouble(cc);

        if (Double.parseDouble(netPremium) <= 500.00) {
            portalChargesRate = "20.00";
        } else {
            portalChargesRate = "50.00";
        }
        portalIncentiveRate = "0.75";
        ArrayList<String> payout = new ArrayList<String>();

        if (isSAOD.equalsIgnoreCase(YES)) {
            commissionRate = "12.00";
        } else {
            if (type.equalsIgnoreCase(CommonFunctions.NEW)) {
                if (fuel.equalsIgnoreCase(CommonFunctions.DIESEL)) {
                    if (doubleCc <= 1500.00) {
                        commissionRate = "10.00";
                    } else if (doubleCc > 1500.00 && doubleCc <= 2500.00) {
                        commissionRate = "17.50";
                        incentiveRate = "10.00";
                    } else if (doubleCc > 2500.00) {
                        if (manufacturer.equalsIgnoreCase(CommonFunctions.OTHERS)) {
                            commissionRate = "10.00";
                        } else {
                            commissionRate = "17.50";
                            incentiveRate = "10.00";
                        }
                    }
                } else if (fuel.equalsIgnoreCase(CommonFunctions.PETROL)) {
                    if (doubleCc > 2500.00) {
                        if (manufacturer.equalsIgnoreCase(CommonFunctions.OTHERS)) {
                            commissionRate = "10.00";
                        } else {
                            commissionRate = "17.50";
                            incentiveRate = "10.00";
                        }
                    } else {
                        commissionRate = "17.50";
                        incentiveRate = "10.00";
                    }
                } else if (fuel.equalsIgnoreCase(CommonFunctions.ELECTRIC)) {
                    commissionRate = "17.50";
                    incentiveRate = "10.00";
                }
            } else {
                if (fuel.equalsIgnoreCase(CommonFunctions.DIESEL)) {
                    if (doubleCc <= 1500.00) {
                        commissionRate = "5.00";
                    } else if (doubleCc > 1500.00 && doubleCc <= 2500.00) {
                        commissionRate = "15.00";
                        incentiveRate = "5.00";
                    } else if (doubleCc > 2500.00) {
                        if (manufacturer.equalsIgnoreCase(CommonFunctions.OTHERS)) {
                            commissionRate = "5.00";
                        } else {
                            commissionRate = "15.00";
                            incentiveRate = "5.00";
                        }
                    }
                } else if (fuel.equalsIgnoreCase(CommonFunctions.PETROL)) {
                    if (doubleCc > 2500.00) {
                        if (manufacturer.equalsIgnoreCase(CommonFunctions.OTHERS)) {
                            commissionRate = "5.00";
                        } else {
                            commissionRate = "15.00";
                            incentiveRate = "5.00";
                        }
                    } else {
                        commissionRate = "15.00";
                        incentiveRate = "5.00";
                    }
                } else if (fuel.equalsIgnoreCase(CommonFunctions.ELECTRIC)) {
                    commissionRate = "12.00";
                    incentiveRate = "5.00";
                }
            }
        }

        if (fuel.equalsIgnoreCase(ELECTRIC)) {
            additionalIncentiveODRate = "2.50";
            additionalIncentiveTPRate = "15.00";
        } else {
            if (doubleCc > 1000.00 && doubleCc <= 1200.00) {
                if (rtoState.equalsIgnoreCase(KARNATAKA) || rtoState.equalsIgnoreCase(HARYANA) || rtoState.equalsIgnoreCase(MADHYA_PRADESH) || rtoState.equalsIgnoreCase(TAMIL_NADU)) {

                } else {
                    additionalIncentiveODRate = "2.50";
                    additionalIncentiveTPRate = "15.00";
                }
            } else if (doubleCc > 1500.00 && doubleCc <= 2000.00) {
                additionalIncentiveODRate = "2.50";
                additionalIncentiveTPRate = "15.00";
            } else if (doubleCc > 2000.00) {
                if (rtoState.equalsIgnoreCase(KARNATAKA) || rtoState.equalsIgnoreCase(HARYANA) || rtoState.equalsIgnoreCase(MADHYA_PRADESH) || rtoState.equalsIgnoreCase(TAMIL_NADU)) {

                } else {
                    additionalIncentiveODRate = "10.00";
                    additionalIncentiveTPRate = "10.00";
                }
            }
        }

        payout.add(Double.toString((Double.parseDouble(commissionRate) / 100.00) * Double.parseDouble(netPremium)));
        payout.add(" ( ".concat(commissionRate).concat(" % of Net Premium )"));
        payout.add(Double.toString((Double.parseDouble(incentiveRate) / 100.00) * Double.parseDouble(netPremium)));
        payout.add(" ( ".concat(incentiveRate).concat(" % of Net Premium )"));
        payout.add(portalChargesRate);
        payout.add(" ( Fixed Charges )");
        payout.add(Double.toString((Double.parseDouble(portalIncentiveRate) / 100.00) * Double.parseDouble(netPremium)));
        payout.add(" ( ".concat(portalIncentiveRate).concat(" % of Net Premium )"));
        payout.add(Double.toString(Double.parseDouble(additionalIncentiveODRate) / 100.00 * Double.parseDouble(totalODPremium)));
        payout.add(" ( ".concat(additionalIncentiveODRate).concat(" % of OD Premium)"));
        payout.add(Double.toString(Double.parseDouble(additionalIncentiveTPRate) / 100.00 * Double.parseDouble(totalTPPremium)));
        payout.add(" ( ".concat(additionalIncentiveTPRate).concat(" % of TP Premium)"));

        return payout;

    }

    public static String[] calculatePayoutForGVW(String gvw, String rtoState, String netPremium) {
        commissionRate = "0.00";
        commissionAmount = "0.00";
        incentiveRate = "0.00";
        incentiveAmount = "0.00";
        portalChargesRate = "0.00";
        portalChargesRateAmount = "0.00";
        portalIncentiveRate = "0.00";
        portalIncentiveAmount = "0.00";

        if (Double.parseDouble(netPremium) <= 500.00) {
            portalChargesRate = "20.00";
        } else {
            portalChargesRate = "50.00";
        }
        portalIncentiveRate = "0.75";
        String[] payout = new String[8];

        Double doubleGvw = 0.00;
        if (!gvw.equalsIgnoreCase("")) {
            doubleGvw = Double.parseDouble(gvw);
        }
        if (doubleGvw <= 2000) {
            if (rtoState.equalsIgnoreCase(UTTAR_PRADESH)) {
                commissionRate = "20.00";
            } else {
                commissionRate = "20.00";
                incentiveRate = "37.50";
            }
        } else if (doubleGvw > 2000 && doubleGvw <= 3500) {
            if (rtoState.equalsIgnoreCase(HARYANA) || rtoState.equalsIgnoreCase(MADHYA_PRADESH) || rtoState.equalsIgnoreCase(RAJASTHAN) || rtoState.equalsIgnoreCase(TAMIL_NADU) || rtoState.equalsIgnoreCase(UTTAR_PRADESH)) {
                commissionRate = "15.00";
            } else {
                commissionRate = "15.00";
                incentiveRate = "30.00";
            }
        } else if (doubleGvw > 3500 && doubleGvw <= 7500) {
            if (rtoState.equalsIgnoreCase(HARYANA) || rtoState.equalsIgnoreCase(MADHYA_PRADESH) || rtoState.equalsIgnoreCase(RAJASTHAN) || rtoState.equalsIgnoreCase(TAMIL_NADU) || rtoState.equalsIgnoreCase(UTTAR_PRADESH)) {
                commissionRate = "10.00";
            } else {
                commissionRate = "10.00";
                incentiveRate = "17.50";
            }
        } else if (doubleGvw > 7500 && doubleGvw <= 10000) {
            if (rtoState.equalsIgnoreCase(HARYANA) || rtoState.equalsIgnoreCase(MADHYA_PRADESH) || rtoState.equalsIgnoreCase(RAJASTHAN) || rtoState.equalsIgnoreCase(TAMIL_NADU) || rtoState.equalsIgnoreCase(UTTAR_PRADESH)) {
                commissionRate = "10.00";
            } else {
                commissionRate = "10.00";
                incentiveRate = "7.50";
            }
        } else if (doubleGvw > 10000 && doubleGvw <= 12000) {
            commissionRate = "2.50";
        } else if (doubleGvw > 12000 && doubleGvw <= 20000) {
            if (rtoState.equalsIgnoreCase(HARYANA) || rtoState.equalsIgnoreCase(MADHYA_PRADESH) || rtoState.equalsIgnoreCase(RAJASTHAN) || rtoState.equalsIgnoreCase(TAMIL_NADU) || rtoState.equalsIgnoreCase(UTTAR_PRADESH) || rtoState.equalsIgnoreCase(KARNATAKA) || rtoState.equalsIgnoreCase(KERALA)) {
                commissionRate = "5.00";
            } else {
                commissionRate = "5.00";
                incentiveRate = "10.00";
            }
        } else if (doubleGvw > 20000 && doubleGvw <= 25000) {
            if (rtoState.equalsIgnoreCase(HARYANA) || rtoState.equalsIgnoreCase(MADHYA_PRADESH) || rtoState.equalsIgnoreCase(RAJASTHAN) || rtoState.equalsIgnoreCase(TAMIL_NADU) || rtoState.equalsIgnoreCase(UTTAR_PRADESH) || rtoState.equalsIgnoreCase(KARNATAKA) || rtoState.equalsIgnoreCase(KERALA)) {
                commissionRate = "5.00";
            } else {
                commissionRate = "5.00";
                incentiveRate = "10.00";
            }
        } else if (doubleGvw > 25000 && doubleGvw <= 35000) {
            if (rtoState.equalsIgnoreCase(HARYANA) || rtoState.equalsIgnoreCase(MADHYA_PRADESH) || rtoState.equalsIgnoreCase(RAJASTHAN) || rtoState.equalsIgnoreCase(TAMIL_NADU) || rtoState.equalsIgnoreCase(UTTAR_PRADESH) || rtoState.equalsIgnoreCase(KARNATAKA) || rtoState.equalsIgnoreCase(KERALA)) {
                commissionRate = "2.50";
            } else {
                commissionRate = "2.50";
                incentiveRate = "10.00";
            }
        } else if (doubleGvw > 35000 && doubleGvw <= 40000) {
            commissionRate = "2.50";
        } else if (doubleGvw > 40000) {
            if (rtoState.equalsIgnoreCase(HARYANA) || rtoState.equalsIgnoreCase(MADHYA_PRADESH) || rtoState.equalsIgnoreCase(RAJASTHAN) || rtoState.equalsIgnoreCase(TAMIL_NADU) || rtoState.equalsIgnoreCase(UTTAR_PRADESH) || rtoState.equalsIgnoreCase(KARNATAKA) || rtoState.equalsIgnoreCase(KERALA)) {

            } else {
                incentiveRate = "5.00";
            }
        }


        payout[0] = Double.toString((Double.parseDouble(commissionRate) / 100.00) * Double.parseDouble(netPremium));
        payout[1] = " ( ".concat(commissionRate).concat(" % of Net Premium )");
        payout[2] = Double.toString((Double.parseDouble(incentiveRate) / 100.00) * Double.parseDouble(netPremium));
        ;
        payout[3] = " ( ".concat(incentiveRate).concat(" % of Net Premium )");
        payout[4] = portalChargesRate;
        payout[5] = " ( Fixed Charges )";
        payout[6] = Double.toString((Double.parseDouble(portalIncentiveRate) / 100.00) * Double.parseDouble(netPremium));
        ;
        payout[7] = " ( ".concat(portalIncentiveRate).concat(" % of Net Premium )");

        return payout;
    }

    public static String calculateBasicODRateForPvtCar(String ageOfTheVehicle, Spinner zoneSpinner, String cc, String fuel) {
        String basicODRate = "0.00";
        Double doubleCc = Double.parseDouble(cc);
        if (zoneSpinner.getSelectedItem().toString().equalsIgnoreCase(ZONE_A)) {
            if (fuel.equalsIgnoreCase(ELECTRIC)) {
                if (Double.parseDouble(ageOfTheVehicle) < 5.00) {
                    basicODRate = "3.283";
                } else {
                    basicODRate = "3.447";
                }
            } else {
                if (Double.parseDouble(ageOfTheVehicle) < 5.00) {
                    if (doubleCc <= 1000.00) {
                        basicODRate = "3.127";
                    } else if (doubleCc > 1000.00 && doubleCc <= 1500.00) {
                        basicODRate = "3.283";
                    } else if (doubleCc > 1500.00) {
                        basicODRate = "3.440";
                    }
                } else if (Double.parseDouble(ageOfTheVehicle) >= 5.00 && Double.parseDouble(ageOfTheVehicle) < 10.00) {
                    if (doubleCc <= 1000.00) {
                        basicODRate = "3.283";
                    } else if (doubleCc > 1000.00 && doubleCc <= 1500.00) {
                        basicODRate = "3.447";
                    } else if (doubleCc > 1500.00) {
                        basicODRate = "3.612";
                    }
                } else if (Double.parseDouble(ageOfTheVehicle) >= 10.00) {
                    if (doubleCc <= 1000.00) {
                        basicODRate = "3.362";
                    } else if (doubleCc > 1000.00 && doubleCc <= 1500.00) {
                        basicODRate = "3.529";
                    } else if (doubleCc > 1500.00) {
                        basicODRate = "3.698";
                    }
                }
            }
        } else if (zoneSpinner.getSelectedItem().toString().equalsIgnoreCase(ZONE_B)) {
            if (fuel.equalsIgnoreCase(ELECTRIC)) {
                if (Double.parseDouble(ageOfTheVehicle) < 5.00) {
                    basicODRate = "3.191";
                } else {
                    basicODRate = "3.351";
                }
            } else {
                if (Double.parseDouble(ageOfTheVehicle) < 5.00) {
                    if (doubleCc <= 1000.00) {
                        basicODRate = "3.039";
                    } else if (doubleCc > 1000.00 && doubleCc <= 1500.00) {
                        basicODRate = "3.191";
                    } else if (doubleCc > 1500.00) {
                        basicODRate = "3.343";
                    }
                } else if (Double.parseDouble(ageOfTheVehicle) >= 5.00 && Double.parseDouble(ageOfTheVehicle) < 10.00) {
                    if (doubleCc <= 1000.00) {
                        basicODRate = "3.191";
                    } else if (doubleCc > 1000.00 && doubleCc <= 1500.00) {
                        basicODRate = "3.351";
                    } else if (doubleCc > 1500.00) {
                        basicODRate = "3.510";
                    }
                } else if (Double.parseDouble(ageOfTheVehicle) >= 10.00) {
                    if (doubleCc <= 1000.00) {
                        basicODRate = "3.267";
                    } else if (doubleCc > 1000.00 && doubleCc <= 1500.00) {
                        basicODRate = "3.430";
                    } else if (doubleCc > 1500.00) {
                        basicODRate = "3.594";
                    }
                }
            }
        }
        return basicODRate;
    }


    public static String roundUp(String input) {
        String result = "0.00";
        // Extract decimal part
        double decimalPart = Math.abs(Double.parseDouble(input) - Math.floor(Double.parseDouble(input)));

        // Determine rounding based on decimal part
        int roundedResult;
        if (decimalPart >= 0.5) {
            roundedResult = (int) Math.ceil(Double.parseDouble(input)); // Round up
        } else {
            roundedResult = (int) Math.floor(Double.parseDouble(input)); // Round down
        }
        result = Double.toString((double) roundedResult);
        return result;
    }

    public static int[] getYearsAndMonthsFromAge(Calendar polStartDateCalendar, Calendar regDateCalendar) {

        int[] result = new int[2];
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String polStartDateFormattedDate = dateFormat.format(polStartDateCalendar.getTime());
        String regDateFormattedDate = dateFormat.format(regDateCalendar.getTime());

        String[] polStartDateParts = polStartDateFormattedDate.split("/");
        int polStartDateDay = Integer.parseInt(polStartDateParts[0]);
        int polStartDateMonth = Integer.parseInt(polStartDateParts[1]) - 1; // Calendar months are 0-based
        int polStartDateYear = Integer.parseInt(polStartDateParts[2]);

        String[] regDateParts = regDateFormattedDate.split("/");
        int regDateDay = Integer.parseInt(regDateParts[0]);
        int regDateMonth = Integer.parseInt(regDateParts[1]) - 1; // Calendar months are 0-based
        int regDateYear = Integer.parseInt(regDateParts[2]);

        polStartDateCalendar.set(polStartDateYear, polStartDateMonth, polStartDateDay);
        regDateCalendar.set(regDateYear, regDateMonth, regDateDay);

        int years = polStartDateCalendar.get(Calendar.YEAR) - regDateCalendar.get(Calendar.YEAR);
        int months = polStartDateCalendar.get(Calendar.MONTH) - regDateCalendar.get(Calendar.MONTH);
        int days = polStartDateCalendar.get(Calendar.DAY_OF_MONTH) - regDateCalendar.get(Calendar.DAY_OF_MONTH);

        // Adjust if the current date is before the birth date in the year
        if (months < 0 || (months == 0 && days < 0)) {
            years--;
            months += 12;
        }

        result[0] = years;
        result[1] = months;

        return result;
    }

    public static int[] getYearsAndMonthsFromAge(String polStartDate, String regDate) {
        int[] result = new int[2];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        if (!isValidDate(polStartDate)) {

        }
        if (!isValidDate(regDate)) {

        }
        LocalDate date1 = LocalDate.parse(polStartDate, formatter);
        LocalDate date2 = LocalDate.parse(regDate, formatter);

        if (date2.isAfter(date1)) {

        } else {
            Period diff = Period.between(date2, date1);
            result[0] = Math.abs(diff.getYears());
            result[1] = Math.abs(diff.getMonths());
        }

        return result;
    }

    private static boolean isValidDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse(dateStr, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }


    public static String[] calculatePersonalEffectPremium(String vehicle, String si) {
        String[] result = new String[2];
        if (vehicle.equalsIgnoreCase(PRIVATE_CAR)) {
            result[0] = "250.00";
            result[1] = si;
        }
        return result;
    }

    public static String[] calculatePAToPassenger(String vehicle, Spinner paToPassengerSISpinner, EditText noOfPassenger) {
        String[] result = new String[2];
        double rate = 0.00;
        if (vehicle.equalsIgnoreCase(PRIVATE_CAR) || vehicle.equalsIgnoreCase(TWO_WHEELER)) {
            rate = 5.00;
        } else if (vehicle.equalsIgnoreCase(GCV)) {
            rate = 7.00;
        }
        String paToPassengerSI = Double.toString(Double.parseDouble(paToPassengerSISpinner.getSelectedItem().toString()) / 10000.00 * rate);
        String paToPassengerTotalSI = Double.toString(Double.parseDouble(paToPassengerSISpinner.getSelectedItem().toString()) * Double.parseDouble(noOfPassenger.getText().toString().trim()));
        String paToPassengerPremium = Double.toString(Double.parseDouble(noOfPassenger.getText().toString()) * Double.parseDouble(paToPassengerSI));
        result[0] = paToPassengerPremium;
        result[1] = paToPassengerTotalSI;
        return result;
    }


    public static String[] calculatePayoutForPCV(String type, String rtoState, String netPremium, String fuelType, String passengerCapacity, String category) {
        String[] payout = new String[8];
        commissionRate = "0.00";
        commissionAmount = "0.00";
        incentiveRate = "0.00";
        incentiveAmount = "0.00";
        portalChargesRate = "0.00";
        portalChargesRateAmount = "0.00";
        portalIncentiveRate = "0.00";
        portalIncentiveAmount = "0.00";

        if (Double.parseDouble(netPremium) <= 500.00) {
            portalChargesRate = "20.00";
        } else {
            portalChargesRate = "50.00";
        }
        portalIncentiveRate = "0.75";

        Double passenger = 0.00;
        if (!passengerCapacity.equalsIgnoreCase("")) {
            passenger = Double.parseDouble(passengerCapacity);
        }
        if (type.equalsIgnoreCase(BUS_MAXI_LUXURY_PCV)) {
            if (category.equalsIgnoreCase(INSTITUTION_BUS)) {
                if (rtoState.equalsIgnoreCase(KARNATAKA) || rtoState.equalsIgnoreCase(MADHYA_PRADESH) || rtoState.equalsIgnoreCase(RAJASTHAN) || rtoState.equalsIgnoreCase(TAMIL_NADU)) {
                    commissionRate = "30.00";
                } else {
                    commissionRate = "30.00";
                    incentiveRate = "32.50";
                }
            } else {
                if (passenger <= 10) {
                    if (rtoState.equalsIgnoreCase(HARYANA) || rtoState.equalsIgnoreCase(RAJASTHAN)) {
                        commissionRate = "10.00";
                    } else {
                        commissionRate = "10.00";
                        incentiveRate = "10.00";
                    }
                } else if (passenger > 10 && passenger <= 20) {
                    if (rtoState.equalsIgnoreCase(TAMIL_NADU) || rtoState.equalsIgnoreCase(KARNATAKA)) {
                        commissionRate = "10.00";
                    } else {
                        commissionRate = "10.00";
                        incentiveRate = "10.00";
                    }
                } else if (passenger > 20 && passenger <= 30) {
                    if (rtoState.equalsIgnoreCase(TAMIL_NADU) || rtoState.equalsIgnoreCase(MADHYA_PRADESH) || rtoState.equalsIgnoreCase(UTTAR_PRADESH)) {
                        commissionRate = "7.50";
                    } else {
                        commissionRate = "7.50";
                        incentiveRate = "2.50";
                    }
                } else if (passenger > 30) {
                    commissionRate = "5.00";
                }
            }
        } else if (type.equalsIgnoreCase(THREE_WHEELER_PCV)) {
            if (rtoState.equalsIgnoreCase(KERALA) || rtoState.equalsIgnoreCase(MADHYA_PRADESH) || rtoState.equalsIgnoreCase(TAMIL_NADU)) {
                commissionRate = "25.00";
            } else {
                commissionRate = "25.00";
                incentiveRate = "12.50";
            }
        } else if (type.equalsIgnoreCase(FOUR_WHEELER_PCV)) {
            if (rtoState.equalsIgnoreCase(HARYANA) || rtoState.equalsIgnoreCase(KARNATAKA) || rtoState.equalsIgnoreCase(RAJASTHAN) || rtoState.equalsIgnoreCase(TAMIL_NADU) || rtoState.equalsIgnoreCase(UTTAR_PRADESH) || rtoState.equalsIgnoreCase(MADHYA_PRADESH)) {
                commissionRate = "15.00";
            } else {
                commissionRate = "15.00";
                incentiveRate = "10.00";
            }
        }

        payout[0] = Double.toString((Double.parseDouble(commissionRate) / 100.00) * Double.parseDouble(netPremium));
        payout[1] = " ( ".concat(commissionRate).concat(" % of Net Premium )");
        payout[2] = Double.toString((Double.parseDouble(incentiveRate) / 100.00) * Double.parseDouble(netPremium));
        ;
        payout[3] = " ( ".concat(incentiveRate).concat(" % of Net Premium )");
        payout[4] = portalChargesRate;
        payout[5] = " ( Fixed Charges )";
        payout[6] = Double.toString((Double.parseDouble(portalIncentiveRate) / 100.00) * Double.parseDouble(netPremium));
        ;
        payout[7] = " ( ".concat(portalIncentiveRate).concat(" % of Net Premium )");

        return payout;
    }

    public static long convertStringToCalenderObject(String dateString) {
        long output = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = sdf.parse(dateString);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            output = calendar.getTimeInMillis();
        } catch (ParseException e) {

        }
        return output;
    }

    public static void deleteLayoutAndView(LinearLayout linearLayout) {
        ViewGroup parentLayout = (ViewGroup) linearLayout.getParent();
        View nextView = parentLayout.getChildAt(parentLayout.indexOfChild(linearLayout) + 1);
        parentLayout.removeView(linearLayout);
        parentLayout.removeView(nextView);
    }

    public static void deleteLayout(LinearLayout linearLayout) {
        ViewGroup parentLayout = (ViewGroup) linearLayout.getParent();
        View nextView = parentLayout.getChildAt(parentLayout.indexOfChild(linearLayout) + 1);
        parentLayout.removeView(linearLayout);
    }

    public static String loadJSONFromAsset(Context context, String filename) {
        String json = null;
        try {
            AssetManager assetManager = context.getAssets();
            InputStream is = assetManager.open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private static ArrayList<String> calculateDailyCashPremium(String type, ArrayList<Integer> ageArrayList, String memberAge, String floater_si, String product, String dailyCashAllowance) {
        ArrayList<String> output = new ArrayList<>();
        String dailyCashAllowancePremium = "0.00";
        String dailyCashAllowanceAmount = "0.00";
        if (product.equalsIgnoreCase(FAMILY_MEDICARE_POLICY)) {
            if (type.equalsIgnoreCase(FLOATER)) {
                int maxAge = Collections.max(ageArrayList);
                if (maxAge <= 50) {
                    if (Double.parseDouble(floater_si) <= 500000) {
                        dailyCashAllowancePremium = "400.00";
                        dailyCashAllowanceAmount = "500.00";
                    } else if (Double.parseDouble(floater_si) > 500000 && Double.parseDouble(floater_si) <= 1500000) {
                        dailyCashAllowancePremium = "800.00";
                        dailyCashAllowanceAmount = "1000.00";
                    } else {
                        dailyCashAllowancePremium = "1600.00";
                        dailyCashAllowanceAmount = "2000.00";
                    }
                } else if (maxAge > 50 && maxAge <= 60) {
                    if (Double.parseDouble(floater_si) <= 500000) {
                        dailyCashAllowancePremium = "500.00";
                        dailyCashAllowanceAmount = "500.00";
                    } else if (Double.parseDouble(floater_si) > 500000 && Double.parseDouble(floater_si) <= 1500000) {
                        dailyCashAllowancePremium = "1000.00";
                        dailyCashAllowanceAmount = "1000.00";
                    } else {
                        dailyCashAllowancePremium = "2000.00";
                        dailyCashAllowanceAmount = "2000.00";
                    }
                } else {
                    if (Double.parseDouble(floater_si) <= 500000) {
                        dailyCashAllowancePremium = "600.00";
                        dailyCashAllowanceAmount = "500.00";
                    } else if (Double.parseDouble(floater_si) < 500000 && Double.parseDouble(floater_si) <= 1500000) {
                        dailyCashAllowancePremium = "1200.00";
                        dailyCashAllowanceAmount = "1000.00";
                    } else {
                        dailyCashAllowancePremium = "2400.00";
                        dailyCashAllowanceAmount = "2000.00";
                    }
                }
            } else if (type.equalsIgnoreCase(INDIVIDUAL)) {
                int age = Integer.parseInt(memberAge);
                if (age <= 50) {
                    if (Double.parseDouble(floater_si) <= 500000) {
                        dailyCashAllowancePremium = "300.00";
                        dailyCashAllowanceAmount = "500.00";
                    } else if (Double.parseDouble(floater_si) > 500000 && Double.parseDouble(floater_si) <= 1500000) {
                        dailyCashAllowancePremium = "600.00";
                        dailyCashAllowanceAmount = "1000.00";
                    } else {
                        dailyCashAllowancePremium = "1200.00";
                        dailyCashAllowanceAmount = "2000.00";
                    }
                } else if (age > 50 && age <= 60) {
                    if (Double.parseDouble(floater_si) <= 500000) {
                        dailyCashAllowancePremium = "400.00";
                        dailyCashAllowanceAmount = "500.00";
                    } else if (Double.parseDouble(floater_si) > 500000 && Double.parseDouble(floater_si) <= 1500000) {
                        dailyCashAllowancePremium = "800.00";
                        dailyCashAllowanceAmount = "1000.00";
                    } else {
                        dailyCashAllowancePremium = "1600.00";
                        dailyCashAllowanceAmount = "2000.00";
                    }
                } else {
                    if (Double.parseDouble(floater_si) <= 500000) {
                        dailyCashAllowancePremium = "500.00";
                        dailyCashAllowanceAmount = "500.00";
                    } else if (Double.parseDouble(floater_si) > 500000 && Double.parseDouble(floater_si) <= 1500000) {
                        dailyCashAllowancePremium = "1000.00";
                        dailyCashAllowanceAmount = "1000.00";
                    } else {
                        dailyCashAllowancePremium = "2000.00";
                        dailyCashAllowanceAmount = "2000.00";
                    }
                }
            }
        } else if (product.equalsIgnoreCase(INDIVIDUAL_HEALTH_POLICY)) {
            if (dailyCashAllowance.equalsIgnoreCase(DAILY_CASH_ALLOWANCE_500)) {
                dailyCashAllowancePremium = "70.00";
                dailyCashAllowanceAmount = "500.00";
            } else if (dailyCashAllowance.equalsIgnoreCase(DAILY_CASH_ALLOWANCE_1000)) {
                dailyCashAllowancePremium = "140.00";
                dailyCashAllowanceAmount = "1000.00";
            } else if (dailyCashAllowance.equalsIgnoreCase(DAILY_CASH_ALLOWANCE_2000)) {
                dailyCashAllowancePremium = "280.00";
                dailyCashAllowanceAmount = "2000.00";
            }
        } else if (product.equalsIgnoreCase(YUVAAN_HEALTH_POLICY)) {
            if (dailyCashAllowance.equalsIgnoreCase(DAILY_CASH_ALLOWANCE_500)) {
                dailyCashAllowancePremium = "120.00";
                dailyCashAllowanceAmount = "500.00";
            } else if (dailyCashAllowance.equalsIgnoreCase(DAILY_CASH_ALLOWANCE_1000)) {
                dailyCashAllowancePremium = "240.00";
                dailyCashAllowanceAmount = "1000.00";
            } else if (dailyCashAllowance.equalsIgnoreCase(DAILY_CASH_ALLOWANCE_2000)) {
                dailyCashAllowancePremium = "480.00";
                dailyCashAllowanceAmount = "2000.00";
            }
        } else if (product.equalsIgnoreCase(STUMP)) {
            int age = Integer.parseInt(memberAge);

            if (type.equalsIgnoreCase(FLOATER)) {
                if (Double.parseDouble(floater_si) < 500000) {
                    if (age >= 0 && age <= 35) {
                        dailyCashAllowancePremium = "55.00";
                        dailyCashAllowanceAmount = "500.00";
                    } else if (age >= 36 && age <= 45) {
                        dailyCashAllowancePremium = "73.00";
                        dailyCashAllowanceAmount = "500.00";
                    } else if (age >= 46 && age <= 60) {
                        dailyCashAllowancePremium = "127.00";
                        dailyCashAllowanceAmount = "500.00";
                    } else if (age >= 61 && age <= 65) {
                        dailyCashAllowancePremium = "227.00";
                        dailyCashAllowanceAmount = "500.00";
                    } else if (age >= 66 && age <= 70) {
                        dailyCashAllowancePremium = "309.00";
                        dailyCashAllowanceAmount = "500.00";
                    } else if (age >= 71 && age <= 75) {
                        dailyCashAllowancePremium = "436.00";
                        dailyCashAllowanceAmount = "500.00";
                    } else if (age > 75) {
                        dailyCashAllowancePremium = "545.00";
                        dailyCashAllowanceAmount = "500.00";
                    }
                } else if (Double.parseDouble(floater_si) == 500000) {
                    if (age >= 0 && age <= 35) {
                        dailyCashAllowancePremium = "73.00";
                        dailyCashAllowanceAmount = "1000.00";
                    } else if (age >= 36 && age <= 45) {
                        dailyCashAllowancePremium = "100.00";
                        dailyCashAllowanceAmount = "1000.00";
                    } else if (age >= 46 && age <= 60) {
                        dailyCashAllowancePremium = "182.00";
                        dailyCashAllowanceAmount = "1000.00";
                    } else if (age >= 61 && age <= 65) {
                        dailyCashAllowancePremium = "255.00";
                        dailyCashAllowanceAmount = "1000.00";
                    } else if (age >= 66 && age <= 70) {
                        dailyCashAllowancePremium = "400.00";
                        dailyCashAllowanceAmount = "1000.00";
                    } else if (age >= 71 && age <= 75) {
                        dailyCashAllowancePremium = "491.00";
                        dailyCashAllowanceAmount = "1000.00";
                    } else if (age > 75) {
                        dailyCashAllowancePremium = "582.00";
                        dailyCashAllowanceAmount = "1000.00";
                    }
                } else if (Double.parseDouble(floater_si) > 500000) {
                    if (age >= 0 && age <= 35) {
                        dailyCashAllowancePremium = "91.00";
                        dailyCashAllowanceAmount = "2000.00";
                    } else if (age >= 36 && age <= 45) {
                        dailyCashAllowancePremium = "127.00";
                        dailyCashAllowanceAmount = "2000.00";
                    } else if (age >= 46 && age <= 60) {
                        dailyCashAllowancePremium = "236.00";
                        dailyCashAllowanceAmount = "2000.00";
                    } else if (age >= 61 && age <= 65) {
                        dailyCashAllowancePremium = "309.00";
                        dailyCashAllowanceAmount = "2000.00";
                    } else if (age >= 66 && age <= 70) {
                        dailyCashAllowancePremium = "545.00";
                        dailyCashAllowanceAmount = "2000.00";
                    } else if (age >= 71 && age <= 75) {
                        dailyCashAllowancePremium = "691.00";
                        dailyCashAllowanceAmount = "2000.00";
                    } else if (age > 75) {
                        dailyCashAllowancePremium = "818.00";
                        dailyCashAllowanceAmount = "2000.00";
                    }
                }
            } else if (type.equalsIgnoreCase(INDIVIDUAL)) {

                if (Double.parseDouble(floater_si) < 500000) {
                    if (age >= 0 && age <= 35) {
                        dailyCashAllowancePremium = "9.00";
                        dailyCashAllowanceAmount = "500.00";
                    } else if (age >= 36 && age <= 45) {
                        dailyCashAllowancePremium = "36.00";
                        dailyCashAllowanceAmount = "500.00";
                    } else if (age >= 46 && age <= 60) {
                        dailyCashAllowancePremium = "73.00";
                        dailyCashAllowanceAmount = "500.00";
                    } else if (age >= 61 && age <= 65) {
                        dailyCashAllowancePremium = "127.00";
                        dailyCashAllowanceAmount = "500.00";
                    } else if (age >= 66 && age <= 70) {
                        dailyCashAllowancePremium = "182.00";
                        dailyCashAllowanceAmount = "500.00";
                    } else if (age >= 71 && age <= 75) {
                        dailyCashAllowancePremium = "255.00";
                        dailyCashAllowanceAmount = "500.00";
                    } else if (age > 75) {
                        dailyCashAllowancePremium = "318.00";
                        dailyCashAllowanceAmount = "500.00";
                    }
                } else if (Double.parseDouble(floater_si) == 500000) {
                    if (age >= 0 && age <= 35) {
                        dailyCashAllowancePremium = "18.00";
                        dailyCashAllowanceAmount = "1000.00";
                    } else if (age >= 36 && age <= 45) {
                        dailyCashAllowancePremium = "55.00";
                        dailyCashAllowanceAmount = "1000.00";
                    } else if (age >= 46 && age <= 60) {
                        dailyCashAllowancePremium = "91.00";
                        dailyCashAllowanceAmount = "1000.00";
                    } else if (age >= 61 && age <= 65) {
                        dailyCashAllowancePremium = "209.00";
                        dailyCashAllowanceAmount = "1000.00";
                    } else if (age >= 66 && age <= 70) {
                        dailyCashAllowancePremium = "309.00";
                        dailyCashAllowanceAmount = "1000.00";
                    } else if (age >= 71 && age <= 75) {
                        dailyCashAllowancePremium = "400.00";
                        dailyCashAllowanceAmount = "1000.00";
                    } else if (age > 75) {
                        dailyCashAllowancePremium = "455.00";
                        dailyCashAllowanceAmount = "1000.00";
                    }
                } else if (Double.parseDouble(floater_si) > 500000) {
                    if (age >= 0 && age <= 35) {
                        dailyCashAllowancePremium = "27.00";
                        dailyCashAllowanceAmount = "2000.00";
                    } else if (age >= 36 && age <= 45) {
                        dailyCashAllowancePremium = "82.00";
                        dailyCashAllowanceAmount = "2000.00";
                    } else if (age >= 46 && age <= 60) {
                        dailyCashAllowancePremium = "164.00";
                        dailyCashAllowanceAmount = "2000.00";
                    } else if (age >= 61 && age <= 65) {
                        dailyCashAllowancePremium = "327.00";
                        dailyCashAllowanceAmount = "2000.00";
                    } else if (age >= 66 && age <= 70) {
                        dailyCashAllowancePremium = "473.00";
                        dailyCashAllowanceAmount = "2000.00";
                    } else if (age >= 71 && age <= 75) {
                        dailyCashAllowancePremium = "582.00";
                        dailyCashAllowanceAmount = "2000.00";
                    } else if (age > 75) {
                        dailyCashAllowancePremium = "727.00";
                        dailyCashAllowanceAmount = "2000.00";
                    }
                }
            }

        } else if (product.equalsIgnoreCase(SPECTRA_HEALTH_POLICY)) {
            if (Double.parseDouble(floater_si) <= 500000) {
                dailyCashAllowancePremium = "120.00";
                dailyCashAllowanceAmount = "500.00";
            } else if (Double.parseDouble(floater_si) > 500000 & Double.parseDouble(floater_si) <= 1500000) {
                dailyCashAllowancePremium = "240.00";
                dailyCashAllowanceAmount = "1000.00";
            } else if (Double.parseDouble(floater_si) > 1500000) {
                dailyCashAllowancePremium = "480.00";
                dailyCashAllowanceAmount = "2000.00";
            }
        }
        output.add(dailyCashAllowancePremium);
        output.add(dailyCashAllowanceAmount);
        return output;
    }

    public static ArrayList<HashMap<String, String>> calculateFamilyMedicarePremiumIndividual(String type, String zone, String noOfMembers, String floater_si, String floater_ncd, ArrayList<Map<String, View>> memberDetailsArrayList, Context context, String familyComposition, boolean dailyCashCheckBox, boolean maternityCheckbox, int memberSelectedForMaternity) {
        ArrayList<HashMap<String, String>> output1 = new ArrayList<>();
        ArrayList<Integer> ageArrayList = new ArrayList<>();
        String floaterDiscountPercentage = getFamilyDiscount(type, familyComposition, isAgeBetween40and50(memberDetailsArrayList), FAMILY_MEDICARE_POLICY, noOfMembers);
        String fileName = "";
        String age = "";
        String memberSI = "0.00";
        String memberNCD = "0.00";
        String memberAge = "0.00";
        String age_slab = "0.00";
        String totalBasicPremium = "0.00";
        String totalNCDAmount = "0.00";
        String totalFamilyDiscount = "0.00";
        String totalDailyCashPremium = "0.00";
        String maternityPremium = "0.00";
        if (zone.equalsIgnoreCase(ZONE_A)) {
            fileName = "health/fmp/fmp_zone_a.json";
        } else if (zone.equalsIgnoreCase(ZONE_B)) {
            fileName = "health/fmp/fmp_zone_b.json";
        } else if (zone.equalsIgnoreCase(ZONE_C)) {
            fileName = "health/fmp/fmp_zone_c.json";
        }

        String jsonStr = loadJSONFromAsset(context, fileName);
        if (jsonStr != null) {
            try {
                JSONArray jsonArray = new JSONArray(jsonStr);
                ArrayList<Double> commssionArrayList = new ArrayList<>();

                for (int i = 0; i < memberDetailsArrayList.size(); i++) {
                    Map<String, View> map = memberDetailsArrayList.get(i);
                    int count = 0;
                    for (Iterator<Map.Entry<String, View>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, View> entry = it.next();
                        String s = entry.getKey();
                        View v = entry.getValue();
                        if (s.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_SI)) {
                            if (v instanceof Spinner) {
                                memberSI = ((Spinner) v).getSelectedItem().toString();
                                count = count + 1;
                            }
                        } else if (s.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_NCD_PERCENTAGE)) {
                            if (v instanceof Spinner) {
                                memberNCD = ((Spinner) v).getSelectedItem().toString();
                                count = count + 1;
                            }
                        } else if (s.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_AGE)) {
                            if (v instanceof EditText) {
                                memberAge = ((EditText) v).getText().toString().trim();
                                ageArrayList.add(Integer.parseInt(memberAge));
                                age_slab = getAgeSlab(memberAge, FAMILY_MEDICARE_POLICY);
                                count = count + 1;
                            }
                        }
                        if (count == 3) {
                            HashMap<String, String> map1 = new HashMap<>();
                            for (int k = 0; k < jsonArray.length(); k++) {
                                JSONObject object = jsonArray.getJSONObject(k);
                                String si = object.getString("SI");
                                if (si.equalsIgnoreCase(memberSI)) {

                                    String memberDailyCashPremium = "0.00";
                                    String memberDailyCashAmount = "0.00";
                                    String basicPremium = object.getString(age_slab);
                                    String memberNCDAmount = Double.toString(Double.parseDouble(memberNCD) / 100.00 * Double.parseDouble(basicPremium));
                                    String familyDiscountPercentage = getFamilyDiscount(type, familyComposition, isAgeBetween40and50(memberDetailsArrayList), FAMILY_MEDICARE_POLICY, noOfMembers);
                                    String familyDiscountAmount = Double.toString(Double.parseDouble(familyDiscountPercentage) / 100.00 * (Double.parseDouble(basicPremium) - Double.parseDouble(memberNCDAmount)));
                                    String premiumForTheMember = Double.toString(Double.parseDouble(basicPremium) - Double.parseDouble(memberNCDAmount) - Double.parseDouble(familyDiscountAmount));

                                    String dailyCashAllowanceCommissionAmount = "0.00";

                                    if (dailyCashCheckBox) {
                                        ArrayList<String> arrayList = calculateDailyCashPremium(type, ageArrayList, memberAge, memberSI, FAMILY_MEDICARE_POLICY, "");
                                        for (int j = 0; j < arrayList.size(); j++) {
                                            memberDailyCashPremium = arrayList.get(j);
                                            memberDailyCashAmount = arrayList.get(j + 1);
                                            dailyCashAllowanceCommissionAmount = calculateCommission(zone, memberDailyCashPremium, Integer.toString(Collections.max(ageArrayList)), FAMILY_MEDICARE_POLICY, false);
                                            commssionArrayList.add(Double.parseDouble(dailyCashAllowanceCommissionAmount));
                                            break;
                                        }
                                    }
                                    String commissionForTheMember = calculateCommission(zone, premiumForTheMember, memberAge, FAMILY_MEDICARE_POLICY, false);
                                    commssionArrayList.add(Double.parseDouble(commissionForTheMember));

                                    if (maternityCheckbox) {
                                        if (i == memberSelectedForMaternity) {
                                            maternityPremium = calculateMaternityPremium(memberSI);
                                        }

                                        String maternityCommissionAmount = calculateCommission(zone, maternityPremium, memberAge, INDIVIDUAL_HEALTH_POLICY, false);
                                        commssionArrayList.add((Double.parseDouble(maternityCommissionAmount)));

                                    }
                                    map1.put(CommonFunctions.INTENT_MEMBER_AGE, memberAge);
                                    map1.put(CommonFunctions.INTENT_MEMBER_SI, memberSI);
                                    map1.put(CommonFunctions.INTENT_MEMBER_NCD_PERCENTAGE, memberNCD);
                                    map1.put(CommonFunctions.INTENT_MEMBER_BASIC_PREMIUM, basicPremium);
                                    map1.put(CommonFunctions.INTENT_MEMBER_NCD_AMOUNT, memberNCDAmount);
                                    map1.put(CommonFunctions.INTENT_MEMBER_FAMILY_DISCOUNT, familyDiscountAmount);
                                    map1.put(CommonFunctions.INTENT_MEMBER_NET_PREMIUM, premiumForTheMember);
                                    map1.put(CommonFunctions.INTENT_MEMBER_COMMISSION, commissionForTheMember);
                                    map1.put(CommonFunctions.INTENT_TOTAL_DAILY_CASH_PREMIUM, memberDailyCashPremium);
                                    map1.put(CommonFunctions.INTENT_MEMBER_DAILY_CASH_AMOUNT, memberDailyCashAmount);
                                    output1.add(map1);
                                    totalBasicPremium = Double.toString(Double.parseDouble(totalBasicPremium) + Double.parseDouble(basicPremium));
                                    totalNCDAmount = Double.toString(Double.parseDouble(totalNCDAmount) + Double.parseDouble(memberNCDAmount));
                                    totalFamilyDiscount = Double.toString(Double.parseDouble(totalFamilyDiscount) + Double.parseDouble(familyDiscountAmount));
                                    totalDailyCashPremium = Double.toString(Double.parseDouble(totalDailyCashPremium) + Double.parseDouble(memberDailyCashPremium));
                                }
                            }
                        }
                    }
                }


                HashMap<String, String> map1 = new HashMap<>();
                map1.put(INTENT_TOTAL_BASIC_PREMIUM, totalBasicPremium);
                map1.put(INTENT_TOTAL_NCD_AMOUNT, totalNCDAmount);
                map1.put(INTENT_TOTAL_FAMILY_DISCOUNT, totalFamilyDiscount);
                map1.put(INTENT_TOTAL_DAILY_CASH_PREMIUM, totalDailyCashPremium);
                map1.put(INTENT_TOTAL_MATERNITY_PREMIUM, maternityPremium);
                String totalGrossPremiumBeforeAddOns = Double.toString(Double.parseDouble(totalBasicPremium) - Double.parseDouble(totalNCDAmount) - Double.parseDouble(totalFamilyDiscount));
                String totalGrossPremiumAfterAddOns = Double.toString(Double.parseDouble(totalGrossPremiumBeforeAddOns) + Double.parseDouble(totalDailyCashPremium) + Double.parseDouble(maternityPremium));
                map1.put(INTENT_TOTAL_GROSS_PREMIUM, totalGrossPremiumBeforeAddOns);
                String gst = Double.toString(GST_0 / 100.00 * Double.parseDouble(totalGrossPremiumAfterAddOns));
                String netPremium = Double.toString(Double.parseDouble(totalGrossPremiumAfterAddOns) + Double.parseDouble(gst));
                map1.put(INTENT_TOTAL_GST, gst);
                map1.put(INTENT_TOTAL_NET_PREMIUM, netPremium);
                String totalCommission = sumOfDoubleArrayList(commssionArrayList);

                String incentive = "0.00";
                String portalCharges = "50.00";
                String portalIncentive = Double.toString(0.25 / 100 * Double.parseDouble(totalGrossPremiumAfterAddOns));
                String commissionString = "Approx Commission : ".concat(uptoTwoDecimal(totalCommission)).concat("\nApprox Incentive : ").concat(uptoTwoDecimal(incentive)).concat("\nPortal Charges : ").concat(uptoTwoDecimal(portalCharges)).concat("\nPortal Incentive : ").concat(uptoTwoDecimal(portalIncentive));

                map1.put(INTENT_TOTAL_COMMISSION, commissionString);
                output1.add(map1);


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return output1;
    }

    public static ArrayList<HashMap<String, String>> calculateSpectraPremiumIndividual(String type, String zone, String noOfMembers, String floater_si, String floater_ncd, ArrayList<Map<String, View>> memberDetailsArrayList, Context context, String familyComposition, boolean dailyCashCheckBox, boolean maternityCheckbox) {
        ArrayList<HashMap<String, String>> output1 = new ArrayList<>();
        ArrayList<Integer> ageArrayList = new ArrayList<>();
        String floaterDiscountPercentage = getFamilyDiscount(type, familyComposition, isAgeBetween40and50(memberDetailsArrayList), SPECTRA_HEALTH_POLICY, noOfMembers);
        String fileName = "";
        String age = "";
        String memberSI = "0.00";
        String memberNCD = "0.00";
        String memberAge = "0.00";
        String age_slab = "0.00";
        String totalBasicPremium = "0.00";
        String totalNCDAmount = "0.00";
        String totalFamilyDiscount = "0.00";
        String totalDailyCashPremium = "0.00";
        if (zone.equalsIgnoreCase(ZONE_A)) {
            fileName = "health/fmp/fmp_zone_a.json";
        } else if (zone.equalsIgnoreCase(ZONE_B)) {
            fileName = "health/fmp/fmp_zone_b.json";
        } else if (zone.equalsIgnoreCase(ZONE_C)) {
            fileName = "health/fmp/fmp_zone_c.json";
        }

        String jsonStr = loadJSONFromAsset(context, fileName);
        if (jsonStr != null) {
            try {
                JSONArray jsonArray = new JSONArray(jsonStr);
                ArrayList<Double> commssionArrayList = new ArrayList<>();
                int memberSelectedForMaternity = 0;
                String maternityPremium = "0.00";
                if (maternityCheckbox) {
                    if (familyComposition.equalsIgnoreCase(ONE_ADULT)) {
                        memberSelectedForMaternity = 0;
                    } else if (familyComposition.equalsIgnoreCase(ONE_ADULT_ANY_CHILD)) {
                        memberSelectedForMaternity = 0;
                    } else if (familyComposition.equalsIgnoreCase(TWO_ADULT)) {
                        memberSelectedForMaternity = 1;
                    } else if (familyComposition.equalsIgnoreCase(TWO_ADULT_ANY_CHILD)) {
                        memberSelectedForMaternity = 1;
                    }
                }

                for (int i = 0; i < memberDetailsArrayList.size(); i++) {
                    Map<String, View> map = memberDetailsArrayList.get(i);
                    int count = 0;
                    for (Iterator<Map.Entry<String, View>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, View> entry = it.next();
                        String s = entry.getKey();
                        View v = entry.getValue();
                        if (s.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_SI)) {
                            if (v instanceof Spinner) {
                                memberSI = ((Spinner) v).getSelectedItem().toString();
                                count = count + 1;
                            }
                        } else if (s.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_NCD_PERCENTAGE)) {
                            if (v instanceof Spinner) {
                                memberNCD = ((Spinner) v).getSelectedItem().toString();
                                count = count + 1;
                            }
                        } else if (s.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_AGE)) {
                            if (v instanceof EditText) {
                                memberAge = ((EditText) v).getText().toString().trim();
                                ageArrayList.add(Integer.parseInt(memberAge));
                                age_slab = getAgeSlab(memberAge, FAMILY_MEDICARE_POLICY);
                                count = count + 1;
                            }
                        }
                        if (count == 3) {
                            HashMap<String, String> map1 = new HashMap<>();
                            for (int k = 0; k < jsonArray.length(); k++) {
                                JSONObject object = jsonArray.getJSONObject(k);
                                String si = object.getString("SI");
                                if (si.equalsIgnoreCase(memberSI)) {

                                    String memberDailyCashPremium = "0.00";
                                    String memberDailyCashAmount = "0.00";
                                    String basicPremium = object.getString(age_slab);
                                    String memberNCDAmount = Double.toString(Double.parseDouble(memberNCD) / 100.00 * Double.parseDouble(basicPremium));
                                    String familyDiscountPercentage = getFamilyDiscount(type, familyComposition, isAgeBetween40and50(memberDetailsArrayList), SPECTRA_HEALTH_POLICY, noOfMembers);
                                    String familyDiscountAmount = Double.toString(Double.parseDouble(familyDiscountPercentage) / 100.00 * (Double.parseDouble(basicPremium) - Double.parseDouble(memberNCDAmount)));
                                    String premiumForTheMember = Double.toString(Double.parseDouble(basicPremium) - Double.parseDouble(memberNCDAmount) - Double.parseDouble(familyDiscountAmount));

                                    String dailyCashAllowanceCommissionAmount = "0.00";

                                    if (dailyCashCheckBox) {
                                        ArrayList<String> arrayList = calculateDailyCashPremium(type, ageArrayList, memberAge, memberSI, FAMILY_MEDICARE_POLICY, "");
                                        for (int j = 0; j < arrayList.size(); j++) {
                                            memberDailyCashPremium = arrayList.get(j);
                                            memberDailyCashAmount = arrayList.get(j + 1);
                                            dailyCashAllowanceCommissionAmount = calculateCommission(zone, memberDailyCashPremium, Integer.toString(Collections.max(ageArrayList)), FAMILY_MEDICARE_POLICY, false);
                                            commssionArrayList.add(Double.parseDouble(dailyCashAllowanceCommissionAmount));
                                            break;
                                        }
                                    }
                                    String commissionForTheMember = calculateCommission(zone, premiumForTheMember, memberAge, FAMILY_MEDICARE_POLICY, false);
                                    commssionArrayList.add(Double.parseDouble(commissionForTheMember));

                                    if (maternityCheckbox) {

                                        if (i == memberSelectedForMaternity) {
                                            if (memberSI.equalsIgnoreCase(SI_350000)) {
                                                maternityPremium = "12000.00";
                                            } else if (memberSI.equalsIgnoreCase(SI_400000)) {
                                                maternityPremium = "13750.00";
                                            } else if (memberSI.equalsIgnoreCase(SI_450000)) {
                                                maternityPremium = "15500.00";
                                            } else if (memberSI.equalsIgnoreCase(SI_500000)) {
                                                maternityPremium = "17000.00";
                                            } else if (memberSI.equalsIgnoreCase(SI_600000)) {
                                                maternityPremium = "20350.00";
                                            } else if (memberSI.equalsIgnoreCase(SI_700000)) {
                                                maternityPremium = "20600.00";
                                            } else if (memberSI.equalsIgnoreCase(SI_800000)) {
                                                maternityPremium = "20850.00";
                                            } else if (memberSI.equalsIgnoreCase(SI_900000)) {
                                                maternityPremium = "21000.00";
                                            } else if (memberSI.equalsIgnoreCase(SI_1000000)) {
                                                maternityPremium = "21200.00";
                                            } else if (memberSI.equalsIgnoreCase(SI_1500000)) {
                                                maternityPremium = "22000.00";
                                            } else if (memberSI.equalsIgnoreCase(SI_2000000)) {
                                                maternityPremium = "23000.00";
                                            } else if (memberSI.equalsIgnoreCase(SI_2500000)) {
                                                maternityPremium = "23500.00";
                                            } else {
                                                maternityPremium = "0.00";
                                            }

                                            String maternityCommissionAmount = calculateCommission(zone, maternityPremium, memberAge, INDIVIDUAL_HEALTH_POLICY, false);
                                            commssionArrayList.add((Double.parseDouble(maternityCommissionAmount)));
                                        }
                                    }
                                    map1.put(CommonFunctions.INTENT_MEMBER_AGE, memberAge);
                                    map1.put(CommonFunctions.INTENT_MEMBER_SI, memberSI);
                                    map1.put(CommonFunctions.INTENT_MEMBER_NCD_PERCENTAGE, memberNCD);
                                    map1.put(CommonFunctions.INTENT_MEMBER_BASIC_PREMIUM, basicPremium);
                                    map1.put(CommonFunctions.INTENT_MEMBER_NCD_AMOUNT, memberNCDAmount);
                                    map1.put(CommonFunctions.INTENT_MEMBER_FAMILY_DISCOUNT, familyDiscountAmount);
                                    map1.put(CommonFunctions.INTENT_MEMBER_NET_PREMIUM, premiumForTheMember);
                                    map1.put(CommonFunctions.INTENT_MEMBER_COMMISSION, commissionForTheMember);
                                    map1.put(CommonFunctions.INTENT_TOTAL_DAILY_CASH_PREMIUM, memberDailyCashPremium);
                                    map1.put(CommonFunctions.INTENT_MEMBER_DAILY_CASH_AMOUNT, memberDailyCashAmount);
                                    output1.add(map1);
                                    totalBasicPremium = Double.toString(Double.parseDouble(totalBasicPremium) + Double.parseDouble(basicPremium));
                                    totalNCDAmount = Double.toString(Double.parseDouble(totalNCDAmount) + Double.parseDouble(memberNCDAmount));
                                    totalFamilyDiscount = Double.toString(Double.parseDouble(totalFamilyDiscount) + Double.parseDouble(familyDiscountAmount));
                                    totalDailyCashPremium = Double.toString(Double.parseDouble(totalDailyCashPremium) + Double.parseDouble(memberDailyCashPremium));
                                }
                            }
                        }
                    }
                }


                HashMap<String, String> map1 = new HashMap<>();
                map1.put(INTENT_TOTAL_BASIC_PREMIUM, totalBasicPremium);
                map1.put(INTENT_TOTAL_NCD_AMOUNT, totalNCDAmount);
                map1.put(INTENT_TOTAL_FAMILY_DISCOUNT, totalFamilyDiscount);
                map1.put(INTENT_TOTAL_DAILY_CASH_PREMIUM, totalDailyCashPremium);
                map1.put(INTENT_TOTAL_MATERNITY_PREMIUM, maternityPremium);
                String totalGrossPremiumBeforeAddOns = Double.toString(Double.parseDouble(totalBasicPremium) - Double.parseDouble(totalNCDAmount) - Double.parseDouble(totalFamilyDiscount));
                String totalGrossPremiumAfterAddOns = Double.toString(Double.parseDouble(totalGrossPremiumBeforeAddOns) + Double.parseDouble(totalDailyCashPremium) + Double.parseDouble(maternityPremium));
                map1.put(INTENT_TOTAL_GROSS_PREMIUM, totalGrossPremiumBeforeAddOns);
                String gst = Double.toString(GST_0 / 100.00 * Double.parseDouble(totalGrossPremiumAfterAddOns));
                String netPremium = Double.toString(Double.parseDouble(totalGrossPremiumAfterAddOns) + Double.parseDouble(gst));
                map1.put(INTENT_TOTAL_GST, gst);
                map1.put(INTENT_TOTAL_NET_PREMIUM, netPremium);
                String totalCommission = sumOfDoubleArrayList(commssionArrayList);

                String incentive = "0.00";
                String portalCharges = "50.00";
                String portalIncentive = Double.toString(0.25 / 100 * Double.parseDouble(totalGrossPremiumAfterAddOns));
                String commissionString = "Approx Commission : ".concat(uptoTwoDecimal(totalCommission)).concat("\nApprox Incentive : ").concat(uptoTwoDecimal(incentive)).concat("\nPortal Charges : ").concat(uptoTwoDecimal(portalCharges)).concat("\nPortal Incentive : ").concat(uptoTwoDecimal(portalIncentive));

                map1.put(INTENT_TOTAL_COMMISSION, commissionString);
                output1.add(map1);


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return output1;
    }


    public static ArrayList<HashMap<String, String>> calculateYuvaanHealthPremiumIndividual(String type, String zone, String noOfMembers, String floater_si, String floater_ncd, ArrayList<Map<String, View>> memberDetailsArrayList, Context context, String familyComposition, boolean dailyCashCheckBox, boolean coPaymentWaiverCheckbox, String dailyCashAllowanceAmount) {
        ArrayList<HashMap<String, String>> output1 = new ArrayList<>();
        ArrayList<Integer> ageArrayList = new ArrayList<>();
        String floaterDiscountPercentage = getFamilyDiscount(type, familyComposition, isAgeBetween40and50(memberDetailsArrayList), YUVAAN_HEALTH_POLICY, noOfMembers);
        String fileName = "";
        String age = "";
        String memberSI = "0.00";
        String memberNCD = "0.00";
        String memberAge = "0.00";
        String age_slab = "0.00";
        String totalBasicPremium = "0.00";
        String totalNCDAmount = "0.00";
        String totalFamilyDiscount = "0.00";
        String totalDailyCashPremium = "0.00";

        if (coPaymentWaiverCheckbox) {
            fileName = "health/yuvaan/yuvaan_zone_a.json";
        } else {
            if (zone.equalsIgnoreCase(ZONE_A)) {
                fileName = "health/yuvaan/yuvaan_zone_a.json";
            } else if (zone.equalsIgnoreCase(ZONE_B)) {
                fileName = "health/yuvaan/yuvaan_zone_b.json";
            } else if (zone.equalsIgnoreCase(ZONE_C)) {
                fileName = "health/yuvaan/yuvaan_zone_c.json";
            }
        }


        String jsonStr = loadJSONFromAsset(context, fileName);
        if (jsonStr != null) {
            try {
                JSONArray jsonArray = new JSONArray(jsonStr);
                ArrayList<Double> commssionArrayList = new ArrayList<>();
                for (int i = 0; i < memberDetailsArrayList.size(); i++) {
                    Map<String, View> map = memberDetailsArrayList.get(i);
                    int count = 0;
                    for (Iterator<Map.Entry<String, View>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, View> entry = it.next();
                        String s = entry.getKey();
                        View v = entry.getValue();
                        if (s.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_SI)) {
                            if (v instanceof Spinner) {
                                memberSI = ((Spinner) v).getSelectedItem().toString();
                                count = count + 1;
                            }
                        } else if (s.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_NCD_PERCENTAGE)) {
                            if (v instanceof Spinner) {
                                memberNCD = ((Spinner) v).getSelectedItem().toString();
                                count = count + 1;
                            }
                        } else if (s.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_AGE)) {
                            if (v instanceof EditText) {
                                memberAge = ((EditText) v).getText().toString().trim();
                                ageArrayList.add(Integer.parseInt(memberAge));
                                age_slab = getAgeSlab(memberAge, YUVAAN_HEALTH_POLICY);
                                count = count + 1;
                            }
                        }
                        if (count == 3) {
                            HashMap<String, String> map1 = new HashMap<>();
                            for (int k = 0; k < jsonArray.length(); k++) {
                                JSONObject object = jsonArray.getJSONObject(k);
                                String si = object.getString("SI");
                                if (si.equalsIgnoreCase(memberSI)) {

                                    String memberDailyCashPremium = "0.00";
                                    String memberDailyCashAmount = "0.00";
                                    String basicPremium = object.getString(age_slab);
                                    String memberNCDAmount = Double.toString(Double.parseDouble(memberNCD) / 100.00 * Double.parseDouble(basicPremium));
                                    String familyDiscountPercentage = getFamilyDiscount(type, familyComposition, isAgeBetween40and50(memberDetailsArrayList), YUVAAN_HEALTH_POLICY, noOfMembers);
                                    String familyDiscountAmount = Double.toString(Double.parseDouble(familyDiscountPercentage) / 100.00 * (Double.parseDouble(basicPremium) - Double.parseDouble(memberNCDAmount)));
                                    String premiumForTheMember = Double.toString(Double.parseDouble(basicPremium) - Double.parseDouble(memberNCDAmount) - Double.parseDouble(familyDiscountAmount));

                                    String dailyCashAllowanceCommissionAmount = "0.00";

                                    if (dailyCashCheckBox) {
                                        ArrayList<String> arrayList = calculateDailyCashPremium(type, ageArrayList, memberAge, memberSI, YUVAAN_HEALTH_POLICY, dailyCashAllowanceAmount);
                                        for (int j = 0; j < arrayList.size(); j++) {
                                            memberDailyCashPremium = arrayList.get(j);
                                            memberDailyCashAmount = arrayList.get(j + 1);
                                            dailyCashAllowanceCommissionAmount = calculateCommission(zone, memberDailyCashPremium, Integer.toString(Collections.max(ageArrayList)), YUVAAN_HEALTH_POLICY, false);
                                            commssionArrayList.add(Double.parseDouble(dailyCashAllowanceCommissionAmount));
                                            break;
                                        }
                                    }
                                    String commissionForTheMember = calculateCommission(zone, premiumForTheMember, memberAge, YUVAAN_HEALTH_POLICY, false);
                                    commssionArrayList.add(Double.parseDouble(commissionForTheMember));

                                    map1.put(CommonFunctions.INTENT_MEMBER_AGE, memberAge);
                                    map1.put(CommonFunctions.INTENT_MEMBER_SI, memberSI);
                                    map1.put(CommonFunctions.INTENT_MEMBER_NCD_PERCENTAGE, memberNCD);
                                    map1.put(CommonFunctions.INTENT_MEMBER_BASIC_PREMIUM, basicPremium);
                                    map1.put(CommonFunctions.INTENT_MEMBER_NCD_AMOUNT, memberNCDAmount);
                                    map1.put(CommonFunctions.INTENT_MEMBER_FAMILY_DISCOUNT, familyDiscountAmount);
                                    map1.put(CommonFunctions.INTENT_MEMBER_NET_PREMIUM, premiumForTheMember);
                                    map1.put(CommonFunctions.INTENT_MEMBER_COMMISSION, commissionForTheMember);
                                    map1.put(CommonFunctions.INTENT_TOTAL_DAILY_CASH_PREMIUM, memberDailyCashPremium);
                                    map1.put(CommonFunctions.INTENT_MEMBER_DAILY_CASH_AMOUNT, memberDailyCashAmount);
                                    output1.add(map1);
                                    totalBasicPremium = Double.toString(Double.parseDouble(totalBasicPremium) + Double.parseDouble(basicPremium));
                                    totalNCDAmount = Double.toString(Double.parseDouble(totalNCDAmount) + Double.parseDouble(memberNCDAmount));
                                    totalFamilyDiscount = Double.toString(Double.parseDouble(totalFamilyDiscount) + Double.parseDouble(familyDiscountAmount));
                                    totalDailyCashPremium = Double.toString(Double.parseDouble(totalDailyCashPremium) + Double.parseDouble(memberDailyCashPremium));
                                }
                            }
                        }
                    }
                }


                HashMap<String, String> map1 = new HashMap<>();
                map1.put(INTENT_TOTAL_BASIC_PREMIUM, totalBasicPremium);
                map1.put(INTENT_TOTAL_NCD_AMOUNT, totalNCDAmount);
                map1.put(INTENT_TOTAL_FAMILY_DISCOUNT, totalFamilyDiscount);
                map1.put(INTENT_TOTAL_DAILY_CASH_PREMIUM, totalDailyCashPremium);
                String totalGrossPremium = Double.toString(Double.parseDouble(totalBasicPremium) - Double.parseDouble(totalNCDAmount) - Double.parseDouble(totalFamilyDiscount));
                String totalGrossPremiumAfterAddOns = Double.toString(Double.parseDouble(totalGrossPremium) + Double.parseDouble(totalDailyCashPremium));
                map1.put(INTENT_TOTAL_GROSS_PREMIUM, totalGrossPremiumAfterAddOns);
                String gst = Double.toString(GST_0 / 100.00 * Double.parseDouble(totalGrossPremiumAfterAddOns));
                String netPremium = Double.toString(Double.parseDouble(totalGrossPremiumAfterAddOns) + Double.parseDouble(gst));
                map1.put(INTENT_TOTAL_GST, gst);
                map1.put(INTENT_TOTAL_NET_PREMIUM, netPremium);
                String totalCommission = sumOfDoubleArrayList(commssionArrayList);

                String incentive = "0.00";
                String portalCharges = "50.00";
                String portalIncentive = Double.toString(0.25 / 100 * Double.parseDouble(totalGrossPremiumAfterAddOns));
                String commissionString = "Approx Commission : ".concat(uptoTwoDecimal(totalCommission)).concat("\nApprox Incentive : ").concat(uptoTwoDecimal(incentive)).concat("\nPortal Charges : ").concat(uptoTwoDecimal(portalCharges)).concat("\nPortal Incentive : ").concat(uptoTwoDecimal(portalIncentive));

                map1.put(INTENT_TOTAL_COMMISSION, commissionString);
                output1.add(map1);


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return output1;
    }

    private static String calculateCommission(String zone, String premiumForTheMember, String age, String product, boolean stringStatementRequired) {
        String commission = "0.00";
        String incentive = "0.00";
        String portalCharges = "50.00";
        String portalIncentive = "0.25";
        String output = "";
        Double ageDouble = Double.parseDouble(age);

        if (product.equalsIgnoreCase(FAMILY_MEDICARE_POLICY) || product.equalsIgnoreCase(INDIVIDUAL_HEALTH_POLICY)) {
            if (zone.equalsIgnoreCase(ZONE_A)) {
                if (ageDouble >= 0 && ageDouble <= 45) {
                    commission = "7.50";
                } else if (ageDouble > 45 && ageDouble <= 60) {
                    commission = "7.50";
                } else {
                    commission = "3.00";
                }
            } else if (zone.equalsIgnoreCase(ZONE_B)) {
                if (ageDouble >= 0 && ageDouble <= 45) {
                    commission = "20.00";
                } else if (ageDouble > 45 && ageDouble <= 60) {
                    commission = "15.00";
                } else {
                    commission = "5.00";
                }
            } else if (zone.equalsIgnoreCase(ZONE_C)) {
                if (ageDouble >= 0 && ageDouble <= 45) {
                    commission = "20.00";
                } else if (ageDouble > 45 && ageDouble <= 60) {
                    commission = "15.00";
                } else {
                    commission = "5.00";
                }
            }

            Double commissionDouble = Double.parseDouble(commission);
            Double premiumForTheMemberDouble = Double.parseDouble(premiumForTheMember);
            Double commissionAmountDouble = commissionDouble / 100.00 * premiumForTheMemberDouble;
            output = Double.toString(commissionAmountDouble);

        } else if (product.equalsIgnoreCase(YUVAAN_HEALTH_POLICY)) {
            if (zone.equalsIgnoreCase(ZONE_A)) {
                if (ageDouble >= 0 && ageDouble <= 45) {
                    commission = "10.00";
                } else if (ageDouble > 45 && ageDouble <= 60) {
                    commission = "10.00";
                } else {
                    commission = "10.00";
                }
            } else if (zone.equalsIgnoreCase(ZONE_B)) {
                if (ageDouble >= 0 && ageDouble <= 45) {
                    commission = "20.00";
                } else if (ageDouble > 45 && ageDouble <= 60) {
                    commission = "20.00";
                } else {
                    commission = "20.00";
                }
            } else if (zone.equalsIgnoreCase(ZONE_C)) {
                if (ageDouble >= 0 && ageDouble <= 45) {
                    commission = "25.00";
                } else if (ageDouble > 45 && ageDouble <= 60) {
                    commission = "25.00";
                } else {
                    commission = "25.00";
                }
            }

            Double commissionDouble = Double.parseDouble(commission);
            Double premiumForTheMemberDouble = Double.parseDouble(premiumForTheMember);
            Double commissionAmountDouble = commissionDouble / 100.00 * premiumForTheMemberDouble;
            output = Double.toString(commissionAmountDouble);

        } else if (product.equalsIgnoreCase(STUMP)) {
            if (zone.equalsIgnoreCase(ZONE_A)) {
                if (ageDouble >= 0 && ageDouble <= 45) {
                    commission = "20.00";
                } else if (ageDouble > 45 && ageDouble <= 60) {
                    commission = "15.00";
                } else if (ageDouble > 60) {
                    commission = "3.00";
                }
            } else if (zone.equalsIgnoreCase(ZONE_B)) {
                if (ageDouble >= 0 && ageDouble <= 45) {
                    commission = "30.00";
                } else if (ageDouble > 45 && ageDouble <= 60) {
                    commission = "20.00";
                } else if (ageDouble > 60) {
                    commission = "5.00";
                }
            } else if (zone.equalsIgnoreCase(ZONE_C)) {
                if (ageDouble >= 0 && ageDouble <= 45) {
                    commission = "30.00";
                } else if (ageDouble > 45 && ageDouble <= 60) {
                    commission = "20.00";
                } else if (ageDouble > 60) {
                    commission = "5.00";
                }
            }

            String commissionAmount = Double.toString(Double.parseDouble(commission) / 100.00 * Double.parseDouble(premiumForTheMember));
            String portalIncentiveAmount1 = Double.toString(Double.parseDouble(portalIncentive) / 100.00 * Double.parseDouble(premiumForTheMember));

            if (stringStatementRequired) {
                output = "Approx Commission : ".concat(uptoTwoDecimal(commissionAmount)).concat("\nApprox Incentive : ").concat(uptoTwoDecimal(incentive)).concat("\nPortal Charges : ").concat(uptoTwoDecimal(portalCharges)).concat("\nPortal Incentive : ").concat(uptoTwoDecimal(portalIncentiveAmount1));
                return output;

            } else {
                output = commissionAmount;
            }
        } else if (product.equalsIgnoreCase(UNI_CRITI_CARE_HEALTH_POLICY)) {
            commission = "25.00";
        } else if (product.equalsIgnoreCase(SPECTRA_HEALTH_POLICY)) {
            commission = "5.00";
        }
        double commissionDouble = Double.parseDouble(commission);
        double premiumForTheMemberDouble = Double.parseDouble(premiumForTheMember);
        double commissionAmountDouble = commissionDouble / 100.00 * premiumForTheMemberDouble;
        output = Double.toString(commissionAmountDouble);
        return output;
    }

    private static boolean isAgeBetween40and50(ArrayList<Map<String, View>> memberDetailsArrayList) {
        boolean isAgeBetween40and50 = false;

        ArrayList<Boolean> arrayList = new ArrayList<Boolean>();

        for (int j = 0; j < memberDetailsArrayList.size(); j++) {
            Map<String, View> map = memberDetailsArrayList.get(j);
            for (Iterator<Map.Entry<String, View>> it = map.entrySet().iterator(); it.hasNext(); ) {
                Map.Entry<String, View> entry = it.next();
                String s = entry.getKey();
                View v = entry.getValue();
                String t = "";
                String age = "";
                if (v instanceof EditText) {
                    Map<String, String> map1 = new HashMap<>();
                    age = ((EditText) v).getText().toString().trim();
                    if (Double.parseDouble(age) >= 40 && Double.parseDouble(age) <= 50) {
                        arrayList.add(true);
                    } else {
                        arrayList.add(false);
                    }
                }
            }
        }

        if (atLeastTwoTrue(arrayList)) {
            isAgeBetween40and50 = true;
        } else {
            isAgeBetween40and50 = false;
        }
        return isAgeBetween40and50;
    }

    private static boolean atLeastTwoTrue(ArrayList<Boolean> arrayList) {
        int count = 0;
        for (Boolean b : arrayList) {
            if (b != null && b) {
                count++;
                if (count >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String getFamilyDiscount(String type, String familyComposition, boolean isAgeBetween40and50, String product, String noOfMembers) {
        String familyDiscount = "0.00";
        if (product.equalsIgnoreCase(FAMILY_MEDICARE_POLICY) || product.equalsIgnoreCase(INDIVIDUAL_HEALTH_POLICY)) {
            if (type.equalsIgnoreCase(FLOATER)) {
                if (familyComposition.equalsIgnoreCase(ONE_ADULT_ANY_CHILD)) {
                    familyDiscount = "15";
                } else {
                    if (isAgeBetween40and50) {
                        familyDiscount = "30";
                    } else {
                        familyDiscount = "25";
                    }
                }
            } else if (type.equalsIgnoreCase(INDIVIDUAL)) {
                if (!familyComposition.equalsIgnoreCase(ONE_ADULT)) {
                    familyDiscount = "5.00";
                }
            }
        } else if (product.equalsIgnoreCase(YUVAAN_HEALTH_POLICY)) {
            if (type.equalsIgnoreCase(FLOATER)) {
                if (familyComposition.equalsIgnoreCase(ONE_ADULT_ANY_CHILD)) {
                    familyDiscount = "15.00";
                } else if (familyComposition.equalsIgnoreCase(TWO_ADULT) || familyComposition.equalsIgnoreCase(TWO_ADULT_ANY_CHILD)) {
                    familyDiscount = "25.00";
                }
            } else if (type.equalsIgnoreCase(INDIVIDUAL)) {
                if(!familyComposition.equalsIgnoreCase(ONE_ADULT)){
                    familyDiscount = "5.00";
                }
            }
        } else if (product.equalsIgnoreCase(STUMP)) {
            if (type.equalsIgnoreCase(INDIVIDUAL)) {
                if (!familyComposition.equalsIgnoreCase(ONE_ADULT)) {
                    familyDiscount = "5.00";
                }
            }
        } else if (product.equalsIgnoreCase(SPECTRA_HEALTH_POLICY)) {
            if (type.equalsIgnoreCase(FLOATER)) {
                if (Integer.parseInt(noOfMembers) == 2) {
                    familyDiscount = "15.00";
                } else if (Integer.parseInt(noOfMembers) == 3) {
                    familyDiscount = "20.00";
                } else if (Integer.parseInt(noOfMembers) > 3) {
                    familyDiscount = "25.00";
                }
            } else if(type.equalsIgnoreCase(INDIVIDUAL)){
                if(Integer.parseInt(noOfMembers)>1){
                    familyDiscount = "5.00";
                }
            }
        }
        return familyDiscount;
    }

    private static String getAgeSlab(String age, String product) {
        int intAge = Integer.parseInt(age);
        String age_slab = "0";

        if (product.equalsIgnoreCase(FAMILY_MEDICARE_POLICY)) {
            if (intAge >= 0 && intAge <= 17) {
                age_slab = "0-17";
            } else if (intAge >= 18 && intAge <= 25) {
                age_slab = "18-25";
            } else if (intAge >= 26 && intAge <= 30) {
                age_slab = "26-30";
            } else if (intAge >= 31 && intAge <= 35) {
                age_slab = "31-35";
            } else if (intAge >= 36 && intAge <= 40) {
                age_slab = "36-40";
            } else if (intAge >= 41 && intAge <= 45) {
                age_slab = "41-45";
            } else if (intAge >= 46 && intAge <= 50) {
                age_slab = "46-50";
            } else if (intAge >= 51 && intAge <= 55) {
                age_slab = "51-55";
            } else if (intAge >= 56 && intAge <= 60) {
                age_slab = "56-60";
            } else if (intAge >= 61 && intAge <= 65) {
                age_slab = "61-65";
            } else if (intAge >= 66 && intAge <= 70) {
                age_slab = "66-70";
            } else if (intAge >= 71 && intAge <= 75) {
                age_slab = "71-75";
            } else if (intAge > 75) {
                age_slab = ">75";
            }
        } else if (product.equalsIgnoreCase(INDIVIDUAL_HEALTH_POLICY) || product.equalsIgnoreCase(SPECTRA_HEALTH_POLICY)) {
            if (intAge >= 0 && intAge <= 17) {
                age_slab = "0-17";
            } else if (intAge >= 18 && intAge <= 25) {
                age_slab = "18-25";
            } else if (intAge >= 26 && intAge <= 30) {
                age_slab = "26-30";
            } else if (intAge >= 31 && intAge <= 35) {
                age_slab = "31-35";
            } else if (intAge >= 36 && intAge <= 40) {
                age_slab = "36-40";
            } else if (intAge >= 41 && intAge <= 45) {
                age_slab = "41-45";
            } else if (intAge >= 46 && intAge <= 50) {
                age_slab = "46-50";
            } else if (intAge >= 51 && intAge <= 55) {
                age_slab = "51-55";
            } else if (intAge >= 56 && intAge <= 60) {
                age_slab = "56-60";
            } else if (intAge >= 61 && intAge <= 65) {
                age_slab = "61-65";
            } else if (intAge >= 66 && intAge <= 70) {
                age_slab = "66-70";
            } else if (intAge >= 71 && intAge <= 75) {
                age_slab = "71-75";
            } else if (intAge > 75) {
                age_slab = "75+";
            }
        } else if (product.equalsIgnoreCase(YUVAAN_HEALTH_POLICY)) {
            if (intAge >= 0 && intAge <= 17) {
                age_slab = "0-17";
            } else if (intAge >= 18 && intAge <= 25) {
                age_slab = "18-25";
            } else if (intAge >= 26 && intAge <= 30) {
                age_slab = "26-30";
            } else if (intAge >= 31 && intAge <= 35) {
                age_slab = "31-35";
            } else if (intAge >= 36 && intAge <= 40) {
                age_slab = "36-40";
            } else if (intAge >= 41 && intAge <= 45) {
                age_slab = "41-45";
            } else if (intAge >= 46 && intAge <= 50) {
                age_slab = "46-50";
            } else if (intAge >= 51 && intAge <= 55) {
                age_slab = "51-55";
            } else if (intAge >= 56 && intAge <= 60) {
                age_slab = "56-60";
            } else if (intAge >= 61 && intAge <= 65) {
                age_slab = "61-65";
            } else if (intAge >= 66 && intAge <= 70) {
                age_slab = "66-70";
            } else if (intAge >= 71 && intAge <= 75) {
                age_slab = "71-75";
            } else if (intAge > 75) {
                age_slab = "Above 75";
            }
        } else if (product.equalsIgnoreCase(STUMP)) {
            if (intAge >= 0 && intAge <= 35) {
                age_slab = "0-35";
            } else if (intAge >= 36 && intAge <= 45) {
                age_slab = "36-45";
            } else if (intAge >= 46 && intAge <= 60) {
                age_slab = "46-60";
            } else if (intAge >= 61 && intAge <= 65) {
                age_slab = "61-65";
            } else if (intAge >= 66 && intAge <= 70) {
                age_slab = "66-70";
            } else if (intAge >= 71 && intAge <= 75) {
                age_slab = "71-75";
            } else if (intAge > 75) {
                age_slab = "75+";
            }
        } else if (product.equalsIgnoreCase(UNI_CRITI_CARE_HEALTH_POLICY)) {
            if (intAge >= 21 && intAge <= 35) {
                age_slab = "21-35";
            } else if (intAge >= 36 && intAge <= 45) {
                age_slab = "36-45";
            } else if (intAge >= 46 && intAge <= 55) {
                age_slab = "46-55";
            } else if (intAge >= 56 && intAge <= 65) {
                age_slab = "56-65";
            } else if (intAge > 65) {
                age_slab = ">65";
            }
        }
        return age_slab;
    }


    public static ArrayList<HashMap<String, String>> calculateFamilyMedicarePremiumFloater(String type, String zone, String noOfMembers, String floaterSI, String floaterNCD, ArrayList<Map<String, View>> memberDetailsArrayList, Context context, String familyType, boolean dailyCashCheckBox, boolean maternityCheckbox) {

        ArrayList<HashMap<String, String>> output = new ArrayList<>();
        ArrayList<HashMap<String, String>> output1 = new ArrayList<>();
        String familyDiscountPercentage = getFamilyDiscount(type, familyType, isAgeBetween40and50(memberDetailsArrayList), FAMILY_MEDICARE_POLICY, noOfMembers);

        String dailyCashAllowancePremium = "0.00";
        String dailyCashAllowanceAmount = "0.00";
        String dailyCashAllowanceCommissionAmount = "0.00";
        String maternityCommissionAmount = "0.00";
        String maternityPremium = "0.00";
        ArrayList<Integer> ageArrayList = new ArrayList<>();
        ArrayList<Double> basicPremiumArrayList = new ArrayList<>();
        ArrayList<Double> ncdAmountArrayList = new ArrayList<>();
        ArrayList<Double> familyDiscountAmountArrayList = new ArrayList<>();
        ArrayList<Double> grossPremiumArrayList = new ArrayList<>();
        ArrayList<Double> commissionArrayList = new ArrayList<>();


        String fileName = "";
        if (zone.equalsIgnoreCase(ZONE_A)) {
            fileName = "health/fmp/fmp_zone_a.json";
        } else if (zone.equalsIgnoreCase(ZONE_B)) {
            fileName = "health/fmp/fmp_zone_b.json";
        } else if (zone.equalsIgnoreCase(ZONE_C)) {
            fileName = "health/fmp/fmp_zone_c.json";
        }

        String jsonStr = loadJSONFromAsset(context, fileName);
        if (jsonStr != null) {
            try {
                JSONArray jsonArray = new JSONArray(jsonStr);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    String si = object.getString("SI");
                    if (si.equalsIgnoreCase(floaterSI)) {
                        for (int j = 0; j < memberDetailsArrayList.size(); j++) {
                            Map<String, View> map = memberDetailsArrayList.get(j);
                            for (Iterator<Map.Entry<String, View>> it = map.entrySet().iterator(); it.hasNext(); ) {
                                Map.Entry<String, View> entry = it.next();
                                String key = entry.getKey();
                                View v = entry.getValue();
                                String memberAge = "0";
                                if (v instanceof EditText) {
                                    HashMap<String, String> map1 = new HashMap<>();
                                    memberAge = ((EditText) v).getText().toString().trim();
                                    String age_slab = getAgeSlab(memberAge, FAMILY_MEDICARE_POLICY);
                                    String basicPremium = object.getString(age_slab);
                                    String ncdAmount = Double.toString(Double.parseDouble(floaterNCD) / 100.00 * Double.parseDouble(basicPremium));
                                    String familyDiscountAmount = Double.toString(Double.parseDouble(familyDiscountPercentage) / 100.00 * (Double.parseDouble(basicPremium) - Double.parseDouble(ncdAmount)));
                                    String grossPremium = Double.toString(Double.parseDouble(basicPremium) - Double.parseDouble(ncdAmount) - Double.parseDouble(familyDiscountAmount));
                                    String commission = calculateCommission(zone, grossPremium, memberAge, FAMILY_MEDICARE_POLICY, false);

                                    map1.put(INTENT_MEMBER_AGE, memberAge);
                                    map1.put(INTENT_MEMBER_BASIC_PREMIUM, basicPremium);
                                    map1.put(INTENT_MEMBER_NCD_AMOUNT, ncdAmount);
                                    map1.put(INTENT_MEMBER_FAMILY_DISCOUNT, familyDiscountAmount);
                                    map1.put(INTENT_MEMBER_GROSS_PREMIUM, grossPremium);
                                    output1.add(map1);
                                    ageArrayList.add(Integer.parseInt(memberAge));
                                    basicPremiumArrayList.add(Double.parseDouble(basicPremium));
                                    ncdAmountArrayList.add(Double.parseDouble(ncdAmount));
                                    familyDiscountAmountArrayList.add(Double.parseDouble(familyDiscountAmount));
                                    grossPremiumArrayList.add(Double.parseDouble(grossPremium));
                                    commissionArrayList.add(Double.parseDouble(commission));
                                }
                            }
                        }
                    }
                }

                if (dailyCashCheckBox) {
                    ArrayList<String> output2 = new ArrayList<>();
                    output2 = calculateDailyCashPremium(type, ageArrayList, "0.00", floaterSI, FAMILY_MEDICARE_POLICY, "");
                    dailyCashAllowancePremium = output2.get(0);
                    dailyCashAllowanceAmount = output2.get(1);
                    dailyCashAllowanceCommissionAmount = calculateCommission(zone, dailyCashAllowancePremium, Integer.toString(Collections.max(ageArrayList)), FAMILY_MEDICARE_POLICY, false);
                    commissionArrayList.add((Double.parseDouble(dailyCashAllowanceCommissionAmount)));
                }

                if (maternityCheckbox) {
                    maternityPremium = calculateMaternityPremium(floaterSI);
                    maternityCommissionAmount = calculateCommission(zone, maternityPremium, Integer.toString(Collections.max(ageArrayList)), FAMILY_MEDICARE_POLICY, false);
                    commissionArrayList.add((Double.parseDouble(maternityCommissionAmount)));

                }

                HashMap<String, String> map1 = new HashMap<>();
                map1.put(INTENT_TOTAL_BASIC_PREMIUM, sumOfDoubleArrayList(basicPremiumArrayList));
                map1.put(INTENT_TOTAL_NCD_AMOUNT, sumOfDoubleArrayList(ncdAmountArrayList));
                map1.put(INTENT_TOTAL_FAMILY_DISCOUNT, sumOfDoubleArrayList(familyDiscountAmountArrayList));
                map1.put(INTENT_TOTAL_GROSS_PREMIUM, sumOfDoubleArrayList(grossPremiumArrayList));
                map1.put(INTENT_TOTAL_DAILY_CASH_PREMIUM, dailyCashAllowancePremium);
                map1.put(INTENT_TOTAL_DAILY_CASH_AMOUNT, dailyCashAllowanceAmount);
                map1.put(INTENT_TOTAL_MATERNITY_PREMIUM, maternityPremium);
                String totalGrossPremiumAfterAddOns = Double.toString(Double.parseDouble(sumOfDoubleArrayList(grossPremiumArrayList)) + Double.parseDouble(dailyCashAllowancePremium) + Double.parseDouble(maternityPremium));
                String gst = Double.toString(GST_0 / 100.00 * Double.parseDouble(totalGrossPremiumAfterAddOns));
                map1.put(INTENT_TOTAL_GST, gst);
                String netPremium = uptoTwoDecimal(Double.toString(Double.parseDouble(totalGrossPremiumAfterAddOns) + Double.parseDouble(gst)));
                map1.put(INTENT_TOTAL_NET_PREMIUM, netPremium);
                String commission = uptoTwoDecimal(Double.toString(Double.parseDouble(sumOfDoubleArrayList(commissionArrayList))));
                String incentive = "0.00";
                String portalCharges = "50.00";
                String portalIncentive = Double.toString(0.25 / 100 * Double.parseDouble(totalGrossPremiumAfterAddOns));
                String commissionString = "Approx Commission : ".concat(uptoTwoDecimal(commission)).concat("\nApprox Incentive : ").concat(uptoTwoDecimal(incentive)).concat("\nPortal Charges : ").concat(uptoTwoDecimal(portalCharges)).concat("\nPortal Incentive : ").concat(uptoTwoDecimal(portalIncentive));
                map1.put("total_commission", commissionString);
                output1.add(map1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return output1;
    }

    private static String calculateMaternityPremium(String si) {
        String output;
        if (si.equalsIgnoreCase(SI_350000)) {
            output = "12000.00";
        } else if (si.equalsIgnoreCase(SI_400000)) {
            output = "13750.00";
        } else if (si.equalsIgnoreCase(SI_450000)) {
            output = "15500.00";
        } else if (si.equalsIgnoreCase(SI_500000)) {
            output = "17000.00";
        } else if (si.equalsIgnoreCase(SI_600000)) {
            output = "20350.00";
        } else if (si.equalsIgnoreCase(SI_700000)) {
            output = "20600.00";
        } else if (si.equalsIgnoreCase(SI_800000)) {
            output = "20850.00";
        } else if (si.equalsIgnoreCase(SI_900000)) {
            output = "21000.00";
        } else if (si.equalsIgnoreCase(SI_1000000)) {
            output = "21200.00";
        } else if (si.equalsIgnoreCase(SI_1500000)) {
            output = "22000.00";
        } else if (si.equalsIgnoreCase(SI_2000000)) {
            output = "23000.00";
        } else if (si.equalsIgnoreCase(SI_2500000)) {
            output = "23500.00";
        } else {
            output = "0.00";
        }
        return output;
    }

    public static ArrayList<HashMap<String, String>> calculateYuvaanHealthPremiumFloater(String type, String zone, String noOfMembers, String floaterSI, String floaterNCD, ArrayList<Map<String, View>> memberDetailsArrayList, Context context, String familyType, boolean dailyCashCheckBox, boolean coPaymentWaiverCheckbox, String dailyCashAllowanceAmount) {

        ArrayList<HashMap<String, String>> output = new ArrayList<>();
        ArrayList<HashMap<String, String>> output1 = new ArrayList<>();
        String familyDiscountPercentage = getFamilyDiscount(type, familyType, isAgeBetween40and50(memberDetailsArrayList), YUVAAN_HEALTH_POLICY, noOfMembers);

        String dailyCashAllowancePremium = "0.00";
        String dailyCashAllowanceCommissionAmount = "0.00";
        String maternityCommissionAmount = "0.00";
        String maternityPremium = "0.00";
        ArrayList<Integer> ageArrayList = new ArrayList<>();
        ArrayList<Double> basicPremiumArrayList = new ArrayList<>();
        ArrayList<Double> ncdAmountArrayList = new ArrayList<>();
        ArrayList<Double> dailyCashAllowancePremiumArrayList = new ArrayList<>();
        ArrayList<Double> familyDiscountAmountArrayList = new ArrayList<>();
        ArrayList<Double> grossPremiumArrayList = new ArrayList<>();
        ArrayList<Double> commissionArrayList = new ArrayList<>();


        String fileName = "";
        if (coPaymentWaiverCheckbox) {
            fileName = "health/yuvaan/yuvaan_zone_a.json";
        } else {
            if (zone.equalsIgnoreCase(ZONE_A)) {
                fileName = "health/yuvaan/yuvaan_zone_a.json";
            } else if (zone.equalsIgnoreCase(ZONE_B)) {
                fileName = "health/yuvaan/yuvaan_zone_b.json";
            } else if (zone.equalsIgnoreCase(ZONE_C)) {
                fileName = "health/yuvaan/yuvaan_zone_c.json";
            }
        }

        String jsonStr = loadJSONFromAsset(context, fileName);
        if (jsonStr != null) {
            try {
                JSONArray jsonArray = new JSONArray(jsonStr);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    String si = object.getString("SI");
                    if (si.equalsIgnoreCase(floaterSI)) {
                        for (int j = 0; j < memberDetailsArrayList.size(); j++) {
                            Map<String, View> map = memberDetailsArrayList.get(j);
                            for (Iterator<Map.Entry<String, View>> it = map.entrySet().iterator(); it.hasNext(); ) {
                                Map.Entry<String, View> entry = it.next();
                                String key = entry.getKey();
                                View v = entry.getValue();
                                String memberAge = "0";
                                if (v instanceof EditText) {
                                    HashMap<String, String> map1 = new HashMap<>();
                                    memberAge = ((EditText) v).getText().toString().trim();
                                    String age_slab = getAgeSlab(memberAge, YUVAAN_HEALTH_POLICY);
                                    String basicPremium = object.getString(age_slab);
                                    String ncdAmount = Double.toString(Double.parseDouble(floaterNCD) / 100.00 * Double.parseDouble(basicPremium));
                                    String familyDiscountAmount = Double.toString(Double.parseDouble(familyDiscountPercentage) / 100.00 * (Double.parseDouble(basicPremium) - Double.parseDouble(ncdAmount)));
                                    String grossPremium = Double.toString(Double.parseDouble(basicPremium) - Double.parseDouble(ncdAmount) - Double.parseDouble(familyDiscountAmount));
                                    String commission = calculateCommission(zone, grossPremium, memberAge, YUVAAN_HEALTH_POLICY, false);

                                    if (dailyCashCheckBox) {
                                        ArrayList<String> output2 = new ArrayList<>();
                                        output2 = calculateDailyCashPremium(type, ageArrayList, "0.00", floaterSI, YUVAAN_HEALTH_POLICY, dailyCashAllowanceAmount);
                                        dailyCashAllowancePremium = output2.get(0);
                                        dailyCashAllowancePremiumArrayList.add(Double.parseDouble(dailyCashAllowancePremium));
                                        dailyCashAllowanceAmount = output2.get(1);
                                        dailyCashAllowanceCommissionAmount = calculateCommission(zone, dailyCashAllowancePremium, memberAge, YUVAAN_HEALTH_POLICY, false);
                                        commissionArrayList.add((Double.parseDouble(dailyCashAllowanceCommissionAmount)));
                                    } else {
                                        dailyCashAllowancePremium = "0.00";
                                        dailyCashAllowanceAmount = "0.00";
                                    }

                                    map1.put(INTENT_MEMBER_AGE, memberAge);
                                    map1.put(INTENT_MEMBER_BASIC_PREMIUM, basicPremium);
                                    map1.put(INTENT_MEMBER_NCD_AMOUNT, ncdAmount);
                                    map1.put(INTENT_MEMBER_FAMILY_DISCOUNT, familyDiscountAmount);
                                    map1.put(INTENT_MEMBER_GROSS_PREMIUM, grossPremium);
                                    output1.add(map1);
                                    ageArrayList.add(Integer.parseInt(memberAge));
                                    basicPremiumArrayList.add(Double.parseDouble(basicPremium));
                                    ncdAmountArrayList.add(Double.parseDouble(ncdAmount));
                                    familyDiscountAmountArrayList.add(Double.parseDouble(familyDiscountAmount));
                                    grossPremiumArrayList.add(Double.parseDouble(grossPremium));
                                    commissionArrayList.add(Double.parseDouble(commission));
                                }
                            }
                        }
                    }
                }

                HashMap<String, String> map1 = new HashMap<>();
                map1.put(INTENT_TOTAL_BASIC_PREMIUM, sumOfDoubleArrayList(basicPremiumArrayList));
                map1.put(INTENT_TOTAL_NCD_AMOUNT, sumOfDoubleArrayList(ncdAmountArrayList));
                map1.put(INTENT_TOTAL_FAMILY_DISCOUNT, sumOfDoubleArrayList(familyDiscountAmountArrayList));
                map1.put(INTENT_TOTAL_GROSS_PREMIUM, sumOfDoubleArrayList(grossPremiumArrayList));
                map1.put(INTENT_TOTAL_DAILY_CASH_PREMIUM, sumOfDoubleArrayList(dailyCashAllowancePremiumArrayList));
                map1.put(INTENT_TOTAL_DAILY_CASH_AMOUNT, dailyCashAllowanceAmount);
                String totalGrossPremiumAfterAddOns = Double.toString(Double.parseDouble(sumOfDoubleArrayList(grossPremiumArrayList)) + Double.parseDouble(dailyCashAllowancePremium) + Double.parseDouble(maternityPremium));
                String gst = Double.toString(GST_0 / 100.00 * Double.parseDouble(totalGrossPremiumAfterAddOns));
                map1.put(INTENT_TOTAL_GST, gst);
                String netPremium = uptoTwoDecimal(Double.toString(Double.parseDouble(totalGrossPremiumAfterAddOns) + Double.parseDouble(gst)));
                map1.put(INTENT_TOTAL_NET_PREMIUM, netPremium);
                String commission = uptoTwoDecimal(Double.toString(Double.parseDouble(sumOfDoubleArrayList(commissionArrayList))));
                String incentive = "0.00";
                String portalCharges = "50.00";
                String portalIncentive = Double.toString(0.25 / 100 * Double.parseDouble(totalGrossPremiumAfterAddOns));
                String commissionString = "Approx Commission : ".concat(uptoTwoDecimal(commission)).concat("\nApprox Incentive : ").concat(uptoTwoDecimal(incentive)).concat("\nPortal Charges : ").concat(uptoTwoDecimal(portalCharges)).concat("\nPortal Incentive : ").concat(uptoTwoDecimal(portalIncentive));
                map1.put(INTENT_TOTAL_COMMISSION, commissionString);
                output1.add(map1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return output1;
    }


    private static String sumOfDoubleArrayList(ArrayList<Double> arrayList) {
        String output = "0.00";
        double sum = 0.00;
        for (Double d : arrayList) {
            if (d != null) {
                sum += d;
            }
        }
        output = Double.toString(sum);
        return output;
    }

    public static ArrayList<HashMap<String, String>> calculateIndividualHealthPremium(String type, String zone, String noOfMembers, ArrayList<Map<String, View>> memberDetailsArrayList, Context context, String familyType, Boolean dailyCash, Boolean maternity, String dailyCashAllowanceAmount) {

        ArrayList<HashMap<String, String>> output = new ArrayList<>();
        ArrayList<HashMap<String, String>> output1 = new ArrayList<>();
        String familyDiscountPercentage = getFamilyDiscount(type, familyType, isAgeBetween40and50(memberDetailsArrayList), INDIVIDUAL_HEALTH_POLICY, noOfMembers);

        String dailyCashAllowancePremium = "0.00";
        String dailyCashAllowanceCommissionAmount = "0.00";
        String maternityCommissionAmount = "0.00";
        String maternityPremium = "0.00";
        ArrayList<Integer> ageArrayList = new ArrayList<>();
        ArrayList<Double> basicPremiumArrayList = new ArrayList<>();
        ArrayList<Double> ncdAmountArrayList = new ArrayList<>();
        ArrayList<Double> familyDiscountAmountArrayList = new ArrayList<>();
        ArrayList<Double> grossPremiumArrayList = new ArrayList<>();
        ArrayList<Double> commissionArrayList = new ArrayList<>();
        ArrayList<Double> dailyCashAllowancePremiumArrayList = new ArrayList<>();

        String fileName = "";
        if (zone.equalsIgnoreCase(ZONE_A)) {
            fileName = "health/ihp/ihp_zone_a.json";
        } else if (zone.equalsIgnoreCase(ZONE_B)) {
            fileName = "health/ihp/ihp_zone_b.json";
        } else if (zone.equalsIgnoreCase(ZONE_C)) {
            fileName = "health/ihp/ihp_zone_c.json";
        }

        String jsonStr = loadJSONFromAsset(context, fileName);
        String memberAge = "0";
        String memberSI = "0";
        String memberNCDPercentage = "0";
        String memberNCDAmount = "0.00";

        String basicPremium = "0.00";
        if (jsonStr != null) {
            try {
                JSONArray jsonArray = new JSONArray(jsonStr);
                for (int j = 0; j < memberDetailsArrayList.size(); j++) {
                    Map<String, View> map = memberDetailsArrayList.get(j);
                    HashMap<String, String> map1 = new HashMap<>();

                    int count = 0;

                    for (Iterator<Map.Entry<String, View>> it = map.entrySet().iterator(); it.hasNext(); ) {

                        Map.Entry<String, View> entry = it.next();
                        String key = entry.getKey();
                        View v = entry.getValue();

                        if (key.equalsIgnoreCase(INTENT_MEMBER_AGE)) {
                            if (v instanceof EditText) {
                                memberAge = ((EditText) v).getText().toString().trim();
                            }
                        } else if (key.equalsIgnoreCase(INTENT_MEMBER_SI)) {
                            if (v instanceof Spinner) {
                                memberSI = ((Spinner) v).getSelectedItem().toString();
                            }
                        } else if (key.equalsIgnoreCase(INTENT_MEMBER_NCD_PERCENTAGE)) {
                            if (v instanceof Spinner) {
                                memberNCDPercentage = ((Spinner) v).getSelectedItem().toString();
                            }
                        }
                        count = count + 1;
                        if (count == 3) {
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i);
                                String si = object.getString("SI");
                                if (si.equalsIgnoreCase(memberSI)) {
                                    String age_slab = getAgeSlab(memberAge, INDIVIDUAL_HEALTH_POLICY);
                                    basicPremium = object.getString(age_slab);

                                    map1.put(INTENT_MEMBER_AGE, memberAge);
                                    map1.put(INTENT_MEMBER_SI, memberSI);
                                    map1.put(INTENT_MEMBER_BASIC_PREMIUM, basicPremium);
                                    map1.put(INTENT_MEMBER_NCD_PERCENTAGE, memberNCDPercentage);
                                    memberNCDAmount = Double.toString(Double.parseDouble(memberNCDPercentage) / 100.00 * Double.parseDouble(basicPremium));
                                    map1.put(INTENT_MEMBER_NCD_AMOUNT, memberNCDAmount);
                                    String familyDiscountAmount = Double.toString(Double.parseDouble(familyDiscountPercentage) / 100.00 * (Double.parseDouble(basicPremium) - Double.parseDouble(memberNCDAmount)));
                                    map1.put(INTENT_MEMBER_FAMILY_DISCOUNT, familyDiscountAmount);
                                    String grossPremium = Double.toString(Double.parseDouble(basicPremium) - Double.parseDouble(memberNCDAmount) - Double.parseDouble(familyDiscountAmount));
                                    map1.put(INTENT_MEMBER_GROSS_PREMIUM, grossPremium);
                                    String commission = calculateCommission(zone, grossPremium, memberAge, INDIVIDUAL_HEALTH_POLICY, false);

                                    ageArrayList.add(Integer.parseInt(memberAge));
                                    basicPremiumArrayList.add(Double.parseDouble(basicPremium));
                                    ncdAmountArrayList.add((Double.parseDouble(memberNCDAmount)));
                                    familyDiscountAmountArrayList.add(Double.parseDouble(familyDiscountAmount));
                                    grossPremiumArrayList.add(Double.parseDouble(grossPremium));
                                    commissionArrayList.add(Double.parseDouble(commission));

                                    if (dailyCash) {
                                        ArrayList<String> outputDailyCash = new ArrayList<>();
                                        outputDailyCash = calculateDailyCashPremium(type, null, "", "", INDIVIDUAL_HEALTH_POLICY, dailyCashAllowanceAmount);
                                        dailyCashAllowancePremium = outputDailyCash.get(0);
                                        dailyCashAllowanceAmount = outputDailyCash.get(1);
                                        map1.put(INTENT_MEMBER_DAILY_CASH_PREMIUM, dailyCashAllowancePremium);
                                        map1.put(INTENT_MEMBER_DAILY_CASH_AMOUNT, dailyCashAllowanceAmount);
                                        dailyCashAllowancePremiumArrayList.add(Double.parseDouble(dailyCashAllowancePremium));
                                        dailyCashAllowanceCommissionAmount = calculateCommission(zone, dailyCashAllowancePremium, Integer.toString(Collections.max(ageArrayList)), INDIVIDUAL_HEALTH_POLICY, false);
                                        commissionArrayList.add(Double.parseDouble(dailyCashAllowanceCommissionAmount));
                                    } else {
                                        map1.put(INTENT_MEMBER_DAILY_CASH_PREMIUM, dailyCashAllowancePremium);
                                        map1.put(INTENT_MEMBER_DAILY_CASH_AMOUNT, dailyCashAllowanceAmount);
                                    }
                                    output1.add(map1);
                                    break;
                                }
                            }
                        }
                    }
                }

                HashMap<String, String> map2 = new HashMap<>();
                map2.put(INTENT_TOTAL_BASIC_PREMIUM, sumOfDoubleArrayList(basicPremiumArrayList));
                map2.put(INTENT_TOTAL_NCD_AMOUNT, sumOfDoubleArrayList(ncdAmountArrayList));
                map2.put(INTENT_TOTAL_FAMILY_DISCOUNT, sumOfDoubleArrayList(familyDiscountAmountArrayList));
                map2.put(INTENT_TOTAL_GROSS_PREMIUM, sumOfDoubleArrayList(grossPremiumArrayList));
                map2.put(INTENT_TOTAL_DAILY_CASH_PREMIUM, sumOfDoubleArrayList(dailyCashAllowancePremiumArrayList));
                map2.put(INTENT_TOTAL_DAILY_CASH_AMOUNT, dailyCashAllowanceAmount);
                String totalGrossPremiumAfterAddOns = Double.toString(Double.parseDouble(sumOfDoubleArrayList(grossPremiumArrayList)) + Double.parseDouble(sumOfDoubleArrayList(dailyCashAllowancePremiumArrayList)));
                String gst = Double.toString(GST_0 / 100.00 * Double.parseDouble(totalGrossPremiumAfterAddOns));
                map2.put(INTENT_TOTAL_GST, gst);
                String netPremium = Double.toString(Double.parseDouble(totalGrossPremiumAfterAddOns) + Double.parseDouble(gst));
                map2.put(INTENT_TOTAL_NET_PREMIUM, netPremium);
                String commission = uptoTwoDecimal(Double.toString(Double.parseDouble(sumOfDoubleArrayList(commissionArrayList))));
                String incentive = "0.00";
                String portalCharges = "50.00";
                String portalIncentive = Double.toString(0.25 / 100 * Double.parseDouble(totalGrossPremiumAfterAddOns));
                String commissionString = "Approx Commission : ".concat(uptoTwoDecimal(commission)).concat("\nApprox Incentive : ").concat(uptoTwoDecimal(incentive)).concat("\nPortal Charges : ").concat(uptoTwoDecimal(portalCharges)).concat("\nPortal Incentive : ").concat(uptoTwoDecimal(portalIncentive));
                map2.put(INTENT_TOTAL_COMMISSION, commissionString);
                output1.add(map2);
                int k = 0;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            int k = 0;
        }
        return output1;
    }

    public static ArrayList<HashMap<String, String>> calculateUniCritiCarePremium(String type, String zone, String noOfMembers, ArrayList<Map<String, View>> memberDetailsArrayList, Context context, String familyType, Boolean dailyCash, Boolean maternity, String dailyCashAllowanceAmount) {
        ArrayList<HashMap<String, String>> output1 = new ArrayList<>();
        String fileName = "health/unicriticare/uni_criti_care.json";
        String jsonStr = loadJSONFromAsset(context, fileName);
        String memberAge = "0";
        String memberSI = "0";
        String memberNCDPercentage = "0";
        String memberNCDAmount = "0.00";
        String basicPremium = "0.00";
        ArrayList<Integer> ageArrayList = new ArrayList<>();
        ArrayList<Double> basicPremiumArrayList = new ArrayList<>();
        ArrayList<Double> grossPremiumArrayList = new ArrayList<>();

        ArrayList<Double> commissionArrayList = new ArrayList<>();

        if (jsonStr != null) {
            try {
                JSONArray jsonArray = new JSONArray(jsonStr);
                for (int j = 0; j < memberDetailsArrayList.size(); j++) {
                    Map<String, View> map = memberDetailsArrayList.get(j);
                    HashMap<String, String> map1 = new HashMap<>();

                    int count = 0;

                    for (Iterator<Map.Entry<String, View>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, View> entry = it.next();
                        String key = entry.getKey();
                        View v = entry.getValue();

                        if (key.equalsIgnoreCase(INTENT_MEMBER_AGE)) {
                            if (v instanceof EditText) {
                                memberAge = ((EditText) v).getText().toString().trim();
                            }
                        } else if (key.equalsIgnoreCase(INTENT_MEMBER_SI)) {
                            if (v instanceof Spinner) {
                                memberSI = ((Spinner) v).getSelectedItem().toString();
                            }
                        }

                        count = count + 1;
                        if (count == 2) {
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject object = jsonArray.getJSONObject(i);
                                String si = object.getString("SI");
                                if (si.equalsIgnoreCase(memberSI)) {
                                    String age_slab = getAgeSlab(memberAge, UNI_CRITI_CARE_HEALTH_POLICY);
                                    basicPremium = object.getString(age_slab);

                                    map1.put(INTENT_MEMBER_AGE, memberAge);
                                    map1.put(INTENT_MEMBER_SI, memberSI);
                                    map1.put(INTENT_MEMBER_BASIC_PREMIUM, basicPremium);
                                    String grossPremium = basicPremium;
                                    map1.put(INTENT_MEMBER_GROSS_PREMIUM, grossPremium);
                                    String commission = calculateCommission(zone, grossPremium, memberAge, UNI_CRITI_CARE_HEALTH_POLICY, false);

                                    ageArrayList.add(Integer.parseInt(memberAge));
                                    basicPremiumArrayList.add(Double.parseDouble(basicPremium));
                                    grossPremiumArrayList.add(Double.parseDouble(grossPremium));
                                    commissionArrayList.add(Double.parseDouble(commission));
                                    output1.add(map1);
                                    break;
                                }
                            }
                        }
                    }
                }
                HashMap<String, String> map2 = new HashMap<>();
                map2.put(INTENT_TOTAL_BASIC_PREMIUM, sumOfDoubleArrayList(basicPremiumArrayList));
                map2.put(INTENT_TOTAL_GROSS_PREMIUM, sumOfDoubleArrayList(grossPremiumArrayList));
                String totalGrossPremiumAfterAddOns = Double.toString(Double.parseDouble(sumOfDoubleArrayList(grossPremiumArrayList)));
                String gst = Double.toString(GST_0 / 100.00 * Double.parseDouble(totalGrossPremiumAfterAddOns));
                map2.put(INTENT_TOTAL_GST, gst);
                String netPremium = Double.toString(Double.parseDouble(totalGrossPremiumAfterAddOns) + Double.parseDouble(gst));
                map2.put(INTENT_TOTAL_NET_PREMIUM, netPremium);
                String commission = uptoTwoDecimal(Double.toString(Double.parseDouble(sumOfDoubleArrayList(commissionArrayList))));
                String incentive = "0.00";
                String portalCharges = "50.00";
                String portalIncentive = Double.toString(0.25 / 100 * Double.parseDouble(totalGrossPremiumAfterAddOns));
                String commissionString = "Approx Commission : ".concat(uptoTwoDecimal(commission)).concat("\nApprox Incentive : ").concat(uptoTwoDecimal(incentive)).concat("\nPortal Charges : ").concat(uptoTwoDecimal(portalCharges)).concat("\nPortal Incentive : ").concat(uptoTwoDecimal(portalIncentive));
                map2.put(INTENT_TOTAL_COMMISSION, commissionString);
                output1.add(map2);
                int k = 0;

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return output1;
    }


    public static ArrayList<HashMap<String, String>> calculateSTUMPPremiumFloater(String type, String zone, String noOfMembers, String floaterThreshold, String floaterSI, ArrayList<Map<String, View>> memberDetailsArrayList, Context context, String familyType, boolean dailyCash) {

        ArrayList<HashMap<String, String>> output = new ArrayList<>();
        ArrayList<HashMap<String, String>> output1 = new ArrayList<>();
        String familyDiscountPercentage = getFamilyDiscount(type, familyType, false, STUMP, noOfMembers);

        String dailyCashAllowancePremium = "0.00";
        String dailyCashAllowanceAmount = "0.00";
        String dailyCashAllowanceCommissionAmount = "0.00";
        String maternityCommissionAmount = "0.00";
        String maternityPremium = "0.00";
        ArrayList<Integer> ageArrayList = new ArrayList<>();
        ArrayList<Double> basicPremiumArrayList = new ArrayList<>();
        ArrayList<Double> dailyCashAllowancePremiumArrayList = new ArrayList<>();
        ArrayList<Double> ncdAmountArrayList = new ArrayList<>();
        ArrayList<Double> familyDiscountAmountArrayList = new ArrayList<>();
        ArrayList<Double> grossPremiumArrayList = new ArrayList<>();
        ArrayList<Double> commissionArrayList = new ArrayList<>();

        String fileName = "";

        if (type.equalsIgnoreCase(FLOATER)) {
            if (Integer.parseInt(noOfMembers) == 2) {
                fileName = "health/stump/stump_floater_2_member_".concat(floaterThreshold).concat(".json");
            } else if (Integer.parseInt(noOfMembers) > 2) {
                fileName = "health/stump/stump_floater_more_than_2_member_".concat(floaterThreshold).concat(".json");
            }

            String jsonStr = loadJSONFromAsset(context, fileName);
            int m = 0;
            if (jsonStr != null) {
                try {
                    for (int j = 0; j < memberDetailsArrayList.size(); j++) {
                        Map<String, View> map = memberDetailsArrayList.get(j);
                        for (Iterator<Map.Entry<String, View>> it = map.entrySet().iterator(); it.hasNext(); ) {
                            Map.Entry<String, View> entry = it.next();
                            String key = entry.getKey();
                            View v = entry.getValue();
                            String memberAge = "0";
                            if (v instanceof EditText) {
                                HashMap<String, String> map1 = new HashMap<>();
                                memberAge = ((EditText) v).getText().toString().trim();
                                ageArrayList.add(Integer.parseInt(memberAge));
                                map1.put(INTENT_MEMBER_AGE, memberAge);
                                output1.add(map1);
                            }
                        }
                    }
                    int maxAge = Collections.max(ageArrayList);
                    JSONArray jsonArray = new JSONArray(jsonStr);
                    String basicPremium = "0.00";
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        String si = object.getString("SI");
                        if (si.equalsIgnoreCase(floaterSI)) {
                            String maxAgeSlab = getAgeSlab(Integer.toString(maxAge), STUMP);
                            basicPremium = object.getString(maxAgeSlab);
                            break;
                        }
                    }
                    HashMap<String, String> map1 = new HashMap<>();
                    map1.put(INTENT_TOTAL_BASIC_PREMIUM, basicPremium);

                    if (dailyCash) {
                        ArrayList<String> output2 = new ArrayList<>();
                        output2 = calculateDailyCashPremium(type, ageArrayList, Integer.toString(maxAge), floaterThreshold, STUMP, "");
                        dailyCashAllowancePremium = output2.get(0);
                        dailyCashAllowanceAmount = output2.get(1);
                        dailyCashAllowanceCommissionAmount = calculateCommission(zone, dailyCashAllowancePremium, Integer.toString(Collections.max(ageArrayList)), STUMP, false);

                    }

                    String familyDiscountAmount = Double.toString(Double.parseDouble(familyDiscountPercentage) / 100.00 * Double.parseDouble(basicPremium));
                    map1.put(INTENT_TOTAL_FAMILY_DISCOUNT, uptoTwoDecimal(familyDiscountAmount));
                    String grossPremiumBeforeAddOn = Double.toString(Double.parseDouble(basicPremium) - Double.parseDouble(familyDiscountAmount));
                    map1.put(INTENT_TOTAL_GROSS_PREMIUM, grossPremiumBeforeAddOn);

                    map1.put(INTENT_TOTAL_DAILY_CASH_PREMIUM, dailyCashAllowancePremium);
                    map1.put(INTENT_TOTAL_DAILY_CASH_AMOUNT, dailyCashAllowanceAmount);

                    String grossPremiumAfterAddOn = Double.toString(Double.parseDouble(grossPremiumBeforeAddOn) + Double.parseDouble(dailyCashAllowancePremium));

                    String gst = Double.toString(GST_0 / 100.00 * Double.parseDouble(grossPremiumAfterAddOn));
                    String netPremium = Double.toString(Double.parseDouble(grossPremiumAfterAddOn) + Double.parseDouble(gst));

                    map1.put(INTENT_TOTAL_GST, gst);
                    map1.put(INTENT_TOTAL_NET_PREMIUM, netPremium);

                    String commission = calculateCommission(zone, grossPremiumAfterAddOn, Integer.toString(maxAge), STUMP, true);

                    map1.put(INTENT_TOTAL_COMMISSION, commission);

                    output1.add(map1);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else if (type.equalsIgnoreCase(INDIVIDUAL)) {
            try {
                for (int j = 0; j < memberDetailsArrayList.size(); j++) {
                    Map<String, View> map = memberDetailsArrayList.get(j);
                    int count = 0;
                    String age_slab = "";
                    String memberAge = "0";
                    String memberThreshold = "0.00";
                    String memberSI = "0.00";
                    String basicPremium = "0.00";
                    for (Iterator<Map.Entry<String, View>> it = map.entrySet().iterator(); it.hasNext(); ) {
                        Map.Entry<String, View> entry = it.next();
                        String key = entry.getKey();
                        View v = entry.getValue();
                        HashMap<String, String> map1 = new HashMap<>();
                        if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_AGE)) {
                            if (v instanceof EditText) {
                                memberAge = ((EditText) v).getText().toString().trim();

                                ageArrayList.add(Integer.parseInt(memberAge));
                                age_slab = getAgeSlab(memberAge, STUMP);
                                count = count + 1;
                            }
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_THRESHOLD)) {
                            if (v instanceof Spinner) {
                                memberThreshold = ((Spinner) v).getSelectedItem().toString();

                                count = count + 1;
                            }
                        } else if (key.equalsIgnoreCase(CommonFunctions.INTENT_MEMBER_SI)) {
                            if (v instanceof Spinner) {
                                memberSI = ((Spinner) v).getSelectedItem().toString();

                                count = count + 1;
                            }
                        }

                        if (count == 3) {

                            map1.put(INTENT_MEMBER_AGE, memberAge);
                            map1.put(INTENT_MEMBER_THRESHOLD, memberThreshold.toString());
                            map1.put(INTENT_MEMBER_SI, memberSI.toString());

                            fileName = "health/stump/stump_individual_".concat(memberThreshold).concat(".json");
                            String jsonStr = loadJSONFromAsset(context, fileName);
                            if (jsonStr != null) {
                                JSONArray jsonArray = new JSONArray(jsonStr);
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String si = object.getString("SI");
                                    if (si.equalsIgnoreCase(memberSI)) {
                                        String maxAgeSlab = getAgeSlab(memberAge, STUMP);
                                        basicPremium = object.getString(maxAgeSlab);
                                        basicPremiumArrayList.add(Double.parseDouble(basicPremium));
                                        commissionAmount = calculateCommission(zone, basicPremium, memberAge, STUMP, false);
                                        commissionArrayList.add(Double.parseDouble(commissionAmount));
                                        String memberFamilyDiscountAmount = Double.toString(Double.parseDouble(familyDiscountPercentage) / 100.00 * Double.parseDouble(basicPremium));
                                        familyDiscountAmountArrayList.add(Double.parseDouble(memberFamilyDiscountAmount));


                                        if (dailyCash) {
                                            ArrayList<String> output2 = new ArrayList<>();
                                            output2 = calculateDailyCashPremium(type, ageArrayList, memberAge, memberSI, STUMP, "");
                                            dailyCashAllowancePremium = output2.get(0);
                                            dailyCashAllowanceAmount = output2.get(1);
                                            map1.put(INTENT_MEMBER_DAILY_CASH_PREMIUM, dailyCashAllowancePremium);
                                            dailyCashAllowancePremiumArrayList.add(Double.parseDouble(dailyCashAllowancePremium));
                                            map1.put(INTENT_MEMBER_DAILY_CASH_AMOUNT, dailyCashAllowanceAmount);
                                            dailyCashAllowanceCommissionAmount = calculateCommission(zone, dailyCashAllowancePremium, Integer.toString(Collections.max(ageArrayList)), STUMP, false);
                                            commissionArrayList.add(Double.parseDouble(dailyCashAllowanceCommissionAmount));
                                        } else {
                                            map1.put(INTENT_MEMBER_DAILY_CASH_PREMIUM, dailyCashAllowancePremium);
                                            map1.put(INTENT_MEMBER_DAILY_CASH_AMOUNT, dailyCashAllowanceAmount);
                                        }
                                    }
                                }
                                output1.add(map1);
                                break;
                            }
                        }
                    }
                }
                HashMap<String, String> map1 = new HashMap<>();
                String totalBasicPremium = sumOfDoubleArrayList(basicPremiumArrayList);
                String totalFamilyDiscount = sumOfDoubleArrayList(familyDiscountAmountArrayList);
                String totalGrossPremiumBeforeAddOn = Double.toString(Double.parseDouble(totalBasicPremium) - Double.parseDouble(totalFamilyDiscount));
                String totalDailyCashPremium = sumOfDoubleArrayList(dailyCashAllowancePremiumArrayList);
                String totalGrossPremiumAfterAddOn = Double.toString(Double.parseDouble(totalGrossPremiumBeforeAddOn) + Double.parseDouble(totalDailyCashPremium));
                String totalGST = Double.toString(GST_0 / 100.00 * Double.parseDouble(totalGrossPremiumAfterAddOn));
                String totalNetPremium = Double.toString(Double.parseDouble(totalGrossPremiumAfterAddOn) + Double.parseDouble(totalGST));
                map1.put(INTENT_TOTAL_BASIC_PREMIUM, totalBasicPremium);
                map1.put(INTENT_TOTAL_FAMILY_DISCOUNT, totalFamilyDiscount);
                map1.put(INTENT_TOTAL_GROSS_PREMIUM, totalGrossPremiumBeforeAddOn);
                map1.put(INTENT_TOTAL_DAILY_CASH_PREMIUM, totalDailyCashPremium);
                map1.put(INTENT_TOTAL_GST, totalGST);
                map1.put(INTENT_TOTAL_NET_PREMIUM, totalNetPremium);
                String commission = sumOfDoubleArrayList(commissionArrayList);
                String incentive = "0.00";
                String portalCharges = "50.00";
                String portalIncentive = Double.toString(0.25 / 100 * Double.parseDouble(totalGrossPremiumAfterAddOn));
                String commissionString = "Approx Commission : ".concat(uptoTwoDecimal(commission)).concat("\nApprox Incentive : ").concat(uptoTwoDecimal(incentive)).concat("\nPortal Charges : ").concat(uptoTwoDecimal(portalCharges)).concat("\nPortal Incentive : ").concat(uptoTwoDecimal(portalIncentive));
                map1.put(INTENT_TOTAL_COMMISSION, commissionString);
                output1.add(map1);
                int g = 0;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return output1;
    }

    public static String setCurrencyFormat(String value) {

        long number = Math.round(Double.parseDouble(value));

        // Convert to Indian format with commas
        StringBuilder sb = new StringBuilder();
        String numStr = Long.toString(number);
        int len = numStr.length();

        if (len > 3) {
            // Handle last 3 digits separately
            String lastThree = numStr.substring(len - 3);
            String remaining = numStr.substring(0, len - 3);
            // Insert commas every two digits in remaining part
            int remLen = remaining.length();
            int firstGroupLen = remLen % 2;
            if (firstGroupLen > 0) {
                sb.append(remaining.substring(0, firstGroupLen));
                if (remLen > firstGroupLen) {
                    sb.append(",");
                }
            }
            for (int i = firstGroupLen; i < remLen; i += 2) {
                sb.append(remaining.substring(i, i + 2));
                if (i + 2 < remLen) {
                    sb.append(",");
                }
            }
            sb.append(",").append(lastThree);
        } else {
            // If length <= 3, just append the number
            sb.append(numStr);
        }
        return sb.toString();
    }

    public static ArrayList<HashMap<String, String>> calculateSpectraPremiumFloater(String type, String zone, String noOfMembers, String floaterSI, String floaterNCD, ArrayList<Map<String, View>> memberDetailsArrayList, Context context, String familyType, boolean dailyCashCheckBox, boolean maternityCheckbox) {
        {

            ArrayList<HashMap<String, String>> output = new ArrayList<>();
            ArrayList<HashMap<String, String>> output1 = new ArrayList<>();
            String familyDiscountPercentage = getFamilyDiscount(type, familyType, isAgeBetween40and50(memberDetailsArrayList), SPECTRA_HEALTH_POLICY, noOfMembers);

            String dailyCashAllowancePremium = "0.00";
            String dailyCashAllowanceAmount = "0.00";
            String dailyCashAllowanceCommissionAmount = "0.00";
            String maternityCommissionAmount = "0.00";
            String maternityPremium = "0.00";
            ArrayList<Integer> ageArrayList = new ArrayList<>();
            ArrayList<Double> basicPremiumArrayList = new ArrayList<>();
            ArrayList<Double> dailyCashAllowanceArrayList = new ArrayList<>();
            ArrayList<Double> ncdAmountArrayList = new ArrayList<>();
            ArrayList<Double> familyDiscountAmountArrayList = new ArrayList<>();
            ArrayList<Double> grossPremiumArrayList = new ArrayList<>();
            ArrayList<Double> commissionArrayList = new ArrayList<>();


            String fileName = "";
            if (zone.equalsIgnoreCase(ZONE_A)) {
                fileName = "health/spectra/spectra_zone_a.json";
            } else if (zone.equalsIgnoreCase(ZONE_B)) {
                fileName = "health/spectra/spectra_zone_b.json";
            } else if (zone.equalsIgnoreCase(ZONE_C)) {
                fileName = "health/spectra/spectra_zone_c.json";
            }

            String jsonStr = loadJSONFromAsset(context, fileName);
            if (jsonStr != null) {
                try {
                    JSONArray jsonArray = new JSONArray(jsonStr);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        String si = object.getString("SI");
                        if (si.equalsIgnoreCase(floaterSI)) {
                            for (int j = 0; j < memberDetailsArrayList.size(); j++) {
                                Map<String, View> map = memberDetailsArrayList.get(j);
                                for (Iterator<Map.Entry<String, View>> it = map.entrySet().iterator(); it.hasNext(); ) {
                                    Map.Entry<String, View> entry = it.next();
                                    String key = entry.getKey();
                                    View v = entry.getValue();
                                    String memberAge = "0";
                                    if (v instanceof EditText) {
                                        HashMap<String, String> map1 = new HashMap<>();
                                        memberAge = ((EditText) v).getText().toString().trim();
                                        String age_slab = getAgeSlab(memberAge, SPECTRA_HEALTH_POLICY);
                                        String basicPremium = object.getString(age_slab);
                                        String ncdAmount = Double.toString(Double.parseDouble(floaterNCD) / 100.00 * Double.parseDouble(basicPremium));
                                        String familyDiscountAmount = Double.toString(Double.parseDouble(familyDiscountPercentage) / 100.00 * (Double.parseDouble(basicPremium) - Double.parseDouble(ncdAmount)));
                                        String grossPremium = Double.toString(Double.parseDouble(basicPremium) - Double.parseDouble(ncdAmount) - Double.parseDouble(familyDiscountAmount));
                                        String commission = calculateCommission(zone, grossPremium, memberAge, SPECTRA_HEALTH_POLICY, false);

                                        map1.put(INTENT_MEMBER_AGE, memberAge);
                                        map1.put(INTENT_MEMBER_BASIC_PREMIUM, basicPremium);
                                        map1.put(INTENT_MEMBER_NCD_AMOUNT, ncdAmount);
                                        map1.put(INTENT_MEMBER_FAMILY_DISCOUNT, familyDiscountAmount);
                                        map1.put(INTENT_MEMBER_GROSS_PREMIUM, grossPremium);
                                        output1.add(map1);
                                        ageArrayList.add(Integer.parseInt(memberAge));
                                        basicPremiumArrayList.add(Double.parseDouble(basicPremium));
                                        ncdAmountArrayList.add(Double.parseDouble(ncdAmount));
                                        familyDiscountAmountArrayList.add(Double.parseDouble(familyDiscountAmount));
                                        grossPremiumArrayList.add(Double.parseDouble(grossPremium));
                                        commissionArrayList.add(Double.parseDouble(commission));
                                        if (dailyCashCheckBox) {
                                            ArrayList<String> output2 = new ArrayList<>();
                                            output2 = calculateDailyCashPremium(type, ageArrayList, "0.00", floaterSI, SPECTRA_HEALTH_POLICY, "");
                                            dailyCashAllowancePremium = output2.get(0);
                                            dailyCashAllowanceAmount = output2.get(1);
                                            map1.put(INTENT_MEMBER_DAILY_CASH_PREMIUM, dailyCashAllowancePremium);
                                            map1.put(INTENT_MEMBER_DAILY_CASH_AMOUNT, dailyCashAllowanceAmount);
                                            dailyCashAllowanceArrayList.add(Double.parseDouble(dailyCashAllowancePremium));
                                        }
                                    }
                                }
                            }
                        }
                    }

                    HashMap<String, String> map1 = new HashMap<>();
                    map1.put(INTENT_TOTAL_BASIC_PREMIUM, sumOfDoubleArrayList(basicPremiumArrayList));
                    map1.put(INTENT_TOTAL_NCD_AMOUNT, sumOfDoubleArrayList(ncdAmountArrayList));
                    map1.put(INTENT_TOTAL_FAMILY_DISCOUNT, sumOfDoubleArrayList(familyDiscountAmountArrayList));
                    map1.put(INTENT_TOTAL_GROSS_PREMIUM, sumOfDoubleArrayList(grossPremiumArrayList));
                    map1.put(INTENT_TOTAL_DAILY_CASH_PREMIUM, sumOfDoubleArrayList(dailyCashAllowanceArrayList));
                    map1.put(INTENT_TOTAL_DAILY_CASH_AMOUNT, dailyCashAllowanceAmount);
                    map1.put(INTENT_TOTAL_MATERNITY_PREMIUM, maternityPremium);
                    String totalGrossPremiumAfterAddOns = Double.toString(Double.parseDouble(sumOfDoubleArrayList(grossPremiumArrayList)) + Double.parseDouble(dailyCashAllowancePremium) + Double.parseDouble(maternityPremium));
                    String gst = Double.toString(GST_0 / 100.00 * Double.parseDouble(totalGrossPremiumAfterAddOns));
                    map1.put(INTENT_TOTAL_GST, gst);
                    String netPremium = uptoTwoDecimal(Double.toString(Double.parseDouble(totalGrossPremiumAfterAddOns) + Double.parseDouble(gst)));
                    map1.put(INTENT_TOTAL_NET_PREMIUM, netPremium);
                    String commission = uptoTwoDecimal(Double.toString(Double.parseDouble(sumOfDoubleArrayList(commissionArrayList))));
                    String incentive = "0.00";
                    String portalCharges = "50.00";
                    String portalIncentive = Double.toString(0.25 / 100 * Double.parseDouble(totalGrossPremiumAfterAddOns));
                    String commissionString = "Approx Commission : ".concat(uptoTwoDecimal(commission)).concat("\nApprox Incentive : ").concat(uptoTwoDecimal(incentive)).concat("\nPortal Charges : ").concat(uptoTwoDecimal(portalCharges)).concat("\nPortal Incentive : ").concat(uptoTwoDecimal(portalIncentive));
                    map1.put("total_commission", commissionString);
                    output1.add(map1);
                    int l = 0;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return output1;
        }
    }

    public static void createAlertBuilder(Context context, String title, String message, String positive, String negative) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        if(!negative.equalsIgnoreCase("")){
            builder.setNegativeButton(negative, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        }
        builder.create().show();
    }

    public static Bitmap getBitmapFromView(View view) {
        // Ensure it has correct size, even if off‑screen in ScrollView
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            view.measure(
                    View.MeasureSpec.makeMeasureSpec(((View)view.getParent()).getWidth(), View.MeasureSpec.EXACTLY),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            );
            width = view.getMeasuredWidth();
            height = view.getMeasuredHeight();
            view.layout(0, 0, width, height);
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.WHITE);  // ← ADD THIS LINE

        view.draw(canvas);
        return bitmap;
    }

    public static File saveBitmapToCache(Context context, Bitmap bitmap, String product) {
        File cachePath = new File(context.getCacheDir(), "images");
        if (!cachePath.exists()) {
            cachePath.mkdirs();
        }
        File file = new File(cachePath, product.concat(" Quote.png"));
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (fos != null) {
                try { fos.close(); } catch (IOException ignore) {}
            }
        }
    }

    public static void shareImage(Context context, File imageFile) {
        String authority = context.getPackageName() + ".fileprovider";
        Uri uri = FileProvider.getUriForFile(context, authority, imageFile);

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("image/png");
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        context.startActivity(Intent.createChooser(shareIntent, "Share section"));
    }

    public static File saveBitmapToPdf(Context context, Bitmap bitmap, String product) {
        File cachePath = new File(context.getCacheDir(), "pdfs");
        if (!cachePath.exists()) {
            cachePath.mkdirs();
        }
        File pdfFile = new File(cachePath, product.concat(" Quote.pdf"));

        PdfDocument document = new PdfDocument();
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(bitmap.getWidth(), bitmap.getHeight(), 1).create();
        PdfDocument.Page page = document.startPage(pageInfo);

        Canvas canvas = page.getCanvas();
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);  // Fill page with white
        canvas.drawBitmap(bitmap, 0, 0, null);

        document.finishPage(page);

        try {
            document.writeTo(new FileOutputStream(pdfFile));
            document.close();
            return pdfFile;
        } catch (IOException e) {
            e.printStackTrace();
            document.close();
            return null;
        }
    }

    public static void sharePdf(Context context, File pdfFile) {
        String authority = context.getPackageName() + ".fileprovider";
        Uri uri = FileProvider.getUriForFile(context, authority, pdfFile);

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("application/pdf");
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        context.startActivity(Intent.createChooser(shareIntent, "Share PDF"));
    }

    public static void shareBrochure(Context context, String productName) {
        String fileName = "";
        String cacheFileName = "";
        if(productName.equalsIgnoreCase(FAMILY_MEDICARE_POLICY)){
            fileName = "health/fmp/fmp_prospectus.pdf";
            cacheFileName = "fmp_prospectus.pdf";
        } else if (productName.equalsIgnoreCase(INDIVIDUAL_HEALTH_POLICY)) {
            fileName = "health/ihp/ihp_prospectus.pdf";
            cacheFileName = "ihp_prospectus.pdf";
        } else if (productName.equalsIgnoreCase(YUVAAN_HEALTH_POLICY)) {
            fileName = "health/yuvaan/yuvaan_prospectus.pdf";
            cacheFileName = "yuvaan_prospectus.pdf";
        } else if (productName.equalsIgnoreCase(STUMP)) {
            fileName = "health/stump/stump_prospectus.pdf";
            cacheFileName = "stump_prospectus.pdf";
        } else if (productName.equalsIgnoreCase(SPECTRA_HEALTH_POLICY)) {
            fileName = "health/spectra/spectra_prospectus.pdf";
            cacheFileName = "spectra_prospectus.pdf";
        }else if (productName.equalsIgnoreCase(UNI_CRITI_CARE_HEALTH_POLICY)){
            fileName = "health/unicriticare/unicriticare_prospectus.pdf";
            cacheFileName = "unicriticare_prospectus.pdf";
        }
        try {
            File cacheFile = new File(context.getCacheDir(), cacheFileName);
            AssetManager a = context.getAssets();
            InputStream inputStream = context.getAssets().open(fileName);
            FileOutputStream outputStream = new FileOutputStream(cacheFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.close();
            inputStream.close();

            Uri uri = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", cacheFile);
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("application/pdf");
            shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
            shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            context.startActivity(Intent.createChooser(shareIntent, "Share Prospectus"));
        } catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
