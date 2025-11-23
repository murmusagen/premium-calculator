package com.example.premiumcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HealthProductList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_health_product_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button familyMedicareButton = findViewById(R.id.familyMedicareButton);
        Button individualHealthButton = findViewById(R.id.individualHealthButton);
        Button yuvaanButton = findViewById(R.id.yuvaanButton);
        Button stumpButton = findViewById(R.id.stumpButton);

        familyMedicareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthProductList.this, FamilyMedicareDataEntry.class);
                startActivity(intent);
            }
        });

        individualHealthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthProductList.this, IndividualHealthDataEntry.class);
                startActivity(intent);
            }
        });

        yuvaanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthProductList.this, YuvaanHealthDataEntry.class);
                startActivity(intent);
            }
        });

    }
}