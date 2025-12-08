package com.example.premiumcalculator;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.regex.Pattern;

public class SplashActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button skipButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        skipButton = findViewById(R.id.skipButton);

        new Thread(new Runnable() {
            @Override
            public void run() {
                checkAppUpdate();
            }
        }).start();

        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proceedToMain();
            }
        });
    }

    private void checkAppUpdate() {
        updateProgress(10);
        if (!isInternetAvailable()) {
            showNoInternetDialog();
            return;
        }
        simulateProgress(20, 80, 200);
        try {
            int responseCode = NetworkUtils.checkPostAvailability();
            if (responseCode == 200) {
                proceedToMain();
            } else if (responseCode == 404) {
                showUpdateDialog();
            } else {
                showUpdateErrorDialog();
            }
        } catch (Exception e) {
            showNoInternetDialog();
        }
    }

    private void proceedToMain() {
        runOnUiThread(new Runnable() {
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void simulateProgress(final int start, final int end, final int delay) {
        final Handler handler = new Handler(Looper.getMainLooper());
        final int step = 10;

        for (int i = start; i <= end; i += step) {
            final int progress = i;
            handler.postDelayed(new Runnable() {
                public void run() {
                    updateProgress(progress);
                }
            }, (i - start) * delay / step);
        }
    }

    private void showNoInternetDialog() {
        runOnUiThread(new Runnable() {
            public void run() {
                updateProgress(100);
                new AlertDialog.Builder(SplashActivity.this)
                        .setTitle("No Internet")
                        .setMessage("Unable to connect to internet")
                        .setPositiveButton("Skip", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                proceedToMain();
                            }
                        })
                        .setCancelable(false)
                        .show();
            }
        });
    }

    private void showUpdateErrorDialog() {
        runOnUiThread(new Runnable() {
            public void run() {
                updateProgress(100);
                new AlertDialog.Builder(SplashActivity.this)
                        .setTitle("Update Error")
                        .setMessage("Unable to connect to server. Please try again later.")
                        .setPositiveButton("Skip", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                proceedToMain();
                            }
                        })
                        .setCancelable(false)
                        .show();
            }
        });
    }

    private void updateProgress(final int progress) {
        runOnUiThread(new Runnable() {
            public void run() {
                progressBar.setProgress(progress);
            }
        });
    }


    private boolean isInternetAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    private void showUpdateDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                updateProgress(100);
                new AlertDialog.Builder(SplashActivity.this)
                        .setTitle("Update Available")
                        .setMessage("A new Version is available. Update now?")
                        .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(NetworkUtils.URL_FOR_DOWNLOADING_NEW_APP));
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("Skip", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                proceedToMain();
                            }
                        })
                        .show();
            }
        });
    }
}