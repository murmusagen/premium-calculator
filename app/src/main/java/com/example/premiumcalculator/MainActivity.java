package com.example.premiumcalculator;

import static com.example.premiumcalculator.CommonFunctions.loadJSONFromAsset;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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

    private Handler handler;
    private Runnable periodicRunnable;
    private Thread currentThread;
    private boolean isRunning;
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

        // Test For HTTP Connect
        handler = new Handler();
        periodicRunnable = new Runnable() {
            @Override
            public void run() {
                if(isRunning){
                    executeNetworkTask();
                    handler.postDelayed(periodicRunnable, 60 * 1000);
                }

            }
        };


        Button healthButton = findViewById(R.id.healthButton);
        Button motorButton = findViewById(R.id.motorButton);
        TextView appVersion = findViewById(R.id.appVersion);
        Button updateAppButton = findViewById(R.id.updateAppButton);
        appUpdateLinearLayout = findViewById(R.id.appUpdateLinearLayout);
        CommonFunctions.deleteLayout(appUpdateLinearLayout);

        appVersion.setText(CommonFunctions.APP_VERSION);

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

    private void executeNetworkTask() {
        if (currentThread != null && currentThread.isAlive()) {
            return; // Prevent multiple threads
        }
        currentThread = new Thread(new Runnable() {
            @Override
            public void run() {
                String result = NetworkUtils.connectToWebsite("https://www.programiz.com/java-programming/online-compiler1/");

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(result==null){
                            Toast.makeText(MainActivity.this, "Hello, Update Available", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Hello, Update Not Available", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
        currentThread.start();
    }

    protected void onResume() {
        super.onResume();
        startPeriodicTask();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopPeriodicTask();
    }

    private void startPeriodicTask() {
        isRunning = true;
        handler.post(periodicRunnable);
    }

    private void stopPeriodicTask() {
        isRunning = false;
        handler.removeCallbacks(periodicRunnable);
        if (currentThread != null && currentThread.isAlive()) {
            currentThread.interrupt();
        }
    }
}