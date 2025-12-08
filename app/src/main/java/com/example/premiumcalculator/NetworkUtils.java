package com.example.premiumcalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetworkUtils {

    public static String APP_VERSION_URL = "https://premiumcalculator6.wordpress.com/2025/12/08/version-1-0/";
    public static String URL_FOR_DOWNLOADING_NEW_APP = "https://premiumcalculator6.wordpress.com/2025/12/07/update-available/";

    public static int checkPostAvailability() {
        int responseCode = 0;
        try {
            URL url = new URL(APP_VERSION_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            responseCode = connection.getResponseCode();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseCode;
    }
}


