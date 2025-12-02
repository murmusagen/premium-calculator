package com.example.premiumcalculator;

import static com.example.premiumcalculator.CommonFunctions.loadJSONFromAsset;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    LinearLayout appUpdateLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button healthButton = findViewById(R.id.healthButton);
        Button motorButton = findViewById(R.id.motorButton);
        TextView appVersion = findViewById(R.id.appVersion);
        Button checkForUpdates = findViewById(R.id.checkForUpdates);

        appVersion.setText(CommonFunctions.APP_VERSION);

        checkForUpdates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        checkAppUpdate();
                    }
                }).start();
            }
        });

        healthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HealthProductList.class);
                startActivity(intent);
            }
        });

        motorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MotorProductList.class);
                startActivity(intent);
            }
        });
    }

    private void checkAppUpdate() {
        try {
            String result = NetworkUtils.connectToWebsite(NetworkUtils.APP_VERSION_URL);
            if (result == null) {
                showUpdateDialog();
            } else {
                showNoNewUpdateDialog();
            }
        } catch (Exception e) {
            showNoInternetDialog();
        }
    }

    private void showNoInternetDialog() {
        runOnUiThread(new Runnable() {
            public void run() {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("No Internet")
                        .setMessage("Unable to connect to internet")
                        .setPositiveButton("Skip", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setCancelable(false)
                        .show();
            }
        });
    }

    private void showNoNewUpdateDialog() {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("No Update Available")
                .setMessage("You are already using latest update")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }

    private void showUpdateDialog() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new AlertDialog.Builder(MainActivity.this)
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
                                dialogInterface.dismiss();
                            }
                        })
                        .show();
            }
        });
    }
}