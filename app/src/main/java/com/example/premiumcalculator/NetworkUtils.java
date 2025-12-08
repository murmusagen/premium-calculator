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

    public static void checkPostAvailability() {
        try{
            URL url = new URL(APP_VERSION_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                System.out.println("Post is available and accessible.");

                // Optional: Read content to confirm it's a valid post
                try (BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder content = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line);
                    }
                    if (content.toString().contains("update available") ||
                            content.length() > 1000) {  // Reasonable post size check
                        System.out.println("Confirmed: Valid post content found.");
                    } else {
                        System.out.println("Post exists but content appears invalid.");
                    }
                }
            } else if (responseCode == 404) {
                System.out.println("Post is not available (404 Not Found).");
            } else {
                System.out.println("Post check failed with HTTP " + responseCode + ".");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /*public static String connectToWebsite(String urlString) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Android)");
            urlConnection.setRequestProperty("Accept", "text/html");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            if (inputStream == null) {
                return null;
            }

            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder buffer = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            return buffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/



    /*private static final String TAG = "NetworkUtils";
    private static final int TIMEOUT_MS = 10000;

    *//**
     * Fetches Wordpress post title using HttpURLConnection and regex
     *//*
    public static void fetchPostTitle(Context context, String urlString, TitleCallback callback) {
        new FetchTitleTask(callback).execute(urlString);
    }

    private static class FetchTitleTask extends AsyncTask<String, Void, String> {
        private final TitleCallback callback;

        FetchTitleTask(TitleCallback callback) {
            this.callback = callback;
        }

        @Override
        protected String doInBackground(String... urls) {
            HttpURLConnection connection = null;
            try {
                URL url = new URL(urls[0]);
                connection = (HttpURLConnection) url.openConnection();

                // Standard HttpURLConnection setup [web:21]
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(TIMEOUT_MS);
                connection.setReadTimeout(TIMEOUT_MS);
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Android)");
                connection.setRequestProperty("Accept", "text/html");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    String html = readStream(connection.getInputStream());
                    return extractPostTitle(html);
                }

            } catch (Exception e) {
                Log.e(TAG, "Error fetching title", e);
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
            return "Error fetching title";
        }

        @Override
        protected void onPostExecute(String title) {
            callback.onTitleFetched(title);
        }
    }

    private static String readStream(java.io.InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        reader.close();
        return result.toString();
    }

    private static String extractPostTitle(String html) {
        // Wordpress post title patterns [web:21]
        Pattern[] patterns = {
                Pattern.compile("<h1[^>]*class=[\"']entry-title[\"'][^>]*>([^<]+)</h1>", Pattern.CASE_INSENSITIVE),
                Pattern.compile("<h1[^>]*class=[\"']post-title[\"'][^>]*>([^<]+)</h1>", Pattern.CASE_INSENSITIVE),
                Pattern.compile("<title[^>]*>([^<]+)</title>", Pattern.CASE_INSENSITIVE)
        };

        for (Pattern pattern : patterns) {
            Matcher matcher = pattern.matcher(html);
            if (matcher.find()) {
                return matcher.group(1).trim();
            }
        }
        return "Title not found";
    }

    public interface TitleCallback {
        void onTitleFetched(String title);
    }*/

}


